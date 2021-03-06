/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.productions.sentence;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.syntax.Nonterminal;
import org.jesadido.poc.core.syntax.tree.JesadidoNode;
import org.jesadido.poc.core.syntax.productions.ProductionLeaf;
import org.jesadido.poc.core.syntax.tokens.Token;
import org.jesadido.poc.core.syntax.tokens.TokenStream;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public class PartDomProduction extends ProductionLeaf {
    
    private List<TokenType> firsts = null;
    
    public PartDomProduction() {
        super(
                Nonterminal.PART_DOM,
                Arrays.asList(TokenType.PART_DOM, TokenType.OPEN, TokenType.CLOSE),
                Arrays.asList(Nonterminal.VERBAL_SELECTION)
        );
    }
    
    @Override
    public List<String> getRules() {
        return Arrays.asList(
                String.format("%s ::= %s %s %s %s", this.getNonterminalSymbol(), TokenType.PART_DOM, TokenType.OPEN, Nonterminal.VERBAL_SELECTION, TokenType.CLOSE),
                String.format("%s ::= %s? %s", this.getNonterminalSymbol(), TokenType.PART_DOM, Nonterminal.VERBAL_SELECTION)
        );
    }
    
    @Override
    public List<TokenType> getFirsts() {
        if (this.firsts == null) {
            this.firsts = new LinkedList<>();
            this.firsts.add(TokenType.PART_DOM);
            this.firsts.addAll(this.getFirsts(Nonterminal.VERBAL_SELECTION));
        }
        return this.firsts;
    }
    
    @Override
    public JesadidoNode parse(final TokenStream tokenStream) {
        if (tokenStream.hasOneOf(TokenType.PART_DOM)) {
            final Token preposition = tokenStream.next();
            if (tokenStream.hasOneOf(TokenType.OPEN)) {
                final Token opener = tokenStream.next();
                final JesadidoNode verbalSelection = this.parseVerbalSelection(tokenStream);
                if (tokenStream.hasOneOf(TokenType.CLOSE)) {
                    final Token closer = tokenStream.next();
                    return this.getGrammar().getSyntaxTreeFactory().createPartDom(preposition, opener, verbalSelection, closer);
                }
                return this.parsingTrouble(tokenStream, TokenType.CLOSE);
            } else {
                final JesadidoNode verbalSelection = this.parseVerbalSelection(tokenStream);
                return this.getGrammar().getSyntaxTreeFactory().createPartDom(preposition, this.createToken(TokenType.OPEN), verbalSelection, this.createToken(TokenType.CLOSE));
            }
        } else {
            final JesadidoNode verbalSelection = this.parseVerbalSelection(tokenStream);
            return this.getGrammar().getSyntaxTreeFactory().createPartDom(this.createToken(TokenType.PART_DOM), this.createToken(TokenType.OPEN), verbalSelection, this.createToken(TokenType.CLOSE));
        }
    }
    
    private JesadidoNode parseVerbalSelection(final TokenStream tokenStream) {
        if (this.hasFirstOf(tokenStream, Nonterminal.VERBAL_SELECTION)) {
            return this.parse(tokenStream, Nonterminal.VERBAL_SELECTION);
        }
        return this.parsingTrouble(tokenStream);
    }
}

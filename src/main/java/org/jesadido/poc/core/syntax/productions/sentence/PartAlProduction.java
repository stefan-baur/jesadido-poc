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
import org.jesadido.poc.core.syntax.tree.Node;
import org.jesadido.poc.core.syntax.productions.ProductionLeaf;
import org.jesadido.poc.core.syntax.tokens.Token;
import org.jesadido.poc.core.syntax.tokens.TokenStream;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public class PartAlProduction extends ProductionLeaf {
    
    private List<TokenType> firsts = null;
    
    public PartAlProduction() {
        super(
                Nonterminal.PART_AL,
                Arrays.asList(TokenType.PART_AL, TokenType.OPEN, TokenType.CLOSE),
                Arrays.asList(Nonterminal.NOMINAL_SELECTION)
        );
    }
    
    @Override
    public List<String> getRules() {
        return Arrays.asList(
                String.format("%s ::= %s %s %s %s", this.getNonterminalSymbol(), TokenType.PART_AL, TokenType.OPEN, Nonterminal.NOMINAL_SELECTION, TokenType.CLOSE),
                String.format("%s ::= %s %s", this.getNonterminalSymbol(), TokenType.PART_AL, Nonterminal.NOMINAL_SELECTION)
        );
    }
    
    @Override
    public List<TokenType> getFirsts() {
        if (this.firsts == null) {
            this.firsts = new LinkedList<>();
            this.firsts.add(TokenType.PART_AL);
        }
        return this.firsts;
    }
    
    @Override
    public Node parse(final TokenStream tokenStream) {
        if (tokenStream.hasOneOf(TokenType.PART_AL)) {
            final Token preposition = tokenStream.next();
            return this.parsePrefixless(tokenStream, preposition);
        }
        return this.parsingTrouble(tokenStream, TokenType.PART_AL);
    }
    
    private Node parsePrefixless(final TokenStream tokenStream, final Token preposition) {
        if (tokenStream.hasOneOf(TokenType.OPEN)) {
            final Token opener = tokenStream.next();
            if (this.hasFirstOf(tokenStream, Nonterminal.NOMINAL_SELECTION)) {
                final Node nominalSelection = this.parse(tokenStream, Nonterminal.NOMINAL_SELECTION);
                if (tokenStream.hasOneOf(TokenType.CLOSE)) {
                    final Token closer = tokenStream.next();
                    return this.getGrammar().getSyntaxTreeFactory().createPartAl(preposition, opener, nominalSelection, closer);
                }
            }
            return this.parsingTrouble(tokenStream, TokenType.CLOSE);
        } else if (this.hasFirstOf(tokenStream, Nonterminal.NOMINAL_SELECTION)) {
            final Node nominalSelection = this.parse(tokenStream, Nonterminal.NOMINAL_SELECTION);
            return this.getGrammar().getSyntaxTreeFactory().createPartSu(preposition, null, nominalSelection, null);
        }
        return this.parsingTrouble(tokenStream);
    }
}

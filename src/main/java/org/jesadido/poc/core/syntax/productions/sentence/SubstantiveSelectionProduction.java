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

public class SubstantiveSelectionProduction extends ProductionLeaf {
    
    private List<TokenType> firsts = null;
    
    public SubstantiveSelectionProduction() {
        super(Nonterminal.SUBSTANTIVE_SELECTION,
                Arrays.asList(TokenType.SUBSTANTIVE_SINGULAR),
                Arrays.asList(Nonterminal.ADJECTIVE_SELECTION)
        );
    }
    
    @Override
    public List<String> getRules() {
        return Arrays.asList(
                String.format("%s ::= %s %s*", this.getNonterminalSymbol(), TokenType.SUBSTANTIVE_SINGULAR, Nonterminal.ADJECTIVE_SELECTION)
        );
    }
    
    @Override
    public List<TokenType> getFirsts() {
        if (this.firsts == null) {
            this.firsts = new LinkedList<>();
            this.firsts.add(TokenType.SUBSTANTIVE_SINGULAR);
        }
        return this.firsts;
    }
    
    @Override
    public JesadidoNode parse(final TokenStream tokenStream) {
        if (tokenStream.hasOneOf(TokenType.SUBSTANTIVE_SINGULAR)) {
            final Token substantive = tokenStream.next();
            final List<JesadidoNode> adjectiveSelections = new LinkedList<>();
            while (this.hasFirstOf(tokenStream, Nonterminal.ADJECTIVE_SELECTION)) {
                adjectiveSelections.add(this.parse(tokenStream, Nonterminal.ADJECTIVE_SELECTION));
            }
            return this.getGrammar().getSyntaxTreeFactory().createSubstantiveSelection(substantive, adjectiveSelections);
        }
        return this.parsingTrouble(tokenStream);
    }
}

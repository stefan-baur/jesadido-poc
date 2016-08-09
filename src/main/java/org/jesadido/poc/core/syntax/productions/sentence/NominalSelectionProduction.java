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
import org.jesadido.poc.core.syntax.tokens.TokenStream;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public class NominalSelectionProduction extends ProductionLeaf {
    
    private List<TokenType> firsts = null;
    
    public NominalSelectionProduction() {
        super(
                Nonterminal.NOMINAL_SELECTION,
                new LinkedList<>(),
                Arrays.asList(Nonterminal.SUBSTANTIVE_SELECTION)
        );
    }
    
    @Override
    public List<String> getRules() {
        return Arrays.asList(
                String.format("%s ::= %s", this.getNonterminalSymbol(), Nonterminal.SUBSTANTIVE_SELECTION)
        );
    }
    
    @Override
    public List<TokenType> getFirsts() {
        if (this.firsts == null) {
            this.firsts = new LinkedList<>();
            this.firsts.addAll(this.getFirsts(Nonterminal.SUBSTANTIVE_SELECTION));
        }
        return this.firsts;
    }
    
    @Override
    public Node parse(final TokenStream tokenStream) {
        if (this.hasFirstOf(tokenStream, Nonterminal.SUBSTANTIVE_SELECTION)) {
            final Node phrase = this.parse(tokenStream, Nonterminal.SUBSTANTIVE_SELECTION);
            return this.getGrammar().getSyntaxTreeFactory().createNominalSelection(phrase);
        }
        return this.parsingTrouble(tokenStream);
    }
}

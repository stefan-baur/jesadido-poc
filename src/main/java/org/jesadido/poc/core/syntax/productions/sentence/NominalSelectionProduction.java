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
import org.jesadido.poc.core.syntax.Nonterminal;
import org.jesadido.poc.core.syntax.tree.JesadidoNode;
import org.jesadido.poc.core.syntax.productions.ProductionOneOf;
import org.jesadido.poc.core.syntax.tokens.TokenStream;

public class NominalSelectionProduction extends ProductionOneOf {
    
    public NominalSelectionProduction() {
        super(
                Nonterminal.NOMINAL_SELECTION,
                new LinkedList<>(),
                Arrays.asList(Nonterminal.ARTICLE_SELECTION, Nonterminal.SUBSTANTIVE_SELECTION)
        );
    }
    
    @Override
    public JesadidoNode parse(final TokenStream tokenStream) {
        if (this.hasFirstOf(tokenStream, Nonterminal.ARTICLE_SELECTION)) {
            final JesadidoNode articleSelection = this.parse(tokenStream, Nonterminal.ARTICLE_SELECTION);
            return this.getGrammar().getSyntaxTreeFactory().createNominalSelection(articleSelection);
        } else if (this.hasFirstOf(tokenStream, Nonterminal.SUBSTANTIVE_SELECTION)) {
            final JesadidoNode substantiveSelection = this.parse(tokenStream, Nonterminal.SUBSTANTIVE_SELECTION);
            return this.getGrammar().getSyntaxTreeFactory().createNominalSelection(substantiveSelection);
        }
        return this.parsingTrouble(tokenStream);
    }
}

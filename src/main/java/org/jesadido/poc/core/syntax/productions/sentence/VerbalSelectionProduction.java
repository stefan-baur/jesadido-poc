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

public class VerbalSelectionProduction extends ProductionOneOf {
    
    public VerbalSelectionProduction() {
        super(
                Nonterminal.VERBAL_SELECTION,
                new LinkedList<>(),
                Arrays.asList(Nonterminal.VERB_SELECTION)
        );
    }
    
    @Override
    public JesadidoNode parse(final TokenStream tokenStream) {
        if (this.hasFirstOf(tokenStream, Nonterminal.VERB_SELECTION)) {
            final JesadidoNode verbSelection = this.parse(tokenStream, Nonterminal.VERB_SELECTION);
            return this.getGrammar().getSyntaxTreeFactory().createVerbalSelection(verbSelection);
        }
        return this.parsingTrouble(tokenStream);
    }
}

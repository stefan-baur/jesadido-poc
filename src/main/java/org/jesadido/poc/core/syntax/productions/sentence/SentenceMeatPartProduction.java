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
import org.jesadido.poc.core.syntax.tree.Node;
import org.jesadido.poc.core.syntax.productions.ProductionOneOf;
import org.jesadido.poc.core.syntax.tokens.TokenStream;

public class SentenceMeatPartProduction extends ProductionOneOf {
    
    public SentenceMeatPartProduction() {
        super(
                Nonterminal.SENTENCE_MEAT_PART,
                new LinkedList<>(),
                Arrays.asList(Nonterminal.PART_SU, Nonterminal.PART_DOM, Nonterminal.PART_AL, Nonterminal.PART_FIN)
        );
    }
    
    @Override
    public Node parse(final TokenStream tokenStream) {
        if (this.hasFirstOf(tokenStream, Nonterminal.PART_SU)) {
            return this.parse(tokenStream, Nonterminal.PART_SU);
        } else if (this.hasFirstOf(tokenStream, Nonterminal.PART_DOM)) {
            return this.parse(tokenStream, Nonterminal.PART_DOM);
        } else if (this.hasFirstOf(tokenStream, Nonterminal.PART_AL)) {
            return this.parse(tokenStream, Nonterminal.PART_AL);
        } else if (this.hasFirstOf(tokenStream, Nonterminal.PART_FIN)) {
            return this.parse(tokenStream, Nonterminal.PART_FIN);
        }
        return this.parsingTrouble(tokenStream);
    }
}

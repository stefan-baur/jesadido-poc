/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.base.productions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.syntax.Nonterminal;
import org.jesadido.poc.core.syntax.nodes.Node;
import org.jesadido.poc.core.syntax.productions.ProductionLeaf;
import org.jesadido.poc.core.syntax.tokens.TokenStream;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public class SentenceMeatPartProduction extends ProductionLeaf {
    
    private List<TokenType> firsts = null;
    
    public SentenceMeatPartProduction() {
        super(Nonterminal.SENTENCE_MEAT_PART,
                new LinkedList<>(),
                Arrays.asList(Nonterminal.PART_SU, Nonterminal.PART_DOM, Nonterminal.PART_FIN)
        );
    }
    
    @Override
    public List<String> getRules() {
        return Arrays.asList(String.format("%s ::= %s | %s | %s", this.getNonterminalSymbol(),
                Nonterminal.PART_SU,
                Nonterminal.PART_DOM,
                Nonterminal.PART_FIN
        ));
    }
    
    @Override
    public List<TokenType> getFirsts() {
        if (this.firsts == null) {
            this.firsts = new LinkedList<>();
            this.firsts.addAll(this.getFirsts(Nonterminal.PART_SU));
            this.firsts.addAll(this.getFirsts(Nonterminal.PART_DOM));
            this.firsts.addAll(this.getFirsts(Nonterminal.PART_FIN));
        }
        return this.firsts;
    }
    
    @Override
    public Node parse(final TokenStream tokenStream) {
        if (this.hasFirstOf(tokenStream, Nonterminal.PART_SU)) {
            return this.parse(tokenStream, Nonterminal.PART_SU);
        } else if (this.hasFirstOf(tokenStream, Nonterminal.PART_DOM)) {
            return this.parse(tokenStream, Nonterminal.PART_DOM);
        } else if (this.hasFirstOf(tokenStream, Nonterminal.PART_FIN)) {
            return this.parse(tokenStream, Nonterminal.PART_FIN);
        }
        return this.parsingTrouble(tokenStream);
    }
}

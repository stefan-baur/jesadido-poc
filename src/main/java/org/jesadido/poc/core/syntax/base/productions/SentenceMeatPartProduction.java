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
import org.jesadido.poc.core.syntax.base.Base;
import org.jesadido.poc.core.syntax.nodes.Node;
import org.jesadido.poc.core.syntax.productions.ProductionLeaf;
import org.jesadido.poc.core.syntax.tokens.TokenStream;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public class SentenceMeatPartProduction extends ProductionLeaf {
    
    private List<TokenType> firstSet = null;
    
    public SentenceMeatPartProduction() {
        super(
                Base.NT_SENTENCE_MEAT_PART,
                new LinkedList<>(),
                Arrays.asList(Base.NT_SENTENCE_MEAT_PART_SU)
        );
    }
    
    @Override
    public List<String> getRules() {
        return Arrays.asList(String.format("%s ::= %s", this.getNonterminalSymbol(),
                Base.NT_SENTENCE_MEAT_PART_SU
        ));
    }
    
    @Override
    public List<TokenType> getFirstSet() {
        if (this.firstSet == null) {
            this.firstSet = new LinkedList<>();
            this.firstSet.addAll(this.getFirsts(Base.NT_SENTENCE_MEAT_PART_SU));
        }
        return this.firstSet;
    }
    
    @Override
    public Node parse(final TokenStream tokenStream) {
        if (this.hasFirstOf(tokenStream, Base.NT_SENTENCE_MEAT_PART_SU)) {
            return this.parse(tokenStream, Base.NT_SENTENCE_MEAT_PART_SU);
        }
        return this.parsingTrouble(tokenStream);
    }
}

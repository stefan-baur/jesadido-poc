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
import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.syntax.base.Base;
import org.jesadido.poc.core.syntax.nodes.Node;
import org.jesadido.poc.core.syntax.productions.ProductionLeaf;
import org.jesadido.poc.core.syntax.tokens.Token;
import org.jesadido.poc.core.syntax.tokens.TokenStream;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public class PartSuProduction extends ProductionLeaf {
    
    private List<TokenType> firsts = null;
    
    public PartSuProduction() {
        super(Base.NT_PART_SU,
                Arrays.asList(TokenType.SU, TokenType.OPEN, TokenType.CLOSE),
                new LinkedList<>()
        );
    }
    
    @Override
    public List<String> getRules() {
        return Arrays.asList(String.format("%s ::= %s? %s %s", this.getNonterminalSymbol(),
                TokenType.SU,
                TokenType.OPEN,
                TokenType.CLOSE
        ));
    }
    
    @Override
    public List<TokenType> getFirsts() {
        if (this.firsts == null) {
            this.firsts = new LinkedList<>();
            this.firsts.add(TokenType.SU);
            this.firsts.add(TokenType.OPEN);
        }
        return this.firsts;
    }
    
    @Override
    public Node parse(final TokenStream tokenStream) {
        if (tokenStream.hasOneOf(TokenType.SU)) {
            final Token preposition = tokenStream.next();
            return this.parseOpenClose(tokenStream, preposition.getConcept());
        }
        return this.parseOpenClose(tokenStream, null);
    }
    
    private Node parseOpenClose(final TokenStream tokenStream, final Concept prepositionConcept) {
        if (tokenStream.hasOneOf(TokenType.OPEN)) {
            final Token opener = tokenStream.next();
            if (tokenStream.hasOneOf(TokenType.CLOSE)) {
                final Token closer = tokenStream.next();
                return this.getGrammar().getSyntaxTreeFactory().createPartSu(prepositionConcept, opener.getConcept(), null, closer.getConcept());
            }
            return this.parsingTrouble(tokenStream, TokenType.CLOSE);
        }
        return this.parsingTrouble(tokenStream, TokenType.OPEN);
    }
}
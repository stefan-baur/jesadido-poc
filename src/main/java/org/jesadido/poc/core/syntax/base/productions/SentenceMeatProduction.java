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
import org.jesadido.poc.core.syntax.tokens.Token;
import org.jesadido.poc.core.syntax.tokens.TokenStream;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public class SentenceMeatProduction extends ProductionLeaf {
    
    private List<TokenType> firstSet = null;
    
    public SentenceMeatProduction() {
        super(Base.NT_SENTENCE_MEAT, Arrays.asList(
                TokenType.SET_OPEN,
                TokenType.SET_CLOSE
        ), Arrays.asList(
                Base.NT_SENTENCE_MEAT_PREFIX
        ));
    }
    
    @Override
    public List<String> getRules() {
        return Arrays.asList(String.format("%s ::= (%s)? %s %s", this.getNonterminalSymbol(),
                Base.NT_SENTENCE_MEAT_PREFIX,
                TokenType.SET_OPEN,
                TokenType.SET_CLOSE
        ));
    }
    
    @Override
    public List<TokenType> getFirstSet() {
        if (this.firstSet == null) {
            this.firstSet = new LinkedList<>();
            this.firstSet.add(TokenType.SET_OPEN);
            this.firstSet.addAll(this.getProduction(Base.NT_SENTENCE_MEAT_PREFIX).getFirstSet());
        }
        return this.firstSet;
    }
    
    @Override
    public Node parse(final TokenStream tokenStream) {
        Node meatPrefix = null;
        if (this.hasFirstOf(tokenStream, Base.NT_SENTENCE_MEAT_PREFIX)) {
            meatPrefix = this.getProduction(Base.NT_SENTENCE_MEAT_PREFIX).parse(tokenStream);
        }
        if (tokenStream.hasOneOf(TokenType.SET_OPEN)) {
            final Token opener = tokenStream.next();
            if (tokenStream.hasOneOf(TokenType.SET_CLOSE)) {
                final Token closer = tokenStream.next();
                return this.getGrammar().getSyntaxTreeFactory().createSentenceMeat(opener.getConcept(), meatPrefix, null, closer.getConcept());
            }
            return this.parsingTrouble(tokenStream, TokenType.SET_CLOSE);
        }
        return this.parsingTrouble(tokenStream, TokenType.SET_OPEN);
    }
}

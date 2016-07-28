/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.base.productions.leaves;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.syntax.ProductionLeaf;
import org.jesadido.poc.core.syntax.base.Base;
import org.jesadido.poc.core.syntax.nodes.Node;
import org.jesadido.poc.core.syntax.tokens.Token;
import org.jesadido.poc.core.syntax.tokens.TokenStream;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public class SentenceInfixConjunctionProduction extends ProductionLeaf {
    
    public SentenceInfixConjunctionProduction() {
        super(Base.NT_SENTENCE, Arrays.asList(TokenType.TERMINATOR), Arrays.asList(Base.NT_SENTENCE_MEAT));
    }
    
    @Override
    public List<String> getBnfs() {
        return Arrays.asList(String.format("%s ::= %s (%s? %s)* %s",
                this.getNonterminalSymbol(),
                Base.NT_SENTENCE_MEAT,
                Base.NT_SENTENCE_MEAT_INFIX_CONJUNCTION,
                Base.NT_SENTENCE_MEAT,
                TokenType.TERMINATOR));
    }
    
    @Override
    public List<TokenType> getFirstSet() {
        return this.getProduction(Base.NT_SENTENCE_MEAT).getFirstSet();
    }
    
    @Override
    public Node parse(final TokenStream tokenStream) {
        if (this.hasFirstOf(tokenStream, Base.NT_SENTENCE_MEAT)) {
            final List<Node> meats = new LinkedList<>();
            meats.add(this.parse(tokenStream, Base.NT_SENTENCE_MEAT));
            while (this.hasFirstOf(tokenStream, Base.NT_SENTENCE_MEAT_INFIX_CONJUNCTION, Base.NT_SENTENCE_MEAT)) {
                if (this.hasFirstOf(tokenStream, Base.NT_SENTENCE_MEAT_INFIX_CONJUNCTION)) {
                    meats.add(this.parse(tokenStream, Base.NT_SENTENCE_MEAT_INFIX_CONJUNCTION));
                }
                meats.add(this.parse(tokenStream, Base.NT_SENTENCE_MEAT));
            }
            if (tokenStream.hasOneOf(TokenType.TERMINATOR)) {
                final Token terminator = tokenStream.next();
                return this.getGrammar().getSyntaxTreeFactory().createSentence(meats, terminator.getConcept());
            } else {
                return this.parsingTrouble(tokenStream, TokenType.TERMINATOR);
            }
        }
        return this.parsingTrouble(tokenStream);
    }
}

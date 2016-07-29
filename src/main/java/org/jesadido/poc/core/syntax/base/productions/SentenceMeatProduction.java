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
        super(
                Base.NT_SENTENCE_MEAT,
                Arrays.asList(TokenType.OPEN_SET, TokenType.CLOSE_SET),
                Arrays.asList(Base.NT_SENTENCE_MEAT_PREFIX, Base.NT_SENTENCE_MEAT_PART)
        );
    }
    
    @Override
    public List<String> getRules() {
        return Arrays.asList(String.format("%s ::= (%s)? %s (%s)+ %s", this.getNonterminalSymbol(),
                Base.NT_SENTENCE_MEAT_PREFIX,
                TokenType.OPEN_SET,
                Base.NT_SENTENCE_MEAT_PART,
                TokenType.CLOSE_SET
        ));
    }
    
    @Override
    public List<TokenType> getFirstSet() {
        if (this.firstSet == null) {
            this.firstSet = new LinkedList<>();
            this.firstSet.add(TokenType.OPEN_SET);
            this.firstSet.addAll(this.getFirsts(Base.NT_SENTENCE_MEAT_PREFIX));
        }
        return this.firstSet;
    }
    
    @Override
    public Node parse(final TokenStream tokenStream) {
        Node meatPrefix = null;
        if (this.hasFirstOf(tokenStream, Base.NT_SENTENCE_MEAT_PREFIX)) {
            meatPrefix = this.parse(tokenStream, Base.NT_SENTENCE_MEAT_PREFIX);
        }
        if (tokenStream.hasOneOf(TokenType.OPEN_SET)) {
            final Token opener = tokenStream.next();
            final List<Node> parts = new LinkedList<>();
            if (this.hasFirstOf(tokenStream, Base.NT_SENTENCE_MEAT_PART)) {
                parts.add(this.parse(tokenStream, Base.NT_SENTENCE_MEAT_PART));
                while (this.hasFirstOf(tokenStream, Base.NT_SENTENCE_MEAT_PART)) {
                    parts.add(this.parse(tokenStream, Base.NT_SENTENCE_MEAT_PART));
                }
                if (tokenStream.hasOneOf(TokenType.CLOSE_SET)) {
                    final Token closer = tokenStream.next();
                    return this.getGrammar().getSyntaxTreeFactory().createSentenceMeat(meatPrefix, opener.getConcept(), parts, closer.getConcept());
                }
                return this.parsingTrouble(tokenStream, TokenType.CLOSE_SET);
            }
            return this.parsingTrouble(tokenStream);
        }
        return this.parsingTrouble(tokenStream, TokenType.OPEN_SET);
    }
}

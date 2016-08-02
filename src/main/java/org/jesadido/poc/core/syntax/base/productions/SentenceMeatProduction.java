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
    
    private List<TokenType> firsts = null;
    
    public SentenceMeatProduction() {
        super(
                Base.NT_SENTENCE_MEAT,
                Arrays.asList(TokenType.OPEN_SET, TokenType.CLOSE_SET),
                Arrays.asList(Base.NT_SENTENCE_MEAT_CONJUNCTION, Base.NT_SENTENCE_MEAT_PART)
        );
    }
    
    @Override
    public List<String> getRules() {
        return Arrays.asList(String.format("%s ::= (%s)? ((%s (%s)+ %s) | (%s)+)", this.getNonterminalSymbol(),
                Base.NT_SENTENCE_MEAT_CONJUNCTION,
                TokenType.OPEN_SET,
                Base.NT_SENTENCE_MEAT_PART,
                TokenType.CLOSE_SET,
                Base.NT_SENTENCE_MEAT_PART
        ));
    }
    
    @Override
    public List<TokenType> getFirsts() {
        if (this.firsts == null) {
            this.firsts = new LinkedList<>();
            this.firsts.add(TokenType.OPEN_SET);
            this.firsts.addAll(this.getFirsts(Base.NT_SENTENCE_MEAT_CONJUNCTION));
            this.firsts.addAll(this.getFirsts(Base.NT_SENTENCE_MEAT_PART));
        }
        return this.firsts;
    }
    
    @Override
    public Node parse(final TokenStream tokenStream) {
        Node meatConjunction = null;
        if (this.hasFirstOf(tokenStream, Base.NT_SENTENCE_MEAT_CONJUNCTION)) {
            meatConjunction = this.parse(tokenStream, Base.NT_SENTENCE_MEAT_CONJUNCTION);
        }
        if (tokenStream.hasOneOf(TokenType.OPEN_SET)) {
            final Token opener = tokenStream.next();
            final List<Node> parts = this.parseParts(tokenStream);
            if (tokenStream.hasOneOf(TokenType.CLOSE_SET)) {
                final Token closer = tokenStream.next();
                return this.getGrammar().getSyntaxTreeFactory().createSentenceMeat(meatConjunction, opener.getConcept(), parts, closer.getConcept());
            }
            return this.parsingTrouble(tokenStream, TokenType.CLOSE_SET);
        } else {
            final List<Node> parts = this.parseParts(tokenStream);
            return this.getGrammar().getSyntaxTreeFactory().createSentenceMeat(meatConjunction, null, parts, null);
        }
    }
    
    private List<Node> parseParts(final TokenStream tokenStream) {
        final List<Node> result = new LinkedList<>();
        if (this.hasFirstOf(tokenStream, Base.NT_SENTENCE_MEAT_PART)) {
            result.add(this.parse(tokenStream, Base.NT_SENTENCE_MEAT_PART));
            while (this.hasFirstOf(tokenStream, Base.NT_SENTENCE_MEAT_PART)) {
                result.add(this.parse(tokenStream, Base.NT_SENTENCE_MEAT_PART));
            }
        }
        result.add(this.parsingTrouble(tokenStream));
        return result;
    }
}

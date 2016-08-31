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
import java.util.List;
import org.jesadido.poc.core.syntax.Nonterminal;
import org.jesadido.poc.core.syntax.tree.Node;
import org.jesadido.poc.core.syntax.productions.ProductionLeaf;
import org.jesadido.poc.core.syntax.tokens.Token;
import org.jesadido.poc.core.syntax.tokens.TokenStream;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public class SentenceMeatProduction extends ProductionLeaf {
    
    private List<TokenType> firsts = null;
    
    public SentenceMeatProduction() {
        super(
                Nonterminal.SENTENCE_MEAT,
                Arrays.asList(TokenType.OPEN_SET, TokenType.CLOSE_SET),
                Arrays.asList(Nonterminal.SENTENCE_MEAT_CONJUNCTION, Nonterminal.SENTENCE_MEAT_PART)
        );
    }
    
    @Override
    public List<String> getRules() {
        return Arrays.asList(
                String.format("%s ::= %s? %s %s+ %s", this.getNonterminalSymbol(), Nonterminal.SENTENCE_MEAT_CONJUNCTION, TokenType.OPEN_SET, Nonterminal.SENTENCE_MEAT_PART, TokenType.CLOSE_SET),
                String.format("%s ::= %s? %s+", this.getNonterminalSymbol(), Nonterminal.SENTENCE_MEAT_CONJUNCTION, Nonterminal.SENTENCE_MEAT_PART)
        );
    }
    
    @Override
    public List<TokenType> getFirsts() {
        if (this.firsts == null) {
            this.firsts = new LinkedList<>();
            this.firsts.add(TokenType.OPEN_SET);
            this.firsts.addAll(this.getFirsts(Nonterminal.SENTENCE_MEAT_CONJUNCTION));
            this.firsts.addAll(this.getFirsts(Nonterminal.SENTENCE_MEAT_PART));
        }
        return this.firsts;
    }
    
    @Override
    public Node parse(final TokenStream tokenStream) {
        Node meatConjunction = null;
        if (this.hasFirstOf(tokenStream, Nonterminal.SENTENCE_MEAT_CONJUNCTION)) {
            meatConjunction = this.parse(tokenStream, Nonterminal.SENTENCE_MEAT_CONJUNCTION);
        }
        if (tokenStream.hasOneOf(TokenType.OPEN_SET)) {
            final Token opener = tokenStream.next();
            final List<Node> parts = this.parseParts(tokenStream);
            if (tokenStream.hasOneOf(TokenType.CLOSE_SET)) {
                final Token closer = tokenStream.next();
                return this.getGrammar().getSyntaxTreeFactory().createSentenceMeat(meatConjunction, opener, parts, closer);
            }
            return this.parsingTrouble(tokenStream, TokenType.CLOSE_SET);
        } else {
            final List<Node> parts = this.parseParts(tokenStream);
            return this.getGrammar().getSyntaxTreeFactory().createSentenceMeat(meatConjunction, this.createToken(TokenType.OPEN_SET), parts, this.createToken(TokenType.CLOSE_SET));
        }
    }
    
    private List<Node> parseParts(final TokenStream tokenStream) {
        final List<Node> result = new LinkedList<>();
        if (this.hasFirstOf(tokenStream, Nonterminal.SENTENCE_MEAT_PART)) {
            result.add(this.parse(tokenStream, Nonterminal.SENTENCE_MEAT_PART));
            while (this.hasFirstOf(tokenStream, Nonterminal.SENTENCE_MEAT_PART)) {
                result.add(this.parse(tokenStream, Nonterminal.SENTENCE_MEAT_PART));
            }
        } else {
            result.add(this.parsingTrouble(tokenStream));
        }
        return result;
    }
}

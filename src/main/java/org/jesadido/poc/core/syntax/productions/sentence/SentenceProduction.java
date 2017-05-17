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
import org.jesadido.poc.core.syntax.tree.JesadidoNode;
import org.jesadido.poc.core.syntax.productions.ProductionLeaf;
import org.jesadido.poc.core.syntax.tokens.Token;
import org.jesadido.poc.core.syntax.tokens.TokenStream;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public class SentenceProduction extends ProductionLeaf {
    
    public SentenceProduction() {
        super(
                Nonterminal.SENTENCE,
                Arrays.asList(TokenType.TERMINATOR),
                Arrays.asList(Nonterminal.SENTENCE_MEAT)
        );
    }
    
    @Override
    public List<String> getRules() {
        return Arrays.asList(
                String.format("%s ::= %s+ %s", this.getNonterminalSymbol(), Nonterminal.SENTENCE_MEAT, TokenType.TERMINATOR)
        );
    }
    
    @Override
    public List<TokenType> getFirsts() {
        return this.getFirsts(Nonterminal.SENTENCE_MEAT);
    }
    
    @Override
    public JesadidoNode parse(final TokenStream tokenStream) {
        if (this.hasFirstOf(tokenStream, Nonterminal.SENTENCE_MEAT)) {
            final List<JesadidoNode> meats = new LinkedList<>();
            meats.add(this.parse(tokenStream, Nonterminal.SENTENCE_MEAT));
            while (this.hasFirstOf(tokenStream, Nonterminal.SENTENCE_MEAT)) {
                meats.add(this.parse(tokenStream, Nonterminal.SENTENCE_MEAT));
            }
            if (tokenStream.hasOneOf(TokenType.TERMINATOR)) {
                final Token terminator = tokenStream.next();
                return this.getGrammar().getSyntaxTreeFactory().createSentence(meats, terminator);
            } else {
                return this.parsingTrouble(tokenStream, TokenType.TERMINATOR);
            }
        }
        return this.parsingTrouble(tokenStream);
    }
}

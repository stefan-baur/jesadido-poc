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
import org.jesadido.poc.core.syntax.tokens.TokenStream;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public class SentenceSequenceProduction extends ProductionLeaf {
    
    public SentenceSequenceProduction() {
        super(
                Nonterminal.SENTENCE_SEQUENCE,
                new LinkedList<>(),
                Arrays.asList(Nonterminal.SENTENCE)
        );
    }
    
    @Override
    public List<String> getRules() {
        return Arrays.asList(
                String.format("%s ::= %s+", this.getNonterminalSymbol(), Nonterminal.SENTENCE)
        );
    }
    
    @Override
    public List<TokenType> getFirsts() {
        return this.getFirsts(Nonterminal.SENTENCE);
    }
    
    @Override
    public JesadidoNode parse(final TokenStream tokenStream) {
        if (this.hasFirstOf(tokenStream, Nonterminal.SENTENCE)) {
            final List<JesadidoNode> sentences = new LinkedList<>();
            sentences.add(this.parse(tokenStream, Nonterminal.SENTENCE));
            while (this.hasFirstOf(tokenStream, Nonterminal.SENTENCE)) {
                sentences.add(this.parse(tokenStream, Nonterminal.SENTENCE));
            }
            return this.getGrammar().getSyntaxTreeFactory().createSentenceSequence(sentences);
        }
        return this.parsingTrouble(tokenStream);
    }
}

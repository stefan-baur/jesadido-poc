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
import org.jesadido.poc.core.syntax.Production;
import org.jesadido.poc.core.syntax.base.BaseConstants;
import org.jesadido.poc.core.syntax.nodes.Node;
import org.jesadido.poc.core.syntax.tokens.Token;
import org.jesadido.poc.core.syntax.tokens.TokenStream;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public class SentenceProduction extends Production {
    
    public SentenceProduction() {
        super(BaseConstants.NT_SENTENCE, Arrays.asList(TokenType.TERMINATOR), Arrays.asList(BaseConstants.NT_SENTENCE_MEAT));
    }
    
    @Override
    public List<TokenType> getFirstSet() {
        return this.getGrammar().getProduction(BaseConstants.NT_SENTENCE_MEAT).getFirstSet();
    }
    
    @Override
    public Node parse(final TokenStream tokenStream) {
        Production sentenceMeatProduction = this.getGrammar().getProduction(BaseConstants.NT_SENTENCE_MEAT);
        if (tokenStream.hasOneOf(sentenceMeatProduction.getFirstSet())) {
            List<Node> meats = new LinkedList<>();
            meats.add(sentenceMeatProduction.parse(tokenStream));
            if (tokenStream.hasOneOf(TokenType.TERMINATOR)) {
                final Token terminator = tokenStream.next();
                return this.getGrammar().getSyntaxTreeFactory().createSentence(meats, terminator.getConcept());
            } else {
                return this.getGrammar().getSyntaxTreeFactory().createTrouble("The TERMINATOR-Token is not available.");
            }
        }
        return this.getGrammar().getSyntaxTreeFactory().createTrouble(String.format("The nonterminal '%s' can not be parsed.", BaseConstants.NT_SENTENCE_MEAT));
    }
}

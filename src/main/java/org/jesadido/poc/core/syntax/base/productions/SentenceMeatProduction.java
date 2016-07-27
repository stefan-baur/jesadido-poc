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

public class SentenceMeatProduction extends Production {
    
    public SentenceMeatProduction() {
        super(BaseConstants.NT_SENTENCE_MEAT, Arrays.asList(TokenType.BRACE_OPEN, TokenType.BRACE_CLOSE), new LinkedList<>());
    }
    
    @Override
    public List<TokenType> getFirstSet() {
        return Arrays.asList(TokenType.BRACE_OPEN);
    }
    
    @Override
    public Node parse(final TokenStream tokenStream) {
        if (tokenStream.hasOneOf(TokenType.BRACE_OPEN)) {
            final Token opener = tokenStream.next();
            if (tokenStream.hasOneOf(TokenType.BRACE_CLOSE)) {
                final Token closer = tokenStream.next();
                return this.getGrammar().getSyntaxTreeFactory().createSentenceMeat(opener.getConcept(), null, closer.getConcept());
            }
            return this.getGrammar().getSyntaxTreeFactory().createTrouble("No BRACE_CLOSE");
        }
        return this.getGrammar().getSyntaxTreeFactory().createTrouble("No BRACE_OPEN");
    }
}

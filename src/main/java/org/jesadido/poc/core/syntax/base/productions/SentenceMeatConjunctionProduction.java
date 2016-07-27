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
import org.jesadido.poc.core.syntax.base.Base;
import org.jesadido.poc.core.syntax.nodes.Node;
import org.jesadido.poc.core.syntax.tokens.Token;
import org.jesadido.poc.core.syntax.tokens.TokenStream;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public class SentenceMeatConjunctionProduction extends Production {
    
    public SentenceMeatConjunctionProduction() {
        super(Base.NT_SENTENCE_MEAT_CONJUNCTION, Arrays.asList(TokenType.SEPARATOR), new LinkedList<>());
    }
    
    @Override
    public List<TokenType> getFirstSet() {
        return Arrays.asList(TokenType.SEPARATOR);
    }
    
    @Override
    public Node parse(final TokenStream tokenStream) {
        if (tokenStream.hasOneOf(TokenType.SEPARATOR)) {
            final Token separator = tokenStream.next();
            return this.getGrammar().getSyntaxTreeFactory().createSentenceMeatConjunction(separator.getConcept());
        }
        return this.getGrammar().getSyntaxTreeFactory().createTrouble("No SEPARATOR");
    }
}

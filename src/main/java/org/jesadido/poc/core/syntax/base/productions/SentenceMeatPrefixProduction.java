/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.base.productions;

import java.util.Arrays;
import org.jesadido.poc.core.syntax.base.Base;
import org.jesadido.poc.core.syntax.nodes.Node;
import org.jesadido.poc.core.syntax.productions.ProductionOneOf;
import org.jesadido.poc.core.syntax.tokens.Token;
import org.jesadido.poc.core.syntax.tokens.TokenStream;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public class SentenceMeatPrefixProduction extends ProductionOneOf {
    
    public SentenceMeatPrefixProduction() {
        super(
                Base.NT_SENTENCE_MEAT_PREFIX,
                Arrays.asList(
                        TokenType.SE,
                        TokenType.KAJ,
                        TokenType.AUX,
                        TokenType.SEPARATOR
                )
        );
    }
    
    @Override
    public Node parse(final TokenStream tokenStream) {
        if (tokenStream.hasOneOf(this.getFirstSet())) {
            final Token infix = tokenStream.next();
            return this.getGrammar().getSyntaxTreeFactory().createSentenceMeatPrefix(infix.getConcept());
        }
        return this.parsingTrouble(tokenStream);
    }
}
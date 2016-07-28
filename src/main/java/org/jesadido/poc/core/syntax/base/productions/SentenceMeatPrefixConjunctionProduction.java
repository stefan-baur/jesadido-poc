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

public class SentenceMeatPrefixConjunctionProduction extends ProductionOneOf {
    
    public SentenceMeatPrefixConjunctionProduction() {
        super(Base.NT_SENTENCE_MEAT_PREFIX_CONJUNCTION, Arrays.asList(
                TokenType.SE
        ));
    }
    
    @Override
    public Node parse(final TokenStream tokenStream) {
        if (tokenStream.hasOneOf(this.getFirstSet())) {
            final Token prefix = tokenStream.next();
            return this.getGrammar().getSyntaxTreeFactory().createSentenceMeatConjunction(prefix.getConcept());
        }
        return this.parsingTrouble(tokenStream);
    }
}

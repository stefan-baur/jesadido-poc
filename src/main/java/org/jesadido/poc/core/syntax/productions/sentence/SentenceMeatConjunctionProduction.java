/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.productions.sentence;

import java.util.Arrays;
import org.jesadido.poc.core.syntax.Nonterminal;
import org.jesadido.poc.core.syntax.tree.Node;
import org.jesadido.poc.core.syntax.productions.ProductionOneOf;
import org.jesadido.poc.core.syntax.tokens.Token;
import org.jesadido.poc.core.syntax.tokens.TokenStream;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public class SentenceMeatConjunctionProduction extends ProductionOneOf {
    
    public SentenceMeatConjunctionProduction() {
        super(
                Nonterminal.SENTENCE_MEAT_CONJUNCTION,
                Arrays.asList(TokenType.SEPARATOR_SE, TokenType.SEPARATOR_KAJ, TokenType.SEPARATOR_AUX, TokenType.SEPARATOR)
        );
    }
    
    @Override
    public Node parse(final TokenStream tokenStream) {
        if (tokenStream.hasOneOf(this.getFirsts())) {
            final Token conjunction = tokenStream.next();
            return this.getGrammar().getSyntaxTreeFactory().createSentenceMeatConjunction(conjunction);
        }
        return this.parsingTrouble(tokenStream);
    }
}

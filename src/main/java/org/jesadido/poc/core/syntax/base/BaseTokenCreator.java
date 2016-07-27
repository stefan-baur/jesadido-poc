/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.base;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.concepts.ConceptRegistry;
import org.jesadido.poc.core.concepts.ConceptTermination;
import org.jesadido.poc.core.syntax.tokens.Token;
import org.jesadido.poc.core.syntax.tokens.TokenCreator;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public final class BaseTokenCreator implements TokenCreator {
    
    private static final List<TokenType> SUPPORTED_TOKEN_TYPES = Arrays.asList(
            TokenType.UNKNOWN,
            TokenType.TERMINATOR,
            TokenType.BRACE_OPEN,
            TokenType.BRACE_CLOSE
    );

    private static final EnumMap<ConceptTermination, TokenCreator.Selector> SELECTIONS = new EnumMap<>(ConceptTermination.class);

    static {
        SELECTIONS.put(ConceptTermination.PERIOD, (TokenCreator.Selector) (Concept c) -> TokenType.TERMINATOR);
        SELECTIONS.put(ConceptTermination.L1, (TokenCreator.Selector) (Concept c) -> TokenType.BRACE_OPEN);
        SELECTIONS.put(ConceptTermination.R1, (TokenCreator.Selector) (Concept c) -> TokenType.BRACE_CLOSE);
    }

    @Override
    public final Token create(final String conceptPhrase) {
        final Concept concept = ConceptRegistry.getInstance().getConcept(conceptPhrase);
        return new Token(conceptPhrase, this.selectTokenType(concept), concept);
    }

    @Override
    public final List<TokenType> getSupportedTokenTypes() {
        return SUPPORTED_TOKEN_TYPES;
    }

    @Override
    public final TokenType selectTokenType(final Concept concept) {
        final ConceptTermination termination = concept.getProperties().getTermination();
        if (SELECTIONS.containsKey(termination)) {
            return SELECTIONS.get(termination).select(concept);
        }
        return TokenType.UNKNOWN;
    }
}

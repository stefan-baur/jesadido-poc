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
import java.util.Map;
import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.concepts.ConceptRegistry;
import org.jesadido.poc.core.concepts.ConceptTermination;
import org.jesadido.poc.core.syntax.tokens.Token;
import org.jesadido.poc.core.syntax.tokens.TokenCreator;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public final class BaseTokenCreator implements TokenCreator {
    
    private static final List<TokenType> SUPPORTED_TOKEN_TYPES = Arrays.asList(TokenType.UNKNOWN,
            
            TokenType.TERMINATOR,
            
            TokenType.SEPARATOR,
            TokenType.SEPARATOR_KAJ,
            TokenType.SEPARATOR_AUX,
            TokenType.SEPARATOR_SE,
            
            TokenType.OPEN_SET,
            TokenType.CLOSE_SET,
            TokenType.OPEN,
            TokenType.CLOSE,
            
            TokenType.PART_SU,
            TokenType.PART_DOM,
            TokenType.PART_FIN,
            
            TokenType.SUBSTANTIVE_SINGULAR,
            TokenType.VERB_PRESENT_TENSE
    );

    private static final Map<ConceptTermination, TokenCreator.Selector> SELECTIONS = new EnumMap<>(ConceptTermination.class);

    static {
        SELECTIONS.put(ConceptTermination.PERIOD, (TokenCreator.Selector) (Concept c) -> TokenType.TERMINATOR);
        
        SELECTIONS.put(ConceptTermination.COMMA, (TokenCreator.Selector) (Concept c) -> TokenType.SEPARATOR);
        SELECTIONS.put(ConceptTermination.KAJ, (TokenCreator.Selector) (Concept c) -> TokenType.SEPARATOR_KAJ);
        SELECTIONS.put(ConceptTermination.AUX, (TokenCreator.Selector) (Concept c) -> TokenType.SEPARATOR_AUX);
        SELECTIONS.put(ConceptTermination.SE, (TokenCreator.Selector) (Concept c) -> TokenType.SEPARATOR_SE);
        
        SELECTIONS.put(ConceptTermination.LEFT_CURLY, (TokenCreator.Selector) (Concept c) -> TokenType.OPEN_SET);
        SELECTIONS.put(ConceptTermination.RIGHT_CURLY, (TokenCreator.Selector) (Concept c) -> TokenType.CLOSE_SET);
        SELECTIONS.put(ConceptTermination.LEFT_PARENTHESIS, (TokenCreator.Selector) (Concept c) -> TokenType.OPEN);
        SELECTIONS.put(ConceptTermination.RIGHT_PARENTHESIS, (TokenCreator.Selector) (Concept c) -> TokenType.CLOSE);
        
        SELECTIONS.put(ConceptTermination.SU, (TokenCreator.Selector) (Concept c) -> TokenType.PART_SU);
        SELECTIONS.put(ConceptTermination.DOM, (TokenCreator.Selector) (Concept c) -> TokenType.PART_DOM);
        SELECTIONS.put(ConceptTermination.FIN, (TokenCreator.Selector) (Concept c) -> TokenType.PART_FIN);
        
        SELECTIONS.put(ConceptTermination.O, (TokenCreator.Selector) (Concept c) -> TokenType.SUBSTANTIVE_SINGULAR);
        SELECTIONS.put(ConceptTermination.AS, (TokenCreator.Selector) (Concept c) -> TokenType.VERB_PRESENT_TENSE);
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

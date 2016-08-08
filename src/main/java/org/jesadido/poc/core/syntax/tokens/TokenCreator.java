/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tokens;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.concepts.ConceptRegistry;
import org.jesadido.poc.core.concepts.ConceptTermination;

/**
 * This <code>TokenCreator</code> class is used for creating token instances for
 * the purpose of token stream with aspect-orientated selection of token types.
 */
public class TokenCreator {
    
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
            TokenType.PART_AL,
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
        SELECTIONS.put(ConceptTermination.AL, (TokenCreator.Selector) (Concept c) -> TokenType.PART_AL);
        SELECTIONS.put(ConceptTermination.FIN, (TokenCreator.Selector) (Concept c) -> TokenType.PART_FIN);
        
        SELECTIONS.put(ConceptTermination.O, (TokenCreator.Selector) (Concept c) -> TokenType.SUBSTANTIVE_SINGULAR);
        SELECTIONS.put(ConceptTermination.AS, (TokenCreator.Selector) (Concept c) -> TokenType.VERB_PRESENT_TENSE);
    }

    /**
     * Instantiates a token instance by the given concept phrase/lexeme.
     * @param conceptPhrase The given concept phrase used for the token value.
     * @return The token instance.
     */
    public Token create(final String conceptPhrase) {
        final Concept concept = ConceptRegistry.getInstance().getConcept(conceptPhrase);
        return new Token(conceptPhrase, this.selectTokenType(concept), concept);
    }

    /**
     * Returns the list of the supported token types. This method should return
     * the <code>UNKNOWN</code> token type, at least.
     * @return The supported token types.
     */
    public List<TokenType> getSupportedTokenTypes() {
        return SUPPORTED_TOKEN_TYPES;
    }

    /**
     * Returns an adequate token type by the given concept instance.
     * @param concept The given concept instance.
     * @return The adequate token type/syntactical category.
     */
    public TokenType selectTokenType(final Concept concept) {
        final ConceptTermination termination = concept.getProperties().getTermination();
        if (SELECTIONS.containsKey(termination)) {
            return SELECTIONS.get(termination).select(concept);
        }
        return TokenType.UNKNOWN;
    }
    
    /**
     * This nested <code>Selector</code> interface can be used for selecting the
     * adequate token type by a given concept instance.
     */
    @FunctionalInterface
    public interface Selector {
        
        /**
         * Returns the adequate token type by the given concept instance.
         * @param concept The given concept instance.
         * @return The adequate token type/syntactical category.
         */
        TokenType select(Concept concept);
    }
}

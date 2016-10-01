/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tokens;

import java.util.EnumMap;
import java.util.LinkedList;
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
    
    private static final Map<TokenType, String> DEFAULTS = new EnumMap<>(TokenType.class);
    private static final Map<ConceptTermination, Selector> SELECTIONS = new EnumMap<>(ConceptTermination.class);

    static {
        DEFAULTS.put(TokenType.UNKNOWN, "");
        
        DEFAULTS.put(TokenType.TERMINATOR, ConceptTermination.PERIOD.getTerminationPhrase());
        
        DEFAULTS.put(TokenType.SEPARATOR, ConceptTermination.COMMA.getTerminationPhrase());
        DEFAULTS.put(TokenType.SEPARATOR_KAJ, ConceptTermination.KAJ.getTerminationPhrase());
        DEFAULTS.put(TokenType.SEPARATOR_AUX, ConceptTermination.AUX.getTerminationPhrase());
        DEFAULTS.put(TokenType.SEPARATOR_SE, ConceptTermination.SE.getTerminationPhrase());
        
        DEFAULTS.put(TokenType.OPEN_SET, ConceptTermination.LEFT_CURLY.getTerminationPhrase());
        DEFAULTS.put(TokenType.CLOSE_SET, ConceptTermination.RIGHT_CURLY.getTerminationPhrase());
        DEFAULTS.put(TokenType.OPEN, ConceptTermination.LEFT_PARENTHESIS.getTerminationPhrase());
        DEFAULTS.put(TokenType.CLOSE, ConceptTermination.RIGHT_PARENTHESIS.getTerminationPhrase());
        
        DEFAULTS.put(TokenType.PART_SU, ConceptTermination.SU.getTerminationPhrase());
        DEFAULTS.put(TokenType.PART_DOM, ConceptTermination.DOM.getTerminationPhrase());
        DEFAULTS.put(TokenType.PART_AL, ConceptTermination.AL.getTerminationPhrase());
        DEFAULTS.put(TokenType.PART_FIN, ConceptTermination.FIN.getTerminationPhrase());
        
        DEFAULTS.put(TokenType.ARTICLE, ConceptTermination.LA.getTerminationPhrase());
        DEFAULTS.put(TokenType.SUBSTANTIVE_SINGULAR, "Test" + ConceptTermination.O.getTerminationPhrase());
        DEFAULTS.put(TokenType.ADJECTIVE_SINGULAR, "Test" + ConceptTermination.A.getTerminationPhrase());
        DEFAULTS.put(TokenType.VERB_PRESENT_TENSE, "Test" + ConceptTermination.AS.getTerminationPhrase());
        
        SELECTIONS.put(ConceptTermination.ELLIPSIS, (Selector) (Concept c) -> TokenType.TERMINATOR);
        SELECTIONS.put(ConceptTermination.PERIOD, (Selector) (Concept c) -> TokenType.TERMINATOR);
        
        SELECTIONS.put(ConceptTermination.COMMA, (Selector) (Concept c) -> TokenType.SEPARATOR);
        SELECTIONS.put(ConceptTermination.KAJ, (Selector) (Concept c) -> TokenType.SEPARATOR_KAJ);
        SELECTIONS.put(ConceptTermination.AUX, (Selector) (Concept c) -> TokenType.SEPARATOR_AUX);
        SELECTIONS.put(ConceptTermination.SE, (Selector) (Concept c) -> TokenType.SEPARATOR_SE);
        
        SELECTIONS.put(ConceptTermination.LEFT_CURLY, (Selector) (Concept c) -> TokenType.OPEN_SET);
        SELECTIONS.put(ConceptTermination.RIGHT_CURLY, (Selector) (Concept c) -> TokenType.CLOSE_SET);
        SELECTIONS.put(ConceptTermination.LEFT_PARENTHESIS, (Selector) (Concept c) -> TokenType.OPEN);
        SELECTIONS.put(ConceptTermination.RIGHT_PARENTHESIS, (Selector) (Concept c) -> TokenType.CLOSE);
        
        SELECTIONS.put(ConceptTermination.SU, (Selector) (Concept c) -> TokenType.PART_SU);
        SELECTIONS.put(ConceptTermination.DOM, (Selector) (Concept c) -> TokenType.PART_DOM);
        SELECTIONS.put(ConceptTermination.AL, (Selector) (Concept c) -> TokenType.PART_AL);
        SELECTIONS.put(ConceptTermination.FIN, (Selector) (Concept c) -> TokenType.PART_FIN);
        
        SELECTIONS.put(ConceptTermination.LA, (Selector) (Concept c) -> TokenType.ARTICLE);
        SELECTIONS.put(ConceptTermination.O, (Selector) (Concept c) -> TokenType.SUBSTANTIVE_SINGULAR);
        SELECTIONS.put(ConceptTermination.A, (Selector) (Concept c) -> TokenType.ADJECTIVE_SINGULAR);
        SELECTIONS.put(ConceptTermination.AS, (Selector) (Concept c) -> TokenType.VERB_PRESENT_TENSE);
    }

    /**
     * Instantiates a token instance by the given concept phrase/lexeme.
     * @param conceptPhrase The given concept phrase used for the token value.
     * @param positionX The x-cursor-position of the appearance of the lexeme.
     * @param positionY The y-cursor-position of the appearance of the lexeme.
     * @return The token instance.
     */
    public Token create(final String conceptPhrase, final int positionX, final int positionY) {
        final Concept concept = ConceptRegistry.getInstance().getConcept(conceptPhrase);
        return new Token(conceptPhrase, this.selectTokenType(concept), concept, positionX, positionY);
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
     * Instantiates at token instance by the given token-type which has to be
     * supported.
     * @param tokenType The token type.
     * @return The token instance.
     */
    public Token create(final TokenType tokenType) {
        if (DEFAULTS.containsKey(tokenType)) {
            return this.create(DEFAULTS.get(tokenType));
        }
        throw new IllegalArgumentException(String.format("The given token-type %s is not supported.", tokenType));
    }

    /**
     * Returns the list of the supported token types. This method should return
     * the <code>UNKNOWN</code> token type, at least.
     * @return The supported token types.
     */
    public List<TokenType> getSupportedTokenTypes() {
        return new LinkedList<>(DEFAULTS.keySet());
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

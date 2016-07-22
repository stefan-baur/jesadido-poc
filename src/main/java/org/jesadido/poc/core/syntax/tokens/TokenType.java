/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tokens;

import java.util.EnumMap;
import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.concepts.ConceptTermination;

/**
 * This <code>TokenType</code> class declares the possible syntactical
 * categories for the <b>Jesadido</b> tokens, respectively lexemes.
 */
public enum TokenType {
    
    /**
     * The appropriate token value is unknown.
     */
    UNKNOWN,
    
    /**
     * The appropriate token value differs to the phrase of the appropriate
     * concept instance.
     */
    INVALID_CONCEPT,
    
    /**
     * The appropriate token value represents a determined article, for example
     * <b>La</b> <i>(the)</i> or <b>Mi$La</b> <i>(I, me)</i>.
     */
    ARTICLE,
    
    /**
     * The appropriate token value represents a singular substantive, for
     * example <b>SunO</b> <i>(sun)</i> or <b>LunO</b> <i>(moon)</i>.
     */
    SUBSTANTIVE_SINGULAR,
    
    /**
     * The appropriate token value represents a plural substantive, for example
     * <b>StelOJ</b> <i>(stars)</i>.
     */
    SUBSTANTIVE_PLURAL,
    
    /**
     * The appropriate token value represents a singular substantive containing
     * a parameter, for example <b>'1974-01-28'DatO</b> <i>(28th of January
     * 1974)</i>.
     */
    PARAMETERED_SUBSTANTIVE_SINGULAR,
    
    /**
     * The appropriate token value represents a plural substantive containing
     * a parameter, for example <b>/en/'Millers'|'Miller'OJ</b> <i>(the proper
     * name "Millers" in plural, sometimes needed in singular)</i>.
     */
    PARAMETERED_SUBSTANTIVE_PLURAL,
    
    /**
     * The appropriate token value represents a singular adjective, for example
     * <b>SunA</b> <i>(sunny)</i>.
     */
    ADJECTIVE_SINGULAR,
    
    /**
     * The appropriate token value represents a plural adjective, for example
     * <b>SunAJ</b> <i>(sunny)</i>.
     */
    ADJECTIVE_PLURAL,
    
    /**
     * The appropriate token value represents a singular adverb, for example
     * <b>SunE</b> <i>(sunnily)</i>.
     */
    ADVERB_SINGULAR,
    
    /**
     * The appropriate token value represents a plural adverb, for example
     * <b>SunEJ</b> <i>(sunnily)</i>.
     */
    ADVERB_PLURAL,
    
    /**
     * The appropriate token value represents a singular personal pronoun, for
     * example <b>Mi</b> <i>(I, me)</i> or <b>InO$Bi</b> <i>(you, singular,
     * female)</i>.
     */
    PERSONAL_PRONOUN_SINGULAR,
    
    /**
     * The appropriate token value represents a plural personal pronoun, for
     * example <b>Ni</b> <i>(we)</i> or <b>Vi</b> <i>(you, singular)</i>.
     */
    PERSONAL_PRONOUN_PLURAL,
    
    /**
     * The appropriate token value represents a terminator symbol for
     * terminating plain text sentences, for example a single period.
     */
    TERMINATOR;
    
    /**
     * This <code>Selector</code> nested interface is used for selecting the
     * adequate token type by a given concept phrase.
     */
    @FunctionalInterface
    private interface Selector {
        
        /**
         * Returns the adequate token type by the given concept instance.
         * @param concept The given concept instance.
         * @return The adequate token type/syntactical category.
         */
        TokenType select(Concept concept);
    }
    
    private static final EnumMap<ConceptTermination, Selector> SELECTIONS = new EnumMap<>(ConceptTermination.class);
    
    static {
        SELECTIONS.put(ConceptTermination.TERMINATOR, (Selector) (Concept c) -> TERMINATOR);
        SELECTIONS.put(ConceptTermination.LA, (Selector) (Concept c) -> ARTICLE);
        SELECTIONS.put(ConceptTermination.O, (Selector) (Concept c) -> c.getProperties().hasParameter() ? PARAMETERED_SUBSTANTIVE_SINGULAR : SUBSTANTIVE_SINGULAR);
        SELECTIONS.put(ConceptTermination.O_J, (Selector) (Concept c) -> c.getProperties().hasParameter() ? PARAMETERED_SUBSTANTIVE_PLURAL : SUBSTANTIVE_PLURAL);
        SELECTIONS.put(ConceptTermination.A, (Selector) (Concept c) -> ADJECTIVE_SINGULAR);
        SELECTIONS.put(ConceptTermination.A_J, (Selector) (Concept c) -> ADJECTIVE_PLURAL);
        SELECTIONS.put(ConceptTermination.E, (Selector) (Concept c) -> ADVERB_SINGULAR);
        SELECTIONS.put(ConceptTermination.E_J, (Selector) (Concept c) -> ADVERB_PLURAL);
        SELECTIONS.put(ConceptTermination.MI, (Selector) (Concept c) -> PERSONAL_PRONOUN_SINGULAR);
        SELECTIONS.put(ConceptTermination.BI, (Selector) (Concept c) -> PERSONAL_PRONOUN_SINGULAR);
        SELECTIONS.put(ConceptTermination.GXI, (Selector) (Concept c) -> PERSONAL_PRONOUN_SINGULAR);
        SELECTIONS.put(ConceptTermination.NI, (Selector) (Concept c) -> PERSONAL_PRONOUN_PLURAL);
        SELECTIONS.put(ConceptTermination.VI, (Selector) (Concept c) -> PERSONAL_PRONOUN_PLURAL);
        SELECTIONS.put(ConceptTermination.ILI, (Selector) (Concept c) -> PERSONAL_PRONOUN_PLURAL);
    }
    
    /**
     * Returns an adequate token type by the given concept instance.
     * @param concept The given concept instance.
     * @return The adequate token type/syntactical category.
     */
    public static final TokenType get(Concept concept) {
        ConceptTermination termination = concept.getProperties().getTermination();
        if (SELECTIONS.containsKey(termination)) {
            return SELECTIONS.get(termination).select(concept);
        }
        return UNKNOWN;
    }
    
    /**
     * Indicates whether this token type is an element of the given token types.
     * @param tokenTypes The given token types.
     * @return <code>true</code> if the token type is contained in the given
     * token type array.
     */
    public final boolean isOneOf(final TokenType ... tokenTypes) {
        for (final TokenType tokenType : tokenTypes) {
            if (this == tokenType) {
                return true;
            }
        }
        return false;
    }
}

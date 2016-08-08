/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tokens;

import java.util.List;

/**
 * This <code>TokenType</code> class declares all possible syntactical
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
     * The appropriate token value represents an arbitrary substantive (singular
     * or plural), for example <b>SunO</b> <i>(sun)</i> or <b>SunOJ</b>
     * <i>(suns)</i>.
     */
    SUBSTANTIVE,
    
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
     * The appropriate token value represents an arbitrary adjective (singular
     * or plural).
     */
    ADJECTIVE,
    
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
     * The appropriate token value represents an arbitrary adverb (singular or
     * plural).
     */
    ADVERB,
    
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
     * The appropriate token value represents an arbitrary personal pronoun.
     */
    PERSONAL_PRONOUN,
    
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
     * The appropriate token value represents a kind of separator symbol for
     * listings.
     */
    SEPARATOR,
    
    /**
     * The appropriate token value represents the base concept <b>Kaj</b>
     * <i>(and)</i>.
     */
    SEPARATOR_KAJ,
    
    /**
     * The appropriate token value represents the base concept <b>Aux</b>
     * <i>(or)</i>.
     */
    SEPARATOR_AUX,
    
    /**
     * The appropriate token value represents the base concept <b>Se</b>
     * <i>(or)</i>.
     */
    SEPARATOR_SE,
    
    /**
     * The appropriate token value opens an element.
     */
    OPEN,
    
    /**
     * The appropriate token value closes an element.
     */
    CLOSE,
    
    /**
     * The appropriate token value opens an unordered list of elements.
     */
    OPEN_SET,
    
    /**
     * The appropriate token value closes an unordered list of elements.
     */
    CLOSE_SET,
    
    /**
     * The appropriate token value indicates the subject.
     */
    PART_SU,
    
    /**
     * The appropriate token value indicates the predicate.
     */
    PART_DOM,
    
    /**
     * The appropriate token value indicates the dative object.
     */
    PART_AL,
    
    /**
     * The appropriate token value indicates the accusative object.
     */
    PART_FIN,
    
    /**
     * The appropriate token value indicates the present tense verb.
     */
    VERB_PRESENT_TENSE,
    
    /**
     * The appropriate token value represents a terminator symbol for
     * terminating plain text sentences, for example a single period.
     */
    TERMINATOR;
    
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
    
    /**
     * Indicates whether this token type is an element of the given token types.
     * @param tokenTypes The given token types.
     * @return <code>true</code> if the token type is contained in the given
     * token type list.
     */
    public final boolean isOneOf(final List<TokenType> tokenTypes) {
        return tokenTypes.stream().anyMatch(tokenType -> this == tokenType);
    }
    
    /**
     * Returns the simple/single name of this token type.
     * @return The name of this token type.
     */
    @Override
    public final String toString() {
        return this.name();
    }
}

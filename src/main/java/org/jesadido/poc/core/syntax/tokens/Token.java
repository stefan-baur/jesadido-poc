/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tokens;

import org.jesadido.poc.core.concepts.Concept;

/**
 * This <code>Token</code> class implements the structural representation of a
 * single <b>Jesadido</b> lexeme/concept phrase that explicitly indicates its
 * categrization for the purpose of parsing.
 */
public final class Token {
    
    private final String value;
    private final TokenType type;
    private final Concept concept;
    
    /**
     * Class constructor.
     * @param value The token value/concept phrase/lexeme (not null).
     * @param type The token type listed under <code>TokenType</code>.
     * @param concept The appropriate concept instance (not null).
     */
    public Token(final String value, final TokenType type, final Concept concept) {
        this.value = value;
        this.type = type;
        this.concept = concept;
    }
    
    /**
     * Returns the single lexeme of this token.
     * @return The single lexeme/concept phrase.
     */
    public final String getValue() {
        return this.value;
    }
    
    /**
     * Return the syntactical category of this token.
     * @return The syntactical category.
     */
    public final TokenType getType() {
        return this.type;
    }
    
    /**
     * Returns the concept instance according to the token value.
     * @return The appropriated concept instance.
     */
    public final Concept getConcept() {
        return this.concept;
    }
    
    /**
     * Returns the type and the value of this token as a string.
     * @return The type and the value of this token as a string.
     */
    @Override
    public final String toString() {
        return String.format("%s[\"%s\"]", this.getType().name(), this.getValue());
    }
}

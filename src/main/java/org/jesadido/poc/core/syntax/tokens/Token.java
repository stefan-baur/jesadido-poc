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
    private final int positionX;
    private final int positionY;
    
    /**
     * Class constructor.
     * @param value The token value/concept phrase/lexeme (not null).
     * @param type The token type listed under <code>TokenType</code>.
     * @param concept The appropriate concept instance (not null).
     * @param positionX The x-cursor-position of the appearance of the lexeme.
     * @param positionY The y-cursor-position of the appearance of the lexeme.
     */
    public Token(final String value, final TokenType type, final Concept concept, final int positionX, final int positionY) {
        this.value = value;
        this.type = type;
        this.concept = concept;
        this.positionX = positionX;
        this.positionY = positionY;
    }
    
    /**
     * Class constructor.
     * @param value The token value/concept phrase/lexeme (not null).
     * @param type The token type listed under <code>TokenType</code>.
     * @param concept The appropriate concept instance (not null).
     */
    public Token(final String value, final TokenType type, final Concept concept) {
        this(value, type, concept, 0, 1);
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
     * Indicates whether this token has position-informations.
     * @return <code>true</code> if the position-informations can be used.
     */
    public final boolean hasPosition() {
        return this.positionX > 0;
    }
    
    /**
     * Returns the x-position of the appearance of this token inside the
     * source-code.
     * @return The x-position.
     */
    public final int getPositionX() {
        return this.positionX;
    }
    
    /**
     * Returns the y-position of the appearance of this token inside the
     * source-code.
     * @return The y-position.
     */
    public final int getPositionY() {
        return this.positionY;
    }
    
    /**
     * Returns the type and the value of this token as a string.
     * @return The type and the value of this token as a string.
     */
    @Override
    public final String toString() {
        String positionInformation = "";
        if (this.hasPosition()) {
            positionInformation = String.format("[%d:%d]", this.getPositionX(), this.getPositionY());
        }
        return String.format("\"%s\" %s%s", this.getValue(), this.getType().name(), positionInformation);
    }
}

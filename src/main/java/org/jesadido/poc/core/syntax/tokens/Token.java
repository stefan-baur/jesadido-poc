/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tokens;

import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.concepts.ConceptRegistry;

/**
 * This <code>Token</code> class implements the structural representation of a
 * single <b>Jesadido</b> lexeme/concept phrase that explicitly indicates its
 * categrization for the purpose of parsing.
 */
public final class Token {
    
    private final String value;
    private final TokenType type;
    private final Concept concept;
    
    private Token(final String value, final TokenType type, final Concept concept) {
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
     * Instantiates a token instance by the given concept phrase/lexeme.
     * @param conceptPhrase The given concept phrase.
     * @return The token instance.
     */
    public static final Token create(final String conceptPhrase) {
        final String value = conceptPhrase == null ? "" : conceptPhrase;
        final Concept concept = ConceptRegistry.getInstance().getConcept(value);
        if (!value.equals(concept.getFullPhrase())) {
            return new Token(value, TokenType.INVALID_CONCEPT, concept);
        }
        return new Token(value, TokenType.get(concept), concept);
    }
}

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

public final class Token {
    
    private final String value;
    private final TokenType type;
    private final Concept concept;
    
    private Token(final String value, final TokenType type, final Concept concept) {
        this.value = value;
        this.type = type;
        this.concept = concept;
    }
    
    public final String getValue() {
        return this.value;
    }
    
    public final Concept getConcept() {
        return this.concept;
    }
    
    public final TokenType getType() {
        return this.type;
    }
    
    public static final Token create(final String conceptPhrase) {
        final String value = conceptPhrase == null ? "" : conceptPhrase;
        final Concept concept = ConceptRegistry.getInstance().getConcept(value);
        if (!value.equals(concept.getFullPhrase())) {
            return new Token(value, TokenType.INVALID_CONCEPT, concept);
        }
        return new Token(value, TokenType.get(concept), concept);
    }
}

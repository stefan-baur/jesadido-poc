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
 * This <code>TokenCreator</code> interface is used for creating token instances
 * for the purpose of token stream with aspect-orientated selection of token
 * types.
 */
public interface TokenCreator {
    
    /**
     * Instantiates a token instance by the given concept phrase/lexeme.
     * @param conceptPhrase The given concept phrase used for the token value.
     * @return The token instance.
     */
    Token create(String conceptPhrase);
    
    /**
     * Returns an adequate token type by the given concept instance.
     * @param concept The given concept instance.
     * @return The adequate token type/syntactical category.
     */
    TokenType selectTokenType(Concept concept);
    
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

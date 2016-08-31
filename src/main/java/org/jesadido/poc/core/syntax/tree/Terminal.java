/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tree;

import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.syntax.tokens.Token;

public final class Terminal {
    
    private final Token token;
    
    public Terminal(final Token token) {
        this.token = token;
        if (this.token == null) {
            throw new IllegalArgumentException("A token has to be not null.");
        }
    }
    
    public final Token getToken() {
        return this.token;
    }
    
    public final Concept getConcept() {
        return this.token.getConcept();
    }
    
    public final boolean isDefault() {
        return !this.token.hasPosition();
    }
    
    @Override
    public final String toString() {
        return this.token.toString();
    }
}

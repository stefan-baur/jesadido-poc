/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tree;

import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.concepts.ConceptRegistry;
import org.jesadido.poc.core.syntax.tokens.Token;

public final class Terminal {
    
    private final String defaultConceptPhrase;
    private final Token token;
    
    public Terminal(final Token token, final String defaultConceptPhrase) {
        this.defaultConceptPhrase = defaultConceptPhrase;
        this.token = token;
    }
    
    public Terminal(final Token token) {
        this(token, null);
    }
    
    public Terminal(final String defaultConceptPhrase) {
        this(null, defaultConceptPhrase);
    }
    
    public final boolean hasConcept() {
        return this.token != null || this.defaultConceptPhrase != null;
    }
    
    public final Concept getConcept() {
        return this.token != null ? this.token.getConcept() : ConceptRegistry.getInstance().getConcept(this.defaultConceptPhrase);
    }
    
    public final boolean isDefault() {
        return this.token == null || this.token.getConcept().getFullPhrase().equals(this.defaultConceptPhrase);
    }
}

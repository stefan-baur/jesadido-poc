/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax;

import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.concepts.ConceptRegistry;

public final class Terminal {
    
    private final String defaultConceptPhrase;
    private final Concept nullableConcept;
    
    public Terminal(final Concept nullableConcept, final String defaultConceptPhrase) {
        this.defaultConceptPhrase = defaultConceptPhrase;
        this.nullableConcept = nullableConcept;
    }
    
    public Terminal(final String defaultConceptPhrase) {
        this(null, defaultConceptPhrase);
    }
    
    public final Concept getConcept() {
        return this.nullableConcept != null ? this.nullableConcept : ConceptRegistry.getInstance().getConcept(this.defaultConceptPhrase);
    }
    
    public final boolean isDefault() {
        return this.nullableConcept == null || this.nullableConcept.getFullPhrase().equals(this.defaultConceptPhrase);
    }
}

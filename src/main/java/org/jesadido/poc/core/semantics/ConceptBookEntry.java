/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics;

public class ConceptBookEntry {
    
    private final String conceptPhrase;
    
    public ConceptBookEntry(final String conceptPhrase) {
        this.conceptPhrase = conceptPhrase;
    }
    
    public String getConceptPhrase() {
        return this.conceptPhrase;
    }
    
    public boolean expand(final ConceptBookEntry entry) {
        return this.conceptPhrase.equals(entry.getConceptPhrase());
    }
}

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.concepts;

import java.util.HashMap;
import java.util.Map;

public final class ConceptPool {
    
    private static final Map<String, Concept> CONCEPTS;
    
    static {
        CONCEPTS = new HashMap<>();
    }
    
    private ConceptPool() {
        // Unused.
    }
    
    public static final Map<String, Concept> getConcepts() {
        return CONCEPTS;
    }
    
    public static final boolean hasConcept(final String conceptPhrase) {
        return CONCEPTS.containsKey(conceptPhrase);
    }
    
    public static final Concept getConcept(final String conceptPhrase) {
        if (!CONCEPTS.containsKey(conceptPhrase)) {
            CONCEPTS.put(conceptPhrase, ConceptParser.parse(conceptPhrase));
        }
        return CONCEPTS.get(conceptPhrase);
    }
}

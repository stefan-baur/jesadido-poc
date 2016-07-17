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
import java.util.logging.Logger;

public final class ConceptRegistry {
    
    private static final Logger LOGGER = Logger.getLogger(ConceptRegistry.class.getName());
    
    private static final Map<String, Concept> CONCEPTS = new HashMap<>();
    
    private ConceptRegistry() {
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
            Concept parsedConcept = ConceptParser.parse(conceptPhrase);
            if (!conceptPhrase.equals(parsedConcept.getFullPhrase())) {
                LOGGER.severe(String.format("The given concept phrase differs to the parsed result: \"%s\" != \"%s\"", conceptPhrase, parsedConcept.getFullPhrase()));
            }
            CONCEPTS.put(conceptPhrase, parsedConcept);
        }
        return CONCEPTS.get(conceptPhrase);
    }
}

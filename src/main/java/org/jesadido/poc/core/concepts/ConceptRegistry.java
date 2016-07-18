/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.concepts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.jesadido.poc.core.CoreUtils;

public final class ConceptRegistry {
    
    private static final Logger LOGGER = Logger.getLogger(ConceptRegistry.class.getName());
    
    private static final Map<String, Concept> CONCEPTS = new HashMap<>();
    
    private ConceptRegistry() {
        // A private utility class constructor.
    }
    
    public static final Map<String, Concept> getConcepts() {
        return CONCEPTS;
    }
    
    public static final boolean hasConcept(final String conceptPhrase) {
        return CONCEPTS.containsKey(conceptPhrase);
    }
    
    public static final Concept getConcept(final List<String> morphemes) {
        if (!morphemes.isEmpty()) {
            final String conceptPhrase = CoreUtils.toConceptPhrase(morphemes);
            if (!CONCEPTS.containsKey(conceptPhrase)) {
                final Concept builtConcept = new Concept(new ConceptBuilder(morphemes));
                if (!conceptPhrase.equals(builtConcept.getFullPhrase())) {
                    LOGGER.severe(String.format("The given concept phrase differs to the built result: \"%s\" != \"%s\"", conceptPhrase, builtConcept.getFullPhrase()));
                }
                CONCEPTS.put(conceptPhrase, builtConcept);
            }
            return CONCEPTS.get(conceptPhrase);
        }
        throw new IllegalArgumentException("There are no concept morphemes.");
    }
    
    public static final Concept getConcept(final String conceptPhrase) {
        if (conceptPhrase != null && conceptPhrase.length() > 0) {
            if (!CONCEPTS.containsKey(conceptPhrase)) {
                final Concept parsedConcept = ConceptParser.parse(conceptPhrase);
                if (!conceptPhrase.equals(parsedConcept.getFullPhrase())) {
                    LOGGER.severe(String.format("The given concept phrase differs to the parsed result: \"%s\" != \"%s\"", conceptPhrase, parsedConcept.getFullPhrase()));
                }
                CONCEPTS.put(conceptPhrase, parsedConcept);
            }
            return CONCEPTS.get(conceptPhrase);
        }
        throw new IllegalArgumentException("The given concept is null or empty.");
    }
}

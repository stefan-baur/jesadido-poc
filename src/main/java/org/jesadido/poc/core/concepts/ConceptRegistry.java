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
    
    private static ConceptRegistry instance = null;
    
    private final Map<String, Concept> concepts = new HashMap<>();
    
    private ConceptRegistry() {
        // A private singleton class constructor.
    }
    
    public static final ConceptRegistry getInstance() {
        if (instance == null) {
            instance = new ConceptRegistry();
        }
        return instance;
    }
    
    public final Map<String, Concept> getConcepts() {
        return concepts;
    }
    
    public final boolean hasConcept(final String conceptPhrase) {
        return concepts.containsKey(conceptPhrase);
    }
    
    public final Concept getConcept(final List<String> morphemes) {
        if (!morphemes.isEmpty()) {
            final String conceptPhrase = CoreUtils.toConceptPhrase(morphemes);
            if (!concepts.containsKey(conceptPhrase)) {
                final Concept builtConcept = new Concept(new ConceptBuilder(morphemes));
                if (!conceptPhrase.equals(builtConcept.getFullPhrase())) {
                    LOGGER.severe(String.format("The given concept phrase differs to the built result: \"%s\" != \"%s\"", conceptPhrase, builtConcept.getFullPhrase()));
                }
                concepts.put(conceptPhrase, builtConcept);
            }
            return concepts.get(conceptPhrase);
        }
        throw new IllegalArgumentException("There are no concept morphemes.");
    }
    
    public final Concept getConcept(final String conceptPhrase) {
        if (conceptPhrase != null && conceptPhrase.length() > 0) {
            if (!concepts.containsKey(conceptPhrase)) {
                final Concept parsedConcept = ConceptParser.parse(conceptPhrase);
                if (!conceptPhrase.equals(parsedConcept.getFullPhrase())) {
                    LOGGER.severe(String.format("The given concept phrase differs to the parsed result: \"%s\" != \"%s\"", conceptPhrase, parsedConcept.getFullPhrase()));
                }
                concepts.put(conceptPhrase, parsedConcept);
            }
            return concepts.get(conceptPhrase);
        }
        throw new IllegalArgumentException("The given concept is null or empty.");
    }
}

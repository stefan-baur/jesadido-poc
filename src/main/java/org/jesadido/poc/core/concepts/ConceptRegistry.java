/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.concepts;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * This <code>ConceptRegistry</code> singleton class is a factory and a pool for
 * all required concepts.
 */
public final class ConceptRegistry {
    
    private static final Logger LOGGER = Logger.getLogger(ConceptRegistry.class.getName());
    
    private static ConceptRegistry instance = null;
    
    private final Map<String, Concept> conceptMap = new HashMap<>();
    private final Map<String, Concept> concepts = Collections.unmodifiableMap(this.conceptMap);
    
    private ConceptRegistry() {
        // A private singleton class constructor.
    }
    
    /**
     * Returns the singleton instance of this class.
     * @return The singleton instance of this class.
     */
    public static final ConceptRegistry getInstance() {
        if (instance == null) {
            instance = new ConceptRegistry();
        }
        return instance;
    }
    
    /**
     * Returns the unmodifiable concept map containing all concepts created by
     * this singleton instance.
     * @return The concept map.
     */
    public final Map<String, Concept> getConcepts() {
        return this.concepts;
    }
    
    /**
     * Indicates whether there is a concept instance mapped to the given
     * concept phrase.
     * @param conceptPhrase The given concept phrase.
     * @return <code>true</code> if there is a mapped concept instance.
     */
    public final boolean hasConcept(final String conceptPhrase) {
        return this.conceptMap.containsKey(conceptPhrase);
    }
    
    /**
     * Returns a concept instance by the given morpheme list. If there is no
     * mapped concept, a new concept will be created via the concept builder
     * <code>ConceptBuilder</code>.
     * @param morphemes The given morpheme list. An empty list will cause an
     * <code>IllegalArgumentException</code>.
     * @return The concept instance.
     */
    public final Concept getConcept(final List<String> morphemes) {
        if (!morphemes.isEmpty()) {
            final String conceptPhrase = ConceptUtils.toConceptPhrase(morphemes);
            if (!this.conceptMap.containsKey(conceptPhrase)) {
                final Concept builtConcept = new Concept(new ConceptBuilder(morphemes));
                if (!conceptPhrase.equals(builtConcept.getFullPhrase())) {
                    LOGGER.severe(String.format("The given morpheme phrases differs to the built result: \"%s\" != \"%s\"", conceptPhrase, builtConcept.getFullPhrase()));
                }
                this.conceptMap.put(conceptPhrase, builtConcept);
            }
            return this.conceptMap.get(conceptPhrase);
        }
        throw new IllegalArgumentException("There are no concept morphemes.");
    }
    
    /**
     * Returns a concept instance by the given concept phrase. If there is no
     * mapped concept, a new concept will be created via the concept parser
     * <code>ConceptParser</code>.
     * @param conceptPhrase The given concept phrase.
     * @return The concept instance.
     */
    public final Concept getConcept(final String conceptPhrase) {
        if (conceptPhrase != null && conceptPhrase.length() > 0) {
            if (!this.conceptMap.containsKey(conceptPhrase)) {
                final Concept parsedConcept = ConceptUtils.parseToConcept(conceptPhrase);
                if (!conceptPhrase.equals(parsedConcept.getFullPhrase())) {
                    LOGGER.severe(String.format("The given concept phrase differs to the parsed result: \"%s\" != \"%s\"", conceptPhrase, parsedConcept.getFullPhrase()));
                }
                this.conceptMap.put(conceptPhrase, parsedConcept);
            }
            return this.conceptMap.get(conceptPhrase);
        }
        throw new IllegalArgumentException("The given concept is null or empty.");
    }
}

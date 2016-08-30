/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.concepts.ConceptRegistry;
import org.jesadido.poc.core.syntax.Grammar;
import org.jesadido.poc.core.syntax.GrammarFactory;

public class ConceptBook {
    
    private final String name;
    private final Grammar grammar = GrammarFactory.createJesadidoGrammar();
    private final Map<String, ConceptBookEntry> conceptBookMap = new LinkedHashMap<>();
    private final List<String> referenceSources = new LinkedList<>();
    
    public ConceptBook(final String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public Grammar getGrammar() {
        return this.grammar;
    }
    
    public ConceptBook add(final ConceptBookEntry conceptBookEntry) {
        this.conceptBookMap.put(conceptBookEntry.getConceptPhrase(), conceptBookEntry);
        return this;
    }
    
    public ConceptBookEntry get(final Concept concept) {
        if (concept != null) {
            if (this.conceptBookMap.containsKey(concept.getFullPhrase())) {
                return this.conceptBookMap.get(concept.getFullPhrase());
            }
            return new ConceptBookEntry(concept.getFullPhrase());
        }
        throw new IllegalArgumentException("The concept is null.");
    }
    
    public ConceptBookEntry get(final String conceptPhrase) {
        return this.get(ConceptRegistry.getInstance().getConcept(conceptPhrase));
    }
    
    public Collection<ConceptBookEntry> getEntries() {
        return this.conceptBookMap.values();
    }
    
    public List<String> getReferenceSources() {
        return this.referenceSources;
    }
    
    public ConceptBook addReferenceSources(String ... referenceSource) {
        this.referenceSources.addAll(Arrays.asList(referenceSource));
        return this;
    }
}

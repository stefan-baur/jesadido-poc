/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.concepts;

import java.util.List;

public final class Concept {
    
    private final Concept referenceConcept;
    private final List<String> baseMorphemes;
    private final String basePhrase;
    private final String fullPhrase;
    private final ConceptProperties properties;
    
    public Concept(final ConceptBuilder conceptBuilder) {
        this.referenceConcept = conceptBuilder.buildReferenceConcept();
        this.baseMorphemes = conceptBuilder.buildBaseMorphemes();
        this.basePhrase = conceptBuilder.buildBasePhrase();
        this.fullPhrase = conceptBuilder.buildFullPhrase();
        this.properties = conceptBuilder.buildProperties();
    }
    
    public boolean hasReferenceConcept() {
        return this.referenceConcept != null;
    }
    
    public Concept getReferenceConcept() {
        return this.referenceConcept;
    }
    
    public List<String> getBaseMorphemes() {
        return this.baseMorphemes;
    }
    
    public String getBasePhrase() {
        return this.basePhrase;
    }
    
    public String getFullPhrase() {
        return this.fullPhrase;
    }
    
    public ConceptProperties getProperties() {
        return this.properties;
    }
    
    public static Concept parse(final String fullPhrase) {
        return ConceptParser.parse(fullPhrase);
    }
}

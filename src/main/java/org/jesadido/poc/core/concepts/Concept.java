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
    
    public final boolean hasReferenceConcept() {
        return this.referenceConcept != null;
    }
    
    public final Concept getReferenceConcept() {
        return this.referenceConcept;
    }
    
    public final List<String> getBaseMorphemes() {
        return this.baseMorphemes;
    }
    
    public final String getBasePhrase() {
        return this.basePhrase;
    }
    
    public final String getFullPhrase() {
        return this.fullPhrase;
    }
    
    public final ConceptProperties getProperties() {
        return this.properties;
    }
    
    public static final Concept parse(final String fullPhrase) {
        return ConceptParser.parse(fullPhrase);
    }
}

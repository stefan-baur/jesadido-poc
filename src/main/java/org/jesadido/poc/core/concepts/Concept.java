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
    
    private final Concept reference;
    private final List<String> baseMorphemes;
    private final String basePhrase;
    private final String fullPhrase;
    private final ConceptProperties properties;
    
    public Concept(final ConceptBuilder conceptBuilder) {
        this.reference = conceptBuilder.buildReference();
        this.baseMorphemes = conceptBuilder.buildBaseMorphemes();
        this.basePhrase = conceptBuilder.buildBasePhrase();
        this.fullPhrase = conceptBuilder.buildFullPhrase();
        this.properties = conceptBuilder.buildProperties();
    }
    
    public boolean hasReference() {
        return this.reference != null;
    }
    
    public Concept getReference() {
        return this.reference;
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

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.concepts;

import java.util.List;

/**
 * This <code>Concept</code> class represents a morpheme-based <b>Jesadido</b>
 * lexeme without any whitespaces.
 * Some examples of <b>Jesadido</b> lexemes are:
 * <ul>
 *  <li><code>SunO</code> <i>(sun)</i></li>
 *  <li><code>SunA</code> <i>(sunny)</i></li>
 *  <li><code>SunE</code> <i>(sunnily)</i></li>
 *  <li><code>LunO</code> <i>(moon)</i></li>
 *  <li><code>Kaj</code> <i>(and)</i></li>
 *  <li><code>StelOJ</code> <i>(stars)</i></li>
 *  <li><code>Mi</code> <i>(I)</i></li>
 *  <li><code>Bi</code> <i>(you)</i></li>
 *  <li><code>InO$Bi</code> <i>(you as female)</i></li>
 *  <li><code>IcxO$Bi</code> <i>(you as male)</i></li>
 *  <li><code>/de/'Bertha'von'Suttner'InO</code> <i>(Bertha von Suttner)</i></li>
 *  <li><code>/eo/'Ludoviko'Lazaro'Zamenhofo'IcxO</code> <i>(Ludwik Lejzer Zamenhof)</i></li>
 * </ul>
 */
public final class Concept {
    
    private final Concept referenceConcept;
    private final List<String> baseMorphemes;
    private final String basePhrase;
    private final String fullPhrase;
    private final ConceptProperties properties;
    
    /**
     * This class constructor uses a <code>ConceptBuilder</code> instance for
     * the parameter construction. Use the factory method
     * <code>ConceptRegistry.getConcept()</code> for creating new concept
     * instances, respectively for using existing concept instances!
     * @param conceptBuilder The concept builder.
     */
    public Concept(final ConceptBuilder conceptBuilder) {
        this.referenceConcept = conceptBuilder.buildReferenceConcept();
        this.baseMorphemes = conceptBuilder.buildBaseMorphemes();
        this.basePhrase = conceptBuilder.buildBasePhrase();
        this.fullPhrase = conceptBuilder.buildFullPhrase();
        this.properties = conceptBuilder.buildProperties();
    }
    
    /**
     * Indicates whether there is a reference concept.
     * @return <code>true</code> if there is a reference concept.
     */
    public final boolean hasReferenceConcept() {
        return this.referenceConcept != null;
    }
    
    /**
     * Returns the reference concept of this concept. The reference concept is
     * often required by the translation process.
     * @return The reference concept.
     */
    public final Concept getReferenceConcept() {
        return this.referenceConcept;
    }
    
    /**
     * Returns the first character upper-cased morpheme list of the root phrase
     * (not involving the reference concept) of this concept. The endings
     * contains the syntactical information for the parsing process.
     * @return The morpheme list.
     */
    public final List<String> getBaseMorphemes() {
        return this.baseMorphemes;
    }
    
    /**
     * Returns the base lexeme of this concept without the representation of the
     * reference concept.
     * @return The base lexeme, the concatenation of the base morphemes.
     */
    public final String getBasePhrase() {
        return this.basePhrase;
    }
    
    /**
     * Returns the full lexeme of this concept within the representation of the
     * reference concept.
     * @return The full lexeme.
     */
    public final String getFullPhrase() {
        return this.fullPhrase;
    }
    
    /**
     * Returns the properties of this concept which are often required for the
     * translation process.
     * @return The concept properties.
     */
    public final ConceptProperties getProperties() {
        return this.properties;
    }
}

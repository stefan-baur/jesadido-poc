/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.concepts;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This <code>ConceptParameterType</code> enum class provides all supported
 * parameter types which can be represented by a <b>Jesadido</b> lexeme so
 * called 'concept'.
 */
public enum ConceptParameterType {
    
    /**
     * The appropriated concept has no parameter.
     */
    NONE,
    
    /**
     * The appropriated concept is a genderless proper name.
     */
    PROPERNAME("'O", "'OJ"),
    
    /**
     * The appropriated concept is a proper name for males.
     */
    PROPERNAME_MASCULINE("'IcxO", "'IcxOJ"),
    
    /**
     * The appropriated concept is a proper name for females.
     */
    PROPERNAME_FEMININE("'InO", "'InOJ"),
    
    /**
     * The appropriated concept is a uniform resource locator (URL).
     */
    URL("'LigO"),
    
    /**
     * The appropriated concept is a date, respectively a day.
     */
    DATE("'DatO"),
    
    /**
     * The appropriated concept is a citation.
     */
    CITATION("'CitO"),
    
    /**
     * The appropriated concept is a postal address.
     */
    ADDRESS("'AdresO");
    
    private final List<String> conceptEndings;
    
    private ConceptParameterType(final String ... conceptEndings) {
        this.conceptEndings = Collections.unmodifiableList(Arrays.asList(conceptEndings));
    }
    
    /**
     * Returns the indicators for the concept parameter types as lexeme endings.
     * @return The concept endings.
     */
    public final List<String> getConceptEndings() {
        return this.conceptEndings;
    }
    
    /**
     * Returns the concept parameter type by the given concept phrase.
     * @param conceptPhrase The given concept phrase.
     * @return The concept parameter type.
     */
    public static final ConceptParameterType get(final String conceptPhrase) {
        for (final ConceptParameterType conceptParameterType : ConceptParameterType.values()) {
            for (final String conceptEnding : conceptParameterType.getConceptEndings()) {
                if (conceptPhrase != null && conceptPhrase.endsWith(conceptEnding)) {
                    return conceptParameterType;
                }
            }
        }
        return ConceptParameterType.NONE;
    }
}

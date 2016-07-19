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

public enum ConceptParameterType {
    NONE,
    PROPERNAME("'O", "'OJ"),
    PROPERNAME_MASCULINE("'IcxO", "'IcxOJ"),
    PROPERNAME_FEMININE("'InO", "'InOJ"),
    URL("'LigO"),
    DATE("'DatO"),
    CITATION("'CitO"),
    ADDRESS("'AdresO");
    
    private final List<String> conceptEndings;
    
    private ConceptParameterType(final String ... conceptEndings) {
        this.conceptEndings = Collections.unmodifiableList(Arrays.asList(conceptEndings));
    }
    
    public final List<String> getConceptEndings() {
        return this.conceptEndings;
    }
    
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

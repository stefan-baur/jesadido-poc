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
    HYPER_LINK("'LigO"),
    DATE("'DatO"),
    CITATION("'CitO"),
    ADDRESS("'AdresO");
    
    private final List<String> conceptEndings;
    
    private ConceptParameterType(String ... conceptEndings) {
        this.conceptEndings = Collections.unmodifiableList(Arrays.asList(conceptEndings));
    }
    
    public List<String> getConceptEndings() {
        return this.conceptEndings;
    }
}

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.concepts;

import java.util.Arrays;
import java.util.List;

public final class ConceptParser {
    
    private ConceptParser() {
        // A private utility class constructor.
    }
    
    public static final Concept parse(final String fullPhrase) {
        return new Concept(new ConceptBuilder(parseToMorphemes(fullPhrase)));
    }
    
    private static final List<String> parseToMorphemes(final String fullPhrase) {
        return Arrays.asList(fullPhrase);
    }
}

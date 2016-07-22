/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.concepts;

import java.util.List;
import org.jesadido.poc.core.CoreUtils;

public final class MorphemeUtils {
    
    private MorphemeUtils() {
        // A private utility class constructor.
    }
        
    /**
     * Concats the given morphemes to a typical concept phrase with upper-cased
     * morphemes.
     * @param morphemes The given morphemes.
     * @return The concept phrase.
     */
    public static final String toConceptPhrase(final List<String> morphemes) {
        return String.join("", CoreUtils.up(morphemes));
    }
}

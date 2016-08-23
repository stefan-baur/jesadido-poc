/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.en;

import org.jesadido.poc.core.semantics.TranslationTarget;

public final class EnUtils {
    
    private EnUtils() {
        // A private utility class constructor
    }
    
    public static String getIndefiniteArticle(final TranslationTarget followerTarget) {
        final String follower = followerTarget.getPhrase();
        if ("aeio".contains(Character.toString(follower.charAt(0)))) {
            return "an";
        } else {
            return "a";
        }
    }
}

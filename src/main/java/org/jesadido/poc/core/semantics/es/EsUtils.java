/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.es;

import org.jesadido.poc.core.semantics.TranslationTarget;

public final class EsUtils {
    
    private EsUtils() {
        // A private utility class constructor
    }
    
    public static String getUndeterminedArticle(final TranslationTarget substantiveTarget) {
        if (substantiveTarget.getAttributes().contains(Es.FEMININE)) {
            return "una";
        } else {
            return "un";
        }
    }
}

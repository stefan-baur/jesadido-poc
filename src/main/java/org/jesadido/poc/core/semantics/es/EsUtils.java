/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.es;

import java.util.List;
import org.jesadido.poc.core.semantics.TranslationTarget;
import org.jesadido.poc.core.syntax.tree.Node;

public final class EsUtils {
    
    private EsUtils() {
        // A private utility class constructor
    }
    
    public static List<Node> orderParts(List<Node> parts) {
        return parts;
    }
    
    public static String getIndefiniteArticle(final TranslationTarget substantiveTarget) {
        if (substantiveTarget.getAttributes().contains(Es.FEMININE)) {
            return "una";
        } else {
            return "un";
        }
    }
}

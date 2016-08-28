/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.eo;

import java.util.List;
import org.jesadido.poc.core.semantics.TranslationTarget;
import org.jesadido.poc.core.syntax.tree.Node;

public final class EoUtils {
    
    private EoUtils() {
        // A private utility class constructor
    }
    
    public static List<Node> orderParts(List<Node> parts) {
        return parts;
    }
    
    public static String getCasedSubstantive(final TranslationTarget substantiveTarget, final Eo caseAttribute) {
        return String.format("%s%s", substantiveTarget.getPhrase(), caseAttribute == Eo.ACCUSATIVE ? "n" : "");
    }
}

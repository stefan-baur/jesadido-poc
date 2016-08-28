/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.de;

import java.util.List;
import org.jesadido.poc.core.semantics.TranslationTarget;
import org.jesadido.poc.core.syntax.tree.Node;
import org.jesadido.poc.core.syntax.tree.NodeUtils;
import org.jesadido.poc.core.syntax.tree.sentence.PartAl;
import org.jesadido.poc.core.syntax.tree.sentence.PartDom;
import org.jesadido.poc.core.syntax.tree.sentence.PartFin;
import org.jesadido.poc.core.syntax.tree.sentence.PartSu;

public final class DeUtils {
    
    private DeUtils() {
        // A private utility class constructor
    }
    
    public static List<Node> orderParts(final List<Node> parts) {
        boolean fin = false;
        for (Node part : parts) {
            if (part.objectOf(PartSu.class)) {
                break;
            } else if (part.objectOf(PartFin.class)) {
                fin = true;
            }
        }
        if (fin) {
            return NodeUtils.rearrange(parts, PartFin.class, PartDom.class, PartSu.class, PartAl.class);
        } else {
            return NodeUtils.rearrange(parts, PartSu.class, PartDom.class, PartAl.class, PartFin.class);
        }
    }
    
    public static String getIndefiniteArticleFeminine(final De caseAttribute) {
        if ((caseAttribute == De.NOMINATIVE) || (caseAttribute == De.ACCUSATIVE)) {
            return "eine";
        } else {
            return "einer";
        }
    }
    
    public static String getIndefiniteArticleNeuter(final De caseAttribute) {
        if ((caseAttribute == De.NOMINATIVE) || (caseAttribute == De.ACCUSATIVE)) {
            return "ein";
        } else if (caseAttribute == De.DATIVE) {
            return "einem";
        } else {
            return "eines";
        }
    }
    
    public static String getIndefiniteArticleMasculine(final De caseAttribute) {
        if (caseAttribute == De.NOMINATIVE) {
            return "ein";
        } else if (caseAttribute == De.GENITIVE) {
            return "eines";
        } else if (caseAttribute == De.DATIVE) {
            return "einem";
        } else {
            return "einen";
        }
    }
    
    public static String getIndefiniteArticle(final TranslationTarget substantiveTarget, final De caseAttribute) {
        if (substantiveTarget.getAttributes().contains(De.FEMININE)) {
            return getIndefiniteArticleFeminine(caseAttribute);
        } else if (substantiveTarget.getAttributes().contains(De.NEUTER)) {
            return getIndefiniteArticleNeuter(caseAttribute);
        } else {
            return getIndefiniteArticleMasculine(caseAttribute);
        }
    }
}

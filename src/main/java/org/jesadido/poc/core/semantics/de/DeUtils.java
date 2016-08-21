/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.de;

import org.jesadido.poc.core.semantics.TranslationTarget;

public final class DeUtils {
    
    private DeUtils() {
        // A private utility class constructor
    }
    
    public static String getUndeterminedArticleFeminine(final De caseAttribute) {
        if ((caseAttribute == De.NOMINATIVE) || (caseAttribute == De.ACCUSATIVE)) {
            return "eine";
        } else {
            return "einer";
        }
    }
    
    public static String getUndeterminedArticleNeuter(final De caseAttribute) {
        if ((caseAttribute == De.NOMINATIVE) || (caseAttribute == De.ACCUSATIVE)) {
            return "ein";
        } else if (caseAttribute == De.DATIVE) {
            return "einem";
        } else {
            return "eines";
        }
    }
    
    public static String getUndeterminedArticleMasculine(final De caseAttribute) {
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
    
    public static String getUndeterminedArticle(final TranslationTarget substantiveTarget, final De caseAttribute) {
        if (substantiveTarget.getAttributes().contains(De.FEMININE)) {
            return getUndeterminedArticleFeminine(caseAttribute);
        } else if (substantiveTarget.getAttributes().contains(De.NEUTER)) {
            return getUndeterminedArticleNeuter(caseAttribute);
        } else {
            return getUndeterminedArticleMasculine(caseAttribute);
        }
    }
}

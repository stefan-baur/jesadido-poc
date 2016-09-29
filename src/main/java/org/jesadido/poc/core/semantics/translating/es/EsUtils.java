/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.es;

import java.util.List;
import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.concepts.ConceptTermination;
import org.jesadido.poc.core.semantics.translating.TranslationTarget;
import org.jesadido.poc.core.semantics.translating.Translator;
import org.jesadido.poc.core.syntax.tree.Node;
import org.jesadido.poc.core.syntax.tree.NodeUtils;
import org.jesadido.poc.core.syntax.tree.sentence.PartAl;
import org.jesadido.poc.core.syntax.tree.sentence.PartDom;
import org.jesadido.poc.core.syntax.tree.sentence.PartFin;
import org.jesadido.poc.core.syntax.tree.sentence.PartSu;

public final class EsUtils {
    
    private EsUtils() {
        // A private utility class constructor
    }
    
    public static List<Node> rearrangeParts(final List<Node> parts) {
        return NodeUtils.rearrange(parts, PartSu.class, PartDom.class, PartAl.class, PartFin.class);
    }
    
    public static String getIndefinite(final Translator translator, final Es caseAttribute, final Concept substantiveConcept) {
        final TranslationTarget substantiveTarget = translator.getFirstDefaultTarget(substantiveConcept);
        return String.join(" ", getIndefiniteArticle(caseAttribute, substantiveTarget), substantiveTarget.getMainPhrase());
    }
    
    public static String getDefinite(final Translator translator, final Es caseAttribute, final Concept articleConcept, final Concept substantiveConcept) {
        final TranslationTarget substantiveTarget = translator.getFirstDefaultTarget(substantiveConcept);
        return String.join(" ", getDefiniteArticle(caseAttribute, articleConcept, substantiveTarget), substantiveTarget.getMainPhrase());
    }
    
    private static String getIndefiniteArticle(final Es caseAttribute, final TranslationTarget substantiveTarget) {
        return getCased(caseAttribute, substantiveTarget.has(Es.FEMININE) ? "una" : "un");
    }
    
    private static String getDefiniteArticle(final Es caseAttribute, final Concept articleConcept, final TranslationTarget substantiveTarget) {
        if (articleConcept.hasReferenceConcept()) {
            final Concept referenceConcept = articleConcept.getReferenceConcept();
            if (referenceConcept.getProperties().getTermination().isOneOf(ConceptTermination.MI)) {
                return getCased(caseAttribute, "mi");
            } else if (referenceConcept.getProperties().getTermination().isOneOf(ConceptTermination.BI)) {
                return getCased(caseAttribute, "tu");
            } else if (referenceConcept.getProperties().getTermination().isOneOf(ConceptTermination.GXI)) {
                return getCased(caseAttribute, "su");
            }
        }
        return getDefiniteArticle(caseAttribute, substantiveTarget);
    }
    
    private static String getDefiniteArticle(final Es caseAttribute, final TranslationTarget substantiveTarget) {
        if (substantiveTarget.has(Es.FEMININE)) {
            return getCased(caseAttribute, "la");
        } else {
            return caseAttribute == Es.DATIVE ? "al" : "el";
        }
    }
    
    private static String getCased(final Es caseAttribute, final String phrase) {
        return String.format("%s%s", caseAttribute == Es.DATIVE ? "a " : "", phrase);
    }
}

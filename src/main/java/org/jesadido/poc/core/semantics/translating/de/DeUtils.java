/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.de;

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

public final class DeUtils {
    
    private DeUtils() {
        // A private utility class constructor
    }
    
    public static List<Node> rearrangeParts(final List<Node> parts) {
        boolean fin = false;
        for (final Node part : parts) {
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
    
    public static List<Node> rearrangeConditionalMeatAParts(final List<Node> parts) {
        return NodeUtils.rearrange(parts, PartSu.class, PartAl.class, PartFin.class, PartDom.class);
    }
    
    public static List<Node> rearrangeConditionalMeatBParts(final List<Node> parts) {
        return NodeUtils.rearrange(parts, PartDom.class, PartSu.class, PartAl.class, PartFin.class);
    }
    
    public static String getIndefinite(final Translator translator, final De caseAttribute, final Concept substantiveConcept) {
        final TranslationTarget substantiveTarget = translator.getFirstDefaultTarget(substantiveConcept, caseAttribute);
        return String.join(" ", getIndefiniteArticle(substantiveTarget, caseAttribute), substantiveTarget.getMainPhrase());
    }
    
    public static String getDefinite(final Translator translator, final De caseAttribute, final Concept articleConcept, final Concept substantiveConcept) {
        final TranslationTarget substantiveTarget = translator.getFirstDefaultTarget(substantiveConcept, caseAttribute);
        return String.join(" ", getDefiniteArticle(translator, caseAttribute, articleConcept, substantiveTarget), substantiveTarget.getMainPhrase());
    }
    
    private static String getIndefiniteArticle(final TranslationTarget substantiveTarget, final De caseAttribute) {
        if (substantiveTarget.has(De.FEMININE)) {
            return getIndefiniteArticleFeminine(caseAttribute);
        } else if (substantiveTarget.has(De.NEUTER)) {
            return getIndefiniteArticleNeuter(caseAttribute);
        } else {
            return getIndefiniteArticleMasculine(caseAttribute);
        }
    }
    
    private static String getIndefiniteArticleFeminine(final De caseAttribute) {
        if ((caseAttribute == De.NOMINATIVE) || (caseAttribute == De.ACCUSATIVE)) {
            return "eine";
        } else {
            return "einer";
        }
    }
    
    private static String getIndefiniteArticleNeuter(final De caseAttribute) {
        if ((caseAttribute == De.NOMINATIVE) || (caseAttribute == De.ACCUSATIVE)) {
            return "ein";
        } else if (caseAttribute == De.DATIVE) {
            return "einem";
        } else {
            return "eines";
        }
    }
    
    private static String getIndefiniteArticleMasculine(final De caseAttribute) {
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
    
    private static String getDefiniteArticle(final Translator translator, final De caseAttribute, final Concept articleConcept, final TranslationTarget substantiveTarget) {
        if (caseAttribute == De.NOMINATIVE) {
            return getNominativeDefiniteArticle(translator, articleConcept, substantiveTarget);
        } else if (caseAttribute == De.DATIVE) {
            return getDativeDefiniteArticle(translator, articleConcept, substantiveTarget);
        } else {
            return getAccusativeDefiniteArticle(translator, articleConcept, substantiveTarget);
        }
    }
    
    private static String getDefiniteArticle(final Translator translator, final Concept articleConcept, final String miPhrase, final String biPhrase, final String gxiFemininePhrase, final String gxiDefaultPhrase, final String defaultPhrase) {
        if (articleConcept.hasReferenceConcept()) {
            final Concept referenceConcept = articleConcept.getReferenceConcept();
            final ConceptTermination referenceConceptTermination = referenceConcept.getProperties().getTermination();
            if (referenceConceptTermination.isOneOf(ConceptTermination.MI)) {
                return miPhrase;
            } else if (referenceConceptTermination.isOneOf(ConceptTermination.BI)) {
                return biPhrase;
            } else if (referenceConceptTermination.isOneOf(ConceptTermination.GXI)) {
                return getGxiArticle(translator, referenceConcept, gxiFemininePhrase, gxiDefaultPhrase);
            }
        }
        return defaultPhrase;
    }
    
    private static String getNominativeDefiniteArticle(final Translator translator, final Concept articleConcept, final TranslationTarget substantiveTarget) {
        if (substantiveTarget.has(De.FEMININE)) {
            return getDefiniteArticle(translator, articleConcept, "meine", "deine", "ihre", "seine", "die");
        } else if (substantiveTarget.has(De.NEUTER)) {
            return getDefiniteArticle(translator, articleConcept, "mein", "dein", "ihr", "sein", "das");
        } else {
            return getDefiniteArticle(translator, articleConcept, "mein", "dein", "ihr", "sein", "der");
        }
    }
    
    private static String getDativeDefiniteArticle(final Translator translator, final Concept articleConcept, final TranslationTarget substantiveTarget) {
        if (substantiveTarget.has(De.FEMININE)) {
            return getDefiniteArticle(translator, articleConcept, "meiner", "deiner", "ihrer", "seiner", "der");
        } else {
            return getDefiniteArticle(translator, articleConcept, "meinem", "deinem", "ihrem", "seinem", "dem");
        }
    }
    
    private static String getAccusativeDefiniteArticle(final Translator translator, final Concept articleConcept, final TranslationTarget substantiveTarget) {
        if (substantiveTarget.has(De.FEMININE)) {
            return getDefiniteArticle(translator, articleConcept, "meine", "deine", "ihre", "seine", "die");
        } else if (substantiveTarget.has(De.NEUTER)) {
            return getDefiniteArticle(translator, articleConcept, "mein", "dein", "ihr", "sein", "das");
        } else {
            return getDefiniteArticle(translator, articleConcept, "meinen", "deinen", "ihren", "seinen", "den");
        }
    }
    
    private static String getGxiArticle(final Translator translator, final Concept gxiConcept, final String femininePhrase, final String musculineOrNeuterPhrase) {
        if (gxiConcept.hasReferenceConcept()) {
            final Concept gxiReferenceConcept = gxiConcept.getReferenceConcept();
            final TranslationTarget gxiReferenceTarget = translator.getFirstDefaultTarget(gxiReferenceConcept);
            if (gxiReferenceTarget.has(De.FEMININE)) {
                return femininePhrase;
            }
        }
        return musculineOrNeuterPhrase;
    }
}

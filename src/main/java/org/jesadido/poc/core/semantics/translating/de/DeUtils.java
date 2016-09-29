/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.de;

import java.util.Arrays;
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
    
    private static final String LEXEME_UNSER = "unser";
    
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
    
    private static String getDefiniteArticle(final Translator translator, final Concept articleConcept, final List<String> singularPersonalPronounPhrases, final List<String> pluralPersonalPronounPhrases, final String defaultPhrase) {
        if (articleConcept.hasReferenceConcept()) {
            final Concept referenceConcept = articleConcept.getReferenceConcept();
            final ConceptTermination referenceConceptTermination = referenceConcept.getProperties().getTermination();
            if (referenceConceptTermination.isOneOf(ConceptTermination.MI, ConceptTermination.BI, ConceptTermination.GXI)) {
                return getSingularPossessiva(translator, referenceConcept, singularPersonalPronounPhrases.get(0), singularPersonalPronounPhrases.get(1), singularPersonalPronounPhrases.get(2), singularPersonalPronounPhrases.get(3));
            } else if (referenceConceptTermination.isOneOf(ConceptTermination.NI, ConceptTermination.VI, ConceptTermination.ILI)) {
                return getPluralPossessiva(referenceConcept, pluralPersonalPronounPhrases.get(0), pluralPersonalPronounPhrases.get(1), pluralPersonalPronounPhrases.get(2));
            }
        }
        return defaultPhrase;
    }
    
    private static String getSingularPossessiva(final Translator translator, final Concept personalPronounConcept, final String miPhrase, final String biPhrase, final String gxiFemininePhrase, final String gxiDefaultPhrase) {
        final ConceptTermination personalPronounConceptTermination = personalPronounConcept.getProperties().getTermination();
        if (personalPronounConceptTermination.isOneOf(ConceptTermination.BI)) {
            return biPhrase;
        } else if (personalPronounConceptTermination.isOneOf(ConceptTermination.GXI)) {
            return getGxiArticle(translator, personalPronounConcept, gxiFemininePhrase, gxiDefaultPhrase);
        }
        return miPhrase;
    }
    
    private static String getPluralPossessiva(final Concept personalPronounConcept, final String niPhrase, final String viPhrase, final String iliPhrase) {
        final ConceptTermination personalPronounConceptTermination = personalPronounConcept.getProperties().getTermination();
        if (personalPronounConceptTermination.isOneOf(ConceptTermination.VI)) {
            return viPhrase;
        } else if (personalPronounConceptTermination.isOneOf(ConceptTermination.ILI)) {
            return iliPhrase;
        }
        return niPhrase;
    }
    
    private static String getNominativeDefiniteArticle(final Translator translator, final Concept articleConcept, final TranslationTarget substantiveTarget) {
        if (substantiveTarget.has(De.FEMININE)) {
            return getDefiniteArticle(translator, articleConcept, Arrays.asList("meine", "deine", "ihre", "seine"), Arrays.asList("unsere", "eure", "ihre"), "die");
        } else if (substantiveTarget.has(De.NEUTER)) {
            return getDefiniteArticle(translator, articleConcept, Arrays.asList("mein", "dein", "ihr", "sein"), Arrays.asList(LEXEME_UNSER, "euer", "ihr"), "das");
        } else {
            return getDefiniteArticle(translator, articleConcept, Arrays.asList("mein", "dein", "ihr", "sein"), Arrays.asList(LEXEME_UNSER, "euer", "ihr"), "der");
        }
    }
    
    private static String getDativeDefiniteArticle(final Translator translator, final Concept articleConcept, final TranslationTarget substantiveTarget) {
        if (substantiveTarget.has(De.FEMININE)) {
            return getDefiniteArticle(translator, articleConcept, Arrays.asList("meiner", "deiner", "ihrer", "seiner"), Arrays.asList("unserer", "euerer", "ihrer"), "der");
        } else {
            return getDefiniteArticle(translator, articleConcept, Arrays.asList("meinem", "deinem", "ihrem", "seinem"), Arrays.asList("unserem", "eurem", "ihrem"), "dem");
        }
    }
    
    private static String getAccusativeDefiniteArticle(final Translator translator, final Concept articleConcept, final TranslationTarget substantiveTarget) {
        if (substantiveTarget.has(De.FEMININE)) {
            return getDefiniteArticle(translator, articleConcept, Arrays.asList("meine", "deine", "ihre", "seine"), Arrays.asList("unsere", "eure", "ihre"), "die");
        } else if (substantiveTarget.has(De.NEUTER)) {
            return getDefiniteArticle(translator, articleConcept, Arrays.asList("mein", "dein", "ihr", "sein"), Arrays.asList(LEXEME_UNSER, "euer", "ihr"), "das");
        } else {
            return getDefiniteArticle(translator, articleConcept, Arrays.asList("meinen", "deinen", "ihren", "seinen"), Arrays.asList("unseren", "euren", "ihren"), "den");
        }
    }
    
    private static String getGxiArticle(final Translator translator, final Concept gxiConcept, final String femininePhrase, final String masculineOrNeuterPhrase) {
        if (gxiConcept.hasReferenceConcept()) {
            final Concept gxiReferenceConcept = gxiConcept.getReferenceConcept();
            final TranslationTarget gxiReferenceTarget = translator.getFirstDefaultTarget(gxiReferenceConcept);
            if (gxiReferenceTarget.has(De.FEMININE)) {
                return femininePhrase;
            }
        }
        return masculineOrNeuterPhrase;
    }
}

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.de;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.StringUtils;
import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.concepts.ConceptTermination;
import org.jesadido.poc.core.concepts.ConceptUtils;
import org.jesadido.poc.core.semantics.translating.TranslationTarget;
import org.jesadido.poc.core.semantics.translating.Translator;
import org.jesadido.poc.core.syntax.tree.JesadidoNode;
import org.jesadido.poc.core.syntax.tree.JesadidoNodeUtils;
import org.jesadido.poc.core.syntax.tree.sentence.PartAl;
import org.jesadido.poc.core.syntax.tree.sentence.PartDom;
import org.jesadido.poc.core.syntax.tree.sentence.PartFin;
import org.jesadido.poc.core.syntax.tree.sentence.PartSu;

public final class DeUtils {
    
    private static final String LEXEME_UNSER = "unser";
    
    private DeUtils() {
        // A private utility class constructor
    }
    
    public static List<JesadidoNode> rearrangeParts(final List<JesadidoNode> parts) {
        boolean fin = false;
        for (final JesadidoNode part : parts) {
            if (part.objectOf(PartSu.class)) {
                break;
            } else if (part.objectOf(PartFin.class)) {
                fin = true;
            }
        }
        if (fin) {
            return JesadidoNodeUtils.rearrange(parts, PartFin.class, PartDom.class, PartSu.class, PartAl.class);
        } else {
            return JesadidoNodeUtils.rearrange(parts, PartSu.class, PartDom.class, PartAl.class, PartFin.class);
        }
    }
    
    public static List<JesadidoNode> rearrangeConditionalMeatAParts(final List<JesadidoNode> parts) {
        return JesadidoNodeUtils.rearrange(parts, PartSu.class, PartAl.class, PartFin.class, PartDom.class);
    }
    
    public static List<JesadidoNode> rearrangeConditionalMeatBParts(final List<JesadidoNode> parts) {
        return JesadidoNodeUtils.rearrange(parts, PartDom.class, PartSu.class, PartAl.class, PartFin.class);
    }
    
    public static String getIndefinite(final Translator translator, final Object caseAttribute, final Concept substantiveConcept, final List<Concept> adjectiveConcepts) {
        final TranslationTarget substantiveTarget = translator.getFirstDefaultTarget(substantiveConcept, caseAttribute);
        final String articlePhrase = getIndefiniteArticle(substantiveTarget, caseAttribute);
        final String substantivePhrase = substantiveTarget.getMainPhrase();
        if (adjectiveConcepts.isEmpty()) {
            return String.join(" ", articlePhrase, substantivePhrase);
        } else {
            final String adjectivesPhrase = getIndefiniteAdjectives(translator, caseAttribute, substantiveTarget, adjectiveConcepts);
            return String.join(" ", articlePhrase, adjectivesPhrase, substantivePhrase);
        }
    }
    
    public static String getDefinite(final Translator translator, final Object caseAttribute, final Concept articleConcept, final Concept substantiveConcept, final List<Concept> adjectiveConcepts) {
        final TranslationTarget substantiveTarget = translator.getFirstDefaultTarget(substantiveConcept, caseAttribute);
        final String articlePhrase = getDefiniteArticle(translator, caseAttribute, articleConcept, substantiveTarget);
        final String substantivePhrase = substantiveTarget.getMainPhrase();
        if (adjectiveConcepts.isEmpty()) {
            return String.join(" ", articlePhrase, substantivePhrase);
        } else if (ConceptUtils.isPossessivePronoun(articleConcept)) {
            final String adjectivesPhrase = getIndefiniteAdjectives(translator, caseAttribute, substantiveTarget, adjectiveConcepts);
            return String.join(" ", articlePhrase, adjectivesPhrase, substantivePhrase);
        }
        final String adjectivesPhrase = getDefiniteAdjectives(translator, caseAttribute, substantiveTarget, adjectiveConcepts);
        return String.join(" ", articlePhrase, adjectivesPhrase, substantivePhrase);
    }
    
    private static String getIndefiniteAdjectives(final Translator translator, final Object caseAttribute, final TranslationTarget substantiveTarget, final List<Concept> adjectiveConcepts) {
        final List<String> adjectivePhrases = new LinkedList<>();
        adjectiveConcepts.stream().forEach(adjectiveConcept -> adjectivePhrases.add(getIndefiniteAdjective(translator, caseAttribute, substantiveTarget, adjectiveConcept)));
        return StringUtils.join(", ", " und ", adjectivePhrases);
    }
    
    private static String getIndefiniteAdjective(final Translator translator, final Object caseAttribute, final TranslationTarget substantiveTarget, final Concept adjectiveConcept) {
        if (caseAttribute == De.NOMINATIVE) {
            return getIndefiniteAdjective(translator, substantiveTarget, adjectiveConcept, "er", "e", "es");
        } else if (caseAttribute == De.DATIVE) {
            return getIndefiniteAdjective(translator, substantiveTarget, adjectiveConcept, "en", "en", "en");
        } else {
            return getIndefiniteAdjective(translator, substantiveTarget, adjectiveConcept, "en", "e", "es");
        }
    }
    
    private static String getIndefiniteAdjective(final Translator translator, final TranslationTarget substantiveTarget, final Concept adjectiveConcept, final String masulinSuffix, final String feminieSuffix, final String neuterSuffix) {
        if (substantiveTarget.has(De.MASCULINE)) {
            return translator.getFirstDefaultTarget(adjectiveConcept).getMainPhrase().concat(masulinSuffix);
        } else if (substantiveTarget.has(De.FEMININE)) {
            return translator.getFirstDefaultTarget(adjectiveConcept).getMainPhrase().concat(feminieSuffix);
        }
        return translator.getFirstDefaultTarget(adjectiveConcept).getMainPhrase().concat(neuterSuffix);
    }
    
    private static String getDefiniteAdjectives(final Translator translator, final Object caseAttribute, final TranslationTarget substantiveTarget, final List<Concept> adjectiveConcepts) {
        final List<String> adjectivePhrases = new LinkedList<>();
        adjectiveConcepts.stream().forEach(adjectiveConcept -> adjectivePhrases.add(getDefiniteAdjective(translator, caseAttribute, substantiveTarget, adjectiveConcept)));
        return StringUtils.join(", ", " und ", adjectivePhrases);
    }
    
    private static String getDefiniteAdjective(final Translator translator, final Object caseAttribute, final TranslationTarget substantiveTarget, final Concept adjectiveConcept) {
        if (caseAttribute == De.NOMINATIVE) {
            return getDefiniteAdjective(translator, substantiveTarget, adjectiveConcept, "e", "e", "e");
        } else if (caseAttribute == De.DATIVE) {
            return getDefiniteAdjective(translator, substantiveTarget, adjectiveConcept, "en", "en", "en");
        } else {
            return getDefiniteAdjective(translator, substantiveTarget, adjectiveConcept, "en", "e", "e");
        }
    }
    
    private static String getDefiniteAdjective(final Translator translator, final TranslationTarget substantiveTarget, final Concept adjectiveConcept, final String masulinSuffix, final String feminieSuffix, final String neuterSuffix) {
        if (substantiveTarget.has(De.MASCULINE)) {
            return translator.getFirstDefaultTarget(adjectiveConcept).getMainPhrase().concat(masulinSuffix);
        } else if (substantiveTarget.has(De.FEMININE)) {
            return translator.getFirstDefaultTarget(adjectiveConcept).getMainPhrase().concat(feminieSuffix);
        }
        return translator.getFirstDefaultTarget(adjectiveConcept).getMainPhrase().concat(neuterSuffix);
    }
    
    private static String getIndefiniteArticle(final TranslationTarget substantiveTarget, final Object caseAttribute) {
        if (substantiveTarget.has(De.FEMININE)) {
            return getIndefiniteArticleFeminine(caseAttribute);
        } else if (substantiveTarget.has(De.NEUTER)) {
            return getIndefiniteArticleNeuter(caseAttribute);
        } else {
            return getIndefiniteArticleMasculine(caseAttribute);
        }
    }
    
    private static String getIndefiniteArticleFeminine(final Object caseAttribute) {
        if ((caseAttribute == De.NOMINATIVE) || (caseAttribute == De.ACCUSATIVE)) {
            return "eine";
        } else {
            return "einer";
        }
    }
    
    private static String getIndefiniteArticleNeuter(final Object caseAttribute) {
        if ((caseAttribute == De.NOMINATIVE) || (caseAttribute == De.ACCUSATIVE)) {
            return "ein";
        } else if (caseAttribute == De.DATIVE) {
            return "einem";
        } else {
            return "eines";
        }
    }
    
    private static String getIndefiniteArticleMasculine(final Object caseAttribute) {
        if (caseAttribute == De.NOMINATIVE) {
            return "ein";
        } else if (caseAttribute == De.DATIVE) {
            return "einem";
        } else {
            return "einen";
        }
    }
    
    private static String getDefiniteArticle(final Translator translator, final Object caseAttribute, final Concept articleConcept, final TranslationTarget substantiveTarget) {
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
            if (ConceptUtils.isPersonalPronounSingular(referenceConcept)) {
                return getPossessivePronounSingular(translator, referenceConcept, singularPersonalPronounPhrases.get(0), singularPersonalPronounPhrases.get(1), singularPersonalPronounPhrases.get(2), singularPersonalPronounPhrases.get(3));
            } else if (ConceptUtils.isPersonalPronounPlural(referenceConcept)) {
                return getPossessivePronounPlural(referenceConcept, pluralPersonalPronounPhrases.get(0), pluralPersonalPronounPhrases.get(1), pluralPersonalPronounPhrases.get(2));
            }
        }
        return defaultPhrase;
    }
    
    private static String getPossessivePronounSingular(final Translator translator, final Concept personalPronounConcept, final String miPhrase, final String biPhrase, final String gxiFemininePhrase, final String gxiDefaultPhrase) {
        final ConceptTermination personalPronounConceptTermination = personalPronounConcept.getProperties().getTermination();
        if (personalPronounConceptTermination == ConceptTermination.BI) {
            return biPhrase;
        } else if (personalPronounConceptTermination == ConceptTermination.GXI) {
            return getGxiArticle(translator, personalPronounConcept, gxiFemininePhrase, gxiDefaultPhrase);
        }
        return miPhrase;
    }
    
    private static String getPossessivePronounPlural(final Concept personalPronounConcept, final String niPhrase, final String viPhrase, final String iliPhrase) {
        final ConceptTermination personalPronounConceptTermination = personalPronounConcept.getProperties().getTermination();
        if (personalPronounConceptTermination == ConceptTermination.VI) {
            return viPhrase;
        } else if (personalPronounConceptTermination == ConceptTermination.ILI) {
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

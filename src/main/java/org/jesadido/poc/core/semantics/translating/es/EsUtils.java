/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.es;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.StringUtils;
import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.concepts.ConceptTermination;
import org.jesadido.poc.core.concepts.ConceptUtils;
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
        return NodeUtils.rearrange(parts, PartSu.class, PartDom.class, PartFin.class, PartAl.class);
    }
    
    public static String getIndefinite(final Translator translator, final Concept substantiveConcept, final List<Concept> adjectiveConcepts) {
        final TranslationTarget substantiveTarget = translator.getFirstDefaultTarget(substantiveConcept);
        final String substantivePhrase = substantiveTarget.getMainPhrase();
        final String articlePhrase = getIndefiniteArticle(substantiveTarget);
        if (adjectiveConcepts.isEmpty()) {
            return String.join(" ", articlePhrase, substantivePhrase);
        } else {
            return String.join(" ", articlePhrase, getSubstantiveAdjectives(translator, substantiveTarget, adjectiveConcepts));
        }
    }
    
    public static String getDefinite(final Translator translator, final Concept articleConcept, final Concept substantiveConcept, final List<Concept> adjectiveConcepts) {
        final TranslationTarget substantiveTarget = translator.getFirstDefaultTarget(substantiveConcept);
        final String substantivePhrase = substantiveTarget.getMainPhrase();
        final String articlePhrase = getDefiniteArticle(articleConcept, substantiveTarget);
        if (adjectiveConcepts.isEmpty()) {
            return String.join(" ", articlePhrase, substantivePhrase);
        } else {
            return String.join(" ", articlePhrase, getSubstantiveAdjectives(translator, substantiveTarget, adjectiveConcepts));
        }
    }
    
    private static String getSubstantiveAdjectives(final Translator translator, final TranslationTarget substantiveTarget, final List<Concept> adjectiveConcepts) {
        final String substantivePhrase = substantiveTarget.getMainPhrase();
        final List<TranslationTarget> adjectiveTargets = getAdjectiveTargets(translator, substantiveTarget, adjectiveConcepts);
        final String preposedAdjectives = getPreposedAdjectives(adjectiveTargets);
        final String postposedAdjectives = getPostposedAdjectives(adjectiveTargets);
        return StringUtils.join(" ", Arrays.asList(preposedAdjectives.length() > 0 ? preposedAdjectives : null, substantivePhrase, postposedAdjectives.length() > 0 ? postposedAdjectives : null));
    }
    
    private static String getPreposedAdjectives(final List<TranslationTarget> adjectiveTargets) {
        final List<String> adjectivePhrases = new LinkedList<>();
        adjectiveTargets.stream().filter(adjectiveTarget -> adjectiveTarget.has(Es.PREPOSED)).forEach(adjectiveTarget -> adjectivePhrases.add(adjectiveTarget.getMainPhrase()));
        return StringUtils.join(", ", " y ", adjectivePhrases);
    }
    
    private static String getPostposedAdjectives(final List<TranslationTarget> adjectiveTargets) {
        final List<String> adjectivePhrases = new LinkedList<>();
        adjectiveTargets.stream().filter(adjectiveTarget -> !adjectiveTarget.has(Es.PREPOSED)).forEach(adjectiveTarget -> adjectivePhrases.add(adjectiveTarget.getMainPhrase()));
        return StringUtils.join(", ", " y ", adjectivePhrases);
    }
    
    private static List<TranslationTarget> getAdjectiveTargets(final Translator translator, final TranslationTarget substantiveTarget, final List<Concept> adjectiveConcepts) {
        final List<TranslationTarget> result = new LinkedList<>();
        adjectiveConcepts.stream().forEach(adjectiveConcept -> result.add(getAdjectiveTarget(translator, substantiveTarget, adjectiveConcept)));
        return result;
    }
    
    private static TranslationTarget getAdjectiveTarget(final Translator translator, final TranslationTarget substantiveTarget, final Concept adjectiveConcept) {
        if (substantiveTarget.has(Es.FEMININE)) {
            return translator.getFirstDefaultTarget(adjectiveConcept, Es.FEMININE);
        }
        return translator.getFirstDefaultTarget(adjectiveConcept, Es.MASCULINE);
    }
    
    private static String getIndefiniteArticle(final TranslationTarget substantiveTarget) {
        return substantiveTarget.has(Es.FEMININE) ? "una" : "un";
    }
    
    private static String getDefiniteArticle(final Concept articleConcept, final TranslationTarget substantiveTarget) {
        if (articleConcept.hasReferenceConcept()) {
            final Concept referenceConcept = articleConcept.getReferenceConcept();
            if (ConceptUtils.isPersonalPronounSingular(referenceConcept)) {
                return getPossessivePronounSingular(referenceConcept);
            } else if (ConceptUtils.isPersonalPronounPlural(referenceConcept)) {
                return getPossessivePronounPlural(referenceConcept, substantiveTarget);
            }
        }
        return getDefiniteArticle(substantiveTarget);
    }
    
    private static String getPossessivePronounSingular(final Concept personalPronounConcept) {
        final ConceptTermination personalPronounConceptTermination = personalPronounConcept.getProperties().getTermination();
        if (personalPronounConceptTermination == ConceptTermination.BI) {
            return "tu";
        } else if (personalPronounConceptTermination == ConceptTermination.GXI) {
            return "su";
        }
        return "mi";
    }
    
    private static String getPossessivePronounPlural(final Concept personalPronounConcept, final TranslationTarget substantiveTarget) {
        final ConceptTermination personalPronounConceptTermination = personalPronounConcept.getProperties().getTermination();
        if (personalPronounConceptTermination == ConceptTermination.VI) {
            return substantiveTarget.has(Es.FEMININE) ? "vuestra" : "vuestro";
        } else if (personalPronounConceptTermination == ConceptTermination.ILI) {
            return "su";
        }
        return substantiveTarget.has(Es.FEMININE) ? "nuestra" : "nuestro";
    }
    
    private static String getDefiniteArticle(final TranslationTarget substantiveTarget) {
        return substantiveTarget.has(Es.FEMININE) ? "la" : "el";
    }
}

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
    
    public static String getIndefinite(final Translator translator, final Object caseAttribute, final Concept substantiveConcept, final List<Concept> adjectiveConcepts) {
        final TranslationTarget substantiveTarget = translator.getFirstDefaultTarget(substantiveConcept);
        final String substantivePhrase = substantiveTarget.getMainPhrase();
        final String articlePhrase = getIndefiniteArticle(caseAttribute, substantiveTarget);
        if (adjectiveConcepts.isEmpty()) {
            return String.join(" ", articlePhrase, substantivePhrase);
        } else {
            return String.join(" ", articlePhrase, getSubstantiveAdjectives(translator, substantiveConcept, adjectiveConcepts));
        }
    }
    
    public static String getDefinite(final Translator translator, final Object caseAttribute, final Concept articleConcept, final Concept substantiveConcept, final List<Concept> adjectiveConcepts) {
        final TranslationTarget substantiveTarget = translator.getFirstDefaultTarget(substantiveConcept);
        final String substantivePhrase = substantiveTarget.getMainPhrase();
        final String articlePhrase = getDefiniteArticle(caseAttribute, articleConcept, substantiveTarget);
        if (adjectiveConcepts.isEmpty()) {
            return String.join(" ", articlePhrase, substantivePhrase);
        } else {
            return String.join(" ", articlePhrase, getSubstantiveAdjectives(translator, substantiveConcept, adjectiveConcepts));
        }
    }
    
    private static String getSubstantiveAdjectives(final Translator translator, final Concept substantiveConcept, final List<Concept> adjectiveConcepts) {
        final TranslationTarget substantiveTarget = translator.getFirstDefaultTarget(substantiveConcept);
        final String substantivePhrase = substantiveTarget.getMainPhrase();
        if (adjectiveConcepts.isEmpty()) {
            return substantivePhrase;
        } else {
            final List<TranslationTarget> adjectiveTargets = getAdjectiveTargets(translator, substantiveTarget, adjectiveConcepts);
            final String preposedAdjectives = getPreposedAdjectives(adjectiveTargets);
            final String postposedAdjectives = getPostposedAdjectives(adjectiveTargets);
            return StringUtils.join(" ", Arrays.asList(preposedAdjectives.length() > 0 ? preposedAdjectives : null, substantivePhrase, postposedAdjectives.length() > 0 ? postposedAdjectives : null));
        }
    }
    
    private static String getPreposedAdjectives(final List<TranslationTarget> adjectiveTargets) {
        final List<String> adjectivePhrases = new LinkedList<>();
        adjectiveTargets.stream().filter(adjectiveTarget -> adjectiveTarget.has(Es.PRE)).forEach(adjectiveTarget -> adjectivePhrases.add(adjectiveTarget.getMainPhrase()));
        return StringUtils.join(", ", " y ", adjectivePhrases);
    }
    
    private static String getPostposedAdjectives(final List<TranslationTarget> adjectiveTargets) {
        final List<String> adjectivePhrases = new LinkedList<>();
        adjectiveTargets.stream().filter(adjectiveTarget -> !adjectiveTarget.has(Es.PRE)).forEach(adjectiveTarget -> adjectivePhrases.add(adjectiveTarget.getMainPhrase()));
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
    
    private static String getIndefiniteArticle(final Object caseAttribute, final TranslationTarget substantiveTarget) {
        return getCased(caseAttribute, substantiveTarget.has(Es.FEMININE) ? "una" : "un");
    }
    
    private static String getDefiniteArticle(final Object caseAttribute, final Concept articleConcept, final TranslationTarget substantiveTarget) {
        if (articleConcept.hasReferenceConcept()) {
            final Concept referenceConcept = articleConcept.getReferenceConcept();
            final ConceptTermination referenceConceptTermination = referenceConcept.getProperties().getTermination();
            if (referenceConceptTermination.isOneOf(ConceptTermination.MI, ConceptTermination.BI, ConceptTermination.GXI)) {
                return getSingularPossessivePronoun(caseAttribute, referenceConcept);
            } else if (referenceConceptTermination.isOneOf(ConceptTermination.NI, ConceptTermination.VI, ConceptTermination.ILI)) {
                return getPluralPossessivePronoun(caseAttribute, referenceConcept, substantiveTarget);
            }
        }
        return getDefiniteArticle(caseAttribute, substantiveTarget);
    }
    
    private static String getSingularPossessivePronoun(final Object caseAttribute, final Concept personalPronounConcept) {
        final ConceptTermination personalPronounConceptTermination = personalPronounConcept.getProperties().getTermination();
        if (personalPronounConceptTermination == ConceptTermination.BI) {
            return getCased(caseAttribute, "tu");
        } else if (personalPronounConceptTermination == ConceptTermination.GXI) {
            return getCased(caseAttribute, "su");
        }
        return getCased(caseAttribute, "mi");
    }
    
    private static String getPluralPossessivePronoun(final Object caseAttribute, final Concept personalPronounConcept, final TranslationTarget substantiveTarget) {
        final ConceptTermination personalPronounConceptTermination = personalPronounConcept.getProperties().getTermination();
        if (personalPronounConceptTermination == ConceptTermination.VI) {
            return getCased(caseAttribute, substantiveTarget.has(Es.FEMININE) ? "vuestra" : "vuestro");
        } else if (personalPronounConceptTermination == ConceptTermination.ILI) {
            return getCased(caseAttribute, "su");
        }
        return getCased(caseAttribute, substantiveTarget.has(Es.FEMININE) ? "nuestra" : "nuestro");
    }
    
    private static String getDefiniteArticle(final Object caseAttribute, final TranslationTarget substantiveTarget) {
        if (substantiveTarget.has(Es.FEMININE)) {
            return getCased(caseAttribute, "la");
        } else {
            return caseAttribute == Es.DATIVE ? "al" : "el";
        }
    }
    
    private static String getCased(final Object caseAttribute, final String phrase) {
        return String.format("%s%s", caseAttribute == Es.DATIVE ? "a " : "", phrase);
    }
}

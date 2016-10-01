/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.eo;

import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.StringUtils;
import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.concepts.ConceptTermination;
import org.jesadido.poc.core.concepts.ConceptUtils;
import org.jesadido.poc.core.semantics.translating.TranslationTarget;
import org.jesadido.poc.core.semantics.translating.Translator;
import org.jesadido.poc.core.syntax.tree.Node;

public final class EoUtils {
    
    private EoUtils() {
        // A private utility class constructor
    }
    
    public static List<Node> rearrangeParts(List<Node> parts) {
        return parts;
    }
    
    public static String getIndefinite(final Translator translator, final Object caseAttribute, final Concept substantiveConcept, final List<Concept> adjectiveConcepts) {
        final String substantivePhrase = getCased(caseAttribute, getTarget(translator, substantiveConcept).getMainPhrase());
        if (adjectiveConcepts.isEmpty()) {
            return substantivePhrase;
        } else {
            final String adjectivesPhrase = getCasedAdjectives(translator, caseAttribute, adjectiveConcepts);
            return String.join(" ", adjectivesPhrase, substantivePhrase);
        }
    }
    
    public static String getDefinite(final Translator translator, final Object caseAttribute, final Concept articleConcept, final Concept substantiveConcept, final List<Concept> adjectiveConcepts) {
        final String articlePhrase = getDefiniteArticle(translator, caseAttribute, articleConcept);
        final String substantivePhrase = getCased(caseAttribute, getTarget(translator, substantiveConcept).getMainPhrase());
        if (adjectiveConcepts.isEmpty()) {
            return String.join(" ", articlePhrase, substantivePhrase);
        } else {
            final String adjectivesPhrase = getCasedAdjectives(translator, caseAttribute, adjectiveConcepts);
            return String.join(" ", articlePhrase, adjectivesPhrase, substantivePhrase);
        }
    }
    
    private static TranslationTarget getTarget(final Translator translator, final Concept concept) {
        return translator.getFirstDefaultTarget(concept);
    }
    
    private static String getCased(final Object caseAttribute, final String phrase) {
        return caseAttribute == Eo.ACCUSATIVE ? String.format("%sn", phrase) : phrase;
    }
    
    private static String getCasedAdjectives(final Translator translator, final Object caseAttribute, final List<Concept> adjectiveConcepts) {
        final List<String> adjectivePhrases = new LinkedList<>();
        adjectiveConcepts.stream().forEach(adjectiveConcept -> adjectivePhrases.add(getCased(caseAttribute, getTarget(translator, adjectiveConcept).getMainPhrase())));
        return StringUtils.join(", ", " kaj ", adjectivePhrases);
    }
    
    private static String getDefiniteArticle(final Translator translator, final Object caseAttribute, final Concept articleConcept) {
        if (articleConcept.hasReferenceConcept()) {
            final Concept referenceConcept = articleConcept.getReferenceConcept();
            if (ConceptUtils.isPersonalPronounSingular(referenceConcept)) {
                return getPossessivePronounSingular(translator, caseAttribute, referenceConcept);
            } else if (ConceptUtils.isPersonalPronounPlural(referenceConcept)) {
                return getPossessivePronounPlural(caseAttribute, referenceConcept);
            }
        }
        return "la";
    }
    
    private static String getPossessivePronounSingular(final Translator translator, final Object caseAttribute, final Concept personalPronounConcept) {
        final ConceptTermination personalPronounConceptTermination = personalPronounConcept.getProperties().getTermination();
        if (personalPronounConceptTermination == ConceptTermination.BI) {
            return getCased(caseAttribute, "via");
        } else if (personalPronounConceptTermination == ConceptTermination.GXI) {
            return getGxiArticle(translator, caseAttribute, personalPronounConcept);
        }
        return getCased(caseAttribute, "mia");
    }
    
    private static String getPossessivePronounPlural(final Object caseAttribute, final Concept personalPronounConcept) {
        final ConceptTermination personalPronounConceptTermination = personalPronounConcept.getProperties().getTermination();
        if (personalPronounConceptTermination == ConceptTermination.VI) {
            return getCased(caseAttribute, "via");
        } else if (personalPronounConceptTermination == ConceptTermination.ILI) {
            return getCased(caseAttribute, "ilia");
        }
        return getCased(caseAttribute, "nia");
    }
    
    private static String getGxiArticle(final Translator translator, final Object caseAttribute, final Concept gxiConcept) {
        if (gxiConcept.hasReferenceConcept()) {
            final Concept gxiReferenceConcept = gxiConcept.getReferenceConcept();
            final TranslationTarget gxiReferenceTarget = translator.getFirstDefaultTarget(gxiReferenceConcept);
            if (gxiReferenceTarget.has(Eo.FEMININE)) {
                return getCased(caseAttribute, "ŝia");
            } else if (gxiReferenceTarget.has(Eo.MASCULINE)) {
                return getCased(caseAttribute, "lia");
            }
        }
        return getCased(caseAttribute, "ĝia");
    }
}

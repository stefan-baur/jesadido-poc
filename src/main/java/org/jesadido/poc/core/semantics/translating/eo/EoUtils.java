/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.eo;

import java.util.List;
import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.concepts.ConceptTermination;
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
    
    public static String getIndefinite(final Translator translator, final Object caseAttribute, final Concept substantiveConcept, final Concept ... adjectiveConcepts) {
        final String substantivePhrase = getCased(caseAttribute, getTarget(translator, substantiveConcept).getMainPhrase());
        if (adjectiveConcepts.length > 0) {
            final String adjectivesPhrase = getCasedAdjectives(translator, caseAttribute, adjectiveConcepts);
            return String.join(" ", adjectivesPhrase, substantivePhrase);
        }
        return substantivePhrase;
    }
    
    public static String getDefinite(final Translator translator, final Object caseAttribute, final Concept articleConcept, final Concept substantiveConcept, final Concept ... adjectiveConcepts) {
        final String articlePhrase = getDefiniteArticle(translator, caseAttribute, articleConcept);
        final String substantivePhrase = getCased(caseAttribute, getTarget(translator, substantiveConcept).getMainPhrase());
        if (adjectiveConcepts.length > 0) {
            final String adjectivesPhrase = getCasedAdjectives(translator, caseAttribute, adjectiveConcepts);
            return String.join(" ", articlePhrase, adjectivesPhrase, substantivePhrase);
        }
        return String.join(" ", articlePhrase, substantivePhrase);
    }
    
    private static TranslationTarget getTarget(final Translator translator, final Concept concept) {
        return translator.getFirstDefaultTarget(concept);
    }
    
    private static String getCased(final Object caseAttribute, final String phrase) {
        return caseAttribute == Eo.ACCUSATIVE ? String.format("%sn", phrase) : phrase;
    }
    
    private static String getCasedAdjectives(final Translator translator, final Object caseAttribute, final Concept ... adjectiveConcepts) {
        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < adjectiveConcepts.length; i++) {
            if (i > 0) {
                if (i == adjectiveConcepts.length - 1) {
                    result.append(" kaj ");
                } else {
                    result.append(", ");
                }
            }
            result.append(getCased(caseAttribute, getTarget(translator, adjectiveConcepts[i]).getMainPhrase()));
        }
        return result.toString();
    }
    
    private static String getDefiniteArticle(final Translator translator, final Object caseAttribute, final Concept articleConcept) {
        if (articleConcept.hasReferenceConcept()) {
            final Concept referenceConcept = articleConcept.getReferenceConcept();
            final ConceptTermination referenceConceptTermination = referenceConcept.getProperties().getTermination();
            if (referenceConceptTermination.isOneOf(ConceptTermination.MI, ConceptTermination.BI, ConceptTermination.GXI)) {
                return getSingularPossessivePronoun(translator, caseAttribute, referenceConcept);
            } else if (referenceConceptTermination.isOneOf(ConceptTermination.NI, ConceptTermination.VI, ConceptTermination.ILI)) {
                return getPluralPossessivePronoun(caseAttribute, referenceConcept);
            }
        }
        return "la";
    }
    
    private static String getSingularPossessivePronoun(final Translator translator, final Object caseAttribute, final Concept personalPronounConcept) {
        final ConceptTermination personalPronounConceptTermination = personalPronounConcept.getProperties().getTermination();
        if (personalPronounConceptTermination == ConceptTermination.BI) {
            return getCased(caseAttribute, "via");
        } else if (personalPronounConceptTermination == ConceptTermination.GXI) {
            return getGxiArticle(translator, caseAttribute, personalPronounConcept);
        }
        return getCased(caseAttribute, "mia");
    }
    
    private static String getPluralPossessivePronoun(final Object caseAttribute, final Concept personalPronounConcept) {
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

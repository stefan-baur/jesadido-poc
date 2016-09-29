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
    
    public static String getIndefinite(final Translator translator, final Eo caseAttribute, final Concept substantiveConcept) {
        final TranslationTarget substantiveTarget = translator.getFirstDefaultTarget(substantiveConcept);
        return getCased(caseAttribute, substantiveTarget.getMainPhrase());
    }
    
    public static String getDefinite(final Translator translator, final Eo caseAttribute, final Concept articleConcept, final Concept substantiveConcept) {
        final TranslationTarget substantiveTarget = translator.getFirstDefaultTarget(substantiveConcept);
        return String.join(" ", getDefiniteArticle(translator, caseAttribute, articleConcept), getCased(caseAttribute, substantiveTarget.getMainPhrase()));
    }
    
    private static String getCased(final Eo caseAttribute, final String phrase) {
        return caseAttribute == Eo.ACCUSATIVE ? String.format("%sn", phrase) : phrase;
    }
    
    private static String getDefiniteArticle(final Translator translator, final Eo caseAttribute, final Concept articleConcept) {
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
    
    private static String getSingularPossessivePronoun(final Translator translator, final Eo caseAttribute, final Concept personalPronounConcept) {
        final ConceptTermination personalPronounConceptTermination = personalPronounConcept.getProperties().getTermination();
        if (personalPronounConceptTermination == ConceptTermination.BI) {
            return getCased(caseAttribute, "via");
        } else if (personalPronounConceptTermination == ConceptTermination.GXI) {
            return getGxiArticle(translator, caseAttribute, personalPronounConcept);
        }
        return getCased(caseAttribute, "mia");
    }
    
    private static String getPluralPossessivePronoun(final Eo caseAttribute, final Concept personalPronounConcept) {
        final ConceptTermination personalPronounConceptTermination = personalPronounConcept.getProperties().getTermination();
        if (personalPronounConceptTermination == ConceptTermination.VI) {
            return getCased(caseAttribute, "via");
        } else if (personalPronounConceptTermination == ConceptTermination.ILI) {
            return getCased(caseAttribute, "ilia");
        }
        return getCased(caseAttribute, "nia");
    }
    
    private static String getGxiArticle(final Translator translator, final Eo caseAttribute, final Concept gxiConcept) {
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

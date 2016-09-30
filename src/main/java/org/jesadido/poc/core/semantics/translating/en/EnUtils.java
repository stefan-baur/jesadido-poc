/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.en;

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

public final class EnUtils {
    
    private EnUtils() {
        // A private utility class constructor
    }
    
    public static List<Node> rearrangeParts(final List<Node> parts) {
        return NodeUtils.rearrange(parts, PartSu.class, PartDom.class, PartAl.class, PartFin.class);
    }
    
    public static String getIndefinite(final Translator translator, final Concept substantiveConcept, final List<Concept> adjectiveConcepts) {
        final TranslationTarget substantiveTarget = translator.getFirstDefaultTarget(substantiveConcept);
        final String substantivePhrase = substantiveTarget.getMainPhrase();
        if (adjectiveConcepts.isEmpty()) {
            return String.join(" ", getIndefiniteArticle(substantivePhrase), substantivePhrase);
        } else {
            final String adjectivesPhrase = getAdjectives(translator, adjectiveConcepts);
            return String.join(" ", getIndefiniteArticle(adjectivesPhrase), adjectivesPhrase, substantivePhrase);
        }
    }
    
    public static String getDefinite(final Translator translator, final Concept articleConcept, final Concept substantiveConcept, final List<Concept> adjectiveConcepts) {
        final TranslationTarget substantiveTarget = translator.getFirstDefaultTarget(substantiveConcept);
        final String substantivePhrase = substantiveTarget.getMainPhrase();
        final String articlePhrase = getDefiniteArticle(translator, articleConcept);
        if (adjectiveConcepts.isEmpty()) {
            return String.join(" ", articlePhrase, substantivePhrase);
        } else {
            final String adjectivesPhrase = getAdjectives(translator, adjectiveConcepts);
            return String.join(" ", articlePhrase, adjectivesPhrase, substantivePhrase);
        }
    }
    
    private static String getAdjectives(final Translator translator, final List<Concept> adjectiveConcepts) {
        final List<String> adjectivePhrases = new LinkedList<>();
        adjectiveConcepts.stream().forEach(adjectiveConcept -> adjectivePhrases.add(translator.getFirstDefaultTarget(adjectiveConcept).getMainPhrase()));
        return StringUtils.join(", ", " and ", adjectivePhrases);
    }
    
    private static String getIndefiniteArticle(final String followerPhrase) {
        return isVocalical(followerPhrase) ? "an" : "a";
    }
    
    private static String getDefiniteArticle(final Translator translator, final Concept articleConcept) {
        if (articleConcept.hasReferenceConcept()) {
            final Concept referenceConcept = articleConcept.getReferenceConcept();
            final ConceptTermination referenceConceptTermination = referenceConcept.getProperties().getTermination();
            if (referenceConceptTermination.isOneOf(ConceptTermination.MI, ConceptTermination.BI, ConceptTermination.GXI)) {
                return getSingularPossessivePronoun(translator, referenceConcept);
            } else if (referenceConcept.getProperties().getTermination().isOneOf(ConceptTermination.NI, ConceptTermination.VI, ConceptTermination.ILI)) {
                return getPluralPossessivePronoun(referenceConcept);
            }
        }
        return "the";
    }
    
    private static String getSingularPossessivePronoun(final Translator translator, final Concept personalPronounConcept) {
        final ConceptTermination referenceConceptTermination = personalPronounConcept.getProperties().getTermination();
        if (referenceConceptTermination == ConceptTermination.BI) {
            return "your";
        } else if (referenceConceptTermination == ConceptTermination.GXI) {
            return getGxiArticle(translator, personalPronounConcept);
        }
        return "my";
    }
    
    private static String getPluralPossessivePronoun(final Concept personalPronounConcept) {
        final ConceptTermination personalPronounConceptTermination = personalPronounConcept.getProperties().getTermination();
        if (personalPronounConceptTermination == ConceptTermination.VI) {
            return "your";
        } else if (personalPronounConceptTermination == ConceptTermination.ILI) {
            return "their";
        }
        return "our";
    }
    
    private static String getGxiArticle(final Translator translator, final Concept gxiConcept) {
        if (gxiConcept.hasReferenceConcept()) {
            final Concept gxiReferenceConcept = gxiConcept.getReferenceConcept();
            final TranslationTarget gxiReferenceTarget = translator.getFirstDefaultTarget(gxiReferenceConcept);
            if (gxiReferenceTarget.has(En.FEMININE)) {
                return "her";
            } else if (gxiReferenceTarget.has(En.MASCULINE)) {
                return "his";
            }
        }
        return "its";
    }
    
    private static boolean isVocalical(final String phrase) {
        return phrase != null && phrase.length() > 0 && "aeio".contains(Character.toString(phrase.toLowerCase().charAt(0)));
    }
}

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.fr;

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

public final class FrUtils {
    
    private FrUtils() {
        // A private utility class constructor
    }
    
    public static List<Node> rearrangeParts(final List<Node> parts) {
        return NodeUtils.rearrange(parts, PartSu.class, PartDom.class, PartAl.class, PartFin.class);
    }
    
    public static String getIndefinite(final Translator translator, final Fr caseAttribute, final Concept substantiveConcept) {
        final TranslationTarget substantiveTarget = translator.getFirstDefaultTarget(substantiveConcept);
        return getCased(caseAttribute, String.join(" ", getIndefiniteArticle(substantiveTarget), substantiveTarget.getMainPhrase()));
    }
    
    public static String getDefinite(final Translator translator, final Fr caseAttribute, final Concept articleConcept, final Concept substantiveConcept) {
        final TranslationTarget substantiveTarget = translator.getFirstDefaultTarget(substantiveConcept);
        return getCased(caseAttribute, getDefiniteArticleSubstantive(articleConcept, substantiveTarget));
    }
    
    private static String getIndefiniteArticle(final TranslationTarget substantiveTarget) {
        if (substantiveTarget.has(Fr.FEMININE)) {
            return "une";
        } else {
            return "un";
        }
    }
    
    private static String getDefiniteArticleSubstantive(final Concept articleConcept, final TranslationTarget substantiveTarget) {
        final String substantivePhrase = substantiveTarget.getMainPhrase();
        if (articleConcept.hasReferenceConcept()) {
            final Concept referenceConcept = articleConcept.getReferenceConcept();
            final ConceptTermination referenceConceptTermination = referenceConcept.getProperties().getTermination();
            if (referenceConceptTermination.isOneOf(ConceptTermination.MI)) {
                return getGendered(substantiveTarget, String.format("mon %s", substantivePhrase), getVocalized("ma", "m", substantivePhrase));
            } else if (referenceConceptTermination.isOneOf(ConceptTermination.BI)) {
                return getGendered(substantiveTarget, String.format("ton %s", substantivePhrase), getVocalized("ta", "t", substantivePhrase));
            } else if (referenceConceptTermination.isOneOf(ConceptTermination.GXI)) {
                return getGendered(substantiveTarget, String.format("son %s", substantivePhrase), getVocalized("sa", "s", substantivePhrase));
            }
        }
        return getGendered(substantiveTarget, getVocalized("le", "l", substantivePhrase), getVocalized("la", "l", substantivePhrase));
    }
    
    private static String getGendered(final TranslationTarget substantiveTarget, final String masculinePhrase, final String femininePhrase) {
        return substantiveTarget.has(Fr.FEMININE) ? femininePhrase : masculinePhrase;
    }
    
    private static String getVocalized(final String prefixPhrase, final String shortPrefixPhrase, final String followerPhrase) {
        return isVocalical(followerPhrase) ? String.join("'", shortPrefixPhrase, followerPhrase) : String.join(" ", prefixPhrase, followerPhrase);
    }
    
    private static boolean isVocalical(final String followerPhrase) {
        if (followerPhrase != null && followerPhrase.length() > 0) {
            final String firstCharOfFollower = Character.toString(followerPhrase.charAt(0));
            return ("aeioué".contains(firstCharOfFollower)) || ("ha|he|hi|ho|hu".contains(firstCharOfFollower));
        }
        return false;
    }
    
    private static String getCased(final Fr caseAttribute, final String phrase) {
        return String.format("%s%s", caseAttribute == Fr.DATIVE ? "à " : "", phrase);
    }
}

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.fr;

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

public final class FrUtils {
    
    private FrUtils() {
        // A private utility class constructor
    }
    
    public static List<JesadidoNode> rearrangeParts(final List<JesadidoNode> parts) {
        return JesadidoNodeUtils.rearrange(parts, PartSu.class, PartDom.class, PartFin.class, PartAl.class);
    }
    
    public static String getIndefinite(final Translator translator, final Concept substantiveConcept, final List<Concept> adjectiveConcepts) {
        final TranslationTarget substantiveTarget = translator.getFirstDefaultTarget(substantiveConcept);
        return String.join(" ", getIndefiniteArticle(substantiveTarget), getSubstantiveAdjectives(translator, substantiveTarget, adjectiveConcepts));
    }
    
    public static String getDefinite(final Translator translator, final Concept articleConcept, final Concept substantiveConcept, final List<Concept> adjectiveConcepts) {
        final TranslationTarget substantiveTarget = translator.getFirstDefaultTarget(substantiveConcept);
        return getDefiniteArticleSubstantiveAdjectives(translator, articleConcept, substantiveTarget, adjectiveConcepts);
    }
    
    private static String getSubstantiveAdjectives(final Translator translator, final TranslationTarget substantiveTarget, final List<Concept> adjectiveConcepts) {
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
        adjectiveTargets.stream().filter(adjectiveTarget -> adjectiveTarget.has(Fr.PREPOSED)).forEach(adjectiveTarget -> adjectivePhrases.add(adjectiveTarget.getMainPhrase()));
        return StringUtils.join(", ", " et ", adjectivePhrases);
    }
    
    private static String getPostposedAdjectives(final List<TranslationTarget> adjectiveTargets) {
        final List<String> adjectivePhrases = new LinkedList<>();
        adjectiveTargets.stream().filter(adjectiveTarget -> !adjectiveTarget.has(Fr.PREPOSED)).forEach(adjectiveTarget -> adjectivePhrases.add(adjectiveTarget.getMainPhrase()));
        return StringUtils.join(", ", " et ", adjectivePhrases);
    }
    
    private static List<TranslationTarget> getAdjectiveTargets(final Translator translator, final TranslationTarget substantiveTarget, final List<Concept> adjectiveConcepts) {
        final List<TranslationTarget> result = new LinkedList<>();
        adjectiveConcepts.stream().forEach(adjectiveConcept -> result.add(getAdjectiveTarget(translator, substantiveTarget, adjectiveConcept)));
        return result;
    }
    
    private static TranslationTarget getAdjectiveTarget(final Translator translator, final TranslationTarget substantiveTarget, final Concept adjectiveConcept) {
        if (substantiveTarget.has(Fr.FEMININE)) {
            return translator.getFirstDefaultTarget(adjectiveConcept, Fr.FEMININE);
        }
        return translator.getFirstDefaultTarget(adjectiveConcept, Fr.MASCULINE);
    }
    
    private static String getIndefiniteArticle(final TranslationTarget substantiveTarget) {
        if (substantiveTarget.has(Fr.FEMININE)) {
            return "une";
        } else {
            return "un";
        }
    }
    
    private static String getDefiniteArticleSubstantiveAdjectives(final Translator translator, final Concept articleConcept, final TranslationTarget substantiveTarget, final List<Concept> adjectiveConcepts) {
        final String followerPhrase = getSubstantiveAdjectives(translator, substantiveTarget, adjectiveConcepts);
        if (articleConcept.hasReferenceConcept()) {
            final Concept referenceConcept = articleConcept.getReferenceConcept();
            if (ConceptUtils.isPersonalPronounSingular(referenceConcept)) {
                return getSingularPossessivePronounedSubstantive(referenceConcept, substantiveTarget, followerPhrase);
            } else if (ConceptUtils.isPersonalPronounPlural(referenceConcept)) {
                return getPluralPossessivePronounedSubstantive(referenceConcept, followerPhrase);
            }
        }
        return getGendered(substantiveTarget, getVocalized("le", "l", followerPhrase), getVocalized("la", "l", followerPhrase));
    }
    
    private static String getSingularPossessivePronounedSubstantive(final Concept personalPronounConcept, final TranslationTarget substantiveTarget, final String followerPhrase) {
        final ConceptTermination personalPronounConceptTermination = personalPronounConcept.getProperties().getTermination();
        if (personalPronounConceptTermination == ConceptTermination.BI) {
            return getGendered(substantiveTarget, String.format("ton %s", followerPhrase), getVocalized("ta", "t", followerPhrase));
        } else if (personalPronounConceptTermination == ConceptTermination.GXI) {
            return getGendered(substantiveTarget, String.format("son %s", followerPhrase), getVocalized("sa", "s", followerPhrase));
        }
        return getGendered(substantiveTarget, String.format("mon %s", followerPhrase), getVocalized("ma", "m", followerPhrase));
    }
    
    private static String getPluralPossessivePronounedSubstantive(final Concept personalPronounConcept, final String followerPhrase) {
        final ConceptTermination personalPronounConceptTermination = personalPronounConcept.getProperties().getTermination();
        if (personalPronounConceptTermination == ConceptTermination.VI) {
            return String.format("votre %s", followerPhrase);
        } else if (personalPronounConceptTermination == ConceptTermination.ILI) {
            return String.format("leur %s", followerPhrase);
        }
        return String.format("notre %s", followerPhrase);
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
}

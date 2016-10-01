/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.concepts;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.StringUtils;
import org.jesadido.poc.core.Language;

public final class ConceptUtils {
    
    /**
     * The separator (a single white-space) for the concatenation of concept
     * phrases.
     */
    public static final String DEFAULT_CONCEPT_DELIMITER = " ";
    
    private ConceptUtils() {
        // A private utility class constructor.
    }
        
    /**
     * Concats the given morphemes to a typical concept phrase with upper-cased
     * morphemes.
     * @param morphemes The given morphemes.
     * @return The concept phrase.
     */
    public static final String toConceptPhrase(final List<String> morphemes) {
        return String.join("", StringUtils.up(morphemes));
    }
    
    /**
     * Returns a new concept instance by the given concept phrase.
     * @param conceptPhrase The given concept phrase.
     * @return The new concept instance.
     */
    public static final Concept parseToConcept(final String conceptPhrase) {
        return new Concept(new ConceptBuilder(parseToMorphemes(conceptPhrase)));
    }
    
    /**
     * Returns the parsed concept phrase splitted into its morphemes.
     * @param conceptPhrase The concept phrase/lexeme.
     * @return The morpheme list.
     */
    public static final List<String> parseToMorphemes(final String conceptPhrase) {
        final List<String> result = new LinkedList<>();
        final String escaper = StringUtils.escaper("1", conceptPhrase);
        final String escapedfullPhrase = conceptPhrase.replace("\\$", escaper);
        final String[] escapedBasePhrases = escapedfullPhrase.split("\\$");
        for (int i = 0; i < escapedBasePhrases.length; i++) {
            if (i > 0) {
                result.add("$");
            }
            result.addAll(parseBasePhrase(escapedBasePhrases[i].replace(escaper, "\\$")));
        }
        return result;
    }
    
    private static List<String> parseBasePhrase(final String basePhrase) {
        final List<String> result = new LinkedList<>();
        if (basePhrase.contains("'")) {
            final int beginIndex = basePhrase.indexOf('\'');
            final int endIndex = basePhrase.lastIndexOf('\'');
            final String prefix = basePhrase.substring(0, beginIndex);
            if (ConceptUtils.checkLanguageMorpheme(prefix)) {
                result.add(prefix);
            }
            result.add(basePhrase.substring(beginIndex, endIndex + 1));
            final String suffix = basePhrase.substring(endIndex + 1, basePhrase.length());
            if (suffix.length() > 0) {
                result.addAll(parseBaseFragment(suffix));
            }
        } else {
            result.addAll(parseBaseFragment(basePhrase));
        }
        return result;
    }
    
    private static List<String> parseBaseFragment(final String baseFragment) {
        final List<String> result = new LinkedList<>();
        boolean number = false;
        StringBuilder morphemeBuilder = new StringBuilder();
        for (int i = 0; i < baseFragment.length(); i++) {
            final char c = baseFragment.charAt(i);
            if (Character.isUpperCase(c)) {
                if (morphemeBuilder.length() > 0) {
                    result.add(morphemeBuilder.toString());
                    morphemeBuilder = new StringBuilder();
                }
                morphemeBuilder.append(c);
                number = false;
            } else if (Character.isLowerCase(c)) {
                morphemeBuilder.append(c);
                number = false;
            } else if (Character.isDigit(c)) {
                if (!number && morphemeBuilder.length() > 0) {
                    result.add(morphemeBuilder.toString());
                    morphemeBuilder = new StringBuilder();
                }
                morphemeBuilder.append(c);
                number = true;
            } else {
                if (morphemeBuilder.length() > 0) {
                    result.add(morphemeBuilder.toString());
                    morphemeBuilder = new StringBuilder();
                }
                morphemeBuilder.append(c);
                number = false;
            }
        }
        if (morphemeBuilder.length() > 0) {
            result.add(morphemeBuilder.toString());
        }
        return result;
    }
    
    /**
     * Checks whether the given morpheme phrase is parsable as a parameter.
     * @param morpheme The given morpheme phrase.
     * @return <code>true</code> if the given morpheme phrase is parsable.
     */
    public static final boolean checkParameterMorpheme(final String morpheme) {
        return morpheme != null && morpheme.length() > 1 && morpheme.startsWith("'") && morpheme.endsWith("'");
    }
    
    /**
     * Parses the given parameter morpheme phrase to its plain text phrases. Use
     * <code>checkParameterMorpheme()</code> before!
     * @param parameterMorpheme The given parameter morpheme phrase.
     * @return The parsed plain text phrases.
     */
    public static final List<String> parseToPlainTextList(final String parameterMorpheme) {
        final List<String> result = new LinkedList<>();
        final String morpheme = parameterMorpheme == null ? "" : parameterMorpheme;
        final String escaper0 = StringUtils.escaper("0", morpheme);
        final String escaper1 = StringUtils.escaper("1", morpheme);
        final String escaper2 = StringUtils.escaper("2", morpheme);
        final String escaper3 = StringUtils.escaper("3", morpheme);
        final String escapedMorpheme = morpheme.replace("\\\\", escaper0).replace("\\'", escaper1).replace("\\|", escaper2).replace("\\$", escaper3);
        for (final String listItemPhrase : escapedMorpheme.split("\\|")) {
            final String[] snippets = listItemPhrase.split("'");
            final StringBuilder listPhraseBuilder = new StringBuilder();
            for (int i = 1; i < snippets.length; i++) {
                if (i > 1) {
                    listPhraseBuilder.append(' ');
                }
                listPhraseBuilder.append(snippets[i]);
            }
            result.add(listPhraseBuilder.toString().replace(escaper0, "\\").replace(escaper1, "'").replace(escaper2, "|").replace(escaper3, "$"));
        }
        return result;
    }
    
    /**
     * Checks whether the given morpheme phrase is parsable as a language.
     * @param morpheme The given morpheme phrase.
     * @return <code>true</code> if the given morpheme phrase is parsable.
     */
    public static final boolean checkLanguageMorpheme(final String morpheme) {
        return morpheme != null && morpheme.length() == 4 && morpheme.startsWith("/") && morpheme.endsWith("/");
    }
    
    /**
     * Returns a language morpheme phrase according to the given language.
     * @param language The given language.
     * @return The language morpheme pharse.
     */
    public static final String toLanguageMorpheme(final Language language) {
        return String.format("/%s/", language.getCode());
    }
    
    /**
     * Parses the given language morpheme phrase to its language. Use
     * <code>checkLanguageMorpheme()</code> before!
     * @param languageMorpheme The given language morpheme phrase.
     * @return The parsed language (default: <code>Language.JI</code>).
     */
    public static final Language parseToLanguage(final String languageMorpheme) {
        for (final Language result : Language.values()) {
            if (String.format("/%s/", result.getCode()).equals(languageMorpheme)) {
                return result;
            }
        }
        return Language.JI;
    }
    
    /**
     * Returns a concatenation of the given concepts separated with the given
     * delimiter.
     * @param delimiter The given delimiter.
     * @param concepts The given delimiter.
     * @return The concatenation of the full phrases of the given concetps.
     */
    public static String join(final String delimiter, final List<Concept> concepts) {
        final List<String> result = new LinkedList<>();
        if (concepts != null) {
            concepts.stream().filter(concept -> concept != null).forEach(concept -> result.add(concept.getFullPhrase()));
        }
        return String.join(delimiter != null ? delimiter : DEFAULT_CONCEPT_DELIMITER, result);
    }
    
    /**
     * Returns a concatenation of the given concepts separated with the default
     * delimiter (single white-space) defined under the constant
     * <code>DEFAULT_CONCEPT_DELIMITER</code>.
     * @param concepts The given concepts.
     * @return The standard concatenation of the given concepts.
     */
    public static String join(final List<Concept> concepts) {
        return join(DEFAULT_CONCEPT_DELIMITER, concepts);
    }
    
    /**
     * Returns a concatenation of the given concepts separated with the default
     * delimiter (single white-space) defined under the constant
     * <code>DEFAULT_CONCEPT_DELIMITER</code>.
     * @param concepts The given concepts.
     * @return The standard concatenation of the given concepts.
     */
    public static String join(final Concept ... concepts) {
        return join(Arrays.asList(concepts));
    }
    
    /**
     * Determines whether the given concept is a personal pronoun.
     * @param concept The given concept.
     * @return <code>true</code> if the concept is a personal pronoun.
     */
    public static boolean isPersonalPronoun(final Concept concept) {
        return isPersonalPronounSingular(concept) || isPersonalPronounPlural(concept);
    }
    
    /**
     * Determines whether the given concept is a singular personal pronoun.
     * @param concept The given concept.
     * @return <code>true</code> if the concept is a singular personal pronoun.
     */
    public static boolean isPersonalPronounSingular(final Concept concept) {
        return concept.getProperties().getTermination().isOneOf(ConceptTermination.MI, ConceptTermination.BI, ConceptTermination.GXI);
    }
    
    /**
     * Determines whether the given concept is a plural personal pronoun.
     * @param concept The given concept.
     * @return <code>true</code> if the concept is a plural personal pronoun.
     */
    public static boolean isPersonalPronounPlural(final Concept concept) {
        return concept.getProperties().getTermination().isOneOf(ConceptTermination.NI, ConceptTermination.VI, ConceptTermination.ILI);
    }
    
    /**
     * Determines whether the given concept is a possessive pronoun.
     * @param concept The given concept.
     * @return <code>true</code> if the concept is a possessive pronoun.
     */
    public static boolean isPossessivePronoun(final Concept concept) {
        if (concept.getProperties().getTermination() == ConceptTermination.LA && concept.hasReferenceConcept()) {
            return isPersonalPronoun(concept.getReferenceConcept());
        }
        return false;
    }
    
    /**
     * Determines whether the given concept is a singular possessive pronoun.
     * @param concept The given concept.
     * @return <code>true</code> if the concept is a singular possessive
     * pronoun.
     */
    public static boolean isPossessivePronounSingular(final Concept concept) {
        if (concept.getProperties().getTermination() == ConceptTermination.LA && concept.hasReferenceConcept()) {
            return isPersonalPronounSingular(concept.getReferenceConcept());
        }
        return false;
    }
    
    /**
     * Determines whether the given concept is a plural possessive pronoun.
     * @param concept The given concept.
     * @return <code>true</code> if the concept is a plural possessive pronoun.
     */
    public static boolean isPossessivePronounPlural(final Concept concept) {
        if (concept.getProperties().getTermination() == ConceptTermination.LA && concept.hasReferenceConcept()) {
            return isPersonalPronounPlural(concept.getReferenceConcept());
        }
        return false;
    }
}

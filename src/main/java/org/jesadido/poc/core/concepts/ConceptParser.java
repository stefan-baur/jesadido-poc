/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.concepts;

import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.CoreUtils;

/**
 * This <code>ConceptParser</code> class implements the parser for
 * <b>Jesadido</b> lexems (concept phrases).
 */
public final class ConceptParser {
    
    private ConceptParser() {
        // A private utility class constructor.
    }
    
    /**
     * Returns a new concept instance by the given concept phrase.
     * @param conceptPhrase The given concept phrase.
     * @return The new concept instance.
     */
    public static final Concept parse(final String conceptPhrase) {
        return new Concept(new ConceptBuilder(parseToMorphemes(conceptPhrase)));
    }
    
    /**
     * Returns the parsed concept phrase splitted into its morphemes.
     * @param conceptPhrase The concept phrase/lexem.
     * @return The morpheme list.
     */
    public static final List<String> parseToMorphemes(final String conceptPhrase) {
        final List<String> result = new LinkedList<>();
        final String escaper = CoreUtils.escaper("1", conceptPhrase);
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
            if (prefix.startsWith("/") && prefix.endsWith("/")) {
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
}

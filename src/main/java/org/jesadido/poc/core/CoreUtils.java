/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core;

import java.util.LinkedList;
import java.util.List;

/**
 * This <code>CoreUtils</code> class is a util-class e.g. for string-formatting.
 */
public final class CoreUtils {
    
    private CoreUtils() {
        // A private utility class constructor.
    }
    
    /**
     * Returns the given string whereby the first charakter is upper-cased.
     * @param value The given string.
     * @return The given string with upper-cased first character.
     */
    public static final String up(final String value) {
        return (value == null || value.length() == 0) ? "" : value.substring(0, 1).toUpperCase() + value.substring(1);
    }
    
    /**
     * Returns a new list which contains items with upper-cased first character.
     * @param items The given items (not null).
     * @return The new list, each item of the result is upper-cased.
     */
    public static final List<String> up(final List<String> items) {
        final List<String> result = new LinkedList<>();
        items.stream().forEach(item -> result.add(up(item)));
        return result;
    }
    
    /**
     * Gernerates a string which is not a part of the given phrase. This is
     * needful for string replacements and its back-replacements.
     * @param escaperPrefix The prefix of the generated result.
     * @param phrase Any phrase which is not null.
     * @return A string which is not containing to the given phrase.
     */
    public static final String escaper(final String escaperPrefix, final String phrase) {
        String result = escaperPrefix == null ? "_" : escaperPrefix;
        while (phrase.contains(result)) {
            result = result.concat("_");
        }
        return result;
    }
    
    /**
     * Concats the given morphemes to a typical concept phrase with upper-cased
     * morphemes.
     * @param morphemes The given morphemes.
     * @return The concept phrase.
     */
    public static final String toConceptPhrase(final List<String> morphemes) {
        return String.join("", up(morphemes));
    }
}

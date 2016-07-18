/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core;

/**
 * This <code>CoreUtils</code> class is a util-class e.g. for string-formatting.
 */
public final class CoreUtils {
    
    private CoreUtils() {
        // Unused.
    }
    
    /**
     * Returns the given string whereby the first charakter is upper-cased.
     * @param value The given string.
     * @return The given string with upper-cased first charakter.
     */
    public static String up(final String value) {
        return (value == null || value.length() == 0) ? "" : value.substring(0, 1).toUpperCase() + value.substring(1);
    }
    
    /**
     * Return the given string without the last character.
     * @param value The given string.
     * @return The given string without the last character. An empty string, if
     * the given string is empty or null.
     */
    public static String cut(final String value) {
        return (value == null || value.length() == 0) ? "" : value.substring(0, value.length() - 1);
    }
    
    /**
     * Gernerates a string which is not a part of the given phrase. This is needful for string replacements and its back-replacements.
     * @param escaperPrefix The prefix of the generated result.
     * @param phrase Any phrase which is not null.
     * @return A string which is not containing to the given phrase.
     */
    public static String escaper(final String escaperPrefix, final String phrase) {
        String result = escaperPrefix;
        while (phrase.contains(result)) {
            result = result.concat("_");
        }
        return result;
    }
}

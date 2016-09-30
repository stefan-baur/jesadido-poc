/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core;

import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

/**
 * This <code>StringUtils</code> class is a utility class often used for
 * framework-specific string operations.
 */
public final class StringUtils {
    
    /**
     * The charset of this language framework is <b>UFT-8</b>. If this charset
     * is not supported, you can not use this framework.
     */
    public static final Charset UTF_8 = Charset.availableCharsets().get("UTF-8");
    
    private StringUtils() {
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
     * Returns a concatenated repeatation of the given phrase.
     * @param count The repeatation amount.
     * @param phrase The given phrase.
     * @return The concatenated repeatation.
     */
    public static final String repeat(final int count, final String phrase) {
        if (phrase != null) {
            final StringBuilder result = new StringBuilder();
            for (int i = 0; i < count; i++) {
                result.append(phrase);
            }
            return result.toString();
        }
        return "";
    }
    
    /**
     * Joins the objects of the given list as strings separated with the given
     * delimiter. If you have a list of strings, use <code>String.join()</code>
     * for more efficient usage!
     * @param delimiter The given delimiter.
     * @param elements The objects of the given list (null-elements will be
     * skipped).
     * @return The delimiter-separated join of the given elements.
     */
    public static final String join(final String delimiter, List<?> elements) {
        return String.join(delimiter, nonNullElements(elements));
    }
    
    /**
     * Joins the objects of the given list as strings separated with the given
     * delimiters.
     * @param delimiter The given default delimiter.
     * @param lastDelimiter The given delimiter for the last separation.
     * @param elements The objects of the given list (null-elements will be
     * skipped).
     * @return The delimiter-separated join of the given elements.
     */
    public static final String join(final String delimiter, final String lastDelimiter, List<?> elements) {
        final StringBuilder result = new StringBuilder();
        final List<String> convertedElements = nonNullElements(elements);
        final int maxIndex = convertedElements.size() - 1;
        for (int i = 0; i <= maxIndex; i++) {
            if (i > 0) {
                if (i == maxIndex) {
                    result.append(lastDelimiter);
                } else {
                    result.append(delimiter);
                }
            }
            result.append(convertedElements.get(i));
        }
        return result.toString();
    }
    
    private static List<String> nonNullElements(List<?> elements) {
        final List<String> result = new LinkedList<>();
        if (elements != null) {
            elements.stream().filter(element -> element != null).forEach(element -> result.add(element.toString()));
        }
        return result;
    }
}

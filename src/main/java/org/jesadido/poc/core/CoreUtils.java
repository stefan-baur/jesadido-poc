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
    public static String up(String value) {
        return (value == null || value.length() == 0) ? "" : value.substring(0, 1).toUpperCase() + value.substring(1);
    }
    
    /**
     * Return the given string without the last character.
     * @param value The given string.
     * @return The given string without the last character.
     */
    public static String cut(String value) {
        return (value == null || value.length() == 0) ? "" : value.substring(0, value.length() - 1);
    }
}

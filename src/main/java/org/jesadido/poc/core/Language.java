/*
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core;

/**
 * This <code>Language</code> enum class provides all supported languages of
 * this language project. The writing direction of all these languages is from
 * left to right (ltr).
 */
public enum Language {
    
    /**
     * The abbreviation for <b>Jesadido</b> is <b>ji</b>. It is <i>not</i>
     * conform to the standard <b>ISO 639-1</b>.
     */
    JI("ji", false),
    
    /**
     * The <b>ISO 639-1 conform</b> abbreviation for <b>German</b> is
     * <b>de</b>.
     */
    DE("de", true),
    
    /**
     * The <b>ISO 639-1 conform</b> abbreviation for <b>English</b> is
     * <b>en</b>.
     */
    EN("en", true),
    
    /**
     * The <b>ISO 639-1 conform</b> abbreviation for <b>Esperanto</b> is
     * <b>eo</b>.
     */
    EO("eo", true),
    
    /**
     * The <b>ISO 639-1 conform</b> abbreviation for <b>Spanish</b> is
     * <b>es</b>.
     */
    ES("es", true),
    
    /**
     * The <b>ISO 639-1 conform</b> abbreviation for <b>French</b> is
     * <b>fr</b>.
     */
    FR("fr", true);
    
    private final String code;
    private final boolean isoConform;
    
    private Language(String code, boolean isoConform) {
        this.code = code;
        this.isoConform = isoConform;
    }
    
    /**
     * Returns the lower-cased language abbreviation code.
     * @return The language code.
     */
    public String getCode() {
        return this.code;
    }
    
    /**
     * Returns <code>true</code> if this language is conform to the standard
     * <b>ISO 639-1</b>. In this case, the code of this language can be use for
     * example by declaring the HTML-tag-attribute <code>lang</code>.
     * @return <code>true</code> if this language is <b>ISO 639-1 conform</b>.
     */
    public boolean isIsoConform() {
        return this.isoConform;
    }
    
    /**
     * Returns the lower-cased language abbreviation code, only.
     * @return The language code.
     */
    @Override
    public String toString() {
        return this.code;
    }
}

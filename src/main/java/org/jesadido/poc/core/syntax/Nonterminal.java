/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax;

/**
 * This <code>Nonterminal</code> enum class lists a set of nonterminal-symbols.
 */
public enum Nonterminal {
    
    /**
     * The nonterminal-symbol for the <b>sentence-sequence</b>.
     *//**
     * The nonterminal-symbol for the <b>sentence-sequence</b>.
     */
    SENTENCE_SEQUENCE("sentence-sequence"),
    
    /**
     * The nonterminal-symbol for the <b>sentence</b>.
     */
    SENTENCE("sentence"),
    
    /**
     * The nonterminal-symbol for the <b>sentence-meat</b>.
     */
    SENTENCE_MEAT("sentence-meat"),
    
    /**
     * The nonterminal-symbol for the <b>sentence-meat-conjunction</b>.
     */
    SENTENCE_MEAT_CONJUNCTION("sentence-meat-conjunction"),
    
    /**
     * The nonterminal-symbol for the <b>sentence-meat-part</b>.
     */
    SENTENCE_MEAT_PART("sentence-meat-part"),
    
    /**
     * The nonterminal-symbol for the <b>part-su</b> (subject as sentence-part).
     */
    PART_SU("part-su"),
    
    /**
     * The nonterminal-symbol for the <b>part-dom</b> (predicate as
     * sentence-part).
     */
    PART_DOM("part-dom"),
    
    /**
     * The nonterminal-symbol for the <b>part-al</b> (dative-object as
     * sentence-part).
     */
    PART_AL("part-al"),
    
    /**
     * The nonterminal-symbol for the <b>part-fin</b> (accusative-object as
     * sentence-part).
     */
    PART_FIN("part-fin"),
    
    /**
     * The nonterminal-symbol for the <b>nominal-selection</b> (a kind of
     * nominal-phrase).
     */
    NOMINAL_SELECTION("nominal-selection"),
    
    /**
     * The nonterminal-symbol for the <b>article</b> (an indefinite article).
     */
    ARTICLE_SELECTION("article-selection"),
    
    /**
     * The nonterminal-symbol for the <b>substantive-selection</b> (a special
     * kind of nominal-phrase).
     */
    SUBSTANTIVE_SELECTION("substantive-selection"),
    
    /**
     * The nonterminal-symbol for the <b>verbal-selection</b> (a kind of
     * predicate).
     */
    VERBAL_SELECTION("verbal-selection"),
    
    /**
     * The nonterminal-symbol for the <b>verb-selection</b> (a special kind of
     * predicate).
     */
    VERB_SELECTION("verb-selection");
    
    private final String value;
    
    private Nonterminal(final String value) {
        this.value = value;
    }
    
    /**
     * Returns the textual representation of this nonterminal-symbol.
     * @return The value.
     */
    public String getValue() {
        return this.value;
    }
    
    /**
     * Returns the value of this nonterminal-symbol.
     * @return This nonterminal-symbol as a string.
     */
    @Override
    public String toString() {
        return this.value;
    }
}

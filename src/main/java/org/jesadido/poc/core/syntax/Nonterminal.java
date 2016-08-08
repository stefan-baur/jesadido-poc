/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax;

public enum Nonterminal {
    
    SENTENCE("sentence"),
    SENTENCE_MEAT("sentence-meat"),
    SENTENCE_MEAT_CONJUNCTION("sentence-meat-conjunction"),
    SENTENCE_MEAT_PART("sentence-meat-part"),
    
    PART_SU("part-su"),
    PART_DOM("part-dom"),
    PART_AL("part-al"),
    PART_FIN("part-fin"),
    
    NOMINAL_SELECTION("nominal-selection"),
    NOMINAL_PHRASE("nominal-phrase"),
    
    VERBAL_SELECTION("verbal-selection");
    
    private final String value;
    
    private Nonterminal(final String value) {
        this.value = value;
    }
    
    public String getValue() {
        return this.value;
    }
    
    @Override
    public String toString() {
        return this.value;
    }
}

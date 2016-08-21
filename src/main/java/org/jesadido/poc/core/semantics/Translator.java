/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics;

import org.jesadido.poc.core.Language;

public abstract class Translator {
    
    private final Language language;
    private final ConceptBook conceptBook;
    
    public Translator(final Language language, final ConceptBook conceptBook) {
        this.language = language;
        this.conceptBook = conceptBook;
    }
    
    public Language getLanguage() {
        return this.language;
    }
    
    public ConceptBook getConceptBook() {
        return this.conceptBook;
    }
    
    public abstract TranslationResult translate(final String code);
}

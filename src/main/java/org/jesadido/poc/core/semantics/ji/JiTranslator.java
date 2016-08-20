/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.ji;

import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.semantics.ConceptBook;
import org.jesadido.poc.core.semantics.TranslatingResult;
import org.jesadido.poc.core.semantics.Translator;

public class JiTranslator extends Translator {
    
    public JiTranslator(final ConceptBook conceptBook) {
        super(Language.JI, conceptBook);
    }
    
    @Override
    public TranslatingResult translate(final String code) {
        final TranslatingResult result = new TranslatingResult();
        result.getTranslations().add(code);
        return result;
    }
}

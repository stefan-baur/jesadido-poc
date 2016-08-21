/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.eo;

import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.semantics.ConceptBook;
import org.jesadido.poc.core.semantics.TranslationResult;
import org.jesadido.poc.core.semantics.Translator;
import org.jesadido.poc.core.syntax.tree.Node;

public class EoTranslator extends Translator {
    
    public EoTranslator(final ConceptBook conceptBook) {
        super(Language.EO, conceptBook);
    }
    
    @Override
    public TranslationResult translate(final String code) {
        final Node node = this.getConceptBook().getGrammar().parse(code);
        final TranslationResult result = new TranslationResult(node);
        result.setTranslation(String.format("%s: TODO %s", this.getLanguage().getCode(), code));
        return result;
    }
}

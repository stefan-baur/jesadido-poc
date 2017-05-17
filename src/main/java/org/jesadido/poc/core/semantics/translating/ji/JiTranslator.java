/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.ji;

import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.concepts.ConceptUtils;
import org.jesadido.poc.core.semantics.ConceptBook;
import org.jesadido.poc.core.semantics.translating.TranslationContext;
import org.jesadido.poc.core.semantics.translating.TranslationResult;
import org.jesadido.poc.core.semantics.translating.Translator;
import org.jesadido.poc.core.syntax.tree.JesadidoNode;

public class JiTranslator extends Translator {
    
    public JiTranslator(final ConceptBook conceptBook, final TranslationContext translationContext) {
        super(Language.JI, conceptBook, translationContext);
    }
    
    public JiTranslator(final ConceptBook conceptBook) {
        super(Language.JI, conceptBook, new TranslationContext() {});
    }
    
    @Override
    public TranslationResult translate(final JesadidoNode validatedNode) {
        final TranslationResult result = new TranslationResult(this, validatedNode);
        result.setTranslation(ConceptUtils.join(validatedNode.collectConcepts()));
        return result;
    }
}

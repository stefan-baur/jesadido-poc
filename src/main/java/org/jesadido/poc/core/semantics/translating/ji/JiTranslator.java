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
import org.jesadido.poc.core.semantics.translating.TranslationResult;
import org.jesadido.poc.core.semantics.translating.Translator;
import org.jesadido.poc.core.syntax.tree.Node;

public class JiTranslator extends Translator {
    
    public JiTranslator(final ConceptBook conceptBook) {
        super(Language.JI, conceptBook);
    }
    
    @Override
    public TranslationResult translate(final Node validatedNode) {
        final TranslationResult result = new TranslationResult(validatedNode);
        result.setTranslation(ConceptUtils.join(validatedNode.collectConcepts()));
        return result;
    }
}
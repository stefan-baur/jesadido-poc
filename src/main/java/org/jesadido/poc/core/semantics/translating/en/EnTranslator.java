/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.en;

import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.semantics.ConceptBook;
import org.jesadido.poc.core.semantics.translating.TranslationResult;
import org.jesadido.poc.core.semantics.translating.Translator;
import org.jesadido.poc.core.syntax.tree.Node;

public class EnTranslator extends Translator {
    
    public EnTranslator(final ConceptBook conceptBook) {
        super(Language.EN, conceptBook);
    }
    
    @Override
    public TranslationResult translate(final String code) {
        final Node node = this.getConceptBook().getGrammar().parse(code);
        final TranslationResult result = new TranslationResult(node);
        if (node.collectTroubles().isEmpty()) {
            return node.accept(new EnVisitor(this), new EnVisitorArgument());
        }
        return result;
    }
}

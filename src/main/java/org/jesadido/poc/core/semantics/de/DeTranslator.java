/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.de;

import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.semantics.ConceptBook;
import org.jesadido.poc.core.semantics.TranslatingResult;
import org.jesadido.poc.core.semantics.Translator;
import org.jesadido.poc.core.syntax.Grammar;
import org.jesadido.poc.core.syntax.tree.Node;

public class DeTranslator extends Translator {
    
    public DeTranslator(final ConceptBook conceptBook) {
        super(Language.DE, conceptBook);
    }
    
    @Override
    public TranslatingResult translate(final String code) {
        final TranslatingResult result = new TranslatingResult();
        final ConceptBook conceptBook = this.getConceptBook();
        final Grammar grammar = conceptBook.getGrammar();
        final Node node = grammar.parse(code);
        if (node.collectTroubles().isEmpty()) {
            final String translation = node.accept(new DeVisitor(this), new DeVisitorArgument());
            result.getTranslations().add(translation);
        }
        return result;
    }
}

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.fr;

import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.semantics.ConceptBook;
import org.jesadido.poc.core.semantics.translating.TranslationContext;
import org.jesadido.poc.core.semantics.translating.TranslationResult;
import org.jesadido.poc.core.semantics.translating.Translator;
import org.jesadido.poc.core.syntax.tree.Node;

public class FrTranslator extends Translator {
    
    public FrTranslator(final ConceptBook conceptBook, final TranslationContext translationContext) {
        super(Language.FR, conceptBook, translationContext);
    }
    
    public FrTranslator(final ConceptBook conceptBook) {
        super(Language.FR, conceptBook, new TranslationContext() {});
    }
    
    @Override
    public TranslationResult translate(final Node validatedNode) {
        return validatedNode.accept(new FrVisitor(this), new FrVisitorArgument());
    }
}

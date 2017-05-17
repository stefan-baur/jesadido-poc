/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.eo;

import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.semantics.ConceptBook;
import org.jesadido.poc.core.semantics.translating.TranslationContext;
import org.jesadido.poc.core.semantics.translating.TranslationResult;
import org.jesadido.poc.core.semantics.translating.Translator;
import org.jesadido.poc.core.syntax.tree.JesadidoNode;

public class EoTranslator extends Translator {
    
    public EoTranslator(final ConceptBook conceptBook, final TranslationContext translationContext) {
        super(Language.EO, conceptBook, translationContext);
    }
    
    public EoTranslator(final ConceptBook conceptBook) {
        super(Language.EO, conceptBook, new TranslationContext() {});
    }
    
    @Override
    public TranslationResult translate(final JesadidoNode validatedNode) {
        return validatedNode.accept(new EoVisitor(this), new EoVisitorArgument());
    }
}

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax;

import org.jesadido.poc.core.syntax.base.BaseSyntaxTreeFactory;
import org.jesadido.poc.core.syntax.base.productions.SentenceProduction;
import org.jesadido.poc.core.syntax.base.BaseTokenCreator;
import org.jesadido.poc.core.syntax.base.productions.SentenceMeatProduction;

public class GrammarFactory {
    
    public final Grammar createBaseGrammar(final String name) {
        return new Grammar(name, new BaseTokenCreator(), new BaseSyntaxTreeFactory())
                .register(false, new SentenceMeatProduction())
                .register(true, new SentenceProduction());
    }
}

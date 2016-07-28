/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax;

import java.util.logging.Logger;
import org.jesadido.poc.core.syntax.base.BaseSyntaxTreeFactory;
import org.jesadido.poc.core.syntax.base.productions.SentenceProduction;
import org.jesadido.poc.core.syntax.base.BaseTokenCreator;
import org.jesadido.poc.core.syntax.base.productions.SentenceMeatConjunctionProduction;
import org.jesadido.poc.core.syntax.base.productions.SentenceMeatProduction;

public class GrammarFactory {
    
    private static final Logger LOGGER = Logger.getLogger(GrammarFactory.class.getName());
    
    public final Grammar createBaseGrammar(final String name) {
        return new Grammar(name, new BaseTokenCreator(), new BaseSyntaxTreeFactory())
                .register(false, new SentenceMeatConjunctionProduction())
                .register(false, new SentenceMeatProduction())
                .register(true, new SentenceProduction());
    }
    
    public static void main(String[] arguments) {
        LOGGER.info(new GrammarFactory().createBaseGrammar("Jesadido-Base").toString());
    }
}

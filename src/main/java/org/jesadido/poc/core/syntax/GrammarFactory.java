/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax;

import java.util.logging.Logger;
import org.jesadido.poc.core.syntax.base.productions.NominalSelectionProduction;
import org.jesadido.poc.core.syntax.base.productions.PartDomProduction;
import org.jesadido.poc.core.syntax.base.productions.PartFinProduction;
import org.jesadido.poc.core.syntax.base.productions.SentenceMeatPartProduction;
import org.jesadido.poc.core.syntax.base.productions.PartSuProduction;
import org.jesadido.poc.core.syntax.base.productions.VerbalSelectionProduction;
import org.jesadido.poc.core.syntax.base.productions.SentenceMeatConjunctionProduction;
import org.jesadido.poc.core.syntax.base.productions.SentenceMeatProduction;
import org.jesadido.poc.core.syntax.base.productions.SentenceProduction;

public class GrammarFactory {
    
    private static final Logger LOGGER = Logger.getLogger(GrammarFactory.class.getName());
    
    public final Grammar createDefaultGrammar(final String name) {
        return new Grammar(name, new DefaultTokenCreator(), new SyntaxTreeFactory())
                
                .register(false, new NominalSelectionProduction())
                .register(false, new VerbalSelectionProduction())
                
                .register(false, new PartSuProduction())
                .register(false, new PartDomProduction())
                .register(false, new PartFinProduction())
                
                .register(false, new SentenceMeatPartProduction())
                .register(false, new SentenceMeatConjunctionProduction())
                .register(false, new SentenceMeatProduction())
                .register(true, new SentenceProduction())
                ;
    }
    
    public static void main(String[] arguments) {
        LOGGER.info(new GrammarFactory().createDefaultGrammar("Jesadido-Base").toString());
    }
}

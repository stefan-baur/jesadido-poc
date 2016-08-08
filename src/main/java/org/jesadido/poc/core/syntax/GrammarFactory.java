/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax;

import org.jesadido.poc.core.syntax.tree.SyntaxTreeFactory;
import java.util.logging.Logger;
import org.jesadido.poc.core.syntax.productions.sentence.NominalPhraseProduction;
import org.jesadido.poc.core.syntax.productions.sentence.NominalSelectionProduction;
import org.jesadido.poc.core.syntax.productions.sentence.PartAlProduction;
import org.jesadido.poc.core.syntax.productions.sentence.PartDomProduction;
import org.jesadido.poc.core.syntax.productions.sentence.PartFinProduction;
import org.jesadido.poc.core.syntax.productions.sentence.SentenceMeatPartProduction;
import org.jesadido.poc.core.syntax.productions.sentence.PartSuProduction;
import org.jesadido.poc.core.syntax.productions.sentence.VerbalSelectionProduction;
import org.jesadido.poc.core.syntax.productions.sentence.SentenceMeatConjunctionProduction;
import org.jesadido.poc.core.syntax.productions.sentence.SentenceMeatProduction;
import org.jesadido.poc.core.syntax.productions.sentence.SentenceProduction;
import org.jesadido.poc.core.syntax.tokens.TokenCreator;

public class GrammarFactory {
    
    private static final Logger LOGGER = Logger.getLogger(GrammarFactory.class.getName());
    
    public final Grammar createDefaultGrammar(final String name) {
        return new Grammar(name, new TokenCreator(), new SyntaxTreeFactory())
                
                .register(false, new NominalPhraseProduction())
                .register(false, new NominalSelectionProduction())
                
                .register(false, new PartSuProduction())
                .register(false, new PartAlProduction())
                .register(false, new PartFinProduction())
                
                .register(false, new VerbalSelectionProduction())
                
                .register(false, new PartDomProduction())
                
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

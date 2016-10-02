/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax;

import java.util.logging.Logger;
import org.jesadido.poc.core.syntax.productions.sentence.AdjectiveSelectionProduction;
import org.jesadido.poc.core.syntax.productions.sentence.ArticleSelectionProduction;
import org.jesadido.poc.core.syntax.productions.sentence.SubstantiveSelectionProduction;
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
import org.jesadido.poc.core.syntax.productions.sentence.SentenceSequenceProduction;
import org.jesadido.poc.core.syntax.productions.sentence.VerbSelectionProduction;
import org.jesadido.poc.core.syntax.tokens.TokenCreator;
import org.jesadido.poc.core.syntax.tree.SyntaxTreeFactory;

/**
 * This <code>GrammarFactory</code> class is a factory for relevant grammars of
 * this language-framework.
 */
public final class GrammarFactory {
    
    private GrammarFactory() {
        // A private factory class constructor
    }
    
    /**
     * Creates an instance of the <b>Jesadido</b>-grammar.
     * @return The grammar of Jesadido.
     */
    public static Grammar createJesadidoGrammar() {
        return new Grammar("jesadido-grammar", new TokenCreator(), new SyntaxTreeFactory())
                
                .register(false, new AdjectiveSelectionProduction())
                .register(false, new SubstantiveSelectionProduction())
                .register(false, new ArticleSelectionProduction())
                .register(false, new NominalSelectionProduction())
                
                .register(false, new PartSuProduction())
                .register(false, new PartAlProduction())
                .register(false, new PartFinProduction())
                
                .register(false, new VerbSelectionProduction())
                .register(false, new VerbalSelectionProduction())
                
                .register(false, new PartDomProduction())
                
                .register(false, new SentenceMeatPartProduction())
                .register(false, new SentenceMeatConjunctionProduction())
                .register(false, new SentenceMeatProduction())
                .register(false, new SentenceProduction())
                
                .register(true, new SentenceSequenceProduction())
                ;
    }
    
    /**
     * Plots the grammar of Jesadido to the logging-output.
     * @param arguments Unused.
     */
    public static void main(final String[] arguments) {
        Logger.getAnonymousLogger().info(GrammarFactory.createJesadidoGrammar().toString());
    }
}

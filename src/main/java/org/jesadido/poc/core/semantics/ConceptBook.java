/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;
import org.jesadido.poc.core.syntax.Grammar;
import org.jesadido.poc.core.syntax.GrammarFactory;
import org.jesadido.poc.core.syntax.Nonterminal;

public class ConceptBook {
    
    private final Grammar grammar = GrammarFactory.createJesadidoGrammar();
    private final Map<String, ConceptBookEntry> book = new LinkedHashMap<>();
    
    public Grammar getGrammar() {
        return this.grammar;
    }
    
    public boolean add(final ConceptBookEntry entry) {
        final String conceptPhrase = entry.getConceptPhrase();
        if (this.book.containsKey(conceptPhrase)) {
            return this.book.get(conceptPhrase).expand(entry);
        }
        this.book.put(conceptPhrase, entry);
        return true;
    }
    
    public static void main(String[] arguments) {
        
        final ConceptBook conceptBook = new ConceptBook();
        
        conceptBook.add(new ConceptBookEntry("HeroIcxO"));
        
        conceptBook.add(new ConceptBookEntry("HeroInO"));
        // Required parts: Su Dom Fin
        conceptBook.add(new ConceptBookEntry("TrovAs"));
        // Required parts: Su Dom Al Fin
        conceptBook.add(new ConceptBookEntry("DonAs"));
        
        conceptBook.add(new ConceptBookEntry("SkribIlO"));
        
        conceptBook.add(new ConceptBookEntry("FlorO"));
        
        
        conceptBook.getGrammar().parse("HeroIcxO TrovAs Fin SkribIlO . HeroInO").collectTroubles().stream().forEach(trouble -> Logger.getAnonymousLogger().info(trouble.getMessage()));
        
        conceptBook.book.keySet().stream().map(conceptPhrase -> {
            Logger.getAnonymousLogger().info(conceptPhrase);
            return conceptPhrase;
        }).map(conceptPhrase -> conceptBook.getGrammar().parse(conceptPhrase, Nonterminal.SENTENCE_MEAT)).forEach(node -> node.collectTroubles().stream().forEach(trouble -> Logger.getAnonymousLogger().info("TROUBLE: ".concat(trouble.getMessage()))));
    }
}

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
import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.semantics.de.De;
import org.jesadido.poc.core.semantics.de.DeTarget;
import org.jesadido.poc.core.syntax.Grammar;
import org.jesadido.poc.core.syntax.GrammarFactory;

public class ConceptBook {
    
    private final Grammar grammar = GrammarFactory.createJesadidoGrammar();
    private final Map<String, ConceptBookEntry> book = new LinkedHashMap<>();
    
    public Grammar getGrammar() {
        return this.grammar;
    }
    
    public ConceptBookEntry add(final ConceptBookEntry conceptBookEntry) {
        this.book.put(conceptBookEntry.getConceptPhrase(), conceptBookEntry);
        return conceptBookEntry;
    }
    
    public ConceptBookEntry get(final Concept concept) {
        if (this.book.containsKey(concept.getFullPhrase())) {
            return this.book.get(concept.getFullPhrase());
        }
        return new ConceptBookEntry(concept.getFullPhrase());
    }
    
    public static void main(final String[] arguments) {
        
        final ConceptBook conceptBook = new ConceptBook();
        
        conceptBook.add(new ConceptBookEntry("HeroIcxO"))
                .addDefaultTargets(new DeTarget("Held", De.MASCULINE, De.NOMINATIVE), new DeTarget("Helden", De.MASCULINE, De.GENITIVE, De.DATIVE, De.ACCUSATIVE));
        
        conceptBook.add(new ConceptBookEntry("HeroInO"))
                .addDefaultTargets(new DeTarget("Heldin", De.FEMININE, De.NOMINATIVE, De.GENITIVE, De.DATIVE, De.ACCUSATIVE));
        
        conceptBook.add(new ConceptBookEntry("TrovAs"))
                .addDefaultTargets(new DeTarget("finde", De.MI), new DeTarget("findest", De.BI), new DeTarget("findet", De.GXI, De.VI), new DeTarget("finden", De.NI, De.ILI));
        
        conceptBook.add(new ConceptBookEntry("DonAs"))
                .addDefaultTargets(new DeTarget("gebe", De.MI), new DeTarget("gibst", De.BI), new DeTarget("gibt", De.GXI), new DeTarget("geben", De.NI, De.ILI), new DeTarget("gebt", De.VI));
        
        conceptBook.add(new ConceptBookEntry("SkribIlO"))
                .addDefaultTargets(new DeTarget("Stift", De.MASCULINE, De.NOMINATIVE, De.DATIVE, De.ACCUSATIVE), new DeTarget("Stifts", De.MASCULINE, De.GENITIVE));
        
        conceptBook.add(new ConceptBookEntry("FlorO"))
                .addDefaultTargets(new DeTarget("Blume", De.FEMININE, De.NOMINATIVE, De.GENITIVE, De.DATIVE, De.ACCUSATIVE));
        
        conceptBook.add(new ConceptBookEntry("NomO"))
                .addDefaultTargets(new DeTarget("Name", De.MASCULINE, De.NOMINATIVE), new DeTarget("Namens", De.MASCULINE, De.GENITIVE), new DeTarget("Namen", De.MASCULINE, De.DATIVE, De.ACCUSATIVE));
        
        conceptBook.add(new ConceptBookEntry("Kaj"))
                .addDefaultTargets(new DeTarget("und"));
        
        for (final Language language : Language.values()) {
            final Translator translator = TranslatorFactory.createTranslator(language, conceptBook);
            final String translation = translator.translate("HeroInO TrovAs Fin NomO . Fin NomO DonAs HeroInO Al HeroIcxO . HeroIcxO TrovAs Fin SkribIlO Kaj HeroIcxO DonAs Al HeroInO Fin SkribIlO .").getTranslation();
            Logger.getAnonymousLogger().info(translation);
        }
    }
}

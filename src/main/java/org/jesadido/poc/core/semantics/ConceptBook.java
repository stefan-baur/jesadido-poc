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
import org.jesadido.poc.core.semantics.en.En;
import org.jesadido.poc.core.semantics.en.EnTarget;
import org.jesadido.poc.core.semantics.eo.EoTarget;
import org.jesadido.poc.core.semantics.es.Es;
import org.jesadido.poc.core.semantics.es.EsTarget;
import org.jesadido.poc.core.semantics.fr.Fr;
import org.jesadido.poc.core.semantics.fr.FrTarget;
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
                .addDefaultTargets(new DeTarget("Held", De.MASCULINE, De.NOMINATIVE), new DeTarget("Helden", De.MASCULINE, De.GENITIVE, De.DATIVE, De.ACCUSATIVE))
                .addDefaultTargets(new EnTarget("hero"))
                .addDefaultTargets(new EoTarget("heroo"))
                .addDefaultTargets(new EsTarget("héroe", Es.MASCULINE))
                .addDefaultTargets(new FrTarget("héros", Fr.MASCULINE))
                ;
        
        conceptBook.add(new ConceptBookEntry("HeroInO"))
                .addDefaultTargets(new DeTarget("Heldin", De.FEMININE, De.NOMINATIVE, De.GENITIVE, De.DATIVE, De.ACCUSATIVE))
                .addDefaultTargets(new EnTarget("heroine"))
                .addDefaultTargets(new EoTarget("heroino"))
                .addDefaultTargets(new EsTarget("heroína", Es.FEMININE))
                .addDefaultTargets(new FrTarget("héroïne", Fr.FEMININE))
                ;
        
        conceptBook.add(new ConceptBookEntry("TrovAs"))
                .addDefaultTargets(new DeTarget("finde", De.MI), new DeTarget("findest", De.BI), new DeTarget("findet", De.GXI, De.VI), new DeTarget("finden", De.NI, De.ILI))
                .addDefaultTargets(new EnTarget("find", En.MI, En.BI, En.NI, En.VI, En.ILI), new EnTarget("finds", En.GXI))
                .addDefaultTargets(new EoTarget("trovas"))
                .addDefaultTargets(new EsTarget("encuentro", Es.MI), new EsTarget("encuentras", Es.BI), new EsTarget("encuentra", Es.GXI), new EsTarget("encontramos", Es.NI), new EsTarget("encontráis", Es.VI), new EsTarget("encuentran", Es.ILI))
                .addDefaultTargets(new FrTarget("trouve", Fr.MI, Fr.GXI), new FrTarget("trouves", Fr.BI), new FrTarget("trouvons", Fr.NI), new FrTarget("trouvez", Fr.VI), new FrTarget("trouvent", Fr.ILI))
                ;
        
        conceptBook.add(new ConceptBookEntry("DonAs"))
                .addDefaultTargets(new DeTarget("gebe", De.MI), new DeTarget("gibst", De.BI), new DeTarget("gibt", De.GXI), new DeTarget("geben", De.NI, De.ILI), new DeTarget("gebt", De.VI))
                .addDefaultTargets(new EnTarget("give", En.MI, En.BI, En.NI, En.VI, En.ILI), new EnTarget("gives", En.GXI))
                .addDefaultTargets(new EoTarget("donas"))
                .addDefaultTargets(new EsTarget("doy", Es.MI), new EsTarget("das", Es.BI), new EsTarget("da", Es.GXI), new EsTarget("damos", Es.NI), new EsTarget("dais", Es.VI), new EsTarget("dan", Es.ILI))
                .addDefaultTargets(new FrTarget("donne", Fr.MI, Fr.GXI), new FrTarget("donnes", Fr.BI), new FrTarget("donnons", Fr.NI), new FrTarget("donnez", Fr.VI), new FrTarget("donnent", Fr.ILI))
                ;
        
        conceptBook.add(new ConceptBookEntry("SkribIlO"))
                .addDefaultTargets(new DeTarget("Stift", De.MASCULINE, De.NOMINATIVE, De.DATIVE, De.ACCUSATIVE), new DeTarget("Stifts", De.MASCULINE, De.GENITIVE))
                .addDefaultTargets(new EnTarget("pen"))
                .addDefaultTargets(new EoTarget("skribilo"))
                .addDefaultTargets(new EsTarget("lapicero", Es.MASCULINE))
                .addDefaultTargets(new FrTarget("crayon", Fr.MASCULINE))
                ;
        
        conceptBook.add(new ConceptBookEntry("FlorO"))
                .addDefaultTargets(new DeTarget("Blume", De.FEMININE, De.NOMINATIVE, De.GENITIVE, De.DATIVE, De.ACCUSATIVE))
                .addDefaultTargets(new EnTarget("flower"))
                .addDefaultTargets(new EoTarget("floro"))
                .addDefaultTargets(new EsTarget("flor", Es.FEMININE))
                .addDefaultTargets(new FrTarget("fleur", Fr.FEMININE))
                ;
        
        conceptBook.add(new ConceptBookEntry("NomO"))
                .addDefaultTargets(new DeTarget("Name", De.MASCULINE, De.NOMINATIVE), new DeTarget("Namens", De.MASCULINE, De.GENITIVE), new DeTarget("Namen", De.MASCULINE, De.DATIVE, De.ACCUSATIVE))
                .addDefaultTargets(new EnTarget("name"))
                .addDefaultTargets(new EoTarget("nomo"))
                .addDefaultTargets(new EsTarget("nombre", Es.MASCULINE))
                .addDefaultTargets(new FrTarget("nom", Fr.MASCULINE))
                ;
        
        conceptBook.add(new ConceptBookEntry("Kaj"))
                .addDefaultTargets(new DeTarget("und"))
                .addDefaultTargets(new EnTarget("and"))
                .addDefaultTargets(new EoTarget("kaj"))
                .addDefaultTargets(new EsTarget("y"))
                .addDefaultTargets(new FrTarget("et"))
                ;
        
        for (final Language language : Language.values()) {
            final Translator translator = TranslatorFactory.createTranslator(language, conceptBook);
            final String translation = translator.translate("HeroInO TrovAs Fin NomO . Fin NomO DonAs HeroInO Al HeroIcxO . HeroIcxO TrovAs Fin SkribIlO Kaj HeroIcxO DonAs Al HeroInO Fin SkribIlO .").getTranslation();
            Logger.getAnonymousLogger().info(translation);
        }
    }
}

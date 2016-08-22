/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.testing;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;
import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.scripting.Src;
import org.jesadido.poc.core.semantics.ConceptBook;
import org.jesadido.poc.core.semantics.ConceptBookEntry;
import org.jesadido.poc.core.semantics.TranslatorFactory;
import org.jesadido.poc.core.semantics.de.De;
import org.jesadido.poc.core.semantics.de.DeTarget;
import org.jesadido.poc.core.semantics.en.En;
import org.jesadido.poc.core.semantics.en.EnTarget;
import org.jesadido.poc.core.semantics.eo.EoTarget;
import org.jesadido.poc.core.semantics.es.Es;
import org.jesadido.poc.core.semantics.es.EsTarget;
import org.jesadido.poc.core.semantics.fr.Fr;
import org.jesadido.poc.core.semantics.fr.FrTarget;

public final class References {
    
    public static final ConceptBook GAME_BOOK = new ConceptBook()
            
            .add(new ConceptBookEntry("HeroIcxO")
                    .addDefaultTargets(new DeTarget("Held", De.MASCULINE, De.NOMINATIVE), new DeTarget("Helden", De.MASCULINE, De.GENITIVE, De.DATIVE, De.ACCUSATIVE))
                    .addDefaultTargets(new EnTarget("hero"))
                    .addDefaultTargets(new EoTarget("heroo"))
                    .addDefaultTargets(new EsTarget("héroe", Es.MASCULINE))
                    .addDefaultTargets(new FrTarget("héros", Fr.MASCULINE))
            )
            .add(new ConceptBookEntry("HeroInO")
                    .addDefaultTargets(new DeTarget("Heldin", De.FEMININE, De.NOMINATIVE, De.GENITIVE, De.DATIVE, De.ACCUSATIVE))
                    .addDefaultTargets(new EnTarget("heroine"))
                    .addDefaultTargets(new EoTarget("heroino"))
                    .addDefaultTargets(new EsTarget("heroína", Es.FEMININE))
                    .addDefaultTargets(new FrTarget("héroïne", Fr.FEMININE))
            )
            .add(new ConceptBookEntry("TrovAs")
                    .addDefaultTargets(new DeTarget("finde", De.MI), new DeTarget("findest", De.BI), new DeTarget("findet", De.GXI, De.VI), new DeTarget("finden", De.NI, De.ILI))
                    .addDefaultTargets(new EnTarget("find", En.MI, En.BI, En.NI, En.VI, En.ILI), new EnTarget("finds", En.GXI))
                    .addDefaultTargets(new EoTarget("trovas"))
                    .addDefaultTargets(new EsTarget("encuentro", Es.MI), new EsTarget("encuentras", Es.BI), new EsTarget("encuentra", Es.GXI), new EsTarget("encontramos", Es.NI), new EsTarget("encontráis", Es.VI), new EsTarget("encuentran", Es.ILI))
                    .addDefaultTargets(new FrTarget("trouve", Fr.MI, Fr.GXI), new FrTarget("trouves", Fr.BI), new FrTarget("trouvons", Fr.NI), new FrTarget("trouvez", Fr.VI), new FrTarget("trouvent", Fr.ILI))
            )
            .add(new ConceptBookEntry("DonAs")
                    .addDefaultTargets(new DeTarget("gebe", De.MI), new DeTarget("gibst", De.BI), new DeTarget("gibt", De.GXI), new DeTarget("geben", De.NI, De.ILI), new DeTarget("gebt", De.VI))
                    .addDefaultTargets(new EnTarget("give", En.MI, En.BI, En.NI, En.VI, En.ILI), new EnTarget("gives", En.GXI))
                    .addDefaultTargets(new EoTarget("donas"))
                    .addDefaultTargets(new EsTarget("doy", Es.MI), new EsTarget("das", Es.BI), new EsTarget("da", Es.GXI), new EsTarget("damos", Es.NI), new EsTarget("dais", Es.VI), new EsTarget("dan", Es.ILI))
                    .addDefaultTargets(new FrTarget("donne", Fr.MI, Fr.GXI), new FrTarget("donnes", Fr.BI), new FrTarget("donnons", Fr.NI), new FrTarget("donnez", Fr.VI), new FrTarget("donnent", Fr.ILI))
            )
            .add(new ConceptBookEntry("SkribIlO")
                    .addDefaultTargets(new DeTarget("Stift", De.MASCULINE, De.NOMINATIVE, De.DATIVE, De.ACCUSATIVE), new DeTarget("Stifts", De.MASCULINE, De.GENITIVE))
                    .addDefaultTargets(new EnTarget("pen"))
                    .addDefaultTargets(new EoTarget("skribilo"))
                    .addDefaultTargets(new EsTarget("lapicero", Es.MASCULINE))
                    .addDefaultTargets(new FrTarget("crayon", Fr.MASCULINE))
            )
            .add(new ConceptBookEntry("FlorO")
                    .addDefaultTargets(new DeTarget("Blume", De.FEMININE, De.NOMINATIVE, De.GENITIVE, De.DATIVE, De.ACCUSATIVE))
                    .addDefaultTargets(new EnTarget("flower"))
                    .addDefaultTargets(new EoTarget("floro"))
                    .addDefaultTargets(new EsTarget("flor", Es.FEMININE))
                    .addDefaultTargets(new FrTarget("fleur", Fr.FEMININE))
            )
            .add(new ConceptBookEntry("NomO")
                    .addDefaultTargets(new DeTarget("Name", De.MASCULINE, De.NOMINATIVE), new DeTarget("Namens", De.MASCULINE, De.GENITIVE), new DeTarget("Namen", De.MASCULINE, De.DATIVE, De.ACCUSATIVE))
                    .addDefaultTargets(new EnTarget("name"))
                    .addDefaultTargets(new EoTarget("nomo"))
                    .addDefaultTargets(new EsTarget("nombre", Es.MASCULINE))
                    .addDefaultTargets(new FrTarget("nom", Fr.MASCULINE))
            )
            .add(new ConceptBookEntry("Kaj")
                    .addDefaultTargets(new DeTarget("und"))
                    .addDefaultTargets(new EnTarget("and"))
                    .addDefaultTargets(new EoTarget("kaj"))
                    .addDefaultTargets(new EsTarget("y"))
                    .addDefaultTargets(new FrTarget("et"))
            )
            ;
    
    private static final String[] GAME_SOURCES = new String[] {
        
        "HeroIcxO TrovAs Fin SkribIlO .",
        "HeroIcxO TrovAs Fin FlorO .",
        "HeroInO TrovAs Fin SkribIlO .",
        "HeroInO TrovAs Fin FlorO .",
        
        "HeroIcxO DonAs Al HeroInO Fin SkribIlO .",
        "HeroIcxO DonAs Al HeroInO Fin FlorO .",
        "HeroInO DonAs Al HeroIcxO Fin SkribIlO .",
        "HeroInO DonAs Al HeroIcxO Fin FlorO ."
        
        //"HeroInO TrovAs Fin NomO . Fin NomO DonAs HeroInO Al HeroIcxO . HeroIcxO TrovAs Fin SkribIlO Kaj HeroIcxO DonAs Al HeroInO Fin SkribIlO ."
    };
    
    private References() {
        // A private utility class constructor
    }
    
    public static String[] getGameSources() {
        return GAME_SOURCES;
    }
    
    private static Src generateSingleGameTest(final String methodId, final String source) {
        final Src result = new Src()
                .line()
                .line("@Test")
                .begin("public void test%sGame%s() {", methodId, new SimpleDateFormat("yyyyMMddhhmmsszzz").format(new Date()))
                .line("final String source = \"%s\";", source)
                ;
        for (final Language language : Language.values()) {
            final String translation = TranslatorFactory.createTranslator(language, GAME_BOOK).translate(source).getTranslation();
            result.line("Assert.assertEquals(\"%s\", TranslatorFactory.createTranslator(Language.%s, References.GAME_BOOK).translate(source).getTranslation());", translation, language.name());
        }
        return result.end("}");
    }
    
    public static Src generateGameTests() {
        final Src result = new Src(Integer.MAX_VALUE, "", "    ", "\r\n").line().inc();
        for (int i = 0; i < GAME_SOURCES.length; i++) {
            result.add(generateSingleGameTest(String.format("VerticalTranslation%03d", i), GAME_SOURCES[i]));
        }
        return result.dec().line();
    }
    
    public static void main(final String[] arguments) {
        Logger.getAnonymousLogger().info(generateGameTests().toString());
    }
}

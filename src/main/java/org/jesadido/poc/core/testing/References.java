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
import org.jesadido.poc.core.semantics.Part;
import org.jesadido.poc.core.semantics.translating.TranslatorFactory;
import org.jesadido.poc.core.semantics.translating.de.De;
import org.jesadido.poc.core.semantics.translating.de.DeTarget;
import org.jesadido.poc.core.semantics.translating.en.En;
import org.jesadido.poc.core.semantics.translating.en.EnTarget;
import org.jesadido.poc.core.semantics.translating.eo.EoTarget;
import org.jesadido.poc.core.semantics.translating.es.Es;
import org.jesadido.poc.core.semantics.translating.es.EsTarget;
import org.jesadido.poc.core.semantics.translating.fr.Fr;
import org.jesadido.poc.core.semantics.translating.fr.FrTarget;

public final class References {
    
    public static final ConceptBook GAME_BOOK = new ConceptBook("Game Concepts")
            
            .add(new ConceptBookEntry("LudO")
                    .addDefaultTargets(new DeTarget("Spiel", De.NEUTER, De.NOMINATIVE, De.DATIVE, De.ACCUSATIVE), new DeTarget("Spieles", De.NEUTER, De.GENITIVE))
                    .addDefaultTargets(new EnTarget("game", En.NEUTER))
                    .addDefaultTargets(new EoTarget("ludo"))
                    .addDefaultTargets(new EsTarget("juego", Es.MASCULINE))
                    .addDefaultTargets(new FrTarget("jeu", Fr.MASCULINE))
            )
            .add(new ConceptBookEntry("HeroIcxO")
                    .addDefaultTargets(new DeTarget("Held", De.MASCULINE, De.NOMINATIVE), new DeTarget("Helden", De.MASCULINE, De.GENITIVE, De.DATIVE, De.ACCUSATIVE))
                    .addDefaultTargets(new EnTarget("hero", En.MASCULINE))
                    .addDefaultTargets(new EoTarget("heroo"))
                    .addDefaultTargets(new EsTarget("héroe", Es.MASCULINE))
                    .addDefaultTargets(new FrTarget("héros", Fr.MASCULINE))
            )
            .add(new ConceptBookEntry("HeroInO")
                    .addDefaultTargets(new DeTarget("Heldin", De.FEMININE, De.NOMINATIVE, De.GENITIVE, De.DATIVE, De.ACCUSATIVE))
                    .addDefaultTargets(new EnTarget("heroine", En.FEMININE))
                    .addDefaultTargets(new EoTarget("heroino"))
                    .addDefaultTargets(new EsTarget("heroína", Es.FEMININE))
                    .addDefaultTargets(new FrTarget("héroïne", Fr.FEMININE))
            )
            .add(new ConceptBookEntry("HavAs")
                    .addRequiredParts(Part.SU, Part.DOM, Part.FIN)
                    .addExcludedParts(Part.AL)
                    .addDefaultTargets(new DeTarget("habe", De.MI), new DeTarget("hast", De.BI), new DeTarget("hat", De.GXI), new DeTarget("haben", De.NI, De.ILI), new DeTarget("habt", De.VI))
                    .addDefaultTargets(new EnTarget("have", En.MI, En.BI, En.NI, En.VI, En.ILI), new EnTarget("has", En.GXI))
                    .addDefaultTargets(new EoTarget("havas"))
                    .addDefaultTargets(new EsTarget("tengo", Es.MI), new EsTarget("tienes", Es.BI), new EsTarget("tiene", Es.GXI), new EsTarget("tenemos", Es.NI), new EsTarget("tenéis", Es.VI), new EsTarget("tienen", Es.ILI))
                    .addDefaultTargets(new FrTarget("ai", Fr.MI), new FrTarget("as", Fr.BI), new FrTarget("a", Fr.GXI), new FrTarget("avons", Fr.NI), new FrTarget("avez", Fr.VI), new FrTarget("ont", Fr.ILI))
            )
            .add(new ConceptBookEntry("TrovAs")
                    .addRequiredParts(Part.SU, Part.DOM, Part.FIN)
                    .addExcludedParts(Part.AL)
                    .addDefaultTargets(new DeTarget("finde", De.MI), new DeTarget("findest", De.BI), new DeTarget("findet", De.GXI, De.VI), new DeTarget("finden", De.NI, De.ILI))
                    .addDefaultTargets(new EnTarget("find", En.MI, En.BI, En.NI, En.VI, En.ILI), new EnTarget("finds", En.GXI))
                    .addDefaultTargets(new EoTarget("trovas"))
                    .addDefaultTargets(new EsTarget("encuentro", Es.MI), new EsTarget("encuentras", Es.BI), new EsTarget("encuentra", Es.GXI), new EsTarget("encontramos", Es.NI), new EsTarget("encontráis", Es.VI), new EsTarget("encuentran", Es.ILI))
                    .addDefaultTargets(new FrTarget("trouve", Fr.MI, Fr.GXI), new FrTarget("trouves", Fr.BI), new FrTarget("trouvons", Fr.NI), new FrTarget("trouvez", Fr.VI), new FrTarget("trouvent", Fr.ILI))
            )
            .add(new ConceptBookEntry("DonAs")
                    .addRequiredParts(Part.SU, Part.DOM, Part.AL, Part.FIN)
                    .addDefaultTargets(new DeTarget("gebe", De.MI), new DeTarget("gibst", De.BI), new DeTarget("gibt", De.GXI), new DeTarget("geben", De.NI, De.ILI), new DeTarget("gebt", De.VI))
                    .addDefaultTargets(new EnTarget("give", En.MI, En.BI, En.NI, En.VI, En.ILI), new EnTarget("gives", En.GXI))
                    .addDefaultTargets(new EoTarget("donas"))
                    .addDefaultTargets(new EsTarget("doy", Es.MI), new EsTarget("das", Es.BI), new EsTarget("da", Es.GXI), new EsTarget("damos", Es.NI), new EsTarget("dais", Es.VI), new EsTarget("dan", Es.ILI))
                    .addDefaultTargets(new FrTarget("donne", Fr.MI, Fr.GXI), new FrTarget("donnes", Fr.BI), new FrTarget("donnons", Fr.NI), new FrTarget("donnez", Fr.VI), new FrTarget("donnent", Fr.ILI))
            )
            .add(new ConceptBookEntry("SkribIlO")
                    .addDefaultTargets(new DeTarget("Stift", De.MASCULINE, De.NOMINATIVE, De.DATIVE, De.ACCUSATIVE), new DeTarget("Stifts", De.MASCULINE, De.GENITIVE))
                    .addDefaultTargets(new EnTarget("pen", En.NEUTER))
                    .addDefaultTargets(new EoTarget("skribilo"))
                    .addDefaultTargets(new EsTarget("lapicero", Es.MASCULINE))
                    .addDefaultTargets(new FrTarget("crayon", Fr.MASCULINE))
            )
            .add(new ConceptBookEntry("FlorO")
                    .addDefaultTargets(new DeTarget("Blume", De.FEMININE, De.NOMINATIVE, De.GENITIVE, De.DATIVE, De.ACCUSATIVE))
                    .addDefaultTargets(new EnTarget("flower", En.NEUTER))
                    .addDefaultTargets(new EoTarget("floro"))
                    .addDefaultTargets(new EsTarget("flor", Es.FEMININE))
                    .addDefaultTargets(new FrTarget("fleur", Fr.FEMININE))
            )
            .add(new ConceptBookEntry("NomO")
                    .addDefaultTargets(new DeTarget("Name", De.MASCULINE, De.NOMINATIVE), new DeTarget("Namens", De.MASCULINE, De.GENITIVE), new DeTarget("Namen", De.MASCULINE, De.DATIVE, De.ACCUSATIVE))
                    .addDefaultTargets(new EnTarget("name", En.NEUTER))
                    .addDefaultTargets(new EoTarget("nomo"))
                    .addDefaultTargets(new EsTarget("nombre", Es.MASCULINE))
                    .addDefaultTargets(new FrTarget("nom", Fr.MASCULINE))
            )
            .add(new ConceptBookEntry("IcxO")
                    .addDefaultTargets(new DeTarget("Mann", De.MASCULINE, De.NOMINATIVE, De.DATIVE, De.ACCUSATIVE), new DeTarget("Mannes", De.MASCULINE, De.GENITIVE))
                    .addDefaultTargets(new EnTarget("man", En.MASCULINE))
                    .addDefaultTargets(new EoTarget("viro"))
                    .addDefaultTargets(new EsTarget("hombre", Es.MASCULINE))
                    .addDefaultTargets(new FrTarget("homme", Fr.MASCULINE))
            )
            .add(new ConceptBookEntry("InO")
                    .addDefaultTargets(new DeTarget("Frau", De.FEMININE, De.NOMINATIVE, De.GENITIVE, De.DATIVE, De.ACCUSATIVE))
                    .addDefaultTargets(new EnTarget("woman", En.FEMININE))
                    .addDefaultTargets(new EoTarget("virino"))
                    .addDefaultTargets(new EsTarget("mujer", Es.FEMININE))
                    .addDefaultTargets(new FrTarget("femme", Fr.FEMININE))
            )
            .add(new ConceptBookEntry("Mi")
                    .addDefaultTargets(new DeTarget("ich", De.MI))
                    .addDefaultTargets(new EnTarget("I", En.MI))
                    .addDefaultTargets(new EoTarget("mi"))
                    .addDefaultTargets(new EsTarget("yo", Es.MI))
                    .addDefaultTargets(new FrTarget("je", Fr.MI))
            )
            .add(new ConceptBookEntry("Bi")
                    .addDefaultTargets(new DeTarget("du", De.BI))
                    .addDefaultTargets(new EnTarget("you", En.BI))
                    .addDefaultTargets(new EoTarget("vi"))
                    .addDefaultTargets(new EsTarget("tú", Es.BI))
                    .addDefaultTargets(new FrTarget("tu", Fr.BI))
            )
            .add(new ConceptBookEntry("Gxi")
                    .addDefaultTargets(new DeTarget("es", De.GXI))
                    .addDefaultTargets(new EnTarget("it", En.GXI))
                    .addDefaultTargets(new EoTarget("ĝi"))
                    .addDefaultTargets(new EsTarget("él", Es.GXI))
                    .addDefaultTargets(new FrTarget("il", Fr.GXI))
            )
            .add(new ConceptBookEntry("Kaj")
                    .addDefaultTargets(new DeTarget("und"))
                    .addDefaultTargets(new EnTarget("and"))
                    .addDefaultTargets(new EoTarget("kaj"))
                    .addDefaultTargets(new EsTarget("y"))
                    .addDefaultTargets(new FrTarget("et"))
            )
            .add(new ConceptBookEntry("Aux")
                    .addDefaultTargets(new DeTarget("oder"))
                    .addDefaultTargets(new EnTarget("or"))
                    .addDefaultTargets(new EoTarget("aŭ"))
                    .addDefaultTargets(new EsTarget("o"))
                    .addDefaultTargets(new FrTarget("ou"))
            )
            .add(new ConceptBookEntry("Se")
                    .addDefaultTargets(new DeTarget("wenn"))
                    .addDefaultTargets(new EnTarget("if"))
                    .addDefaultTargets(new EoTarget("se"))
                    .addDefaultTargets(new EsTarget("si"))
                    .addDefaultTargets(new FrTarget("si"))
            )
            .addReferenceSources(
                    
                    "HeroIcxO TrovAs Fin SkribIlO .",
                    "HeroIcxO TrovAs Fin FlorO .",
                    "HeroInO TrovAs Fin SkribIlO .",
                    "Kaj HeroInO TrovAs Fin FlorO .",

                    "HeroIcxO HavAs Fin NomO .",
                    "HeroIcxO DonAs Al HeroInO Fin SkribIlO .",
                    "HeroIcxO DonAs Al HeroInO Fin FlorO .",
                    "HeroInO DonAs Al HeroIcxO Fin SkribIlO .",
                    "Kaj HeroInO DonAs Al HeroIcxO Fin FlorO .",

                    "HeroIcxO TrovAs Fin FlorO Kaj HeroInO TrovAs Fin SkribIlO .",
                    "HeroIcxO DonAs Al HeroInO Fin FlorO Kaj HeroInO DonAs Al HeroIcxO Fin SkribIlO .",
                    "HeroIcxO DonAs Al HeroInO Fin FlorO Aux HeroInO DonAs Al HeroIcxO Fin SkribIlO .",

                    "Fin SkribIlO Su HeroIcxO TrovAs . Fin NomO Al HeroIcxO DonAs HeroInO .",
                    "Fin SkribIlO TrovAs Su HeroIcxO Kaj TrovAs Fin FlorO Su HeroInO Kaj Al HeroIcxO Fin FlorO DonAs HeroInO .",
                    "Fin SkribIlO TrovAs Su HeroIcxO , TrovAs Fin FlorO Su HeroInO , Al HeroIcxO Fin FlorO DonAs HeroInO .",
                    "HeroIcxO TrovAs Fin SkribIlO . HeroIcxO HavAs Fin SkribIlO .",
                    
                    "Se HeroIcxO TrovAs Fin FlorO , HeroIcxO DonAs Fin FlorO Al HeroInO .",
                    "HeroIcxO DonAs Fin FlorO Al HeroInO Se HeroIcxO TrovAs Fin FlorO .",
                    
                    "La HeroIcxO TrovAs Fin La SkribIlO .",
                    "La HeroIcxO TrovAs Fin La FlorO .",
                    "La HeroInO TrovAs Fin La SkribIlO .",
                    "Kaj La HeroInO TrovAs Fin La FlorO .",

                    "La HeroIcxO HavAs Fin La NomO .",
                    "La HeroIcxO DonAs Al La HeroInO Fin La SkribIlO .",
                    "La HeroIcxO DonAs Al La HeroInO Fin La FlorO .",
                    "La HeroInO DonAs Al La HeroIcxO Fin La SkribIlO .",
                    "Kaj La HeroInO DonAs Al La HeroIcxO Fin La FlorO .",

                    "La HeroIcxO TrovAs Fin La FlorO Kaj La HeroInO TrovAs Fin La SkribIlO .",
                    "La HeroIcxO DonAs Al La HeroInO Fin La FlorO Kaj La HeroInO DonAs Al La HeroIcxO Fin La SkribIlO .",
                    "La HeroIcxO DonAs Al La HeroInO Fin La FlorO Aux La HeroInO DonAs Al La HeroIcxO Fin La SkribIlO .",

                    "Fin La SkribIlO Su La HeroIcxO TrovAs . Fin La NomO Al La HeroIcxO DonAs La HeroInO .",
                    "Fin La SkribIlO TrovAs Su La HeroIcxO Kaj TrovAs Fin La FlorO Su La HeroInO Kaj Al La HeroIcxO Fin La FlorO DonAs La HeroInO .",
                    "Fin La SkribIlO TrovAs Su La HeroIcxO , TrovAs Fin La FlorO Su La HeroInO , Al La HeroIcxO Fin La FlorO DonAs La HeroInO .",
                    "La HeroIcxO TrovAs Fin La SkribIlO . La HeroIcxO HavAs Fin La SkribIlO .",
                    
                    "Se La HeroIcxO TrovAs Fin La FlorO , La HeroIcxO DonAs Fin La FlorO Al La HeroInO .",
                    "La HeroIcxO DonAs Fin La FlorO Al La HeroInO Se La HeroIcxO TrovAs Fin La FlorO .",
                    
                    "Mi$La HeroIcxO TrovAs Fin Bi$La SkribIlO .",
                    "Bi$La HeroIcxO TrovAs Fin Mi$La FlorO .",
                    "IcxO$Gxi$La HeroInO TrovAs Fin LudO$Gxi$La SkribIlO .",
                    "Kaj InO$Gxi$La HeroInO TrovAs Fin InO$Bi$La FlorO .",

                    "IcxO$Mi$La HeroIcxO HavAs Fin HeroInO$Gxi$La NomO .",
                    "InO$Bi$La HeroIcxO DonAs Al HeroIcxO$Mi$La HeroInO Fin LudO$Gxi$La SkribIlO .",
                    "IcxO$Gxi$La HeroIcxO DonAs Al Bi$La HeroInO Fin Mi$La FlorO .",
                    "InO$Gxi$La HeroInO DonAs Al Mi$La HeroIcxO Fin Bi$La SkribIlO .",
                    "Kaj Gxi$La HeroInO DonAs Al Bi$La HeroIcxO Fin HeroInO$Gxi$La FlorO .",

                    "Mi$La HeroIcxO TrovAs Fin Bi$La FlorO Kaj Bi$La HeroInO TrovAs Fin Mi$La SkribIlO .",
                    "Bi$La HeroIcxO DonAs Al Mi$La HeroInO Fin LudO$Gxi$La FlorO Kaj Mi$La HeroInO DonAs Al InO$Bi$La HeroIcxO Fin HeroInO$Gxi$La SkribIlO .",
                    "LudO$Gxi$La HeroIcxO DonAs Al Mi$La HeroInO Fin Bi$La FlorO Aux Mi$La HeroInO DonAs Al Gxi$La HeroIcxO Fin Mi$La SkribIlO .",

                    "Fin Mi$La SkribIlO Su Bi$La HeroIcxO TrovAs . Fin Bi$La NomO Al Mi$La HeroIcxO DonAs Bi$La HeroInO .",
                    "Fin Bi$La SkribIlO TrovAs Su Mi$La HeroIcxO Kaj TrovAs Fin Bi$La FlorO Su Mi$La HeroInO Kaj Al Bi$La HeroIcxO Fin Mi$La FlorO DonAs Bi$La HeroInO .",
                    "Fin LudO$Gxi$La SkribIlO TrovAs Su Mi$La HeroIcxO , TrovAs Fin Bi$La FlorO Su Mi$La HeroInO , Al Bi$La HeroIcxO Fin Mi$La FlorO DonAs Bi$La HeroInO .",
                    "SkribIlO$Gxi$La HeroIcxO TrovAs Fin Bi$La SkribIlO . Mi$La HeroIcxO HavAs Fin Bi$La SkribIlO .",
                    
                    "Se Mi$La HeroIcxO TrovAs Fin Gxi$La FlorO , Mi$La HeroIcxO DonAs Fin Gxi$La FlorO Al Bi$La HeroInO .",
                    "Bi$La HeroIcxO DonAs Fin Gxi$La FlorO Al Mi$La HeroInO Se Bi$La HeroIcxO TrovAs Fin Gxi$La FlorO ."
            )
            ;
    
    private References() {
        // A private utility class constructor
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
        for (int i = 0; i < GAME_BOOK.getReferenceSources().size(); i++) {
            result.add(generateSingleGameTest(String.format("VerticalTranslation%03d", i), GAME_BOOK.getReferenceSources().get(i)));
        }
        return result.dec().line();
    }
    
    public static void main(final String[] arguments) {
        Logger.getAnonymousLogger().info(generateGameTests().toString());
    }
}

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.references;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;
import org.jesadido.poc.core.scripting.Src;
import org.jesadido.poc.core.semantics.ConceptBook;
import org.jesadido.poc.core.semantics.ConceptBookEntry;
import org.jesadido.poc.core.semantics.Part;
import org.jesadido.poc.core.semantics.translating.de.De;
import org.jesadido.poc.core.semantics.translating.de.DeTarget;
import org.jesadido.poc.core.semantics.translating.en.En;
import org.jesadido.poc.core.semantics.translating.en.EnTarget;
import org.jesadido.poc.core.semantics.translating.eo.Eo;
import org.jesadido.poc.core.semantics.translating.eo.EoTarget;
import org.jesadido.poc.core.semantics.translating.es.Es;
import org.jesadido.poc.core.semantics.translating.es.EsTarget;
import org.jesadido.poc.core.semantics.translating.fr.Fr;
import org.jesadido.poc.core.semantics.translating.fr.FrTarget;

public final class ReferenceConceptBooks {
    
    public static final ConceptBook GAME_CONCEPTS = new ConceptBook("game-concepts")
            
            .add(new ConceptBookEntry("LudO")
                    .addDefaultTargets(new DeTarget("Spiel", De.NEUTER, De.NOMINATIVE, De.DATIVE, De.ACCUSATIVE), new DeTarget("Spieles", De.NEUTER, De.GENITIVE))
                    .addDefaultTargets(new EnTarget("game", En.NEUTER))
                    .addDefaultTargets(new EoTarget("ludo", Eo.NEUTER))
                    .addDefaultTargets(new EsTarget("juego", Es.MASCULINE))
                    .addDefaultTargets(new FrTarget("jeu", Fr.MASCULINE))
            )
            .add(new ConceptBookEntry("GigantA")
                    .addDefaultTargets(new DeTarget("gigantisch"))
                    .addDefaultTargets(new EnTarget("gigantic"))
                    .addDefaultTargets(new EoTarget("giganta"))
                    .addDefaultTargets(new EsTarget("gigantesco", Es.MASCULINE, Es.PREPOSED), new EsTarget("gigantesca", Es.FEMININE, Es.PREPOSED))
                    .addDefaultTargets(new FrTarget("gigantesque", Fr.MASCULINE, Fr.FEMININE, Fr.PREPOSED))
            )
            .add(new ConceptBookEntry("MalGrandEgA")
                    .addDefaultTargets(new DeTarget("winzig"))
                    .addDefaultTargets(new EnTarget("tiny"))
                    .addDefaultTargets(new EoTarget("malgrandega"))
                    .addDefaultTargets(new EsTarget("menudo", Es.MASCULINE, Es.PREPOSED), new EsTarget("menuda", Es.FEMININE, Es.PREPOSED))
                    .addDefaultTargets(new FrTarget("infime", Fr.MASCULINE, Fr.FEMININE))
            )
            .add(new ConceptBookEntry("SunO")
                    .addDefaultTargets(new DeTarget("Sonne", De.FEMININE, De.NOMINATIVE, De.GENITIVE, De.DATIVE, De.ACCUSATIVE))
                    .addDefaultTargets(new EnTarget("sun", En.NEUTER))
                    .addDefaultTargets(new EoTarget("suno", Eo.NEUTER))
                    .addDefaultTargets(new EsTarget("sol", Es.MASCULINE))
                    .addDefaultTargets(new FrTarget("soleil", Fr.MASCULINE))
            )
            .add(new ConceptBookEntry("ArbO")
                    .addDefaultTargets(new DeTarget("Baum", De.MASCULINE, De.NOMINATIVE, De.DATIVE, De.ACCUSATIVE), new DeTarget("Baumes", De.MASCULINE, De.GENITIVE))
                    .addDefaultTargets(new EnTarget("tree", En.NEUTER))
                    .addDefaultTargets(new EoTarget("arbo", Eo.NEUTER))
                    .addDefaultTargets(new EsTarget("árbol", Es.MASCULINE))
                    .addDefaultTargets(new FrTarget("arbre", Fr.MASCULINE))
            )
            .addReferenceSources(
                    
                    "Mi$La LudO MalGrandEgA ..",
                    
                    "Ni$La LudO GigantA ..",
                    
                    "SunO .",
                    "ArbO .",
                    "SunO ..",
                    "ArbO .."
            )
            ;
    
    public static final ConceptBook TEST_CONCEPTS = new ConceptBook("test-concepts")
            
            .add(new ConceptBookEntry("LudO")
                    .addDefaultTargets(new DeTarget("Spiel", De.NEUTER, De.NOMINATIVE, De.DATIVE, De.ACCUSATIVE), new DeTarget("Spieles", De.NEUTER, De.GENITIVE))
                    .addDefaultTargets(new EnTarget("game", En.NEUTER))
                    .addDefaultTargets(new EoTarget("ludo", Eo.NEUTER))
                    .addDefaultTargets(new EsTarget("juego", Es.MASCULINE))
                    .addDefaultTargets(new FrTarget("jeu", Fr.MASCULINE))
            )
            .add(new ConceptBookEntry("SunO")
                    .addDefaultTargets(new DeTarget("Sonne", De.FEMININE, De.NOMINATIVE, De.GENITIVE, De.DATIVE, De.ACCUSATIVE))
                    .addDefaultTargets(new EnTarget("sun", En.NEUTER))
                    .addDefaultTargets(new EoTarget("suno", Eo.NEUTER))
                    .addDefaultTargets(new EsTarget("sol", Es.MASCULINE))
                    .addDefaultTargets(new FrTarget("soleil", Fr.MASCULINE))
            )
            .add(new ConceptBookEntry("LunO")
                    .addDefaultTargets(new DeTarget("Mond", De.MASCULINE, De.NOMINATIVE, De.DATIVE, De.ACCUSATIVE), new DeTarget("Mondes", De.MASCULINE, De.GENITIVE))
                    .addDefaultTargets(new EnTarget("moon", En.NEUTER))
                    .addDefaultTargets(new EoTarget("luno", Eo.NEUTER))
                    .addDefaultTargets(new EsTarget("luna", Es.FEMININE))
                    .addDefaultTargets(new FrTarget("lune", Fr.FEMININE))
            )
            .add(new ConceptBookEntry("ArbO")
                    .addDefaultTargets(new DeTarget("Baum", De.MASCULINE, De.NOMINATIVE, De.DATIVE, De.ACCUSATIVE), new DeTarget("Baumes", De.MASCULINE, De.GENITIVE))
                    .addDefaultTargets(new EnTarget("tree", En.NEUTER))
                    .addDefaultTargets(new EoTarget("arbo", Eo.NEUTER))
                    .addDefaultTargets(new EsTarget("árbol", Es.MASCULINE))
                    .addDefaultTargets(new FrTarget("arbre", Fr.MASCULINE))
            )
            .add(new ConceptBookEntry("HeroIcxO")
                    .addDefaultTargets(new DeTarget("Held", De.MASCULINE, De.NOMINATIVE), new DeTarget("Helden", De.MASCULINE, De.GENITIVE, De.DATIVE, De.ACCUSATIVE))
                    .addDefaultTargets(new EnTarget("hero", En.MASCULINE))
                    .addDefaultTargets(new EoTarget("heroo", Eo.MASCULINE))
                    .addDefaultTargets(new EsTarget("héroe", Es.MASCULINE))
                    .addDefaultTargets(new FrTarget("héros", Fr.MASCULINE))
            )
            .add(new ConceptBookEntry("HeroInO")
                    .addDefaultTargets(new DeTarget("Heldin", De.FEMININE, De.NOMINATIVE, De.GENITIVE, De.DATIVE, De.ACCUSATIVE))
                    .addDefaultTargets(new EnTarget("heroine", En.FEMININE))
                    .addDefaultTargets(new EoTarget("heroino", Eo.FEMININE))
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
                    .addDefaultTargets(new EoTarget("skribilo", Eo.NEUTER))
                    .addDefaultTargets(new EsTarget("lápiz", Es.MASCULINE))
                    .addDefaultTargets(new FrTarget("crayon", Fr.MASCULINE))
            )
            .add(new ConceptBookEntry("FlorO")
                    .addDefaultTargets(new DeTarget("Blume", De.FEMININE, De.NOMINATIVE, De.GENITIVE, De.DATIVE, De.ACCUSATIVE))
                    .addDefaultTargets(new EnTarget("flower", En.NEUTER))
                    .addDefaultTargets(new EoTarget("floro", Eo.NEUTER))
                    .addDefaultTargets(new EsTarget("flor", Es.FEMININE))
                    .addDefaultTargets(new FrTarget("fleur", Fr.FEMININE))
            )
            .add(new ConceptBookEntry("NomO")
                    .addDefaultTargets(new DeTarget("Name", De.MASCULINE, De.NOMINATIVE), new DeTarget("Namens", De.MASCULINE, De.GENITIVE), new DeTarget("Namen", De.MASCULINE, De.DATIVE, De.ACCUSATIVE))
                    .addDefaultTargets(new EnTarget("name", En.NEUTER))
                    .addDefaultTargets(new EoTarget("nomo", Eo.NEUTER))
                    .addDefaultTargets(new EsTarget("nombre", Es.MASCULINE))
                    .addDefaultTargets(new FrTarget("nom", Fr.MASCULINE))
            )
            .add(new ConceptBookEntry("IcxO")
                    .addDefaultTargets(new DeTarget("Mann", De.MASCULINE, De.NOMINATIVE, De.DATIVE, De.ACCUSATIVE), new DeTarget("Mannes", De.MASCULINE, De.GENITIVE))
                    .addDefaultTargets(new EnTarget("man", En.MASCULINE))
                    .addDefaultTargets(new EoTarget("viro", Eo.MASCULINE))
                    .addDefaultTargets(new EsTarget("hombre", Es.MASCULINE))
                    .addDefaultTargets(new FrTarget("homme", Fr.MASCULINE))
            )
            .add(new ConceptBookEntry("InO")
                    .addDefaultTargets(new DeTarget("Frau", De.FEMININE, De.NOMINATIVE, De.GENITIVE, De.DATIVE, De.ACCUSATIVE))
                    .addDefaultTargets(new EnTarget("woman", En.FEMININE))
                    .addDefaultTargets(new EoTarget("virino", Eo.FEMININE))
                    .addDefaultTargets(new EsTarget("mujer", Es.FEMININE))
                    .addDefaultTargets(new FrTarget("femme", Fr.FEMININE))
            )
            .add(new ConceptBookEntry("AtentA")
                    .addDefaultTargets(new DeTarget("aufmerksam"))
                    .addDefaultTargets(new EnTarget("attentive"))
                    .addDefaultTargets(new EoTarget("atenta"))
                    .addDefaultTargets(new EsTarget("atento", Es.MASCULINE), new EsTarget("atenta", Es.FEMININE))
                    .addDefaultTargets(new FrTarget("attentif", Fr.MASCULINE), new FrTarget("attentive", Fr.FEMININE))
            )
            .add(new ConceptBookEntry("GigantA")
                    .addDefaultTargets(new DeTarget("gigantisch"))
                    .addDefaultTargets(new EnTarget("gigantic"))
                    .addDefaultTargets(new EoTarget("giganta"))
                    .addDefaultTargets(new EsTarget("gigantesco", Es.MASCULINE, Es.PREPOSED), new EsTarget("gigantesca", Es.FEMININE, Es.PREPOSED))
                    .addDefaultTargets(new FrTarget("gigantesque", Fr.MASCULINE, Fr.FEMININE, Fr.PREPOSED))
            )
            .add(new ConceptBookEntry("KarA")
                    .addDefaultTargets(new DeTarget("lieb"))
                    .addDefaultTargets(new EnTarget("dear"))
                    .addDefaultTargets(new EoTarget("kara"))
                    .addDefaultTargets(new EsTarget("querido", Es.MASCULINE), new EsTarget("querida", Es.FEMININE))
                    .addDefaultTargets(new FrTarget("cher", Fr.MASCULINE, Fr.PREPOSED), new FrTarget("chère", Fr.FEMININE, Fr.PREPOSED))
            )
            .add(new ConceptBookEntry("KontentA")
                    .addDefaultTargets(new DeTarget("zufrieden"))
                    .addDefaultTargets(new EnTarget("satisfied"))
                    .addDefaultTargets(new EoTarget("kontenta"))
                    .addDefaultTargets(new EsTarget("satisfecho", Es.MASCULINE), new EsTarget("satisfecha", Es.FEMININE))
                    .addDefaultTargets(new FrTarget("satisfait", Fr.MASCULINE), new FrTarget("satisfaite", Fr.FEMININE))
            )
            .add(new ConceptBookEntry("KuragxA")
                    .addDefaultTargets(new DeTarget("beherzt"))
                    .addDefaultTargets(new EnTarget("valiant"))
                    .addDefaultTargets(new EoTarget("kuraĝa"))
                    .addDefaultTargets(new EsTarget("valiente", Es.MASCULINE, Es.FEMININE))
                    .addDefaultTargets(new FrTarget("courageux", Fr.MASCULINE), new FrTarget("courageuse", Fr.FEMININE))
            )
            .add(new ConceptBookEntry("MalGrandEgA")
                    .addDefaultTargets(new DeTarget("winzig"))
                    .addDefaultTargets(new EnTarget("tiny"))
                    .addDefaultTargets(new EoTarget("malgrandega"))
                    .addDefaultTargets(new EsTarget("menudo", Es.MASCULINE, Es.PREPOSED), new EsTarget("menuda", Es.FEMININE, Es.PREPOSED))
                    .addDefaultTargets(new FrTarget("infime", Fr.MASCULINE, Fr.FEMININE))
            )
            .add(new ConceptBookEntry("MalSanA")
                    .addDefaultTargets(new DeTarget("krank"))
                    .addDefaultTargets(new EnTarget("sick"))
                    .addDefaultTargets(new EoTarget("sana"))
                    .addDefaultTargets(new EsTarget("enfermo", Es.MASCULINE), new EsTarget("enferma", Es.FEMININE))
                    .addDefaultTargets(new FrTarget("malade", Fr.MASCULINE, Fr.FEMININE))
            )
            .add(new ConceptBookEntry("SanA")
                    .addDefaultTargets(new DeTarget("gesund"))
                    .addDefaultTargets(new EnTarget("sane"))
                    .addDefaultTargets(new EoTarget("sana"))
                    .addDefaultTargets(new EsTarget("sano", Es.MASCULINE), new EsTarget("sana", Es.FEMININE))
                    .addDefaultTargets(new FrTarget("sain", Fr.MASCULINE), new FrTarget("saine", Fr.FEMININE))
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
                    .addDefaultTargets(new DeTarget("er", De.GXI, De.MASCULINE), new DeTarget("sie", De.GXI, De.FEMININE), new DeTarget("es", De.GXI, De.NEUTER))
                    .addDefaultTargets(new EnTarget("he", En.GXI, En.MASCULINE), new EnTarget("she", En.GXI, En.FEMININE), new EnTarget("it", En.GXI, En.NEUTER))
                    .addDefaultTargets(new EoTarget("li", Eo.MASCULINE), new EoTarget("ŝi", Eo.FEMININE), new EoTarget("ĝi", Eo.NEUTER))
                    .addDefaultTargets(new EsTarget("él", Es.GXI, Es.MASCULINE), new EsTarget("ella", Es.GXI, Es.FEMININE))
                    .addDefaultTargets(new FrTarget("il", Fr.GXI, Fr.MASCULINE), new FrTarget("elle", Fr.GXI, Fr.FEMININE))
            )
            .add(new ConceptBookEntry("Ni")
                    .addDefaultTargets(new DeTarget("wir", De.NI))
                    .addDefaultTargets(new EnTarget("we", En.NI))
                    .addDefaultTargets(new EoTarget("ni"))
                    .addDefaultTargets(new EsTarget("nosotros", Es.NI, Es.MASCULINE), new EsTarget("nosotras", Es.NI, Es.MASCULINE))
                    .addDefaultTargets(new FrTarget("nous", Fr.NI))
            )
            .add(new ConceptBookEntry("Vi")
                    .addDefaultTargets(new DeTarget("ihr", De.VI))
                    .addDefaultTargets(new EnTarget("you", En.VI))
                    .addDefaultTargets(new EoTarget("vi"))
                    .addDefaultTargets(new EsTarget("vosotros", Es.VI, Es.MASCULINE), new EsTarget("vosotros", Es.VI, Es.MASCULINE))
                    .addDefaultTargets(new FrTarget("vous", Fr.VI))
            )
            .add(new ConceptBookEntry("Ili")
                    .addDefaultTargets(new DeTarget("sie", De.ILI))
                    .addDefaultTargets(new EnTarget("they", En.ILI))
                    .addDefaultTargets(new EoTarget("ili"))
                    .addDefaultTargets(new EsTarget("ellos", Es.ILI, Es.MASCULINE), new EsTarget("ellas", Es.ILI, Es.MASCULINE))
                    .addDefaultTargets(new FrTarget("ils", Fr.ILI, Fr.MASCULINE), new FrTarget("elles", Fr.ILI, Fr.FEMININE))
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
                    
                    "Mi$La LudO ..",
                    "Mi$La LudO MalGrandEgA ..",
                    "Mi$La LudO GigantA ..",
                    "Mi$La LudO MalGrandEgA .. Vi$La LudO GigantA ..",
                    "Mi$La LudO MalGrandEgA .. Bi$La HeroIcxO GigantA KontentA .. Ni$La FlorO ..",
                    
                    "LudO HavAs Fin HeroIcxO .",
                    "La LudO HavAs Fin La HeroIcxO .",
                    "Mi$La LudO HavAs Fin Bi$La HeroIcxO .",
                    "Ni$La LudO HavAs Fin Vi$La HeroIcxO .",
                    "Mi$La LudO HavAs Fin HeroIcxO .",
                    "Mi$La LudO MalGrandEgA HavAs Fin HeroIcxO SanA .",
                    
                    "SunO ..",
                    "SunO GigantA ..",
                    "LunO ..",
                    "LunO MalGrandEgA ..",
                    "ArbO ..",
                    "SunO .",
                    "SunO GigantA .",
                    "LunO .",
                    "LunO MalGrandEgA .",
                    "ArbO .",
                    
                    "HeroIcxO TrovAs Fin SkribIlO .",
                    "La HeroIcxO TrovAs Fin La SkribIlO .",
                    "Mi$La HeroIcxO TrovAs Fin Bi$La SkribIlO .",
                    "Vi$La HeroIcxO TrovAs Fin Ni$La SkribIlO .",
                    "Mi$La HeroIcxO TrovAs Fin La SkribIlO .",
                    "Mi$La HeroIcxO TrovAs Fin La SkribIlO GigantA KontentA .",
                    
                    "HeroIcxO TrovAs Fin FlorO .",
                    "La HeroIcxO TrovAs Fin La FlorO .",
                    "Bi$La HeroIcxO TrovAs Fin Mi$La FlorO .",
                    "Vi$La HeroIcxO TrovAs Fin Ni$La FlorO .",
                    "Vi$La HeroIcxO TrovAs Fin FlorO .",
                    "Vi$La HeroIcxO SanA KontentA GigantA TrovAs Fin FlorO .",
                    
                    "HeroInO TrovAs Fin SkribIlO .",
                    "La HeroInO TrovAs Fin La SkribIlO .",
                    "IcxO$Gxi$La HeroInO TrovAs Fin LudO$Gxi$La SkribIlO .",
                    "IcxArO$Ili$La HeroInO TrovAs Fin InArO$Ili$La SkribIlO .",
                    "La HeroInO TrovAs Fin LudO$Gxi$La SkribIlO .",
                    "La HeroInO GigantA KontentA TrovAs Fin LudO$Gxi$La SkribIlO GigantA .",
                    
                    "Kaj HeroInO TrovAs Fin FlorO .",
                    "Kaj La HeroInO TrovAs Fin La FlorO .",
                    "Kaj InO$Gxi$La HeroInO TrovAs Fin InO$Bi$La FlorO .",
                    "Kaj InArO$Ili$La HeroInO TrovAs Fin InArO$Vi$La FlorO .",
                    "Kaj HeroInO TrovAs Fin InArO$Vi$La FlorO .",
                    "Kaj HeroInO AtentA KontentA TrovAs Fin InArO$Vi$La FlorO GigantA SanA .",

                    "HeroIcxO HavAs Fin NomO .",
                    "La HeroIcxO HavAs Fin La NomO .",
                    "IcxO$Mi$La HeroIcxO HavAs Fin HeroInO$Gxi$La NomO .",
                    "IcxArO$Ni$La HeroIcxO HavAs Fin HeroInArO$Ili$La NomO .",
                    "IcxO$Mi$La HeroIcxO HavAs Fin NomO .",
                    "IcxO$Mi$La HeroIcxO KontentA HavAs Fin NomO GigantA .",
                    
                    "HeroIcxO DonAs Al HeroInO Fin SkribIlO .",
                    "La HeroIcxO DonAs Al La HeroInO Fin La SkribIlO .",
                    "InO$Bi$La HeroIcxO DonAs Al HeroIcxO$Mi$La HeroInO Fin LudO$Gxi$La SkribIlO .",
                    "InArO$Vi$La HeroIcxO DonAs Al HeroIcxArO$Ni$La HeroInO Fin LudArO$Ili$La SkribIlO .",
                    "HeroIcxO DonAs Al La HeroInO Fin SkribIlO .",
                    "HeroIcxO KontentA KuragxA DonAs Al La HeroInO SanA Fin SkribIlO .",
                    
                    "HeroIcxO DonAs Al HeroInO Fin FlorO .",
                    "La HeroIcxO DonAs Al La HeroInO Fin La FlorO .",
                    "IcxO$Gxi$La HeroIcxO DonAs Al Bi$La HeroInO Fin Mi$La FlorO .",
                    "Ili$La HeroIcxO DonAs Al Vi$La HeroInO Fin Ni$La FlorO .",
                    "HeroIcxO DonAs Al HeroInO Fin HomArO$Ni$La FlorO .",
                    "HeroIcxO GigantA DonAs Al HeroInO Fin HomArO$Ni$La FlorO GigantA .",
                    
                    "HeroInO DonAs Al HeroIcxO Fin SkribIlO .",
                    "La HeroInO DonAs Al La HeroIcxO Fin La SkribIlO .",
                    "InO$Gxi$La HeroInO DonAs Al Mi$La HeroIcxO Fin Bi$La SkribIlO .",
                    "InArO$Ili$La HeroInO DonAs Al Ni$La HeroIcxO Fin Vi$La SkribIlO .",
                    "HeroInO DonAs Al La HeroIcxO Fin Bi$La SkribIlO .",
                    "HeroInO GigantA AtentA DonAs Al La HeroIcxO GigantA KontentA Fin Bi$La SkribIlO GigantA .",
                    
                    "Kaj HeroInO DonAs Al HeroIcxO Fin FlorO .",
                    "Kaj La HeroInO DonAs Al La HeroIcxO Fin La FlorO .",
                    "Kaj Gxi$La HeroInO DonAs Al Bi$La HeroIcxO Fin HeroInO$Gxi$La FlorO .",
                    "Kaj Ili$La HeroInO DonAs Al Vi$La HeroIcxO Fin HeroInArO$Ili$La FlorO .",
                    "Kaj La HeroInO DonAs Al HeroIcxO Fin HeroInArO$Ili$La FlorO .",
                    "Kaj La HeroInO SanA AtentA KuragxA DonAs Al HeroIcxO KontentA Fin HeroInArO$Ili$La FlorO .",
                    
                    "HeroIcxO TrovAs Fin FlorO Kaj HeroInO TrovAs Fin SkribIlO .",
                    "La HeroIcxO TrovAs Fin La FlorO Kaj La HeroInO TrovAs Fin La SkribIlO .",
                    "Mi$La HeroIcxO TrovAs Fin Bi$La FlorO Kaj Bi$La HeroInO TrovAs Fin Mi$La SkribIlO .",
                    "Ni$La HeroIcxO TrovAs Fin Vi$La FlorO Kaj Vi$La HeroInO TrovAs Fin Ni$La SkribIlO .",
                    "La HeroIcxO TrovAs Fin FlorO Kaj Vi$La HeroInO TrovAs Fin SkribIlO .",
                    "La HeroIcxO KontentA TrovAs Fin FlorO GigantA Kaj Vi$La HeroInO TrovAs Fin SkribIlO GigantA .",
                    
                    "HeroIcxO DonAs Al HeroInO Fin FlorO Kaj HeroInO DonAs Al HeroIcxO Fin SkribIlO .",
                    "La HeroIcxO DonAs Al La HeroInO Fin La FlorO Kaj La HeroInO DonAs Al La HeroIcxO Fin La SkribIlO .",
                    "Bi$La HeroIcxO DonAs Al Mi$La HeroInO Fin LudO$Gxi$La FlorO Kaj Mi$La HeroInO DonAs Al InO$Bi$La HeroIcxO Fin HeroInO$Gxi$La SkribIlO .",
                    "Vi$La HeroIcxO DonAs Al Ni$La HeroInO Fin LudArO$Ili$La FlorO Kaj Ni$La HeroInO DonAs Al InArO$Vi$La HeroIcxO Fin HeroInArO$Ili$La SkribIlO .",
                    "Bi$La HeroIcxO DonAs Al HeroInO Fin La FlorO Kaj HeroInO DonAs Al HeroIcxO Fin SkribIlO .",
                    "Bi$La HeroIcxO KontentA AtentA DonAs Al HeroInO MalSanA KontentA Fin La FlorO Kaj HeroInO MalSanA DonAs Al HeroIcxO Fin SkribIlO .",
                    
                    "HeroIcxO DonAs Al HeroInO Fin FlorO Aux HeroInO DonAs Al HeroIcxO Fin SkribIlO .",
                    "La HeroIcxO DonAs Al La HeroInO Fin La FlorO Aux La HeroInO DonAs Al La HeroIcxO Fin La SkribIlO .",
                    "LudO$Gxi$La HeroIcxO DonAs Al Mi$La HeroInO Fin Bi$La FlorO Aux Mi$La HeroInO DonAs Al Gxi$La HeroIcxO Fin Mi$La SkribIlO .",
                    "LudArO$Ili$La HeroIcxO DonAs Al Ni$La HeroInO Fin Vi$La FlorO Aux Ni$La HeroInO DonAs Al Ili$La HeroIcxO Fin Ni$La SkribIlO .",
                    "HeroIcxO DonAs Al Ni$La HeroInO Fin FlorO Aux La HeroInO DonAs Al HeroIcxO Fin SkribIlO .",
                    "HeroIcxO SanA DonAs Al Ni$La HeroInO Fin FlorO Aux La HeroInO KontentA KuragxA DonAs Al HeroIcxO Fin SkribIlO .",

                    "Fin SkribIlO Su HeroIcxO TrovAs . Fin NomO Al HeroIcxO DonAs HeroInO .",
                    "Fin La SkribIlO Su La HeroIcxO TrovAs . Fin La NomO Al La HeroIcxO DonAs La HeroInO .",
                    "Fin Mi$La SkribIlO Su Bi$La HeroIcxO TrovAs . Fin Bi$La NomO Al Mi$La HeroIcxO DonAs Bi$La HeroInO .",
                    "Fin Ni$La SkribIlO Su Vi$La HeroIcxO TrovAs . Fin Vi$La NomO Al Ni$La HeroIcxO DonAs Vi$La HeroInO .",
                    "Fin SkribIlO Su Vi$La HeroIcxO TrovAs . Fin NomO Al Mi$La HeroIcxO DonAs La HeroInO .",
                    "Fin SkribIlO Su Vi$La HeroIcxO SanA TrovAs . Fin NomO GigantA KontentA Al Mi$La HeroIcxO DonAs La HeroInO .",
                    
                    "Fin SkribIlO TrovAs Su HeroIcxO Kaj TrovAs Fin FlorO Su HeroInO Kaj Al HeroIcxO Fin FlorO DonAs HeroInO .",
                    "Fin La SkribIlO TrovAs Su La HeroIcxO Kaj TrovAs Fin La FlorO Su La HeroInO Kaj Al La HeroIcxO Fin La FlorO DonAs La HeroInO .",
                    "Fin Bi$La SkribIlO TrovAs Su Mi$La HeroIcxO Kaj TrovAs Fin Bi$La FlorO Su Mi$La HeroInO Kaj Al Bi$La HeroIcxO Fin Mi$La FlorO DonAs Bi$La HeroInO .",
                    "Fin Vi$La SkribIlO TrovAs Su Ni$La HeroIcxO Kaj TrovAs Fin Vi$La FlorO Su Ni$La HeroInO Kaj Al Vi$La HeroIcxO Fin Ni$La FlorO DonAs Vi$La HeroInO .",
                    "Fin Bi$La SkribIlO TrovAs Su HeroIcxO Kaj TrovAs Fin FlorO Su Ni$La HeroInO Kaj Al La HeroIcxO Fin FlorO DonAs Bi$La HeroInO .",
                    "Fin Bi$La SkribIlO GigantA AtentA TrovAs Su HeroIcxO SanA Kaj TrovAs Fin FlorO Su Ni$La HeroInO Kaj Al La HeroIcxO Fin FlorO GigantA DonAs Bi$La HeroInO .",
                    
                    "Fin SkribIlO TrovAs Su HeroIcxO , TrovAs Fin FlorO Su HeroInO , Al HeroIcxO Fin FlorO DonAs HeroInO .",
                    "Fin La SkribIlO TrovAs Su La HeroIcxO , TrovAs Fin La FlorO Su La HeroInO , Al La HeroIcxO Fin La FlorO DonAs La HeroInO .",
                    "Fin LudO$Gxi$La SkribIlO TrovAs Su Mi$La HeroIcxO , TrovAs Fin Bi$La FlorO Su Mi$La HeroInO , Al Bi$La HeroIcxO Fin Mi$La FlorO DonAs Bi$La HeroInO .",
                    "Fin LudArO$Ili$La SkribIlO TrovAs Su Ni$La HeroIcxO , TrovAs Fin Vi$La FlorO Su Ni$La HeroInO , Al Vi$La HeroIcxO Fin Ni$La FlorO DonAs Vi$La HeroInO .",
                    "Fin La SkribIlO TrovAs Su HeroIcxO , TrovAs Fin FlorO Su Ni$La HeroInO , Al HeroIcxO Fin Mi$La FlorO DonAs Bi$La HeroInO .",
                    "Fin La SkribIlO TrovAs Su HeroIcxO GigantA , TrovAs Fin FlorO Su Ni$La HeroInO GigantA , Al HeroIcxO GigantA Fin Mi$La FlorO DonAs Bi$La HeroInO GigantA .",
                    
                    "HeroIcxO TrovAs Fin SkribIlO . HeroIcxO HavAs Fin SkribIlO .",
                    "La HeroIcxO TrovAs Fin La SkribIlO . La HeroIcxO HavAs Fin La SkribIlO .",
                    "SkribIlO$Gxi$La HeroIcxO TrovAs Fin Bi$La SkribIlO . Mi$La HeroIcxO HavAs Fin Bi$La SkribIlO .",
                    "SkribIlArO$Ili$La HeroIcxO TrovAs Fin Vi$La SkribIlO . Ni$La HeroIcxO HavAs Fin Vi$La SkribIlO .",
                    "La HeroIcxO TrovAs Fin SkribIlO . HeroIcxO HavAs Fin Ili$La SkribIlO .",
                    "La HeroIcxO KontentA SanA TrovAs Fin SkribIlO . HeroIcxO SanA KontentA HavAs Fin Ili$La SkribIlO .",
                    
                    "Se HeroIcxO TrovAs Fin FlorO , HeroIcxO DonAs Fin FlorO Al HeroInO .",
                    "Se La HeroIcxO TrovAs Fin La FlorO , La HeroIcxO DonAs Fin La FlorO Al La HeroInO .",
                    "Se Mi$La HeroIcxO TrovAs Fin Gxi$La FlorO , Mi$La HeroIcxO DonAs Fin Gxi$La FlorO Al Bi$La HeroInO .",
                    "Se Ni$La HeroIcxO TrovAs Fin Ili$La FlorO , Ni$La HeroIcxO DonAs Fin Ili$La FlorO Al Vi$La HeroInO .",
                    "Se Mi$La HeroIcxO TrovAs Fin La FlorO , HeroIcxO DonAs Fin FlorO Al HeroInO .",
                    "Se Mi$La HeroIcxO GigantA TrovAs Fin La FlorO SanA , HeroIcxO GigantA KontentA SanA DonAs Fin FlorO SanA Al HeroInO .",
                    
                    "HeroIcxO DonAs Fin FlorO Al HeroInO Se HeroIcxO TrovAs Fin FlorO .",
                    "La HeroIcxO DonAs Fin La FlorO Al La HeroInO Se La HeroIcxO TrovAs Fin La FlorO .",
                    "Bi$La HeroIcxO DonAs Fin Gxi$La FlorO Al Mi$La HeroInO Se Bi$La HeroIcxO TrovAs Fin Gxi$La FlorO .",
                    "Vi$La HeroIcxO DonAs Fin Ili$La FlorO Al Ni$La HeroInO Se Vi$La HeroIcxO TrovAs Fin Ili$La FlorO .",
                    "Vi$La HeroIcxO DonAs Fin FlorO Al Mi$La HeroInO Se La HeroIcxO TrovAs Fin FlorO .",
                    "Vi$La HeroIcxO KontentA GigantA KuragxA DonAs Fin FlorO Al Mi$La HeroInO Se La HeroIcxO KontentA TrovAs Fin FlorO ."
            )
            ;
    
    private static final Map<ConceptBook, ConceptBookTestsGenerator> CONCEPT_BOOK_TESTS_GENERATORS = new LinkedHashMap<>();
    
    static {
        CONCEPT_BOOK_TESTS_GENERATORS.put(GAME_CONCEPTS, new ConceptBookTestsGenerator(GAME_CONCEPTS, "ReferenceConceptBooks.GAME_CONCEPTS", "GameConcepts"));
        CONCEPT_BOOK_TESTS_GENERATORS.put(TEST_CONCEPTS, new ConceptBookTestsGenerator(TEST_CONCEPTS, "ReferenceConceptBooks.TEST_CONCEPTS", "TestConcepts"));
    }
    
    private ReferenceConceptBooks() {
        // A private utility class constructor
    }
    
    public static Collection<ConceptBook> getConceptBooks() {
        return Collections.unmodifiableCollection(CONCEPT_BOOK_TESTS_GENERATORS.keySet());
    }
    
    public static Src generateTests(final ConceptBook conceptBook) {
        if (CONCEPT_BOOK_TESTS_GENERATORS.containsKey(conceptBook)) {
            return CONCEPT_BOOK_TESTS_GENERATORS.get(conceptBook).generate();
        }
        return new Src();
    }
    
    public static void main(final String[] arguments) {
        getConceptBooks().stream().forEach(conceptBook -> Logger.getAnonymousLogger().info(generateTests(conceptBook).toString()));
    }
}

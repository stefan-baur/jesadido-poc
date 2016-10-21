/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.references;

import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.semantics.translating.TranslatorFactory;
import org.junit.Assert;
import org.junit.Test;

public class TestConcepts005Test {
    
    @Test
    public void testMethod000TestConcepts20161002090946MESZ() {
        final String source = "Mi$La LudO ..";
        Assert.assertEquals("{ Su ( Mi$La LudO ) } ..", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mein Spiel", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("My game", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mia ludo", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mi juego", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mon jeu", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod001TestConcepts20161002090946MESZ() {
        final String source = "Mi$La LudO MalGrandEgA ..";
        Assert.assertEquals("{ Su ( Mi$La LudO MalGrandEgA ) } ..", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mein winziges Spiel", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("My tiny game", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mia malgrandega ludo", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mi menudo juego", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mon jeu infime", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod002TestConcepts20161002090946MESZ() {
        final String source = "Mi$La LudO GigantA ..";
        Assert.assertEquals("{ Su ( Mi$La LudO GigantA ) } ..", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mein gigantisches Spiel", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("My gigantic game", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mia giganta ludo", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mi gigantesco juego", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mon gigantesque jeu", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod003TestConcepts20161002090946MESZ() {
        final String source = "Mi$La LudO MalGrandEgA .. Vi$La LudO GigantA ..";
        Assert.assertEquals("{ Su ( Mi$La LudO MalGrandEgA ) } .. { Su ( Vi$La LudO GigantA ) } ..", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mein winziges Spiel; Euer gigantisches Spiel", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("My tiny game; Your gigantic game", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mia malgrandega ludo; Via giganta ludo", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mi menudo juego; Vuestro gigantesco juego", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mon jeu infime; Votre gigantesque jeu", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod004TestConcepts20161002090946MESZ() {
        final String source = "Mi$La LudO MalGrandEgA .. Bi$La HeroIcxO GigantA KontentA .. Ni$La FlorO ..";
        Assert.assertEquals("{ Su ( Mi$La LudO MalGrandEgA ) } .. { Su ( Bi$La HeroIcxO GigantA KontentA ) } .. { Su ( Ni$La FlorO ) } ..", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mein winziges Spiel; Dein gigantischer und zufriedener Held; Unsere Blume", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("My tiny game; Your gigantic and satisfied hero; Our flower", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mia malgrandega ludo; Via giganta kaj kontenta heroo; Nia floro", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mi menudo juego; Tu gigantesco héroe satisfecho; Nuestra flor", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mon jeu infime; Ton gigantesque héros satisfait; Notre fleur", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod005TestConcepts20161002090946MESZ() {
        final String source = "LudO HavAs Fin HeroIcxO .";
        Assert.assertEquals("{ Su ( LudO ) Dom ( HavAs ) Fin ( HeroIcxO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ein Spiel hat einen Helden.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("A game has a hero.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ludo havas heroon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un juego tiene un héroe.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un jeu a un héros.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod006TestConcepts20161002090946MESZ() {
        final String source = "La LudO HavAs Fin La HeroIcxO .";
        Assert.assertEquals("{ Su ( La LudO ) Dom ( HavAs ) Fin ( La HeroIcxO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Das Spiel hat den Helden.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("The game has the hero.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("La ludo havas la heroon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("El juego tiene el héroe.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Le jeu a l'héros.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod007TestConcepts20161002090946MESZ() {
        final String source = "Mi$La LudO HavAs Fin Bi$La HeroIcxO .";
        Assert.assertEquals("{ Su ( Mi$La LudO ) Dom ( HavAs ) Fin ( Bi$La HeroIcxO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mein Spiel hat deinen Helden.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("My game has your hero.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mia ludo havas vian heroon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mi juego tiene tu héroe.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mon jeu a ton héros.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod008TestConcepts20161002090946MESZ() {
        final String source = "Ni$La LudO HavAs Fin Vi$La HeroIcxO .";
        Assert.assertEquals("{ Su ( Ni$La LudO ) Dom ( HavAs ) Fin ( Vi$La HeroIcxO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Unser Spiel hat euren Helden.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Our game has your hero.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Nia ludo havas vian heroon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Nuestro juego tiene vuestro héroe.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Notre jeu a votre héros.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod009TestConcepts20161002090946MESZ() {
        final String source = "Mi$La LudO HavAs Fin HeroIcxO .";
        Assert.assertEquals("{ Su ( Mi$La LudO ) Dom ( HavAs ) Fin ( HeroIcxO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mein Spiel hat einen Helden.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("My game has a hero.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mia ludo havas heroon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mi juego tiene un héroe.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mon jeu a un héros.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod010TestConcepts20161002090946MESZ() {
        final String source = "Mi$La LudO MalGrandEgA HavAs Fin HeroIcxO SanA .";
        Assert.assertEquals("{ Su ( Mi$La LudO MalGrandEgA ) Dom ( HavAs ) Fin ( HeroIcxO SanA ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mein winziges Spiel hat einen gesunden Helden.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("My tiny game has a sane hero.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mia malgrandega ludo havas sanan heroon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mi menudo juego tiene un héroe sano.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mon jeu infime a un héros sain.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod011TestConcepts20161002090946MESZ() {
        final String source = "HeroIcxO TrovAs Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( TrovAs ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ein Held findet einen Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("A hero finds a pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Heroo trovas skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héroe encuentra un lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héros trouve un crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod012TestConcepts20161002090946MESZ() {
        final String source = "La HeroIcxO TrovAs Fin La SkribIlO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( TrovAs ) Fin ( La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Der Held findet den Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("The hero finds the pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("La heroo trovas la skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("El héroe encuentra el lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("L'héros trouve le crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod013TestConcepts20161002090946MESZ() {
        final String source = "Mi$La HeroIcxO TrovAs Fin Bi$La SkribIlO .";
        Assert.assertEquals("{ Su ( Mi$La HeroIcxO ) Dom ( TrovAs ) Fin ( Bi$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mein Held findet deinen Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("My hero finds your pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mia heroo trovas vian skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mi héroe encuentra tu lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mon héros trouve ton crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod014TestConcepts20161002090946MESZ() {
        final String source = "Vi$La HeroIcxO TrovAs Fin Ni$La SkribIlO .";
        Assert.assertEquals("{ Su ( Vi$La HeroIcxO ) Dom ( TrovAs ) Fin ( Ni$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Euer Held findet unseren Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Your hero finds our pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Via heroo trovas nian skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Vuestro héroe encuentra nuestro lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Votre héros trouve notre crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod015TestConcepts20161002090946MESZ() {
        final String source = "Mi$La HeroIcxO TrovAs Fin La SkribIlO .";
        Assert.assertEquals("{ Su ( Mi$La HeroIcxO ) Dom ( TrovAs ) Fin ( La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mein Held findet den Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("My hero finds the pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mia heroo trovas la skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mi héroe encuentra el lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mon héros trouve le crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod016TestConcepts20161002090946MESZ() {
        final String source = "Mi$La HeroIcxO TrovAs Fin La SkribIlO GigantA KontentA .";
        Assert.assertEquals("{ Su ( Mi$La HeroIcxO ) Dom ( TrovAs ) Fin ( La SkribIlO GigantA KontentA ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mein Held findet den gigantischen und zufriedenen Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("My hero finds the gigantic and satisfied pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mia heroo trovas la gigantan kaj kontentan skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mi héroe encuentra el gigantesco lápiz satisfecho.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mon héros trouve le gigantesque crayon satisfait.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod017TestConcepts20161002090946MESZ() {
        final String source = "HeroIcxO TrovAs Fin FlorO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( TrovAs ) Fin ( FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ein Held findet eine Blume.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("A hero finds a flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Heroo trovas floron.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héroe encuentra una flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héros trouve une fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod018TestConcepts20161002090946MESZ() {
        final String source = "La HeroIcxO TrovAs Fin La FlorO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( TrovAs ) Fin ( La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Der Held findet die Blume.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("The hero finds the flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("La heroo trovas la floron.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("El héroe encuentra la flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("L'héros trouve la fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod019TestConcepts20161002090946MESZ() {
        final String source = "Bi$La HeroIcxO TrovAs Fin Mi$La FlorO .";
        Assert.assertEquals("{ Su ( Bi$La HeroIcxO ) Dom ( TrovAs ) Fin ( Mi$La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Dein Held findet meine Blume.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Your hero finds my flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Via heroo trovas mian floron.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Tu héroe encuentra mi flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ton héros trouve ma fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod020TestConcepts20161002090946MESZ() {
        final String source = "Vi$La HeroIcxO TrovAs Fin Ni$La FlorO .";
        Assert.assertEquals("{ Su ( Vi$La HeroIcxO ) Dom ( TrovAs ) Fin ( Ni$La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Euer Held findet unsere Blume.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Your hero finds our flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Via heroo trovas nian floron.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Vuestro héroe encuentra nuestra flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Votre héros trouve notre fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod021TestConcepts20161002090946MESZ() {
        final String source = "Vi$La HeroIcxO TrovAs Fin FlorO .";
        Assert.assertEquals("{ Su ( Vi$La HeroIcxO ) Dom ( TrovAs ) Fin ( FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Euer Held findet eine Blume.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Your hero finds a flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Via heroo trovas floron.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Vuestro héroe encuentra una flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Votre héros trouve une fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod022TestConcepts20161002090946MESZ() {
        final String source = "Vi$La HeroIcxO SanA KontentA GigantA TrovAs Fin FlorO .";
        Assert.assertEquals("{ Su ( Vi$La HeroIcxO SanA KontentA GigantA ) Dom ( TrovAs ) Fin ( FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Euer gesunder, zufriedener und gigantischer Held findet eine Blume.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Your sane, satisfied and gigantic hero finds a flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Via sana, kontenta kaj giganta heroo trovas floron.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Vuestro gigantesco héroe sano y satisfecho encuentra una flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Votre gigantesque héros sain et satisfait trouve une fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod023TestConcepts20161002090946MESZ() {
        final String source = "HeroInO TrovAs Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroInO ) Dom ( TrovAs ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Eine Heldin findet einen Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("A heroine finds a pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Heroino trovas skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Una heroína encuentra un lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Une héroïne trouve un crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod024TestConcepts20161002090946MESZ() {
        final String source = "La HeroInO TrovAs Fin La SkribIlO .";
        Assert.assertEquals("{ Su ( La HeroInO ) Dom ( TrovAs ) Fin ( La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Die Heldin findet den Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("The heroine finds the pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("La heroino trovas la skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("La heroína encuentra el lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("L'héroïne trouve le crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod025TestConcepts20161002090946MESZ() {
        final String source = "IcxO$Gxi$La HeroInO TrovAs Fin LudO$Gxi$La SkribIlO .";
        Assert.assertEquals("{ Su ( IcxO$Gxi$La HeroInO ) Dom ( TrovAs ) Fin ( LudO$Gxi$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Seine Heldin findet seinen Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("His heroine finds its pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Lia heroino trovas ĝian skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Su heroína encuentra su lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("S'héroïne trouve son crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod026TestConcepts20161002090946MESZ() {
        final String source = "IcxArO$Ili$La HeroInO TrovAs Fin InArO$Ili$La SkribIlO .";
        Assert.assertEquals("{ Su ( IcxArO$Ili$La HeroInO ) Dom ( TrovAs ) Fin ( InArO$Ili$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ihre Heldin findet ihren Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Their heroine finds their pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ilia heroino trovas ilian skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Su heroína encuentra su lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Leur héroïne trouve leur crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod027TestConcepts20161002090946MESZ() {
        final String source = "La HeroInO TrovAs Fin LudO$Gxi$La SkribIlO .";
        Assert.assertEquals("{ Su ( La HeroInO ) Dom ( TrovAs ) Fin ( LudO$Gxi$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Die Heldin findet seinen Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("The heroine finds its pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("La heroino trovas ĝian skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("La heroína encuentra su lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("L'héroïne trouve son crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod028TestConcepts20161002090946MESZ() {
        final String source = "La HeroInO GigantA KontentA TrovAs Fin LudO$Gxi$La SkribIlO GigantA .";
        Assert.assertEquals("{ Su ( La HeroInO GigantA KontentA ) Dom ( TrovAs ) Fin ( LudO$Gxi$La SkribIlO GigantA ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Die gigantische und zufriedene Heldin findet seinen gigantischen Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("The gigantic and satisfied heroine finds its gigantic pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("La giganta kaj kontenta heroino trovas ĝian gigantan skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("La gigantesca heroína satisfecha encuentra su gigantesco lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("La gigantesque héroïne satisfaite trouve son gigantesque crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod029TestConcepts20161002090946MESZ() {
        final String source = "Kaj HeroInO TrovAs Fin FlorO .";
        Assert.assertEquals("Kaj { Su ( HeroInO ) Dom ( TrovAs ) Fin ( FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Und eine Heldin findet eine Blume.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("And a heroine finds a flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Kaj heroino trovas floron.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Y una heroína encuentra una flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Et une héroïne trouve une fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod030TestConcepts20161002090946MESZ() {
        final String source = "Kaj La HeroInO TrovAs Fin La FlorO .";
        Assert.assertEquals("Kaj { Su ( La HeroInO ) Dom ( TrovAs ) Fin ( La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Und die Heldin findet die Blume.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("And the heroine finds the flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Kaj la heroino trovas la floron.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Y la heroína encuentra la flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Et l'héroïne trouve la fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod031TestConcepts20161002090946MESZ() {
        final String source = "Kaj InO$Gxi$La HeroInO TrovAs Fin InO$Bi$La FlorO .";
        Assert.assertEquals("Kaj { Su ( InO$Gxi$La HeroInO ) Dom ( TrovAs ) Fin ( InO$Bi$La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Und ihre Heldin findet deine Blume.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("And her heroine finds your flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Kaj ŝia heroino trovas vian floron.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Y su heroína encuentra tu flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Et s'héroïne trouve ta fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod032TestConcepts20161002090946MESZ() {
        final String source = "Kaj InArO$Ili$La HeroInO TrovAs Fin InArO$Vi$La FlorO .";
        Assert.assertEquals("Kaj { Su ( InArO$Ili$La HeroInO ) Dom ( TrovAs ) Fin ( InArO$Vi$La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Und ihre Heldin findet eure Blume.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("And their heroine finds your flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Kaj ilia heroino trovas vian floron.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Y su heroína encuentra vuestra flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Et leur héroïne trouve votre fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod033TestConcepts20161002090946MESZ() {
        final String source = "Kaj HeroInO TrovAs Fin InArO$Vi$La FlorO .";
        Assert.assertEquals("Kaj { Su ( HeroInO ) Dom ( TrovAs ) Fin ( InArO$Vi$La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Und eine Heldin findet eure Blume.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("And a heroine finds your flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Kaj heroino trovas vian floron.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Y una heroína encuentra vuestra flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Et une héroïne trouve votre fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod034TestConcepts20161002090946MESZ() {
        final String source = "Kaj HeroInO AtentA KontentA TrovAs Fin InArO$Vi$La FlorO GigantA SanA .";
        Assert.assertEquals("Kaj { Su ( HeroInO AtentA KontentA ) Dom ( TrovAs ) Fin ( InArO$Vi$La FlorO GigantA SanA ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Und eine aufmerksame und zufriedene Heldin findet eure gigantische und gesunde Blume.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("And an attentive and satisfied heroine finds your gigantic and sane flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Kaj atenta kaj kontenta heroino trovas vian gigantan kaj sanan floron.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Y una heroína atenta y satisfecha encuentra vuestra gigantesca flor sana.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Et une héroïne attentive et satisfaite trouve votre gigantesque fleur saine.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod035TestConcepts20161002090946MESZ() {
        final String source = "HeroIcxO HavAs Fin NomO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( HavAs ) Fin ( NomO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ein Held hat einen Namen.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("A hero has a name.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Heroo havas nomon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héroe tiene un nombre.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héros a un nom.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod036TestConcepts20161002090946MESZ() {
        final String source = "La HeroIcxO HavAs Fin La NomO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( HavAs ) Fin ( La NomO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Der Held hat den Namen.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("The hero has the name.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("La heroo havas la nomon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("El héroe tiene el nombre.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("L'héros a le nom.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod037TestConcepts20161002090946MESZ() {
        final String source = "IcxO$Mi$La HeroIcxO HavAs Fin HeroInO$Gxi$La NomO .";
        Assert.assertEquals("{ Su ( IcxO$Mi$La HeroIcxO ) Dom ( HavAs ) Fin ( HeroInO$Gxi$La NomO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mein Held hat ihren Namen.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("My hero has her name.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mia heroo havas ŝian nomon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mi héroe tiene su nombre.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mon héros a son nom.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod038TestConcepts20161002090946MESZ() {
        final String source = "IcxArO$Ni$La HeroIcxO HavAs Fin HeroInArO$Ili$La NomO .";
        Assert.assertEquals("{ Su ( IcxArO$Ni$La HeroIcxO ) Dom ( HavAs ) Fin ( HeroInArO$Ili$La NomO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Unser Held hat ihren Namen.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Our hero has their name.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Nia heroo havas ilian nomon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Nuestro héroe tiene su nombre.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Notre héros a leur nom.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod039TestConcepts20161002090946MESZ() {
        final String source = "IcxO$Mi$La HeroIcxO HavAs Fin NomO .";
        Assert.assertEquals("{ Su ( IcxO$Mi$La HeroIcxO ) Dom ( HavAs ) Fin ( NomO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mein Held hat einen Namen.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("My hero has a name.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mia heroo havas nomon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mi héroe tiene un nombre.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mon héros a un nom.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod040TestConcepts20161002090946MESZ() {
        final String source = "IcxO$Mi$La HeroIcxO KontentA HavAs Fin NomO GigantA .";
        Assert.assertEquals("{ Su ( IcxO$Mi$La HeroIcxO KontentA ) Dom ( HavAs ) Fin ( NomO GigantA ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mein zufriedener Held hat einen gigantischen Namen.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("My satisfied hero has a gigantic name.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mia kontenta heroo havas gigantan nomon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mi héroe satisfecho tiene un gigantesco nombre.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mon héros satisfait a un gigantesque nom.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod041TestConcepts20161002090946MESZ() {
        final String source = "HeroIcxO DonAs Al HeroInO Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( DonAs ) Al ( HeroInO ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ein Held gibt einer Heldin einen Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("A hero gives a heroine a pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Heroo donas al heroino skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héroe da a una heroína un lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héros donne à une héroïne un crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod042TestConcepts20161002090946MESZ() {
        final String source = "La HeroIcxO DonAs Al La HeroInO Fin La SkribIlO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( DonAs ) Al ( La HeroInO ) Fin ( La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Der Held gibt der Heldin den Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("The hero gives the heroine the pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("La heroo donas al la heroino la skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("El héroe da a la heroína el lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("L'héros donne à l'héroïne le crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod043TestConcepts20161002090946MESZ() {
        final String source = "InO$Bi$La HeroIcxO DonAs Al HeroIcxO$Mi$La HeroInO Fin LudO$Gxi$La SkribIlO .";
        Assert.assertEquals("{ Su ( InO$Bi$La HeroIcxO ) Dom ( DonAs ) Al ( HeroIcxO$Mi$La HeroInO ) Fin ( LudO$Gxi$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Dein Held gibt meiner Heldin seinen Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Your hero gives my heroine its pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Via heroo donas al mia heroino ĝian skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Tu héroe da a mi heroína su lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ton héros donne à m'héroïne son crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod044TestConcepts20161002090946MESZ() {
        final String source = "InArO$Vi$La HeroIcxO DonAs Al HeroIcxArO$Ni$La HeroInO Fin LudArO$Ili$La SkribIlO .";
        Assert.assertEquals("{ Su ( InArO$Vi$La HeroIcxO ) Dom ( DonAs ) Al ( HeroIcxArO$Ni$La HeroInO ) Fin ( LudArO$Ili$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Euer Held gibt unserer Heldin ihren Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Your hero gives our heroine their pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Via heroo donas al nia heroino ilian skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Vuestro héroe da a nuestra heroína su lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Votre héros donne à notre héroïne leur crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod045TestConcepts20161002090946MESZ() {
        final String source = "HeroIcxO DonAs Al La HeroInO Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( DonAs ) Al ( La HeroInO ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ein Held gibt der Heldin einen Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("A hero gives the heroine a pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Heroo donas al la heroino skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héroe da a la heroína un lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héros donne à l'héroïne un crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod046TestConcepts20161002090946MESZ() {
        final String source = "HeroIcxO KontentA KuragxA DonAs Al La HeroInO SanA Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroIcxO KontentA KuragxA ) Dom ( DonAs ) Al ( La HeroInO SanA ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ein zufriedener und beherzter Held gibt der gesunden Heldin einen Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("A satisfied and valiant hero gives the sane heroine a pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Kontenta kaj kuraĝa heroo donas al la sana heroino skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héroe satisfecho y valiente da a la heroína sana un lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héros satisfait et courageux donne à l'héroïne saine un crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod047TestConcepts20161002090946MESZ() {
        final String source = "HeroIcxO DonAs Al HeroInO Fin FlorO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( DonAs ) Al ( HeroInO ) Fin ( FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ein Held gibt einer Heldin eine Blume.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("A hero gives a heroine a flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Heroo donas al heroino floron.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héroe da a una heroína una flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héros donne à une héroïne une fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod048TestConcepts20161002090946MESZ() {
        final String source = "La HeroIcxO DonAs Al La HeroInO Fin La FlorO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( DonAs ) Al ( La HeroInO ) Fin ( La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Der Held gibt der Heldin die Blume.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("The hero gives the heroine the flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("La heroo donas al la heroino la floron.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("El héroe da a la heroína la flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("L'héros donne à l'héroïne la fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod049TestConcepts20161002090946MESZ() {
        final String source = "IcxO$Gxi$La HeroIcxO DonAs Al Bi$La HeroInO Fin Mi$La FlorO .";
        Assert.assertEquals("{ Su ( IcxO$Gxi$La HeroIcxO ) Dom ( DonAs ) Al ( Bi$La HeroInO ) Fin ( Mi$La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Sein Held gibt deiner Heldin meine Blume.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("His hero gives your heroine my flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Lia heroo donas al via heroino mian floron.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Su héroe da a tu heroína mi flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Son héros donne à t'héroïne ma fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod050TestConcepts20161002090946MESZ() {
        final String source = "Ili$La HeroIcxO DonAs Al Vi$La HeroInO Fin Ni$La FlorO .";
        Assert.assertEquals("{ Su ( Ili$La HeroIcxO ) Dom ( DonAs ) Al ( Vi$La HeroInO ) Fin ( Ni$La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ihr Held gibt euerer Heldin unsere Blume.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Their hero gives your heroine our flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ilia heroo donas al via heroino nian floron.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Su héroe da a vuestra heroína nuestra flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Leur héros donne à votre héroïne notre fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod051TestConcepts20161002090946MESZ() {
        final String source = "HeroIcxO DonAs Al HeroInO Fin HomArO$Ni$La FlorO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( DonAs ) Al ( HeroInO ) Fin ( HomArO$Ni$La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ein Held gibt einer Heldin unsere Blume.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("A hero gives a heroine our flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Heroo donas al heroino nian floron.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héroe da a una heroína nuestra flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héros donne à une héroïne notre fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod052TestConcepts20161002090946MESZ() {
        final String source = "HeroIcxO GigantA DonAs Al HeroInO Fin HomArO$Ni$La FlorO GigantA .";
        Assert.assertEquals("{ Su ( HeroIcxO GigantA ) Dom ( DonAs ) Al ( HeroInO ) Fin ( HomArO$Ni$La FlorO GigantA ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ein gigantischer Held gibt einer Heldin unsere gigantische Blume.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("A gigantic hero gives a heroine our gigantic flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Giganta heroo donas al heroino nian gigantan floron.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un gigantesco héroe da a una heroína nuestra gigantesca flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un gigantesque héros donne à une héroïne notre gigantesque fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod053TestConcepts20161002090946MESZ() {
        final String source = "HeroInO DonAs Al HeroIcxO Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroInO ) Dom ( DonAs ) Al ( HeroIcxO ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Eine Heldin gibt einem Helden einen Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("A heroine gives a hero a pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Heroino donas al heroo skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Una heroína da a un héroe un lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Une héroïne donne à un héros un crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod054TestConcepts20161002090946MESZ() {
        final String source = "La HeroInO DonAs Al La HeroIcxO Fin La SkribIlO .";
        Assert.assertEquals("{ Su ( La HeroInO ) Dom ( DonAs ) Al ( La HeroIcxO ) Fin ( La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Die Heldin gibt dem Helden den Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("The heroine gives the hero the pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("La heroino donas al la heroo la skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("La heroína da al héroe el lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("L'héroïne donne à l'héros le crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod055TestConcepts20161002090946MESZ() {
        final String source = "InO$Gxi$La HeroInO DonAs Al Mi$La HeroIcxO Fin Bi$La SkribIlO .";
        Assert.assertEquals("{ Su ( InO$Gxi$La HeroInO ) Dom ( DonAs ) Al ( Mi$La HeroIcxO ) Fin ( Bi$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ihre Heldin gibt meinem Helden deinen Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Her heroine gives my hero your pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ŝia heroino donas al mia heroo vian skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Su heroína da a mi héroe tu lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("S'héroïne donne à mon héros ton crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod056TestConcepts20161002090946MESZ() {
        final String source = "InArO$Ili$La HeroInO DonAs Al Ni$La HeroIcxO Fin Vi$La SkribIlO .";
        Assert.assertEquals("{ Su ( InArO$Ili$La HeroInO ) Dom ( DonAs ) Al ( Ni$La HeroIcxO ) Fin ( Vi$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ihre Heldin gibt unserem Helden euren Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Their heroine gives our hero your pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ilia heroino donas al nia heroo vian skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Su heroína da a nuestro héroe vuestro lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Leur héroïne donne à notre héros votre crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod057TestConcepts20161002090946MESZ() {
        final String source = "HeroInO DonAs Al La HeroIcxO Fin Bi$La SkribIlO .";
        Assert.assertEquals("{ Su ( HeroInO ) Dom ( DonAs ) Al ( La HeroIcxO ) Fin ( Bi$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Eine Heldin gibt dem Helden deinen Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("A heroine gives the hero your pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Heroino donas al la heroo vian skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Una heroína da al héroe tu lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Une héroïne donne à l'héros ton crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod058TestConcepts20161002090946MESZ() {
        final String source = "HeroInO GigantA AtentA DonAs Al La HeroIcxO GigantA KontentA Fin Bi$La SkribIlO GigantA .";
        Assert.assertEquals("{ Su ( HeroInO GigantA AtentA ) Dom ( DonAs ) Al ( La HeroIcxO GigantA KontentA ) Fin ( Bi$La SkribIlO GigantA ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Eine gigantische und aufmerksame Heldin gibt dem gigantischen und zufriedenen Helden deinen gigantischen Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("A gigantic and attentive heroine gives the gigantic and satisfied hero your gigantic pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Giganta kaj atenta heroino donas al la giganta kaj kontenta heroo vian gigantan skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Una gigantesca heroína atenta da al gigantesco héroe satisfecho tu gigantesco lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Une gigantesque héroïne attentive donne à le gigantesque héros satisfait ton gigantesque crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod059TestConcepts20161002090946MESZ() {
        final String source = "Kaj HeroInO DonAs Al HeroIcxO Fin FlorO .";
        Assert.assertEquals("Kaj { Su ( HeroInO ) Dom ( DonAs ) Al ( HeroIcxO ) Fin ( FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Und eine Heldin gibt einem Helden eine Blume.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("And a heroine gives a hero a flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Kaj heroino donas al heroo floron.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Y una heroína da a un héroe una flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Et une héroïne donne à un héros une fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod060TestConcepts20161002090947MESZ() {
        final String source = "Kaj La HeroInO DonAs Al La HeroIcxO Fin La FlorO .";
        Assert.assertEquals("Kaj { Su ( La HeroInO ) Dom ( DonAs ) Al ( La HeroIcxO ) Fin ( La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Und die Heldin gibt dem Helden die Blume.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("And the heroine gives the hero the flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Kaj la heroino donas al la heroo la floron.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Y la heroína da al héroe la flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Et l'héroïne donne à l'héros la fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod061TestConcepts20161002090947MESZ() {
        final String source = "Kaj Gxi$La HeroInO DonAs Al Bi$La HeroIcxO Fin HeroInO$Gxi$La FlorO .";
        Assert.assertEquals("Kaj { Su ( Gxi$La HeroInO ) Dom ( DonAs ) Al ( Bi$La HeroIcxO ) Fin ( HeroInO$Gxi$La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Und seine Heldin gibt deinem Helden ihre Blume.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("And its heroine gives your hero her flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Kaj ĝia heroino donas al via heroo ŝian floron.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Y su heroína da a tu héroe su flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Et s'héroïne donne à ton héros sa fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod062TestConcepts20161002090947MESZ() {
        final String source = "Kaj Ili$La HeroInO DonAs Al Vi$La HeroIcxO Fin HeroInArO$Ili$La FlorO .";
        Assert.assertEquals("Kaj { Su ( Ili$La HeroInO ) Dom ( DonAs ) Al ( Vi$La HeroIcxO ) Fin ( HeroInArO$Ili$La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Und ihre Heldin gibt eurem Helden ihre Blume.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("And their heroine gives your hero their flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Kaj ilia heroino donas al via heroo ilian floron.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Y su heroína da a vuestro héroe su flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Et leur héroïne donne à votre héros leur fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod063TestConcepts20161002090947MESZ() {
        final String source = "Kaj La HeroInO DonAs Al HeroIcxO Fin HeroInArO$Ili$La FlorO .";
        Assert.assertEquals("Kaj { Su ( La HeroInO ) Dom ( DonAs ) Al ( HeroIcxO ) Fin ( HeroInArO$Ili$La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Und die Heldin gibt einem Helden ihre Blume.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("And the heroine gives a hero their flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Kaj la heroino donas al heroo ilian floron.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Y la heroína da a un héroe su flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Et l'héroïne donne à un héros leur fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod064TestConcepts20161002090947MESZ() {
        final String source = "Kaj La HeroInO SanA AtentA KuragxA DonAs Al HeroIcxO KontentA Fin HeroInArO$Ili$La FlorO .";
        Assert.assertEquals("Kaj { Su ( La HeroInO SanA AtentA KuragxA ) Dom ( DonAs ) Al ( HeroIcxO KontentA ) Fin ( HeroInArO$Ili$La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Und die gesunde, aufmerksame und beherzte Heldin gibt einem zufriedenen Helden ihre Blume.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("And the sane, attentive and valiant heroine gives a satisfied hero their flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Kaj la sana, atenta kaj kuraĝa heroino donas al kontenta heroo ilian floron.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Y la heroína sana, atenta y valiente da a un héroe satisfecho su flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Et l'héroïne saine, attentive et courageuse donne à un héros satisfait leur fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod065TestConcepts20161002090947MESZ() {
        final String source = "HeroIcxO TrovAs Fin FlorO Kaj HeroInO TrovAs Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( TrovAs ) Fin ( FlorO ) } Kaj { Su ( HeroInO ) Dom ( TrovAs ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ein Held findet eine Blume, und eine Heldin findet einen Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("A hero finds a flower, and a heroine finds a pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Heroo trovas floron, kaj heroino trovas skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héroe encuentra una flor, y una heroína encuentra un lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héros trouve une fleur et une héroïne trouve un crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod066TestConcepts20161002090947MESZ() {
        final String source = "La HeroIcxO TrovAs Fin La FlorO Kaj La HeroInO TrovAs Fin La SkribIlO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( TrovAs ) Fin ( La FlorO ) } Kaj { Su ( La HeroInO ) Dom ( TrovAs ) Fin ( La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Der Held findet die Blume, und die Heldin findet den Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("The hero finds the flower, and the heroine finds the pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("La heroo trovas la floron, kaj la heroino trovas la skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("El héroe encuentra la flor, y la heroína encuentra el lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("L'héros trouve la fleur et l'héroïne trouve le crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod067TestConcepts20161002090947MESZ() {
        final String source = "Mi$La HeroIcxO TrovAs Fin Bi$La FlorO Kaj Bi$La HeroInO TrovAs Fin Mi$La SkribIlO .";
        Assert.assertEquals("{ Su ( Mi$La HeroIcxO ) Dom ( TrovAs ) Fin ( Bi$La FlorO ) } Kaj { Su ( Bi$La HeroInO ) Dom ( TrovAs ) Fin ( Mi$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mein Held findet deine Blume, und deine Heldin findet meinen Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("My hero finds your flower, and your heroine finds my pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mia heroo trovas vian floron, kaj via heroino trovas mian skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mi héroe encuentra tu flor, y tu heroína encuentra mi lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mon héros trouve ta fleur et t'héroïne trouve mon crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod068TestConcepts20161002090947MESZ() {
        final String source = "Ni$La HeroIcxO TrovAs Fin Vi$La FlorO Kaj Vi$La HeroInO TrovAs Fin Ni$La SkribIlO .";
        Assert.assertEquals("{ Su ( Ni$La HeroIcxO ) Dom ( TrovAs ) Fin ( Vi$La FlorO ) } Kaj { Su ( Vi$La HeroInO ) Dom ( TrovAs ) Fin ( Ni$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Unser Held findet eure Blume, und eure Heldin findet unseren Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Our hero finds your flower, and your heroine finds our pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Nia heroo trovas vian floron, kaj via heroino trovas nian skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Nuestro héroe encuentra vuestra flor, y vuestra heroína encuentra nuestro lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Notre héros trouve votre fleur et votre héroïne trouve notre crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod069TestConcepts20161002090947MESZ() {
        final String source = "La HeroIcxO TrovAs Fin FlorO Kaj Vi$La HeroInO TrovAs Fin SkribIlO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( TrovAs ) Fin ( FlorO ) } Kaj { Su ( Vi$La HeroInO ) Dom ( TrovAs ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Der Held findet eine Blume, und eure Heldin findet einen Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("The hero finds a flower, and your heroine finds a pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("La heroo trovas floron, kaj via heroino trovas skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("El héroe encuentra una flor, y vuestra heroína encuentra un lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("L'héros trouve une fleur et votre héroïne trouve un crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod070TestConcepts20161002090947MESZ() {
        final String source = "La HeroIcxO KontentA TrovAs Fin FlorO GigantA Kaj Vi$La HeroInO TrovAs Fin SkribIlO GigantA .";
        Assert.assertEquals("{ Su ( La HeroIcxO KontentA ) Dom ( TrovAs ) Fin ( FlorO GigantA ) } Kaj { Su ( Vi$La HeroInO ) Dom ( TrovAs ) Fin ( SkribIlO GigantA ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Der zufriedene Held findet eine gigantische Blume, und eure Heldin findet einen gigantischen Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("The satisfied hero finds a gigantic flower, and your heroine finds a gigantic pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("La kontenta heroo trovas gigantan floron, kaj via heroino trovas gigantan skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("El héroe satisfecho encuentra una gigantesca flor, y vuestra heroína encuentra un gigantesco lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("L'héros satisfait trouve une gigantesque fleur et votre héroïne trouve un gigantesque crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod071TestConcepts20161002090947MESZ() {
        final String source = "HeroIcxO DonAs Al HeroInO Fin FlorO Kaj HeroInO DonAs Al HeroIcxO Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( DonAs ) Al ( HeroInO ) Fin ( FlorO ) } Kaj { Su ( HeroInO ) Dom ( DonAs ) Al ( HeroIcxO ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ein Held gibt einer Heldin eine Blume, und eine Heldin gibt einem Helden einen Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("A hero gives a heroine a flower, and a heroine gives a hero a pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Heroo donas al heroino floron, kaj heroino donas al heroo skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héroe da a una heroína una flor, y una heroína da a un héroe un lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héros donne à une héroïne une fleur et une héroïne donne à un héros un crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod072TestConcepts20161002090947MESZ() {
        final String source = "La HeroIcxO DonAs Al La HeroInO Fin La FlorO Kaj La HeroInO DonAs Al La HeroIcxO Fin La SkribIlO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( DonAs ) Al ( La HeroInO ) Fin ( La FlorO ) } Kaj { Su ( La HeroInO ) Dom ( DonAs ) Al ( La HeroIcxO ) Fin ( La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Der Held gibt der Heldin die Blume, und die Heldin gibt dem Helden den Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("The hero gives the heroine the flower, and the heroine gives the hero the pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("La heroo donas al la heroino la floron, kaj la heroino donas al la heroo la skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("El héroe da a la heroína la flor, y la heroína da al héroe el lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("L'héros donne à l'héroïne la fleur et l'héroïne donne à l'héros le crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod073TestConcepts20161002090947MESZ() {
        final String source = "Bi$La HeroIcxO DonAs Al Mi$La HeroInO Fin LudO$Gxi$La FlorO Kaj Mi$La HeroInO DonAs Al InO$Bi$La HeroIcxO Fin HeroInO$Gxi$La SkribIlO .";
        Assert.assertEquals("{ Su ( Bi$La HeroIcxO ) Dom ( DonAs ) Al ( Mi$La HeroInO ) Fin ( LudO$Gxi$La FlorO ) } Kaj { Su ( Mi$La HeroInO ) Dom ( DonAs ) Al ( InO$Bi$La HeroIcxO ) Fin ( HeroInO$Gxi$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Dein Held gibt meiner Heldin seine Blume, und meine Heldin gibt deinem Helden ihren Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Your hero gives my heroine its flower, and my heroine gives your hero her pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Via heroo donas al mia heroino ĝian floron, kaj mia heroino donas al via heroo ŝian skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Tu héroe da a mi heroína su flor, y mi heroína da a tu héroe su lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ton héros donne à m'héroïne sa fleur et m'héroïne donne à ton héros son crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod074TestConcepts20161002090947MESZ() {
        final String source = "Vi$La HeroIcxO DonAs Al Ni$La HeroInO Fin LudArO$Ili$La FlorO Kaj Ni$La HeroInO DonAs Al InArO$Vi$La HeroIcxO Fin HeroInArO$Ili$La SkribIlO .";
        Assert.assertEquals("{ Su ( Vi$La HeroIcxO ) Dom ( DonAs ) Al ( Ni$La HeroInO ) Fin ( LudArO$Ili$La FlorO ) } Kaj { Su ( Ni$La HeroInO ) Dom ( DonAs ) Al ( InArO$Vi$La HeroIcxO ) Fin ( HeroInArO$Ili$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Euer Held gibt unserer Heldin ihre Blume, und unsere Heldin gibt eurem Helden ihren Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Your hero gives our heroine their flower, and our heroine gives your hero their pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Via heroo donas al nia heroino ilian floron, kaj nia heroino donas al via heroo ilian skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Vuestro héroe da a nuestra heroína su flor, y nuestra heroína da a vuestro héroe su lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Votre héros donne à notre héroïne leur fleur et notre héroïne donne à votre héros leur crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod075TestConcepts20161002090947MESZ() {
        final String source = "Bi$La HeroIcxO DonAs Al HeroInO Fin La FlorO Kaj HeroInO DonAs Al HeroIcxO Fin SkribIlO .";
        Assert.assertEquals("{ Su ( Bi$La HeroIcxO ) Dom ( DonAs ) Al ( HeroInO ) Fin ( La FlorO ) } Kaj { Su ( HeroInO ) Dom ( DonAs ) Al ( HeroIcxO ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Dein Held gibt einer Heldin die Blume, und eine Heldin gibt einem Helden einen Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Your hero gives a heroine the flower, and a heroine gives a hero a pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Via heroo donas al heroino la floron, kaj heroino donas al heroo skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Tu héroe da a una heroína la flor, y una heroína da a un héroe un lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ton héros donne à une héroïne la fleur et une héroïne donne à un héros un crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod076TestConcepts20161002090947MESZ() {
        final String source = "Bi$La HeroIcxO KontentA AtentA DonAs Al HeroInO MalSanA KontentA Fin La FlorO Kaj HeroInO MalSanA DonAs Al HeroIcxO Fin SkribIlO .";
        Assert.assertEquals("{ Su ( Bi$La HeroIcxO KontentA AtentA ) Dom ( DonAs ) Al ( HeroInO MalSanA KontentA ) Fin ( La FlorO ) } Kaj { Su ( HeroInO MalSanA ) Dom ( DonAs ) Al ( HeroIcxO ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Dein zufriedener und aufmerksamer Held gibt einer kranken und zufriedenen Heldin die Blume, und eine kranke Heldin gibt einem Helden einen Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Your satisfied and attentive hero gives a sick and satisfied heroine the flower, and a sick heroine gives a hero a pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Via kontenta kaj atenta heroo donas al sana kaj kontenta heroino la floron, kaj sana heroino donas al heroo skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Tu héroe satisfecho y atento da a una heroína enferma y satisfecha la flor, y una heroína enferma da a un héroe un lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ton héros satisfait et attentif donne à une héroïne malade et satisfaite la fleur et une héroïne malade donne à un héros un crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod077TestConcepts20161002090947MESZ() {
        final String source = "HeroIcxO DonAs Al HeroInO Fin FlorO Aux HeroInO DonAs Al HeroIcxO Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( DonAs ) Al ( HeroInO ) Fin ( FlorO ) } Aux { Su ( HeroInO ) Dom ( DonAs ) Al ( HeroIcxO ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ein Held gibt einer Heldin eine Blume, oder eine Heldin gibt einem Helden einen Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("A hero gives a heroine a flower, or a heroine gives a hero a pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Heroo donas al heroino floron, aŭ heroino donas al heroo skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héroe da a una heroína una flor, o una heroína da a un héroe un lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héros donne à une héroïne une fleur ou une héroïne donne à un héros un crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod078TestConcepts20161002090947MESZ() {
        final String source = "La HeroIcxO DonAs Al La HeroInO Fin La FlorO Aux La HeroInO DonAs Al La HeroIcxO Fin La SkribIlO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( DonAs ) Al ( La HeroInO ) Fin ( La FlorO ) } Aux { Su ( La HeroInO ) Dom ( DonAs ) Al ( La HeroIcxO ) Fin ( La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Der Held gibt der Heldin die Blume, oder die Heldin gibt dem Helden den Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("The hero gives the heroine the flower, or the heroine gives the hero the pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("La heroo donas al la heroino la floron, aŭ la heroino donas al la heroo la skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("El héroe da a la heroína la flor, o la heroína da al héroe el lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("L'héros donne à l'héroïne la fleur ou l'héroïne donne à l'héros le crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod079TestConcepts20161002090947MESZ() {
        final String source = "LudO$Gxi$La HeroIcxO DonAs Al Mi$La HeroInO Fin Bi$La FlorO Aux Mi$La HeroInO DonAs Al Gxi$La HeroIcxO Fin Mi$La SkribIlO .";
        Assert.assertEquals("{ Su ( LudO$Gxi$La HeroIcxO ) Dom ( DonAs ) Al ( Mi$La HeroInO ) Fin ( Bi$La FlorO ) } Aux { Su ( Mi$La HeroInO ) Dom ( DonAs ) Al ( Gxi$La HeroIcxO ) Fin ( Mi$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Sein Held gibt meiner Heldin deine Blume, oder meine Heldin gibt seinem Helden meinen Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Its hero gives my heroine your flower, or my heroine gives its hero my pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ĝia heroo donas al mia heroino vian floron, aŭ mia heroino donas al ĝia heroo mian skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Su héroe da a mi heroína tu flor, o mi heroína da a su héroe mi lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Son héros donne à m'héroïne ta fleur ou m'héroïne donne à son héros mon crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod080TestConcepts20161002090947MESZ() {
        final String source = "LudArO$Ili$La HeroIcxO DonAs Al Ni$La HeroInO Fin Vi$La FlorO Aux Ni$La HeroInO DonAs Al Ili$La HeroIcxO Fin Ni$La SkribIlO .";
        Assert.assertEquals("{ Su ( LudArO$Ili$La HeroIcxO ) Dom ( DonAs ) Al ( Ni$La HeroInO ) Fin ( Vi$La FlorO ) } Aux { Su ( Ni$La HeroInO ) Dom ( DonAs ) Al ( Ili$La HeroIcxO ) Fin ( Ni$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ihr Held gibt unserer Heldin eure Blume, oder unsere Heldin gibt ihrem Helden unseren Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Their hero gives our heroine your flower, or our heroine gives their hero our pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ilia heroo donas al nia heroino vian floron, aŭ nia heroino donas al ilia heroo nian skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Su héroe da a nuestra heroína vuestra flor, o nuestra heroína da a su héroe nuestro lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Leur héros donne à notre héroïne votre fleur ou notre héroïne donne à leur héros notre crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod081TestConcepts20161002090947MESZ() {
        final String source = "HeroIcxO DonAs Al Ni$La HeroInO Fin FlorO Aux La HeroInO DonAs Al HeroIcxO Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( DonAs ) Al ( Ni$La HeroInO ) Fin ( FlorO ) } Aux { Su ( La HeroInO ) Dom ( DonAs ) Al ( HeroIcxO ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ein Held gibt unserer Heldin eine Blume, oder die Heldin gibt einem Helden einen Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("A hero gives our heroine a flower, or the heroine gives a hero a pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Heroo donas al nia heroino floron, aŭ la heroino donas al heroo skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héroe da a nuestra heroína una flor, o la heroína da a un héroe un lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héros donne à notre héroïne une fleur ou l'héroïne donne à un héros un crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod082TestConcepts20161002090947MESZ() {
        final String source = "HeroIcxO SanA DonAs Al Ni$La HeroInO Fin FlorO Aux La HeroInO KontentA KuragxA DonAs Al HeroIcxO Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroIcxO SanA ) Dom ( DonAs ) Al ( Ni$La HeroInO ) Fin ( FlorO ) } Aux { Su ( La HeroInO KontentA KuragxA ) Dom ( DonAs ) Al ( HeroIcxO ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ein gesunder Held gibt unserer Heldin eine Blume, oder die zufriedene und beherzte Heldin gibt einem Helden einen Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("A sane hero gives our heroine a flower, or the satisfied and valiant heroine gives a hero a pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Sana heroo donas al nia heroino floron, aŭ la kontenta kaj kuraĝa heroino donas al heroo skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héroe sano da a nuestra heroína una flor, o la heroína satisfecha y valiente da a un héroe un lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héros sain donne à notre héroïne une fleur ou l'héroïne satisfaite et courageuse donne à un héros un crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod083TestConcepts20161002090947MESZ() {
        final String source = "Fin SkribIlO Su HeroIcxO TrovAs . Fin NomO Al HeroIcxO DonAs HeroInO .";
        Assert.assertEquals("{ Fin ( SkribIlO ) Su ( HeroIcxO ) Dom ( TrovAs ) } . { Fin ( NomO ) Al ( HeroIcxO ) Dom ( DonAs ) Su ( HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Einen Stift findet ein Held. Einen Namen gibt eine Heldin einem Helden.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("A hero finds a pen. A heroine gives a hero a name.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Skribilon heroo trovas. Nomon al heroo donas heroino.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héroe encuentra un lápiz. Una heroína da a un héroe un nombre.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héros trouve un crayon. Une héroïne donne à un héros un nom.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod084TestConcepts20161002090947MESZ() {
        final String source = "Fin La SkribIlO Su La HeroIcxO TrovAs . Fin La NomO Al La HeroIcxO DonAs La HeroInO .";
        Assert.assertEquals("{ Fin ( La SkribIlO ) Su ( La HeroIcxO ) Dom ( TrovAs ) } . { Fin ( La NomO ) Al ( La HeroIcxO ) Dom ( DonAs ) Su ( La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Den Stift findet der Held. Den Namen gibt die Heldin dem Helden.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("The hero finds the pen. The heroine gives the hero the name.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("La skribilon la heroo trovas. La nomon al la heroo donas la heroino.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("El héroe encuentra el lápiz. La heroína da al héroe el nombre.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("L'héros trouve le crayon. L'héroïne donne à l'héros le nom.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod085TestConcepts20161002090947MESZ() {
        final String source = "Fin Mi$La SkribIlO Su Bi$La HeroIcxO TrovAs . Fin Bi$La NomO Al Mi$La HeroIcxO DonAs Bi$La HeroInO .";
        Assert.assertEquals("{ Fin ( Mi$La SkribIlO ) Su ( Bi$La HeroIcxO ) Dom ( TrovAs ) } . { Fin ( Bi$La NomO ) Al ( Mi$La HeroIcxO ) Dom ( DonAs ) Su ( Bi$La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Meinen Stift findet dein Held. Deinen Namen gibt deine Heldin meinem Helden.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Your hero finds my pen. Your heroine gives my hero your name.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mian skribilon via heroo trovas. Vian nomon al mia heroo donas via heroino.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Tu héroe encuentra mi lápiz. Tu heroína da a mi héroe tu nombre.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ton héros trouve mon crayon. T'héroïne donne à mon héros ton nom.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod086TestConcepts20161002090947MESZ() {
        final String source = "Fin Ni$La SkribIlO Su Vi$La HeroIcxO TrovAs . Fin Vi$La NomO Al Ni$La HeroIcxO DonAs Vi$La HeroInO .";
        Assert.assertEquals("{ Fin ( Ni$La SkribIlO ) Su ( Vi$La HeroIcxO ) Dom ( TrovAs ) } . { Fin ( Vi$La NomO ) Al ( Ni$La HeroIcxO ) Dom ( DonAs ) Su ( Vi$La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Unseren Stift findet euer Held. Euren Namen gibt eure Heldin unserem Helden.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Your hero finds our pen. Your heroine gives our hero your name.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Nian skribilon via heroo trovas. Vian nomon al nia heroo donas via heroino.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Vuestro héroe encuentra nuestro lápiz. Vuestra heroína da a nuestro héroe vuestro nombre.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Votre héros trouve notre crayon. Votre héroïne donne à notre héros votre nom.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod087TestConcepts20161002090947MESZ() {
        final String source = "Fin SkribIlO Su Vi$La HeroIcxO TrovAs . Fin NomO Al Mi$La HeroIcxO DonAs La HeroInO .";
        Assert.assertEquals("{ Fin ( SkribIlO ) Su ( Vi$La HeroIcxO ) Dom ( TrovAs ) } . { Fin ( NomO ) Al ( Mi$La HeroIcxO ) Dom ( DonAs ) Su ( La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Einen Stift findet euer Held. Einen Namen gibt die Heldin meinem Helden.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Your hero finds a pen. The heroine gives my hero a name.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Skribilon via heroo trovas. Nomon al mia heroo donas la heroino.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Vuestro héroe encuentra un lápiz. La heroína da a mi héroe un nombre.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Votre héros trouve un crayon. L'héroïne donne à mon héros un nom.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod088TestConcepts20161002090947MESZ() {
        final String source = "Fin SkribIlO Su Vi$La HeroIcxO SanA TrovAs . Fin NomO GigantA KontentA Al Mi$La HeroIcxO DonAs La HeroInO .";
        Assert.assertEquals("{ Fin ( SkribIlO ) Su ( Vi$La HeroIcxO SanA ) Dom ( TrovAs ) } . { Fin ( NomO GigantA KontentA ) Al ( Mi$La HeroIcxO ) Dom ( DonAs ) Su ( La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Einen Stift findet euer gesunder Held. Einen gigantischen und zufriedenen Namen gibt die Heldin meinem Helden.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Your sane hero finds a pen. The heroine gives my hero a gigantic and satisfied name.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Skribilon via sana heroo trovas. Gigantan kaj kontentan nomon al mia heroo donas la heroino.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Vuestro héroe sano encuentra un lápiz. La heroína da a mi héroe un gigantesco nombre satisfecho.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Votre héros sain trouve un crayon. L'héroïne donne à mon héros un gigantesque nom satisfait.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod089TestConcepts20161002090947MESZ() {
        final String source = "Fin SkribIlO TrovAs Su HeroIcxO Kaj TrovAs Fin FlorO Su HeroInO Kaj Al HeroIcxO Fin FlorO DonAs HeroInO .";
        Assert.assertEquals("{ Fin ( SkribIlO ) Dom ( TrovAs ) Su ( HeroIcxO ) } Kaj { Dom ( TrovAs ) Fin ( FlorO ) Su ( HeroInO ) } Kaj { Al ( HeroIcxO ) Fin ( FlorO ) Dom ( DonAs ) Su ( HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Einen Stift findet ein Held, und eine Blume findet eine Heldin, und eine Blume gibt eine Heldin einem Helden.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("A hero finds a pen, and a heroine finds a flower, and a heroine gives a hero a flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Skribilon trovas heroo, kaj trovas floron heroino, kaj al heroo floron donas heroino.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héroe encuentra un lápiz, y una heroína encuentra una flor, y una heroína da a un héroe una flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héros trouve un crayon et une héroïne trouve une fleur et une héroïne donne à un héros une fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod090TestConcepts20161002090947MESZ() {
        final String source = "Fin La SkribIlO TrovAs Su La HeroIcxO Kaj TrovAs Fin La FlorO Su La HeroInO Kaj Al La HeroIcxO Fin La FlorO DonAs La HeroInO .";
        Assert.assertEquals("{ Fin ( La SkribIlO ) Dom ( TrovAs ) Su ( La HeroIcxO ) } Kaj { Dom ( TrovAs ) Fin ( La FlorO ) Su ( La HeroInO ) } Kaj { Al ( La HeroIcxO ) Fin ( La FlorO ) Dom ( DonAs ) Su ( La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Den Stift findet der Held, und die Blume findet die Heldin, und die Blume gibt die Heldin dem Helden.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("The hero finds the pen, and the heroine finds the flower, and the heroine gives the hero the flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("La skribilon trovas la heroo, kaj trovas la floron la heroino, kaj al la heroo la floron donas la heroino.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("El héroe encuentra el lápiz, y la heroína encuentra la flor, y la heroína da al héroe la flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("L'héros trouve le crayon et l'héroïne trouve la fleur et l'héroïne donne à l'héros la fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod091TestConcepts20161002090947MESZ() {
        final String source = "Fin Bi$La SkribIlO TrovAs Su Mi$La HeroIcxO Kaj TrovAs Fin Bi$La FlorO Su Mi$La HeroInO Kaj Al Bi$La HeroIcxO Fin Mi$La FlorO DonAs Bi$La HeroInO .";
        Assert.assertEquals("{ Fin ( Bi$La SkribIlO ) Dom ( TrovAs ) Su ( Mi$La HeroIcxO ) } Kaj { Dom ( TrovAs ) Fin ( Bi$La FlorO ) Su ( Mi$La HeroInO ) } Kaj { Al ( Bi$La HeroIcxO ) Fin ( Mi$La FlorO ) Dom ( DonAs ) Su ( Bi$La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Deinen Stift findet mein Held, und deine Blume findet meine Heldin, und meine Blume gibt deine Heldin deinem Helden.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("My hero finds your pen, and my heroine finds your flower, and your heroine gives your hero my flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Vian skribilon trovas mia heroo, kaj trovas vian floron mia heroino, kaj al via heroo mian floron donas via heroino.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mi héroe encuentra tu lápiz, y mi heroína encuentra tu flor, y tu heroína da a tu héroe mi flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mon héros trouve ton crayon et m'héroïne trouve ta fleur et t'héroïne donne à ton héros ma fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod092TestConcepts20161002090947MESZ() {
        final String source = "Fin Vi$La SkribIlO TrovAs Su Ni$La HeroIcxO Kaj TrovAs Fin Vi$La FlorO Su Ni$La HeroInO Kaj Al Vi$La HeroIcxO Fin Ni$La FlorO DonAs Vi$La HeroInO .";
        Assert.assertEquals("{ Fin ( Vi$La SkribIlO ) Dom ( TrovAs ) Su ( Ni$La HeroIcxO ) } Kaj { Dom ( TrovAs ) Fin ( Vi$La FlorO ) Su ( Ni$La HeroInO ) } Kaj { Al ( Vi$La HeroIcxO ) Fin ( Ni$La FlorO ) Dom ( DonAs ) Su ( Vi$La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Euren Stift findet unser Held, und eure Blume findet unsere Heldin, und unsere Blume gibt eure Heldin eurem Helden.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Our hero finds your pen, and our heroine finds your flower, and your heroine gives your hero our flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Vian skribilon trovas nia heroo, kaj trovas vian floron nia heroino, kaj al via heroo nian floron donas via heroino.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Nuestro héroe encuentra vuestro lápiz, y nuestra heroína encuentra vuestra flor, y vuestra heroína da a vuestro héroe nuestra flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Notre héros trouve votre crayon et notre héroïne trouve votre fleur et votre héroïne donne à votre héros notre fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod093TestConcepts20161002090947MESZ() {
        final String source = "Fin Bi$La SkribIlO TrovAs Su HeroIcxO Kaj TrovAs Fin FlorO Su Ni$La HeroInO Kaj Al La HeroIcxO Fin FlorO DonAs Bi$La HeroInO .";
        Assert.assertEquals("{ Fin ( Bi$La SkribIlO ) Dom ( TrovAs ) Su ( HeroIcxO ) } Kaj { Dom ( TrovAs ) Fin ( FlorO ) Su ( Ni$La HeroInO ) } Kaj { Al ( La HeroIcxO ) Fin ( FlorO ) Dom ( DonAs ) Su ( Bi$La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Deinen Stift findet ein Held, und eine Blume findet unsere Heldin, und eine Blume gibt deine Heldin dem Helden.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("A hero finds your pen, and our heroine finds a flower, and your heroine gives the hero a flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Vian skribilon trovas heroo, kaj trovas floron nia heroino, kaj al la heroo floron donas via heroino.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héroe encuentra tu lápiz, y nuestra heroína encuentra una flor, y tu heroína da al héroe una flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héros trouve ton crayon et notre héroïne trouve une fleur et t'héroïne donne à l'héros une fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod094TestConcepts20161002090947MESZ() {
        final String source = "Fin Bi$La SkribIlO GigantA AtentA TrovAs Su HeroIcxO SanA Kaj TrovAs Fin FlorO Su Ni$La HeroInO Kaj Al La HeroIcxO Fin FlorO GigantA DonAs Bi$La HeroInO .";
        Assert.assertEquals("{ Fin ( Bi$La SkribIlO GigantA AtentA ) Dom ( TrovAs ) Su ( HeroIcxO SanA ) } Kaj { Dom ( TrovAs ) Fin ( FlorO ) Su ( Ni$La HeroInO ) } Kaj { Al ( La HeroIcxO ) Fin ( FlorO GigantA ) Dom ( DonAs ) Su ( Bi$La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Deinen gigantischen und aufmerksamen Stift findet ein gesunder Held, und eine Blume findet unsere Heldin, und eine gigantische Blume gibt deine Heldin dem Helden.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("A sane hero finds your gigantic and attentive pen, and our heroine finds a flower, and your heroine gives the hero a gigantic flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Vian gigantan kaj atentan skribilon trovas sana heroo, kaj trovas floron nia heroino, kaj al la heroo gigantan floron donas via heroino.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héroe sano encuentra tu gigantesco lápiz atento, y nuestra heroína encuentra una flor, y tu heroína da al héroe una gigantesca flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héros sain trouve ton gigantesque crayon attentif et notre héroïne trouve une fleur et t'héroïne donne à l'héros une gigantesque fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod095TestConcepts20161002090947MESZ() {
        final String source = "Fin SkribIlO TrovAs Su HeroIcxO , TrovAs Fin FlorO Su HeroInO , Al HeroIcxO Fin FlorO DonAs HeroInO .";
        Assert.assertEquals("{ Fin ( SkribIlO ) Dom ( TrovAs ) Su ( HeroIcxO ) } , { Dom ( TrovAs ) Fin ( FlorO ) Su ( HeroInO ) } , { Al ( HeroIcxO ) Fin ( FlorO ) Dom ( DonAs ) Su ( HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Einen Stift findet ein Held, eine Blume findet eine Heldin, eine Blume gibt eine Heldin einem Helden.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("A hero finds a pen, a heroine finds a flower, a heroine gives a hero a flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Skribilon trovas heroo, trovas floron heroino, al heroo floron donas heroino.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héroe encuentra un lápiz, una heroína encuentra una flor, una heroína da a un héroe una flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héros trouve un crayon, une héroïne trouve une fleur, une héroïne donne à un héros une fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod096TestConcepts20161002090947MESZ() {
        final String source = "Fin La SkribIlO TrovAs Su La HeroIcxO , TrovAs Fin La FlorO Su La HeroInO , Al La HeroIcxO Fin La FlorO DonAs La HeroInO .";
        Assert.assertEquals("{ Fin ( La SkribIlO ) Dom ( TrovAs ) Su ( La HeroIcxO ) } , { Dom ( TrovAs ) Fin ( La FlorO ) Su ( La HeroInO ) } , { Al ( La HeroIcxO ) Fin ( La FlorO ) Dom ( DonAs ) Su ( La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Den Stift findet der Held, die Blume findet die Heldin, die Blume gibt die Heldin dem Helden.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("The hero finds the pen, the heroine finds the flower, the heroine gives the hero the flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("La skribilon trovas la heroo, trovas la floron la heroino, al la heroo la floron donas la heroino.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("El héroe encuentra el lápiz, la heroína encuentra la flor, la heroína da al héroe la flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("L'héros trouve le crayon, l'héroïne trouve la fleur, l'héroïne donne à l'héros la fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod097TestConcepts20161002090947MESZ() {
        final String source = "Fin LudO$Gxi$La SkribIlO TrovAs Su Mi$La HeroIcxO , TrovAs Fin Bi$La FlorO Su Mi$La HeroInO , Al Bi$La HeroIcxO Fin Mi$La FlorO DonAs Bi$La HeroInO .";
        Assert.assertEquals("{ Fin ( LudO$Gxi$La SkribIlO ) Dom ( TrovAs ) Su ( Mi$La HeroIcxO ) } , { Dom ( TrovAs ) Fin ( Bi$La FlorO ) Su ( Mi$La HeroInO ) } , { Al ( Bi$La HeroIcxO ) Fin ( Mi$La FlorO ) Dom ( DonAs ) Su ( Bi$La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Seinen Stift findet mein Held, deine Blume findet meine Heldin, meine Blume gibt deine Heldin deinem Helden.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("My hero finds its pen, my heroine finds your flower, your heroine gives your hero my flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ĝian skribilon trovas mia heroo, trovas vian floron mia heroino, al via heroo mian floron donas via heroino.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mi héroe encuentra su lápiz, mi heroína encuentra tu flor, tu heroína da a tu héroe mi flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mon héros trouve son crayon, m'héroïne trouve ta fleur, t'héroïne donne à ton héros ma fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod098TestConcepts20161002090947MESZ() {
        final String source = "Fin LudArO$Ili$La SkribIlO TrovAs Su Ni$La HeroIcxO , TrovAs Fin Vi$La FlorO Su Ni$La HeroInO , Al Vi$La HeroIcxO Fin Ni$La FlorO DonAs Vi$La HeroInO .";
        Assert.assertEquals("{ Fin ( LudArO$Ili$La SkribIlO ) Dom ( TrovAs ) Su ( Ni$La HeroIcxO ) } , { Dom ( TrovAs ) Fin ( Vi$La FlorO ) Su ( Ni$La HeroInO ) } , { Al ( Vi$La HeroIcxO ) Fin ( Ni$La FlorO ) Dom ( DonAs ) Su ( Vi$La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ihren Stift findet unser Held, eure Blume findet unsere Heldin, unsere Blume gibt eure Heldin eurem Helden.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Our hero finds their pen, our heroine finds your flower, your heroine gives your hero our flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ilian skribilon trovas nia heroo, trovas vian floron nia heroino, al via heroo nian floron donas via heroino.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Nuestro héroe encuentra su lápiz, nuestra heroína encuentra vuestra flor, vuestra heroína da a vuestro héroe nuestra flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Notre héros trouve leur crayon, notre héroïne trouve votre fleur, votre héroïne donne à votre héros notre fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod099TestConcepts20161002090947MESZ() {
        final String source = "Fin La SkribIlO TrovAs Su HeroIcxO , TrovAs Fin FlorO Su Ni$La HeroInO , Al HeroIcxO Fin Mi$La FlorO DonAs Bi$La HeroInO .";
        Assert.assertEquals("{ Fin ( La SkribIlO ) Dom ( TrovAs ) Su ( HeroIcxO ) } , { Dom ( TrovAs ) Fin ( FlorO ) Su ( Ni$La HeroInO ) } , { Al ( HeroIcxO ) Fin ( Mi$La FlorO ) Dom ( DonAs ) Su ( Bi$La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Den Stift findet ein Held, eine Blume findet unsere Heldin, meine Blume gibt deine Heldin einem Helden.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("A hero finds the pen, our heroine finds a flower, your heroine gives a hero my flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("La skribilon trovas heroo, trovas floron nia heroino, al heroo mian floron donas via heroino.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héroe encuentra el lápiz, nuestra heroína encuentra una flor, tu heroína da a un héroe mi flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héros trouve le crayon, notre héroïne trouve une fleur, t'héroïne donne à un héros ma fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod100TestConcepts20161002090947MESZ() {
        final String source = "Fin La SkribIlO TrovAs Su HeroIcxO GigantA , TrovAs Fin FlorO Su Ni$La HeroInO GigantA , Al HeroIcxO GigantA Fin Mi$La FlorO DonAs Bi$La HeroInO GigantA .";
        Assert.assertEquals("{ Fin ( La SkribIlO ) Dom ( TrovAs ) Su ( HeroIcxO GigantA ) } , { Dom ( TrovAs ) Fin ( FlorO ) Su ( Ni$La HeroInO GigantA ) } , { Al ( HeroIcxO GigantA ) Fin ( Mi$La FlorO ) Dom ( DonAs ) Su ( Bi$La HeroInO GigantA ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Den Stift findet ein gigantischer Held, eine Blume findet unsere gigantische Heldin, meine Blume gibt deine gigantische Heldin einem gigantischen Helden.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("A gigantic hero finds the pen, our gigantic heroine finds a flower, your gigantic heroine gives a gigantic hero my flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("La skribilon trovas giganta heroo, trovas floron nia giganta heroino, al giganta heroo mian floron donas via giganta heroino.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un gigantesco héroe encuentra el lápiz, nuestra gigantesca heroína encuentra una flor, tu gigantesca heroína da a un gigantesco héroe mi flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un gigantesque héros trouve le crayon, notre gigantesque héroïne trouve une fleur, ta gigantesque héroïne donne à un gigantesque héros ma fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod101TestConcepts20161002090947MESZ() {
        final String source = "HeroIcxO TrovAs Fin SkribIlO . HeroIcxO HavAs Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( TrovAs ) Fin ( SkribIlO ) } . { Su ( HeroIcxO ) Dom ( HavAs ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ein Held findet einen Stift. Ein Held hat einen Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("A hero finds a pen. A hero has a pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Heroo trovas skribilon. Heroo havas skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héroe encuentra un lápiz. Un héroe tiene un lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héros trouve un crayon. Un héros a un crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod102TestConcepts20161002090947MESZ() {
        final String source = "La HeroIcxO TrovAs Fin La SkribIlO . La HeroIcxO HavAs Fin La SkribIlO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( TrovAs ) Fin ( La SkribIlO ) } . { Su ( La HeroIcxO ) Dom ( HavAs ) Fin ( La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Der Held findet den Stift. Der Held hat den Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("The hero finds the pen. The hero has the pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("La heroo trovas la skribilon. La heroo havas la skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("El héroe encuentra el lápiz. El héroe tiene el lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("L'héros trouve le crayon. L'héros a le crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod103TestConcepts20161002090947MESZ() {
        final String source = "SkribIlO$Gxi$La HeroIcxO TrovAs Fin Bi$La SkribIlO . Mi$La HeroIcxO HavAs Fin Bi$La SkribIlO .";
        Assert.assertEquals("{ Su ( SkribIlO$Gxi$La HeroIcxO ) Dom ( TrovAs ) Fin ( Bi$La SkribIlO ) } . { Su ( Mi$La HeroIcxO ) Dom ( HavAs ) Fin ( Bi$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Sein Held findet deinen Stift. Mein Held hat deinen Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Its hero finds your pen. My hero has your pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ĝia heroo trovas vian skribilon. Mia heroo havas vian skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Su héroe encuentra tu lápiz. Mi héroe tiene tu lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Son héros trouve ton crayon. Mon héros a ton crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod104TestConcepts20161002090947MESZ() {
        final String source = "SkribIlArO$Ili$La HeroIcxO TrovAs Fin Vi$La SkribIlO . Ni$La HeroIcxO HavAs Fin Vi$La SkribIlO .";
        Assert.assertEquals("{ Su ( SkribIlArO$Ili$La HeroIcxO ) Dom ( TrovAs ) Fin ( Vi$La SkribIlO ) } . { Su ( Ni$La HeroIcxO ) Dom ( HavAs ) Fin ( Vi$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ihr Held findet euren Stift. Unser Held hat euren Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Their hero finds your pen. Our hero has your pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ilia heroo trovas vian skribilon. Nia heroo havas vian skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Su héroe encuentra vuestro lápiz. Nuestro héroe tiene vuestro lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Leur héros trouve votre crayon. Notre héros a votre crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod105TestConcepts20161002090947MESZ() {
        final String source = "La HeroIcxO TrovAs Fin SkribIlO . HeroIcxO HavAs Fin Ili$La SkribIlO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( TrovAs ) Fin ( SkribIlO ) } . { Su ( HeroIcxO ) Dom ( HavAs ) Fin ( Ili$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Der Held findet einen Stift. Ein Held hat ihren Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("The hero finds a pen. A hero has their pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("La heroo trovas skribilon. Heroo havas ilian skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("El héroe encuentra un lápiz. Un héroe tiene su lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("L'héros trouve un crayon. Un héros a leur crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod106TestConcepts20161002090947MESZ() {
        final String source = "La HeroIcxO KontentA SanA TrovAs Fin SkribIlO . HeroIcxO SanA KontentA HavAs Fin Ili$La SkribIlO .";
        Assert.assertEquals("{ Su ( La HeroIcxO KontentA SanA ) Dom ( TrovAs ) Fin ( SkribIlO ) } . { Su ( HeroIcxO SanA KontentA ) Dom ( HavAs ) Fin ( Ili$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Der zufriedene und gesunde Held findet einen Stift. Ein gesunder und zufriedener Held hat ihren Stift.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("The satisfied and sane hero finds a pen. A sane and satisfied hero has their pen.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("La kontenta kaj sana heroo trovas skribilon. Sana kaj kontenta heroo havas ilian skribilon.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("El héroe satisfecho y sano encuentra un lápiz. Un héroe sano y satisfecho tiene su lápiz.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("L'héros satisfait et sain trouve un crayon. Un héros sain et satisfait a leur crayon.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod107TestConcepts20161002090947MESZ() {
        final String source = "Se HeroIcxO TrovAs Fin FlorO , HeroIcxO DonAs Fin FlorO Al HeroInO .";
        Assert.assertEquals("Se { Su ( HeroIcxO ) Dom ( TrovAs ) Fin ( FlorO ) } , { Su ( HeroIcxO ) Dom ( DonAs ) Fin ( FlorO ) Al ( HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Wenn ein Held eine Blume findet, gibt ein Held einer Heldin eine Blume.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("If a hero finds a flower, a hero gives a heroine a flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Se heroo trovas floron, heroo donas floron al heroino.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Si un héroe encuentra una flor, un héroe da a una heroína una flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Si un héros trouve une fleur, un héros donne à une héroïne une fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod108TestConcepts20161002090947MESZ() {
        final String source = "Se La HeroIcxO TrovAs Fin La FlorO , La HeroIcxO DonAs Fin La FlorO Al La HeroInO .";
        Assert.assertEquals("Se { Su ( La HeroIcxO ) Dom ( TrovAs ) Fin ( La FlorO ) } , { Su ( La HeroIcxO ) Dom ( DonAs ) Fin ( La FlorO ) Al ( La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Wenn der Held die Blume findet, gibt der Held der Heldin die Blume.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("If the hero finds the flower, the hero gives the heroine the flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Se la heroo trovas la floron, la heroo donas la floron al la heroino.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Si el héroe encuentra la flor, el héroe da a la heroína la flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Si l'héros trouve la fleur, l'héros donne à l'héroïne la fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod109TestConcepts20161002090947MESZ() {
        final String source = "Se Mi$La HeroIcxO TrovAs Fin Gxi$La FlorO , Mi$La HeroIcxO DonAs Fin Gxi$La FlorO Al Bi$La HeroInO .";
        Assert.assertEquals("Se { Su ( Mi$La HeroIcxO ) Dom ( TrovAs ) Fin ( Gxi$La FlorO ) } , { Su ( Mi$La HeroIcxO ) Dom ( DonAs ) Fin ( Gxi$La FlorO ) Al ( Bi$La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Wenn mein Held seine Blume findet, gibt mein Held deiner Heldin seine Blume.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("If my hero finds its flower, my hero gives your heroine its flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Se mia heroo trovas ĝian floron, mia heroo donas ĝian floron al via heroino.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Si mi héroe encuentra su flor, mi héroe da a tu heroína su flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Si mon héros trouve sa fleur, mon héros donne à t'héroïne sa fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod110TestConcepts20161002090947MESZ() {
        final String source = "Se Ni$La HeroIcxO TrovAs Fin Ili$La FlorO , Ni$La HeroIcxO DonAs Fin Ili$La FlorO Al Vi$La HeroInO .";
        Assert.assertEquals("Se { Su ( Ni$La HeroIcxO ) Dom ( TrovAs ) Fin ( Ili$La FlorO ) } , { Su ( Ni$La HeroIcxO ) Dom ( DonAs ) Fin ( Ili$La FlorO ) Al ( Vi$La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Wenn unser Held ihre Blume findet, gibt unser Held euerer Heldin ihre Blume.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("If our hero finds their flower, our hero gives your heroine their flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Se nia heroo trovas ilian floron, nia heroo donas ilian floron al via heroino.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Si nuestro héroe encuentra su flor, nuestro héroe da a vuestra heroína su flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Si notre héros trouve leur fleur, notre héros donne à votre héroïne leur fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod111TestConcepts20161002090947MESZ() {
        final String source = "Se Mi$La HeroIcxO TrovAs Fin La FlorO , HeroIcxO DonAs Fin FlorO Al HeroInO .";
        Assert.assertEquals("Se { Su ( Mi$La HeroIcxO ) Dom ( TrovAs ) Fin ( La FlorO ) } , { Su ( HeroIcxO ) Dom ( DonAs ) Fin ( FlorO ) Al ( HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Wenn mein Held die Blume findet, gibt ein Held einer Heldin eine Blume.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("If my hero finds the flower, a hero gives a heroine a flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Se mia heroo trovas la floron, heroo donas floron al heroino.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Si mi héroe encuentra la flor, un héroe da a una heroína una flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Si mon héros trouve la fleur, un héros donne à une héroïne une fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod112TestConcepts20161002090947MESZ() {
        final String source = "Se Mi$La HeroIcxO GigantA TrovAs Fin La FlorO SanA , HeroIcxO GigantA KontentA SanA DonAs Fin FlorO SanA Al HeroInO .";
        Assert.assertEquals("Se { Su ( Mi$La HeroIcxO GigantA ) Dom ( TrovAs ) Fin ( La FlorO SanA ) } , { Su ( HeroIcxO GigantA KontentA SanA ) Dom ( DonAs ) Fin ( FlorO SanA ) Al ( HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Wenn mein gigantischer Held die gesunde Blume findet, gibt ein gigantischer, zufriedener und gesunder Held einer Heldin eine gesunde Blume.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("If my gigantic hero finds the sane flower, a gigantic, satisfied and sane hero gives a heroine a sane flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Se mia giganta heroo trovas la sanan floron, giganta, kontenta kaj sana heroo donas sanan floron al heroino.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Si mi gigantesco héroe encuentra la flor sana, un gigantesco héroe satisfecho y sano da a una heroína una flor sana.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Si mon gigantesque héros trouve la fleur saine, un gigantesque héros satisfait et sain donne à une héroïne une fleur saine.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod113TestConcepts20161002090947MESZ() {
        final String source = "HeroIcxO DonAs Fin FlorO Al HeroInO Se HeroIcxO TrovAs Fin FlorO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( DonAs ) Fin ( FlorO ) Al ( HeroInO ) } Se { Su ( HeroIcxO ) Dom ( TrovAs ) Fin ( FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ein Held gibt einer Heldin eine Blume, wenn ein Held eine Blume findet.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("A hero gives a heroine a flower, if a hero finds a flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Heroo donas floron al heroino, se heroo trovas floron.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héroe da a una heroína una flor si un héroe encuentra una flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Un héros donne à une héroïne une fleur, si un héros trouve une fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod114TestConcepts20161002090947MESZ() {
        final String source = "La HeroIcxO DonAs Fin La FlorO Al La HeroInO Se La HeroIcxO TrovAs Fin La FlorO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( DonAs ) Fin ( La FlorO ) Al ( La HeroInO ) } Se { Su ( La HeroIcxO ) Dom ( TrovAs ) Fin ( La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Der Held gibt der Heldin die Blume, wenn der Held die Blume findet.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("The hero gives the heroine the flower, if the hero finds the flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("La heroo donas la floron al la heroino, se la heroo trovas la floron.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("El héroe da a la heroína la flor si el héroe encuentra la flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("L'héros donne à l'héroïne la fleur, si l'héros trouve la fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod115TestConcepts20161002090947MESZ() {
        final String source = "Bi$La HeroIcxO DonAs Fin Gxi$La FlorO Al Mi$La HeroInO Se Bi$La HeroIcxO TrovAs Fin Gxi$La FlorO .";
        Assert.assertEquals("{ Su ( Bi$La HeroIcxO ) Dom ( DonAs ) Fin ( Gxi$La FlorO ) Al ( Mi$La HeroInO ) } Se { Su ( Bi$La HeroIcxO ) Dom ( TrovAs ) Fin ( Gxi$La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Dein Held gibt meiner Heldin seine Blume, wenn dein Held seine Blume findet.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Your hero gives my heroine its flower, if your hero finds its flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Via heroo donas ĝian floron al mia heroino, se via heroo trovas ĝian floron.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Tu héroe da a mi heroína su flor si tu héroe encuentra su flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Ton héros donne à m'héroïne sa fleur, si ton héros trouve sa fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod116TestConcepts20161002090947MESZ() {
        final String source = "Vi$La HeroIcxO DonAs Fin Ili$La FlorO Al Ni$La HeroInO Se Vi$La HeroIcxO TrovAs Fin Ili$La FlorO .";
        Assert.assertEquals("{ Su ( Vi$La HeroIcxO ) Dom ( DonAs ) Fin ( Ili$La FlorO ) Al ( Ni$La HeroInO ) } Se { Su ( Vi$La HeroIcxO ) Dom ( TrovAs ) Fin ( Ili$La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Euer Held gibt unserer Heldin ihre Blume, wenn euer Held ihre Blume findet.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Your hero gives our heroine their flower, if your hero finds their flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Via heroo donas ilian floron al nia heroino, se via heroo trovas ilian floron.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Vuestro héroe da a nuestra heroína su flor si vuestro héroe encuentra su flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Votre héros donne à notre héroïne leur fleur, si votre héros trouve leur fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod117TestConcepts20161002090947MESZ() {
        final String source = "Vi$La HeroIcxO DonAs Fin FlorO Al Mi$La HeroInO Se La HeroIcxO TrovAs Fin FlorO .";
        Assert.assertEquals("{ Su ( Vi$La HeroIcxO ) Dom ( DonAs ) Fin ( FlorO ) Al ( Mi$La HeroInO ) } Se { Su ( La HeroIcxO ) Dom ( TrovAs ) Fin ( FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Euer Held gibt meiner Heldin eine Blume, wenn der Held eine Blume findet.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Your hero gives my heroine a flower, if the hero finds a flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Via heroo donas floron al mia heroino, se la heroo trovas floron.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Vuestro héroe da a mi heroína una flor si el héroe encuentra una flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Votre héros donne à m'héroïne une fleur, si l'héros trouve une fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod118TestConcepts20161002090947MESZ() {
        final String source = "Vi$La HeroIcxO KontentA GigantA KuragxA DonAs Fin FlorO Al Mi$La HeroInO Se La HeroIcxO KontentA TrovAs Fin FlorO .";
        Assert.assertEquals("{ Su ( Vi$La HeroIcxO KontentA GigantA KuragxA ) Dom ( DonAs ) Fin ( FlorO ) Al ( Mi$La HeroInO ) } Se { Su ( La HeroIcxO KontentA ) Dom ( TrovAs ) Fin ( FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Euer zufriedener, gigantischer und beherzter Held gibt meiner Heldin eine Blume, wenn der zufriedene Held eine Blume findet.", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Your satisfied, gigantic and valiant hero gives my heroine a flower, if the satisfied hero finds a flower.", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Via kontenta, giganta kaj kuraĝa heroo donas floron al mia heroino, se la kontenta heroo trovas floron.", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Vuestro gigantesco héroe satisfecho y valiente da a mi heroína una flor si el héroe satisfecho encuentra una flor.", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Votre gigantesque héros satisfait et courageux donne à m'héroïne une fleur, si l'héros satisfait trouve une fleur.", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.TEST_CONCEPTS).translate(source).getTranslation());
    }
}

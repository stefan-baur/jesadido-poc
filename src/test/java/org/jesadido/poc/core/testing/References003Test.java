/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.testing;

import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.semantics.translating.TranslatorFactory;
import org.junit.Assert;
import org.junit.Test;

public class References003Test {
    
    @Test
    public void testVerticalTranslation000Game20160929043048MESZ() {
        final String source = "LudO HavAs Fin HeroIcxO .";
        Assert.assertEquals("{ Su ( LudO ) Dom ( HavAs ) Fin ( HeroIcxO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ein Spiel hat einen Helden.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A game has a hero.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ludo havas heroon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un juego tiene un héroe.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un jeu a un héros.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation001Game20160929043048MESZ() {
        final String source = "La LudO HavAs Fin La HeroIcxO .";
        Assert.assertEquals("{ Su ( La LudO ) Dom ( HavAs ) Fin ( La HeroIcxO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Das Spiel hat den Helden.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The game has the hero.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La ludo havas la heroon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El juego tiene el héroe.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Le jeu a l'héros.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation002Game20160929043048MESZ() {
        final String source = "Mi$La LudO HavAs Fin Bi$La HeroIcxO .";
        Assert.assertEquals("{ Su ( Mi$La LudO ) Dom ( HavAs ) Fin ( Bi$La HeroIcxO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Mein Spiel hat deinen Helden.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("My game has your hero.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Mia ludo havas vian heroon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Mi juego tiene tu héroe.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Mon jeu a ton héros.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation003Game20160929043048MESZ() {
        final String source = "Ni$La LudO HavAs Fin Vi$La HeroIcxO .";
        Assert.assertEquals("{ Su ( Ni$La LudO ) Dom ( HavAs ) Fin ( Vi$La HeroIcxO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Unser Spiel hat euren Helden.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Our game has your hero.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Nia ludo havas vian heroon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Nuestro juego tiene vuestro héroe.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Notre jeu a votre héros.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation004Game20160929043048MESZ() {
        final String source = "La LudO HavAs Fin Vi$La HeroIcxO .";
        Assert.assertEquals("{ Su ( La LudO ) Dom ( HavAs ) Fin ( Vi$La HeroIcxO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Das Spiel hat euren Helden.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The game has your hero.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La ludo havas vian heroon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El juego tiene vuestro héroe.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Le jeu a votre héros.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation005Game20160929043048MESZ() {
        final String source = "HeroIcxO TrovAs Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( TrovAs ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ein Held findet einen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero finds a pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroo trovas skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe encuentra un lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros trouve un crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation006Game20160929043048MESZ() {
        final String source = "La HeroIcxO TrovAs Fin La SkribIlO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( TrovAs ) Fin ( La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Der Held findet den Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero finds the pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroo trovas la skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe encuentra el lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros trouve le crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation007Game20160929043048MESZ() {
        final String source = "Mi$La HeroIcxO TrovAs Fin Bi$La SkribIlO .";
        Assert.assertEquals("{ Su ( Mi$La HeroIcxO ) Dom ( TrovAs ) Fin ( Bi$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Mein Held findet deinen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("My hero finds your pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Mia heroo trovas vian skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Mi héroe encuentra tu lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Mon héros trouve ton crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation008Game20160929043048MESZ() {
        final String source = "Vi$La HeroIcxO TrovAs Fin Ni$La SkribIlO .";
        Assert.assertEquals("{ Su ( Vi$La HeroIcxO ) Dom ( TrovAs ) Fin ( Ni$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Euer Held findet unseren Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Your hero finds our pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Via heroo trovas nian skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Vuestro héroe encuentra nuestro lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Votre héros trouve notre crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation009Game20160929043048MESZ() {
        final String source = "Mi$La HeroIcxO TrovAs Fin La SkribIlO .";
        Assert.assertEquals("{ Su ( Mi$La HeroIcxO ) Dom ( TrovAs ) Fin ( La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Mein Held findet den Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("My hero finds the pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Mia heroo trovas la skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Mi héroe encuentra el lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Mon héros trouve le crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation010Game20160929043048MESZ() {
        final String source = "HeroIcxO TrovAs Fin FlorO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( TrovAs ) Fin ( FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ein Held findet eine Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero finds a flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroo trovas floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe encuentra una flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros trouve une fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation011Game20160929043048MESZ() {
        final String source = "La HeroIcxO TrovAs Fin La FlorO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( TrovAs ) Fin ( La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Der Held findet die Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero finds the flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroo trovas la floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe encuentra la flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros trouve la fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation012Game20160929043048MESZ() {
        final String source = "Bi$La HeroIcxO TrovAs Fin Mi$La FlorO .";
        Assert.assertEquals("{ Su ( Bi$La HeroIcxO ) Dom ( TrovAs ) Fin ( Mi$La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Dein Held findet meine Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Your hero finds my flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Via heroo trovas mian floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Tu héroe encuentra mi flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ton héros trouve ma fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation013Game20160929043048MESZ() {
        final String source = "Vi$La HeroIcxO TrovAs Fin Ni$La FlorO .";
        Assert.assertEquals("{ Su ( Vi$La HeroIcxO ) Dom ( TrovAs ) Fin ( Ni$La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Euer Held findet unsere Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Your hero finds our flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Via heroo trovas nian floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Vuestro héroe encuentra nuestra flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Votre héros trouve notre fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation014Game20160929043048MESZ() {
        final String source = "Vi$La HeroIcxO TrovAs Fin FlorO .";
        Assert.assertEquals("{ Su ( Vi$La HeroIcxO ) Dom ( TrovAs ) Fin ( FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Euer Held findet eine Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Your hero finds a flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Via heroo trovas floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Vuestro héroe encuentra una flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Votre héros trouve une fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation015Game20160929043048MESZ() {
        final String source = "HeroInO TrovAs Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroInO ) Dom ( TrovAs ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Eine Heldin findet einen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A heroine finds a pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroino trovas skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Una heroína encuentra un lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Une héroïne trouve un crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation016Game20160929043048MESZ() {
        final String source = "La HeroInO TrovAs Fin La SkribIlO .";
        Assert.assertEquals("{ Su ( La HeroInO ) Dom ( TrovAs ) Fin ( La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Die Heldin findet den Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The heroine finds the pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroino trovas la skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroína encuentra el lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héroïne trouve le crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation017Game20160929043048MESZ() {
        final String source = "IcxO$Gxi$La HeroInO TrovAs Fin LudO$Gxi$La SkribIlO .";
        Assert.assertEquals("{ Su ( IcxO$Gxi$La HeroInO ) Dom ( TrovAs ) Fin ( LudO$Gxi$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Seine Heldin findet seinen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("His heroine finds its pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Lia heroino trovas ĝian skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Su heroína encuentra su lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("S'héroïne trouve son crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation018Game20160929043048MESZ() {
        final String source = "IcxArO$Ili$La HeroInO TrovAs Fin InArO$Ili$La SkribIlO .";
        Assert.assertEquals("{ Su ( IcxArO$Ili$La HeroInO ) Dom ( TrovAs ) Fin ( InArO$Ili$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ihre Heldin findet ihren Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Their heroine finds their pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ilia heroino trovas ilian skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Su heroína encuentra su lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Leur héroïne trouve leur crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation019Game20160929043048MESZ() {
        final String source = "La HeroInO TrovAs Fin LudO$Gxi$La SkribIlO .";
        Assert.assertEquals("{ Su ( La HeroInO ) Dom ( TrovAs ) Fin ( LudO$Gxi$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Die Heldin findet seinen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The heroine finds its pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroino trovas ĝian skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroína encuentra su lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héroïne trouve son crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation020Game20160929043048MESZ() {
        final String source = "Kaj HeroInO TrovAs Fin FlorO .";
        Assert.assertEquals("Kaj { Su ( HeroInO ) Dom ( TrovAs ) Fin ( FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Und eine Heldin findet eine Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("And a heroine finds a flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Kaj heroino trovas floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Y una heroína encuentra una flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Et une héroïne trouve une fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation021Game20160929043048MESZ() {
        final String source = "Kaj La HeroInO TrovAs Fin La FlorO .";
        Assert.assertEquals("Kaj { Su ( La HeroInO ) Dom ( TrovAs ) Fin ( La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Und die Heldin findet die Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("And the heroine finds the flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Kaj la heroino trovas la floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Y la heroína encuentra la flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Et l'héroïne trouve la fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation022Game20160929043048MESZ() {
        final String source = "Kaj InO$Gxi$La HeroInO TrovAs Fin InO$Bi$La FlorO .";
        Assert.assertEquals("Kaj { Su ( InO$Gxi$La HeroInO ) Dom ( TrovAs ) Fin ( InO$Bi$La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Und ihre Heldin findet deine Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("And her heroine finds your flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Kaj ŝia heroino trovas vian floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Y su heroína encuentra tu flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Et s'héroïne trouve ta fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation023Game20160929043048MESZ() {
        final String source = "Kaj InArO$Ili$La HeroInO TrovAs Fin InArO$Vi$La FlorO .";
        Assert.assertEquals("Kaj { Su ( InArO$Ili$La HeroInO ) Dom ( TrovAs ) Fin ( InArO$Vi$La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Und ihre Heldin findet eure Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("And their heroine finds your flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Kaj ilia heroino trovas vian floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Y su heroína encuentra vuestra flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Et leur héroïne trouve votre fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation024Game20160929043048MESZ() {
        final String source = "Kaj HeroInO TrovAs Fin InArO$Vi$La FlorO .";
        Assert.assertEquals("Kaj { Su ( HeroInO ) Dom ( TrovAs ) Fin ( InArO$Vi$La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Und eine Heldin findet eure Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("And a heroine finds your flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Kaj heroino trovas vian floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Y una heroína encuentra vuestra flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Et une héroïne trouve votre fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation025Game20160929043048MESZ() {
        final String source = "HeroIcxO HavAs Fin NomO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( HavAs ) Fin ( NomO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ein Held hat einen Namen.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero has a name.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroo havas nomon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe tiene un nombre.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros a un nom.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation026Game20160929043048MESZ() {
        final String source = "La HeroIcxO HavAs Fin La NomO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( HavAs ) Fin ( La NomO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Der Held hat den Namen.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero has the name.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroo havas la nomon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe tiene el nombre.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros a le nom.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation027Game20160929043048MESZ() {
        final String source = "IcxO$Mi$La HeroIcxO HavAs Fin HeroInO$Gxi$La NomO .";
        Assert.assertEquals("{ Su ( IcxO$Mi$La HeroIcxO ) Dom ( HavAs ) Fin ( HeroInO$Gxi$La NomO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Mein Held hat ihren Namen.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("My hero has her name.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Mia heroo havas ŝian nomon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Mi héroe tiene su nombre.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Mon héros a son nom.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation028Game20160929043048MESZ() {
        final String source = "IcxArO$Ni$La HeroIcxO HavAs Fin HeroInArO$Ili$La NomO .";
        Assert.assertEquals("{ Su ( IcxArO$Ni$La HeroIcxO ) Dom ( HavAs ) Fin ( HeroInArO$Ili$La NomO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Unser Held hat ihren Namen.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Our hero has their name.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Nia heroo havas ilian nomon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Nuestro héroe tiene su nombre.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Notre héros a leur nom.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation029Game20160929043048MESZ() {
        final String source = "IcxO$Mi$La HeroIcxO HavAs Fin NomO .";
        Assert.assertEquals("{ Su ( IcxO$Mi$La HeroIcxO ) Dom ( HavAs ) Fin ( NomO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Mein Held hat einen Namen.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("My hero has a name.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Mia heroo havas nomon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Mi héroe tiene un nombre.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Mon héros a un nom.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation030Game20160929043048MESZ() {
        final String source = "HeroIcxO DonAs Al HeroInO Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( DonAs ) Al ( HeroInO ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ein Held gibt einer Heldin einen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero gives a heroine a pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroo donas al heroino skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe da a una heroína un lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros donne à une héroïne un crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation031Game20160929043048MESZ() {
        final String source = "La HeroIcxO DonAs Al La HeroInO Fin La SkribIlO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( DonAs ) Al ( La HeroInO ) Fin ( La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Der Held gibt der Heldin den Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero gives the heroine the pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroo donas al la heroino la skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe da a la heroína el lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros donne à l'héroïne le crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation032Game20160929043048MESZ() {
        final String source = "InO$Bi$La HeroIcxO DonAs Al HeroIcxO$Mi$La HeroInO Fin LudO$Gxi$La SkribIlO .";
        Assert.assertEquals("{ Su ( InO$Bi$La HeroIcxO ) Dom ( DonAs ) Al ( HeroIcxO$Mi$La HeroInO ) Fin ( LudO$Gxi$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Dein Held gibt meiner Heldin seinen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Your hero gives my heroine its pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Via heroo donas al mia heroino ĝian skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Tu héroe da a mi heroína su lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ton héros donne à m'héroïne son crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation033Game20160929043048MESZ() {
        final String source = "InArO$Vi$La HeroIcxO DonAs Al HeroIcxArO$Ni$La HeroInO Fin LudArO$Ili$La SkribIlO .";
        Assert.assertEquals("{ Su ( InArO$Vi$La HeroIcxO ) Dom ( DonAs ) Al ( HeroIcxArO$Ni$La HeroInO ) Fin ( LudArO$Ili$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Euer Held gibt unserer Heldin ihren Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Your hero gives our heroine their pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Via heroo donas al nia heroino ilian skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Vuestro héroe da a nuestra heroína su lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Votre héros donne à notre héroïne leur crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation034Game20160929043048MESZ() {
        final String source = "HeroIcxO DonAs Al La HeroInO Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( DonAs ) Al ( La HeroInO ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ein Held gibt der Heldin einen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero gives the heroine a pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroo donas al la heroino skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe da a la heroína un lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros donne à l'héroïne un crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation035Game20160929043048MESZ() {
        final String source = "HeroIcxO DonAs Al HeroInO Fin FlorO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( DonAs ) Al ( HeroInO ) Fin ( FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ein Held gibt einer Heldin eine Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero gives a heroine a flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroo donas al heroino floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe da a una heroína una flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros donne à une héroïne une fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation036Game20160929043048MESZ() {
        final String source = "La HeroIcxO DonAs Al La HeroInO Fin La FlorO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( DonAs ) Al ( La HeroInO ) Fin ( La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Der Held gibt der Heldin die Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero gives the heroine the flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroo donas al la heroino la floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe da a la heroína la flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros donne à l'héroïne la fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation037Game20160929043048MESZ() {
        final String source = "IcxO$Gxi$La HeroIcxO DonAs Al Bi$La HeroInO Fin Mi$La FlorO .";
        Assert.assertEquals("{ Su ( IcxO$Gxi$La HeroIcxO ) Dom ( DonAs ) Al ( Bi$La HeroInO ) Fin ( Mi$La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Sein Held gibt deiner Heldin meine Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("His hero gives your heroine my flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Lia heroo donas al via heroino mian floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Su héroe da a tu heroína mi flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Son héros donne à t'héroïne ma fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation038Game20160929043048MESZ() {
        final String source = "Ili$La HeroIcxO DonAs Al Vi$La HeroInO Fin Ni$La FlorO .";
        Assert.assertEquals("{ Su ( Ili$La HeroIcxO ) Dom ( DonAs ) Al ( Vi$La HeroInO ) Fin ( Ni$La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ihr Held gibt euerer Heldin unsere Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Their hero gives your heroine our flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ilia heroo donas al via heroino nian floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Su héroe da a vuestra heroína nuestra flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Leur héros donne à votre héroïne notre fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation039Game20160929043048MESZ() {
        final String source = "HeroIcxO DonAs Al HeroInO Fin HomArO$Ni$La FlorO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( DonAs ) Al ( HeroInO ) Fin ( HomArO$Ni$La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ein Held gibt einer Heldin unsere Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero gives a heroine our flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroo donas al heroino nian floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe da a una heroína nuestra flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros donne à une héroïne notre fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation040Game20160929043048MESZ() {
        final String source = "HeroInO DonAs Al HeroIcxO Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroInO ) Dom ( DonAs ) Al ( HeroIcxO ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Eine Heldin gibt einem Helden einen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A heroine gives a hero a pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroino donas al heroo skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Una heroína da a un héroe un lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Une héroïne donne à un héros un crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation041Game20160929043048MESZ() {
        final String source = "La HeroInO DonAs Al La HeroIcxO Fin La SkribIlO .";
        Assert.assertEquals("{ Su ( La HeroInO ) Dom ( DonAs ) Al ( La HeroIcxO ) Fin ( La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Die Heldin gibt dem Helden den Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The heroine gives the hero the pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroino donas al la heroo la skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroína da al héroe el lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héroïne donne à l'héros le crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation042Game20160929043048MESZ() {
        final String source = "InO$Gxi$La HeroInO DonAs Al Mi$La HeroIcxO Fin Bi$La SkribIlO .";
        Assert.assertEquals("{ Su ( InO$Gxi$La HeroInO ) Dom ( DonAs ) Al ( Mi$La HeroIcxO ) Fin ( Bi$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ihre Heldin gibt meinem Helden deinen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Her heroine gives my hero your pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ŝia heroino donas al mia heroo vian skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Su heroína da a mi héroe tu lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("S'héroïne donne à mon héros ton crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation043Game20160929043048MESZ() {
        final String source = "InArO$Ili$La HeroInO DonAs Al Ni$La HeroIcxO Fin Vi$La SkribIlO .";
        Assert.assertEquals("{ Su ( InArO$Ili$La HeroInO ) Dom ( DonAs ) Al ( Ni$La HeroIcxO ) Fin ( Vi$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ihre Heldin gibt unserem Helden euren Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Their heroine gives our hero your pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ilia heroino donas al nia heroo vian skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Su heroína da a nuestro héroe vuestro lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Leur héroïne donne à notre héros votre crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation044Game20160929043048MESZ() {
        final String source = "HeroInO DonAs Al La HeroIcxO Fin Bi$La SkribIlO .";
        Assert.assertEquals("{ Su ( HeroInO ) Dom ( DonAs ) Al ( La HeroIcxO ) Fin ( Bi$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Eine Heldin gibt dem Helden deinen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A heroine gives the hero your pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroino donas al la heroo vian skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Una heroína da al héroe tu lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Une héroïne donne à l'héros ton crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation045Game20160929043048MESZ() {
        final String source = "Kaj HeroInO DonAs Al HeroIcxO Fin FlorO .";
        Assert.assertEquals("Kaj { Su ( HeroInO ) Dom ( DonAs ) Al ( HeroIcxO ) Fin ( FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Und eine Heldin gibt einem Helden eine Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("And a heroine gives a hero a flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Kaj heroino donas al heroo floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Y una heroína da a un héroe una flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Et une héroïne donne à un héros une fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation046Game20160929043048MESZ() {
        final String source = "Kaj La HeroInO DonAs Al La HeroIcxO Fin La FlorO .";
        Assert.assertEquals("Kaj { Su ( La HeroInO ) Dom ( DonAs ) Al ( La HeroIcxO ) Fin ( La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Und die Heldin gibt dem Helden die Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("And the heroine gives the hero the flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Kaj la heroino donas al la heroo la floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Y la heroína da al héroe la flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Et l'héroïne donne à l'héros la fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation047Game20160929043048MESZ() {
        final String source = "Kaj Gxi$La HeroInO DonAs Al Bi$La HeroIcxO Fin HeroInO$Gxi$La FlorO .";
        Assert.assertEquals("Kaj { Su ( Gxi$La HeroInO ) Dom ( DonAs ) Al ( Bi$La HeroIcxO ) Fin ( HeroInO$Gxi$La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Und seine Heldin gibt deinem Helden ihre Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("And its heroine gives your hero her flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Kaj ĝia heroino donas al via heroo ŝian floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Y su heroína da a tu héroe su flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Et s'héroïne donne à ton héros sa fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation048Game20160929043048MESZ() {
        final String source = "Kaj Ili$La HeroInO DonAs Al Vi$La HeroIcxO Fin HeroInArO$Ili$La FlorO .";
        Assert.assertEquals("Kaj { Su ( Ili$La HeroInO ) Dom ( DonAs ) Al ( Vi$La HeroIcxO ) Fin ( HeroInArO$Ili$La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Und ihre Heldin gibt eurem Helden ihre Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("And their heroine gives your hero their flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Kaj ilia heroino donas al via heroo ilian floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Y su heroína da a vuestro héroe su flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Et leur héroïne donne à votre héros leur fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation049Game20160929043048MESZ() {
        final String source = "Kaj La HeroInO DonAs Al HeroIcxO Fin HeroInArO$Ili$La FlorO .";
        Assert.assertEquals("Kaj { Su ( La HeroInO ) Dom ( DonAs ) Al ( HeroIcxO ) Fin ( HeroInArO$Ili$La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Und die Heldin gibt einem Helden ihre Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("And the heroine gives a hero their flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Kaj la heroino donas al heroo ilian floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Y la heroína da a un héroe su flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Et l'héroïne donne à un héros leur fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation050Game20160929043048MESZ() {
        final String source = "HeroIcxO TrovAs Fin FlorO Kaj HeroInO TrovAs Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( TrovAs ) Fin ( FlorO ) } Kaj { Su ( HeroInO ) Dom ( TrovAs ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ein Held findet eine Blume, und eine Heldin findet einen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero finds a flower, and a heroine finds a pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroo trovas floron, kaj heroino trovas skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe encuentra una flor, y una heroína encuentra un lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros trouve une fleur et une héroïne trouve un crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation051Game20160929043048MESZ() {
        final String source = "La HeroIcxO TrovAs Fin La FlorO Kaj La HeroInO TrovAs Fin La SkribIlO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( TrovAs ) Fin ( La FlorO ) } Kaj { Su ( La HeroInO ) Dom ( TrovAs ) Fin ( La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Der Held findet die Blume, und die Heldin findet den Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero finds the flower, and the heroine finds the pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroo trovas la floron, kaj la heroino trovas la skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe encuentra la flor, y la heroína encuentra el lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros trouve la fleur et l'héroïne trouve le crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation052Game20160929043048MESZ() {
        final String source = "Mi$La HeroIcxO TrovAs Fin Bi$La FlorO Kaj Bi$La HeroInO TrovAs Fin Mi$La SkribIlO .";
        Assert.assertEquals("{ Su ( Mi$La HeroIcxO ) Dom ( TrovAs ) Fin ( Bi$La FlorO ) } Kaj { Su ( Bi$La HeroInO ) Dom ( TrovAs ) Fin ( Mi$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Mein Held findet deine Blume, und deine Heldin findet meinen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("My hero finds your flower, and your heroine finds my pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Mia heroo trovas vian floron, kaj via heroino trovas mian skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Mi héroe encuentra tu flor, y tu heroína encuentra mi lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Mon héros trouve ta fleur et t'héroïne trouve mon crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation053Game20160929043048MESZ() {
        final String source = "Ni$La HeroIcxO TrovAs Fin Vi$La FlorO Kaj Vi$La HeroInO TrovAs Fin Ni$La SkribIlO .";
        Assert.assertEquals("{ Su ( Ni$La HeroIcxO ) Dom ( TrovAs ) Fin ( Vi$La FlorO ) } Kaj { Su ( Vi$La HeroInO ) Dom ( TrovAs ) Fin ( Ni$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Unser Held findet eure Blume, und eure Heldin findet unseren Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Our hero finds your flower, and your heroine finds our pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Nia heroo trovas vian floron, kaj via heroino trovas nian skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Nuestro héroe encuentra vuestra flor, y vuestra heroína encuentra nuestro lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Notre héros trouve votre fleur et votre héroïne trouve notre crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation054Game20160929043048MESZ() {
        final String source = "La HeroIcxO TrovAs Fin FlorO Kaj Vi$La HeroInO TrovAs Fin SkribIlO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( TrovAs ) Fin ( FlorO ) } Kaj { Su ( Vi$La HeroInO ) Dom ( TrovAs ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Der Held findet eine Blume, und eure Heldin findet einen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero finds a flower, and your heroine finds a pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroo trovas floron, kaj via heroino trovas skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe encuentra una flor, y vuestra heroína encuentra un lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros trouve une fleur et votre héroïne trouve un crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation055Game20160929043048MESZ() {
        final String source = "HeroIcxO DonAs Al HeroInO Fin FlorO Kaj HeroInO DonAs Al HeroIcxO Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( DonAs ) Al ( HeroInO ) Fin ( FlorO ) } Kaj { Su ( HeroInO ) Dom ( DonAs ) Al ( HeroIcxO ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ein Held gibt einer Heldin eine Blume, und eine Heldin gibt einem Helden einen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero gives a heroine a flower, and a heroine gives a hero a pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroo donas al heroino floron, kaj heroino donas al heroo skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe da a una heroína una flor, y una heroína da a un héroe un lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros donne à une héroïne une fleur et une héroïne donne à un héros un crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation056Game20160929043048MESZ() {
        final String source = "La HeroIcxO DonAs Al La HeroInO Fin La FlorO Kaj La HeroInO DonAs Al La HeroIcxO Fin La SkribIlO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( DonAs ) Al ( La HeroInO ) Fin ( La FlorO ) } Kaj { Su ( La HeroInO ) Dom ( DonAs ) Al ( La HeroIcxO ) Fin ( La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Der Held gibt der Heldin die Blume, und die Heldin gibt dem Helden den Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero gives the heroine the flower, and the heroine gives the hero the pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroo donas al la heroino la floron, kaj la heroino donas al la heroo la skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe da a la heroína la flor, y la heroína da al héroe el lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros donne à l'héroïne la fleur et l'héroïne donne à l'héros le crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation057Game20160929043048MESZ() {
        final String source = "Bi$La HeroIcxO DonAs Al Mi$La HeroInO Fin LudO$Gxi$La FlorO Kaj Mi$La HeroInO DonAs Al InO$Bi$La HeroIcxO Fin HeroInO$Gxi$La SkribIlO .";
        Assert.assertEquals("{ Su ( Bi$La HeroIcxO ) Dom ( DonAs ) Al ( Mi$La HeroInO ) Fin ( LudO$Gxi$La FlorO ) } Kaj { Su ( Mi$La HeroInO ) Dom ( DonAs ) Al ( InO$Bi$La HeroIcxO ) Fin ( HeroInO$Gxi$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Dein Held gibt meiner Heldin seine Blume, und meine Heldin gibt deinem Helden ihren Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Your hero gives my heroine its flower, and my heroine gives your hero her pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Via heroo donas al mia heroino ĝian floron, kaj mia heroino donas al via heroo ŝian skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Tu héroe da a mi heroína su flor, y mi heroína da a tu héroe su lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ton héros donne à m'héroïne sa fleur et m'héroïne donne à ton héros son crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation058Game20160929043048MESZ() {
        final String source = "Vi$La HeroIcxO DonAs Al Ni$La HeroInO Fin LudArO$Ili$La FlorO Kaj Ni$La HeroInO DonAs Al InArO$Vi$La HeroIcxO Fin HeroInArO$Ili$La SkribIlO .";
        Assert.assertEquals("{ Su ( Vi$La HeroIcxO ) Dom ( DonAs ) Al ( Ni$La HeroInO ) Fin ( LudArO$Ili$La FlorO ) } Kaj { Su ( Ni$La HeroInO ) Dom ( DonAs ) Al ( InArO$Vi$La HeroIcxO ) Fin ( HeroInArO$Ili$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Euer Held gibt unserer Heldin ihre Blume, und unsere Heldin gibt eurem Helden ihren Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Your hero gives our heroine their flower, and our heroine gives your hero their pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Via heroo donas al nia heroino ilian floron, kaj nia heroino donas al via heroo ilian skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Vuestro héroe da a nuestra heroína su flor, y nuestra heroína da a vuestro héroe su lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Votre héros donne à notre héroïne leur fleur et notre héroïne donne à votre héros leur crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation059Game20160929043048MESZ() {
        final String source = "Bi$La HeroIcxO DonAs Al HeroInO Fin La FlorO Kaj HeroInO DonAs Al HeroIcxO Fin SkribIlO .";
        Assert.assertEquals("{ Su ( Bi$La HeroIcxO ) Dom ( DonAs ) Al ( HeroInO ) Fin ( La FlorO ) } Kaj { Su ( HeroInO ) Dom ( DonAs ) Al ( HeroIcxO ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Dein Held gibt einer Heldin die Blume, und eine Heldin gibt einem Helden einen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Your hero gives a heroine the flower, and a heroine gives a hero a pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Via heroo donas al heroino la floron, kaj heroino donas al heroo skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Tu héroe da a una heroína la flor, y una heroína da a un héroe un lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ton héros donne à une héroïne la fleur et une héroïne donne à un héros un crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation060Game20160929043048MESZ() {
        final String source = "HeroIcxO DonAs Al HeroInO Fin FlorO Aux HeroInO DonAs Al HeroIcxO Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( DonAs ) Al ( HeroInO ) Fin ( FlorO ) } Aux { Su ( HeroInO ) Dom ( DonAs ) Al ( HeroIcxO ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ein Held gibt einer Heldin eine Blume, oder eine Heldin gibt einem Helden einen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero gives a heroine a flower, or a heroine gives a hero a pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroo donas al heroino floron, aŭ heroino donas al heroo skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe da a una heroína una flor, o una heroína da a un héroe un lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros donne à une héroïne une fleur ou une héroïne donne à un héros un crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation061Game20160929043048MESZ() {
        final String source = "La HeroIcxO DonAs Al La HeroInO Fin La FlorO Aux La HeroInO DonAs Al La HeroIcxO Fin La SkribIlO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( DonAs ) Al ( La HeroInO ) Fin ( La FlorO ) } Aux { Su ( La HeroInO ) Dom ( DonAs ) Al ( La HeroIcxO ) Fin ( La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Der Held gibt der Heldin die Blume, oder die Heldin gibt dem Helden den Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero gives the heroine the flower, or the heroine gives the hero the pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroo donas al la heroino la floron, aŭ la heroino donas al la heroo la skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe da a la heroína la flor, o la heroína da al héroe el lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros donne à l'héroïne la fleur ou l'héroïne donne à l'héros le crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation062Game20160929043048MESZ() {
        final String source = "LudO$Gxi$La HeroIcxO DonAs Al Mi$La HeroInO Fin Bi$La FlorO Aux Mi$La HeroInO DonAs Al Gxi$La HeroIcxO Fin Mi$La SkribIlO .";
        Assert.assertEquals("{ Su ( LudO$Gxi$La HeroIcxO ) Dom ( DonAs ) Al ( Mi$La HeroInO ) Fin ( Bi$La FlorO ) } Aux { Su ( Mi$La HeroInO ) Dom ( DonAs ) Al ( Gxi$La HeroIcxO ) Fin ( Mi$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Sein Held gibt meiner Heldin deine Blume, oder meine Heldin gibt seinem Helden meinen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Its hero gives my heroine your flower, or my heroine gives its hero my pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ĝia heroo donas al mia heroino vian floron, aŭ mia heroino donas al ĝia heroo mian skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Su héroe da a mi heroína tu flor, o mi heroína da a su héroe mi lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Son héros donne à m'héroïne ta fleur ou m'héroïne donne à son héros mon crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation063Game20160929043048MESZ() {
        final String source = "LudArO$Ili$La HeroIcxO DonAs Al Ni$La HeroInO Fin Vi$La FlorO Aux Ni$La HeroInO DonAs Al Ili$La HeroIcxO Fin Ni$La SkribIlO .";
        Assert.assertEquals("{ Su ( LudArO$Ili$La HeroIcxO ) Dom ( DonAs ) Al ( Ni$La HeroInO ) Fin ( Vi$La FlorO ) } Aux { Su ( Ni$La HeroInO ) Dom ( DonAs ) Al ( Ili$La HeroIcxO ) Fin ( Ni$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ihr Held gibt unserer Heldin eure Blume, oder unsere Heldin gibt ihrem Helden unseren Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Their hero gives our heroine your flower, or our heroine gives their hero our pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ilia heroo donas al nia heroino vian floron, aŭ nia heroino donas al ilia heroo nian skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Su héroe da a nuestra heroína vuestra flor, o nuestra heroína da a su héroe nuestro lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Leur héros donne à notre héroïne votre fleur ou notre héroïne donne à leur héros notre crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation064Game20160929043048MESZ() {
        final String source = "HeroIcxO DonAs Al Ni$La HeroInO Fin FlorO Aux La HeroInO DonAs Al HeroIcxO Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( DonAs ) Al ( Ni$La HeroInO ) Fin ( FlorO ) } Aux { Su ( La HeroInO ) Dom ( DonAs ) Al ( HeroIcxO ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ein Held gibt unserer Heldin eine Blume, oder die Heldin gibt einem Helden einen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero gives our heroine a flower, or the heroine gives a hero a pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroo donas al nia heroino floron, aŭ la heroino donas al heroo skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe da a nuestra heroína una flor, o la heroína da a un héroe un lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros donne à notre héroïne une fleur ou l'héroïne donne à un héros un crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation065Game20160929043048MESZ() {
        final String source = "Fin SkribIlO Su HeroIcxO TrovAs . Fin NomO Al HeroIcxO DonAs HeroInO .";
        Assert.assertEquals("{ Fin ( SkribIlO ) Su ( HeroIcxO ) Dom ( TrovAs ) } . { Fin ( NomO ) Al ( HeroIcxO ) Dom ( DonAs ) Su ( HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Einen Stift findet ein Held. Einen Namen gibt eine Heldin einem Helden.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero finds a pen. A heroine gives a hero a name.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Skribilon heroo trovas. Nomon al heroo donas heroino.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe encuentra un lapicero. Una heroína da a un héroe un nombre.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros trouve un crayon. Une héroïne donne à un héros un nom.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation066Game20160929043048MESZ() {
        final String source = "Fin La SkribIlO Su La HeroIcxO TrovAs . Fin La NomO Al La HeroIcxO DonAs La HeroInO .";
        Assert.assertEquals("{ Fin ( La SkribIlO ) Su ( La HeroIcxO ) Dom ( TrovAs ) } . { Fin ( La NomO ) Al ( La HeroIcxO ) Dom ( DonAs ) Su ( La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Den Stift findet der Held. Den Namen gibt die Heldin dem Helden.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero finds the pen. The heroine gives the hero the name.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La skribilon la heroo trovas. La nomon al la heroo donas la heroino.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe encuentra el lapicero. La heroína da al héroe el nombre.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros trouve le crayon. L'héroïne donne à l'héros le nom.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation067Game20160929043048MESZ() {
        final String source = "Fin Mi$La SkribIlO Su Bi$La HeroIcxO TrovAs . Fin Bi$La NomO Al Mi$La HeroIcxO DonAs Bi$La HeroInO .";
        Assert.assertEquals("{ Fin ( Mi$La SkribIlO ) Su ( Bi$La HeroIcxO ) Dom ( TrovAs ) } . { Fin ( Bi$La NomO ) Al ( Mi$La HeroIcxO ) Dom ( DonAs ) Su ( Bi$La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Meinen Stift findet dein Held. Deinen Namen gibt deine Heldin meinem Helden.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Your hero finds my pen. Your heroine gives my hero your name.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Mian skribilon via heroo trovas. Vian nomon al mia heroo donas via heroino.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Tu héroe encuentra mi lapicero. Tu heroína da a mi héroe tu nombre.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ton héros trouve mon crayon. T'héroïne donne à mon héros ton nom.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation068Game20160929043048MESZ() {
        final String source = "Fin Ni$La SkribIlO Su Vi$La HeroIcxO TrovAs . Fin Vi$La NomO Al Ni$La HeroIcxO DonAs Vi$La HeroInO .";
        Assert.assertEquals("{ Fin ( Ni$La SkribIlO ) Su ( Vi$La HeroIcxO ) Dom ( TrovAs ) } . { Fin ( Vi$La NomO ) Al ( Ni$La HeroIcxO ) Dom ( DonAs ) Su ( Vi$La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Unseren Stift findet euer Held. Euren Namen gibt eure Heldin unserem Helden.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Your hero finds our pen. Your heroine gives our hero your name.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Nian skribilon via heroo trovas. Vian nomon al nia heroo donas via heroino.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Vuestro héroe encuentra nuestro lapicero. Vuestra heroína da a nuestro héroe vuestro nombre.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Votre héros trouve notre crayon. Votre héroïne donne à notre héros votre nom.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation069Game20160929043048MESZ() {
        final String source = "Fin SkribIlO Su Vi$La HeroIcxO TrovAs . Fin NomO Al Mi$La HeroIcxO DonAs La HeroInO .";
        Assert.assertEquals("{ Fin ( SkribIlO ) Su ( Vi$La HeroIcxO ) Dom ( TrovAs ) } . { Fin ( NomO ) Al ( Mi$La HeroIcxO ) Dom ( DonAs ) Su ( La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Einen Stift findet euer Held. Einen Namen gibt die Heldin meinem Helden.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Your hero finds a pen. The heroine gives my hero a name.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Skribilon via heroo trovas. Nomon al mia heroo donas la heroino.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Vuestro héroe encuentra un lapicero. La heroína da a mi héroe un nombre.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Votre héros trouve un crayon. L'héroïne donne à mon héros un nom.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation070Game20160929043048MESZ() {
        final String source = "Fin SkribIlO TrovAs Su HeroIcxO Kaj TrovAs Fin FlorO Su HeroInO Kaj Al HeroIcxO Fin FlorO DonAs HeroInO .";
        Assert.assertEquals("{ Fin ( SkribIlO ) Dom ( TrovAs ) Su ( HeroIcxO ) } Kaj { Dom ( TrovAs ) Fin ( FlorO ) Su ( HeroInO ) } Kaj { Al ( HeroIcxO ) Fin ( FlorO ) Dom ( DonAs ) Su ( HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Einen Stift findet ein Held, und eine Blume findet eine Heldin, und eine Blume gibt eine Heldin einem Helden.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero finds a pen, and a heroine finds a flower, and a heroine gives a hero a flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Skribilon trovas heroo, kaj trovas floron heroino, kaj al heroo floron donas heroino.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe encuentra un lapicero, y una heroína encuentra una flor, y una heroína da a un héroe una flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros trouve un crayon et une héroïne trouve une fleur et une héroïne donne à un héros une fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation071Game20160929043048MESZ() {
        final String source = "Fin La SkribIlO TrovAs Su La HeroIcxO Kaj TrovAs Fin La FlorO Su La HeroInO Kaj Al La HeroIcxO Fin La FlorO DonAs La HeroInO .";
        Assert.assertEquals("{ Fin ( La SkribIlO ) Dom ( TrovAs ) Su ( La HeroIcxO ) } Kaj { Dom ( TrovAs ) Fin ( La FlorO ) Su ( La HeroInO ) } Kaj { Al ( La HeroIcxO ) Fin ( La FlorO ) Dom ( DonAs ) Su ( La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Den Stift findet der Held, und die Blume findet die Heldin, und die Blume gibt die Heldin dem Helden.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero finds the pen, and the heroine finds the flower, and the heroine gives the hero the flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La skribilon trovas la heroo, kaj trovas la floron la heroino, kaj al la heroo la floron donas la heroino.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe encuentra el lapicero, y la heroína encuentra la flor, y la heroína da al héroe la flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros trouve le crayon et l'héroïne trouve la fleur et l'héroïne donne à l'héros la fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation072Game20160929043048MESZ() {
        final String source = "Fin Bi$La SkribIlO TrovAs Su Mi$La HeroIcxO Kaj TrovAs Fin Bi$La FlorO Su Mi$La HeroInO Kaj Al Bi$La HeroIcxO Fin Mi$La FlorO DonAs Bi$La HeroInO .";
        Assert.assertEquals("{ Fin ( Bi$La SkribIlO ) Dom ( TrovAs ) Su ( Mi$La HeroIcxO ) } Kaj { Dom ( TrovAs ) Fin ( Bi$La FlorO ) Su ( Mi$La HeroInO ) } Kaj { Al ( Bi$La HeroIcxO ) Fin ( Mi$La FlorO ) Dom ( DonAs ) Su ( Bi$La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Deinen Stift findet mein Held, und deine Blume findet meine Heldin, und meine Blume gibt deine Heldin deinem Helden.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("My hero finds your pen, and my heroine finds your flower, and your heroine gives your hero my flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Vian skribilon trovas mia heroo, kaj trovas vian floron mia heroino, kaj al via heroo mian floron donas via heroino.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Mi héroe encuentra tu lapicero, y mi heroína encuentra tu flor, y tu heroína da a tu héroe mi flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Mon héros trouve ton crayon et m'héroïne trouve ta fleur et t'héroïne donne à ton héros ma fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation073Game20160929043049MESZ() {
        final String source = "Fin Vi$La SkribIlO TrovAs Su Ni$La HeroIcxO Kaj TrovAs Fin Vi$La FlorO Su Ni$La HeroInO Kaj Al Vi$La HeroIcxO Fin Ni$La FlorO DonAs Vi$La HeroInO .";
        Assert.assertEquals("{ Fin ( Vi$La SkribIlO ) Dom ( TrovAs ) Su ( Ni$La HeroIcxO ) } Kaj { Dom ( TrovAs ) Fin ( Vi$La FlorO ) Su ( Ni$La HeroInO ) } Kaj { Al ( Vi$La HeroIcxO ) Fin ( Ni$La FlorO ) Dom ( DonAs ) Su ( Vi$La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Euren Stift findet unser Held, und eure Blume findet unsere Heldin, und unsere Blume gibt eure Heldin eurem Helden.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Our hero finds your pen, and our heroine finds your flower, and your heroine gives your hero our flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Vian skribilon trovas nia heroo, kaj trovas vian floron nia heroino, kaj al via heroo nian floron donas via heroino.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Nuestro héroe encuentra vuestro lapicero, y nuestra heroína encuentra vuestra flor, y vuestra heroína da a vuestro héroe nuestra flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Notre héros trouve votre crayon et notre héroïne trouve votre fleur et votre héroïne donne à votre héros notre fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation074Game20160929043049MESZ() {
        final String source = "Fin Bi$La SkribIlO TrovAs Su HeroIcxO Kaj TrovAs Fin FlorO Su Ni$La HeroInO Kaj Al La HeroIcxO Fin FlorO DonAs Bi$La HeroInO .";
        Assert.assertEquals("{ Fin ( Bi$La SkribIlO ) Dom ( TrovAs ) Su ( HeroIcxO ) } Kaj { Dom ( TrovAs ) Fin ( FlorO ) Su ( Ni$La HeroInO ) } Kaj { Al ( La HeroIcxO ) Fin ( FlorO ) Dom ( DonAs ) Su ( Bi$La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Deinen Stift findet ein Held, und eine Blume findet unsere Heldin, und eine Blume gibt deine Heldin dem Helden.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero finds your pen, and our heroine finds a flower, and your heroine gives the hero a flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Vian skribilon trovas heroo, kaj trovas floron nia heroino, kaj al la heroo floron donas via heroino.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe encuentra tu lapicero, y nuestra heroína encuentra una flor, y tu heroína da al héroe una flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros trouve ton crayon et notre héroïne trouve une fleur et t'héroïne donne à l'héros une fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation075Game20160929043049MESZ() {
        final String source = "Fin SkribIlO TrovAs Su HeroIcxO , TrovAs Fin FlorO Su HeroInO , Al HeroIcxO Fin FlorO DonAs HeroInO .";
        Assert.assertEquals("{ Fin ( SkribIlO ) Dom ( TrovAs ) Su ( HeroIcxO ) } , { Dom ( TrovAs ) Fin ( FlorO ) Su ( HeroInO ) } , { Al ( HeroIcxO ) Fin ( FlorO ) Dom ( DonAs ) Su ( HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Einen Stift findet ein Held, eine Blume findet eine Heldin, eine Blume gibt eine Heldin einem Helden.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero finds a pen, a heroine finds a flower, a heroine gives a hero a flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Skribilon trovas heroo, trovas floron heroino, al heroo floron donas heroino.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe encuentra un lapicero, una heroína encuentra una flor, una heroína da a un héroe una flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros trouve un crayon, une héroïne trouve une fleur, une héroïne donne à un héros une fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation076Game20160929043049MESZ() {
        final String source = "Fin La SkribIlO TrovAs Su La HeroIcxO , TrovAs Fin La FlorO Su La HeroInO , Al La HeroIcxO Fin La FlorO DonAs La HeroInO .";
        Assert.assertEquals("{ Fin ( La SkribIlO ) Dom ( TrovAs ) Su ( La HeroIcxO ) } , { Dom ( TrovAs ) Fin ( La FlorO ) Su ( La HeroInO ) } , { Al ( La HeroIcxO ) Fin ( La FlorO ) Dom ( DonAs ) Su ( La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Den Stift findet der Held, die Blume findet die Heldin, die Blume gibt die Heldin dem Helden.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero finds the pen, the heroine finds the flower, the heroine gives the hero the flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La skribilon trovas la heroo, trovas la floron la heroino, al la heroo la floron donas la heroino.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe encuentra el lapicero, la heroína encuentra la flor, la heroína da al héroe la flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros trouve le crayon, l'héroïne trouve la fleur, l'héroïne donne à l'héros la fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation077Game20160929043049MESZ() {
        final String source = "Fin LudO$Gxi$La SkribIlO TrovAs Su Mi$La HeroIcxO , TrovAs Fin Bi$La FlorO Su Mi$La HeroInO , Al Bi$La HeroIcxO Fin Mi$La FlorO DonAs Bi$La HeroInO .";
        Assert.assertEquals("{ Fin ( LudO$Gxi$La SkribIlO ) Dom ( TrovAs ) Su ( Mi$La HeroIcxO ) } , { Dom ( TrovAs ) Fin ( Bi$La FlorO ) Su ( Mi$La HeroInO ) } , { Al ( Bi$La HeroIcxO ) Fin ( Mi$La FlorO ) Dom ( DonAs ) Su ( Bi$La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Seinen Stift findet mein Held, deine Blume findet meine Heldin, meine Blume gibt deine Heldin deinem Helden.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("My hero finds its pen, my heroine finds your flower, your heroine gives your hero my flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ĝian skribilon trovas mia heroo, trovas vian floron mia heroino, al via heroo mian floron donas via heroino.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Mi héroe encuentra su lapicero, mi heroína encuentra tu flor, tu heroína da a tu héroe mi flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Mon héros trouve son crayon, m'héroïne trouve ta fleur, t'héroïne donne à ton héros ma fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation078Game20160929043049MESZ() {
        final String source = "Fin LudArO$Ili$La SkribIlO TrovAs Su Ni$La HeroIcxO , TrovAs Fin Vi$La FlorO Su Ni$La HeroInO , Al Vi$La HeroIcxO Fin Ni$La FlorO DonAs Vi$La HeroInO .";
        Assert.assertEquals("{ Fin ( LudArO$Ili$La SkribIlO ) Dom ( TrovAs ) Su ( Ni$La HeroIcxO ) } , { Dom ( TrovAs ) Fin ( Vi$La FlorO ) Su ( Ni$La HeroInO ) } , { Al ( Vi$La HeroIcxO ) Fin ( Ni$La FlorO ) Dom ( DonAs ) Su ( Vi$La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ihren Stift findet unser Held, eure Blume findet unsere Heldin, unsere Blume gibt eure Heldin eurem Helden.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Our hero finds their pen, our heroine finds your flower, your heroine gives your hero our flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ilian skribilon trovas nia heroo, trovas vian floron nia heroino, al via heroo nian floron donas via heroino.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Nuestro héroe encuentra su lapicero, nuestra heroína encuentra vuestra flor, vuestra heroína da a vuestro héroe nuestra flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Notre héros trouve leur crayon, notre héroïne trouve votre fleur, votre héroïne donne à votre héros notre fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation079Game20160929043049MESZ() {
        final String source = "Fin La SkribIlO TrovAs Su HeroIcxO , TrovAs Fin FlorO Su Ni$La HeroInO , Al HeroIcxO Fin Mi$La FlorO DonAs Bi$La HeroInO .";
        Assert.assertEquals("{ Fin ( La SkribIlO ) Dom ( TrovAs ) Su ( HeroIcxO ) } , { Dom ( TrovAs ) Fin ( FlorO ) Su ( Ni$La HeroInO ) } , { Al ( HeroIcxO ) Fin ( Mi$La FlorO ) Dom ( DonAs ) Su ( Bi$La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Den Stift findet ein Held, eine Blume findet unsere Heldin, meine Blume gibt deine Heldin einem Helden.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero finds the pen, our heroine finds a flower, your heroine gives a hero my flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La skribilon trovas heroo, trovas floron nia heroino, al heroo mian floron donas via heroino.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe encuentra el lapicero, nuestra heroína encuentra una flor, tu heroína da a un héroe mi flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros trouve le crayon, notre héroïne trouve une fleur, t'héroïne donne à un héros ma fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation080Game20160929043049MESZ() {
        final String source = "HeroIcxO TrovAs Fin SkribIlO . HeroIcxO HavAs Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( TrovAs ) Fin ( SkribIlO ) } . { Su ( HeroIcxO ) Dom ( HavAs ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ein Held findet einen Stift. Ein Held hat einen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero finds a pen. A hero has a pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroo trovas skribilon. Heroo havas skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe encuentra un lapicero. Un héroe tiene un lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros trouve un crayon. Un héros a un crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation081Game20160929043049MESZ() {
        final String source = "La HeroIcxO TrovAs Fin La SkribIlO . La HeroIcxO HavAs Fin La SkribIlO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( TrovAs ) Fin ( La SkribIlO ) } . { Su ( La HeroIcxO ) Dom ( HavAs ) Fin ( La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Der Held findet den Stift. Der Held hat den Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero finds the pen. The hero has the pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroo trovas la skribilon. La heroo havas la skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe encuentra el lapicero. El héroe tiene el lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros trouve le crayon. L'héros a le crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation082Game20160929043049MESZ() {
        final String source = "SkribIlO$Gxi$La HeroIcxO TrovAs Fin Bi$La SkribIlO . Mi$La HeroIcxO HavAs Fin Bi$La SkribIlO .";
        Assert.assertEquals("{ Su ( SkribIlO$Gxi$La HeroIcxO ) Dom ( TrovAs ) Fin ( Bi$La SkribIlO ) } . { Su ( Mi$La HeroIcxO ) Dom ( HavAs ) Fin ( Bi$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Sein Held findet deinen Stift. Mein Held hat deinen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Its hero finds your pen. My hero has your pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ĝia heroo trovas vian skribilon. Mia heroo havas vian skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Su héroe encuentra tu lapicero. Mi héroe tiene tu lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Son héros trouve ton crayon. Mon héros a ton crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation083Game20160929043049MESZ() {
        final String source = "SkribIlArO$Ili$La HeroIcxO TrovAs Fin Vi$La SkribIlO . Ni$La HeroIcxO HavAs Fin Vi$La SkribIlO .";
        Assert.assertEquals("{ Su ( SkribIlArO$Ili$La HeroIcxO ) Dom ( TrovAs ) Fin ( Vi$La SkribIlO ) } . { Su ( Ni$La HeroIcxO ) Dom ( HavAs ) Fin ( Vi$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ihr Held findet euren Stift. Unser Held hat euren Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Their hero finds your pen. Our hero has your pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ilia heroo trovas vian skribilon. Nia heroo havas vian skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Su héroe encuentra vuestro lapicero. Nuestro héroe tiene vuestro lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Leur héros trouve votre crayon. Notre héros a votre crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation084Game20160929043049MESZ() {
        final String source = "La HeroIcxO TrovAs Fin SkribIlO . HeroIcxO HavAs Fin Ili$La SkribIlO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( TrovAs ) Fin ( SkribIlO ) } . { Su ( HeroIcxO ) Dom ( HavAs ) Fin ( Ili$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Der Held findet einen Stift. Ein Held hat ihren Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero finds a pen. A hero has their pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroo trovas skribilon. Heroo havas ilian skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe encuentra un lapicero. Un héroe tiene su lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros trouve un crayon. Un héros a leur crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation085Game20160929043049MESZ() {
        final String source = "Se HeroIcxO TrovAs Fin FlorO , HeroIcxO DonAs Fin FlorO Al HeroInO .";
        Assert.assertEquals("Se { Su ( HeroIcxO ) Dom ( TrovAs ) Fin ( FlorO ) } , { Su ( HeroIcxO ) Dom ( DonAs ) Fin ( FlorO ) Al ( HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Wenn ein Held eine Blume findet, gibt ein Held einer Heldin eine Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("If a hero finds a flower, a hero gives a heroine a flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Se heroo trovas floron, heroo donas floron al heroino.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Si un héroe encuentra una flor, un héroe da a una heroína una flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Si un héros trouve une fleur, un héros donne à une héroïne une fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation086Game20160929043049MESZ() {
        final String source = "Se La HeroIcxO TrovAs Fin La FlorO , La HeroIcxO DonAs Fin La FlorO Al La HeroInO .";
        Assert.assertEquals("Se { Su ( La HeroIcxO ) Dom ( TrovAs ) Fin ( La FlorO ) } , { Su ( La HeroIcxO ) Dom ( DonAs ) Fin ( La FlorO ) Al ( La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Wenn der Held die Blume findet, gibt der Held der Heldin die Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("If the hero finds the flower, the hero gives the heroine the flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Se la heroo trovas la floron, la heroo donas la floron al la heroino.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Si el héroe encuentra la flor, el héroe da a la heroína la flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Si l'héros trouve la fleur, l'héros donne à l'héroïne la fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation087Game20160929043049MESZ() {
        final String source = "Se Mi$La HeroIcxO TrovAs Fin Gxi$La FlorO , Mi$La HeroIcxO DonAs Fin Gxi$La FlorO Al Bi$La HeroInO .";
        Assert.assertEquals("Se { Su ( Mi$La HeroIcxO ) Dom ( TrovAs ) Fin ( Gxi$La FlorO ) } , { Su ( Mi$La HeroIcxO ) Dom ( DonAs ) Fin ( Gxi$La FlorO ) Al ( Bi$La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Wenn mein Held seine Blume findet, gibt mein Held deiner Heldin seine Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("If my hero finds its flower, my hero gives your heroine its flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Se mia heroo trovas ĝian floron, mia heroo donas ĝian floron al via heroino.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Si mi héroe encuentra su flor, mi héroe da a tu heroína su flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Si mon héros trouve sa fleur, mon héros donne à t'héroïne sa fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation088Game20160929043049MESZ() {
        final String source = "Se Ni$La HeroIcxO TrovAs Fin Ili$La FlorO , Ni$La HeroIcxO DonAs Fin Ili$La FlorO Al Vi$La HeroInO .";
        Assert.assertEquals("Se { Su ( Ni$La HeroIcxO ) Dom ( TrovAs ) Fin ( Ili$La FlorO ) } , { Su ( Ni$La HeroIcxO ) Dom ( DonAs ) Fin ( Ili$La FlorO ) Al ( Vi$La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Wenn unser Held ihre Blume findet, gibt unser Held euerer Heldin ihre Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("If our hero finds their flower, our hero gives your heroine their flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Se nia heroo trovas ilian floron, nia heroo donas ilian floron al via heroino.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Si nuestro héroe encuentra su flor, nuestro héroe da a vuestra heroína su flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Si notre héros trouve leur fleur, notre héros donne à votre héroïne leur fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation089Game20160929043049MESZ() {
        final String source = "Se Mi$La HeroIcxO TrovAs Fin La FlorO , HeroIcxO DonAs Fin FlorO Al HeroInO .";
        Assert.assertEquals("Se { Su ( Mi$La HeroIcxO ) Dom ( TrovAs ) Fin ( La FlorO ) } , { Su ( HeroIcxO ) Dom ( DonAs ) Fin ( FlorO ) Al ( HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Wenn mein Held die Blume findet, gibt ein Held einer Heldin eine Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("If my hero finds the flower, a hero gives a heroine a flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Se mia heroo trovas la floron, heroo donas floron al heroino.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Si mi héroe encuentra la flor, un héroe da a una heroína una flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Si mon héros trouve la fleur, un héros donne à une héroïne une fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation090Game20160929043049MESZ() {
        final String source = "HeroIcxO DonAs Fin FlorO Al HeroInO Se HeroIcxO TrovAs Fin FlorO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( DonAs ) Fin ( FlorO ) Al ( HeroInO ) } Se { Su ( HeroIcxO ) Dom ( TrovAs ) Fin ( FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ein Held gibt einer Heldin eine Blume, wenn ein Held eine Blume findet.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero gives a heroine a flower, if a hero finds a flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroo donas floron al heroino, se heroo trovas floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe da a una heroína una flor si un héroe encuentra una flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros donne à une héroïne une fleur, si un héros trouve une fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation091Game20160929043049MESZ() {
        final String source = "La HeroIcxO DonAs Fin La FlorO Al La HeroInO Se La HeroIcxO TrovAs Fin La FlorO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( DonAs ) Fin ( La FlorO ) Al ( La HeroInO ) } Se { Su ( La HeroIcxO ) Dom ( TrovAs ) Fin ( La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Der Held gibt der Heldin die Blume, wenn der Held die Blume findet.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero gives the heroine the flower, if the hero finds the flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroo donas la floron al la heroino, se la heroo trovas la floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe da a la heroína la flor si el héroe encuentra la flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros donne à l'héroïne la fleur, si l'héros trouve la fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation092Game20160929043049MESZ() {
        final String source = "Bi$La HeroIcxO DonAs Fin Gxi$La FlorO Al Mi$La HeroInO Se Bi$La HeroIcxO TrovAs Fin Gxi$La FlorO .";
        Assert.assertEquals("{ Su ( Bi$La HeroIcxO ) Dom ( DonAs ) Fin ( Gxi$La FlorO ) Al ( Mi$La HeroInO ) } Se { Su ( Bi$La HeroIcxO ) Dom ( TrovAs ) Fin ( Gxi$La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Dein Held gibt meiner Heldin seine Blume, wenn dein Held seine Blume findet.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Your hero gives my heroine its flower, if your hero finds its flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Via heroo donas ĝian floron al mia heroino, se via heroo trovas ĝian floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Tu héroe da a mi heroína su flor si tu héroe encuentra su flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ton héros donne à m'héroïne sa fleur, si ton héros trouve sa fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation093Game20160929043049MESZ() {
        final String source = "Vi$La HeroIcxO DonAs Fin Ili$La FlorO Al Ni$La HeroInO Se Vi$La HeroIcxO TrovAs Fin Ili$La FlorO .";
        Assert.assertEquals("{ Su ( Vi$La HeroIcxO ) Dom ( DonAs ) Fin ( Ili$La FlorO ) Al ( Ni$La HeroInO ) } Se { Su ( Vi$La HeroIcxO ) Dom ( TrovAs ) Fin ( Ili$La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Euer Held gibt unserer Heldin ihre Blume, wenn euer Held ihre Blume findet.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Your hero gives our heroine their flower, if your hero finds their flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Via heroo donas ilian floron al nia heroino, se via heroo trovas ilian floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Vuestro héroe da a nuestra heroína su flor si vuestro héroe encuentra su flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Votre héros donne à notre héroïne leur fleur, si votre héros trouve leur fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation094Game20160929043049MESZ() {
        final String source = "Vi$La HeroIcxO DonAs Fin FlorO Al Mi$La HeroInO Se La HeroIcxO TrovAs Fin FlorO .";
        Assert.assertEquals("{ Su ( Vi$La HeroIcxO ) Dom ( DonAs ) Fin ( FlorO ) Al ( Mi$La HeroInO ) } Se { Su ( La HeroIcxO ) Dom ( TrovAs ) Fin ( FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Euer Held gibt meiner Heldin eine Blume, wenn der Held eine Blume findet.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Your hero gives my heroine a flower, if the hero finds a flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Via heroo donas floron al mia heroino, se la heroo trovas floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Vuestro héroe da a mi heroína una flor si el héroe encuentra una flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Votre héros donne à m'héroïne une fleur, si l'héros trouve une fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }
}

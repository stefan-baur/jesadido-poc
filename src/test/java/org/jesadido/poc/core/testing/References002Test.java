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

public class References002Test {
    
    @Test
    public void testVerticalTranslation000Game20160928030543MESZ() {
        final String source = "HeroIcxO TrovAs Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( TrovAs ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ein Held findet einen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero finds a pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroo trovas skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe encuentra un lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros trouve un crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation001Game20160928030543MESZ() {
        final String source = "HeroIcxO TrovAs Fin FlorO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( TrovAs ) Fin ( FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ein Held findet eine Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero finds a flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroo trovas floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe encuentra una flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros trouve une fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation002Game20160928030543MESZ() {
        final String source = "HeroInO TrovAs Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroInO ) Dom ( TrovAs ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Eine Heldin findet einen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A heroine finds a pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroino trovas skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Una heroína encuentra un lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Une héroïne trouve un crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation003Game20160928030543MESZ() {
        final String source = "Kaj HeroInO TrovAs Fin FlorO .";
        Assert.assertEquals("Kaj { Su ( HeroInO ) Dom ( TrovAs ) Fin ( FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Und eine Heldin findet eine Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("And a heroine finds a flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Kaj heroino trovas floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Y una heroína encuentra una flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Et une héroïne trouve une fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation004Game20160928030543MESZ() {
        final String source = "HeroIcxO HavAs Fin NomO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( HavAs ) Fin ( NomO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ein Held hat einen Namen.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero has a name.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroo havas nomon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe tiene un nombre.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros a un nom.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation005Game20160928030543MESZ() {
        final String source = "HeroIcxO DonAs Al HeroInO Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( DonAs ) Al ( HeroInO ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ein Held gibt einer Heldin einen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero gives a heroine a pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroo donas al heroino skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe da a una heroína un lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros donne à une héroïne un crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation006Game20160928030543MESZ() {
        final String source = "HeroIcxO DonAs Al HeroInO Fin FlorO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( DonAs ) Al ( HeroInO ) Fin ( FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ein Held gibt einer Heldin eine Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero gives a heroine a flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroo donas al heroino floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe da a una heroína una flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros donne à une héroïne une fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation007Game20160928030543MESZ() {
        final String source = "HeroInO DonAs Al HeroIcxO Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroInO ) Dom ( DonAs ) Al ( HeroIcxO ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Eine Heldin gibt einem Helden einen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A heroine gives a hero a pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroino donas al heroo skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Una heroína da a un héroe un lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Une héroïne donne à un héros un crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation008Game20160928030543MESZ() {
        final String source = "Kaj HeroInO DonAs Al HeroIcxO Fin FlorO .";
        Assert.assertEquals("Kaj { Su ( HeroInO ) Dom ( DonAs ) Al ( HeroIcxO ) Fin ( FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Und eine Heldin gibt einem Helden eine Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("And a heroine gives a hero a flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Kaj heroino donas al heroo floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Y una heroína da a un héroe una flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Et une héroïne donne à un héros une fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation009Game20160928030543MESZ() {
        final String source = "HeroIcxO TrovAs Fin FlorO Kaj HeroInO TrovAs Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( TrovAs ) Fin ( FlorO ) } Kaj { Su ( HeroInO ) Dom ( TrovAs ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ein Held findet eine Blume, und eine Heldin findet einen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero finds a flower, and a heroine finds a pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroo trovas floron, kaj heroino trovas skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe encuentra una flor, y una heroína encuentra un lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros trouve une fleur et une héroïne trouve un crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation010Game20160928030543MESZ() {
        final String source = "HeroIcxO DonAs Al HeroInO Fin FlorO Kaj HeroInO DonAs Al HeroIcxO Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( DonAs ) Al ( HeroInO ) Fin ( FlorO ) } Kaj { Su ( HeroInO ) Dom ( DonAs ) Al ( HeroIcxO ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ein Held gibt einer Heldin eine Blume, und eine Heldin gibt einem Helden einen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero gives a heroine a flower, and a heroine gives a hero a pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroo donas al heroino floron, kaj heroino donas al heroo skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe da a una heroína una flor, y una heroína da a un héroe un lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros donne à une héroïne une fleur et une héroïne donne à un héros un crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation011Game20160928030544MESZ() {
        final String source = "HeroIcxO DonAs Al HeroInO Fin FlorO Aux HeroInO DonAs Al HeroIcxO Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( DonAs ) Al ( HeroInO ) Fin ( FlorO ) } Aux { Su ( HeroInO ) Dom ( DonAs ) Al ( HeroIcxO ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ein Held gibt einer Heldin eine Blume, oder eine Heldin gibt einem Helden einen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero gives a heroine a flower, or a heroine gives a hero a pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroo donas al heroino floron, aŭ heroino donas al heroo skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe da a una heroína una flor, o una heroína da a un héroe un lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros donne à une héroïne une fleur ou une héroïne donne à un héros un crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation012Game20160928030544MESZ() {
        final String source = "Fin SkribIlO Su HeroIcxO TrovAs . Fin NomO Al HeroIcxO DonAs HeroInO .";
        Assert.assertEquals("{ Fin ( SkribIlO ) Su ( HeroIcxO ) Dom ( TrovAs ) } . { Fin ( NomO ) Al ( HeroIcxO ) Dom ( DonAs ) Su ( HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Einen Stift findet ein Held. Einen Namen gibt eine Heldin einem Helden.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero finds a pen. A heroine gives a hero a name.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Skribilon heroo trovas. Nomon al heroo donas heroino.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe encuentra un lapicero. Una heroína da a un héroe un nombre.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros trouve un crayon. Une héroïne donne à un héros un nom.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation013Game20160928030544MESZ() {
        final String source = "Fin SkribIlO TrovAs Su HeroIcxO Kaj TrovAs Fin FlorO Su HeroInO Kaj Al HeroIcxO Fin FlorO DonAs HeroInO .";
        Assert.assertEquals("{ Fin ( SkribIlO ) Dom ( TrovAs ) Su ( HeroIcxO ) } Kaj { Dom ( TrovAs ) Fin ( FlorO ) Su ( HeroInO ) } Kaj { Al ( HeroIcxO ) Fin ( FlorO ) Dom ( DonAs ) Su ( HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Einen Stift findet ein Held, und eine Blume findet eine Heldin, und eine Blume gibt eine Heldin einem Helden.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero finds a pen, and a heroine finds a flower, and a heroine gives a hero a flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Skribilon trovas heroo, kaj trovas floron heroino, kaj al heroo floron donas heroino.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe encuentra un lapicero, y una heroína encuentra una flor, y una heroína da a un héroe una flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros trouve un crayon et une héroïne trouve une fleur et une héroïne donne à un héros une fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation014Game20160928030544MESZ() {
        final String source = "Fin SkribIlO TrovAs Su HeroIcxO , TrovAs Fin FlorO Su HeroInO , Al HeroIcxO Fin FlorO DonAs HeroInO .";
        Assert.assertEquals("{ Fin ( SkribIlO ) Dom ( TrovAs ) Su ( HeroIcxO ) } , { Dom ( TrovAs ) Fin ( FlorO ) Su ( HeroInO ) } , { Al ( HeroIcxO ) Fin ( FlorO ) Dom ( DonAs ) Su ( HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Einen Stift findet ein Held, eine Blume findet eine Heldin, eine Blume gibt eine Heldin einem Helden.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero finds a pen, a heroine finds a flower, a heroine gives a hero a flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Skribilon trovas heroo, trovas floron heroino, al heroo floron donas heroino.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe encuentra un lapicero, una heroína encuentra una flor, una heroína da a un héroe una flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros trouve un crayon, une héroïne trouve une fleur, une héroïne donne à un héros une fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation015Game20160928030544MESZ() {
        final String source = "HeroIcxO TrovAs Fin SkribIlO . HeroIcxO HavAs Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( TrovAs ) Fin ( SkribIlO ) } . { Su ( HeroIcxO ) Dom ( HavAs ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ein Held findet einen Stift. Ein Held hat einen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero finds a pen. A hero has a pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroo trovas skribilon. Heroo havas skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe encuentra un lapicero. Un héroe tiene un lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros trouve un crayon. Un héros a un crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation016Game20160928030544MESZ() {
        final String source = "Se HeroIcxO TrovAs Fin FlorO , HeroIcxO DonAs Fin FlorO Al HeroInO .";
        Assert.assertEquals("Se { Su ( HeroIcxO ) Dom ( TrovAs ) Fin ( FlorO ) } , { Su ( HeroIcxO ) Dom ( DonAs ) Fin ( FlorO ) Al ( HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Wenn ein Held eine Blume findet, gibt ein Held einer Heldin eine Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("If a hero finds a flower, a hero gives a heroine a flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Se heroo trovas floron, heroo donas floron al heroino.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Si un héroe encuentra una flor, un héroe da a una heroína una flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Si un héros trouve une fleur, un héros donne à une héroïne une fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation017Game20160928030544MESZ() {
        final String source = "HeroIcxO DonAs Fin FlorO Al HeroInO Se HeroIcxO TrovAs Fin FlorO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( DonAs ) Fin ( FlorO ) Al ( HeroInO ) } Se { Su ( HeroIcxO ) Dom ( TrovAs ) Fin ( FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ein Held gibt einer Heldin eine Blume, wenn ein Held eine Blume findet.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero gives a heroine a flower, if a hero finds a flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroo donas floron al heroino, se heroo trovas floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe da a una heroína una flor si un héroe encuentra una flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros donne à une héroïne une fleur, si un héros trouve une fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation018Game20160928030544MESZ() {
        final String source = "La HeroIcxO TrovAs Fin La SkribIlO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( TrovAs ) Fin ( La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Der Held findet den Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero finds the pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroo trovas la skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe encuentra el lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros trouve le crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation019Game20160928030544MESZ() {
        final String source = "La HeroIcxO TrovAs Fin La FlorO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( TrovAs ) Fin ( La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Der Held findet die Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero finds the flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroo trovas la floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe encuentra la flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros trouve la fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation020Game20160928030544MESZ() {
        final String source = "La HeroInO TrovAs Fin La SkribIlO .";
        Assert.assertEquals("{ Su ( La HeroInO ) Dom ( TrovAs ) Fin ( La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Die Heldin findet den Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The heroine finds the pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroino trovas la skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroína encuentra el lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héroïne trouve le crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation021Game20160928030544MESZ() {
        final String source = "Kaj La HeroInO TrovAs Fin La FlorO .";
        Assert.assertEquals("Kaj { Su ( La HeroInO ) Dom ( TrovAs ) Fin ( La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Und die Heldin findet die Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("And the heroine finds the flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Kaj la heroino trovas la floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Y la heroína encuentra la flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Et l'héroïne trouve la fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation022Game20160928030544MESZ() {
        final String source = "La HeroIcxO HavAs Fin La NomO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( HavAs ) Fin ( La NomO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Der Held hat den Namen.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero has the name.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroo havas la nomon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe tiene el nombre.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros a le nom.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation023Game20160928030544MESZ() {
        final String source = "La HeroIcxO DonAs Al La HeroInO Fin La SkribIlO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( DonAs ) Al ( La HeroInO ) Fin ( La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Der Held gibt der Heldin den Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero gives the heroine the pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroo donas al la heroino la skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe da a la heroína el lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros donne à l'héroïne le crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation024Game20160928030544MESZ() {
        final String source = "La HeroIcxO DonAs Al La HeroInO Fin La FlorO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( DonAs ) Al ( La HeroInO ) Fin ( La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Der Held gibt der Heldin die Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero gives the heroine the flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroo donas al la heroino la floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe da a la heroína la flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros donne à l'héroïne la fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation025Game20160928030544MESZ() {
        final String source = "La HeroInO DonAs Al La HeroIcxO Fin La SkribIlO .";
        Assert.assertEquals("{ Su ( La HeroInO ) Dom ( DonAs ) Al ( La HeroIcxO ) Fin ( La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Die Heldin gibt dem Helden den Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The heroine gives the hero the pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroino donas al la heroo la skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroína da al héroe el lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héroïne donne à l'héros le crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation026Game20160928030544MESZ() {
        final String source = "Kaj La HeroInO DonAs Al La HeroIcxO Fin La FlorO .";
        Assert.assertEquals("Kaj { Su ( La HeroInO ) Dom ( DonAs ) Al ( La HeroIcxO ) Fin ( La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Und die Heldin gibt dem Helden die Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("And the heroine gives the hero the flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Kaj la heroino donas al la heroo la floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Y la heroína da al héroe la flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Et l'héroïne donne à l'héros la fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation027Game20160928030544MESZ() {
        final String source = "La HeroIcxO TrovAs Fin La FlorO Kaj La HeroInO TrovAs Fin La SkribIlO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( TrovAs ) Fin ( La FlorO ) } Kaj { Su ( La HeroInO ) Dom ( TrovAs ) Fin ( La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Der Held findet die Blume, und die Heldin findet den Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero finds the flower, and the heroine finds the pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroo trovas la floron, kaj la heroino trovas la skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe encuentra la flor, y la heroína encuentra el lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros trouve la fleur et l'héroïne trouve le crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation028Game20160928030544MESZ() {
        final String source = "La HeroIcxO DonAs Al La HeroInO Fin La FlorO Kaj La HeroInO DonAs Al La HeroIcxO Fin La SkribIlO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( DonAs ) Al ( La HeroInO ) Fin ( La FlorO ) } Kaj { Su ( La HeroInO ) Dom ( DonAs ) Al ( La HeroIcxO ) Fin ( La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Der Held gibt der Heldin die Blume, und die Heldin gibt dem Helden den Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero gives the heroine the flower, and the heroine gives the hero the pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroo donas al la heroino la floron, kaj la heroino donas al la heroo la skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe da a la heroína la flor, y la heroína da al héroe el lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros donne à l'héroïne la fleur et l'héroïne donne à l'héros le crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation029Game20160928030544MESZ() {
        final String source = "La HeroIcxO DonAs Al La HeroInO Fin La FlorO Aux La HeroInO DonAs Al La HeroIcxO Fin La SkribIlO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( DonAs ) Al ( La HeroInO ) Fin ( La FlorO ) } Aux { Su ( La HeroInO ) Dom ( DonAs ) Al ( La HeroIcxO ) Fin ( La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Der Held gibt der Heldin die Blume, oder die Heldin gibt dem Helden den Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero gives the heroine the flower, or the heroine gives the hero the pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroo donas al la heroino la floron, aŭ la heroino donas al la heroo la skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe da a la heroína la flor, o la heroína da al héroe el lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros donne à l'héroïne la fleur ou l'héroïne donne à l'héros le crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation030Game20160928030544MESZ() {
        final String source = "Fin La SkribIlO Su La HeroIcxO TrovAs . Fin La NomO Al La HeroIcxO DonAs La HeroInO .";
        Assert.assertEquals("{ Fin ( La SkribIlO ) Su ( La HeroIcxO ) Dom ( TrovAs ) } . { Fin ( La NomO ) Al ( La HeroIcxO ) Dom ( DonAs ) Su ( La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Den Stift findet der Held. Den Namen gibt die Heldin dem Helden.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero finds the pen. The heroine gives the hero the name.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La skribilon la heroo trovas. La nomon al la heroo donas la heroino.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe encuentra el lapicero. La heroína da al héroe el nombre.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros trouve le crayon. L'héroïne donne à l'héros le nom.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation031Game20160928030544MESZ() {
        final String source = "Fin La SkribIlO TrovAs Su La HeroIcxO Kaj TrovAs Fin La FlorO Su La HeroInO Kaj Al La HeroIcxO Fin La FlorO DonAs La HeroInO .";
        Assert.assertEquals("{ Fin ( La SkribIlO ) Dom ( TrovAs ) Su ( La HeroIcxO ) } Kaj { Dom ( TrovAs ) Fin ( La FlorO ) Su ( La HeroInO ) } Kaj { Al ( La HeroIcxO ) Fin ( La FlorO ) Dom ( DonAs ) Su ( La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Den Stift findet der Held, und die Blume findet die Heldin, und die Blume gibt die Heldin dem Helden.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero finds the pen, and the heroine finds the flower, and the heroine gives the hero the flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La skribilon trovas la heroo, kaj trovas la floron la heroino, kaj al la heroo la floron donas la heroino.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe encuentra el lapicero, y la heroína encuentra la flor, y la heroína da al héroe la flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros trouve le crayon et l'héroïne trouve la fleur et l'héroïne donne à l'héros la fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation032Game20160928030544MESZ() {
        final String source = "Fin La SkribIlO TrovAs Su La HeroIcxO , TrovAs Fin La FlorO Su La HeroInO , Al La HeroIcxO Fin La FlorO DonAs La HeroInO .";
        Assert.assertEquals("{ Fin ( La SkribIlO ) Dom ( TrovAs ) Su ( La HeroIcxO ) } , { Dom ( TrovAs ) Fin ( La FlorO ) Su ( La HeroInO ) } , { Al ( La HeroIcxO ) Fin ( La FlorO ) Dom ( DonAs ) Su ( La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Den Stift findet der Held, die Blume findet die Heldin, die Blume gibt die Heldin dem Helden.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero finds the pen, the heroine finds the flower, the heroine gives the hero the flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La skribilon trovas la heroo, trovas la floron la heroino, al la heroo la floron donas la heroino.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe encuentra el lapicero, la heroína encuentra la flor, la heroína da al héroe la flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros trouve le crayon, l'héroïne trouve la fleur, l'héroïne donne à l'héros la fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation033Game20160928030544MESZ() {
        final String source = "La HeroIcxO TrovAs Fin La SkribIlO . La HeroIcxO HavAs Fin La SkribIlO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( TrovAs ) Fin ( La SkribIlO ) } . { Su ( La HeroIcxO ) Dom ( HavAs ) Fin ( La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Der Held findet den Stift. Der Held hat den Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero finds the pen. The hero has the pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroo trovas la skribilon. La heroo havas la skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe encuentra el lapicero. El héroe tiene el lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros trouve le crayon. L'héros a le crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation034Game20160928030544MESZ() {
        final String source = "Se La HeroIcxO TrovAs Fin La FlorO , La HeroIcxO DonAs Fin La FlorO Al La HeroInO .";
        Assert.assertEquals("Se { Su ( La HeroIcxO ) Dom ( TrovAs ) Fin ( La FlorO ) } , { Su ( La HeroIcxO ) Dom ( DonAs ) Fin ( La FlorO ) Al ( La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Wenn der Held die Blume findet, gibt der Held der Heldin die Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("If the hero finds the flower, the hero gives the heroine the flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Se la heroo trovas la floron, la heroo donas la floron al la heroino.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Si el héroe encuentra la flor, el héroe da a la heroína la flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Si l'héros trouve la fleur, l'héros donne à l'héroïne la fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation035Game20160928030544MESZ() {
        final String source = "La HeroIcxO DonAs Fin La FlorO Al La HeroInO Se La HeroIcxO TrovAs Fin La FlorO .";
        Assert.assertEquals("{ Su ( La HeroIcxO ) Dom ( DonAs ) Fin ( La FlorO ) Al ( La HeroInO ) } Se { Su ( La HeroIcxO ) Dom ( TrovAs ) Fin ( La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Der Held gibt der Heldin die Blume, wenn der Held die Blume findet.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero gives the heroine the flower, if the hero finds the flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroo donas la floron al la heroino, se la heroo trovas la floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe da a la heroína la flor si el héroe encuentra la flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros donne à l'héroïne la fleur, si l'héros trouve la fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation036Game20160928030544MESZ() {
        final String source = "Mi$La HeroIcxO TrovAs Fin Bi$La SkribIlO .";
        Assert.assertEquals("{ Su ( Mi$La HeroIcxO ) Dom ( TrovAs ) Fin ( Bi$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Mein Held findet deinen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero finds the pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroo trovas la skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe encuentra el lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros trouve le crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation037Game20160928030544MESZ() {
        final String source = "Bi$La HeroIcxO TrovAs Fin Mi$La FlorO .";
        Assert.assertEquals("{ Su ( Bi$La HeroIcxO ) Dom ( TrovAs ) Fin ( Mi$La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Dein Held findet meine Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero finds the flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroo trovas la floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe encuentra la flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros trouve la fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation038Game20160928030544MESZ() {
        final String source = "IcxO$Gxi$La HeroInO TrovAs Fin LudO$Gxi$La SkribIlO .";
        Assert.assertEquals("{ Su ( IcxO$Gxi$La HeroInO ) Dom ( TrovAs ) Fin ( LudO$Gxi$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Seine Heldin findet seinen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The heroine finds the pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroino trovas la skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroína encuentra el lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héroïne trouve le crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation039Game20160928030544MESZ() {
        final String source = "Kaj InO$Gxi$La HeroInO TrovAs Fin InO$Bi$La FlorO .";
        Assert.assertEquals("Kaj { Su ( InO$Gxi$La HeroInO ) Dom ( TrovAs ) Fin ( InO$Bi$La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Und ihre Heldin findet deine Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("And the heroine finds the flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Kaj la heroino trovas la floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Y la heroína encuentra la flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Et l'héroïne trouve la fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation040Game20160928030544MESZ() {
        final String source = "IcxO$Mi$La HeroIcxO HavAs Fin HeroInO$Gxi$La NomO .";
        Assert.assertEquals("{ Su ( IcxO$Mi$La HeroIcxO ) Dom ( HavAs ) Fin ( HeroInO$Gxi$La NomO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Mein Held hat ihren Namen.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero has the name.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroo havas la nomon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe tiene el nombre.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros a le nom.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation041Game20160928030544MESZ() {
        final String source = "InO$Bi$La HeroIcxO DonAs Al HeroIcxO$Mi$La HeroInO Fin LudO$Gxi$La SkribIlO .";
        Assert.assertEquals("{ Su ( InO$Bi$La HeroIcxO ) Dom ( DonAs ) Al ( HeroIcxO$Mi$La HeroInO ) Fin ( LudO$Gxi$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Dein Held gibt meiner Heldin seinen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero gives the heroine the pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroo donas al la heroino la skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe da a la heroína el lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros donne à l'héroïne le crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation042Game20160928030544MESZ() {
        final String source = "IcxO$Gxi$La HeroIcxO DonAs Al Bi$La HeroInO Fin Mi$La FlorO .";
        Assert.assertEquals("{ Su ( IcxO$Gxi$La HeroIcxO ) Dom ( DonAs ) Al ( Bi$La HeroInO ) Fin ( Mi$La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Sein Held gibt deiner Heldin meine Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero gives the heroine the flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroo donas al la heroino la floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe da a la heroína la flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros donne à l'héroïne la fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation043Game20160928030544MESZ() {
        final String source = "InO$Gxi$La HeroInO DonAs Al Mi$La HeroIcxO Fin Bi$La SkribIlO .";
        Assert.assertEquals("{ Su ( InO$Gxi$La HeroInO ) Dom ( DonAs ) Al ( Mi$La HeroIcxO ) Fin ( Bi$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ihre Heldin gibt meinem Helden deinen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The heroine gives the hero the pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroino donas al la heroo la skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroína da al héroe el lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héroïne donne à l'héros le crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation044Game20160928030544MESZ() {
        final String source = "Kaj Gxi$La HeroInO DonAs Al Bi$La HeroIcxO Fin HeroInO$Gxi$La FlorO .";
        Assert.assertEquals("Kaj { Su ( Gxi$La HeroInO ) Dom ( DonAs ) Al ( Bi$La HeroIcxO ) Fin ( HeroInO$Gxi$La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Und seine Heldin gibt deinem Helden ihre Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("And the heroine gives the hero the flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Kaj la heroino donas al la heroo la floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Y la heroína da al héroe la flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Et l'héroïne donne à l'héros la fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation045Game20160928030544MESZ() {
        final String source = "Mi$La HeroIcxO TrovAs Fin Bi$La FlorO Kaj Bi$La HeroInO TrovAs Fin Mi$La SkribIlO .";
        Assert.assertEquals("{ Su ( Mi$La HeroIcxO ) Dom ( TrovAs ) Fin ( Bi$La FlorO ) } Kaj { Su ( Bi$La HeroInO ) Dom ( TrovAs ) Fin ( Mi$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Mein Held findet deine Blume, und deine Heldin findet meinen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero finds the flower, and the heroine finds the pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroo trovas la floron, kaj la heroino trovas la skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe encuentra la flor, y la heroína encuentra el lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros trouve la fleur et l'héroïne trouve le crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation046Game20160928030544MESZ() {
        final String source = "Bi$La HeroIcxO DonAs Al Mi$La HeroInO Fin LudO$Gxi$La FlorO Kaj Mi$La HeroInO DonAs Al InO$Bi$La HeroIcxO Fin HeroInO$Gxi$La SkribIlO .";
        Assert.assertEquals("{ Su ( Bi$La HeroIcxO ) Dom ( DonAs ) Al ( Mi$La HeroInO ) Fin ( LudO$Gxi$La FlorO ) } Kaj { Su ( Mi$La HeroInO ) Dom ( DonAs ) Al ( InO$Bi$La HeroIcxO ) Fin ( HeroInO$Gxi$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Dein Held gibt meiner Heldin seine Blume, und meine Heldin gibt deinem Helden ihren Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero gives the heroine the flower, and the heroine gives the hero the pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroo donas al la heroino la floron, kaj la heroino donas al la heroo la skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe da a la heroína la flor, y la heroína da al héroe el lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros donne à l'héroïne la fleur et l'héroïne donne à l'héros le crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation047Game20160928030544MESZ() {
        final String source = "LudO$Gxi$La HeroIcxO DonAs Al Mi$La HeroInO Fin Bi$La FlorO Aux Mi$La HeroInO DonAs Al Gxi$La HeroIcxO Fin Mi$La SkribIlO .";
        Assert.assertEquals("{ Su ( LudO$Gxi$La HeroIcxO ) Dom ( DonAs ) Al ( Mi$La HeroInO ) Fin ( Bi$La FlorO ) } Aux { Su ( Mi$La HeroInO ) Dom ( DonAs ) Al ( Gxi$La HeroIcxO ) Fin ( Mi$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Sein Held gibt meiner Heldin deine Blume, oder meine Heldin gibt seinem Helden meinen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero gives the heroine the flower, or the heroine gives the hero the pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroo donas al la heroino la floron, aŭ la heroino donas al la heroo la skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe da a la heroína la flor, o la heroína da al héroe el lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros donne à l'héroïne la fleur ou l'héroïne donne à l'héros le crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation048Game20160928030544MESZ() {
        final String source = "Fin Mi$La SkribIlO Su Bi$La HeroIcxO TrovAs . Fin Bi$La NomO Al Mi$La HeroIcxO DonAs Bi$La HeroInO .";
        Assert.assertEquals("{ Fin ( Mi$La SkribIlO ) Su ( Bi$La HeroIcxO ) Dom ( TrovAs ) } . { Fin ( Bi$La NomO ) Al ( Mi$La HeroIcxO ) Dom ( DonAs ) Su ( Bi$La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Meinen Stift findet dein Held. Deinen Namen gibt deine Heldin meinem Helden.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero finds the pen. The heroine gives the hero the name.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La skribilon la heroo trovas. La nomon al la heroo donas la heroino.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe encuentra el lapicero. La heroína da al héroe el nombre.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros trouve le crayon. L'héroïne donne à l'héros le nom.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation049Game20160928030544MESZ() {
        final String source = "Fin Bi$La SkribIlO TrovAs Su Mi$La HeroIcxO Kaj TrovAs Fin Bi$La FlorO Su Mi$La HeroInO Kaj Al Bi$La HeroIcxO Fin Mi$La FlorO DonAs Bi$La HeroInO .";
        Assert.assertEquals("{ Fin ( Bi$La SkribIlO ) Dom ( TrovAs ) Su ( Mi$La HeroIcxO ) } Kaj { Dom ( TrovAs ) Fin ( Bi$La FlorO ) Su ( Mi$La HeroInO ) } Kaj { Al ( Bi$La HeroIcxO ) Fin ( Mi$La FlorO ) Dom ( DonAs ) Su ( Bi$La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Deinen Stift findet mein Held, und deine Blume findet meine Heldin, und meine Blume gibt deine Heldin deinem Helden.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero finds the pen, and the heroine finds the flower, and the heroine gives the hero the flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La skribilon trovas la heroo, kaj trovas la floron la heroino, kaj al la heroo la floron donas la heroino.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe encuentra el lapicero, y la heroína encuentra la flor, y la heroína da al héroe la flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros trouve le crayon et l'héroïne trouve la fleur et l'héroïne donne à l'héros la fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation050Game20160928030544MESZ() {
        final String source = "Fin LudO$Gxi$La SkribIlO TrovAs Su Mi$La HeroIcxO , TrovAs Fin Bi$La FlorO Su Mi$La HeroInO , Al Bi$La HeroIcxO Fin Mi$La FlorO DonAs Bi$La HeroInO .";
        Assert.assertEquals("{ Fin ( LudO$Gxi$La SkribIlO ) Dom ( TrovAs ) Su ( Mi$La HeroIcxO ) } , { Dom ( TrovAs ) Fin ( Bi$La FlorO ) Su ( Mi$La HeroInO ) } , { Al ( Bi$La HeroIcxO ) Fin ( Mi$La FlorO ) Dom ( DonAs ) Su ( Bi$La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Seinen Stift findet mein Held, deine Blume findet meine Heldin, meine Blume gibt deine Heldin deinem Helden.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero finds the pen, the heroine finds the flower, the heroine gives the hero the flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La skribilon trovas la heroo, trovas la floron la heroino, al la heroo la floron donas la heroino.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe encuentra el lapicero, la heroína encuentra la flor, la heroína da al héroe la flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros trouve le crayon, l'héroïne trouve la fleur, l'héroïne donne à l'héros la fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation051Game20160928030544MESZ() {
        final String source = "SkribIlO$Gxi$La HeroIcxO TrovAs Fin Bi$La SkribIlO . Mi$La HeroIcxO HavAs Fin Bi$La SkribIlO .";
        Assert.assertEquals("{ Su ( SkribIlO$Gxi$La HeroIcxO ) Dom ( TrovAs ) Fin ( Bi$La SkribIlO ) } . { Su ( Mi$La HeroIcxO ) Dom ( HavAs ) Fin ( Bi$La SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Sein Held findet deinen Stift. Mein Held hat deinen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero finds the pen. The hero has the pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroo trovas la skribilon. La heroo havas la skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe encuentra el lapicero. El héroe tiene el lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros trouve le crayon. L'héros a le crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation052Game20160928030544MESZ() {
        final String source = "Se Mi$La HeroIcxO TrovAs Fin Gxi$La FlorO , Mi$La HeroIcxO DonAs Fin Gxi$La FlorO Al Bi$La HeroInO .";
        Assert.assertEquals("Se { Su ( Mi$La HeroIcxO ) Dom ( TrovAs ) Fin ( Gxi$La FlorO ) } , { Su ( Mi$La HeroIcxO ) Dom ( DonAs ) Fin ( Gxi$La FlorO ) Al ( Bi$La HeroInO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Wenn mein Held seine Blume findet, gibt mein Held deiner Heldin seine Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("If the hero finds the flower, the hero gives the heroine the flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Se la heroo trovas la floron, la heroo donas la floron al la heroino.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Si el héroe encuentra la flor, el héroe da a la heroína la flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Si l'héros trouve la fleur, l'héros donne à l'héroïne la fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation053Game20160928030544MESZ() {
        final String source = "Bi$La HeroIcxO DonAs Fin Gxi$La FlorO Al Mi$La HeroInO Se Bi$La HeroIcxO TrovAs Fin Gxi$La FlorO .";
        Assert.assertEquals("{ Su ( Bi$La HeroIcxO ) Dom ( DonAs ) Fin ( Gxi$La FlorO ) Al ( Mi$La HeroInO ) } Se { Su ( Bi$La HeroIcxO ) Dom ( TrovAs ) Fin ( Gxi$La FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Dein Held gibt meiner Heldin seine Blume, wenn dein Held seine Blume findet.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("The hero gives the heroine the flower, if the hero finds the flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("La heroo donas la floron al la heroino, se la heroo trovas la floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("El héroe da a la heroína la flor si el héroe encuentra la flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("L'héros donne à l'héroïne la fleur, si l'héros trouve la fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }
}

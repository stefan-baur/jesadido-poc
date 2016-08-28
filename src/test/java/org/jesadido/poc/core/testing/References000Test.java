/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.testing;

import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.semantics.TranslatorFactory;
import org.junit.Assert;
import org.junit.Test;

public class References000Test {
    
    @Test
    public void testVerticalTranslation000Game20160828120418MESZ() {
        final String source = "HeroIcxO TrovAs Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( TrovAs ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ein Held findet einen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero finds a pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroo trovas skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe encuentra un lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros trouve un crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation001Game20160828120419MESZ() {
        final String source = "HeroIcxO TrovAs Fin FlorO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( TrovAs ) Fin ( FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ein Held findet eine Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero finds a flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroo trovas floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe encuentra una flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros trouve une fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation002Game20160828120419MESZ() {
        final String source = "HeroInO TrovAs Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroInO ) Dom ( TrovAs ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Eine Heldin findet einen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A heroine finds a pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroino trovas skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Una heroína encuentra un lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Une héroïne trouve un crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation003Game20160828120419MESZ() {
        final String source = "Kaj HeroInO TrovAs Fin FlorO .";
        Assert.assertEquals("Kaj { Su ( HeroInO ) Dom ( TrovAs ) Fin ( FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Und eine Heldin findet eine Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("And a heroine finds a flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Kaj heroino trovas floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Y una heroína encuentra una flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Et une héroïne trouve une fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation004Game20160828120419MESZ() {
        final String source = "HeroIcxO DonAs Al HeroInO Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( DonAs ) Al ( HeroInO ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ein Held gibt einer Heldin einen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero gives a heroine a pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroo donas al heroino skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe da a una heroína un lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros donne à une héroïne un crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation005Game20160828120419MESZ() {
        final String source = "HeroIcxO DonAs Al HeroInO Fin FlorO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( DonAs ) Al ( HeroInO ) Fin ( FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ein Held gibt einer Heldin eine Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero gives a heroine a flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroo donas al heroino floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe da a una heroína una flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros donne à une héroïne une fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation006Game20160828120419MESZ() {
        final String source = "HeroInO DonAs Al HeroIcxO Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroInO ) Dom ( DonAs ) Al ( HeroIcxO ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Eine Heldin gibt einem Helden einen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A heroine gives a hero a pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroino donas al heroo skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Una heroína da a un héroe un lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Une héroïne donne à un héros un crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation007Game20160828120419MESZ() {
        final String source = "Kaj HeroInO DonAs Al HeroIcxO Fin FlorO .";
        Assert.assertEquals("Kaj { Su ( HeroInO ) Dom ( DonAs ) Al ( HeroIcxO ) Fin ( FlorO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Und eine Heldin gibt einem Helden eine Blume.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("And a heroine gives a hero a flower.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Kaj heroino donas al heroo floron.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Y una heroína da a un héroe una flor.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Et une héroïne donne à un héros une fleur.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation008Game20160828120419MESZ() {
        final String source = "HeroIcxO TrovAs Fin FlorO Kaj HeroInO TrovAs Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( TrovAs ) Fin ( FlorO ) } Kaj { Su ( HeroInO ) Dom ( TrovAs ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ein Held findet eine Blume, und eine Heldin findet einen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero finds a flower, and a heroine finds a pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroo trovas floron, kaj heroino trovas skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe encuentra una flor, y una heroína encuentra un lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros trouve une fleur et une héroïne trouve un crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }

    @Test
    public void testVerticalTranslation009Game20160828120419MESZ() {
        final String source = "HeroIcxO DonAs Al HeroInO Fin FlorO Kaj HeroInO DonAs Al HeroIcxO Fin SkribIlO .";
        Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( DonAs ) Al ( HeroInO ) Fin ( FlorO ) } Kaj { Su ( HeroInO ) Dom ( DonAs ) Al ( HeroIcxO ) Fin ( SkribIlO ) } .", TranslatorFactory.createTranslator(Language.JI, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Ein Held gibt einer Heldin eine Blume, und eine Heldin gibt einem Helden einen Stift.", TranslatorFactory.createTranslator(Language.DE, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("A hero gives a heroine a flower, and a heroine gives a hero a pen.", TranslatorFactory.createTranslator(Language.EN, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Heroo donas al heroino floron, kaj heroino donas al heroo skribilon.", TranslatorFactory.createTranslator(Language.EO, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héroe da a una heroína una flor, y una heroína da a un héroe un lapicero.", TranslatorFactory.createTranslator(Language.ES, References.GAME_BOOK).translate(source).getTranslation());
        Assert.assertEquals("Un héros donne à une héroïne une fleur et une héroïne donne à un héros un crayon.", TranslatorFactory.createTranslator(Language.FR, References.GAME_BOOK).translate(source).getTranslation());
    }
}

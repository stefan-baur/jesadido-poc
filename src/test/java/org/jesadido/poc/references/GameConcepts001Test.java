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

public class GameConcepts001Test {
    
    @Test
    public void testMethod000GameConcepts20161007092635MESZ() {
        final String source = "Mi$La LudO MalGrandEgA ..";
        Assert.assertEquals("{ Su ( Mi$La LudO MalGrandEgA ) } ..", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.GAME_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mein winziges Spiel", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.GAME_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("My tiny game", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.GAME_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mia malgrandega ludo", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.GAME_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mi menudo juego", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.GAME_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mon jeu infime", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.GAME_CONCEPTS).translate(source).getTranslation());
    }

    @Test
    public void testMethod001GameConcepts20161007092635MESZ() {
        final String source = "Ni$La LudO GigantA ..";
        Assert.assertEquals("{ Su ( Ni$La LudO GigantA ) } ..", TranslatorFactory.createTranslator(Language.JI, ReferenceConceptBooks.GAME_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Unser gigantisches Spiel", TranslatorFactory.createTranslator(Language.DE, ReferenceConceptBooks.GAME_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Our gigantic game", TranslatorFactory.createTranslator(Language.EN, ReferenceConceptBooks.GAME_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Nia giganta ludo", TranslatorFactory.createTranslator(Language.EO, ReferenceConceptBooks.GAME_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Nuestro gigantesco juego", TranslatorFactory.createTranslator(Language.ES, ReferenceConceptBooks.GAME_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Notre gigantesque jeu", TranslatorFactory.createTranslator(Language.FR, ReferenceConceptBooks.GAME_CONCEPTS).translate(source).getTranslation());
    }
}

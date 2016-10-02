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

public class GameConcepts000Test {
    
    @Test
    public void testMethod000GameConcepts20161002124101MESZ() {
        final String source = "Mi$La LudO MalGrandEgA ..";
        Assert.assertEquals("{ Su ( Mi$La LudO MalGrandEgA ) } ..", TranslatorFactory.createTranslator(Language.JI, References.GAME_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mein winziges Spiel", TranslatorFactory.createTranslator(Language.DE, References.GAME_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("My tiny game", TranslatorFactory.createTranslator(Language.EN, References.GAME_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mia malgrandega ludo", TranslatorFactory.createTranslator(Language.EO, References.GAME_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mi menudo juego", TranslatorFactory.createTranslator(Language.ES, References.GAME_CONCEPTS).translate(source).getTranslation());
        Assert.assertEquals("Mon jeu infime", TranslatorFactory.createTranslator(Language.FR, References.GAME_CONCEPTS).translate(source).getTranslation());
    }
}

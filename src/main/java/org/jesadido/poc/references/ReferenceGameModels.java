/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.references;

import java.util.Arrays;
import java.util.List;
import org.jesadido.poc.JesadidoPoc;
import org.jesadido.poc.core.Language;
import org.jesadido.poc.usecases.gaming.graphics.ThingFactory;
import org.jesadido.poc.usecases.gaming.models.GameModel;

public final class ReferenceGameModels {
    
    private static final GameModel MY_TINY_GAME = new GameModel("my-tiny-game")
            .initGameConceptBook(ReferenceConceptBooks.GAME_CONCEPTS)
            .initSupportedLanguages(Language.DE, Language.EN, Language.EO, Language.ES, Language.FR, Language.JI)
            .initSelectedLanguages(Language.EO, Language.EN)
            .initRgboPalette(ReferenceRgboPalettes.MAGIC_COLORS)
            .initTitle("Mi$La LudO MalGrandEgA ..")
            .initThings(ThingFactory.createSunO())
            ;
    
    private static final GameModel OUR_GIGANTIC_GAME = new GameModel("our-gigantic-game")
            .initGameConceptBook(ReferenceConceptBooks.GAME_CONCEPTS)
            .initSupportedLanguages(Language.DE, Language.EN, Language.EO, Language.ES, Language.FR)
            .initSelectedLanguages(Language.EO)
            .initRgboPalette(ReferenceRgboPalettes.DEFAULT_COLORS)
            .initTitle("Ni$La LudO GigantA ..")
            ;
    
    private static final List<GameModel> GAME_MODELS = Arrays.asList(MY_TINY_GAME, OUR_GIGANTIC_GAME);
    
    private ReferenceGameModels() {
        // A private class constructor
    }
    
    public static List<GameModel> getGameModels() {
        return GAME_MODELS;
    }
    
    public static void main(final String[] arguments) {
        JesadidoPoc.run(arguments);
    }
}

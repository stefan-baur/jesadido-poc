/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.references;

import org.jesadido.poc.JesadidoPoc;
import org.jesadido.poc.core.Language;
import org.jesadido.poc.usecases.gaming.models.GameModel;

public final class ReferenceGameModels {
    
    public static final GameModel MY_TINY_GAME = new GameModel("my-tiny-game")
            .initGameConceptBook(ReferenceConceptBooks.GAME_CONCEPTS)
            .initSupportedLanguages(Language.DE, Language.EN, Language.EO, Language.ES, Language.FR, Language.JI)
            .initSelectedLanguages(Language.EO, Language.EN)
            .initRgboPalette(ReferenceRgboPalettes.MAGIC_COLORS)
            .initTitle("Mi$La LudO MalGrandEgA ..")
            ;
    
    private ReferenceGameModels() {
        // A private class constructor
    }
    
    public static void main(final String[] arguments) {
        JesadidoPoc.run(arguments);
    }
}

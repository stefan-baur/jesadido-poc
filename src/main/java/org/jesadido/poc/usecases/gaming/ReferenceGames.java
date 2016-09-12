/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming;

import org.jesadido.poc.usecases.gaming.models.GameModel;

public final class ReferenceGames {
    
    public static final GameModel MY_TINY_GAME = new GameModel("my-tiny-game")
            .initTitle("Mi$La LudO MalGrandEgA !.")
            ;
    
    private ReferenceGames() {
        // A private class constructor
    }
}

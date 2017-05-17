/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.generators.javafx;

import org.jesadido.poc.JesadidoPoc;
import org.jesadido.poc.usecases.gaming.models.GameModel;

public class JavaFxGenerator {
    
    public GamePane generate(final GameModel gameModel) {
        final GamePane result = new GamePane(gameModel);
        result.setPrefHeight(2400);
        return result;
    }
    
    public static void main(final String[] arguments) {
        JesadidoPoc.run(arguments);
    }
}

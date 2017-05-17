/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.generators.javafx;

import javafx.scene.Node;
import org.jesadido.poc.usecases.gaming.models.Thing;
import org.jesadido.poc.usecases.gaming.graphics.rags.RagTranslate;

public final class JavaFxFactory {
    
    private JavaFxFactory() {
        // A private utility class constructor
    }
    
    public static Node createJavaFx(final GameState gameState, final Thing thing) {
        return new RagTranslate(thing.getPositionX(), thing.getPositionY()).add(thing.getRawRag()).accept(new JavaFxRagVisitor(gameState), null);
    }
}

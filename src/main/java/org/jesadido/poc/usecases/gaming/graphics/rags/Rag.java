/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.graphics.rags;

import javafx.scene.Node;
import org.jesadido.poc.usecases.gaming.models.GameModel;

@FunctionalInterface
public interface Rag {
    
    public Node createJavaFx(final GameModel gameModel);
}

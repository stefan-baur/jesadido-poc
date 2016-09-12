/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.generators.javafx;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.text.Text;
import org.jesadido.poc.usecases.gaming.models.GameModel;

public class NodeGameGenerator {
    
    public Node generate(final GameModel gameModel) {
        final Group result = new Group();
        final Text title = new Text(gameModel.getTitle());
        result.getChildren().add(title);
        return result;
    }
}

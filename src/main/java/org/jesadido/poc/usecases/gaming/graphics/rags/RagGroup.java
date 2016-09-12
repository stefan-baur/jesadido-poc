/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.graphics.rags;

import javafx.scene.Group;
import javafx.scene.Node;

public class RagGroup extends RagComposite {
    
    @Override
    public Node createJavaFx() {
        final Group result = new Group();
        this.getRags().stream().forEach(rag -> result.getChildren().add(rag.createJavaFx()));
        return result;
    }
}

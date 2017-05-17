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
import org.jesadido.poc.usecases.gaming.models.GameModel;

public class RagTranslate extends RagComposite {
    
    private final double translateX;
    private final double translateY;
    
    public RagTranslate(final double translateX, final double translateY) {
        this.translateX = translateX;
        this.translateY = translateY;
    }
    
    public double getTranslateX() {
        return this.translateX;
    }
    
    public double getTranslateY() {
        return this.translateY;
    }
    
    @Override
    public Node createJavaFx(final GameModel gameModel) {
        final Group result = new Group();
        this.getRags().stream().forEach(rag -> result.getChildren().add(rag.createJavaFx(gameModel)));
        result.setTranslateX(this.translateX);
        result.setTranslateY(this.translateY);
        return result;
    }
}

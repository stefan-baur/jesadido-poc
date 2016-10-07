/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.generators.javafx;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import org.jesadido.poc.usecases.gaming.graphics.RgboKeys;

public class BackgroundLayer extends SizedGameObject {
    
    private final Rectangle backgroundArea = new Rectangle();
    private final Line horizontalCenterLine = new Line();
    private final Line verticalCenterLine = new Line();
    
    public BackgroundLayer(final GameScene gameScene) {
        super(gameScene, 200, 160);
        init();
    }
    
    private void init() {
        this.backgroundArea.setFill(this.getGameScene().getGameState().getColor(RgboKeys.BACKGROUND));
        this.horizontalCenterLine.setStroke(Color.color(0.23, 0.23, 0.23));
        this.verticalCenterLine.setStroke(Color.color(0.23, 0.23, 0.23));
        this.getChildren().addAll(this.backgroundArea, this.horizontalCenterLine, this.verticalCenterLine);
        this.invalidate();
    }
    
    @Override
    public void invalidate() {
        final double width = this.getWidth();
        final double height = this.getHeight();
        final double width2 = width / 2.0;
        final double height2 = height / 2.0;
        
        this.backgroundArea.setWidth(width);
        this.backgroundArea.setHeight(height);
        
        this.horizontalCenterLine.setStartX(0);
        this.horizontalCenterLine.setStartY(height2);
        this.horizontalCenterLine.setEndX(width);
        this.horizontalCenterLine.setEndY(height2);
        
        this.verticalCenterLine.setStartX(width2);
        this.verticalCenterLine.setStartY(0);
        this.verticalCenterLine.setEndX(width2);
        this.verticalCenterLine.setEndY(height);
    }
}

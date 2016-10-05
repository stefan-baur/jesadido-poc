/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.generators.javafx;

import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import org.jesadido.poc.usecases.gaming.models.GameModel;

public class GamePane extends Pane {
    
    private final GameScene gameScene;
    
    public GamePane(final GameScene gameScene) {
        super(gameScene);
        this.gameScene = gameScene;
        this.layoutBoundsProperty().addListener((ObservableValue<? extends Bounds> observable, Bounds oldValue, Bounds newValue) -> this.gameScene.resize(newValue.getWidth(), newValue.getHeight()));
    }
    
    public GamePane(final GameModel gameModel) {
        this(new GameScene(gameModel));
    }
    
    public GameScene getGameScene() {
        return this.gameScene;
    }
}

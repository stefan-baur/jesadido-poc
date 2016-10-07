/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.generators.javafx;

import javafx.scene.Group;
import org.jesadido.poc.usecases.gaming.models.GameModel;

public abstract class GameObject extends Group {
    
    private final GameScene gameScene;
    
    public GameObject(final GameScene gameScene) {
        this.gameScene = gameScene;
    }
    
    public final GameScene getGameScene() {
        return this.gameScene;
    }
    
    public final GameState getGameState() {
        return this.gameScene.getGameState();
    }
    
    public final GameModel getGameModel() {
        return this.gameScene.getGameState().getGameModel();
    }
    
    public abstract void invalidate();
}

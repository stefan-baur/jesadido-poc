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
    
    public GamePane(final GameModel gameModel) {
        super(new GameScene(gameModel));
        this.layoutBoundsProperty().addListener((ObservableValue<? extends Bounds> observable, Bounds oldValue, Bounds newValue) -> this.getChildren().get(0).resize(newValue.getWidth(), newValue.getHeight()));
    }
}

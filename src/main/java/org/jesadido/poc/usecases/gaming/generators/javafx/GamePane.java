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
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import org.jesadido.poc.usecases.gaming.models.GameModel;

public class GamePane extends BorderPane {
    
    private final GameModel gameModel;
    
    public GamePane(final GameModel gameModel) {
        this.gameModel = gameModel;
        this.init();
    }
    
    public GameModel getGameModel() {
        return this.gameModel;
    }
    
    private void init() {
        this.setTop(this.createSupportedLanguages());
        this.setCenter(this.createTitle());
    }
    
    private Node createSupportedLanguages() {
        final Group result = new Group();
        final Text supportedLanguages = new Text(this.gameModel.getSupportedLanguages().toString());
        result.getChildren().add(supportedLanguages);
        return result;
    }
    
    private Node createTitle() {
        final Group result = new Group();
        final Text title = new Text(this.gameModel.getTitle());
        result.getChildren().add(title);
        return result;
    }
}

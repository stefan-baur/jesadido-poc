/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.generators.javafx;

import javafx.event.Event;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.jesadido.poc.core.Language;

public class LanguageSettings extends Group {
    
    private final GameScene gameScene;
    
    public LanguageSettings(final GameScene gameScene) {
        this.gameScene = gameScene;
        this.init();
    }
    
    private void init() {
        final Group settings = new Group();
        settings.getChildren().add(this.createMainLanguageField());
        this.getChildren().add(settings);
    }
    
    private Node createMainLanguageField() {
        return this.createLanguageField(this.gameScene.getGameState().getMainLanguage());
    }
    
    private Node createLanguageField(final Language language) {
        final Text result = new Text(String.format("%s %s %s", language.getCode(), this.gameScene.getGameState().getSemiLanguages(), this.gameScene.getGameState().getRestLanguages()));
        result.setFill(Color.KHAKI);
        result.setX(3);
        result.setY(2);
        result.setTextOrigin(VPos.TOP);
        result.setOnMouseClicked((Event event) -> {
            this.gameScene.getGameState().selectNextMainLanguage();
            this.gameScene.update();
        });
        return result;
    }
    
    public void update() {
        this.getChildren().clear();
        this.init();
    }
}

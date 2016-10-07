/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.generators.javafx;

import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;
import org.jesadido.poc.core.Language;

public class LanguageSettings extends Group {
    
    private final GameScene gameScene;
    
    public LanguageSettings(final GameScene gameScene) {
        this.gameScene = gameScene;
        this.init();
    }
    
    private void init() {
        final FlowPane settings = new FlowPane();
        settings.setHgap(8);
        settings.setVgap(8);
        settings.getChildren().add(this.createMainLanguageField());
        this.gameScene.getGameState().getSemiLanguages().stream().forEach(language -> settings.getChildren().add(this.createLanguageField(language)));
        this.gameScene.getGameState().getRestLanguages().stream().forEach(language -> settings.getChildren().add(this.createLanguageField(language)));
        final Group settingsGroup = new Group(settings);
        settingsGroup.setTranslateX(20);
        settingsGroup.setTranslateY(16);
        this.getChildren().add(settingsGroup);
    }
    
    private Node createMainLanguageField() {
        return this.createLanguageField(this.gameScene.getGameState().getMainLanguage());
    }
    
    private Node createLanguageField(final Language language) {
        final LanguageField result = new LanguageField(language);
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

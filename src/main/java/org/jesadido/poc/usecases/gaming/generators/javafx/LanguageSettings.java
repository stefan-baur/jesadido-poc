/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.generators.javafx;

import javafx.scene.Group;
import javafx.scene.layout.FlowPane;

public class LanguageSettings extends GameObject {
    
    public LanguageSettings(final GameScene gameScene) {
        super(gameScene);
        this.init();
    }
    
    private void init() {
        final double gapWidth = 8.0;
        final int languageCount = this.getGameModel().getSupportedLanguages().size();
        final FlowPane languageFields = new FlowPane();
        languageFields.setHgap(gapWidth);
        languageFields.setVgap(gapWidth);
        languageFields.setPrefWidth(LanguageControl.WIDTH * languageCount + gapWidth * (languageCount - 1));
        languageFields.getChildren().add(new LanguageControl(this.getGameScene(), this.getGameState().getMainLanguage()));
        this.getGameState().getSemiLanguages().stream().forEach(language -> languageFields.getChildren().add(new LanguageControl(this.getGameScene(), language)));
        this.getGameState().getRestLanguages().stream().forEach(language -> languageFields.getChildren().add(new LanguageControl(this.getGameScene(), language)));
        final Group languageSettings = new Group(languageFields);
        languageSettings.setTranslateX(20);
        languageSettings.setTranslateY(16);
        this.getChildren().add(languageSettings);
    }
    
    @Override
    public void invalidate() {
        this.getChildren().clear();
        this.init();
    }
}

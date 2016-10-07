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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import org.jesadido.poc.JesadidoPoc;
import org.jesadido.poc.core.Language;
import org.jesadido.poc.usecases.gaming.graphics.RgboKeys;

public class LanguageControl extends SizedGameObject {
    
    private final Language language;
    
    private final Rectangle controlArea = new Rectangle();
    private final Text languageText = new Text();
    
    public LanguageControl(final GameScene gameScene, final Language language) {
        super(gameScene, 24, 24);
        this.language = language;
        this.init();
    }
    
    private void init() {
        this.setWidth(32);
        this.setHeight(32);
        this.controlArea.setFill(JavaFxGameUtils.toColor(this.getGameModel().getRgbo(RgboKeys.REST_LANGUAGE_CONTROL_FILL)));
        this.controlArea.setArcWidth(8);
        this.controlArea.setArcHeight(8);
        this.getChildren().add(this.controlArea);
        this.languageText.setText(this.language.getCode());
        this.languageText.setFont(Font.font("Comic Sans MS", FontWeight.NORMAL, 14));
        this.languageText.setFill(JavaFxGameUtils.toColor(this.getGameModel().getRgbo(RgboKeys.REST_LANGUAGE_FILL)));
        this.languageText.setTextOrigin(VPos.CENTER);
        this.languageText.setTextAlignment(TextAlignment.CENTER);
        this.getChildren().add(this.languageText);
        if (this.getGameState().getMainLanguage() == this.language) {
            this.controlArea.setFill(JavaFxGameUtils.toColor(this.getGameModel().getRgbo(RgboKeys.MAIN_LANGUAGE_CONTROL_FILL)));
            this.languageText.setFill(JavaFxGameUtils.toColor(this.getGameModel().getRgbo(RgboKeys.MAIN_LANGUAGE_FILL)));
        } else if (this.getGameState().getSemiLanguages().contains(this.language)) {
            this.controlArea.setFill(JavaFxGameUtils.toColor(this.getGameModel().getRgbo(RgboKeys.SEMI_LANGUAGE_CONTROL_FILL)));
            this.languageText.setFill(JavaFxGameUtils.toColor(this.getGameModel().getRgbo(RgboKeys.SEMI_LANGUAGE_FILL)));
        }
        this.setOnMouseClicked((Event event) -> {
            this.getGameState().selectLanguage(this.language);
            this.getGameScene().invalidate();
        });
        this.invalidate();
    }
    
    @Override
    public void invalidate() {
        final double width = this.getWidth();
        final double height = this.getHeight();
        this.controlArea.setWidth(width);
        this.controlArea.setHeight(height);
        this.languageText.setX((width - this.languageText.prefWidth(-1)) / 2.0);
        this.languageText.setY(height / 2.0);
    }
    
    public static void main(final String[] arguments) {
        JesadidoPoc.run(arguments);
    }
}

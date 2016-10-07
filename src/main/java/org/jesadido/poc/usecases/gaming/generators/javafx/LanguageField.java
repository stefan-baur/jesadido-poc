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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import org.jesadido.poc.JesadidoPoc;
import org.jesadido.poc.core.Language;

public class LanguageField extends SizedGameObject {
    
    private final Language language;
    
    private final Rectangle backgroundArea = new Rectangle();
    private final Text languageText = new Text();
    
    public LanguageField(final GameScene gameScene, final Language language) {
        super(gameScene, 24, 24);
        this.language = language;
        this.init();
    }
    
    private void init() {
        this.setWidth(32);
        this.setHeight(32);
        this.backgroundArea.setFill(Color.color(0.24, 0.24, 0.24));
        this.backgroundArea.setArcWidth(8);
        this.backgroundArea.setArcHeight(8);
        this.getChildren().add(this.backgroundArea);
        this.languageText.setText(this.language.getCode());
        this.languageText.setFont(Font.font("Comic Sans MS", FontWeight.NORMAL, 14));
        this.languageText.setFill(Color.color(0.18, 0.18, 0.18));
        this.languageText.setTextOrigin(VPos.CENTER);
        this.languageText.setTextAlignment(TextAlignment.CENTER);
        this.getChildren().add(this.languageText);
        if (this.getGameScene().getGameState().getMainLanguage() == this.language) {
            this.backgroundArea.setFill(Color.color(0.2, 0.2, 0.2));
            this.languageText.setFill(Color.color(0.94, 0.90, 0.55));
        } else if (this.getGameScene().getGameState().getSemiLanguages().contains(this.language)) {
            this.backgroundArea.setFill(Color.color(0.22, 0.22, 0.22));
            this.languageText.setFill(Color.color(0.7, 0.7, 0.7));
        }
        this.setOnMouseClicked((Event event) -> {
            this.getGameScene().getGameState().selectLanguage(this.language);
            this.getGameScene().invalidate();
        });
        this.invalidate();
    }
    
    @Override
    public void invalidate() {
        final double width = this.getWidth();
        final double height = this.getHeight();
        this.backgroundArea.setWidth(width);
        this.backgroundArea.setHeight(height);
        this.languageText.setX((width - this.languageText.prefWidth(-1)) / 2.0);
        this.languageText.setY(height / 2.0);
    }
    
    public static void main(final String[] arguments) {
        JesadidoPoc.run(arguments);
    }
}

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.generators.javafx;

import java.util.EnumMap;
import java.util.Map;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.geometry.VPos;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import org.jesadido.poc.core.Language;
import org.jesadido.poc.usecases.gaming.graphics.Rgbo;
import org.jesadido.poc.usecases.gaming.graphics.RgboKeys;

public class SplashScreen extends SizedGameObject {
    
    private final Rectangle filler = new Rectangle();
    private final Map<Language, Text> title = new EnumMap<>(Language.class);
    
    public SplashScreen(final GameScene gameScene) {
        super(gameScene, 200, 160);
        this.init();
    }
    
    private void init() {
        this.filler.setFill(JavaFxGameUtils.toColor(Rgbo.TRANSPARENT));
        for (final Language language : Language.values()) {
            final Text titleText = new Text(this.getGameModel().translate(language, this.getGameModel().getTitle().getSource()));
            titleText.setTextOrigin(VPos.CENTER);
            this.title.put(language, titleText);
        }
        this.setOnMouseClicked((Event event) -> Logger.getAnonymousLogger().info("SplashScreen-Click-Event"));
        this.invalidate();
    }
    
    @Override
    public void invalidate() {
        final double width = this.getWidth();
        final double height = this.getHeight();
        this.getChildren().clear();
        this.getChildren().add(this.filler);
        this.filler.setWidth(width);
        this.filler.setHeight(height);
        this.getChildren().add(this.createMainTitle(width, height));
        for (int i = 0; i < this.getGameState().getSemiLanguages().size(); i++) {
            this.getChildren().add(this.createSemiTitle(i, this.getGameState().getSemiLanguages().get(i), width, height));
        }
    }
    
    private Text createMainTitle(final double width, final double height) {
        final Text mainTitle = this.title.get(this.getGameState().getMainLanguage());
        mainTitle.setFont(Font.font("Comic Sans MS", FontWeight.NORMAL, 20));
        mainTitle.setFill(JavaFxGameUtils.toColor(this.getGameModel().getRgbo(RgboKeys.MAIN_TEXT_FILL)));
        mainTitle.setX((width - mainTitle.prefWidth(-1)) / 2.0);
        mainTitle.setY(height / 3.0);
        return mainTitle;
    }
    
    private Text createSemiTitle(final int index, final Language language, final double width, final double height) {
        final Text mainTitle = this.title.get(language);
        mainTitle.setFont(Font.font("Comic Sans MS", FontWeight.NORMAL, 18));
        mainTitle.setFill(JavaFxGameUtils.toColor(this.getGameModel().getRgbo(RgboKeys.SEMI_TEXT_FILL)));
        mainTitle.setX((width - mainTitle.prefWidth(-1)) / 2.0);
        mainTitle.setY((height / 3.0) + (index + 1) * 32);
        return mainTitle;
    }
}

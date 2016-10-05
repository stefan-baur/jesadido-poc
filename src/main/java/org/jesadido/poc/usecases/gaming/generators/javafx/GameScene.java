/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.generators.javafx;

import java.util.logging.Logger;
import javafx.event.Event;
import javafx.geometry.VPos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import org.jesadido.poc.JesadidoPoc;
import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.semantics.translating.TranslatorFactory;
import org.jesadido.poc.usecases.gaming.models.GameModel;

public class GameScene extends SizedGroup {
    
    private final GameState gameState;
    
    private final Rectangle clippingRegion = new Rectangle();
    private final BackgroundLayer backgroundLayer = new BackgroundLayer();
    
    public GameScene(final GameModel gameModel) {
        this.gameState = new GameState(gameModel);
        this.init();
    }
    
    public GameState getGameState() {
        return this.gameState;
    }
    
    public GameModel getGameModel() {
        return this.gameState.getGameModel();
    }
    
    private void init() {
        final double width = this.getWidth();
        final double height = this.getHeight();
        
        this.setClip(this.clippingRegion);
        this.clippingRegion.setWidth(width);
        this.clippingRegion.setHeight(height);
        
        this.getChildren().add(this.backgroundLayer);
        this.backgroundLayer.setSize(width, height);
        
        final Text languageSettings = new Text(String.format("%s %s %s", this.gameState.getMainLanguage(), this.gameState.getSemiLanguages(), this.gameState.getSelectableLanguages().toString().replace("[", "{").replace("]", "}")));
        languageSettings.setFill(Color.KHAKI);
        languageSettings.setX(3);
        languageSettings.setY(2);
        languageSettings.setTextOrigin(VPos.TOP);
        languageSettings.setOnMouseClicked((Event event) -> Logger.getAnonymousLogger().info("Click"));
        this.getChildren().add(languageSettings);
        
        final Text title = new Text(this.translate(this.gameState.getMainLanguage(), this.gameState.getGameModel().getTitle().getSource()));
        title.setFill(Color.KHAKI);
        title.setFont(new Font(20));
        title.setX((width - title.prefWidth(-1)) / 2.0);
        title.setY(height / 2.0);
        title.setTextOrigin(VPos.CENTER);
        this.getChildren().add(title);
    }
    
    @Override
    public void update() {
        this.getChildren().clear();
        this.init();
    }
    
    private String translate(final Language language, final String source) {
        return TranslatorFactory.createTranslator(language, this.gameState.getGameModel().getGameConceptBook()).translate(source).getTranslation();
    }
    
    public static void main(final String[] arguments) {
        JesadidoPoc.run(arguments);
    }
}

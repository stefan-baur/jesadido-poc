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
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import org.jesadido.poc.JesadidoPoc;
import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.semantics.translating.TranslatorFactory;
import org.jesadido.poc.usecases.gaming.models.GameModel;

public class GameScene extends Group {
    
    private final GameState gameState;
    
    private static final double MIN_WIDTH = 200;
    private static final double MIN_HEIGHT = 160;
    
    private double width = MIN_WIDTH;
    private double height = MIN_HEIGHT;
    
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
    
    public double getWidth() {
        return this.width;
    }
    
    public double getHeight() {
        return this.height;
    }
    
    public void setSize(final double width, final double height) {
        this.width = Math.max(MIN_WIDTH, width);
        this.height = Math.max(MIN_HEIGHT, height);
    }
    
    private void init() {
        final double w = this.getWidth();
        final double h = this.getHeight();
        this.getChildren().add(new Rectangle(w, h, Color.DARKGREEN));
        
        final Line vLine = new Line(w / 2.0, 0, w / 2.0, h);
        vLine.setStroke(Color.GREEN);
        this.getChildren().add(vLine);
        
        final Line hLine = new Line(0, h / 2.0, w, h / 2.0);
        hLine.setStroke(Color.GREEN);
        this.getChildren().add(hLine);
        
        final Text languageSettings = new Text(String.format("%s %s %s", this.gameState.getMainLanguage(), this.gameState.getSemiLanguages(), this.gameState.getSelectableLanguages().toString().replace("[", "{").replace("]", "}")));
        languageSettings.setFill(Color.WHITE);
        languageSettings.setX(3);
        languageSettings.setY(2);
        languageSettings.setTextOrigin(VPos.TOP);
        languageSettings.setOnMouseClicked((Event event) -> Logger.getAnonymousLogger().info("Click"));
        this.getChildren().add(languageSettings);
        
        final Text title = new Text(this.translate(this.gameState.getMainLanguage(), this.gameState.getGameModel().getTitle().getSource()));
        title.setFill(Color.WHITE);
        title.setX((w - title.prefWidth(-1)) / 2.0);
        title.setY(h / 2.0);
        title.setTextOrigin(VPos.CENTER);
        this.getChildren().add(title);
    }
    
    @Override
    public void resize(final double width, final double height) {
        super.resize(width, height);
        this.setSize(width, height);
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

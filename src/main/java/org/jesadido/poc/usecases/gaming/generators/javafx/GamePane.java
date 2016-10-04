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
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import org.jesadido.poc.JesadidoPoc;
import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.scripting.Src;
import org.jesadido.poc.core.semantics.translating.TranslatorFactory;
import org.jesadido.poc.usecases.gaming.models.GameModel;

public class GamePane extends Pane {
    
    private final GameState gameState;
    
    private final Group gameScene = new Group();
    
    public GamePane(final GameModel gameModel) {
        this.gameState = new GameState(gameModel);
        this.init();
        this.layoutBoundsProperty().addListener((ObservableValue<? extends Bounds> observable, Bounds oldValue, Bounds newValue) -> this.invalidate());
    }
    
    private void init() {
        this.getChildren().add(this.gameScene);
    }
    
    private void invalidate() {
        final double clientWidth = Math.max(200, this.getWidth());
        final double clientHeight = Math.max(160, this.getHeight());
        this.gameScene.getChildren().clear();
        
        this.gameScene.getChildren().add(new Rectangle(clientWidth, clientHeight, Color.DARKGREEN));
        
        final Line vLine = new Line(clientWidth / 2.0, 0, clientWidth / 2.0, clientHeight);
        vLine.setStroke(Color.GREEN);
        this.gameScene.getChildren().add(vLine);
        
        final Line hLine = new Line(0, clientHeight / 2.0, clientWidth, clientHeight / 2.0);
        hLine.setStroke(Color.GREEN);
        this.gameScene.getChildren().add(hLine);
        
        final Text supportedLanguages = new Text(String.format("%s %s %s", this.gameState.getMainLanguage(), this.gameState.getSemiLanguages(), this.gameState.getSelectableLanguages().toString().replace("[", "{").replace("]", "}")));
        supportedLanguages.setFill(Color.WHITE);
        supportedLanguages.setX(3);
        supportedLanguages.setY(2);
        supportedLanguages.setTextOrigin(VPos.TOP);
        this.gameScene.getChildren().add(supportedLanguages);
        
        final Text title = new Text(this.translate(this.gameState.getMainLanguage(), this.gameState.getGameModel().getTitle().getSource()));
        title.setFill(Color.WHITE);
        title.setX((clientWidth - title.prefWidth(-1)) / 2.0);
        title.setY(clientHeight / 2.0);
        title.setTextOrigin(VPos.CENTER);
        this.gameScene.getChildren().add(title);
    }
    
    private String translate(final Language language, final String source) {
        return TranslatorFactory.createTranslator(language, this.gameState.getGameModel().getGameConceptBook()).translate(source).getTranslation();
    }
    
    public static void main(final String[] arguments) {
        JesadidoPoc.run(arguments);
    }
}

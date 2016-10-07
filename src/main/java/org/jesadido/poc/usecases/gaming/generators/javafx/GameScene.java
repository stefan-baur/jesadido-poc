/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.generators.javafx;

import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import org.jesadido.poc.JesadidoPoc;
import org.jesadido.poc.usecases.gaming.models.GameModel;

public class GameScene extends Group {
    
    private final GameState gameState;
    
    private double width = 200;
    private double height = 160;
    
    private final Rectangle clippingRegion = new Rectangle();
    private BackgroundLayer backgroundLayer;
    private SplashScreen splashScreen;
    private LanguageSettings languageSettings;
    
    public GameScene(final GameModel gameModel) {
        this.gameState = new GameState(gameModel);
        this.init();
    }
    
    public GameState getGameState() {
        return this.gameState;
    }
    
    private void init() {
        this.setClip(this.clippingRegion);
        
        this.backgroundLayer = new BackgroundLayer(this);
        this.getChildren().add(this.backgroundLayer);
        
        this.splashScreen = new SplashScreen(this);
        this.getChildren().add(this.splashScreen);
        
        this.languageSettings = new LanguageSettings(this);
        this.getChildren().add(this.languageSettings);
        
        this.resize(200, 160);
    }
    
    public void invalidate() {
        this.clippingRegion.setWidth(this.width);
        this.clippingRegion.setHeight(this.height);
        this.backgroundLayer.setWidth(this.width);
        this.backgroundLayer.setHeight(this.height);
        this.backgroundLayer.invalidate();
        this.splashScreen.setWidth(this.width);
        this.splashScreen.setHeight(this.height);
        this.splashScreen.invalidate();
        this.languageSettings.invalidate();
    }
    
    @Override
    public void resize(final double width, final double height) {
        this.width = width;
        this.height = height;
        this.invalidate();
    }
    
    public static void main(final String[] arguments) {
        JesadidoPoc.run(arguments);
    }
}

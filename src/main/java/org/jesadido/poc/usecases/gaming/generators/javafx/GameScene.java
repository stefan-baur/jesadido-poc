/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.generators.javafx;

import javafx.scene.shape.Rectangle;
import org.jesadido.poc.JesadidoPoc;
import org.jesadido.poc.usecases.gaming.models.GameModel;

public class GameScene extends SizedGroup {
    
    private final GameState gameState;
    
    private final Rectangle clippingRegion = new Rectangle();
    private final BackgroundLayer backgroundLayer = new BackgroundLayer();
    private SplashScreen splashScreen;
    private LanguageSettings languageSettings;
    
    public GameScene(final GameModel gameModel) {
        super(200, 160);
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
        this.setClip(this.clippingRegion);
        
        this.getChildren().add(this.backgroundLayer);
        
        this.splashScreen = new SplashScreen(this);
        this.getChildren().add(this.splashScreen);
        
        this.languageSettings = new LanguageSettings(this);
        this.getChildren().add(this.languageSettings);
        
        this.update();
    }
    
    @Override
    public void update() {
        final double width = this.getWidth();
        final double height = this.getHeight();
        
        this.clippingRegion.setWidth(width);
        this.clippingRegion.setHeight(height);
        this.backgroundLayer.setWidth(width);
        this.backgroundLayer.setHeight(height);
        this.backgroundLayer.update();
        this.splashScreen.setWidth(width);
        this.splashScreen.setHeight(height);
        this.splashScreen.update();
        this.languageSettings.update();
    }
    
    public static void main(final String[] arguments) {
        JesadidoPoc.run(arguments);
    }
}

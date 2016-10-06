/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.generators.javafx;

import javafx.geometry.VPos;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.semantics.translating.TranslatorFactory;

public class SplashScreen extends SizedGroup {
    
    private final GameScene gameScene;
    
    private final Text title = new Text();
    
    public SplashScreen(final GameScene gameScene) {
        this.gameScene = gameScene;
        this.init();
    }
    
    private void init() {
        this.title.setFill(Color.KHAKI);
        this.title.setFont(new Font(20));
        this.title.setTextOrigin(VPos.CENTER);
        this.getChildren().add(this.title);
    }
    
    @Override
    public void update() {
        final double width = this.getWidth();
        final double height = this.getHeight();
        
        this.title.setText(this.translate(this.gameScene.getGameState().getMainLanguage(), this.gameScene.getGameState().getGameModel().getTitle().getSource()));
        this.title.setX((width - this.title.prefWidth(-1)) / 2.0);
        this.title.setY(height / 2.0);
    }
    
    private String translate(final Language language, final String source) {
        return TranslatorFactory.createTranslator(language, this.gameScene.getGameState().getGameModel().getGameConceptBook()).translate(source).getTranslation();
    }
}

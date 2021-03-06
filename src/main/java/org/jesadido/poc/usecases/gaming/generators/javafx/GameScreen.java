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
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import org.jesadido.poc.core.Language;
import org.jesadido.poc.usecases.gaming.graphics.Rgbo;
import org.jesadido.poc.usecases.gaming.models.Thing;

public class GameScreen extends SizedGameObject {
    
    private final Rectangle filler = new Rectangle();
    private final Map<Language, Text> title = new EnumMap<>(Language.class);
    
    public GameScreen(final GameScene gameScene) {
        super(gameScene, 200, 160);
        this.init();
    }
    
    private void init() {
        this.filler.setFill(JavaFxUtils.toColor(Rgbo.TRANSPARENT));
        for (final Language language : Language.values()) {
            final Text titleText = new Text(this.getGameModel().translate(language, this.getGameModel().getTitle().getSource()));
            titleText.setTextOrigin(VPos.CENTER);
            this.title.put(language, titleText);
        }
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
        final int thingsCount = this.getGameModel().getThings().size();
        for (int i = 0; i < thingsCount; i++) {
            final Thing thing = this.getGameModel().getThings().get(i);
            final double w = width / (double) thingsCount;
            thing.setPosition(i * w + w / 2, height / 2);
            final Group thingWrapper = new Group();
            thingWrapper.setScaleX(1 / (double) thingsCount);
            thingWrapper.setScaleY(1 / (double) thingsCount);
            thingWrapper.getChildren().add(JavaFxFactory.createJavaFx(this.getGameState(), thing));
            this.getChildren().add(thingWrapper);
        }
    }
}

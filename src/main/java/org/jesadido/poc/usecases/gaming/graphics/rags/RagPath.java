/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.graphics.rags;

import javafx.scene.Node;
import javafx.scene.shape.SVGPath;
import org.jesadido.poc.usecases.gaming.generators.javafx.JavaFxGameUtils;
import org.jesadido.poc.usecases.gaming.graphics.RgboKeys;
import org.jesadido.poc.usecases.gaming.models.GameModel;

public class RagPath implements RagLeaf {
    
    private final String fillKey;
    private final String strokeKey;
    private final double strokeWidth;
    private final String path;
    
    public RagPath(final String fillKey, final String strokeKey, final double strokeWidth, final String path) {
        this.fillKey = fillKey;
        this.strokeKey = strokeKey;
        this.strokeWidth = Math.max(0, strokeWidth);
        this.path = path;
    }
    
    public RagPath(final String fillKey, final String path) {
        this(fillKey, RgboKeys.NONE, 0, path);
    }
    
    public String getFillKey() {
        return this.fillKey;
    }
    
    public String getStrokeKey() {
        return this.strokeKey;
    }
    
    public double getStrokeWidth() {
        return this.strokeWidth;
    }
    
    public String getPath() {
        return this.path;
    }
    
    @Override
    public Node createJavaFx(final GameModel gameModel) {
        final SVGPath result = new SVGPath();
        result.setContent(this.getPath());
        result.setFill(JavaFxGameUtils.toColor(gameModel.getRgbo(this.getFillKey())));
        result.setStroke(JavaFxGameUtils.toColor(gameModel.getRgbo(this.getStrokeKey())));
        result.setStrokeWidth(this.getStrokeWidth());
        return result;
    }
}

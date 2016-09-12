/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.graphics.rags;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import org.jesadido.poc.usecases.gaming.graphics.RGBO;

public class RagPath implements RagLeaf {
    
    private final RagProperties properties;
    private final String path;
    
    public RagPath(final RagProperties properties, final String path) {
        this.properties = properties;
        this.path = path;
    }
    
    public RagProperties getProperties() {
        return this.properties;
    }
    
    public String getPath() {
        return this.path;
    }
    
    @Override
    public Node createJavaFx() {
        final SVGPath result = new SVGPath();
        result.setContent(this.getPath());
        final RGBO fill = this.getProperties().getFill();
        result.setFill(new Color(fill.getRed() / 255.0, fill.getGreen() / 255.0, fill.getBlue() / 255.0, fill.getOpacity()));
        final RGBO stroke = this.getProperties().getStroke();
        result.setStroke(new Color(stroke.getRed() / 255.0, stroke.getGreen() / 255.0, stroke.getBlue() / 255.0, stroke.getOpacity()));
        result.setStrokeWidth(this.getProperties().getStrokeWidth());
        return result;
    }
}

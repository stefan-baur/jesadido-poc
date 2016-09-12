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
        result.setFill(this.getProperties().getFill());
        result.setStroke(this.getProperties().getStroke());
        result.setStrokeWidth(this.getProperties().getStrokeWidth());
        return result;
    }
}

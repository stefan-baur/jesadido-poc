/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.graphics.rags;

import javafx.scene.paint.Color;

public class RagProperties {
    
    private Color fill;
    private Color stroke;
    private double strokeWidth;
    
    public RagProperties(final Color fill, final Color stroke, final double strokeWidth) {
        this.fill = fill;
        this.stroke = stroke;
        this.strokeWidth = strokeWidth;
    }
    
    public Color getFill() {
        return this.fill;
    }
    
    public void setFill(final Color fill) {
        this.fill = fill;
    }
    
    public Color getStroke() {
        return this.stroke;
    }
    
    public void setStroke(final Color stroke) {
        this.stroke = stroke;
    }
    
    public double getStrokeWidth() {
        return this.strokeWidth;
    }
    
    public void setStrokeWidth(final double strokeWidth) {
        this.strokeWidth = strokeWidth;
    }
}

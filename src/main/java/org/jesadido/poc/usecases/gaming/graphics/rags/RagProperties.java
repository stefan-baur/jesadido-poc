/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.graphics.rags;

import org.jesadido.poc.usecases.gaming.graphics.RGBO;

public class RagProperties {
    
    private RGBO fill;
    private RGBO stroke;
    private double strokeWidth;
    
    public RagProperties(final RGBO fill, final RGBO stroke, final double strokeWidth) {
        this.fill = fill;
        this.stroke = stroke;
        this.strokeWidth = strokeWidth;
    }
    
    public RagProperties(final RGBO fill) {
        this(fill, RGBO.TRANSPARENT, 0);
    }
    
    public RGBO getFill() {
        return this.fill;
    }
    
    public void setFill(final RGBO fill) {
        this.fill = fill;
    }
    
    public RGBO getStroke() {
        return this.stroke;
    }
    
    public void setStroke(final RGBO stroke) {
        this.stroke = stroke;
    }
    
    public double getStrokeWidth() {
        return this.strokeWidth;
    }
    
    public void setStrokeWidth(final double strokeWidth) {
        this.strokeWidth = strokeWidth;
    }
}

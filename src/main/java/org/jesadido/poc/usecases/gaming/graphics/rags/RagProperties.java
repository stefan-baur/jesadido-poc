/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.graphics.rags;

import org.jesadido.poc.usecases.gaming.graphics.Rgbo;

public class RagProperties {
    
    private Rgbo fill;
    private Rgbo stroke;
    private double strokeWidth;
    
    public RagProperties(final Rgbo fill, final Rgbo stroke, final double strokeWidth) {
        this.fill = fill;
        this.stroke = stroke;
        this.strokeWidth = strokeWidth;
    }
    
    public RagProperties(final Rgbo fill) {
        this(fill, Rgbo.TRANSPARENT, 0);
    }
    
    public Rgbo getFill() {
        return this.fill;
    }
    
    public void setFill(final Rgbo fill) {
        this.fill = fill;
    }
    
    public Rgbo getStroke() {
        return this.stroke;
    }
    
    public void setStroke(final Rgbo stroke) {
        this.stroke = stroke;
    }
    
    public double getStrokeWidth() {
        return this.strokeWidth;
    }
    
    public void setStrokeWidth(final double strokeWidth) {
        this.strokeWidth = strokeWidth;
    }
}

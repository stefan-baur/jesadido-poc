/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.graphics.rags;

import org.jesadido.poc.usecases.gaming.graphics.RgboColor;

public class RagProperties {
    
    private RgboColor fill;
    private RgboColor stroke;
    private double strokeWidth;
    
    public RagProperties(final RgboColor fill, final RgboColor stroke, final double strokeWidth) {
        this.fill = fill;
        this.stroke = stroke;
        this.strokeWidth = strokeWidth;
    }
    
    public RagProperties(final RgboColor fill) {
        this(fill, RgboColor.TRANSPARENT, 0);
    }
    
    public RgboColor getFill() {
        return this.fill;
    }
    
    public void setFill(final RgboColor fill) {
        this.fill = fill;
    }
    
    public RgboColor getStroke() {
        return this.stroke;
    }
    
    public void setStroke(final RgboColor stroke) {
        this.stroke = stroke;
    }
    
    public double getStrokeWidth() {
        return this.strokeWidth;
    }
    
    public void setStrokeWidth(final double strokeWidth) {
        this.strokeWidth = strokeWidth;
    }
}

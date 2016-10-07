/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.generators.javafx;

import javafx.scene.Group;

public abstract class SizedGroup extends Group {
    
    private final double minWidth;
    private final double minHeight;
    
    private double width;
    private double height;
    
    public SizedGroup(final double minWidth, final double minHeight) {
        this.minWidth = minWidth;
        this.minHeight = minHeight;
        this.width = minWidth;
        this.height = minHeight;
    }
    
    public double getWidth() {
        return this.width;
    }
    
    public void setWidth(final double width) {
        this.width = Math.max(minWidth, width);
    }
    
    public double getHeight() {
        return this.height;
    }
    
    public void setHeight(final double height) {
        this.height = Math.max(minHeight, height);
    }
    
    @Override
    public void resize(final double width, final double height) {
        super.resize(width, height);
        this.setWidth(width);
        this.setHeight(height);
        this.update();
    }
    
    public abstract void update();
}

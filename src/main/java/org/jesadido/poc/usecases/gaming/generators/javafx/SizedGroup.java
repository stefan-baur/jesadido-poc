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
    
    private static final double MIN_WIDTH = 200;
    private static final double MIN_HEIGHT = 160;
    
    private double width = MIN_WIDTH;
    private double height = MIN_HEIGHT;
    
    public double getWidth() {
        return this.width;
    }
    
    public double getHeight() {
        return this.height;
    }
    
    public void setSize(final double width, final double height) {
        this.width = Math.max(MIN_WIDTH, width);
        this.height = Math.max(MIN_HEIGHT, height);
        this.update();
    }
    
    @Override
    public void resize(final double width, final double height) {
        super.resize(width, height);
        this.setSize(width, height);
    }
    
    public abstract void update();
}

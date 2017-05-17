/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.graphics.rags;

public class RagScale extends RagComposite {
    
    private final double scaleX;
    private final double scaleY;
    
    public RagScale(final double scaleX, final double scaleY) {
        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }
    
    public RagScale(final double scale) {
        this(scale, scale);
    }
    
    @Override
    public <R, A> R accept(RagVisitor<R, A> visitor, A argument) {
        return visitor.visit(this, argument);
    }
    
    public double getScaleX() {
        return this.scaleX;
    }
    
    public double getScaleY() {
        return this.scaleY;
    }
}

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.graphics.rags;

public class RagTranslate extends RagComposite {
    
    private final double translateX;
    private final double translateY;
    
    public RagTranslate(final double translateX, final double translateY) {
        this.translateX = translateX;
        this.translateY = translateY;
    }
    
    @Override
    public <R, A> R accept(RagVisitor<R, A> visitor, A argument) {
        return visitor.visit(this, argument);
    }
    
    public double getTranslateX() {
        return this.translateX;
    }
    
    public double getTranslateY() {
        return this.translateY;
    }
}

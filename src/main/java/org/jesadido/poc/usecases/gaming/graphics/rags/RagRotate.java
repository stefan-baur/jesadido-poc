/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.graphics.rags;

public class RagRotate extends RagComposite {
    
    private final double angle;
    
    public RagRotate(final double angle) {
        this.angle = angle;
    }
    
    @Override
    public <R, A> R accept(RagVisitor<R, A> visitor, A argument) {
        return visitor.visit(this, argument);
    }
    
    public double getAngle() {
        return this.angle;
    }
}

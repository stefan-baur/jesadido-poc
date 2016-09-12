/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming;

import javafx.scene.Node;
import org.jesadido.poc.usecases.gaming.graphics.rags.Rag;
import org.jesadido.poc.usecases.gaming.graphics.rags.RagTranslate;

public class Thing {
    
    private final String label;
    private final Rag rawRag;
    private double positionX = 0.0;
    private double positionY = 0.0;
    
    public Thing(final String label, final Rag rawRag) {
        this.label = label;
        this.rawRag = rawRag;
    }
    
    public String getLabel() {
        return this.label;
    }
    
    public Rag getRawRag() {
        return this.rawRag;
    }
    
    public double getPositionX() {
        return this.positionX;
    }
    
    public double getPositionY() {
        return this.positionY;
    }
    
    public void setPosition(final double positionX, final double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }
    
    public Node createJavaFx() {
        return new RagTranslate(this.positionX, this.positionY).add(this.rawRag).createJavaFx();
    }
}

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.graphics;

import java.util.LinkedList;
import java.util.List;
import javafx.scene.Group;
import javafx.scene.Node;

public class Layer {
    
    private final List<Thing> things = new LinkedList<>();
    
    public List<Thing> getThings() {
        return this.things;
    }
    
    public Node createJavaFx() {
        final Group result = new Group();
        this.getThings().stream().forEach(thing -> result.getChildren().add(thing.createJavaFx()));
        return result;
    }
}

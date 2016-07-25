/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.nodes;

public abstract class Node implements Visitable {
    
    private Node parent;
    
    public Node() {}
    
    public boolean hasParent() {
        return this.parent != null;
    }
    
    public Node getParent() {
        return this.parent;
    }
    
    public void setParent(final Node node) {
        this.parent = node;
    }
}

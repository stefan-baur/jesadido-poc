/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tree;

import java.util.LinkedList;
import java.util.List;

public abstract class Node implements Visitable {
    
    private Node parent;
    private final List<Node> children = new LinkedList<>();
    
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
    
    public List<Node> getChildren() {
        return this.children;
    }
    
    public Node addChild(final Node node) {
        if (node != null) {
            this.children.add(node);
            node.setParent(this);
        }
        return this;
    }
    
    public Node addChildren(final List<Node> nodes) {
        if (nodes != null) {
            nodes.stream().forEach(this::addChild);
        }
        return this;
    }
}

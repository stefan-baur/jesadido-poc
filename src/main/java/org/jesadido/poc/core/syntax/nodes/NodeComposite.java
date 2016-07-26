/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.nodes;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class NodeComposite extends Node {
    
    private final List<Node> children = new LinkedList<>();
    private final List<Node> childrenResult = Collections.unmodifiableList(this.children);
    
    public NodeComposite() {}
    
    public final List<Node> getChildren() {
        return this.childrenResult;
    }
    
    public NodeComposite addChild(final Node node) {
        if (node != null) {
            this.children.add(node);
            node.setParent(this);
        }
        return this;
    }
    
    public NodeComposite addChildren(final List<Node> nodes) {
        if (nodes != null) {
            nodes.stream().forEach(this::addChild);
        }
        return this;
    }
}

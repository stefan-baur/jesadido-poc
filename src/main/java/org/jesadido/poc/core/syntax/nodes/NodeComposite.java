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
import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.concepts.ConceptRegistry;

public abstract class NodeComposite extends Node {
    
    private final List<Concept> openers = new LinkedList<>();
    private final List<Concept> openersResult = Collections.unmodifiableList(this.openers);
    
    private final List<Node> children = new LinkedList<>();
    private final List<Node> childrenResult = Collections.unmodifiableList(this.children);
    
    private final List<Concept> closers = new LinkedList<>();
    private final List<Concept> closersResult = Collections.unmodifiableList(this.closers);
    
    public NodeComposite() {}
    
    public final List<Concept> getOpeners() {
        return this.openersResult;
    }
    
    public final List<Node> getChildren() {
        return this.childrenResult;
    }
    
    public final List<Concept> getClosers() {
        return this.closersResult;
    }
    
    public NodeComposite addOpener(final Concept concept, final String defaultConceptPhrase) {
        this.openers.add(concept != null ? concept : ConceptRegistry.getInstance().getConcept(defaultConceptPhrase));
        return this;
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
    
    public NodeComposite addCloser(final Concept concept, final String defaultConceptPhrase) {
        this.closers.add(concept != null ? concept : ConceptRegistry.getInstance().getConcept(defaultConceptPhrase));
        return this;
    }
}

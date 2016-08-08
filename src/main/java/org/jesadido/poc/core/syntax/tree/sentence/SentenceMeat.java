/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tree.sentence;

import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.syntax.tree.Terminal;
import org.jesadido.poc.core.syntax.tree.Node;
import org.jesadido.poc.core.syntax.tree.Visitor;
import org.jesadido.poc.core.syntax.tree.ClapsedNode;

public class SentenceMeat extends ClapsedNode {
    
    private Node conjunction;
    private final List<Node> parts = new LinkedList<>();
    
    public SentenceMeat(final Terminal opener, final Terminal closer) {
        super(opener, closer);
    }
    
    public boolean hasConjunction() {
        return this.conjunction != null;
    }
    
    public Node getConjunction() {
        return this.conjunction;
    }
    
    public SentenceMeat setConjunction(final Node conjunction) {
        this.conjunction = conjunction;
        if (this.conjunction != null) {
            this.setParent(this);
        }
        return this;
    }
    
    public List<Node> getParts() {
        return this.parts;
    }
    
    public SentenceMeat addPart(final Node node) {
        if (node != null) {
            this.parts.add(node);
            node.setParent(this);
        }
        return this;
    }
    
    public SentenceMeat addParts(final List<Node> nodes) {
        if (nodes != null) {
            nodes.stream().forEach(this::addPart);
        }
        return this;
    }
    
    @Override
    public <R, A> R accept(Visitor<R, A> visitor, A argument) {
        return visitor.visit(this, argument);
    }
}

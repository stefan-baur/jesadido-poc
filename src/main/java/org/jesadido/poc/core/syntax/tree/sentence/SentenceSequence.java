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
import org.jesadido.poc.core.syntax.tree.Node;
import org.jesadido.poc.core.syntax.tree.Visitor;

public class SentenceSequence extends Node {
    
    private final List<Node> sentences = new LinkedList<>();
    
    public List<Node> getSentences() {
        return this.sentences;
    }
    
    public Node addSentence(final Node node) {
        if (node != null) {
            this.sentences.add(node);
            node.setParent(this);
        }
        return this;
    }
    
    public Node addSentences(final List<Node> nodes) {
        if (nodes != null) {
            nodes.stream().forEach(this::addSentence);
        }
        return this;
    }
    
    @Override
    public <R, A> R accept(Visitor<R, A> visitor, A argument) {
        return visitor.visit(this, argument);
    }
}

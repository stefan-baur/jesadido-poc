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
import org.jesadido.poc.core.syntax.tree.JesadidoNode;
import org.jesadido.poc.core.syntax.tree.Terminal;
import org.jesadido.poc.core.syntax.tree.Visitor;

public class Sentence extends JesadidoNode {
    
    private final Terminal terminator;
    private final List<JesadidoNode> meats = new LinkedList<>();
    
    public Sentence(final Terminal terminator) {
        this.terminator = terminator;
    }
    
    public Terminal getTerminator() {
        return this.terminator;
    }
    
    public List<JesadidoNode> getMeats() {
        return this.meats;
    }
    
    public JesadidoNode addMeat(final JesadidoNode node) {
        if (node != null) {
            this.meats.add(node);
            node.setParent(this);
        }
        return this;
    }
    
    public JesadidoNode addMeats(final List<JesadidoNode> nodes) {
        if (nodes != null) {
            nodes.stream().forEach(this::addMeat);
        }
        return this;
    }
    
    @Override
    public <R, A> R accept(Visitor<R, A> visitor, A argument) {
        return visitor.visit(this, argument);
    }
}

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

public class SubstantiveSelection extends JesadidoNode {
    
    private final Terminal substantive;
    private final List<JesadidoNode> adjectiveSelections = new LinkedList<>();
    
    public SubstantiveSelection(final Terminal substantive) {
        this.substantive = substantive;
    }
    
    public Terminal getSubstantive() {
        return this.substantive;
    }
    
    public List<JesadidoNode> getAdjectiveSelections() {
        return this.adjectiveSelections;
    }
    
    public SubstantiveSelection addAdjectiveSelection(final JesadidoNode node) {
        if (node != null) {
            this.adjectiveSelections.add(node);
            node.setParent(this);
        }
        return this;
    }
    
    public SubstantiveSelection addAdjectiveSelections(final List<JesadidoNode> nodes) {
        if (nodes != null) {
            nodes.stream().forEach(this::addAdjectiveSelection);
        }
        return this;
    }
    
    @Override
    public <R, A> R accept(Visitor<R, A> visitor, A argument) {
        return visitor.visit(this, argument);
    }
}

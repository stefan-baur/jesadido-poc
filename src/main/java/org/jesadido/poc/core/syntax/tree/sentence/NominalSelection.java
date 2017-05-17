/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tree.sentence;

import org.jesadido.poc.core.syntax.tree.JesadidoNode;
import org.jesadido.poc.core.syntax.tree.Visitor;

public class NominalSelection extends JesadidoNode {
    
    private JesadidoNode childSelection;
    
    public boolean hasChildSelection() {
        return this.childSelection != null;
    }
    
    public JesadidoNode getChildSelection() {
        return this.childSelection;
    }
    
    public NominalSelection setChildSelection(final JesadidoNode childSelection) {
        this.childSelection = childSelection;
        if (this.childSelection != null) {
            this.childSelection.setParent(this);
        }
        return this;
    }
    
    @Override
    public <R, A> R accept(Visitor<R, A> visitor, A argument) {
        return visitor.visit(this, argument);
    }
}

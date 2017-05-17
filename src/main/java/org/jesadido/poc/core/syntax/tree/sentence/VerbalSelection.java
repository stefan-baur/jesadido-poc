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

public class VerbalSelection extends JesadidoNode {
    
    private JesadidoNode verbSelection;
    
    public boolean hasVerbSelection() {
        return this.verbSelection != null;
    }
    
    public JesadidoNode getVerbSelection() {
        return this.verbSelection;
    }
    
    public VerbalSelection setVerbSelection(final JesadidoNode verbSelection) {
        this.verbSelection = verbSelection;
        if (this.verbSelection != null) {
            this.verbSelection.setParent(this);
        }
        return this;
    }
    
    @Override
    public <R, A> R accept(Visitor<R, A> visitor, A argument) {
        return visitor.visit(this, argument);
    }
}

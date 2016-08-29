/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tree;

public abstract class VerbalPartNode extends PartNode {
    
    private Node verbalSelection;
    
    public VerbalPartNode(final Terminal preposition, final Terminal opener, final Terminal closer) {
        super(preposition, opener, closer);
    }
    
    public boolean hasVerbalSelection() {
        return this.verbalSelection != null;
    }
    
    public Node getVerbalSelection() {
        return this.verbalSelection;
    }
    
    public VerbalPartNode setVerbalSelection(final Node verbalSelection) {
        this.verbalSelection = verbalSelection;
        if (this.verbalSelection != null) {
            this.verbalSelection.setParent(this);
        }
        return this;
    }
    
    
    @Override
    public boolean hasChild() {
        return this.hasVerbalSelection();
    }
    
    @Override
    public Node getChild() {
        return this.getVerbalSelection();
    }
}

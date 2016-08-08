/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tree;

public abstract class NominalPartNode extends ClapsedNode {
    
    private final Terminal preposition;
    private Node nominalSelection;
    
    public NominalPartNode(final Terminal preposition, final Terminal opener, final Terminal closer) {
        super(opener, closer);
        this.preposition = preposition;
    }
    
    public Terminal getPreposition() {
        return this.preposition;
    }
    
    public boolean hasNominalSelection() {
        return this.nominalSelection != null;
    }
    
    public Node getNominalSelection() {
        return this.nominalSelection;
    }
    
    public NominalPartNode setNominalSelection(final Node nominalSelection) {
        this.nominalSelection = nominalSelection;
        if (this.nominalSelection != null) {
            this.nominalSelection.setParent(this);
        }
        return this;
    }
}
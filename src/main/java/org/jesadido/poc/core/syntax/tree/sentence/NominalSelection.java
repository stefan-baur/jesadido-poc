/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tree.sentence;

import org.jesadido.poc.core.syntax.tree.Node;
import org.jesadido.poc.core.syntax.tree.Visitor;

public class NominalSelection extends Node {
    
    private Node nominalPhrase;
    
    public boolean hasNominalPhrase() {
        return this.nominalPhrase != null;
    }
    
    public Node getNominalPhrase() {
        return this.nominalPhrase;
    }
    
    public NominalSelection setNominalPhrase(final Node nominalPhrase) {
        this.nominalPhrase = nominalPhrase;
        if (this.nominalPhrase != null) {
            this.nominalPhrase.setParent(this);
        }
        return this;
    }
    
    @Override
    public <R, A> R accept(Visitor<R, A> visitor, A argument) {
        return visitor.visit(this, argument);
    }
}

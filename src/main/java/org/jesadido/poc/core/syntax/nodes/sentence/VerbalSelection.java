/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.nodes.sentence;

import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.syntax.nodes.NodeLeaf;
import org.jesadido.poc.core.syntax.nodes.Visitor;

public class VerbalSelection extends NodeLeaf {
    
    private final Concept verb;
    
    public VerbalSelection(final Concept verb) {
        this.verb = verb;
    }
    
    public Concept getVerb() {
        return this.verb;
    }
    
    @Override
    public <R, A> R accept(Visitor<R, A> visitor, A argument) {
        return visitor.visit(this, argument);
    }
}

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.nodes.composites;

import org.jesadido.poc.core.syntax.Terminal;
import org.jesadido.poc.core.syntax.nodes.NodeComposite;
import org.jesadido.poc.core.syntax.nodes.Visitor;

public class Sentence extends NodeComposite {
    
    private final Terminal terminator;
    
    public Sentence(final Terminal separator) {
        this.terminator = separator;
    }
    
    public Terminal getTerminator() {
        return this.terminator;
    }
    
    @Override
    public <R, A> R accept(Visitor<R, A> visitor, A argument) {
        return visitor.visit(this, argument);
    }
}

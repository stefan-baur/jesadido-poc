/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.nodes.sentence;

import org.jesadido.poc.core.syntax.Terminal;
import org.jesadido.poc.core.syntax.nodes.NodeLeaf;
import org.jesadido.poc.core.syntax.nodes.Visitor;

public class SentenceMeatConjunction extends NodeLeaf {
    
    private final Terminal conjunction;
    
    public SentenceMeatConjunction(final Terminal conjunction) {
        this.conjunction = conjunction;
    }
    
    public Terminal getConjunction() {
        return this.conjunction;
    }
    
    @Override
    public <R, A> R accept(Visitor<R, A> visitor, A argument) {
        return visitor.visit(this, argument);
    }
}

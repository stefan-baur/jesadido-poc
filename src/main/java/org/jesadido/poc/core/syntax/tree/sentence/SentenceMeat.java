/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tree.sentence;

import org.jesadido.poc.core.syntax.tree.Terminal;
import org.jesadido.poc.core.syntax.tree.Node;
import org.jesadido.poc.core.syntax.tree.Visitor;
import org.jesadido.poc.core.syntax.tree.ClapsedNode;

public class SentenceMeat extends ClapsedNode {
    
    private final Node conjunction;
    
    public SentenceMeat(final Node conjunction, final Terminal opener, final Terminal closer) {
        super(opener, closer);
        this.conjunction = conjunction;
    }
    
    public boolean hasConjunction() {
        return this.conjunction != null;
    }
    
    public Node getConjunction() {
        return this.conjunction;
    }
    
    @Override
    public <R, A> R accept(Visitor<R, A> visitor, A argument) {
        return visitor.visit(this, argument);
    }
}

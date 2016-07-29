/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.nodes.sentence;

import org.jesadido.poc.core.syntax.Terminal;
import org.jesadido.poc.core.syntax.nodes.Node;
import org.jesadido.poc.core.syntax.nodes.Visitor;
import org.jesadido.poc.core.syntax.nodes.common.ClapsedNode;

public class SentenceMeat extends ClapsedNode {
    
    private final Node prefix;
    
    public SentenceMeat(final Node prefix, final Terminal opener, final Terminal closer) {
        super(opener, closer);
        this.prefix = prefix;
    }
    
    public boolean hasPrefix() {
        return this.prefix != null;
    }
    
    public Node getPrefix() {
        return this.prefix;
    }
    
    @Override
    public <R, A> R accept(Visitor<R, A> visitor, A argument) {
        return visitor.visit(this, argument);
    }
}

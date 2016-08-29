/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tree;

public abstract class PartNode extends ClapsedNode {
    
    private final Terminal preposition;
    
    public PartNode(final Terminal preposition, final Terminal opener, final Terminal closer) {
        super(opener, closer);
        this.preposition = preposition;
    }
    
    public Terminal getPreposition() {
        return this.preposition;
    }
    
    public abstract boolean hasChild();
    
    public abstract Node getChild();
}

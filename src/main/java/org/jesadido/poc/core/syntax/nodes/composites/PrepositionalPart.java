/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.nodes.composites;

import org.jesadido.poc.core.syntax.Terminal;

public abstract class PrepositionalPart extends ClapsedElement {
    
    private final Terminal preposition;
    
    public PrepositionalPart(final Terminal preposition, final Terminal opener, final Terminal closer) {
        super(opener, closer);
        this.preposition = preposition;
    }
    
    public Terminal getPreposition() {
        return this.preposition;
    }
}

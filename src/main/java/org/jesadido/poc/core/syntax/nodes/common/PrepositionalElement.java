/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.nodes.common;

import org.jesadido.poc.core.syntax.nodes.common.ClapsedElement;
import org.jesadido.poc.core.syntax.Terminal;

public abstract class PrepositionalElement extends ClapsedElement {
    
    private final Terminal preposition;
    
    public PrepositionalElement(final Terminal preposition, final Terminal opener, final Terminal closer) {
        super(opener, closer);
        this.preposition = preposition;
    }
    
    public Terminal getPreposition() {
        return this.preposition;
    }
}

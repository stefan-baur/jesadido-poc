/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.nodes.common;

import org.jesadido.poc.core.syntax.Terminal;
import org.jesadido.poc.core.syntax.nodes.NodeComposite;

public abstract class ClapsedNode extends NodeComposite {
    
    private final Terminal opener;
    private final Terminal closer;
    
    public ClapsedNode(final Terminal opener, final Terminal closer) {
        this.opener = opener;
        this.closer = closer;
    }
    
    public Terminal getOpener() {
        return this.opener;
    }
    
    public Terminal getCloser() {
        return this.closer;
    }
}

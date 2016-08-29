/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics;

import org.jesadido.poc.core.syntax.tree.sentence.PartAl;
import org.jesadido.poc.core.syntax.tree.sentence.PartDom;
import org.jesadido.poc.core.syntax.tree.sentence.PartFin;
import org.jesadido.poc.core.syntax.tree.sentence.PartSu;

public enum Part {
    
    SU(PartSu.class),
    DOM(PartDom.class),
    AL(PartAl.class),
    FIN(PartFin.class);
    
    private final Class partClass;
    
    private Part(final Class partClass) {
        this.partClass = partClass;
    }
    
    public Class getPartClass() {
        return this.partClass;
    }
}

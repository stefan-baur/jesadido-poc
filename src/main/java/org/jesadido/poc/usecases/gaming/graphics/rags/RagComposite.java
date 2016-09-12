/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.graphics.rags;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class RagComposite implements Rag {
    
    private final List<Rag> rags = new LinkedList<>();
    
    public List<Rag> getRags() {
        return this.rags;
    }
    
    public RagComposite add(final Rag ... rags) {
        this.rags.addAll(Arrays.asList(rags));
        return this;
    }
}

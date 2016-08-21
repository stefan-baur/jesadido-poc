/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics;

import org.jesadido.poc.core.syntax.tree.Node;

public class TranslatingResultLeaf extends TranslatingResult {
    
    private String translation = "";
    
    public TranslatingResultLeaf(final Node node) {
        super(node);
    }
    
    @Override
    public String getTranslation() {
        return this.translation;
    }
    
    public void setTranslation(final String translation) {
        this.translation = translation;
    }
}

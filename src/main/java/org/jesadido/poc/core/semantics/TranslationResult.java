/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics;

import org.jesadido.poc.core.syntax.tree.Node;

public class TranslationResult {
    
    private final Node node;
    private String translation = "";
    
    public TranslationResult(final Node node) {
        this.node = node;
    }
    
    public Node getNode() {
        return this.node;
    }
    
    public boolean hasTranslation() {
        return this.getTranslation().length() > 0;
    }
    
    public String getTranslation() {
        return this.translation;
    }
    
    public TranslationResult setTranslation(final String translation) {
        this.translation = translation;
        return this;
    }
}

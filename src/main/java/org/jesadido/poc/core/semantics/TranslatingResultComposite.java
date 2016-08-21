/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics;

import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.syntax.tree.Node;

public class TranslatingResultComposite extends TranslatingResult {
    
    private final List<TranslatingResult> children = new LinkedList<>();
    
    public TranslatingResultComposite(final Node node) {
        super(node);
    }
    
    public void addChild(final TranslatingResult child) {
        this.children.add(child);
    }
    
    @Override
    public String getTranslation() {
        StringBuilder result = new StringBuilder();
        this.children.stream().forEach(translatingResult -> result.append(translatingResult.getTranslation()));
        return result.toString();
    }
}

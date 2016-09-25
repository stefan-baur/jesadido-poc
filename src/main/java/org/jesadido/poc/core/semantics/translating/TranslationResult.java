/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating;

import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.StringUtils;
import org.jesadido.poc.core.syntax.tree.Node;
import org.jesadido.poc.core.syntax.tree.TroubleNode;

public class TranslationResult {
    
    private final Node node;
    private String translation = "";
    private final List<TroubleNode> parsingTroubles = new LinkedList<>();
    private final List<String> constraintsTroubles = new LinkedList<>();
    
    public TranslationResult(final Node node) {
        this.node = node;
    }
    
    public Node getNode() {
        return this.node;
    }
    
    public boolean hasTranslation() {
        return this.translation != null &&  this.translation.length() > 0;
    }
    
    public String getTranslation() {
        return this.translation;
    }
    
    public TranslationResult setTranslation(final String ... translations) {
        this.translation = String.join(" ", translations);
        return this;
    }
    
    public TranslationResult setTranslation(final List<String> translations) {
        this.translation = StringUtils.join(" ", translations);
        return this;
    }
    
    public boolean hasTroubles() {
        return this.hasParsingTroubles() || this.hasConstraintsTroubles();
    }
    
    public boolean hasParsingTroubles() {
        return !this.parsingTroubles.isEmpty();
    }
    
    public List<TroubleNode> getParsingTroubles() {
        return this.parsingTroubles;
    }
    
    public void addParsingTroubles(final List<TroubleNode> troubles) {
        this.parsingTroubles.addAll(troubles);
    }
    
    public boolean hasConstraintsTroubles() {
        return !this.constraintsTroubles.isEmpty();
    }
    
    public List<String> getConstraintsTroubles() {
        return this.constraintsTroubles;
    }
    
    public void addConstraintsTroubles(final List<String> troubles) {
        this.constraintsTroubles.addAll(troubles);
    }
}

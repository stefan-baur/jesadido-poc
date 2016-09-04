/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tree.sentence;

import org.jesadido.poc.core.syntax.tree.Node;
import org.jesadido.poc.core.syntax.tree.Terminal;
import org.jesadido.poc.core.syntax.tree.Visitor;

public class ArticleSelection extends Node {
    
    private final Terminal article;
    private Node substantiveSelection;
    
    public ArticleSelection(final Terminal article) {
        this.article = article;
    }
    
    public Terminal getArticle() {
        return this.article;
    }
    
    public boolean hasSubstantiveSelection() {
        return this.substantiveSelection != null;
    }
    
    public Node getSubstantiveSelection() {
        return this.substantiveSelection;
    }
    
    public ArticleSelection setSubstantiveSelection(final Node substantiveSelection) {
        this.substantiveSelection = substantiveSelection;
        if (this.substantiveSelection != null) {
            this.substantiveSelection.setParent(this);
        }
        return this;
    }
    
    @Override
    public <R, A> R accept(Visitor<R, A> visitor, A argument) {
        return visitor.visit(this, argument);
    }
}

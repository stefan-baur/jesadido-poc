/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class ProductionComposite extends Production {
    
    private final List<Production> children = new LinkedList<>();
    private final List<Production> publicChildren = Collections.unmodifiableList(this.children);
    
    public ProductionComposite(final String nonterminalSymbol) {
        super(nonterminalSymbol);
    }
    
    public List<Production> getChildren() {
        return this.publicChildren;
    }
    
    public boolean addChild(Production childProduction) {
        if (this.getNonterminalSymbol().equals(childProduction.getNonterminalSymbol())) {
            this.children.add(childProduction);
            this.invalidate();
            return true;
        }
        return false;
    }
    
    public abstract void invalidate();
    
    @Override
    public void setGrammar(final Grammar grammar) {
        super.setGrammar(grammar);
        this.children.stream().forEach(child -> child.setGrammar(grammar));
    }
}

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tree;

import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.scripting.Src;
import org.jesadido.poc.core.syntax.tree.visitors.Plotter;
import org.jesadido.poc.core.syntax.tree.visitors.PrettyPrinter;
import org.jesadido.poc.core.syntax.tree.visitors.TerminalCollector;
import org.jesadido.poc.core.syntax.tree.visitors.TroubleCollector;

public abstract class Node implements Visitable {
    
    private Node parent;
    
    public boolean hasParent() {
        return this.parent != null;
    }
    
    public Node getParent() {
        return this.parent;
    }
    
    public void setParent(final Node node) {
        this.parent = node;
    }
    
    public boolean objectOf(final Class clazz) {
        return this.getClass() == clazz;
    }
    
    public List<Concept> collectConcepts() {
        List<Concept> result = new LinkedList<>();
        this.collectTerminals().stream().filter(terminal -> terminal.hasConcept()).forEach(terminal -> result.add(terminal.getConcept()));
        return result;
    }
    
    public List<Terminal> collectTerminals() {
        return TerminalCollector.collect(this);
    }
    
    public List<TroubleNode> collectTroubles() {
        return TroubleCollector.collect(this);
    }
    
    public Src plot() {
        return Plotter.plot(this);
    }
    
    public Src prettyPrint() {
        return PrettyPrinter.print(this);
    }
}

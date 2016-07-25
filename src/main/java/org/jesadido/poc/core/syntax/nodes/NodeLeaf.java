/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.nodes;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.concepts.ConceptRegistry;

public abstract class NodeLeaf extends Node {
    
    private final List<Concept> terminals = new LinkedList<>();
    private final List<Concept> terminalsResult = Collections.unmodifiableList(this.terminals);
    
    public NodeLeaf() {}
    
    public final List<Concept> getTerminals() {
        return this.terminalsResult;
    }
    
    public NodeLeaf addTerminal(final Concept concept, final String defaultConceptPhrase) {
        this.terminals.add(concept != null ? concept : ConceptRegistry.getInstance().getConcept(defaultConceptPhrase));
        return this;
    }
}

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
import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.syntax.tree.Terminal;

public class TransletParameters {
    
    private final Object caseAttribute;
    private final List<Terminal> terminals;
    
    public TransletParameters(final Object caseAttibute, final List<Terminal> terminals) {
        this.caseAttribute = caseAttibute;
        this.terminals = terminals;
    }
    
    public TransletParameters(final List<Terminal> terminals) {
        this(null, terminals);
    }
    
    public Object getCaseAttribute() {
        return this.caseAttribute;
    }
    
    public List<Terminal> getTerminals() {
        return this.terminals;
    }
    
    public Terminal getTerminal(final int index) {
        return this.terminals.get(index);
    }
    
    public List<Concept> getConcepts() {
        final List<Concept> result = new LinkedList<>();
        this.terminals.stream().forEach(terminal -> result.add(terminal.getConcept()));
        return result;
    }
    
    public Concept getConcept(final int index) {
        return this.getTerminal(index).getConcept();
    }
}

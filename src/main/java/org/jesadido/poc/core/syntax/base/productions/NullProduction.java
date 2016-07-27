/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.base.productions;

import java.util.LinkedList;
import org.jesadido.poc.core.syntax.Production;
import org.jesadido.poc.core.syntax.nodes.Node;
import org.jesadido.poc.core.syntax.tokens.TokenStream;

public class NullProduction extends Production {
    
    public NullProduction(final String nonterminalSymbol) {
        super(nonterminalSymbol, new LinkedList<>(), new LinkedList<>());
    }
    
    @Override
    public Node parse(final TokenStream tokenStream) {
        return this.getGrammar().getSyntaxTreeFactory().createTrouble(String.format("The production of '%s' is not available, the current token is '%s'.", this.getNonterminalSymbol(), tokenStream.peek()));
    }
}

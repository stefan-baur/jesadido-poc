/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.productions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.syntax.Nonterminal;
import org.jesadido.poc.core.syntax.tree.JesadidoNode;
import org.jesadido.poc.core.syntax.tokens.TokenStream;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public class ProductionDummy extends ProductionLeaf {
    
    private static final List<TokenType> NO_TERMINALS = new LinkedList<>();
    private static final List<Nonterminal> NO_NONTERMINALS = new LinkedList<>();
    
    public ProductionDummy(final Nonterminal nonterminalSymbol) {
        super(nonterminalSymbol, NO_TERMINALS, NO_NONTERMINALS);
    }
    
    @Override
    public List<String> getRules() {
        return Arrays.asList(
                String.format("%s ::= IMPOSSIBLE", this.getNonterminalSymbol())
        );
    }
    
    @Override
    public List<TokenType> getFirsts() {
        return NO_TERMINALS;
    }
    
    @Override
    public JesadidoNode parse(final TokenStream tokenStream) {
        return this.getGrammar().getSyntaxTreeFactory().createTrouble(String.format("The production of '%s' is not available, the current token is '%s'.", this.getNonterminalSymbol(), tokenStream.peek()));
    }
}

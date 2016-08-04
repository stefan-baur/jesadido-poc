/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.productions;

import java.util.List;
import org.jesadido.poc.core.syntax.Nonterminal;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public abstract class ProductionLeaf extends Production {
    
    private final List<TokenType> usedTerminalSymbols;
    private final List<Nonterminal> usedNonterminalSymbols;
    
    public ProductionLeaf(final Nonterminal nonterminalSymbol, final List<TokenType> usedTerminalSymbols, final List<Nonterminal> usedNonterminalSymbols) {
        super(nonterminalSymbol);
        this.usedTerminalSymbols = usedTerminalSymbols;
        this.usedNonterminalSymbols = usedNonterminalSymbols;
    }
    
    @Override
    public List<TokenType> getUsedTerminalSymbols() {
        return this.usedTerminalSymbols;
    }
    
    @Override
    public List<Nonterminal> getUsedNonterminalSymbols() {
        return this.usedNonterminalSymbols;
    }
}

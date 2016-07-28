/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax;

import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public abstract class ProductionLeaf extends Production {
    
    private final List<TokenType> usedTerminalSymbols;
    private final List<String> usedNonterminalSymbols;
    
    public ProductionLeaf(final String nonterminalSymbol, final List<TokenType> usedTerminalSymbols, final List<String> usedNonterminalSymbols) {
        super(nonterminalSymbol);
        this.usedTerminalSymbols = usedTerminalSymbols;
        this.usedNonterminalSymbols = usedNonterminalSymbols;
    }
    
    @Override
    public List<TokenType> getUsedTerminalSymbols() {
        return this.usedTerminalSymbols;
    }
    
    @Override
    public List<String> getUsedNonterminalSymbols() {
        return this.usedNonterminalSymbols;
    }
}

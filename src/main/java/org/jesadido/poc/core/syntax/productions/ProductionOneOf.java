/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.productions;

import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.StringUtils;
import org.jesadido.poc.core.syntax.Nonterminal;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public abstract class ProductionOneOf extends ProductionLeaf {
    
    private List<TokenType> firsts = null;
    
    public ProductionOneOf(final Nonterminal nonterminalSymbol, final List<TokenType> usedTerminalSymbols, final List<Nonterminal> usedNonterminalSymbols) {
        super(nonterminalSymbol, usedTerminalSymbols, usedNonterminalSymbols);
    }
    
    @Override
    public List<String> getRules() {
        List<String> result = new LinkedList<>();
        if (!this.getUsedTerminalSymbols().isEmpty()) {
            result.add(String.format("%s ::= %s", this.getNonterminalSymbol(), StringUtils.join(" | ", this.getUsedTerminalSymbols())));
        }
        if (!this.getUsedNonterminalSymbols().isEmpty()) {
            result.add(String.format("%s ::= %s", this.getNonterminalSymbol(), StringUtils.join(" | ", this.getUsedNonterminalSymbols())));
        }
        return result;
    }
    
    @Override
    public List<TokenType> getFirsts() {
        if (this.firsts == null) {
            this.firsts = new LinkedList<>();
            this.firsts.addAll(this.getUsedTerminalSymbols());
            this.getUsedNonterminalSymbols().stream().forEach(nonterminal -> this.firsts.addAll(this.getFirsts(nonterminal)));
        }
        return this.firsts;
    }
}

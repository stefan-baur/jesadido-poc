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
import org.jesadido.poc.core.syntax.Nonterminal;
import org.jesadido.poc.core.syntax.nodes.Node;
import org.jesadido.poc.core.syntax.tokens.TokenStream;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public class ProductionAlternatives extends ProductionComposite {
    
    private final List<String> rules = new LinkedList<>();
    private final List<TokenType> usedTerminalSymbols = new LinkedList<>();
    private final List<Nonterminal> usedNonterminalSymbols = new LinkedList<>();
    private List<TokenType> firsts = null;
    
    public ProductionAlternatives(final Nonterminal nonterminalSymbol) {
        super(nonterminalSymbol);
    }
    
    @Override
    public void invalidate() {
        this.rules.clear();
        this.usedTerminalSymbols.clear();
        this.usedNonterminalSymbols.clear();
        this.firsts = null;
        this.getChildren().stream().forEach(child -> {
            this.rules.addAll(child.getRules());
            this.usedTerminalSymbols.removeAll(child.getUsedTerminalSymbols());
            this.usedTerminalSymbols.addAll(child.getUsedTerminalSymbols());
            this.usedNonterminalSymbols.removeAll(child.getUsedNonterminalSymbols());
            this.usedNonterminalSymbols.addAll(child.getUsedNonterminalSymbols());
        });
    }
    
    @Override
    public List<String> getRules() {
        return this.rules;
    }
    
    @Override
    public List<TokenType> getUsedTerminalSymbols() {
        return this.usedTerminalSymbols;
    }
    
    @Override
    public List<Nonterminal> getUsedNonterminalSymbols() {
        return this.usedNonterminalSymbols;
    }
    
    @Override
    public List<TokenType> getFirsts() {
        if (this.firsts == null) {
            this.firsts = new LinkedList<>();
            this.getChildren().stream().forEach(child -> this.firsts.addAll(child.getFirsts()));
        }
        return this.firsts;
    }
    
    @Override
    public Node parse(final TokenStream tokenStream) {
        for (final Production child : this.getChildren()) {
            if (tokenStream.hasOneOf(child.getFirsts())) {
                return child.parse(tokenStream);
            }
        }
        return this.parsingTrouble(tokenStream);
    }
}

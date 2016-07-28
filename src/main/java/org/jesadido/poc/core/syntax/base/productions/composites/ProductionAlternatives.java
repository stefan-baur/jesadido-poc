/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.base.productions.composites;

import java.util.LinkedList;
import org.jesadido.poc.core.syntax.*;
import java.util.List;
import org.jesadido.poc.core.syntax.nodes.Node;
import org.jesadido.poc.core.syntax.tokens.TokenStream;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public class ProductionAlternatives extends ProductionComposite {
    
    private final List<String> bnfs = new LinkedList<>();
    private final List<TokenType> usedTerminalSymbols = new LinkedList<>();
    private final List<String> usedNonterminalSymbols = new LinkedList<>();
    private final List<TokenType> firstSet = new LinkedList<>();
    
    public ProductionAlternatives(final String nonterminalSymbol) {
        super(nonterminalSymbol);
    }
    
    @Override
    public void invalidate() {
        this.bnfs.clear();
        this.usedTerminalSymbols.clear();
        this.usedNonterminalSymbols.clear();
        this.firstSet.clear();
        this.getChildren().stream().forEach(child -> {
            this.bnfs.addAll(child.getBnfs());
            this.usedTerminalSymbols.removeAll(child.getUsedTerminalSymbols());
            this.usedTerminalSymbols.addAll(child.getUsedTerminalSymbols());
            this.usedNonterminalSymbols.removeAll(child.getUsedNonterminalSymbols());
            this.usedNonterminalSymbols.addAll(child.getUsedNonterminalSymbols());
            this.firstSet.removeAll(child.getFirstSet());
            this.firstSet.addAll(child.getFirstSet());
        });
    }
    
    @Override
    public List<String> getBnfs() {
        return this.bnfs;
    }
    
    @Override
    public List<TokenType> getUsedTerminalSymbols() {
        return this.usedTerminalSymbols;
    }
    
    @Override
    public List<String> getUsedNonterminalSymbols() {
        return this.usedNonterminalSymbols;
    }
    
    @Override
    public List<TokenType> getFirstSet() {
        return this.firstSet;
    }
    
    @Override
    public Node parse(final TokenStream tokenStream) {
        for (final Production child : this.getChildren()) {
            if (this.hasFirstOf(tokenStream, child.getNonterminalSymbol())) {
                return child.parse(tokenStream);
            }
        }
        return this.parsingTrouble(tokenStream);
    }
}

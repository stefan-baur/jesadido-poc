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
    
    private List<String> bnfs = null;
    private List<TokenType> usedTerminalSymbols = null;
    private List<String> usedNonterminalSymbols = null;
    private List<TokenType> firstSet = null;
    
    public ProductionAlternatives(final String nonterminalSymbol) {
        super(nonterminalSymbol);
    }
    
    @Override
    public void invalidate() {
        this.bnfs = null;
        this.usedTerminalSymbols = null;
        this.usedNonterminalSymbols = null;
        this.firstSet = null;
    }
    
    @Override
    public List<String> getBnfs() {
        if (this.bnfs == null) {
            this.bnfs = new LinkedList<>();
            this.getChildren().stream().forEach(child -> this.bnfs.addAll(child.getBnfs()));
        }
        return this.bnfs;
    }
    
    @Override
    public List<TokenType> getUsedTerminalSymbols() {
        if (this.usedTerminalSymbols == null) {
            this.usedTerminalSymbols = new LinkedList<>();
            this.getChildren().stream().forEach(child -> {
                this.usedTerminalSymbols.removeAll(child.getUsedTerminalSymbols());
                this.usedTerminalSymbols.addAll(child.getUsedTerminalSymbols());
            });
        }
        return this.usedTerminalSymbols;
    }
    
    @Override
    public List<String> getUsedNonterminalSymbols() {
        if (this.usedNonterminalSymbols == null) {
            this.usedNonterminalSymbols = new LinkedList<>();
            this.getChildren().stream().forEach(child -> {
                this.usedNonterminalSymbols.removeAll(child.getUsedNonterminalSymbols());
                this.usedNonterminalSymbols.addAll(child.getUsedNonterminalSymbols());
            });
        }
        return this.usedNonterminalSymbols;
    }
    
    @Override
    public List<TokenType> getFirstSet() {
        if (this.firstSet == null) {
            this.firstSet = new LinkedList<>();
            this.getChildren().stream().forEach(child -> {
                this.firstSet.removeAll(child.getFirstSet());
                this.firstSet.addAll(child.getFirstSet());
            });
        }
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

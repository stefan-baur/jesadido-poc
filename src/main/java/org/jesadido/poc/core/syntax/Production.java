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
import org.jesadido.poc.core.syntax.nodes.Node;
import org.jesadido.poc.core.syntax.tokens.TokenStream;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public class Production {
    
    private static final List<TokenType> FIRST_SET = new LinkedList<>();
    
    private final String nonterminalSymbol;
    private final List<TokenType> usedTerminalSymbols;
    private final List<String> usedNonterminalSymbols;
    
    private Grammar grammar;
    
    public Production(final String nonterminalSymbol, final List<TokenType> usedTerminalSymbols, final List<String> usedNonterminalSymbols) {
        this.nonterminalSymbol = nonterminalSymbol;
        this.usedTerminalSymbols = usedTerminalSymbols;
        this.usedNonterminalSymbols = usedNonterminalSymbols;
    }
    
    public Grammar getGrammar() {
        return this.grammar;
    }
    
    public void setGrammar(Grammar grammar) {
        this.grammar = grammar;
    }
    
    public String getNonterminalSymbol() {
        return this.nonterminalSymbol;
    }
    
    public List<TokenType> getUsedTerminalSymbols() {
        return this.usedTerminalSymbols;
    }
    
    public List<String> getUsedNonterminalSymbols() {
        return this.usedNonterminalSymbols;
    }
    
    public List<TokenType> getFirstSet() {
        return FIRST_SET;
    }
    
    public Node parse(final TokenStream tokenStream) {
        return this.grammar.getSyntaxTreeFactory().createTrouble(String.format("The production '%s' is not available [Token: %s].", this.nonterminalSymbol, tokenStream.peek()));
    }
}

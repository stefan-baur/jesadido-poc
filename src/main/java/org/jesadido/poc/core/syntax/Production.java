/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax;

import java.util.List;
import org.jesadido.poc.core.syntax.base.productions.leaves.ProductionDummy;
import org.jesadido.poc.core.syntax.nodes.Node;
import org.jesadido.poc.core.syntax.tokens.TokenStream;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public abstract class Production {
    
    private final String nonterminalSymbol;
    private Grammar grammar;
    
    public Production(final String nonterminalSymbol) {
        this.nonterminalSymbol = nonterminalSymbol;
    }
    
    public Grammar getGrammar() {
        return this.grammar;
    }
    
    public void setGrammar(final Grammar grammar) {
        this.grammar = grammar;
    }
    
    public String getNonterminalSymbol() {
        return this.nonterminalSymbol;
    }
    
    public abstract List<String> getBnfs();
    
    public abstract List<TokenType> getUsedTerminalSymbols();
    
    public abstract List<String> getUsedNonterminalSymbols();
    
    public Production getProduction(final String nonterminalSymbol) {
        if (this.grammar.getProductionRules().containsKey(nonterminalSymbol)) {
            return this.grammar.getProductionRules().get(nonterminalSymbol);
        }
        return new ProductionDummy(nonterminalSymbol);
    }
    
    public abstract List<TokenType> getFirstSet();
    
    public abstract Node parse(final TokenStream tokenStream);
    
    public boolean hasFirstOf(final TokenStream tokenStream, final String ... nonterminalSymbols) {
        for (final String nt : nonterminalSymbols) {
            if (tokenStream.hasOneOf(this.getProduction(nt).getFirstSet())) {
                return true;
            }
        }
        return false;
    }
    
    public Node parse(final TokenStream tokenStream, final String nonterminalSymbol) {
        return this.getProduction(nonterminalSymbol).parse(tokenStream);
    }
    
    public Node parsingTrouble(final TokenStream tokenStream, final TokenType requiredTokenType) {
        return this.grammar.getSyntaxTreeFactory().createTrouble(String.format("The required token type '%s' is not available inside the production of '%s', but '%s' is found instead.", requiredTokenType, this.getNonterminalSymbol(), tokenStream.peek()));
    }
    
    public Node parsingTrouble(final TokenStream tokenStream) {
        return this.grammar.getSyntaxTreeFactory().createTrouble(String.format("The production of '%s' can not be parsed at the token '%s'.", this.getNonterminalSymbol(), tokenStream.peek()));
    }
}

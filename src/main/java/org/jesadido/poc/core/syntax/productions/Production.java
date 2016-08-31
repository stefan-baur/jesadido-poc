/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.productions;

import java.util.List;
import java.util.Map;
import org.jesadido.poc.core.syntax.Grammar;
import org.jesadido.poc.core.syntax.Nonterminal;
import org.jesadido.poc.core.syntax.tokens.Token;
import org.jesadido.poc.core.syntax.tree.Node;
import org.jesadido.poc.core.syntax.tokens.TokenStream;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public abstract class Production {
    
    private final Nonterminal nonterminalSymbol;
    private Grammar grammar;
    
    public Production(final Nonterminal nonterminalSymbol) {
        this.nonterminalSymbol = nonterminalSymbol;
    }
    
    public Grammar getGrammar() {
        return this.grammar;
    }
    
    public void setGrammar(final Grammar grammar) {
        this.grammar = grammar;
    }
    
    public Nonterminal getNonterminalSymbol() {
        return this.nonterminalSymbol;
    }
    
    public abstract List<String> getRules();
    
    public abstract List<TokenType> getUsedTerminalSymbols();
    
    public abstract List<Nonterminal> getUsedNonterminalSymbols();
    
    private Production getProduction(final Nonterminal nonterminalSymbol) {
        final Map<Nonterminal, Production> productions = this.grammar.getProductionRules();
        if (productions.containsKey(nonterminalSymbol)) {
            return productions.get(nonterminalSymbol);
        }
        return new ProductionDummy(nonterminalSymbol);
    }
    
    public abstract List<TokenType> getFirsts();
    
    public abstract Node parse(final TokenStream tokenStream);
    
    public List<TokenType> getFirsts(final Nonterminal nonterminalSymbol) {
        return this.getProduction(nonterminalSymbol).getFirsts();
    }
    
    public boolean hasFirstOf(final TokenStream tokenStream, final Nonterminal ... nonterminalSymbols) {
        for (final Nonterminal nt : nonterminalSymbols) {
            if (tokenStream.hasOneOf(this.getProduction(nt).getFirsts())) {
                return true;
            }
        }
        return false;
    }
    
    public Token createToken(final TokenType tokenType) {
        return this.getGrammar().getTokenCreator().create(tokenType);
    }
    
    public Node parse(final TokenStream tokenStream, final Nonterminal nonterminalSymbol) {
        return this.getProduction(nonterminalSymbol).parse(tokenStream);
    }
    
    public Node parsingTrouble(final TokenStream tokenStream, final TokenType requiredTokenType) {
        return this.grammar.getSyntaxTreeFactory().createTrouble(String.format("The required token type '%s' is not available inside the production of '%s', but '%s' is found instead.", requiredTokenType, this.getNonterminalSymbol(), tokenStream.peek()));
    }
    
    public Node parsingTrouble(final TokenStream tokenStream) {
        return this.grammar.getSyntaxTreeFactory().createTrouble(String.format("The production of '%s' can not be parsed at the token '%s'.", this.getNonterminalSymbol(), tokenStream.peek()));
    }
}

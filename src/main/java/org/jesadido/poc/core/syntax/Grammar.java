/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jesadido.poc.core.StringUtils;
import org.jesadido.poc.core.scripting.Src;
import org.jesadido.poc.core.syntax.nodes.Node;
import org.jesadido.poc.core.syntax.productions.Production;
import org.jesadido.poc.core.syntax.productions.ProductionAlternatives;
import org.jesadido.poc.core.syntax.tokens.TokenCreator;
import org.jesadido.poc.core.syntax.tokens.TokenStream;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public class Grammar {
    
    private static final Logger LOGGER = Logger.getLogger(Grammar.class.getName());
    
    private final String name;
    private final TokenCreator tokenCreator;
    private final SyntaxTreeFactory syntaxTreeFactory;
    
    private final List<String> nonterminals = new LinkedList<>();
    private final List<TokenType> terminals = new LinkedList<>();
    private final Map<String, Production> productions = new HashMap<>();
    private String startSymbol = null;
    
    public Grammar(final String name, final TokenCreator tokenCreator, final SyntaxTreeFactory syntaxTreeFactory) {
        this.name = name;
        this.tokenCreator = tokenCreator;
        this.syntaxTreeFactory = syntaxTreeFactory;
    }
    
    public String getName() {
        return this.name;
    }
    
    public TokenCreator getTokenCreator() {
        return this.tokenCreator;
    }
    
    public SyntaxTreeFactory getSyntaxTreeFactory() {
        return this.syntaxTreeFactory;
    }
    
    public List<String> getNonterminalSymbols() {
        return this.nonterminals;
    }
    
    public List<TokenType> getTerminalSymbols() {
        return this.terminals;
    }
    
    public Map<String, Production> getProductionRules() {
        return this.productions;
    }
    
    public String getStartSymbol() {
        return this.startSymbol;
    }
    
    public Grammar register(final boolean start, final Production production) {
        if (this.tokenCreator.getSupportedTokenTypes().containsAll(production.getUsedTerminalSymbols()) && this.nonterminals.containsAll(production.getUsedNonterminalSymbols())) {
            Production newProduction = production;
            if (this.productions.containsKey(production.getNonterminalSymbol())) {
                ProductionAlternatives productionAlternatives = new ProductionAlternatives(production.getNonterminalSymbol());
                productionAlternatives.addChild(this.productions.get(production.getNonterminalSymbol()));
                productionAlternatives.addChild(production);
                newProduction = productionAlternatives;
            }
            this.productions.put(newProduction.getNonterminalSymbol(), newProduction);
            newProduction.setGrammar(this);
            this.terminals.removeAll(newProduction.getUsedTerminalSymbols());
            this.terminals.addAll(newProduction.getUsedTerminalSymbols());
            this.nonterminals.remove(newProduction.getNonterminalSymbol());
            this.nonterminals.add(newProduction.getNonterminalSymbol());
            if (start) {
                this.startSymbol = newProduction.getNonterminalSymbol();
            }
            return this;
        }
        throw new IllegalArgumentException(String.format("A production can not registered to the grammar '%s'.", this.name));
    }
    
    public Node parse(final String source, final String startSymbol) {
        return this.parse(new TokenStream(source, this.tokenCreator), startSymbol);
    }
    
    public Node parse(final String source) {
        return this.parse(source, this.startSymbol);
    }
    
    public Node parse(final InputStream source, final String startSymbol) {
        try (TokenStream tokenStream = new TokenStream(source, this.tokenCreator)) {
            return this.parse(tokenStream, startSymbol);
        } catch (IOException exception) {
            LOGGER.log(Level.WARNING, "An I/O-exception after the parsing.", exception);
            return this.syntaxTreeFactory.createTrouble(exception.getMessage());
        }
    }
    
    public Node parse(final InputStream source) {
        return this.parse(source, this.startSymbol);
    }
    
    private Node parse(final TokenStream tokenStream, final String startSymbol) {
        if (this.productions.containsKey(startSymbol)) {
            return this.productions.get(startSymbol).parse(tokenStream);
        } else {
            return this.syntaxTreeFactory.createTrouble(String.format("No production available for the start-symbol '%s'.", startSymbol));
        }
    }
    
    public Src toPlot() {
        Src srcProductionRules = new Src();
        List<String> rules = new LinkedList<>();
        this.productions.values().stream().forEach(production -> rules.addAll(production.getRules()));
        final int max = rules.size() - 1;
        for (int i = 0; i < rules.size(); i++) {
            srcProductionRules.line("%s%s", rules.get(i), i < max ? "," : "");
        }
        return new Src()
                .begin("Grammar %s = (N, T, P, s) = (", this.name)
                .begin("{")
                .line(String.join(", ", this.nonterminals))
                .endBegin("}, {")
                .line(StringUtils.join(", ", this.terminals))
                .endBegin("}, {")
                .add(srcProductionRules)
                .end("}, %s", this.startSymbol)
                .end(")")
                ;
    }
    
    @Override
    public String toString() {
        return this.toPlot().toString();
    }
}

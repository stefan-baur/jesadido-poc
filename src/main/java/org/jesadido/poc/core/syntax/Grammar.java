/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax;

import org.jesadido.poc.core.syntax.tree.SyntaxTreeFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jesadido.poc.core.StringUtils;
import org.jesadido.poc.core.scripting.Src;
import org.jesadido.poc.core.syntax.tree.Node;
import org.jesadido.poc.core.syntax.productions.Production;
import org.jesadido.poc.core.syntax.productions.ProductionAlternatives;
import org.jesadido.poc.core.syntax.tokens.TokenCreator;
import org.jesadido.poc.core.syntax.tokens.TokenStream;
import org.jesadido.poc.core.syntax.tokens.TokenType;

/**
 * This <code>Grammar</code> class implements a common description of a formal
 * (context-free) grammar (N, T, P, s). You can get an overview of a
 * grammar-instance by plotting a BNF-slanged grammar. A grammar-instance can be
 * used to parse the source to a syntax-tree. You can define a new grammar by
 * registering your productions.
 */
public class Grammar {
    
    private static final Logger LOGGER = Logger.getLogger(Grammar.class.getName());
    
    private final String name;
    private final TokenCreator tokenCreator;
    private final SyntaxTreeFactory syntaxTreeFactory;
    
    private final List<Nonterminal> nonterminals = new LinkedList<>();
    private final List<TokenType> terminals = new LinkedList<>();
    private final Map<Nonterminal, Production> productions = new EnumMap<>(Nonterminal.class);
    private Nonterminal startSymbol = null;
    
    /**
     * Constructor. Use the <code>GrammarFactory</code> for creating a new
     * grammar-instance.
     * @param name The name of the grammar.
     * @param tokenCreator The token-creator maps each element of the
     * token-stream to a token during the parsing process.
     * @param syntaxTreeFactory The factory for the syntax-tree, creating the
     * nodes of the tree.
     */
    public Grammar(final String name, final TokenCreator tokenCreator, final SyntaxTreeFactory syntaxTreeFactory) {
        this.name = name;
        this.tokenCreator = tokenCreator;
        this.syntaxTreeFactory = syntaxTreeFactory;
    }
    
    /**
     * Returns the name of this grammar.
     * @return The name.
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Returns the used token-creator for the parsing process.
     * @return The token-creator.
     */
    public TokenCreator getTokenCreator() {
        return this.tokenCreator;
    }
    
    /**
     * Returns the factory for creating the nodes of the syntax-tree.
     * @return The syntax-tree-factory.
     */
    public SyntaxTreeFactory getSyntaxTreeFactory() {
        return this.syntaxTreeFactory;
    }
    
    /**
     * Returns a list of the used nonterminal-symbols.
     * @return The nonterminal-symbols of this grammar.
     */
    public List<Nonterminal> getNonterminalSymbols() {
        return this.nonterminals;
    }
    
    /**
     * Returns a list of the used terminal-symbols.
     * @return The terminal-symbols of this grammar.
     */
    public List<TokenType> getTerminalSymbols() {
        return this.terminals;
    }
    
    /**
     * Returns the production-rules mapped by nonterminal-symbols.
     * @return The production-rules of this grammar.
     */
    public Map<Nonterminal, Production> getProductionRules() {
        return this.productions;
    }
    
    /**
     * Returns the start-symbol of this grammar.
     * @return The start-symbol, which can be <code>null</code>.
     */
    public Nonterminal getStartSymbol() {
        return this.startSymbol;
    }
    
    /**
     * Registers a new production-rule instance to the production-rules of this
     * grammar. A new production-rule can only registered, if the used
     * terminal-symbols and the used nonterminal-symbols are already provided by
     * this grammar. If there is already a production with the same
     * nonterminal-symbol registered, the new production will be added as an
     * alternative production.
     * @param start <code>true</code> if the nonterminal-symbol of the new
     * production should by used as start-symbol for this grammar.
     * @param production The new production.
     * @return This grammar-instance for method-chaining.
     */
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
    
    /**
     * Parses the given source under the given start-symbol.
     * @param source The source.
     * @param startSymbol The start-symbol.
     * @return The root-node of the accepted syntax-tree.
     */
    public Node parse(final String source, final Nonterminal startSymbol) {
        return this.parse(new TokenStream(source, this.tokenCreator), startSymbol);
    }
    
    /**
     * Parses the given source under the start-symbol of this grammar.
     * @param source The source.
     * @return The root-node of the accepted syntax-tree.
     */
    public Node parse(final String source) {
        return this.parse(source, this.startSymbol);
    }
    
    /**
     * Parses the given source under the given start-symbol.
     * @param source The source.
     * @param startSymbol The start-symbol.
     * @return The root-node of the accepted syntax-tree.
     */
    public Node parse(final InputStream source, final Nonterminal startSymbol) {
        try (TokenStream tokenStream = new TokenStream(source, this.tokenCreator)) {
            return this.parse(tokenStream, startSymbol);
        } catch (IOException exception) {
            LOGGER.log(Level.WARNING, "An I/O-exception after the parsing.", exception);
            return this.syntaxTreeFactory.createTrouble(exception.getMessage());
        }
    }
    
    /**
     * Parses the given source under the start-symbol of this grammar.
     * @param source The source.
     * @return The root-node of the accepted syntax-tree.
     */
    public Node parse(final InputStream source) {
        return this.parse(source, this.startSymbol);
    }
    
    private Node parse(final TokenStream tokenStream, final Nonterminal startSymbol) {
        if (this.productions.containsKey(startSymbol)) {
            return this.productions.get(startSymbol).parse(tokenStream);
        } else {
            return this.syntaxTreeFactory.createTrouble(String.format("No production is available for the start-symbol '%s'.", startSymbol));
        }
    }
    
    /**
     * Returns the whole description of this grammar.
     * @return The grammar-desciption.
     */
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
                .line(StringUtils.join(", ", this.nonterminals))
                .endBegin("}, {")
                .line(StringUtils.join(", ", this.terminals))
                .endBegin("}, {")
                .add(srcProductionRules)
                .end("}, %s", this.startSymbol)
                .end(")")
                ;
    }
    
    /**
     * Returns the plot of this grammar.
     * @return The string-formated plot.
     */
    @Override
    public String toString() {
        return this.toPlot().toString();
    }
}

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax;

import org.jesadido.poc.core.concepts.ConceptUtils;
import org.jesadido.poc.core.scripting.Src;
import org.jesadido.poc.core.syntax.productions.Production;
import org.jesadido.poc.core.syntax.productions.sentence.SentenceMeatConjunctionProduction;
import org.jesadido.poc.core.syntax.tokens.TokenCreator;
import org.jesadido.poc.core.syntax.tree.Node;
import org.jesadido.poc.core.syntax.tree.SyntaxTreeFactory;
import org.junit.Assert;
import org.junit.Test;

public class GrammarTest {
    
    @Test
    public void testGetName() {
        Assert.assertEquals("NullGrammar", new Grammar("NullGrammar", null, null).getName());
        Assert.assertEquals("NoProductionsGrammar", new Grammar("NoProductionsGrammar", new TokenCreator(), new SyntaxTreeFactory()).getName());
    }
    
    @Test
    public void testGetTokenCreator() {
        Assert.assertNull(new Grammar("NullGrammar", null, null).getTokenCreator());
        Assert.assertNotNull(new Grammar("NoProductionsGrammar", new TokenCreator(), new SyntaxTreeFactory()).getTokenCreator());
    }
    
    @Test
    public void testGetSyntaxTreeFactory() {
        Assert.assertNull(new Grammar("NullGrammar", null, null).getSyntaxTreeFactory());
        Assert.assertNotNull(new Grammar("NoProductionsGrammar", new TokenCreator(), new SyntaxTreeFactory()).getSyntaxTreeFactory());
    }
    
    @Test
    public void testGetNonterminalSymbols() {
        Assert.assertTrue(new Grammar("NullGrammar", null, null).getNonterminalSymbols().isEmpty());
        Assert.assertTrue(new Grammar("NoProductionsGrammar", new TokenCreator(), new SyntaxTreeFactory()).getNonterminalSymbols().isEmpty());
        Assert.assertFalse(new Grammar("ConjunctionGrammar", new TokenCreator(), new SyntaxTreeFactory()).register(true, new SentenceMeatConjunctionProduction()).getNonterminalSymbols().isEmpty());
    }
    
    @Test
    public void testGetTerminalSymbols() {
        Assert.assertTrue(new Grammar("NullGrammar", null, null).getTerminalSymbols().isEmpty());
        Assert.assertTrue(new Grammar("NoProductionsGrammar", new TokenCreator(), new SyntaxTreeFactory()).getTerminalSymbols().isEmpty());
        Assert.assertFalse(new Grammar("ConjunctionGrammar", new TokenCreator(), new SyntaxTreeFactory()).register(true, new SentenceMeatConjunctionProduction()).getTerminalSymbols().isEmpty());
    }
    
    @Test
    public void testGetProductionRules() {
        Assert.assertTrue(new Grammar("NullGrammar", null, null).getProductionRules().isEmpty());
        Assert.assertTrue(new Grammar("NoProductionsGrammar", new TokenCreator(), new SyntaxTreeFactory()).getProductionRules().isEmpty());
        Assert.assertFalse(new Grammar("ConjunctionGrammar", new TokenCreator(), new SyntaxTreeFactory()).register(true, new SentenceMeatConjunctionProduction()).getProductionRules().isEmpty());
    }
    
    @Test
    public void testGetStartSymbol() {
        Assert.assertNull(new Grammar("NullGrammar", null, null).getStartSymbol());
        Assert.assertNull(new Grammar("NoProductionsGrammar", new TokenCreator(), new SyntaxTreeFactory()).getStartSymbol());
        Assert.assertNull(new Grammar("ConjunctionGrammar", new TokenCreator(), new SyntaxTreeFactory()).register(false, new SentenceMeatConjunctionProduction()).getStartSymbol());
        Assert.assertNotNull(new Grammar("ConjunctionGrammar", new TokenCreator(), new SyntaxTreeFactory()).register(true, new SentenceMeatConjunctionProduction()).getStartSymbol());
        Assert.assertNotNull(new Grammar("Conjunction2Grammar", new TokenCreator(), new SyntaxTreeFactory()).register(true, new SentenceMeatConjunctionProduction()).register(false, new SentenceMeatConjunctionProduction()).getStartSymbol());
    }
    
    @Test
    public void testRegister() {
        final Production conjunction = new SentenceMeatConjunctionProduction();
        final Grammar conjunctionGrammar = new Grammar("ConjunctionGrammar", new TokenCreator(), new SyntaxTreeFactory()).register(false, conjunction);
        Assert.assertNull(conjunctionGrammar.getStartSymbol());
        Assert.assertFalse(conjunctionGrammar.getProductionRules().isEmpty());
        Assert.assertEquals(conjunction, conjunctionGrammar.getProductionRules().get(conjunction.getNonterminalSymbol()));
        conjunctionGrammar.register(true, conjunction);
        Assert.assertEquals(conjunction.getNonterminalSymbol(), conjunctionGrammar.getStartSymbol());
        Assert.assertNotEquals(conjunction, conjunctionGrammar.getProductionRules().get(conjunction.getNonterminalSymbol()));
    }
    
    @Test
    public void testParse() {
        final Production conjunctionProduction = new SentenceMeatConjunctionProduction();
        final Grammar grammar = new Grammar("ConjunctionGrammar", new TokenCreator(), new SyntaxTreeFactory()).register(false, conjunctionProduction);
        {
            final Node node = grammar.parse("Kaj");
            Assert.assertEquals("", ConceptUtils.join(node.collectConcepts()));
        }
        {
            final Node conjunction = grammar.parse("Kaj", conjunctionProduction.getNonterminalSymbol());
            Assert.assertEquals("Kaj", ConceptUtils.join(conjunction.collectConcepts()));
        }
        {
            final Node conjunction = grammar.parse("Aux$,", conjunctionProduction.getNonterminalSymbol());
            Assert.assertEquals("Aux$,", ConceptUtils.join(conjunction.collectConcepts()));
        }
        grammar.register(true, conjunctionProduction);
        {
            final Node conjunction = grammar.parse("Kaj");
            Assert.assertEquals("Kaj", ConceptUtils.join(conjunction.collectConcepts()));
        }
        {
            final Node conjunction = grammar.parse("Aux$,");
            Assert.assertEquals("Aux$,", ConceptUtils.join(conjunction.collectConcepts()));
        }
    }
    
    @Test
    public void testToPlot() {
        final Grammar grammar = new Grammar("PlotTest", new TokenCreator(), new SyntaxTreeFactory()).register(true, new SentenceMeatConjunctionProduction());
        final Src plotSrc = grammar.toPlot();
        Assert.assertEquals("Grammar PlotTest = (N, T, P, s) = (\r\n\t{\r\n\t\tsentence-meat-conjunction\r\n\t}, {\r\n\t\tSEPARATOR_SE, SEPARATOR_KAJ, SEPARATOR_AUX, SEPARATOR\r\n\t}, {\r\n\t\tsentence-meat-conjunction ::= SEPARATOR_SE | SEPARATOR_KAJ | SEPARATOR_AUX | SEPARATOR\r\n\t}, sentence-meat-conjunction\r\n)\r\n", plotSrc.toString());
    }
}

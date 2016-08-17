/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tree.visitors;

import org.jesadido.poc.core.syntax.Grammar;
import org.jesadido.poc.core.syntax.GrammarFactory;
import org.jesadido.poc.core.syntax.Nonterminal;
import org.junit.Assert;
import org.junit.Test;

public class PrettyPrinterTest {
    
    @Test
    public void testAcceptPrettyPrintWithSentence() {
        final Grammar grammar = new GrammarFactory().createJesadidoGrammar();
        {
            final String pp = PrettyPrinter.print(grammar.parse("HeroO .", Nonterminal.SENTENCE)).toString();
            Assert.assertNotNull(pp);
            Assert.assertTrue(pp.length() > 0);
            Assert.assertEquals("{\r\n\tSu (\r\n\t\tHeroO\r\n\t)\r\n}\r\n.\r\n", pp);
            final String pppp = PrettyPrinter.print(grammar.parse(pp, Nonterminal.SENTENCE)).toString();
            Assert.assertEquals(pp, pppp);
        }
        {
            final String pp = PrettyPrinter.print(grammar.parse("TrovAs HeroIcxO Fin SkribIlO .", Nonterminal.SENTENCE)).toString();
            Assert.assertNotNull(pp);
            Assert.assertTrue(pp.length() > 0);
            final String pppp = PrettyPrinter.print(grammar.parse(pp, Nonterminal.SENTENCE)).toString();
            Assert.assertEquals(pp, pppp);
        }
        {
            final String pp = PrettyPrinter.print(grammar.parse("Fin SkribIlO DonAs HeroIcxO Al HeroInO .", Nonterminal.SENTENCE)).toString();
            Assert.assertNotNull(pp);
            Assert.assertTrue(pp.length() > 0);
            final String pppp = PrettyPrinter.print(grammar.parse(pp, Nonterminal.SENTENCE)).toString();
            Assert.assertEquals(pp, pppp);
        }
        {
            final String pp = PrettyPrinter.print(grammar.parse("HeroIcxO TrovAs Fin SkribIlO Kaj HeroIcxO DonAs TestO$Al HeroInO Fin SkribIlO .", Nonterminal.SENTENCE)).toString();
            Assert.assertNotNull(pp);
            Assert.assertTrue(pp.length() > 0);
            final String pppp = PrettyPrinter.print(grammar.parse(pp, Nonterminal.SENTENCE)).toString();
            Assert.assertEquals(pp, pppp);
        }
        {
            final String pp = PrettyPrinter.print(grammar.parse("{\n\tHeroIcxO TrovAs Fin SkribIlO\n} Kaj {\n\tHeroIcxO DonAs Al HeroInO Fin SkribIlO\n} .", Nonterminal.SENTENCE)).toString();
            Assert.assertNotNull(pp);
            Assert.assertTrue(pp.length() > 0);
            final String pppp = PrettyPrinter.print(grammar.parse(pp, Nonterminal.SENTENCE)).toString();
            Assert.assertEquals(pp, pppp);
        }
        {
            final String pp = PrettyPrinter.print(grammar.parse("{\n\tTestO$Su ( HeroIcxO )\n\tDom ( TrovAntAs )\n\tFin ( SkribIlO )\n} Kaj {\n\tSu ( HeroIcxO )\n\tDom ( DonAs )\n\tAl ( HeroInO )\n\tFin ( SkribIlO )\n} .", Nonterminal.SENTENCE)).toString();
            Assert.assertNotNull(pp);
            Assert.assertTrue(pp.length() > 0);
            final String pppp = PrettyPrinter.print(grammar.parse(pp, Nonterminal.SENTENCE)).toString();
            Assert.assertEquals(pp, pppp);
        }
        {
            final String pp = PrettyPrinter.print(grammar.parse("HeroIcxO DonAs Al HeroInO Fin FlorO Se HeroIcxO TrovAs Fin FlorO .", Nonterminal.SENTENCE)).toString();
            Assert.assertNotNull(pp);
            Assert.assertTrue(pp.length() > 0);
            final String pppp = PrettyPrinter.print(grammar.parse(pp, Nonterminal.SENTENCE)).toString();
            Assert.assertEquals(pp, pppp);
        }
        {
            final String pp = PrettyPrinter.print(grammar.parse("Se HeroIcxO TrovAs Fin FlorO { HeroIcxO DonAs Al HeroInO Fin FlorO } .", Nonterminal.SENTENCE)).toString();
            Assert.assertNotNull(pp);
            Assert.assertTrue(pp.length() > 0);
            final String pppp = PrettyPrinter.print(grammar.parse(pp, Nonterminal.SENTENCE)).toString();
            Assert.assertEquals(pp, pppp);
        }
        {
            final String pp = PrettyPrinter.print(grammar.parse("Se { HeroIcxO TrovAs Fin FlorO } { HeroIcxO DonAs Al HeroInO Fin FlorO } .", Nonterminal.SENTENCE)).toString();
            Assert.assertNotNull(pp);
            Assert.assertTrue(pp.length() > 0);
            final String pppp = PrettyPrinter.print(grammar.parse(pp, Nonterminal.SENTENCE)).toString();
            Assert.assertEquals(pp, pppp);
        }
    }
}

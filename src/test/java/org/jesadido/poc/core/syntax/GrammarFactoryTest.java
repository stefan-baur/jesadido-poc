/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax;

import org.jesadido.poc.core.concepts.ConceptUtils;
import org.jesadido.poc.core.syntax.tokens.TokenType;
import org.jesadido.poc.core.syntax.tree.JesadidoNode;
import org.junit.Assert;
import org.junit.Test;

public class GrammarFactoryTest {
    
    @Test
    public void testCreateJesadidoGrammar() {
        final Grammar grammar = GrammarFactory.createJesadidoGrammar();
        Assert.assertEquals("jesadido-grammar", grammar.getKey());
        Assert.assertEquals(Nonterminal.SENTENCE_SEQUENCE, grammar.getStartSymbol());
        Assert.assertFalse(grammar.getNonterminalSymbols().isEmpty());
        Assert.assertTrue(grammar.getNonterminalSymbols().contains(Nonterminal.SENTENCE_SEQUENCE));
        Assert.assertTrue(grammar.getNonterminalSymbols().contains(Nonterminal.SENTENCE));
        Assert.assertTrue(grammar.getNonterminalSymbols().contains(Nonterminal.PART_SU));
        Assert.assertFalse(grammar.getTerminalSymbols().isEmpty());
        Assert.assertTrue(grammar.getTerminalSymbols().contains(TokenType.SUBSTANTIVE_SINGULAR));
        Assert.assertFalse(grammar.getProductionRules().isEmpty());
        Assert.assertNotNull(grammar.getProductionRules().get(Nonterminal.SENTENCE_SEQUENCE));
        Assert.assertNotNull(grammar.getTokenCreator());
        Assert.assertNotNull(grammar.getSyntaxTreeFactory());
        {
            final JesadidoNode sentence = grammar.parse("{ Su ( HeroO ) Dom ( HavAs ) Fin ( SkribIlO ) } .", Nonterminal.SENTENCE);
            Assert.assertEquals("{ Su ( HeroO ) Dom ( HavAs ) Fin ( SkribIlO ) } .", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final JesadidoNode sentence = grammar.parse("{ Su ( HeroO ) } X.", Nonterminal.SENTENCE);
            Assert.assertEquals("{ Su ( HeroO ) } X.", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final JesadidoNode sentence = grammar.parse("{ Su ( HeroO ) } K", Nonterminal.SENTENCE);
            Assert.assertEquals("", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final JesadidoNode sentence = grammar.parse("\t{ Su ( HeroO ) }    .", Nonterminal.SENTENCE);
            Assert.assertEquals("{ Su ( HeroO ) } .", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final JesadidoNode sentence = grammar.parse("{ Su ( HeroInO ) } Kaj { Su ( HeroIcxO ) } .", Nonterminal.SENTENCE);
            Assert.assertEquals("{ Su ( HeroInO ) } Kaj { Su ( HeroIcxO ) } .", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final JesadidoNode sentence = grammar.parse("{ Su ( HeroO ) } Aux$, { Su ( HeroInO ) } Aux { Su ( HeroIcxO ) } .", Nonterminal.SENTENCE);
            Assert.assertEquals("{ Su ( HeroO ) } Aux$, { Su ( HeroInO ) } Aux { Su ( HeroIcxO ) } .", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final JesadidoNode sentence = grammar.parse("{ Su ( HeroIcxO ) } Aux$, { Su ( HeroInO ) } Aux { .", Nonterminal.SENTENCE);
            Assert.assertEquals("{ Su ( HeroIcxO ) } Aux$, { Su ( HeroInO ) } .", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final JesadidoNode sentence = grammar.parse("Kaj { Su ( HeroO ) } { Dom ( HavAs ) Su ( TestO ) } Aux { Su ( HeroInO ) } .", Nonterminal.SENTENCE);
            Assert.assertEquals("Kaj { Su ( HeroO ) } { Dom ( HavAs ) Su ( TestO ) } Aux { Su ( HeroInO ) } .", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final JesadidoNode sentence = grammar.parse("{ Su ( TestIcxO ) } { Su ( TestInO ) } .", Nonterminal.SENTENCE);
            Assert.assertEquals("{ Su ( TestIcxO ) } { Su ( TestInO ) } .", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final JesadidoNode sentenceMeat = grammar.parse("{ Su ( TestO ) }", Nonterminal.SENTENCE_MEAT);
            Assert.assertEquals("{ Su ( TestO ) }", ConceptUtils.join(sentenceMeat.collectConcepts()));
        }
        {
            final JesadidoNode sentenceMeatConjunction = grammar.parse("Kaj", Nonterminal.SENTENCE_MEAT_CONJUNCTION);
            Assert.assertEquals("Kaj", ConceptUtils.join(sentenceMeatConjunction.collectConcepts()));
        }
        {
            final JesadidoNode sentence = grammar.parse("Se { Su ( TestO ) } { Dom ( HavAs ) } .", Nonterminal.SENTENCE);
            Assert.assertEquals("Se { Su ( TestO ) } { Dom ( HavAs ) } .", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final JesadidoNode sentence = grammar.parse("Aux Su ( HeroO ) Dom ( HavAs ) .", Nonterminal.SENTENCE);
            Assert.assertEquals("Aux { Su ( HeroO ) Dom ( HavAs ) } .", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final JesadidoNode sentence = grammar.parse("Su ( HeroO ) Dom ( HavAs ) Fin ( SkribIlO ) .", Nonterminal.SENTENCE);
            Assert.assertEquals("{ Su ( HeroO ) Dom ( HavAs ) Fin ( SkribIlO ) } .", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final JesadidoNode sentence = grammar.parse("Aux ( HeroO ) Dom ( HavAs ) .", Nonterminal.SENTENCE);
            Assert.assertEquals("Aux { Su ( HeroO ) Dom ( HavAs ) } .", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final JesadidoNode sentence = grammar.parse("HeroO HavAs Fin SkribIlO .", Nonterminal.SENTENCE);
            Assert.assertEquals("{ Su ( HeroO ) Dom ( HavAs ) Fin ( SkribIlO ) } .", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final JesadidoNode sentence = grammar.parse("Kaj Fin SkribIlO Dom HavAs HeroO .", Nonterminal.SENTENCE);
            Assert.assertEquals("Kaj { Fin ( SkribIlO ) Dom ( HavAs ) Su ( HeroO ) } .", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final JesadidoNode sentence = grammar.parse("( HeroO ) Kaj Fin ( SkribIlO ) Dom ( HavAs ) ( HeroO ) .", Nonterminal.SENTENCE);
            Assert.assertEquals("{ Su ( HeroO ) } Kaj { Fin ( SkribIlO ) Dom ( HavAs ) Su ( HeroO ) } .", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final JesadidoNode sentence = grammar.parse("HeroIcxO DonAs Al HeroInO Fin SkribIlO .", Nonterminal.SENTENCE);
            Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( DonAs ) Al ( HeroInO ) Fin ( SkribIlO ) } .", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final JesadidoNode partAl = grammar.parse("Al HeroO", Nonterminal.PART_AL);
            Assert.assertEquals("Al ( HeroO )", ConceptUtils.join(partAl.collectConcepts()));
        }
        {
            final JesadidoNode sentenceSequence = grammar.parse("HeroIcxO TrovAs Fin SkribIlO . HeroIcxO DonAs Al HeroInO Fin SkribIlO .", Nonterminal.SENTENCE_SEQUENCE);
            Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( TrovAs ) Fin ( SkribIlO ) } . { Su ( HeroIcxO ) Dom ( DonAs ) Al ( HeroInO ) Fin ( SkribIlO ) } .", ConceptUtils.join(sentenceSequence.collectConcepts()));
        }
    }
}

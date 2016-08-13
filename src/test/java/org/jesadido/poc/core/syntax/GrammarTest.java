/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax;

import org.jesadido.poc.core.concepts.ConceptUtils;
import org.jesadido.poc.core.syntax.tree.Node;
import org.jesadido.poc.core.syntax.tree.visitors.ConceptCollector;
import org.junit.Assert;
import org.junit.Test;

public class GrammarTest {
    
    @Test
    public void testCreateBitOfParsing() {
        {
            final Grammar grammar = new GrammarFactory().createJesadidoGrammar();
            {
                Node sentence = grammar.parse("{ Su ( HeroO ) Dom ( HavAs ) Fin ( SkribIlO ) } .", Nonterminal.SENTENCE);
                Assert.assertEquals("{ Su ( HeroO ) Dom ( HavAs ) Fin ( SkribIlO ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("{ Su ( HeroO ) } X.", Nonterminal.SENTENCE);
                Assert.assertEquals("{ Su ( HeroO ) } X.", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("{ Su ( HeroO ) } K", Nonterminal.SENTENCE);
                Assert.assertEquals("", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("\t{ Su ( HeroO ) }    .", Nonterminal.SENTENCE);
                Assert.assertEquals("{ Su ( HeroO ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("{ Su ( HeroInO ) } Kaj { Su ( HeroIcxO ) } .", Nonterminal.SENTENCE);
                Assert.assertEquals("{ Su ( HeroInO ) } Kaj { Su ( HeroIcxO ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("{ Su ( HeroO ) } Aux$, { Su ( HeroInO ) } Aux { Su ( HeroIcxO ) } .", Nonterminal.SENTENCE);
                Assert.assertEquals("{ Su ( HeroO ) } Aux$, { Su ( HeroInO ) } Aux { Su ( HeroIcxO ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("{ Su ( HeroIcxO ) } Aux$, { Su ( HeroInO ) } Aux { .", Nonterminal.SENTENCE);
                Assert.assertEquals("{ Su ( HeroIcxO ) } Aux$, { Su ( HeroInO ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("Kaj { Su ( HeroO ) } { Dom ( HavAs ) Su ( TestO ) } Aux { Su ( HeroInO ) } .", Nonterminal.SENTENCE);
                Assert.assertEquals("Kaj { Su ( HeroO ) } { Dom ( HavAs ) Su ( TestO ) } Aux { Su ( HeroInO ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("{ Su ( TestIcxO ) } { Su ( TestInO ) } .", Nonterminal.SENTENCE);
                Assert.assertEquals("{ Su ( TestIcxO ) } { Su ( TestInO ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("{ Su ( TestO ) }", Nonterminal.SENTENCE_MEAT);
                Assert.assertEquals("{ Su ( TestO ) }", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("Kaj", Nonterminal.SENTENCE_MEAT_CONJUNCTION);
                Assert.assertEquals("Kaj", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("Se { Su ( TestO ) } { Dom ( HavAs ) } .", Nonterminal.SENTENCE);
                Assert.assertEquals("Se { Su ( TestO ) } { Dom ( HavAs ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("Aux Su ( HeroO ) Dom ( HavAs ) .", Nonterminal.SENTENCE);
                Assert.assertEquals("Aux { Su ( HeroO ) Dom ( HavAs ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("Su ( HeroO ) Dom ( HavAs ) Fin ( SkribIlO ) .", Nonterminal.SENTENCE);
                Assert.assertEquals("{ Su ( HeroO ) Dom ( HavAs ) Fin ( SkribIlO ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("Aux ( HeroO ) Dom ( HavAs ) .", Nonterminal.SENTENCE);
                Assert.assertEquals("Aux { Su ( HeroO ) Dom ( HavAs ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("HeroO HavAs Fin SkribIlO .", Nonterminal.SENTENCE);
                Assert.assertEquals("{ Su ( HeroO ) Dom ( HavAs ) Fin ( SkribIlO ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("Kaj Fin SkribIlO Dom HavAs HeroO .", Nonterminal.SENTENCE);
                Assert.assertEquals("Kaj { Fin ( SkribIlO ) Dom ( HavAs ) Su ( HeroO ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("( HeroO ) Kaj Fin ( SkribIlO ) Dom ( HavAs ) ( HeroO ) .", Nonterminal.SENTENCE);
                Assert.assertEquals("{ Su ( HeroO ) } Kaj { Fin ( SkribIlO ) Dom ( HavAs ) Su ( HeroO ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("HeroIcxO DonAs Al HeroInO Fin SkribIlO .", Nonterminal.SENTENCE);
                Assert.assertEquals("{ Su ( HeroIcxO ) Dom ( DonAs ) Al ( HeroInO ) Fin ( SkribIlO ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("Al HeroO", Nonterminal.PART_AL);
                Assert.assertEquals("Al ( HeroO )", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
        }
    }
}

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
            final Grammar grammar = new GrammarFactory().createDefaultGrammar("TestGrammar");
            {
                Node sentence = grammar.parse("{ Su ( HeroO ) Dom ( HavAs ) Fin ( ) } .");
                Assert.assertEquals("{ Su ( HeroO ) Dom ( HavAs ) Fin ( ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("{ Su ( HeroO ) } X.");
                Assert.assertEquals("{ Su ( HeroO ) } X.", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("{ Su ( HeroO ) } K");
                Assert.assertEquals("", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("\t{ Su ( HeroO ) }    .");
                Assert.assertEquals("{ Su ( HeroO ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("{ Su ( HeroInO ) } Kaj { Su ( HeroIcxO ) } .");
                Assert.assertEquals("{ Su ( HeroInO ) } Kaj { Su ( HeroIcxO ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("{ Su ( HeroO ) } Aux$, { Su ( HeroInO ) } Aux { Su ( HeroIcxO ) } .");
                Assert.assertEquals("{ Su ( HeroO ) } Aux$, { Su ( HeroInO ) } Aux { Su ( HeroIcxO ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("{ Su ( HeroIcxO ) } Aux$, { Su ( HeroInO ) } Aux { .");
                Assert.assertEquals("{ Su ( HeroIcxO ) } Aux$, { Su ( HeroInO ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("Kaj { Su ( HeroO ) } { Dom ( HavAs ) Su ( TestO ) } Aux { Su ( HeroInO ) } .");
                Assert.assertEquals("Kaj { Su ( HeroO ) } { Dom ( HavAs ) Su ( TestO ) } Aux { Su ( HeroInO ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("{ Su ( TestIcxO ) } { Su ( TestInO ) } .");
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
                Node sentence = grammar.parse("Se { Su ( TestO ) } { Dom ( HavAs ) } .");
                Assert.assertEquals("Se { Su ( TestO ) } { Dom ( HavAs ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("Aux Su ( HeroO ) Dom ( HavAs ) .");
                Assert.assertEquals("Aux { Su ( HeroO ) Dom ( HavAs ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("Su ( HeroO ) Dom ( HavAs ) Fin ( ) .");
                Assert.assertEquals("{ Su ( HeroO ) Dom ( HavAs ) Fin ( ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("Aux ( HeroO ) Dom ( HavAs ) .");
                Assert.assertEquals("Aux { Su ( HeroO ) Dom ( HavAs ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("HeroO HavAs Fin ( ) .");
                Assert.assertEquals("{ Su ( HeroO ) Dom ( HavAs ) Fin ( ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("Kaj Fin ( ) Dom HavAs HeroO .");
                Assert.assertEquals("Kaj { Fin ( ) Dom ( HavAs ) Su ( HeroO ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("( HeroO ) Kaj Fin ( ) Dom ( HavAs ) ( SkribIlO ) .");
                Assert.assertEquals("{ Su ( HeroO ) } Kaj { Fin ( ) Dom ( HavAs ) Su ( SkribIlO ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
        }
    }
}

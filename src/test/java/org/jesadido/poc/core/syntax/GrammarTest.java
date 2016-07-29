/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax;

import org.jesadido.poc.core.concepts.ConceptUtils;
import org.jesadido.poc.core.syntax.base.Base;
import org.jesadido.poc.core.syntax.nodes.Node;
import org.jesadido.poc.core.syntax.nodes.visitors.ConceptCollector;
import org.junit.Assert;
import org.junit.Test;

public class GrammarTest {
    
    @Test
    public void testCreateBitOfParsing() {
        {
            final Grammar grammar = new GrammarFactory().createBaseGrammar("TestGrammar");
            {
                Node sentence = grammar.parse("{ Su ( ) } .");
                Assert.assertEquals("{ Su ( ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("{ Su ( ) } X.");
                Assert.assertEquals("{ Su ( ) } X.", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("{ Su ( ) } K");
                Assert.assertEquals("", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("\t{ Su ( ) }    .");
                Assert.assertEquals("{ Su ( ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("{ Su ( ) } Kaj { Su ( ) } .");
                Assert.assertEquals("{ Su ( ) } Kaj { Su ( ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("{ Su ( ) } Aux$, { Su ( ) } Aux { Su ( ) } .");
                Assert.assertEquals("{ Su ( ) } Aux$, { Su ( ) } Aux { Su ( ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("{ Su ( ) } Aux$, { Su ( ) } Aux { .");
                Assert.assertEquals("{ Su ( ) } Aux$, { Su ( ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("{ Su ( ) } { Su ( ) } Aux { Su ( ) } .");
                Assert.assertEquals("{ Su ( ) } { Su ( ) } Aux { Su ( ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("{ Su ( ) } { Su ( ) } .");
                Assert.assertEquals("{ Su ( ) } { Su ( ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("{ Su ( ) }", Base.NT_SENTENCE_MEAT);
                Assert.assertEquals("{ Su ( ) }", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("Kaj", Base.NT_SENTENCE_MEAT_PREFIX);
                Assert.assertEquals("Kaj", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("Se { Su ( ) } { Su ( ) } .");
                Assert.assertEquals("Se { Su ( ) } { Su ( ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
        }
    }
}

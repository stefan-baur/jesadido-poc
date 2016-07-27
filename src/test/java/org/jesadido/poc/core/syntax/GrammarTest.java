/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax;

import org.jesadido.poc.core.concepts.ConceptUtils;
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
                Node sentence = grammar.parse("{ } .");
                Assert.assertEquals("{ } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("{ } X.");
                Assert.assertEquals("{ } X.", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("{ } K");
                Assert.assertEquals("", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
            {
                Node sentence = grammar.parse("\t{ }    .");
                Assert.assertEquals("{ } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
            }
        }
    }
}
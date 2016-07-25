/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.nodes.visitors;

import java.util.Arrays;
import org.jesadido.poc.core.concepts.ConceptRegistry;
import org.jesadido.poc.core.syntax.SyntaxTreeFactory;
import org.jesadido.poc.core.syntax.nodes.Node;
import org.junit.Assert;
import org.junit.Test;

public class StringifierTest {
    
    @Test
    public void testStringifier() {
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node sentence = syntaxTreeFactory.createSentence(null, null);
            Assert.assertEquals(".", sentence.accept(new Stringifier(), null));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node sentence = syntaxTreeFactory.createSentence(null, null);
            Assert.assertEquals(".", sentence.accept(new Stringifier(), " "));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node sentence = syntaxTreeFactory.createSentence(null, ConceptRegistry.getInstance().getConcept("Titl."));
            Assert.assertEquals("Titl.", sentence.accept(new Stringifier(), " "));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node sentenceMeat = syntaxTreeFactory.createSentenceMeat(null, null, null);
            Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeat), null);
            Assert.assertEquals("{ } .", sentence.accept(new Stringifier(), null));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node sentenceMeat = syntaxTreeFactory.createSentenceMeat(null, null, null);
            Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeat), null);
            Assert.assertEquals("{ } .", sentence.accept(new Stringifier(), " "));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node sentenceMeat = syntaxTreeFactory.createSentenceMeat(null, null, null);
            Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeat), null);
            Assert.assertEquals("{-}-.", sentence.accept(new Stringifier(), "-"));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node sentenceMeatA = syntaxTreeFactory.createSentenceMeat(null, null, null);
            Node sentenceMeatConjunction = syntaxTreeFactory.createSentenceMeatConjunction(null);
            Node sentenceMeatB = syntaxTreeFactory.createSentenceMeat(null, null, null);
            Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeatA, sentenceMeatConjunction, sentenceMeatB), null);
            Assert.assertEquals("{ \t } \t Kaj \t { \t } \t .", sentence.accept(new Stringifier(), " \t "));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node sentenceMeatA = syntaxTreeFactory.createSentenceMeat(null, null, null);
            Node sentenceMeatConjunctionX = syntaxTreeFactory.createSentenceMeatConjunction(ConceptRegistry.getInstance().getConcept(","));
            Node sentenceMeatB = syntaxTreeFactory.createSentenceMeat(null, null, null);
            Node sentenceMeatConjunctionY = syntaxTreeFactory.createSentenceMeatConjunction(ConceptRegistry.getInstance().getConcept("Aux"));
            Node sentenceMeatC = syntaxTreeFactory.createSentenceMeat(null, null, null);
            Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeatA, sentenceMeatConjunctionX, sentenceMeatB, sentenceMeatConjunctionY, sentenceMeatC), null);
            Assert.assertEquals("{ } , { } Aux { } .", sentence.accept(new Stringifier(), null));
        }
    }
}

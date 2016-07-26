/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.nodes.visitors;

import java.util.Arrays;
import org.jesadido.poc.core.concepts.ConceptUtils;
import org.jesadido.poc.core.syntax.SyntaxTreeFactory;
import org.jesadido.poc.core.syntax.Terminal;
import org.jesadido.poc.core.syntax.nodes.Node;
import org.junit.Assert;
import org.junit.Test;

public class ConceptCollectorTest {
    
    @Test
    public void testCollectWithSentence() {
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node sentence = syntaxTreeFactory.createSentence(null, new Terminal("."));
            Assert.assertEquals(".", ConceptUtils.join(ConceptCollector.collect(sentence)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node sentence = syntaxTreeFactory.createSentence(null, new Terminal("."));
            Assert.assertEquals(".", ConceptUtils.join(ConceptCollector.collect(sentence)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node sentence = syntaxTreeFactory.createSentence(null, new Terminal("Titl."));
            Assert.assertEquals("Titl.", ConceptUtils.join(ConceptCollector.collect(sentence)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node sentenceMeat = syntaxTreeFactory.createSentenceMeat(new Terminal("{"), null, new Terminal("}"));
            Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeat), new Terminal("!."));
            Assert.assertEquals("{ } !.", ConceptUtils.join(ConceptCollector.collect(sentence)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node sentenceMeat = syntaxTreeFactory.createSentenceMeat(new Terminal("{{"), null, new Terminal("}}"));
            Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeat), new Terminal("()."));
            Assert.assertEquals("{{ }} ().", ConceptUtils.join(ConceptCollector.collect(sentence)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node sentenceMeat = syntaxTreeFactory.createSentenceMeat(new Terminal("{"), null, new Terminal("}"));
            Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeat), new Terminal("."));
            Assert.assertEquals("{-}-.", ConceptUtils.join("-", ConceptCollector.collect(sentence)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node sentenceMeatA = syntaxTreeFactory.createSentenceMeat(new Terminal("{"), null, new Terminal("}"));
            Node sentenceMeatConjunction = syntaxTreeFactory.createSentenceMeatConjunction(new Terminal("Kaj"));
            Node sentenceMeatB = syntaxTreeFactory.createSentenceMeat(new Terminal("{"), null, new Terminal("}"));
            Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeatA, sentenceMeatConjunction, sentenceMeatB), new Terminal("."));
            Assert.assertEquals("{ \t } \t Kaj \t { \t } \t .", ConceptUtils.join(" \t ", ConceptCollector.collect(sentence)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node sentenceMeatA = syntaxTreeFactory.createSentenceMeat(new Terminal("{"), null, new Terminal("}"));
            Node sentenceMeatConjunctionX = syntaxTreeFactory.createSentenceMeatConjunction(new Terminal(","));
            Node sentenceMeatB = syntaxTreeFactory.createSentenceMeat(new Terminal("{"), null, new Terminal("}"));
            Node sentenceMeatConjunctionY = syntaxTreeFactory.createSentenceMeatConjunction(new Terminal("Aux"));
            Node sentenceMeatC = syntaxTreeFactory.createSentenceMeat(new Terminal("{"), null, new Terminal("}"));
            Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeatA, sentenceMeatConjunctionX, sentenceMeatB, sentenceMeatConjunctionY, sentenceMeatC), new Terminal("."));
            Assert.assertEquals("{ } , { } Aux { } .", ConceptUtils.join(null, ConceptCollector.collect(sentence)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node su1 = syntaxTreeFactory.createPrepositionalPartSu(new Terminal("Su"), new Terminal("("), null, new Terminal(")"));
            Node sentenceMeatA = syntaxTreeFactory.createSentenceMeat(new Terminal("{"), Arrays.asList(su1), new Terminal("}"));
            Node sentenceMeatConjunctionX = syntaxTreeFactory.createSentenceMeatConjunction(new Terminal(","));
            Node su2 = syntaxTreeFactory.createPrepositionalPartSu(new Terminal("Su"), new Terminal("'X'O$("), null, new Terminal(")"));
            Node sentenceMeatB = syntaxTreeFactory.createSentenceMeat(new Terminal("{"), Arrays.asList(su2), new Terminal("}"));
            Node sentenceMeatConjunctionY = syntaxTreeFactory.createSentenceMeatConjunction(new Terminal("Kaj"));
            Node su3 = syntaxTreeFactory.createPrepositionalPartSu(new Terminal("Su"), new Terminal("(("), null, new Terminal("Cxu$))"));
            Node sentenceMeatC = syntaxTreeFactory.createSentenceMeat(new Terminal("{"), Arrays.asList(su3), new Terminal("}"));
            Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeatA, sentenceMeatConjunctionX, sentenceMeatB, sentenceMeatConjunctionY, sentenceMeatC), new Terminal("."));
            Assert.assertEquals("{ Su ( ) } , { Su 'X'O$( ) } Kaj { Su (( Cxu$)) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node suA = syntaxTreeFactory.createPrepositionalPartSu(new Terminal("Su"), new Terminal("("), null, new Terminal(")"));
            Node domA = syntaxTreeFactory.createPrepositionalPartDom(new Terminal("Dom"), new Terminal("("), null, new Terminal(")"));
            Node sentenceMeatA = syntaxTreeFactory.createSentenceMeat(new Terminal("{"), Arrays.asList(suA, domA), new Terminal("}"));
            Node sentenceMeatConjunction = syntaxTreeFactory.createSentenceMeatConjunction(new Terminal("Kaj"));
            Node suB = syntaxTreeFactory.createPrepositionalPartSu(new Terminal("Su"), new Terminal("("), null, new Terminal(")"));
            Node domB = syntaxTreeFactory.createPrepositionalPartDom(new Terminal("Dom"), new Terminal("("), null, new Terminal(")"));
            Node sentenceMeatB = syntaxTreeFactory.createSentenceMeat(new Terminal("{"), Arrays.asList(domB, suB), new Terminal("}"));
            Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeatA, sentenceMeatConjunction, sentenceMeatB), new Terminal("."));
            Assert.assertEquals("{ Su ( ) Dom ( ) } Kaj { Dom ( ) Su ( ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node suA = syntaxTreeFactory.createPrepositionalPartSu(new Terminal("SUBJ"), new Terminal("["), null, new Terminal("]"));
            Node domA = syntaxTreeFactory.createPrepositionalPartDom(new Terminal("PRED"), new Terminal("["), null, new Terminal("]"));
            Node finA = syntaxTreeFactory.createPrepositionalPartFin(new Terminal("ACC"), new Terminal("["), null, new Terminal("]"));
            Node sentenceMeatA = syntaxTreeFactory.createSentenceMeat(new Terminal("("), Arrays.asList(suA, domA, finA), new Terminal(")"));
            Node sentenceMeatConjunction = syntaxTreeFactory.createSentenceMeatConjunction(new Terminal("CONJ"));
            Node suB = syntaxTreeFactory.createPrepositionalPartSu(new Terminal("SUBJ"), new Terminal("["), null, new Terminal("]"));
            Node domB = syntaxTreeFactory.createPrepositionalPartDom(new Terminal("PRED"), new Terminal("["), null, new Terminal("]"));
            Node finB = syntaxTreeFactory.createPrepositionalPartFin(new Terminal("ACC"), new Terminal("["), null, new Terminal("]"));
            Node sentenceMeatB = syntaxTreeFactory.createSentenceMeat(new Terminal("("), Arrays.asList(finB, domB, suB), new Terminal(")"));
            Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeatA, sentenceMeatConjunction, sentenceMeatB), new Terminal("PERIOD"));
            Assert.assertEquals("( SUBJ [ ] PRED [ ] ACC [ ] ) CONJ ( ACC [ ] PRED [ ] SUBJ [ ] ) PERIOD", ConceptUtils.join(ConceptCollector.collect(sentence)));
        }
    }
    
    @Test
    public void testCollectWithSentenceMeat() {
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node sentenceMeat = syntaxTreeFactory.createSentenceMeat(new Terminal("{"), null, new Terminal("}"));
            Assert.assertEquals("{ MEAT }", ConceptUtils.join(" MEAT ", ConceptCollector.collect(sentenceMeat)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node su = syntaxTreeFactory.createPrepositionalPartSu(new Terminal("Su"), new Terminal("("), null, new Terminal(")"));
            Node dom = syntaxTreeFactory.createPrepositionalPartDom(new Terminal("Dom"), new Terminal("("), null, new Terminal(")"));
            Node sentenceMeat = syntaxTreeFactory.createSentenceMeat(new Terminal("{"), Arrays.asList(dom, su), new Terminal("}"));
            Assert.assertEquals("{ Dom ( ) Su ( ) }", ConceptUtils.join(ConceptCollector.collect(sentenceMeat)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node su = syntaxTreeFactory.createPrepositionalPartSu(new Terminal("Su"), new Terminal("("), null, new Terminal(")"));
            Node dom = syntaxTreeFactory.createPrepositionalPartDom(new Terminal("Dom"), new Terminal("("), null, new Terminal(")"));
            Node fin = syntaxTreeFactory.createPrepositionalPartDom(new Terminal("Fin"), new Terminal("("), null, new Terminal(")"));
            Node sentenceMeat = syntaxTreeFactory.createSentenceMeat(new Terminal("[["), Arrays.asList(fin, dom, su), new Terminal("]]"));
            Assert.assertEquals("[[ Fin ( ) Dom ( ) Su ( ) ]]", ConceptUtils.join(ConceptCollector.collect(sentenceMeat)));
        }
    }
}

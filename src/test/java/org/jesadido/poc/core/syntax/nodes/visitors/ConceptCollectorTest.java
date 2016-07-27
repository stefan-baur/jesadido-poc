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
import org.jesadido.poc.core.concepts.ConceptUtils;
import org.jesadido.poc.core.syntax.SyntaxTreeFactory;
import org.jesadido.poc.core.syntax.Terminal;
import org.jesadido.poc.core.syntax.base.BaseSyntaxTreeFactory;
import org.jesadido.poc.core.syntax.nodes.Node;
import org.junit.Assert;
import org.junit.Test;

public class ConceptCollectorTest {
    
    @Test
    public void testCollectWithSentence() {
        {
            SyntaxTreeFactory syntaxTreeFactory = new BaseSyntaxTreeFactory();
            Node sentence = syntaxTreeFactory.createSentence(null, null);
            Assert.assertEquals(".", ConceptUtils.join(ConceptCollector.collect(sentence)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new BaseSyntaxTreeFactory();
            Node sentence = syntaxTreeFactory.createSentence(null, ConceptRegistry.getInstance().getConcept("."));
            Assert.assertEquals(".", ConceptUtils.join(ConceptCollector.collect(sentence)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new BaseSyntaxTreeFactory();
            Node sentence = syntaxTreeFactory.createSentence(null, ConceptRegistry.getInstance().getConcept("Titl."));
            Assert.assertEquals("Titl.", ConceptUtils.join(ConceptCollector.collect(sentence)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new BaseSyntaxTreeFactory();
            Node sentenceMeat = syntaxTreeFactory.createSentenceMeat(null, null, null);
            Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeat), ConceptRegistry.getInstance().getConcept("!."));
            Assert.assertEquals("{ } !.", ConceptUtils.join(ConceptCollector.collect(sentence)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new BaseSyntaxTreeFactory();
            Node sentenceMeat = syntaxTreeFactory.createSentenceMeat(ConceptRegistry.getInstance().getConcept("{{"), null, ConceptRegistry.getInstance().getConcept("}}"));
            Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeat), ConceptRegistry.getInstance().getConcept("()."));
            Assert.assertEquals("{{ }} ().", ConceptUtils.join(ConceptCollector.collect(sentence)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new BaseSyntaxTreeFactory();
            Node sentenceMeat = syntaxTreeFactory.createSentenceMeat(ConceptRegistry.getInstance().getConcept("{"), null, ConceptRegistry.getInstance().getConcept("}"));
            Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeat), ConceptRegistry.getInstance().getConcept("."));
            Assert.assertEquals("{-}-.", ConceptUtils.join("-", ConceptCollector.collect(sentence)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new BaseSyntaxTreeFactory();
            Node sentenceMeatA = syntaxTreeFactory.createSentenceMeat(null, null, null);
            Node sentenceMeatConjunction = syntaxTreeFactory.createSentenceMeatConjunction(null);
            Node sentenceMeatB = syntaxTreeFactory.createSentenceMeat(null, null, null);
            Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeatA, sentenceMeatConjunction, sentenceMeatB), null);
            Assert.assertEquals("{ \t } \t Kaj \t { \t } \t .", ConceptUtils.join(" \t ", ConceptCollector.collect(sentence)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new BaseSyntaxTreeFactory();
            Node sentenceMeatA = syntaxTreeFactory.createSentenceMeat(null, null, null);
            Node sentenceMeatConjunctionX = syntaxTreeFactory.createSentenceMeatConjunction(ConceptRegistry.getInstance().getConcept(","));
            Node sentenceMeatB = syntaxTreeFactory.createSentenceMeat(null, null, null);
            Node sentenceMeatConjunctionY = syntaxTreeFactory.createSentenceMeatConjunction(ConceptRegistry.getInstance().getConcept("Aux"));
            Node sentenceMeatC = syntaxTreeFactory.createSentenceMeat(null, null, null);
            Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeatA, sentenceMeatConjunctionX, sentenceMeatB, sentenceMeatConjunctionY, sentenceMeatC), null);
            Assert.assertEquals("{ } , { } Aux { } .", ConceptUtils.join(null, ConceptCollector.collect(sentence)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new BaseSyntaxTreeFactory();
            Node su1 = syntaxTreeFactory.createPrepositionalPartSu(null, null, null, null);
            Node sentenceMeatA = syntaxTreeFactory.createSentenceMeat(null, Arrays.asList(su1), null);
            Node sentenceMeatConjunctionX = syntaxTreeFactory.createSentenceMeatConjunction(ConceptRegistry.getInstance().getConcept(","));
            Node su2 = syntaxTreeFactory.createPrepositionalPartSu(null, ConceptRegistry.getInstance().getConcept("'X'O$("), null, null);
            Node sentenceMeatB = syntaxTreeFactory.createSentenceMeat(null, Arrays.asList(su2), null);
            Node sentenceMeatConjunctionY = syntaxTreeFactory.createSentenceMeatConjunction(ConceptRegistry.getInstance().getConcept("Kaj"));
            Node su3 = syntaxTreeFactory.createPrepositionalPartSu(null, ConceptRegistry.getInstance().getConcept("(("), null, ConceptRegistry.getInstance().getConcept("Cxu$))"));
            Node sentenceMeatC = syntaxTreeFactory.createSentenceMeat(null, Arrays.asList(su3), null);
            Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeatA, sentenceMeatConjunctionX, sentenceMeatB, sentenceMeatConjunctionY, sentenceMeatC), null);
            Assert.assertEquals("{ Su ( ) } , { Su 'X'O$( ) } Kaj { Su (( Cxu$)) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new BaseSyntaxTreeFactory();
            Node suA = syntaxTreeFactory.createPrepositionalPartSu(null, null, null, null);
            Node domA = syntaxTreeFactory.createPrepositionalPartDom(null, null, null, null);
            Node sentenceMeatA = syntaxTreeFactory.createSentenceMeat(null, Arrays.asList(suA, domA), null);
            Node sentenceMeatConjunction = syntaxTreeFactory.createSentenceMeatConjunction(null);
            Node suB = syntaxTreeFactory.createPrepositionalPartSu(null, null, null, null);
            Node domB = syntaxTreeFactory.createPrepositionalPartDom(null, null, null, null);
            Node sentenceMeatB = syntaxTreeFactory.createSentenceMeat(null, Arrays.asList(domB, suB), null);
            Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeatA, sentenceMeatConjunction, sentenceMeatB), null);
            Assert.assertEquals("{ Su ( ) Dom ( ) } Kaj { Dom ( ) Su ( ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new BaseSyntaxTreeFactory();
            Node suA = syntaxTreeFactory.createPrepositionalPartSu(ConceptRegistry.getInstance().getConcept("SUBJ"), ConceptRegistry.getInstance().getConcept("["), null, ConceptRegistry.getInstance().getConcept("]"));
            Node domA = syntaxTreeFactory.createPrepositionalPartDom(ConceptRegistry.getInstance().getConcept("PRED"), ConceptRegistry.getInstance().getConcept("["), null, ConceptRegistry.getInstance().getConcept("]"));
            Node finA = syntaxTreeFactory.createPrepositionalPartFin(ConceptRegistry.getInstance().getConcept("ACC"), ConceptRegistry.getInstance().getConcept("["), null, ConceptRegistry.getInstance().getConcept("]"));
            Node sentenceMeatA = syntaxTreeFactory.createSentenceMeat(ConceptRegistry.getInstance().getConcept("("), Arrays.asList(suA, domA, finA), ConceptRegistry.getInstance().getConcept(")"));
            Node sentenceMeatConjunction = syntaxTreeFactory.createSentenceMeatConjunction(ConceptRegistry.getInstance().getConcept("CONJ"));
            Node suB = syntaxTreeFactory.createPrepositionalPartSu(ConceptRegistry.getInstance().getConcept("SUBJ"), ConceptRegistry.getInstance().getConcept("["), null, ConceptRegistry.getInstance().getConcept("]"));
            Node domB = syntaxTreeFactory.createPrepositionalPartDom(ConceptRegistry.getInstance().getConcept("PRED"), ConceptRegistry.getInstance().getConcept("["), null, ConceptRegistry.getInstance().getConcept("]"));
            Node finB = syntaxTreeFactory.createPrepositionalPartFin(ConceptRegistry.getInstance().getConcept("ACC"), ConceptRegistry.getInstance().getConcept("["), null, ConceptRegistry.getInstance().getConcept("]"));
            Node sentenceMeatB = syntaxTreeFactory.createSentenceMeat(ConceptRegistry.getInstance().getConcept("("), Arrays.asList(finB, domB, suB), ConceptRegistry.getInstance().getConcept(")"));
            Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeatA, sentenceMeatConjunction, sentenceMeatB), ConceptRegistry.getInstance().getConcept("PERIOD"));
            Assert.assertEquals("( SUBJ [ ] PRED [ ] ACC [ ] ) CONJ ( ACC [ ] PRED [ ] SUBJ [ ] ) PERIOD", ConceptUtils.join(ConceptCollector.collect(sentence)));
        }
    }
    
    @Test
    public void testCollectWithSentenceMeat() {
        {
            SyntaxTreeFactory syntaxTreeFactory = new BaseSyntaxTreeFactory();
            Node sentenceMeat = syntaxTreeFactory.createSentenceMeat(null, null, null);
            Assert.assertEquals("{ MEAT }", ConceptUtils.join(" MEAT ", ConceptCollector.collect(sentenceMeat)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new BaseSyntaxTreeFactory();
            Node su = syntaxTreeFactory.createPrepositionalPartSu(null, null, null, null);
            Node dom = syntaxTreeFactory.createPrepositionalPartDom(null, null, null, null);
            Node sentenceMeat = syntaxTreeFactory.createSentenceMeat(null, Arrays.asList(dom, su), null);
            Assert.assertEquals("{ Dom ( ) Su ( ) }", ConceptUtils.join(ConceptCollector.collect(sentenceMeat)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new BaseSyntaxTreeFactory();
            Node su = syntaxTreeFactory.createPrepositionalPartSu(null, null, null, null);
            Node dom = syntaxTreeFactory.createPrepositionalPartDom(null, null, null, null);
            Node fin = syntaxTreeFactory.createPrepositionalPartFin(null, null, null, null);
            Node sentenceMeat = syntaxTreeFactory.createSentenceMeat(ConceptRegistry.getInstance().getConcept("[["), Arrays.asList(fin, dom, su), ConceptRegistry.getInstance().getConcept("]]"));
            Assert.assertEquals("[[ Fin ( ) Dom ( ) Su ( ) ]]", ConceptUtils.join(ConceptCollector.collect(sentenceMeat)));
        }
    }
}

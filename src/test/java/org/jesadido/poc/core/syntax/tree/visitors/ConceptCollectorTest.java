/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tree.visitors;

import java.util.Arrays;
import org.jesadido.poc.core.concepts.ConceptUtils;
import org.jesadido.poc.core.syntax.tree.SyntaxTreeFactory;
import org.jesadido.poc.core.syntax.tree.Node;
import org.jesadido.poc.core.syntax.tokens.TokenCreator;
import org.junit.Assert;
import org.junit.Test;

public class ConceptCollectorTest {
    
    private static final TokenCreator TC = new TokenCreator();
    
    @Test
    public void testCollectWithSentence() {
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node sentence = syntaxTreeFactory.createSentence(null, null);
            Assert.assertEquals(".", ConceptUtils.join(ConceptCollector.collect(sentence)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node sentence = syntaxTreeFactory.createSentence(null, TC.create("."));
            Assert.assertEquals(".", ConceptUtils.join(ConceptCollector.collect(sentence)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node sentence = syntaxTreeFactory.createSentence(null, TC.create("Titl."));
            Assert.assertEquals("Titl.", ConceptUtils.join(ConceptCollector.collect(sentence)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node sentenceMeat = syntaxTreeFactory.createSentenceMeat(null, null, null, null);
            Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeat), TC.create("!."));
            Assert.assertEquals("{ } !.", ConceptUtils.join(ConceptCollector.collect(sentence)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node sentenceMeat = syntaxTreeFactory.createSentenceMeat(null, TC.create("{{"), null, TC.create("}}"));
            Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeat), TC.create("()."));
            Assert.assertEquals("{{ }} ().", ConceptUtils.join(ConceptCollector.collect(sentence)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node sentenceMeat = syntaxTreeFactory.createSentenceMeat(null, TC.create("{"), null, TC.create("}"));
            Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeat), TC.create("."));
            Assert.assertEquals("{-}-.", ConceptUtils.join("-", ConceptCollector.collect(sentence)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node sentenceMeatA = syntaxTreeFactory.createSentenceMeat(null, null, null, null);
            Node sentenceMeatConjunction = syntaxTreeFactory.createSentenceMeatConjunction(null);
            Node sentenceMeatB = syntaxTreeFactory.createSentenceMeat(null, null, null, null);
            Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeatA, sentenceMeatConjunction, sentenceMeatB), null);
            Assert.assertEquals("{ \t } \t Kaj \t { \t } \t .", ConceptUtils.join(" \t ", ConceptCollector.collect(sentence)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node sentenceMeatA = syntaxTreeFactory.createSentenceMeat(null, null, null, null);
            Node sentenceMeatConjunctionX = syntaxTreeFactory.createSentenceMeatConjunction(TC.create(","));
            Node sentenceMeatB = syntaxTreeFactory.createSentenceMeat(null, null, null, null);
            Node sentenceMeatConjunctionY = syntaxTreeFactory.createSentenceMeatConjunction(TC.create("Aux"));
            Node sentenceMeatC = syntaxTreeFactory.createSentenceMeat(null, null, null, null);
            Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeatA, sentenceMeatConjunctionX, sentenceMeatB, sentenceMeatConjunctionY, sentenceMeatC), null);
            Assert.assertEquals("{ } , { } Aux { } .", ConceptUtils.join(null, ConceptCollector.collect(sentence)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node su1 = syntaxTreeFactory.createPartSu(null, null, null, null);
            Node sentenceMeatA = syntaxTreeFactory.createSentenceMeat(null, null, Arrays.asList(su1), null);
            Node sentenceMeatConjunctionX = syntaxTreeFactory.createSentenceMeatConjunction(TC.create(","));
            Node su2 = syntaxTreeFactory.createPartSu(null, TC.create("'X'O$("), null, null);
            Node sentenceMeatB = syntaxTreeFactory.createSentenceMeat(null, null, Arrays.asList(su2), null);
            Node sentenceMeatConjunctionY = syntaxTreeFactory.createSentenceMeatConjunction(TC.create("Kaj"));
            Node su3 = syntaxTreeFactory.createPartSu(null, TC.create("(("), null, TC.create("Cxu$))"));
            Node sentenceMeatC = syntaxTreeFactory.createSentenceMeat(null, null, Arrays.asList(su3), null);
            Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeatA, sentenceMeatConjunctionX, sentenceMeatB, sentenceMeatConjunctionY, sentenceMeatC), null);
            Assert.assertEquals("{ Su ( ) } , { Su 'X'O$( ) } Kaj { Su (( Cxu$)) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node suA = syntaxTreeFactory.createPartSu(null, null, null, null);
            Node domA = syntaxTreeFactory.createPartDom(null, null, null, null);
            Node sentenceMeatA = syntaxTreeFactory.createSentenceMeat(null, null, Arrays.asList(suA, domA), null);
            Node sentenceMeatConjunction = syntaxTreeFactory.createSentenceMeatConjunction(null);
            Node suB = syntaxTreeFactory.createPartSu(null, null, null, null);
            Node domB = syntaxTreeFactory.createPartDom(null, null, null, null);
            Node sentenceMeatB = syntaxTreeFactory.createSentenceMeat(null, null, Arrays.asList(domB, suB), null);
            Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeatA, sentenceMeatConjunction, sentenceMeatB), null);
            Assert.assertEquals("{ Su ( ) Dom ( ) } Kaj { Dom ( ) Su ( ) } .", ConceptUtils.join(ConceptCollector.collect(sentence)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node suA = syntaxTreeFactory.createPartSu(TC.create("SUBJ"), TC.create("["), null, TC.create("]"));
            Node domA = syntaxTreeFactory.createPartDom(TC.create("PRED"), TC.create("["), null, TC.create("]"));
            Node finA = syntaxTreeFactory.createPartFin(TC.create("ACC"), TC.create("["), null, TC.create("]"));
            Node sentenceMeatA = syntaxTreeFactory.createSentenceMeat(null, TC.create("("), Arrays.asList(suA, domA, finA), TC.create(")"));
            Node sentenceMeatConjunction = syntaxTreeFactory.createSentenceMeatConjunction(TC.create("CONJ"));
            Node suB = syntaxTreeFactory.createPartSu(TC.create("SUBJ"), TC.create("["), null, TC.create("]"));
            Node domB = syntaxTreeFactory.createPartDom(TC.create("PRED"), TC.create("["), null, TC.create("]"));
            Node finB = syntaxTreeFactory.createPartFin(TC.create("ACC"), TC.create("["), null, TC.create("]"));
            Node sentenceMeatB = syntaxTreeFactory.createSentenceMeat(null, TC.create("("), Arrays.asList(finB, domB, suB), TC.create(")"));
            Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeatA, sentenceMeatConjunction, sentenceMeatB), TC.create("PERIOD"));
            Assert.assertEquals("( SUBJ [ ] PRED [ ] ACC [ ] ) CONJ ( ACC [ ] PRED [ ] SUBJ [ ] ) PERIOD", ConceptUtils.join(ConceptCollector.collect(sentence)));
        }
    }
    
    @Test
    public void testCollectWithSentenceMeat() {
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node sentenceMeat = syntaxTreeFactory.createSentenceMeat(null, null, null, null);
            Assert.assertEquals("{ MEAT }", ConceptUtils.join(" MEAT ", ConceptCollector.collect(sentenceMeat)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node su = syntaxTreeFactory.createPartSu(null, null, null, null);
            Node dom = syntaxTreeFactory.createPartDom(null, null, null, null);
            Node sentenceMeat = syntaxTreeFactory.createSentenceMeat(null, null, Arrays.asList(dom, su), null);
            Assert.assertEquals("{ Dom ( ) Su ( ) }", ConceptUtils.join(ConceptCollector.collect(sentenceMeat)));
        }
        {
            SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
            Node su = syntaxTreeFactory.createPartSu(null, null, null, null);
            Node dom = syntaxTreeFactory.createPartDom(null, null, null, null);
            Node fin = syntaxTreeFactory.createPartFin(null, null, null, null);
            Node sentenceMeat = syntaxTreeFactory.createSentenceMeat(null, TC.create("[["), Arrays.asList(fin, dom, su), TC.create("]]"));
            Assert.assertEquals("[[ Fin ( ) Dom ( ) Su ( ) ]]", ConceptUtils.join(ConceptCollector.collect(sentenceMeat)));
        }
    }
}

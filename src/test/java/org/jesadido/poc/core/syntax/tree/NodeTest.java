/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tree;

import java.util.Arrays;
import org.jesadido.poc.core.concepts.ConceptUtils;
import org.jesadido.poc.core.syntax.tokens.TokenCreator;
import org.junit.Assert;
import org.junit.Test;

public class NodeTest {
    
    @Test
    public void testCollectConcepts() {
        final TokenCreator tokenCreator = new TokenCreator();
        final SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
        {
            final Node sentence = syntaxTreeFactory.createSentence(null, null);
            Assert.assertEquals(".", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final Node sentence = syntaxTreeFactory.createSentence(null, tokenCreator.create("."));
            Assert.assertEquals(".", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final Node sentence = syntaxTreeFactory.createSentence(null, tokenCreator.create("Titl."));
            Assert.assertEquals("Titl.", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final Node sentenceMeat = syntaxTreeFactory.createSentenceMeat(null, null, null, null);
            final Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeat), tokenCreator.create("!."));
            Assert.assertEquals("{ } !.", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final Node sentenceMeat = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create("{{"), null, tokenCreator.create("}}"));
            final Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeat), tokenCreator.create("()."));
            Assert.assertEquals("{{ }} ().", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final Node sentenceMeat = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create("{"), null, tokenCreator.create("}"));
            final Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeat), tokenCreator.create("."));
            Assert.assertEquals("{-}-.", ConceptUtils.join("-", sentence.collectConcepts()));
        }
        {
            final Node sentenceMeatA = syntaxTreeFactory.createSentenceMeat(null, null, null, null);
            final Node sentenceMeatConjunction = syntaxTreeFactory.createSentenceMeatConjunction(null);
            final Node sentenceMeatB = syntaxTreeFactory.createSentenceMeat(null, null, null, null);
            final Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeatA, sentenceMeatConjunction, sentenceMeatB), null);
            Assert.assertEquals("{ \t } \t Kaj \t { \t } \t .", ConceptUtils.join(" \t ", sentence.collectConcepts()));
        }
        {
            final Node sentenceMeatA = syntaxTreeFactory.createSentenceMeat(null, null, null, null);
            final Node sentenceMeatConjunctionX = syntaxTreeFactory.createSentenceMeatConjunction(tokenCreator.create(","));
            final Node sentenceMeatB = syntaxTreeFactory.createSentenceMeat(null, null, null, null);
            final Node sentenceMeatConjunctionY = syntaxTreeFactory.createSentenceMeatConjunction(tokenCreator.create("Aux"));
            final Node sentenceMeatC = syntaxTreeFactory.createSentenceMeat(null, null, null, null);
            final Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeatA, sentenceMeatConjunctionX, sentenceMeatB, sentenceMeatConjunctionY, sentenceMeatC), null);
            Assert.assertEquals("{ } , { } Aux { } .", ConceptUtils.join(null, sentence.collectConcepts()));
        }
        {
            final Node su1 = syntaxTreeFactory.createPartSu(null, null, null, null);
            final Node sentenceMeatA = syntaxTreeFactory.createSentenceMeat(null, null, Arrays.asList(su1), null);
            final Node sentenceMeatConjunctionX = syntaxTreeFactory.createSentenceMeatConjunction(tokenCreator.create(","));
            final Node su2 = syntaxTreeFactory.createPartSu(null, tokenCreator.create("'X'O$("), null, null);
            final Node sentenceMeatB = syntaxTreeFactory.createSentenceMeat(null, null, Arrays.asList(su2), null);
            final Node sentenceMeatConjunctionY = syntaxTreeFactory.createSentenceMeatConjunction(tokenCreator.create("Kaj"));
            final Node su3 = syntaxTreeFactory.createPartSu(null, tokenCreator.create("(("), null, tokenCreator.create("Cxu$))"));
            final Node sentenceMeatC = syntaxTreeFactory.createSentenceMeat(null, null, Arrays.asList(su3), null);
            final Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeatA, sentenceMeatConjunctionX, sentenceMeatB, sentenceMeatConjunctionY, sentenceMeatC), null);
            Assert.assertEquals("{ Su ( ) } , { Su 'X'O$( ) } Kaj { Su (( Cxu$)) } .", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final Node suA = syntaxTreeFactory.createPartSu(null, null, null, null);
            final Node domA = syntaxTreeFactory.createPartDom(null, null, null, null);
            final Node sentenceMeatA = syntaxTreeFactory.createSentenceMeat(null, null, Arrays.asList(suA, domA), null);
            final Node sentenceMeatConjunction = syntaxTreeFactory.createSentenceMeatConjunction(null);
            final Node suB = syntaxTreeFactory.createPartSu(null, null, null, null);
            final Node domB = syntaxTreeFactory.createPartDom(null, null, null, null);
            final Node sentenceMeatB = syntaxTreeFactory.createSentenceMeat(null, null, Arrays.asList(domB, suB), null);
            final Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeatA, sentenceMeatConjunction, sentenceMeatB), null);
            Assert.assertEquals("{ Su ( ) Dom ( ) } Kaj { Dom ( ) Su ( ) } .", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final Node suA = syntaxTreeFactory.createPartSu(tokenCreator.create("SUBJ"), tokenCreator.create("["), null, tokenCreator.create("]"));
            final Node domA = syntaxTreeFactory.createPartDom(tokenCreator.create("PRED"), tokenCreator.create("["), null, tokenCreator.create("]"));
            final Node finA = syntaxTreeFactory.createPartFin(tokenCreator.create("ACC"), tokenCreator.create("["), null, tokenCreator.create("]"));
            final Node sentenceMeatA = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create("("), Arrays.asList(suA, domA, finA), tokenCreator.create(")"));
            final Node sentenceMeatConjunction = syntaxTreeFactory.createSentenceMeatConjunction(tokenCreator.create("CONJ"));
            final Node suB = syntaxTreeFactory.createPartSu(tokenCreator.create("SUBJ"), tokenCreator.create("["), null, tokenCreator.create("]"));
            final Node domB = syntaxTreeFactory.createPartDom(tokenCreator.create("PRED"), tokenCreator.create("["), null, tokenCreator.create("]"));
            final Node finB = syntaxTreeFactory.createPartFin(tokenCreator.create("ACC"), tokenCreator.create("["), null, tokenCreator.create("]"));
            final Node sentenceMeatB = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create("("), Arrays.asList(finB, domB, suB), tokenCreator.create(")"));
            final Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeatA, sentenceMeatConjunction, sentenceMeatB), tokenCreator.create("PERIOD"));
            Assert.assertEquals("( SUBJ [ ] PRED [ ] ACC [ ] ) CONJ ( ACC [ ] PRED [ ] SUBJ [ ] ) PERIOD", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final Node sentenceMeat = syntaxTreeFactory.createSentenceMeat(null, null, null, null);
            Assert.assertEquals("{ MEAT }", ConceptUtils.join(" MEAT ", sentenceMeat.collectConcepts()));
        }
        {
            final Node su = syntaxTreeFactory.createPartSu(null, null, null, null);
            final Node dom = syntaxTreeFactory.createPartDom(null, null, null, null);
            final Node sentenceMeat = syntaxTreeFactory.createSentenceMeat(null, null, Arrays.asList(dom, su), null);
            Assert.assertEquals("{ Dom ( ) Su ( ) }", ConceptUtils.join(sentenceMeat.collectConcepts()));
        }
        {
            final Node su = syntaxTreeFactory.createPartSu(null, null, null, null);
            final Node dom = syntaxTreeFactory.createPartDom(null, null, null, null);
            final Node fin = syntaxTreeFactory.createPartFin(null, null, null, null);
            final Node sentenceMeat = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create("[["), Arrays.asList(fin, dom, su), tokenCreator.create("]]"));
            Assert.assertEquals("[[ Fin ( ) Dom ( ) Su ( ) ]]", ConceptUtils.join(sentenceMeat.collectConcepts()));
        }
    }
}

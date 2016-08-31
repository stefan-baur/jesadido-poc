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
import org.jesadido.poc.core.syntax.tokens.TokenType;
import org.junit.Assert;
import org.junit.Test;

public class NodeTest {
    
    @Test
    public void testCollectConcepts() {
        final TokenCreator tokenCreator = new TokenCreator();
        final SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
        {
            final Node sentence = syntaxTreeFactory.createSentence(null, tokenCreator.create(TokenType.TERMINATOR));
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
            final Node sentenceMeat = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create(TokenType.OPEN_SET), null, tokenCreator.create(TokenType.CLOSE_SET));
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
            final Node sentenceMeatA = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create(TokenType.OPEN_SET), null, tokenCreator.create(TokenType.CLOSE_SET));
            final Node sentenceMeatConjunction = syntaxTreeFactory.createSentenceMeatConjunction(tokenCreator.create(TokenType.SEPARATOR_KAJ));
            final Node sentenceMeatB = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create(TokenType.OPEN_SET), null, tokenCreator.create(TokenType.CLOSE_SET));
            final Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeatA, sentenceMeatConjunction, sentenceMeatB), tokenCreator.create(TokenType.TERMINATOR));
            Assert.assertEquals("{ \t } \t Kaj \t { \t } \t .", ConceptUtils.join(" \t ", sentence.collectConcepts()));
        }
        {
            final Node sentenceMeatA = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create(TokenType.OPEN_SET), null, tokenCreator.create(TokenType.CLOSE_SET));
            final Node sentenceMeatConjunctionX = syntaxTreeFactory.createSentenceMeatConjunction(tokenCreator.create(","));
            final Node sentenceMeatB = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create(TokenType.OPEN_SET), null, tokenCreator.create(TokenType.CLOSE_SET));
            final Node sentenceMeatConjunctionY = syntaxTreeFactory.createSentenceMeatConjunction(tokenCreator.create("Aux"));
            final Node sentenceMeatC = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create(TokenType.OPEN_SET), null, tokenCreator.create(TokenType.CLOSE_SET));
            final Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeatA, sentenceMeatConjunctionX, sentenceMeatB, sentenceMeatConjunctionY, sentenceMeatC), tokenCreator.create(TokenType.TERMINATOR));
            Assert.assertEquals("{ } , { } Aux { } .", ConceptUtils.join(null, sentence.collectConcepts()));
        }
        {
            final Node su1 = syntaxTreeFactory.createPartSu(tokenCreator.create(TokenType.PART_SU), tokenCreator.create(TokenType.OPEN), null, tokenCreator.create(TokenType.CLOSE));
            final Node sentenceMeatA = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create(TokenType.OPEN_SET), Arrays.asList(su1), tokenCreator.create(TokenType.CLOSE_SET));
            final Node sentenceMeatConjunctionX = syntaxTreeFactory.createSentenceMeatConjunction(tokenCreator.create(","));
            final Node su2 = syntaxTreeFactory.createPartSu(tokenCreator.create(TokenType.PART_SU), tokenCreator.create("'X'O$("), null, tokenCreator.create(TokenType.CLOSE));
            final Node sentenceMeatB = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create(TokenType.OPEN_SET), Arrays.asList(su2), tokenCreator.create(TokenType.CLOSE_SET));
            final Node sentenceMeatConjunctionY = syntaxTreeFactory.createSentenceMeatConjunction(tokenCreator.create("Kaj"));
            final Node su3 = syntaxTreeFactory.createPartSu(tokenCreator.create(TokenType.PART_SU), tokenCreator.create("(("), null, tokenCreator.create("Cxu$))"));
            final Node sentenceMeatC = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create(TokenType.OPEN_SET), Arrays.asList(su3), tokenCreator.create(TokenType.CLOSE_SET));
            final Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeatA, sentenceMeatConjunctionX, sentenceMeatB, sentenceMeatConjunctionY, sentenceMeatC), tokenCreator.create(TokenType.TERMINATOR));
            Assert.assertEquals("{ Su ( ) } , { Su 'X'O$( ) } Kaj { Su (( Cxu$)) } .", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final Node suA = syntaxTreeFactory.createPartSu(tokenCreator.create(TokenType.PART_SU), tokenCreator.create(TokenType.OPEN), null, tokenCreator.create(TokenType.CLOSE));
            final Node domA = syntaxTreeFactory.createPartDom(tokenCreator.create(TokenType.PART_DOM), tokenCreator.create(TokenType.OPEN), null, tokenCreator.create(TokenType.CLOSE));
            final Node sentenceMeatA = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create(TokenType.OPEN_SET), Arrays.asList(suA, domA), tokenCreator.create(TokenType.CLOSE_SET));
            final Node sentenceMeatConjunction = syntaxTreeFactory.createSentenceMeatConjunction(tokenCreator.create(TokenType.SEPARATOR_KAJ));
            final Node suB = syntaxTreeFactory.createPartSu(tokenCreator.create(TokenType.PART_SU), tokenCreator.create(TokenType.OPEN), null, tokenCreator.create(TokenType.CLOSE));
            final Node domB = syntaxTreeFactory.createPartDom(tokenCreator.create(TokenType.PART_DOM), tokenCreator.create(TokenType.OPEN), null, tokenCreator.create(TokenType.CLOSE));
            final Node sentenceMeatB = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create(TokenType.OPEN_SET), Arrays.asList(domB, suB), tokenCreator.create(TokenType.CLOSE_SET));
            final Node sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeatA, sentenceMeatConjunction, sentenceMeatB), tokenCreator.create(TokenType.TERMINATOR));
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
            final Node sentenceMeat = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create(TokenType.OPEN_SET), null, tokenCreator.create(TokenType.CLOSE_SET));
            Assert.assertEquals("{ MEAT }", ConceptUtils.join(" MEAT ", sentenceMeat.collectConcepts()));
        }
        {
            final Node su = syntaxTreeFactory.createPartSu(tokenCreator.create(TokenType.PART_SU), tokenCreator.create(TokenType.OPEN), null, tokenCreator.create(TokenType.CLOSE));
            final Node dom = syntaxTreeFactory.createPartDom(tokenCreator.create(TokenType.PART_DOM), tokenCreator.create(TokenType.OPEN), null, tokenCreator.create(TokenType.CLOSE));
            final Node sentenceMeat = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create(TokenType.OPEN_SET), Arrays.asList(dom, su), tokenCreator.create(TokenType.CLOSE_SET));
            Assert.assertEquals("{ Dom ( ) Su ( ) }", ConceptUtils.join(sentenceMeat.collectConcepts()));
        }
        {
            final Node su = syntaxTreeFactory.createPartSu(tokenCreator.create(TokenType.PART_SU), tokenCreator.create(TokenType.OPEN), null, tokenCreator.create(TokenType.CLOSE));
            final Node dom = syntaxTreeFactory.createPartDom(tokenCreator.create(TokenType.PART_DOM), tokenCreator.create(TokenType.OPEN), null, tokenCreator.create(TokenType.CLOSE));
            final Node fin = syntaxTreeFactory.createPartFin(tokenCreator.create(TokenType.PART_FIN), tokenCreator.create(TokenType.OPEN), null, tokenCreator.create(TokenType.CLOSE));
            final Node sentenceMeat = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create("[["), Arrays.asList(fin, dom, su), tokenCreator.create("]]"));
            Assert.assertEquals("[[ Fin ( ) Dom ( ) Su ( ) ]]", ConceptUtils.join(sentenceMeat.collectConcepts()));
        }
    }
}

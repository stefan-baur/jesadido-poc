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

public class JesadidoNodeTest {
    
    @Test
    public void testCollectConcepts() {
        final TokenCreator tokenCreator = new TokenCreator();
        final SyntaxTreeFactory syntaxTreeFactory = new SyntaxTreeFactory();
        {
            final JesadidoNode sentence = syntaxTreeFactory.createSentence(null, tokenCreator.create(TokenType.TERMINATOR));
            Assert.assertEquals(".", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final JesadidoNode sentence = syntaxTreeFactory.createSentence(null, tokenCreator.create("."));
            Assert.assertEquals(".", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final JesadidoNode sentence = syntaxTreeFactory.createSentence(null, tokenCreator.create("Titl."));
            Assert.assertEquals("Titl.", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final JesadidoNode sentenceMeat = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create(TokenType.OPEN_SET), null, tokenCreator.create(TokenType.CLOSE_SET));
            final JesadidoNode sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeat), tokenCreator.create("!."));
            Assert.assertEquals("{ } !.", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final JesadidoNode sentenceMeat = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create("{{"), null, tokenCreator.create("}}"));
            final JesadidoNode sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeat), tokenCreator.create("()."));
            Assert.assertEquals("{{ }} ().", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final JesadidoNode sentenceMeat = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create("{"), null, tokenCreator.create("}"));
            final JesadidoNode sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeat), tokenCreator.create("."));
            Assert.assertEquals("{-}-.", ConceptUtils.join("-", sentence.collectConcepts()));
        }
        {
            final JesadidoNode sentenceMeatA = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create(TokenType.OPEN_SET), null, tokenCreator.create(TokenType.CLOSE_SET));
            final JesadidoNode sentenceMeatConjunction = syntaxTreeFactory.createSentenceMeatConjunction(tokenCreator.create(TokenType.SEPARATOR_KAJ));
            final JesadidoNode sentenceMeatB = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create(TokenType.OPEN_SET), null, tokenCreator.create(TokenType.CLOSE_SET));
            final JesadidoNode sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeatA, sentenceMeatConjunction, sentenceMeatB), tokenCreator.create(TokenType.TERMINATOR));
            Assert.assertEquals("{ \t } \t Kaj \t { \t } \t .", ConceptUtils.join(" \t ", sentence.collectConcepts()));
        }
        {
            final JesadidoNode sentenceMeatA = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create(TokenType.OPEN_SET), null, tokenCreator.create(TokenType.CLOSE_SET));
            final JesadidoNode sentenceMeatConjunctionX = syntaxTreeFactory.createSentenceMeatConjunction(tokenCreator.create(","));
            final JesadidoNode sentenceMeatB = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create(TokenType.OPEN_SET), null, tokenCreator.create(TokenType.CLOSE_SET));
            final JesadidoNode sentenceMeatConjunctionY = syntaxTreeFactory.createSentenceMeatConjunction(tokenCreator.create("Aux"));
            final JesadidoNode sentenceMeatC = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create(TokenType.OPEN_SET), null, tokenCreator.create(TokenType.CLOSE_SET));
            final JesadidoNode sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeatA, sentenceMeatConjunctionX, sentenceMeatB, sentenceMeatConjunctionY, sentenceMeatC), tokenCreator.create(TokenType.TERMINATOR));
            Assert.assertEquals("{ } , { } Aux { } .", ConceptUtils.join(null, sentence.collectConcepts()));
        }
        {
            final JesadidoNode su1 = syntaxTreeFactory.createPartSu(tokenCreator.create(TokenType.PART_SU), tokenCreator.create(TokenType.OPEN), null, tokenCreator.create(TokenType.CLOSE));
            final JesadidoNode sentenceMeatA = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create(TokenType.OPEN_SET), Arrays.asList(su1), tokenCreator.create(TokenType.CLOSE_SET));
            final JesadidoNode sentenceMeatConjunctionX = syntaxTreeFactory.createSentenceMeatConjunction(tokenCreator.create(","));
            final JesadidoNode su2 = syntaxTreeFactory.createPartSu(tokenCreator.create(TokenType.PART_SU), tokenCreator.create("'X'O$("), null, tokenCreator.create(TokenType.CLOSE));
            final JesadidoNode sentenceMeatB = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create(TokenType.OPEN_SET), Arrays.asList(su2), tokenCreator.create(TokenType.CLOSE_SET));
            final JesadidoNode sentenceMeatConjunctionY = syntaxTreeFactory.createSentenceMeatConjunction(tokenCreator.create("Kaj"));
            final JesadidoNode su3 = syntaxTreeFactory.createPartSu(tokenCreator.create(TokenType.PART_SU), tokenCreator.create("(("), null, tokenCreator.create("Cxu$))"));
            final JesadidoNode sentenceMeatC = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create(TokenType.OPEN_SET), Arrays.asList(su3), tokenCreator.create(TokenType.CLOSE_SET));
            final JesadidoNode sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeatA, sentenceMeatConjunctionX, sentenceMeatB, sentenceMeatConjunctionY, sentenceMeatC), tokenCreator.create(TokenType.TERMINATOR));
            Assert.assertEquals("{ Su ( ) } , { Su 'X'O$( ) } Kaj { Su (( Cxu$)) } .", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final JesadidoNode suA = syntaxTreeFactory.createPartSu(tokenCreator.create(TokenType.PART_SU), tokenCreator.create(TokenType.OPEN), null, tokenCreator.create(TokenType.CLOSE));
            final JesadidoNode domA = syntaxTreeFactory.createPartDom(tokenCreator.create(TokenType.PART_DOM), tokenCreator.create(TokenType.OPEN), null, tokenCreator.create(TokenType.CLOSE));
            final JesadidoNode sentenceMeatA = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create(TokenType.OPEN_SET), Arrays.asList(suA, domA), tokenCreator.create(TokenType.CLOSE_SET));
            final JesadidoNode sentenceMeatConjunction = syntaxTreeFactory.createSentenceMeatConjunction(tokenCreator.create(TokenType.SEPARATOR_KAJ));
            final JesadidoNode suB = syntaxTreeFactory.createPartSu(tokenCreator.create(TokenType.PART_SU), tokenCreator.create(TokenType.OPEN), null, tokenCreator.create(TokenType.CLOSE));
            final JesadidoNode domB = syntaxTreeFactory.createPartDom(tokenCreator.create(TokenType.PART_DOM), tokenCreator.create(TokenType.OPEN), null, tokenCreator.create(TokenType.CLOSE));
            final JesadidoNode sentenceMeatB = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create(TokenType.OPEN_SET), Arrays.asList(domB, suB), tokenCreator.create(TokenType.CLOSE_SET));
            final JesadidoNode sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeatA, sentenceMeatConjunction, sentenceMeatB), tokenCreator.create(TokenType.TERMINATOR));
            Assert.assertEquals("{ Su ( ) Dom ( ) } Kaj { Dom ( ) Su ( ) } .", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final JesadidoNode suA = syntaxTreeFactory.createPartSu(tokenCreator.create("SUBJ"), tokenCreator.create("["), null, tokenCreator.create("]"));
            final JesadidoNode domA = syntaxTreeFactory.createPartDom(tokenCreator.create("PRED"), tokenCreator.create("["), null, tokenCreator.create("]"));
            final JesadidoNode finA = syntaxTreeFactory.createPartFin(tokenCreator.create("ACC"), tokenCreator.create("["), null, tokenCreator.create("]"));
            final JesadidoNode sentenceMeatA = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create("("), Arrays.asList(suA, domA, finA), tokenCreator.create(")"));
            final JesadidoNode sentenceMeatConjunction = syntaxTreeFactory.createSentenceMeatConjunction(tokenCreator.create("CONJ"));
            final JesadidoNode suB = syntaxTreeFactory.createPartSu(tokenCreator.create("SUBJ"), tokenCreator.create("["), null, tokenCreator.create("]"));
            final JesadidoNode domB = syntaxTreeFactory.createPartDom(tokenCreator.create("PRED"), tokenCreator.create("["), null, tokenCreator.create("]"));
            final JesadidoNode finB = syntaxTreeFactory.createPartFin(tokenCreator.create("ACC"), tokenCreator.create("["), null, tokenCreator.create("]"));
            final JesadidoNode sentenceMeatB = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create("("), Arrays.asList(finB, domB, suB), tokenCreator.create(")"));
            final JesadidoNode sentence = syntaxTreeFactory.createSentence(Arrays.asList(sentenceMeatA, sentenceMeatConjunction, sentenceMeatB), tokenCreator.create("PERIOD"));
            Assert.assertEquals("( SUBJ [ ] PRED [ ] ACC [ ] ) CONJ ( ACC [ ] PRED [ ] SUBJ [ ] ) PERIOD", ConceptUtils.join(sentence.collectConcepts()));
        }
        {
            final JesadidoNode sentenceMeat = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create(TokenType.OPEN_SET), null, tokenCreator.create(TokenType.CLOSE_SET));
            Assert.assertEquals("{ MEAT }", ConceptUtils.join(" MEAT ", sentenceMeat.collectConcepts()));
        }
        {
            final JesadidoNode su = syntaxTreeFactory.createPartSu(tokenCreator.create(TokenType.PART_SU), tokenCreator.create(TokenType.OPEN), null, tokenCreator.create(TokenType.CLOSE));
            final JesadidoNode dom = syntaxTreeFactory.createPartDom(tokenCreator.create(TokenType.PART_DOM), tokenCreator.create(TokenType.OPEN), null, tokenCreator.create(TokenType.CLOSE));
            final JesadidoNode sentenceMeat = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create(TokenType.OPEN_SET), Arrays.asList(dom, su), tokenCreator.create(TokenType.CLOSE_SET));
            Assert.assertEquals("{ Dom ( ) Su ( ) }", ConceptUtils.join(sentenceMeat.collectConcepts()));
        }
        {
            final JesadidoNode su = syntaxTreeFactory.createPartSu(tokenCreator.create(TokenType.PART_SU), tokenCreator.create(TokenType.OPEN), null, tokenCreator.create(TokenType.CLOSE));
            final JesadidoNode dom = syntaxTreeFactory.createPartDom(tokenCreator.create(TokenType.PART_DOM), tokenCreator.create(TokenType.OPEN), null, tokenCreator.create(TokenType.CLOSE));
            final JesadidoNode fin = syntaxTreeFactory.createPartFin(tokenCreator.create(TokenType.PART_FIN), tokenCreator.create(TokenType.OPEN), null, tokenCreator.create(TokenType.CLOSE));
            final JesadidoNode sentenceMeat = syntaxTreeFactory.createSentenceMeat(null, tokenCreator.create("[["), Arrays.asList(fin, dom, su), tokenCreator.create("]]"));
            Assert.assertEquals("[[ Fin ( ) Dom ( ) Su ( ) ]]", ConceptUtils.join(sentenceMeat.collectConcepts()));
        }
    }
}

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax;

import org.junit.Assert;
import org.junit.Test;

public class NonterminalTest {
    
    @Test
    public void testGetValue() {
        Assert.assertEquals("sentence-sequence", Nonterminal.SENTENCE_SEQUENCE.getValue());
        Assert.assertEquals("sentence", Nonterminal.SENTENCE.getValue());
        Assert.assertEquals("sentence-meat", Nonterminal.SENTENCE_MEAT.getValue());
        Assert.assertEquals("sentence-meat-conjunction", Nonterminal.SENTENCE_MEAT_CONJUNCTION.getValue());
        Assert.assertEquals("sentence-meat-part", Nonterminal.SENTENCE_MEAT_PART.getValue());
        Assert.assertEquals("part-su", Nonterminal.PART_SU.getValue());
        Assert.assertEquals("part-dom", Nonterminal.PART_DOM.getValue());
        Assert.assertEquals("part-al", Nonterminal.PART_AL.getValue());
        Assert.assertEquals("part-fin", Nonterminal.PART_FIN.getValue());
        Assert.assertEquals("nominal-selection", Nonterminal.NOMINAL_SELECTION.getValue());
        Assert.assertEquals("substantive-selection", Nonterminal.SUBSTANTIVE_SELECTION.getValue());
        Assert.assertEquals("verbal-selection", Nonterminal.VERBAL_SELECTION.getValue());
        Assert.assertEquals("verb-selection", Nonterminal.VERB_SELECTION.getValue());
    }
}

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.concepts;

import org.junit.Assert;
import org.junit.Test;

public class ConceptTerminationTest {
    
    @Test
    public void testGetTerminationPhrase() {
        Assert.assertNull(ConceptTermination.UNKNOWN.getTerminationPhrase());
        Assert.assertEquals(".", ConceptTermination.TERMINATOR.getTerminationPhrase());
        Assert.assertEquals("!", ConceptTermination.LABEL_TERMINATOR.getTerminationPhrase());
        Assert.assertEquals("O", ConceptTermination.O.getTerminationPhrase());
        Assert.assertEquals("A", ConceptTermination.A.getTerminationPhrase());
        Assert.assertEquals("E", ConceptTermination.E.getTerminationPhrase());
        Assert.assertEquals("OJ", ConceptTermination.O_J.getTerminationPhrase());
        Assert.assertEquals("AJ", ConceptTermination.A_J.getTerminationPhrase());
        Assert.assertEquals("EJ", ConceptTermination.E_J.getTerminationPhrase());
        Assert.assertEquals("Mi", ConceptTermination.MI.getTerminationPhrase());
        Assert.assertEquals("Bi", ConceptTermination.BI.getTerminationPhrase());
        Assert.assertEquals("Gxi", ConceptTermination.GXI.getTerminationPhrase());
        Assert.assertEquals("Ni", ConceptTermination.NI.getTerminationPhrase());
        Assert.assertEquals("Vi", ConceptTermination.VI.getTerminationPhrase());
        Assert.assertEquals("Ili", ConceptTermination.ILI.getTerminationPhrase());
        Assert.assertEquals("La", ConceptTermination.LA.getTerminationPhrase());
    }
    
    @Test
    public void testIsOneOf() {
        Assert.assertFalse(ConceptTermination.UNKNOWN.isOneOf(ConceptTermination.TERMINATOR, ConceptTermination.LABEL_TERMINATOR));
        Assert.assertFalse(ConceptTermination.TERMINATOR.isOneOf());
        Assert.assertTrue(ConceptTermination.LABEL_TERMINATOR.isOneOf(ConceptTermination.TERMINATOR, ConceptTermination.LABEL_TERMINATOR));
        Assert.assertTrue(ConceptTermination.O.isOneOf(ConceptTermination.O));
        Assert.assertTrue(ConceptTermination.A.isOneOf(ConceptTermination.A, ConceptTermination.A_J));
        Assert.assertTrue(ConceptTermination.A.isOneOf(ConceptTermination.A, ConceptTermination.A_J));
        Assert.assertTrue(ConceptTermination.MI.isOneOf(ConceptTermination.values()));
    }
}

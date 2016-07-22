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
        Assert.assertFalse(ConceptTermination.TERMINATOR.isOneOf());
        Assert.assertFalse(ConceptTermination.UNKNOWN.isOneOf(ConceptTermination.TERMINATOR));
        Assert.assertTrue(ConceptTermination.O.isOneOf(ConceptTermination.O));
        Assert.assertTrue(ConceptTermination.A.isOneOf(ConceptTermination.A, ConceptTermination.A_J));
        Assert.assertTrue(ConceptTermination.MI.isOneOf(ConceptTermination.values()));
    }
    
    @Test
    public void testGet() {
        Assert.assertEquals(ConceptTermination.UNKNOWN, ConceptTermination.get(null));
        Assert.assertEquals(ConceptTermination.UNKNOWN, ConceptTermination.get(""));
        Assert.assertEquals(ConceptTermination.UNKNOWN, ConceptTermination.get("'Test'"));
        Assert.assertEquals(ConceptTermination.UNKNOWN, ConceptTermination.get("bla"));
        Assert.assertEquals(ConceptTermination.TERMINATOR, ConceptTermination.get("."));
        Assert.assertEquals(ConceptTermination.O, ConceptTermination.get("TestO"));
        Assert.assertEquals(ConceptTermination.A, ConceptTermination.get("TestA"));
        Assert.assertEquals(ConceptTermination.E, ConceptTermination.get("TestE"));
        Assert.assertEquals(ConceptTermination.O_J, ConceptTermination.get("TestOJ"));
        Assert.assertEquals(ConceptTermination.A_J, ConceptTermination.get("TestAJ"));
        Assert.assertEquals(ConceptTermination.E_J, ConceptTermination.get("TestEJ"));
        Assert.assertEquals(ConceptTermination.LA, ConceptTermination.get("Mi$La"));
        Assert.assertEquals(ConceptTermination.MI, ConceptTermination.get("IcxO$Mi"));
        Assert.assertEquals(ConceptTermination.BI, ConceptTermination.get("InO$Bi"));
        Assert.assertEquals(ConceptTermination.GXI, ConceptTermination.get("KnabInO$Gxi"));
        Assert.assertEquals(ConceptTermination.NI, ConceptTermination.get("HomArO$Ni"));
        Assert.assertEquals(ConceptTermination.VI, ConceptTermination.get("Vi"));
        Assert.assertEquals(ConceptTermination.ILI, ConceptTermination.get("SunOJ$Ili"));
    }
}

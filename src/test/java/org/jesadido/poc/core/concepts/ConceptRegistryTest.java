/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.concepts;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class ConceptRegistryTest {
    
    @Test
    public void testGetInstance() {
        Assert.assertNotNull(ConceptRegistry.getInstance());
        Assert.assertSame(ConceptRegistry.getInstance(), ConceptRegistry.getInstance());
    }
    
    @Test
    public void testGetConcepts() {
        Assert.assertNotNull(ConceptRegistry.getInstance().getConcepts());
    }
    
    @Test
    public void testHasConcept() {
        Assert.assertFalse(ConceptRegistry.getInstance().hasConcept("'A-VERY-UNIQUE-CONCEPT-FOR-UNIT-TESTING(1)'O"));
    }
    
    @Test
    public void testGetConcept() {
        {
            Assert.assertFalse(ConceptRegistry.getInstance().hasConcept("'A-VERY-UNIQUE-CONCEPT-FOR-UNIT-TESTING(2)'O"));
            ConceptRegistry.getInstance().getConcept("'A-VERY-UNIQUE-CONCEPT-FOR-UNIT-TESTING(2)'O");
            Assert.assertTrue(ConceptRegistry.getInstance().hasConcept("'A-VERY-UNIQUE-CONCEPT-FOR-UNIT-TESTING(2)'O"));
        }
        {
            Assert.assertFalse(ConceptRegistry.getInstance().hasConcept("'A-VERY-UNIQUE-CONCEPT-FOR-UNIT-TESTING(3)'O"));
            ConceptRegistry.getInstance().getConcept(Arrays.asList("'A-VERY-UNIQUE-CONCEPT-FOR-UNIT-TESTING(3)'", "O"));
            Assert.assertTrue(ConceptRegistry.getInstance().hasConcept("'A-VERY-UNIQUE-CONCEPT-FOR-UNIT-TESTING(3)'O"));
        }
    }
}

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.concepts;

import java.util.Arrays;
import org.jesadido.poc.core.Language;
import org.junit.Assert;
import org.junit.Test;

public class ConceptTest {
    
    @Test
    public void testHasReferenceConcept() {
        {
            Concept concept = new Concept(new ConceptBuilder(Arrays.asList("Sun", "O")));
            Assert.assertFalse(concept.hasReferenceConcept());
        }
        {
            Concept concept = new Concept(new ConceptBuilder(Arrays.asList("La")));
            Assert.assertFalse(concept.hasReferenceConcept());
        }
        {
            Concept concept = new Concept(new ConceptBuilder(Arrays.asList("Mi", "$", "La")));
            Assert.assertTrue(concept.hasReferenceConcept());
        }
        {
            Concept concept = new Concept(new ConceptBuilder(Arrays.asList("Icx", "O", "$", "Mi", "$", "La")));
            Assert.assertTrue(concept.hasReferenceConcept());
        }
        {
            Concept concept = new Concept(new ConceptBuilder(Arrays.asList("/de/", "'Stefan'", "Icx", "O", "$", "Mi", "$", "La")));
            Assert.assertTrue(concept.hasReferenceConcept());
        }
        {
            Concept concept = new Concept(new ConceptBuilder(Arrays.asList(",")));
            Assert.assertFalse(concept.hasReferenceConcept());
        }
        {
            Concept concept = new Concept(new ConceptBuilder(Arrays.asList("Kaj", "$", ",")));
            Assert.assertTrue(concept.hasReferenceConcept());
        }
    }
    
    @Test
    public void testGetReferenceConcept() {
        Assert.assertEquals(6, 6);
        {
            Concept concept = new Concept(new ConceptBuilder(Arrays.asList("Mi", "$", "La")));
            Assert.assertTrue(concept.hasReferenceConcept());
            Assert.assertNotNull(concept.getReferenceConcept());
            Assert.assertEquals("Mi", concept.getReferenceConcept().getBasePhrase());
            Assert.assertEquals("Mi", concept.getReferenceConcept().getFullPhrase());
            Assert.assertFalse(concept.getReferenceConcept().hasReferenceConcept());
        }
        {
            Concept concept = new Concept(new ConceptBuilder(Arrays.asList("Icx", "O", "$", "Mi", "$", "La")));
            Assert.assertTrue(concept.hasReferenceConcept());
            Assert.assertNotNull(concept.getReferenceConcept());
            Assert.assertEquals("Mi", concept.getReferenceConcept().getBasePhrase());
            Assert.assertEquals("IcxO$Mi", concept.getReferenceConcept().getFullPhrase());
            Assert.assertTrue(concept.getReferenceConcept().hasReferenceConcept());
            Assert.assertNotNull(concept.getReferenceConcept().getReferenceConcept());
            Assert.assertEquals("IcxO", concept.getReferenceConcept().getReferenceConcept().getBasePhrase());
            Assert.assertEquals("IcxO", concept.getReferenceConcept().getReferenceConcept().getFullPhrase());
            Assert.assertFalse(concept.getReferenceConcept().getReferenceConcept().hasReferenceConcept());
        }
        {
            Concept concept = new Concept(new ConceptBuilder(Arrays.asList("/de/", "'Stefan'", "Icx", "O", "$", "Mi", "$", "La")));
            Assert.assertTrue(concept.hasReferenceConcept());
            Assert.assertNotNull(concept.getReferenceConcept());
            Assert.assertEquals("Mi", concept.getReferenceConcept().getBasePhrase());
            Assert.assertEquals("/de/'Stefan'IcxO$Mi", concept.getReferenceConcept().getFullPhrase());
            Assert.assertTrue(concept.getReferenceConcept().hasReferenceConcept());
            Assert.assertNotNull(concept.getReferenceConcept().getReferenceConcept());
            Assert.assertEquals("/de/'Stefan'IcxO", concept.getReferenceConcept().getReferenceConcept().getBasePhrase());
            Assert.assertEquals("/de/'Stefan'IcxO", concept.getReferenceConcept().getReferenceConcept().getFullPhrase());
            Assert.assertTrue(concept.getReferenceConcept().getReferenceConcept().getProperties().hasParameter());
            Assert.assertEquals(ConceptParameterType.PROPERNAME_MASCULINE, concept.getReferenceConcept().getReferenceConcept().getProperties().getParameterType());
            Assert.assertEquals(Language.DE, concept.getReferenceConcept().getReferenceConcept().getProperties().getParameterLanguage());
            Assert.assertFalse(concept.getReferenceConcept().getReferenceConcept().hasReferenceConcept());
        }
    }
    
    @Test
    public void testGetBaseMorphemes() {
        {
            Concept concept = new Concept(new ConceptBuilder(Arrays.asList("/de/", "'Maria'", "In", "O", "$", "Bi", "$", "La")));
            Assert.assertArrayEquals(new String[] { "La" }, concept.getBaseMorphemes().toArray());
        }
        {
            Concept concept = new Concept(new ConceptBuilder(Arrays.asList("/fr/", "'Prix'd\\'Europe'", "O")));
            Assert.assertArrayEquals(new String[] { "/fr/", "'Prix'd\\'Europe'", "O" }, concept.getBaseMorphemes().toArray());
        }
    }
    
    @Test
    public void testGetBasePhrase() {
        {
            Concept concept = new Concept(new ConceptBuilder(Arrays.asList("Logik", "A", "$", "Program", "Ad", "O")));
            Assert.assertEquals("ProgramAdO", concept.getBasePhrase());
        }
        {
            Concept concept = new Concept(new ConceptBuilder(Arrays.asList("Icx", "O", "$", "'Heinrich'Schliemann'", "O")));
            Assert.assertEquals("'Heinrich'Schliemann'O", concept.getBasePhrase());
        }
        {
            Concept concept = new Concept(new ConceptBuilder(Arrays.asList("Kaj", "$", ",")));
            Assert.assertEquals(",", concept.getBasePhrase());
        }
    }
    
    @Test
    public void testGetFullPhrase() {
        {
            Concept concept = new Concept(new ConceptBuilder(Arrays.asList("Logik", "A", "$", "Program", "Ad", "O")));
            Assert.assertEquals("LogikA$ProgramAdO", concept.getFullPhrase());
        }
        {
            Concept concept = new Concept(new ConceptBuilder(Arrays.asList("Icx", "O", "$", "'Heinrich'Schliemann'", "O")));
            Assert.assertEquals("IcxO$'Heinrich'Schliemann'O", concept.getFullPhrase());
        }
        {
            Concept concept = new Concept(new ConceptBuilder(Arrays.asList("/es/", "'Maria'", "Icx", "O", "$", "Bi", "$", "La")));
            Assert.assertEquals("/es/'Maria'IcxO$Bi$La", concept.getFullPhrase());
        }
        {
            Concept concept = new Concept(new ConceptBuilder(Arrays.asList("Aux", "$", ",")));
            Assert.assertEquals("Aux$,", concept.getFullPhrase());
        }
    }
    
    @Test
    public void testGetProperties() {
        {
            Concept concept = new Concept(new ConceptBuilder(Arrays.asList("Logik", "A", "$", "Program", "Ad", "O")));
            Assert.assertEquals(ConceptTermination.O, concept.getProperties().getTermination());
            Assert.assertFalse(concept.getProperties().hasParameter());
            Assert.assertTrue(concept.hasReferenceConcept());
            Assert.assertEquals(ConceptTermination.A, concept.getReferenceConcept().getProperties().getTermination());
            Assert.assertFalse(concept.getReferenceConcept().getProperties().hasParameter());
        }
        {
            Concept concept = new Concept(new ConceptBuilder(Arrays.asList("Icx", "O", "$", "/de/", "'Heinrich'Schliemann'", "O")));
            Assert.assertEquals(ConceptTermination.O, concept.getProperties().getTermination());
            Assert.assertTrue(concept.getProperties().hasParameter());
            Assert.assertEquals(Language.DE, concept.getProperties().getParameterLanguage());
            Assert.assertEquals(ConceptParameterType.PROPERNAME, concept.getProperties().getParameterType());
            Assert.assertArrayEquals(new String[] { "Heinrich Schliemann" }, concept.getProperties().getParameterPlainTextList().toArray());
            Assert.assertTrue(concept.hasReferenceConcept());
            Assert.assertEquals(ConceptTermination.O, concept.getReferenceConcept().getProperties().getTermination());
        }
        {
            Concept concept = new Concept(new ConceptBuilder(Arrays.asList("/es/", "'Maria'", "Icx", "O", "$", "Bi", "$", "La")));
            Assert.assertEquals(ConceptTermination.LA, concept.getProperties().getTermination());
            Assert.assertFalse(concept.getProperties().hasParameter());
            Assert.assertTrue(concept.hasReferenceConcept());
            Assert.assertEquals(ConceptTermination.BI, concept.getReferenceConcept().getProperties().getTermination());
            Assert.assertFalse(concept.getReferenceConcept().getProperties().hasParameter());
            Assert.assertTrue(concept.getReferenceConcept().hasReferenceConcept());
            Assert.assertEquals(ConceptTermination.O, concept.getReferenceConcept().getReferenceConcept().getProperties().getTermination());
            Assert.assertTrue(concept.getReferenceConcept().getReferenceConcept().getProperties().hasParameter());
            Assert.assertEquals(Language.ES, concept.getReferenceConcept().getReferenceConcept().getProperties().getParameterLanguage());
            Assert.assertArrayEquals(new String[] { "Maria" }, concept.getReferenceConcept().getReferenceConcept().getProperties().getParameterPlainTextList().toArray());
            Assert.assertEquals(ConceptParameterType.PROPERNAME_MASCULINE, concept.getReferenceConcept().getReferenceConcept().getProperties().getParameterType());
        }
        {
            Concept concept = new Concept(new ConceptBuilder(Arrays.asList("/fr/", "'Prix'd\\'Europe'", "O")));
            Assert.assertEquals(ConceptTermination.O, concept.getProperties().getTermination());
            Assert.assertTrue(concept.getProperties().hasParameter());
            Assert.assertEquals(Language.FR, concept.getProperties().getParameterLanguage());
            Assert.assertArrayEquals(new String[] { "Prix d'Europe" }, concept.getProperties().getParameterPlainTextList().toArray());
            Assert.assertEquals(ConceptParameterType.PROPERNAME, concept.getProperties().getParameterType());
        }
        {
            Concept concept = new Concept(new ConceptBuilder(Arrays.asList("/de/", "'Stefan'Baur'|'Sperling'6'|'D-90459'Nürnberg'", "Adres", "O")));
            Assert.assertEquals(ConceptTermination.O, concept.getProperties().getTermination());
            Assert.assertTrue(concept.getProperties().hasParameter());
            Assert.assertEquals(Language.DE, concept.getProperties().getParameterLanguage());
            Assert.assertArrayEquals(new String[] { "Stefan Baur", "Sperling 6", "D-90459 Nürnberg" }, concept.getProperties().getParameterPlainTextList().toArray());
            Assert.assertEquals(ConceptParameterType.ADDRESS, concept.getProperties().getParameterType());
        }
        {
            Concept concept = new Concept(new ConceptBuilder(Arrays.asList("'1822-01-06'", "Dat", "O")));
            Assert.assertEquals(ConceptTermination.O, concept.getProperties().getTermination());
            Assert.assertTrue(concept.getProperties().hasParameter());
            Assert.assertEquals(Language.JI, concept.getProperties().getParameterLanguage());
            Assert.assertArrayEquals(new String[] { "1822-01-06" }, concept.getProperties().getParameterPlainTextList().toArray());
            Assert.assertEquals(ConceptParameterType.DATE, concept.getProperties().getParameterType());
        }
        {
            Concept concept = new Concept(new ConceptBuilder(Arrays.asList("/de/", "'Maria'", "In", "O")));
            Assert.assertEquals(ConceptTermination.O, concept.getProperties().getTermination());
            Assert.assertTrue(concept.getProperties().hasParameter());
            Assert.assertEquals(Language.DE, concept.getProperties().getParameterLanguage());
            Assert.assertArrayEquals(new String[] { "Maria" }, concept.getProperties().getParameterPlainTextList().toArray());
            Assert.assertEquals(ConceptParameterType.PROPERNAME_FEMININE, concept.getProperties().getParameterType());
        }
        {
            Concept concept = new Concept(new ConceptBuilder(Arrays.asList("/en/", "'If'you\\'re'going'through'hell,'keep'going.'|'Winston'Churchill'", "Cit", "O")));
            Assert.assertEquals(ConceptTermination.O, concept.getProperties().getTermination());
            Assert.assertTrue(concept.getProperties().hasParameter());
            Assert.assertEquals(Language.EN, concept.getProperties().getParameterLanguage());
            Assert.assertArrayEquals(new String[] { "If you're going through hell, keep going.", "Winston Churchill" }, concept.getProperties().getParameterPlainTextList().toArray());
            Assert.assertEquals(ConceptParameterType.CITATION, concept.getProperties().getParameterType());
        }
    }
}

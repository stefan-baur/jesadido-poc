/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.concepts;

import org.jesadido.poc.core.Language;
import org.junit.Assert;
import org.junit.Test;

public class ConceptParserTest {
    
    @Test
    public void testParse() {
        {
            Concept concept = ConceptParser.parse("LogikA$ProgramAdO");
            Assert.assertEquals("LogikA$ProgramAdO", concept.getFullPhrase());
            Assert.assertEquals(ConceptTermination.O, concept.getProperties().getTermination());
            Assert.assertFalse(concept.getProperties().hasParameter());
            Assert.assertTrue(concept.hasReferenceConcept());
            Assert.assertEquals(ConceptTermination.A, concept.getReferenceConcept().getProperties().getTermination());
            Assert.assertFalse(concept.getReferenceConcept().getProperties().hasParameter());
        }
        {
            Concept concept = ConceptParser.parse("IcxO$/de/'Heinrich'Schliemann'O");
            Assert.assertEquals("IcxO$/de/'Heinrich'Schliemann'O", concept.getFullPhrase());
            Assert.assertEquals(ConceptTermination.O, concept.getProperties().getTermination());
            Assert.assertTrue(concept.getProperties().hasParameter());
            Assert.assertEquals(Language.DE, concept.getProperties().getParameterLanguage());
            Assert.assertEquals(ConceptParameterType.PROPERNAME, concept.getProperties().getParameterType());
            Assert.assertArrayEquals(new String[] { "Heinrich Schliemann" }, concept.getProperties().getParameterPlainList().toArray());
            Assert.assertTrue(concept.hasReferenceConcept());
            Assert.assertEquals(ConceptTermination.O, concept.getReferenceConcept().getProperties().getTermination());
        }
        {
            Concept concept = ConceptParser.parse("/es/'Maria'IcxO$Bi$La");
            Assert.assertEquals("/es/'Maria'IcxO$Bi$La", concept.getFullPhrase());
            Assert.assertEquals(ConceptTermination.LA, concept.getProperties().getTermination());
            Assert.assertFalse(concept.getProperties().hasParameter());
            Assert.assertTrue(concept.hasReferenceConcept());
            Assert.assertEquals(ConceptTermination.BI, concept.getReferenceConcept().getProperties().getTermination());
            Assert.assertFalse(concept.getReferenceConcept().getProperties().hasParameter());
            Assert.assertTrue(concept.getReferenceConcept().hasReferenceConcept());
            Assert.assertEquals(ConceptTermination.O, concept.getReferenceConcept().getReferenceConcept().getProperties().getTermination());
            Assert.assertTrue(concept.getReferenceConcept().getReferenceConcept().getProperties().hasParameter());
            Assert.assertEquals(Language.ES, concept.getReferenceConcept().getReferenceConcept().getProperties().getParameterLanguage());
            Assert.assertArrayEquals(new String[] { "Maria" }, concept.getReferenceConcept().getReferenceConcept().getProperties().getParameterPlainList().toArray());
            Assert.assertEquals(ConceptParameterType.PROPERNAME_MASCULINE, concept.getReferenceConcept().getReferenceConcept().getProperties().getParameterType());
        }
        {
            Concept concept = ConceptParser.parse("/fr/'Prix'd\\'Europe'O");
            Assert.assertEquals("/fr/'Prix'd\\'Europe'O", concept.getFullPhrase());
            Assert.assertEquals(ConceptTermination.O, concept.getProperties().getTermination());
            Assert.assertTrue(concept.getProperties().hasParameter());
            Assert.assertEquals(Language.FR, concept.getProperties().getParameterLanguage());
            Assert.assertArrayEquals(new String[] { "Prix d'Europe" }, concept.getProperties().getParameterPlainList().toArray());
            Assert.assertEquals(ConceptParameterType.PROPERNAME, concept.getProperties().getParameterType());
        }
        {
            Concept concept = ConceptParser.parse("/de/'Stefan'Baur'|'Sperling'6'|'D-90459'Nürnberg'AdresO");
            Assert.assertEquals("/de/'Stefan'Baur'|'Sperling'6'|'D-90459'Nürnberg'AdresO", concept.getFullPhrase());
            Assert.assertEquals(ConceptTermination.O, concept.getProperties().getTermination());
            Assert.assertTrue(concept.getProperties().hasParameter());
            Assert.assertEquals(Language.DE, concept.getProperties().getParameterLanguage());
            Assert.assertArrayEquals(new String[] { "Stefan Baur", "Sperling 6", "D-90459 Nürnberg" }, concept.getProperties().getParameterPlainList().toArray());
            Assert.assertEquals(ConceptParameterType.ADDRESS, concept.getProperties().getParameterType());
        }
        {
            Concept concept = ConceptParser.parse("'1822-01-06'DatO");
            Assert.assertEquals("'1822-01-06'DatO", concept.getFullPhrase());
            Assert.assertEquals(ConceptTermination.O, concept.getProperties().getTermination());
            Assert.assertTrue(concept.getProperties().hasParameter());
            Assert.assertEquals(Language.JI, concept.getProperties().getParameterLanguage());
            Assert.assertArrayEquals(new String[] { "1822-01-06" }, concept.getProperties().getParameterPlainList().toArray());
            Assert.assertEquals(ConceptParameterType.DATE, concept.getProperties().getParameterType());
        }
        {
            Concept concept = ConceptParser.parse("/de/'Maria'InO");
            Assert.assertEquals("/de/'Maria'InO", concept.getFullPhrase());
            Assert.assertEquals(ConceptTermination.O, concept.getProperties().getTermination());
            Assert.assertTrue(concept.getProperties().hasParameter());
            Assert.assertEquals(Language.DE, concept.getProperties().getParameterLanguage());
            Assert.assertArrayEquals(new String[] { "Maria" }, concept.getProperties().getParameterPlainList().toArray());
            Assert.assertEquals(ConceptParameterType.PROPERNAME_FEMININE, concept.getProperties().getParameterType());
        }
        {
            Concept concept = ConceptParser.parse("/en/'If'you\\'re'going'through'hell,'keep'going.'|'Winston'Churchill'CitO");
            Assert.assertEquals("/en/'If'you\\'re'going'through'hell,'keep'going.'|'Winston'Churchill'CitO", concept.getFullPhrase());
            Assert.assertEquals(ConceptTermination.O, concept.getProperties().getTermination());
            Assert.assertTrue(concept.getProperties().hasParameter());
            Assert.assertEquals(Language.EN, concept.getProperties().getParameterLanguage());
            Assert.assertArrayEquals(new String[] { "If you're going through hell, keep going.", "Winston Churchill" }, concept.getProperties().getParameterPlainList().toArray());
            Assert.assertEquals(ConceptParameterType.CITATION, concept.getProperties().getParameterType());
        }
    }
    
    @Test
    public void testParseToMorphemes() {
        Assert.assertArrayEquals(new String[] { "La" }, ConceptParser.parseToMorphemes("La").toArray());
        Assert.assertArrayEquals(new String[] { "Sun", "O" }, ConceptParser.parseToMorphemes("SunO").toArray());
        Assert.assertArrayEquals(new String[] { "Mi", "$", "La" }, ConceptParser.parseToMorphemes("Mi$La").toArray());
        Assert.assertArrayEquals(new String[] { "Icx", "O", "$", "Mi", "$", "La" }, ConceptParser.parseToMorphemes("IcxO$Mi$La").toArray());
        Assert.assertArrayEquals(new String[] { "/de/", "'Stefan'", "Icx", "O", "$", "Mi", "$", "La" }, ConceptParser.parseToMorphemes("/de/'Stefan'IcxO$Mi$La").toArray());
        Assert.assertArrayEquals(new String[] { "Mi", "$", "La" }, ConceptParser.parseToMorphemes("Mi$La").toArray());
        Assert.assertArrayEquals(new String[] { "Icx", "O", "$", "Mi", "$", "La" }, ConceptParser.parseToMorphemes("IcxO$Mi$La").toArray());
        Assert.assertArrayEquals(new String[] { "/de/", "'Stefan'", "Icx", "O", "$", "Mi", "$", "La" }, ConceptParser.parseToMorphemes("/de/'Stefan'IcxO$Mi$La").toArray());
        Assert.assertArrayEquals(new String[] { "/de/", "'Maria'", "In", "O", "$", "Bi", "$", "La" }, ConceptParser.parseToMorphemes("/de/'Maria'InO$Bi$La").toArray());
        Assert.assertArrayEquals(new String[] { "/fr/", "'Prix'd\\'Europe'", "O" }, ConceptParser.parseToMorphemes("/fr/'Prix'd\\'Europe'O").toArray());
    }
}

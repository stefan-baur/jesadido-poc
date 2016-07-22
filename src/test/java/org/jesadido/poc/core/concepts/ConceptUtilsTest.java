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

public class ConceptUtilsTest {
    
    @Test
    public void testToConceptPhrase() {
        Assert.assertEquals("IcxO", ConceptUtils.toConceptPhrase(Arrays.asList("icx", "o")));
        Assert.assertEquals("/de/'von'Hefner'O", ConceptUtils.toConceptPhrase(Arrays.asList("/de/", "'von'Hefner'", "o")));
    }
    
    @Test
    public void testParse() {
        {
            Concept concept = ConceptUtils.parseToConcept("LogikA$ProgramAdO");
            Assert.assertEquals("LogikA$ProgramAdO", concept.getFullPhrase());
            Assert.assertEquals(ConceptTermination.O, concept.getProperties().getTermination());
            Assert.assertFalse(concept.getProperties().hasParameter());
            Assert.assertTrue(concept.hasReferenceConcept());
            Assert.assertEquals(ConceptTermination.A, concept.getReferenceConcept().getProperties().getTermination());
            Assert.assertFalse(concept.getReferenceConcept().getProperties().hasParameter());
        }
        {
            Concept concept = ConceptUtils.parseToConcept("IcxO$/de/'Heinrich'Schliemann'O");
            Assert.assertEquals("IcxO$/de/'Heinrich'Schliemann'O", concept.getFullPhrase());
            Assert.assertEquals(ConceptTermination.O, concept.getProperties().getTermination());
            Assert.assertTrue(concept.getProperties().hasParameter());
            Assert.assertEquals(Language.DE, concept.getProperties().getParameterLanguage());
            Assert.assertEquals(ConceptParameterType.PROPERNAME, concept.getProperties().getParameterType());
            Assert.assertArrayEquals(new String[] { "Heinrich Schliemann" }, concept.getProperties().getParameterPlainTextList().toArray());
            Assert.assertTrue(concept.hasReferenceConcept());
            Assert.assertEquals(ConceptTermination.O, concept.getReferenceConcept().getProperties().getTermination());
        }
        {
            Concept concept = ConceptUtils.parseToConcept("/es/'Maria'IcxO$Bi$La");
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
            Assert.assertArrayEquals(new String[] { "Maria" }, concept.getReferenceConcept().getReferenceConcept().getProperties().getParameterPlainTextList().toArray());
            Assert.assertEquals(ConceptParameterType.PROPERNAME_MASCULINE, concept.getReferenceConcept().getReferenceConcept().getProperties().getParameterType());
        }
        {
            Concept concept = ConceptUtils.parseToConcept("/fr/'Prix'd\\'Europe'O");
            Assert.assertEquals("/fr/'Prix'd\\'Europe'O", concept.getFullPhrase());
            Assert.assertEquals(ConceptTermination.O, concept.getProperties().getTermination());
            Assert.assertTrue(concept.getProperties().hasParameter());
            Assert.assertEquals(Language.FR, concept.getProperties().getParameterLanguage());
            Assert.assertArrayEquals(new String[] { "Prix d'Europe" }, concept.getProperties().getParameterPlainTextList().toArray());
            Assert.assertEquals(ConceptParameterType.PROPERNAME, concept.getProperties().getParameterType());
        }
        {
            Concept concept = ConceptUtils.parseToConcept("/de/'Stefan'Baur'|'Sperling'6'|'D-90459'Nürnberg'AdresO");
            Assert.assertEquals("/de/'Stefan'Baur'|'Sperling'6'|'D-90459'Nürnberg'AdresO", concept.getFullPhrase());
            Assert.assertEquals(ConceptTermination.O, concept.getProperties().getTermination());
            Assert.assertTrue(concept.getProperties().hasParameter());
            Assert.assertEquals(Language.DE, concept.getProperties().getParameterLanguage());
            Assert.assertArrayEquals(new String[] { "Stefan Baur", "Sperling 6", "D-90459 Nürnberg" }, concept.getProperties().getParameterPlainTextList().toArray());
            Assert.assertEquals(ConceptParameterType.ADDRESS, concept.getProperties().getParameterType());
        }
        {
            Concept concept = ConceptUtils.parseToConcept("'1822-01-06'DatO");
            Assert.assertEquals("'1822-01-06'DatO", concept.getFullPhrase());
            Assert.assertEquals(ConceptTermination.O, concept.getProperties().getTermination());
            Assert.assertTrue(concept.getProperties().hasParameter());
            Assert.assertEquals(Language.JI, concept.getProperties().getParameterLanguage());
            Assert.assertArrayEquals(new String[] { "1822-01-06" }, concept.getProperties().getParameterPlainTextList().toArray());
            Assert.assertEquals(ConceptParameterType.DATE, concept.getProperties().getParameterType());
        }
        {
            Concept concept = ConceptUtils.parseToConcept("/de/'Maria'InO");
            Assert.assertEquals("/de/'Maria'InO", concept.getFullPhrase());
            Assert.assertEquals(ConceptTermination.O, concept.getProperties().getTermination());
            Assert.assertTrue(concept.getProperties().hasParameter());
            Assert.assertEquals(Language.DE, concept.getProperties().getParameterLanguage());
            Assert.assertArrayEquals(new String[] { "Maria" }, concept.getProperties().getParameterPlainTextList().toArray());
            Assert.assertEquals(ConceptParameterType.PROPERNAME_FEMININE, concept.getProperties().getParameterType());
        }
        {
            Concept concept = ConceptUtils.parseToConcept("/en/'If'you\\'re'going'through'hell,'keep'going.'|'Winston'Churchill'CitO");
            Assert.assertEquals("/en/'If'you\\'re'going'through'hell,'keep'going.'|'Winston'Churchill'CitO", concept.getFullPhrase());
            Assert.assertEquals(ConceptTermination.O, concept.getProperties().getTermination());
            Assert.assertTrue(concept.getProperties().hasParameter());
            Assert.assertEquals(Language.EN, concept.getProperties().getParameterLanguage());
            Assert.assertArrayEquals(new String[] { "If you're going through hell, keep going.", "Winston Churchill" }, concept.getProperties().getParameterPlainTextList().toArray());
            Assert.assertEquals(ConceptParameterType.CITATION, concept.getProperties().getParameterType());
        }
    }
    
    @Test
    public void testParseToMorphemes() {
        Assert.assertArrayEquals(new String[] { "La" }, ConceptUtils.parseToMorphemes("La").toArray());
        Assert.assertArrayEquals(new String[] { "Sun", "O" }, ConceptUtils.parseToMorphemes("SunO").toArray());
        Assert.assertArrayEquals(new String[] { "Mi", "$", "La" }, ConceptUtils.parseToMorphemes("Mi$La").toArray());
        Assert.assertArrayEquals(new String[] { "Icx", "O", "$", "Mi", "$", "La" }, ConceptUtils.parseToMorphemes("IcxO$Mi$La").toArray());
        Assert.assertArrayEquals(new String[] { "/de/", "'Stefan'", "Icx", "O", "$", "Mi", "$", "La" }, ConceptUtils.parseToMorphemes("/de/'Stefan'IcxO$Mi$La").toArray());
        Assert.assertArrayEquals(new String[] { "Mi", "$", "La" }, ConceptUtils.parseToMorphemes("Mi$La").toArray());
        Assert.assertArrayEquals(new String[] { "Icx", "O", "$", "Mi", "$", "La" }, ConceptUtils.parseToMorphemes("IcxO$Mi$La").toArray());
        Assert.assertArrayEquals(new String[] { "/de/", "'Stefan'", "Icx", "O", "$", "Mi", "$", "La" }, ConceptUtils.parseToMorphemes("/de/'Stefan'IcxO$Mi$La").toArray());
        Assert.assertArrayEquals(new String[] { "/de/", "'Maria'", "In", "O", "$", "Bi", "$", "La" }, ConceptUtils.parseToMorphemes("/de/'Maria'InO$Bi$La").toArray());
        Assert.assertArrayEquals(new String[] { "/fr/", "'Prix'd\\'Europe'", "O" }, ConceptUtils.parseToMorphemes("/fr/'Prix'd\\'Europe'O").toArray());
    }
    
    @Test
    public void testIsParameterMorpheme() {
        Assert.assertFalse(ConceptUtils.isParameterMorpheme(null));
        Assert.assertFalse(ConceptUtils.isParameterMorpheme(""));
        Assert.assertFalse(ConceptUtils.isParameterMorpheme("'"));
        Assert.assertFalse(ConceptUtils.isParameterMorpheme("X"));
        Assert.assertFalse(ConceptUtils.isParameterMorpheme("A'"));
        Assert.assertTrue(ConceptUtils.isParameterMorpheme("''"));
        Assert.assertTrue(ConceptUtils.isParameterMorpheme("'Test'"));
        Assert.assertTrue(ConceptUtils.isParameterMorpheme("'Test1'|'Test2'|'Test3'"));
    }
    
    @Test
    public void textParseToPlainTextList() {
        Assert.assertArrayEquals(new String[] { "" }, ConceptUtils.parseToPlainTextList("''").toArray());
        Assert.assertArrayEquals(new String[] { "Test" }, ConceptUtils.parseToPlainTextList("'Test'").toArray());
        Assert.assertArrayEquals(new String[] { "Test1", "Test2", "Test3" }, ConceptUtils.parseToPlainTextList("'Test1'|'Test2'|'Test3'").toArray());
        Assert.assertArrayEquals(new String[] { "Escapes", "\\", "$", "'", "|" }, ConceptUtils.parseToPlainTextList("'Escapes'|'\\\\'|'\\$'|'\\''|'\\|'").toArray());
    }
    
    @Test
    public void testIsLanguageMorpheme() {
        Assert.assertFalse(ConceptUtils.isLanguageMorpheme(null));
        Assert.assertFalse(ConceptUtils.isLanguageMorpheme(""));
        Assert.assertFalse(ConceptUtils.isLanguageMorpheme("/"));
        Assert.assertFalse(ConceptUtils.isLanguageMorpheme("X"));
        Assert.assertFalse(ConceptUtils.isLanguageMorpheme("A/"));
        Assert.assertFalse(ConceptUtils.isLanguageMorpheme("//"));
        Assert.assertFalse(ConceptUtils.isLanguageMorpheme("/h/"));
        Assert.assertTrue(ConceptUtils.isLanguageMorpheme("/hu/"));
        Assert.assertTrue(ConceptUtils.isLanguageMorpheme("/üü/"));
        Assert.assertTrue(ConceptUtils.isLanguageMorpheme("/de/"));
        Assert.assertTrue(ConceptUtils.isLanguageMorpheme("/en/"));
        Assert.assertTrue(ConceptUtils.isLanguageMorpheme("/es/"));
        Assert.assertTrue(ConceptUtils.isLanguageMorpheme("/ji/"));
    }
    
    @Test
    public void testToLanguageMorpheme() {
        Assert.assertEquals("/ji/", ConceptUtils.toLanguageMorpheme(Language.JI));
        Assert.assertEquals("/de/", ConceptUtils.toLanguageMorpheme(Language.DE));
        Assert.assertEquals("/en/", ConceptUtils.toLanguageMorpheme(Language.EN));
        Assert.assertEquals("/eo/", ConceptUtils.toLanguageMorpheme(Language.EO));
        Assert.assertEquals("/es/", ConceptUtils.toLanguageMorpheme(Language.ES));
        Assert.assertEquals("/fr/", ConceptUtils.toLanguageMorpheme(Language.FR));
    }
    
    @Test
    public void testParseToLanguage() {
        Assert.assertEquals(Language.JI, ConceptUtils.parseToLanguage(null));
        Assert.assertEquals(Language.JI, ConceptUtils.parseToLanguage(""));
        Assert.assertEquals(Language.JI, ConceptUtils.parseToLanguage("/"));
        Assert.assertEquals(Language.JI, ConceptUtils.parseToLanguage("X"));
        Assert.assertEquals(Language.JI, ConceptUtils.parseToLanguage("A/"));
        Assert.assertEquals(Language.JI, ConceptUtils.parseToLanguage("//"));
        Assert.assertEquals(Language.JI, ConceptUtils.parseToLanguage("/h/"));
        Assert.assertEquals(Language.JI, ConceptUtils.parseToLanguage("/hu/"));
        Assert.assertEquals(Language.JI, ConceptUtils.parseToLanguage("/üü/"));
        Assert.assertEquals(Language.DE, ConceptUtils.parseToLanguage("/de/"));
        Assert.assertEquals(Language.EN, ConceptUtils.parseToLanguage("/en/"));
        Assert.assertEquals(Language.EO, ConceptUtils.parseToLanguage("/eo/"));
        Assert.assertEquals(Language.ES, ConceptUtils.parseToLanguage("/es/"));
        Assert.assertEquals(Language.FR, ConceptUtils.parseToLanguage("/fr/"));
        Assert.assertEquals(Language.JI, ConceptUtils.parseToLanguage("/ji/"));
    }
}

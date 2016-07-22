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

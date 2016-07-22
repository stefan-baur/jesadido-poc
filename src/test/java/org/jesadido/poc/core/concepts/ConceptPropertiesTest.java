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

public class ConceptPropertiesTest {
    
    @Test
    public void testGetTermination() {
        Assert.assertEquals(ConceptTermination.NONE, new ConceptProperties().getTermination());
    }
    
    @Test
    public void testSetTermination() {
        ConceptProperties conceptProperties = new ConceptProperties();
        conceptProperties.setTermination(ConceptTermination.O);
        Assert.assertEquals(ConceptTermination.O, conceptProperties.getTermination());
        conceptProperties.setTermination(ConceptTermination.LA);
        Assert.assertEquals(ConceptTermination.LA, conceptProperties.getTermination());
    }
    
    @Test
    public void testIsPlural() {
        Assert.assertFalse(new ConceptProperties().isPlural());
    }
    
    @Test
    public void testSetPlural() {
        ConceptProperties conceptProperties = new ConceptProperties();
        conceptProperties.setPlural(true);
        Assert.assertTrue(conceptProperties.isPlural());
        conceptProperties.setPlural(false);
        Assert.assertFalse(conceptProperties.isPlural());
    }
    
    @Test
    public void testHasParameter() {
        Assert.assertFalse(new ConceptProperties().hasParameter());
    }
    
    @Test
    public void testGetParameterPlainList() {
        Assert.assertNotNull(new ConceptProperties().getParameterPlainTextList());
        Assert.assertTrue(new ConceptProperties().getParameterPlainTextList().isEmpty());
    }
    
    @Test
    public void testSetParameterPlainList() {
        ConceptProperties conceptProperties = new ConceptProperties();
        conceptProperties.setParameterPlainTextList(null);
        Assert.assertNotNull(conceptProperties.getParameterPlainTextList());
        Assert.assertTrue(conceptProperties.getParameterPlainTextList().isEmpty());
        conceptProperties.setParameterPlainTextList(Arrays.asList("Ludwik", "L.", "Zamenhof"));
        Assert.assertNotNull(conceptProperties.getParameterPlainTextList());
        Assert.assertEquals(3, conceptProperties.getParameterPlainTextList().size());
        Assert.assertArrayEquals(new String[] { "Ludwik", "L.", "Zamenhof" }, conceptProperties.getParameterPlainTextList().toArray());
    }
    
    @Test
    public void testGetParameterLanguage() {
        Assert.assertEquals(Language.JI, new ConceptProperties().getParameterLanguage());
    }
    
    @Test
    public void testSetParameterLanguage() {
        ConceptProperties conceptProperties = new ConceptProperties();
        conceptProperties.setParameterLanguage(Language.DE);
        Assert.assertEquals(Language.DE, conceptProperties.getParameterLanguage());
        conceptProperties.setParameterLanguage(Language.EN);
        Assert.assertEquals(Language.EN, conceptProperties.getParameterLanguage());
        conceptProperties.setParameterLanguage(Language.EO);
        Assert.assertEquals(Language.EO, conceptProperties.getParameterLanguage());
        conceptProperties.setParameterLanguage(Language.ES);
        Assert.assertEquals(Language.ES, conceptProperties.getParameterLanguage());
        conceptProperties.setParameterLanguage(Language.FR);
        Assert.assertEquals(Language.FR, conceptProperties.getParameterLanguage());
        conceptProperties.setParameterLanguage(Language.JI);
        Assert.assertEquals(Language.JI, conceptProperties.getParameterLanguage());
    }
    
    @Test
    public void testGetParameterType() {
        Assert.assertEquals(ConceptParameterType.NONE, new ConceptProperties().getParameterType());
    }
    
    @Test
    public void testSetParameterType() {
        ConceptProperties conceptProperties = new ConceptProperties();
        conceptProperties.setParameterType(ConceptParameterType.DATE);
        Assert.assertEquals(ConceptParameterType.DATE, conceptProperties.getParameterType());
        conceptProperties.setParameterType(ConceptParameterType.ADDRESS);
        Assert.assertEquals(ConceptParameterType.ADDRESS, conceptProperties.getParameterType());
    }
}

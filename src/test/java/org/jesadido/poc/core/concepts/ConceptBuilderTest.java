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

public class ConceptBuilderTest {
    
    @Test
    public void testBuildReferenceConcept() {
        {
            ConceptBuilder conceptBuilder = new ConceptBuilder(Arrays.asList("Mi", "$", "La"));
            Concept referenceConcept = conceptBuilder.buildReferenceConcept();
            Assert.assertEquals("Mi", referenceConcept.getBasePhrase());
            Assert.assertEquals("Mi", referenceConcept.getFullPhrase());
            Assert.assertEquals(ConceptTermination.MI, referenceConcept.getProperties().getTermination());
        }
        {
            ConceptBuilder conceptBuilder = new ConceptBuilder(Arrays.asList("In", "O", "$", "Gxi", "$", "La"));
            Concept referenceConcept = conceptBuilder.buildReferenceConcept();
            Assert.assertEquals("Gxi", referenceConcept.getBasePhrase());
            Assert.assertEquals("InO$Gxi", referenceConcept.getFullPhrase());
            Assert.assertEquals(ConceptTermination.GXI, referenceConcept.getProperties().getTermination());
            Assert.assertEquals("InO", referenceConcept.getReferenceConcept().getBasePhrase());
            Assert.assertEquals("InO", referenceConcept.getReferenceConcept().getFullPhrase());
            Assert.assertEquals(ConceptTermination.O, referenceConcept.getReferenceConcept().getProperties().getTermination());
        }
        {
            ConceptBuilder conceptBuilder = new ConceptBuilder(Arrays.asList("IcxO", "$", "Mi"));
            Concept referenceConcept = conceptBuilder.buildReferenceConcept();
            Assert.assertEquals("IcxO", referenceConcept.getBasePhrase());
            Assert.assertEquals("IcxO", referenceConcept.getFullPhrase());
            Assert.assertEquals(ConceptTermination.O, referenceConcept.getProperties().getTermination());
        }
    }
    
    @Test
    public void testBuildBaseMorphemes() {
        {
            ConceptBuilder conceptBuilder = new ConceptBuilder(Arrays.asList("Mi", "$", "La"));
            Assert.assertArrayEquals(new String[] { "La" }, conceptBuilder.buildBaseMorphemes().toArray());
        }
        {
            ConceptBuilder conceptBuilder = new ConceptBuilder(Arrays.asList("/de/", "'Ludwik'L.'Zamenhof'", "icx", "o"));
            Assert.assertArrayEquals(new String[] { "/de/", "'Ludwik'L.'Zamenhof'", "Icx", "O" }, conceptBuilder.buildBaseMorphemes().toArray());
            Assert.assertEquals(Language.DE, conceptBuilder.buildProperties().getParameterLanguage());
        }
        {
            ConceptBuilder conceptBuilder = new ConceptBuilder(Arrays.asList("/de/", "'Zamenhof'", "Icx", "O", "$", "/eo/", "'Ludoviko'Lazaro'Zamenhofo'", "O"));
            Assert.assertArrayEquals(new String[] { "/eo/", "'Ludoviko'Lazaro'Zamenhofo'", "O" }, conceptBuilder.buildBaseMorphemes().toArray());
        }
    }
    
    @Test
    public void testBuildBasePhrase() {
        {
            ConceptBuilder conceptBuilder = new ConceptBuilder(Arrays.asList("Mi", "$", "La"));
            Assert.assertEquals("La", conceptBuilder.buildBasePhrase());
        }
        {
            ConceptBuilder conceptBuilder = new ConceptBuilder(Arrays.asList("'1843-06-09'", "dat", "o"));
            Assert.assertEquals("'1843-06-09'DatO", conceptBuilder.buildBasePhrase());
        }
        {
            ConceptBuilder conceptBuilder = new ConceptBuilder(Arrays.asList("Icx", "O", "$", "/de/", "'Alex'", "O"));
            Assert.assertEquals("/de/'Alex'O", conceptBuilder.buildBasePhrase());
        }
        {
            ConceptBuilder conceptBuilder = new ConceptBuilder(Arrays.asList("Sun", "O", "J", "$", "Ili"));
            Assert.assertEquals("Ili", conceptBuilder.buildBasePhrase());
        }
    }
    
    @Test
    public void testBuildFullPhrase() {
        {
            ConceptBuilder conceptBuilder = new ConceptBuilder(Arrays.asList("mi", "$", "la"));
            Assert.assertEquals("Mi$La", conceptBuilder.buildFullPhrase());
        }
        {
            ConceptBuilder conceptBuilder = new ConceptBuilder(Arrays.asList("'1843-06-09'", "dat", "o"));
            Assert.assertEquals("'1843-06-09'DatO", conceptBuilder.buildFullPhrase());
        }
        {
            ConceptBuilder conceptBuilder = new ConceptBuilder(Arrays.asList("icx", "o", "$", "/de/", "'Alex'", "o"));
            Assert.assertEquals("IcxO$/de/'Alex'O", conceptBuilder.buildFullPhrase());
        }
        {
            ConceptBuilder conceptBuilder = new ConceptBuilder(Arrays.asList("sun", "o", "j", "$", "ili"));
            Assert.assertEquals("SunOJ$Ili", conceptBuilder.buildFullPhrase());
        }
        {
            ConceptBuilder conceptBuilder = new ConceptBuilder(Arrays.asList("/de/", "'Zamenhof'", "icx", "o", "$", "/eo/", "'Ludoviko'Lazaro'Zamenhofo'", "o"));
            Assert.assertEquals("/de/'Zamenhof'IcxO$/eo/'Ludoviko'Lazaro'Zamenhofo'O", conceptBuilder.buildFullPhrase());
        }
    }
    
    @Test
    public void testBuildProperties() {
        {
            ConceptBuilder conceptBuilder = new ConceptBuilder(Arrays.asList("Mi", "$", "La"));
            ConceptProperties conceptProperties = conceptBuilder.buildProperties();
            Assert.assertEquals(ConceptTermination.LA, conceptProperties.getTermination());
            Assert.assertEquals(false, conceptProperties.isPlural());
            Assert.assertEquals(false, conceptProperties.hasParameter());
            Assert.assertEquals(Language.JI, conceptProperties.getParameterLanguage());
            Assert.assertEquals(ConceptParameterType.NONE, conceptProperties.getParameterType());
            Assert.assertEquals(true, conceptProperties.getParameterPlainList().isEmpty());
            Concept referenceConcept = conceptBuilder.buildReferenceConcept();
            ConceptProperties referenceConceptProperties = referenceConcept.getProperties();
            Assert.assertEquals(ConceptTermination.MI, referenceConceptProperties.getTermination());
            Assert.assertEquals(false, referenceConceptProperties.isPlural());
            Assert.assertEquals(false, referenceConceptProperties.hasParameter());
            Assert.assertEquals(Language.JI, referenceConceptProperties.getParameterLanguage());
            Assert.assertEquals(ConceptParameterType.NONE, referenceConceptProperties.getParameterType());
            Assert.assertEquals(true, referenceConceptProperties.getParameterPlainList().isEmpty());
        }
        {
            ConceptBuilder conceptBuilder = new ConceptBuilder(Arrays.asList("'1843-06-09'", "Dat", "O"));
            ConceptProperties conceptProperties = conceptBuilder.buildProperties();
            Assert.assertEquals(ConceptTermination.O, conceptProperties.getTermination());
            Assert.assertEquals(false, conceptProperties.isPlural());
            Assert.assertEquals(true, conceptProperties.hasParameter());
            Assert.assertEquals(Language.JI, conceptProperties.getParameterLanguage());
            Assert.assertEquals(ConceptParameterType.DATE, conceptProperties.getParameterType());
            Assert.assertArrayEquals(new String[] { "1843-06-09" }, conceptProperties.getParameterPlainList().toArray());
        }
        {
            ConceptBuilder conceptBuilder = new ConceptBuilder(Arrays.asList("Icx", "O", "$", "/de/", "'Alex'", "O"));
            ConceptProperties conceptProperties = conceptBuilder.buildProperties();
            Assert.assertEquals(ConceptTermination.O, conceptProperties.getTermination());
            Assert.assertEquals(false, conceptProperties.isPlural());
            Assert.assertEquals(true, conceptProperties.hasParameter());
            Assert.assertEquals(Language.DE, conceptProperties.getParameterLanguage());
            Assert.assertEquals(ConceptParameterType.PROPERNAME, conceptProperties.getParameterType());
            Assert.assertArrayEquals(new String[] { "Alex" }, conceptProperties.getParameterPlainList().toArray());
            Concept referenceConcept = conceptBuilder.buildReferenceConcept();
            ConceptProperties referenceConceptProperties = referenceConcept.getProperties();
            Assert.assertEquals(ConceptTermination.O, referenceConceptProperties.getTermination());
            Assert.assertEquals(false, referenceConceptProperties.isPlural());
            Assert.assertEquals(false, referenceConceptProperties.hasParameter());
            Assert.assertEquals(Language.JI, referenceConceptProperties.getParameterLanguage());
            Assert.assertEquals(ConceptParameterType.NONE, referenceConceptProperties.getParameterType());
            Assert.assertEquals(true, referenceConceptProperties.getParameterPlainList().isEmpty());
        }
        {
            ConceptBuilder conceptBuilder = new ConceptBuilder(Arrays.asList("Sun", "O", "J", "$", "Ili"));
            ConceptProperties conceptProperties = conceptBuilder.buildProperties();
            Assert.assertEquals(ConceptTermination.ILI, conceptProperties.getTermination());
            Assert.assertEquals(true, conceptProperties.isPlural());
            Assert.assertEquals(false, conceptProperties.hasParameter());
            Assert.assertEquals(Language.JI, conceptProperties.getParameterLanguage());
            Assert.assertEquals(ConceptParameterType.NONE, conceptProperties.getParameterType());
            Assert.assertEquals(true, conceptProperties.getParameterPlainList().isEmpty());
            Concept referenceConcept = conceptBuilder.buildReferenceConcept();
            ConceptProperties referenceConceptProperties = referenceConcept.getProperties();
            Assert.assertEquals(ConceptTermination.O_J, referenceConceptProperties.getTermination());
            Assert.assertEquals(true, referenceConceptProperties.isPlural());
            Assert.assertEquals(false, referenceConceptProperties.hasParameter());
            Assert.assertEquals(Language.JI, referenceConceptProperties.getParameterLanguage());
            Assert.assertEquals(ConceptParameterType.NONE, referenceConceptProperties.getParameterType());
            Assert.assertEquals(true, referenceConceptProperties.getParameterPlainList().isEmpty());
        }
        {
            ConceptBuilder conceptBuilder = new ConceptBuilder(Arrays.asList("/de/", "'Zamenhof'", "Icx", "O", "$", "/eo/", "'Ludoviko'Lazaro'Zamenhofo'", "O"));
            ConceptProperties conceptProperties = conceptBuilder.buildProperties();
            Assert.assertEquals(ConceptTermination.O, conceptProperties.getTermination());
            Assert.assertEquals(false, conceptProperties.isPlural());
            Assert.assertEquals(true, conceptProperties.hasParameter());
            Assert.assertEquals(Language.EO, conceptProperties.getParameterLanguage());
            Assert.assertEquals(ConceptParameterType.PROPERNAME, conceptProperties.getParameterType());
            Assert.assertArrayEquals(new String[] { "Ludoviko Lazaro Zamenhofo" }, conceptProperties.getParameterPlainList().toArray());
            Concept referenceConcept = conceptBuilder.buildReferenceConcept();
            ConceptProperties referenceConceptProperties = referenceConcept.getProperties();
            Assert.assertEquals(ConceptTermination.O, referenceConceptProperties.getTermination());
            Assert.assertEquals(false, referenceConceptProperties.isPlural());
            Assert.assertEquals(true, referenceConceptProperties.hasParameter());
            Assert.assertEquals(Language.DE, referenceConceptProperties.getParameterLanguage());
            Assert.assertEquals(ConceptParameterType.PROPERNAME_MASCULINE, referenceConceptProperties.getParameterType());
            Assert.assertArrayEquals(new String[] { "Zamenhof" }, referenceConceptProperties.getParameterPlainList().toArray());
        }
    }
}

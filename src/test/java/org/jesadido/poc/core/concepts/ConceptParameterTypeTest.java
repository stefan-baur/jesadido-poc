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

public class ConceptParameterTypeTest {
    
    @Test
    public void testGetConceptEndings() {
        Assert.assertTrue(ConceptParameterType.NONE.getConceptEndings().isEmpty());
        Assert.assertArrayEquals(new String[] { "'O", "'OJ" }, ConceptParameterType.PROPERNAME.getConceptEndings().toArray());
        Assert.assertArrayEquals(new String[] { "'IcxO", "'IcxOJ" }, ConceptParameterType.PROPERNAME_MASCULINE.getConceptEndings().toArray());
        Assert.assertArrayEquals(new String[] { "'InO", "'InOJ" }, ConceptParameterType.PROPERNAME_FEMININE.getConceptEndings().toArray());
        Assert.assertArrayEquals(new String[] { "'LigO" }, ConceptParameterType.URL.getConceptEndings().toArray());
        Assert.assertArrayEquals(new String[] { "'DatO" }, ConceptParameterType.DATE.getConceptEndings().toArray());
        Assert.assertArrayEquals(new String[] { "'CitO" }, ConceptParameterType.CITATION.getConceptEndings().toArray());
        Assert.assertArrayEquals(new String[] { "'AdresO" }, ConceptParameterType.ADDRESS.getConceptEndings().toArray());
    }
    
    @Test
    public void testGet() {
        Assert.assertEquals(ConceptParameterType.NONE, ConceptParameterType.get("FacilA"));
        Assert.assertEquals(ConceptParameterType.PROPERNAME, ConceptParameterType.get("/de/'Eiffelturm'O"));
        Assert.assertEquals(ConceptParameterType.PROPERNAME, ConceptParameterType.get("/de/'Müllers'|'Müller'OJ"));
        Assert.assertEquals(ConceptParameterType.PROPERNAME_MASCULINE, ConceptParameterType.get("/de/'Maren'IcxO"));
        Assert.assertEquals(ConceptParameterType.PROPERNAME_MASCULINE, ConceptParameterType.get("/de/'Marens'|'Maren'IcxOJ"));
        Assert.assertEquals(ConceptParameterType.PROPERNAME_FEMININE, ConceptParameterType.get("/de/'Sophia'InO"));
        Assert.assertEquals(ConceptParameterType.PROPERNAME_FEMININE, ConceptParameterType.get("/de/'Sophien'|'Sophia'InOJ"));
        Assert.assertEquals(ConceptParameterType.URL, ConceptParameterType.get("'mailto:info@stefan-baur.org'LigO"));
        Assert.assertEquals(ConceptParameterType.DATE, ConceptParameterType.get("'1974-01-28'DatO"));
        Assert.assertEquals(ConceptParameterType.CITATION, ConceptParameterType.get("/de/'Paradox'ist,'wenn'einer'sich'im'Handumdrehen'den'Fuß'bricht.'|'Heinz'Erhardt'CitO"));
        Assert.assertEquals(ConceptParameterType.ADDRESS, ConceptParameterType.get("/de/'Stefan'Baur'|'Sperling'6'|'D-90459'Nürnberg'AdresO"));
    }
}

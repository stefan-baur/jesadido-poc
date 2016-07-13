/*
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core;

import org.junit.Assert;
import org.junit.Test;

/**
 * This <code>LanguageText</code> class tests the methods of the
 * <code>Language</code> class.
 */
public class LanguageTest {
    
    /**
     * Tests the <code>values</code> method of the <code>Language</code> class.
     */
    @Test
    public void testValues() {
        Language[] allSupportedLanguages = Language.values();
        Assert.assertEquals(6, allSupportedLanguages.length);
        Assert.assertArrayEquals(new Language[] { Language.JI, Language.DE, Language.EN, Language.EO, Language.ES, Language.FR }, allSupportedLanguages);
    }

    /**
     * Tests the <code>valueOf</code> method of the <code>Language</code> class.
     */
    @Test
    public void testValueOf() {
        Assert.assertEquals(Language.JI, Language.valueOf("JI"));
        Assert.assertEquals(Language.DE, Language.valueOf("DE"));
        Assert.assertEquals(Language.EN, Language.valueOf("EN"));
        Assert.assertEquals(Language.EO, Language.valueOf("EO"));
        Assert.assertEquals(Language.ES, Language.valueOf("ES"));
        Assert.assertEquals(Language.FR, Language.valueOf("FR"));
    }

    /**
     * Tests the <code>getCode</code> method of the <code>Language</code> class.
     */
    @Test
    public void testGetCode() {
        Assert.assertEquals("ji", Language.JI.getCode());
        Assert.assertEquals("de", Language.DE.getCode());
        Assert.assertEquals("en", Language.EN.getCode());
        Assert.assertEquals("eo", Language.EO.getCode());
        Assert.assertEquals("es", Language.ES.getCode());
        Assert.assertEquals("fr", Language.FR.getCode());
    }

    /**
     * Tests the <code>isIsoConform</code> method of the <code>Language</code>
     * class.
     */
    @Test
    public void testIsIsoConform() {
        Assert.assertEquals(false, Language.JI.isIsoConform());
        Assert.assertEquals(true, Language.DE.isIsoConform());
        Assert.assertEquals(true, Language.EN.isIsoConform());
        Assert.assertEquals(true, Language.EO.isIsoConform());
        Assert.assertEquals(true, Language.ES.isIsoConform());
        Assert.assertEquals(true, Language.FR.isIsoConform());
    }

    /**
     * Tests the <code>getDescription</code> method of the <code>Language</code>
     * class.
     */
    @Test
    public void testGetDescription() {
        Assert.assertEquals("Jesadido", Language.JI.getDescription());
        Assert.assertEquals("German", Language.DE.getDescription());
        Assert.assertEquals("English", Language.EN.getDescription());
        Assert.assertEquals("Esperanto", Language.EO.getDescription());
        Assert.assertEquals("Spanish", Language.ES.getDescription());
        Assert.assertEquals("French", Language.FR.getDescription());
    }

    /**
     * Tests the <code>toString</code> method of the <code>Language</code> class.
     */
    @Test
    public void testToString() {
        Assert.assertEquals("ji", Language.JI.toString());
        Assert.assertEquals("de", Language.DE.toString());
        Assert.assertEquals("en", Language.EN.toString());
        Assert.assertEquals("eo", Language.EO.toString());
        Assert.assertEquals("es", Language.ES.toString());
        Assert.assertEquals("fr", Language.FR.toString());
    }
}

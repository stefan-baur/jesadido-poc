/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class CoreUtilsTest {
    
    @Test
    public void testUp() {
        Assert.assertEquals("Icx", CoreUtils.up("icx"));
        Assert.assertEquals("Icx", CoreUtils.up("Icx"));
        Assert.assertEquals("O", CoreUtils.up("o"));
        Assert.assertEquals("O", CoreUtils.up("O"));
        Assert.assertArrayEquals(new String[] { "Icx", "O" }, CoreUtils.up(Arrays.asList("icx", "o")).toArray());
        Assert.assertArrayEquals(new String[] { "Icx", "O" }, CoreUtils.up(Arrays.asList("Icx", "O")).toArray());
        Assert.assertArrayEquals(new String[] { "'1974-01-28'", "Dat", "O" }, CoreUtils.up(Arrays.asList("'1974-01-28'", "dat", "o")).toArray());
        Assert.assertArrayEquals(new String[] { "/de/", "'von'Hefner'", "O" }, CoreUtils.up(Arrays.asList("/de/", "'von'Hefner'", "o")).toArray());
    }
    
    @Test
    public void testEscaper() {
        Assert.assertEquals("ASDF", CoreUtils.escaper("ASDF", "Ich liebe meine Muttersprache."));
        Assert.assertEquals("I_", CoreUtils.escaper("I", "Ich liebe meine Muttersprache."));
        Assert.assertEquals("Mutter_", CoreUtils.escaper("Mutter", "Ich liebe meine Muttersprache."));
        Assert.assertEquals("___", CoreUtils.escaper("", "two underscores: __"));
        Assert.assertEquals("___", CoreUtils.escaper(null, "two underscores: __"));
    }
    
    @Test
    public void testToConceptPhrase() {
        Assert.assertEquals("IcxO", CoreUtils.toConceptPhrase(Arrays.asList("icx", "o")));
        Assert.assertEquals("/de/'von'Hefner'O", CoreUtils.toConceptPhrase(Arrays.asList("/de/", "'von'Hefner'", "o")));
    }
}

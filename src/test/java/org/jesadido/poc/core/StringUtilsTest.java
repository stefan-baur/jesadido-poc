/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core;

import java.util.Arrays;
import java.util.LinkedList;
import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {
    
    @Test
    public void testUp() {
        Assert.assertEquals("", StringUtils.up((String) null));
        Assert.assertEquals("", StringUtils.up(""));
        Assert.assertEquals("Icx", StringUtils.up("icx"));
        Assert.assertEquals("Icx", StringUtils.up("Icx"));
        Assert.assertEquals("O", StringUtils.up("o"));
        Assert.assertEquals("O", StringUtils.up("O"));
        Assert.assertArrayEquals(new String[] {}, StringUtils.up(new LinkedList<>()).toArray());
        Assert.assertArrayEquals(new String[] { "Icx", "O" }, StringUtils.up(Arrays.asList("icx", "o")).toArray());
        Assert.assertArrayEquals(new String[] { "Icx", "O" }, StringUtils.up(Arrays.asList("Icx", "O")).toArray());
        Assert.assertArrayEquals(new String[] { "'1974-01-28'", "Dat", "O" }, StringUtils.up(Arrays.asList("'1974-01-28'", "dat", "o")).toArray());
        Assert.assertArrayEquals(new String[] { "/de/", "'von'Hefner'", "O" }, StringUtils.up(Arrays.asList("/de/", "'von'Hefner'", "o")).toArray());
    }
    
    @Test
    public void testEscaper() {
        Assert.assertEquals("ASDF", StringUtils.escaper("ASDF", "Ich liebe meine Muttersprache."));
        Assert.assertEquals("I_", StringUtils.escaper("I", "Ich liebe meine Muttersprache."));
        Assert.assertEquals("Mutter_", StringUtils.escaper("Mutter", "Ich liebe meine Muttersprache."));
        Assert.assertEquals("___", StringUtils.escaper("", "two underscores: __"));
        Assert.assertEquals("___", StringUtils.escaper(null, "two underscores: __"));
    }
}

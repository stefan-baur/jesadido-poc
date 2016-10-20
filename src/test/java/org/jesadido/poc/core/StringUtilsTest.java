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
import org.jesadido.poc.core.syntax.tokens.TokenType;
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
    public void testDown() {
        Assert.assertEquals("", StringUtils.down((String) null));
        Assert.assertEquals("", StringUtils.down(""));
        Assert.assertEquals("icx", StringUtils.down("icx"));
        Assert.assertEquals("icx", StringUtils.down("Icx"));
        Assert.assertEquals("o", StringUtils.down("o"));
        Assert.assertEquals("o", StringUtils.down("O"));
    }
    
    @Test
    public void testEscaper() {
        Assert.assertEquals("ASDF", StringUtils.escaper("ASDF", "Ich liebe meine Muttersprache."));
        Assert.assertEquals("I_", StringUtils.escaper("I", "Ich liebe meine Muttersprache."));
        Assert.assertEquals("Mutter_", StringUtils.escaper("Mutter", "Ich liebe meine Muttersprache."));
        Assert.assertEquals("___", StringUtils.escaper("", "two underscores: __"));
        Assert.assertEquals("___", StringUtils.escaper(null, "two underscores: __"));
    }
    
    @Test
    public void testRepeat() {
        Assert.assertEquals("", StringUtils.repeat(0, null));
        Assert.assertEquals("", StringUtils.repeat(1, null));
        Assert.assertEquals("", StringUtils.repeat(2, null));
        Assert.assertEquals("", StringUtils.repeat(3, null));
        Assert.assertEquals("", StringUtils.repeat(0, ""));
        Assert.assertEquals("", StringUtils.repeat(1, ""));
        Assert.assertEquals("", StringUtils.repeat(2, ""));
        Assert.assertEquals("", StringUtils.repeat(3, ""));
        Assert.assertEquals("", StringUtils.repeat(0, "a"));
        Assert.assertEquals("a", StringUtils.repeat(1, "a"));
        Assert.assertEquals("aa", StringUtils.repeat(2, "a"));
        Assert.assertEquals("aaa", StringUtils.repeat(3, "a"));
        Assert.assertEquals("", StringUtils.repeat(0, "abc."));
        Assert.assertEquals("abc.", StringUtils.repeat(1, "abc."));
        Assert.assertEquals("abc.abc.", StringUtils.repeat(2, "abc."));
        Assert.assertEquals("abc.abc.abc.", StringUtils.repeat(3, "abc."));
    }
    
    @Test
    public void testJoin() {
        Assert.assertEquals("", StringUtils.join("", null));
        Assert.assertEquals("", StringUtils.join("", new LinkedList<>()));
        Assert.assertEquals("O", StringUtils.join("", Arrays.asList("O")));
        Assert.assertEquals("O", StringUtils.join("-", Arrays.asList("O")));
        Assert.assertEquals("ON", StringUtils.join("", Arrays.asList("O", "N")));
        Assert.assertEquals("O-N", StringUtils.join("-", Arrays.asList("O", "N")));
        Assert.assertEquals("ONE", StringUtils.join("", Arrays.asList("O", "N", "E")));
        Assert.assertEquals("O-N-E", StringUtils.join("-", Arrays.asList("O", "N", "E")));
        Assert.assertEquals("ONE", StringUtils.join("", Arrays.asList("O", null, "N", "E")));
        Assert.assertEquals("O-N-E", StringUtils.join("-", Arrays.asList("O", "N", null, "E")));
        Assert.assertEquals("TERMINATOR", StringUtils.join(", ", Arrays.asList(TokenType.TERMINATOR)));
        Assert.assertEquals("ARTICLE, TERMINATOR", StringUtils.join(", ", Arrays.asList(TokenType.ARTICLE, null, TokenType.TERMINATOR)));
        Assert.assertEquals("ARTICLE, TERMINATOR, user-defined", StringUtils.join(", ", Arrays.asList(TokenType.ARTICLE, null, TokenType.TERMINATOR, "user-defined")));
        Assert.assertEquals("", StringUtils.join(", ", " and ", null));
        Assert.assertEquals("", StringUtils.join(", ", " and ", new LinkedList<>()));
        Assert.assertEquals("Sun", StringUtils.join(", ", " and ", Arrays.asList("Sun", null)));
        Assert.assertEquals("Sun and Moon", StringUtils.join(", ", " and ", Arrays.asList("Sun", "Moon")));
        Assert.assertEquals("Sun, Moon and Stars", StringUtils.join(", ", " and ", Arrays.asList("Sun", "Moon", "Stars")));
        Assert.assertEquals("Sun, Moon, Stars and Earth", StringUtils.join(", ", " and ", Arrays.asList("Sun", "Moon", "Stars", null, "Earth")));
        Assert.assertEquals("ARTICLE, TERMINATOR or user-defined", StringUtils.join(", ", " or ", Arrays.asList(null, TokenType.ARTICLE, TokenType.TERMINATOR, "user-defined")));
    }
}

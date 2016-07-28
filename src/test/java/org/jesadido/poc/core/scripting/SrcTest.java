/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.scripting;

import org.junit.Assert;
import org.junit.Test;

public class SrcTest {
    
    @Test
    public void testGetIndent() {
        Assert.assertEquals(Src.DEFAULT_INDENT, new Src().getIndent());
    }
    
    @Test
    public void testToString() {
        Assert.assertEquals("if (blah) {\r\n\tdo();\r\n}\r\n", new Src().begin("if (blah) {").line("do();").end("}").toString());
    }
}

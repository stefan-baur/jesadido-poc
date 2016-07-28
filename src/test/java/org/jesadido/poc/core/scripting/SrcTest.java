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
    public void testGetCompressionLevel() {
        Assert.assertEquals(Integer.MAX_VALUE, new Src().getCompressionLevel());
        Assert.assertEquals(0, new Src(0).getCompressionLevel());
        Assert.assertEquals(5, new Src(5, "// ", "\r").getCompressionLevel());
        Assert.assertEquals(Integer.MAX_VALUE, new Src(Integer.MAX_VALUE).getCompressionLevel());
    }
    
    @Test
    public void testGetIndent() {
        Assert.assertEquals("\t", Src.DEFAULT_INDENT);
        Assert.assertEquals(Src.DEFAULT_INDENT, new Src().getIndent());
        Assert.assertEquals("    ", new Src(0, "    ", "\n").getIndent());
        Assert.assertEquals("// ", new Src(5, "// ", "\r").getIndent());
    }
    
    @Test
    public void testGetNewline() {
        Assert.assertEquals("\r\n", Src.DEFAULT_NEWLINE);
        Assert.assertEquals(Src.DEFAULT_NEWLINE, new Src().getNewline());
        Assert.assertEquals("\n", new Src(0, "\t", "\n").getNewline());
        Assert.assertEquals("\r", new Src(5, " ", "\r").getNewline());
    }
    
    @Test
    public void testBegin() {
        Assert.assertEquals("if (blah) {\r\n", new Src().begin("if (%s) {", "blah").toString());
        Assert.assertEquals("if (blah) {", new Src(0).begin("if (blah) {").toString());
        Assert.assertEquals("if (blah) {\n", new Src(1, " ", "\n").begin("if (blah) {").toString());
        Assert.assertEquals("if (blah1) {\r\n\tif (blah2) {\r\n", new Src().begin("if (blah1) {").begin("if (%s) {", "blah2").toString());
        Assert.assertEquals("if (blah1) {if (blah2) {", new Src(0).begin("if (blah1) {").begin("if (blah2) {").toString());
        Assert.assertEquals("if (blah1) {\n if (blah2) {", new Src(1, " ", "\n").begin("if (blah1) {").begin("if (blah2) {").toString());
    }
    
    @Test
    public void testEnd() {
        Assert.assertEquals("}\r\n", new Src().end("}").toString());
        Assert.assertEquals("}\r\n", new Src(0).end("}").toString());
        Assert.assertEquals("} /* It terminates a typical C-family code-block! */\r\n", new Src().end("} /* %s */", "It terminates a typical C-family code-block!").toString());
        Assert.assertEquals("/* It terminates for example a PHP-block! */ ?>\r\n", new Src().end("/* %s */ ?>", "It terminates for example a PHP-block!").toString());
        Assert.assertEquals("{\r\n\t{\r\n\t}\r\n}\r\n", new Src().begin("{").begin("{").end("}").end("}").toString());
        Assert.assertEquals("{{}}\r\n", new Src(0).begin("{").begin("{").end("}").end("}").toString());
    }
    
    @Test
    public void testEndBegin() {
        Assert.assertEquals("if (x % 2 == 0) {\r\n\tcout << \"even\";\r\n} else {\r\n\tcout << \"odd\";\r\n}\r\n", new Src().begin("if (x %% 2 == 0) {").line("cout << \"even\";").endBegin("} else {").line("cout << \"odd\";").end("}").toString());
        Assert.assertEquals("if (x % 2 == 0) {cout << \"even\";} else {cout << \"odd\";}\r\n", new Src(0).begin("if (x %% 2 == 0) {").line("cout << \"even\";").endBegin("} else {").line("cout << \"odd\";").end("}").toString());
    }
    
    @Test
    public void testLine() {
        Assert.assertEquals("AddDefaultCharset utf-8\r\nDirectoryIndex index.html\r\n", new Src().line("AddDefaultCharset utf-8").line("DirectoryIndex index.html").toString());
        Assert.assertEquals("<!DOCTYPE html>\r\n<html lang=\"en\" dir=\"ltr\">\r\n", new Src().line("<!DOCTYPE html>").begin("<html lang=\"%s\" dir=\"%s\">", "en", "ltr").toString());
        Assert.assertEquals("/*\r\n"
                + " * jesadido-poc\r\n"
                + " * Copyright (C) 2016 Stefan K. Baur\r\n"
                + " *\r\n"
                + " * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)\r\n"
                + " * https://www.gnu.org/licenses/lgpl-3.0.txt\r\n"
                + " */\r\n", new Src()
                        .line("/*")
                        .line(" * jesadido-poc")
                        .line(" * Copyright (C) 2016 Stefan K. Baur")
                        .line(" *")
                        .line(" * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)")
                        .line(" * https://www.gnu.org/licenses/lgpl-3.0.txt")
                        .line(" */")
                        .toString());
    }
    
    @Test
    public void testBeginLine() {
        Assert.assertEquals("<div>\r\n\t<pre>", new Src().begin("<div>").beginLine("<pre>").toString());
        Assert.assertEquals("<div>\r\n\t<pre>ANY\tOTHER\nCODE</pre>\r\n</div>\r\n", new Src().begin("<div>").beginLine("<pre>").snippet("ANY\tOTHER\nCODE").endLine("</pre>").end("</div>").toString());
    }
    
    @Test
    public void testEndLine() {
        Assert.assertEquals("<div>\r\n\t<pre>\nANY\tOTHER\nCODE\n</pre>\r\n</div>\r\n", new Src().begin("<div>").beginLine("<pre>\nANY").snippet("\tOTHER\n").endLine("CODE\n</pre>").end("</div>").toString());
    }
    
    @Test
    public void testSnippet() {
        Assert.assertEquals("<div>\r\n\t<pre>ANY-OTHER-CODE</pre>\r\n</div>\r\n", new Src().begin("<div>").beginLine("<pre>").snippet("ANY").snippet("-%s-%s", "OTHER", "CODE").endLine("</pre>").end("</div>").toString());
    }
    
    @Test
    public void testInc() {
        Assert.assertEquals("\t\tTWO\r\n\t\t\tTHREE\r\n\t\t\t\tFOUR\r\n", new Src().inc().inc().line("TWO").inc().line("THREE").inc().line("FOUR").toString());
    }
    
    @Test
    public void testDec() {
        Assert.assertEquals("\t\t\tTHREE\r\n\t\t\t\tFOUR\r\n\tONE\r\n", new Src().inc().inc().inc().line("THREE").inc().line("FOUR").dec().dec().dec().line("ONE").toString());
    }
    
    @Test
    public void testAdd() {
        {
            Src action = new Src().line("do();");
            Assert.assertEquals("if (blah) {\r\n\tdo();\r\n}\r\n", new Src()
                    .begin("if (blah) {")
                    .add(action).end("}")
                    .toString());
        }
        {
            Src evenCase = new Src().line("cout << \"even\";");
            Src oddCase = new Src().line("cout << \"odd\";");
            Assert.assertEquals("if (x % 2 == 0) {\r\n\tcout << \"even\";\r\n} else {\r\n\tcout << \"odd\";\r\n}\r\n", new Src()
                    .begin("if (x %% 2 == 0) {")
                    .add(evenCase)
                    .endBegin("} else {")
                    .add(oddCase)
                    .end("}")
                    .toString());
        }
    }
    
    @Test
    public void testSave() {
        // Skipped for now.
    }
    
    @Test
    public void testToString() {
        Assert.assertEquals("if (blah) {\r\n\tdo();\r\n}\r\n", new Src().begin("if (blah) {").line("do();").end("}").toString());
    }
}

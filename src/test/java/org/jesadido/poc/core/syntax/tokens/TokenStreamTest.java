/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tokens;

import java.io.IOException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class TokenStreamTest {
    
    @Test
    public void testHas() {
        Assert.assertFalse(new TokenStream("").has());
        Assert.assertFalse(new TokenStream(" \t \r \n ").has());
        Assert.assertTrue(new TokenStream(".").has());
        Assert.assertTrue(new TokenStream(" Titl. ").has());
        Assert.assertFalse(new TokenStream(" . ").has(2));
        Assert.assertTrue(new TokenStream("\r\n \nSunO \t .  ").has(2));
        Assert.assertFalse(new TokenStream("\r\n \tSunO \t .  ").has(3));
    }
    
    @Test
    public void testHasSequence() {
        Assert.assertTrue(new TokenStream("").hasSequence());
        Assert.assertFalse(new TokenStream("").hasSequence(TokenType.PERSONAL_PRONOUN_PLURAL));
        Assert.assertTrue(new TokenStream(" \t \r \n ").hasSequence());
        Assert.assertFalse(new TokenStream(" \t \r \n ").hasSequence(TokenType.TERMINATOR));
        Assert.assertTrue(new TokenStream(".").hasSequence(TokenType.TERMINATOR));
        Assert.assertTrue(new TokenStream(" Titl. ").hasSequence(TokenType.TERMINATOR));
        Assert.assertFalse(new TokenStream(" . ").hasSequence(TokenType.ARTICLE));
        Assert.assertTrue(new TokenStream(" . ").hasSequence(TokenType.TERMINATOR));
        Assert.assertFalse(new TokenStream(" . ").hasSequence(TokenType.TERMINATOR, TokenType.ARTICLE));
        Assert.assertFalse(new TokenStream(" . ").hasSequence(TokenType.ARTICLE, TokenType.TERMINATOR));
        Assert.assertTrue(new TokenStream("\r\n \nSunO \t .  ").hasSequence(TokenType.SUBSTANTIVE_SINGULAR, TokenType.TERMINATOR));
        Assert.assertFalse(new TokenStream("\r\n \tSunO \t .  ").hasSequence(TokenType.SUBSTANTIVE_SINGULAR, TokenType.TERMINATOR, TokenType.UNKNOWN));
    }
    
    @Test
    public void testHasOneOf() {
        Assert.assertFalse(new TokenStream("").hasOneOf());
        Assert.assertFalse(new TokenStream(" \t \r \n ").hasOneOf());
        Assert.assertFalse(new TokenStream(" \t \r /de/'Stefan'IcxO \n . ").hasOneOf(TokenType.TERMINATOR));
        Assert.assertTrue(new TokenStream("/de/'Stefan'IcxO .").hasOneOf(TokenType.PARAMETERED_SUBSTANTIVE_SINGULAR));
        Assert.assertTrue(new TokenStream("/de/'Alex'IcxO .").hasOneOf(TokenType.PARAMETERED_SUBSTANTIVE_SINGULAR, TokenType.UNKNOWN));
        Assert.assertTrue(new TokenStream("/es/'Maria'IcxO .").hasOneOf(TokenType.UNKNOWN, TokenType.PARAMETERED_SUBSTANTIVE_SINGULAR));
    }
    
    @Test
    public void testNext() {
        {
            TokenStream tokenStream = new TokenStream("\tSunO .\r\n\tLunO .\r\n");
            if (tokenStream.has()) {
                Assert.assertEquals("SunO", tokenStream.next().getValue());
            }
            if (tokenStream.has()) {
                Assert.assertEquals(".", tokenStream.next().getValue());
            }
            if (tokenStream.has(2)) {
                Assert.assertEquals("LunO", tokenStream.next().getValue());
                Assert.assertEquals(".", tokenStream.next().getValue());
            }
            Assert.assertNull(tokenStream.next());
            Assert.assertFalse(tokenStream.has());
        }
        {
            TokenStream tokenStream = new TokenStream("SunO . LunO SunA .");
            if (tokenStream.hasOneOf(TokenType.SUBSTANTIVE_SINGULAR)) {
                List<Token> nextTokens = tokenStream.next(1);
                Assert.assertEquals(1, nextTokens.size());
                Assert.assertEquals("SunO", nextTokens.get(0).getValue());
            }
            if (tokenStream.hasSequence(TokenType.TERMINATOR, TokenType.SUBSTANTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR, TokenType.TERMINATOR)) {
                List<Token> nextTokens = tokenStream.next(4);
                Assert.assertEquals(4, nextTokens.size());
                Assert.assertEquals(".", nextTokens.get(0).getValue());
                Assert.assertEquals("LunO", nextTokens.get(1).getValue());
                Assert.assertEquals("SunA", nextTokens.get(2).getValue());
                Assert.assertEquals(".", nextTokens.get(3).getValue());
            }
            Assert.assertTrue(tokenStream.next(5).isEmpty());
        }
    }
    
    @Test
    public void testClose() throws IOException {
        TokenStream tokenStream = new TokenStream("'OPENED'O 'UNREACHABLE-CLOSED'O");
        Assert.assertTrue(tokenStream.has(1));
        tokenStream.close();
        Assert.assertFalse(tokenStream.has(2));
    }
}

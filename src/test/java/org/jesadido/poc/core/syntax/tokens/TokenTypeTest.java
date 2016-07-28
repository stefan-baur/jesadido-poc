/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tokens;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class TokenTypeTest {
    
    @Test
    public void testIsOneOf() {
        {
            Assert.assertFalse(TokenType.TERMINATOR.isOneOf());
            Assert.assertFalse(TokenType.UNKNOWN.isOneOf(TokenType.ADVERB_SINGULAR));
            Assert.assertFalse(TokenType.UNKNOWN.isOneOf(TokenType.INVALID_CONCEPT, TokenType.ARTICLE));
            Assert.assertTrue(TokenType.INVALID_CONCEPT.isOneOf(TokenType.INVALID_CONCEPT));
            Assert.assertTrue(TokenType.INVALID_CONCEPT.isOneOf(TokenType.INVALID_CONCEPT, TokenType.UNKNOWN));
            Assert.assertTrue(TokenType.INVALID_CONCEPT.isOneOf(TokenType.UNKNOWN, TokenType.INVALID_CONCEPT));
            Assert.assertTrue(TokenType.INVALID_CONCEPT.isOneOf(TokenType.UNKNOWN, TokenType.INVALID_CONCEPT, TokenType.TERMINATOR));
            Assert.assertTrue(TokenType.PARAMETERED_SUBSTANTIVE_PLURAL.isOneOf(TokenType.PARAMETERED_SUBSTANTIVE_SINGULAR, TokenType.PARAMETERED_SUBSTANTIVE_PLURAL));
            Assert.assertTrue(TokenType.ARTICLE.isOneOf(TokenType.values()));
        }
        {
            Assert.assertFalse(TokenType.UNKNOWN.isOneOf(Arrays.asList(TokenType.ADVERB_SINGULAR)));
            Assert.assertFalse(TokenType.UNKNOWN.isOneOf(Arrays.asList(TokenType.INVALID_CONCEPT, TokenType.ARTICLE)));
            Assert.assertTrue(TokenType.INVALID_CONCEPT.isOneOf(Arrays.asList(TokenType.INVALID_CONCEPT)));
            Assert.assertTrue(TokenType.INVALID_CONCEPT.isOneOf(Arrays.asList(TokenType.INVALID_CONCEPT, TokenType.UNKNOWN)));
            Assert.assertTrue(TokenType.INVALID_CONCEPT.isOneOf(Arrays.asList(TokenType.UNKNOWN, TokenType.INVALID_CONCEPT)));
            Assert.assertTrue(TokenType.INVALID_CONCEPT.isOneOf(Arrays.asList(TokenType.UNKNOWN, TokenType.INVALID_CONCEPT, TokenType.TERMINATOR)));
            Assert.assertTrue(TokenType.PARAMETERED_SUBSTANTIVE_PLURAL.isOneOf(Arrays.asList(TokenType.PARAMETERED_SUBSTANTIVE_SINGULAR, TokenType.PARAMETERED_SUBSTANTIVE_PLURAL)));
            Assert.assertTrue(TokenType.ARTICLE.isOneOf(Arrays.asList(TokenType.values())));
        }
    }
    
    @Test
    public void testToString() {
        Assert.assertEquals("TERMINATOR", TokenType.TERMINATOR.toString());
        Assert.assertEquals("UNKNOWN", TokenType.UNKNOWN.toString());
    }
}

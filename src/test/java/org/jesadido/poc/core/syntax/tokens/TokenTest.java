/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tokens;

import org.junit.Assert;
import org.junit.Test;

public class TokenTest {
    
    @Test
    public void testGetValue() {
        Assert.assertEquals(".", Token.create(".").getValue());
        Assert.assertEquals("LunO", Token.create("LunO").getValue());
        Assert.assertEquals("LunOJ", Token.create("LunOJ").getValue());
        Assert.assertEquals("LunA", Token.create("LunA").getValue());
        Assert.assertEquals("LunAJ", Token.create("LunAJ").getValue());
        Assert.assertEquals("LunE", Token.create("LunE").getValue());
        Assert.assertEquals("LunEJ", Token.create("LunEJ").getValue());
        Assert.assertEquals("/de/'Stefan'IcxO$Mi", Token.create("/de/'Stefan'IcxO$Mi").getValue());
        Assert.assertEquals("/de/'Baurs'|'Baur'OJ$Ni", Token.create("/de/'Baurs'|'Baur'OJ$Ni").getValue());
        Assert.assertEquals("/de/'Müllers'|'Müller'OJ$Vi", Token.create("/de/'Müllers'|'Müller'OJ$Vi").getValue());
    }
    
    @Test
    public void testGetType() {
        Assert.assertEquals(TokenType.TERMINATOR, Token.create(".").getType());
        Assert.assertEquals(TokenType.SUBSTANTIVE_SINGULAR, Token.create("LunO").getType());
        Assert.assertEquals(TokenType.SUBSTANTIVE_PLURAL, Token.create("LunOJ").getType());
        Assert.assertEquals(TokenType.ADJECTIVE_SINGULAR, Token.create("LunA").getType());
        Assert.assertEquals(TokenType.ADJECTIVE_PLURAL, Token.create("LunAJ").getType());
        Assert.assertEquals(TokenType.ADVERB_SINGULAR, Token.create("LunE").getType());
        Assert.assertEquals(TokenType.ADVERB_PLURAL, Token.create("LunEJ").getType());
        Assert.assertEquals(TokenType.PERSONAL_PRONOUN_SINGULAR, Token.create("/de/'Stefan'IcxO$Mi").getType());
        Assert.assertEquals(TokenType.PERSONAL_PRONOUN_PLURAL, Token.create("/de/'Baurs'|'Baur'OJ$Ni").getType());
        Assert.assertEquals(TokenType.PERSONAL_PRONOUN_PLURAL, Token.create("/de/'Müllers'|'Müller'OJ$Vi").getType());
    }
    
    @Test
    public void testGetConcept() {
        Assert.assertEquals(".", Token.create(".").getConcept().getFullPhrase());
        Assert.assertEquals("LunO", Token.create("LunO").getConcept().getFullPhrase());
        Assert.assertEquals("LunOJ", Token.create("LunOJ").getConcept().getFullPhrase());
        Assert.assertEquals("LunA", Token.create("LunA").getConcept().getFullPhrase());
        Assert.assertEquals("LunAJ", Token.create("LunAJ").getConcept().getFullPhrase());
        Assert.assertEquals("LunE", Token.create("LunE").getConcept().getFullPhrase());
        Assert.assertEquals("LunEJ", Token.create("LunEJ").getConcept().getFullPhrase());
        Assert.assertEquals("/de/'Stefan'IcxO$Mi", Token.create("/de/'Stefan'IcxO$Mi").getConcept().getFullPhrase());
        Assert.assertEquals("/de/'Baurs'|'Baur'OJ$Ni", Token.create("/de/'Baurs'|'Baur'OJ$Ni").getConcept().getFullPhrase());
        Assert.assertEquals("/de/'Müllers'|'Müller'OJ$Vi", Token.create("/de/'Müllers'|'Müller'OJ$Vi").getConcept().getFullPhrase());
    }
    
    @Test
    public void testCreate() {
        Assert.assertNotNull(Token.create("."));
        Assert.assertNotNull(Token.create("LunO"));
        Assert.assertNotNull(Token.create("LunOJ"));
        Assert.assertNotNull(Token.create("LunA"));
        Assert.assertNotNull(Token.create("LunAJ"));
        Assert.assertNotNull(Token.create("LunE"));
        Assert.assertNotNull(Token.create("LunEJ"));
        Assert.assertNotNull(Token.create("/de/'Stefan'IcxO$Mi"));
        Assert.assertNotNull(Token.create("/de/'Baurs'|'Baur'OJ$Ni"));
        Assert.assertNotNull(Token.create("/de/'Müllers'|'Müller'OJ$Vi"));
    }
}

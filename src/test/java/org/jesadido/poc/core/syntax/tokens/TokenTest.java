/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tokens;

import org.jesadido.poc.core.concepts.ConceptRegistry;
import org.junit.Assert;
import org.junit.Test;

public class TokenTest {
    
    @Test
    public void testGetValue() {
        Assert.assertEquals(".", new Token(".", TokenType.TERMINATOR, ConceptRegistry.getInstance().getConcept("."), 20, 5).getValue());
        Assert.assertEquals("LunO", new Token("LunO", TokenType.SUBSTANTIVE_SINGULAR, ConceptRegistry.getInstance().getConcept("LunO"), -1, 1).getValue());
        Assert.assertEquals("LunOJ", new Token("LunOJ", TokenType.SUBSTANTIVE_PLURAL, ConceptRegistry.getInstance().getConcept("LunOJ"), -1, 1).getValue());
        Assert.assertEquals("LunA", new Token("LunA", TokenType.ADJECTIVE_SINGULAR, ConceptRegistry.getInstance().getConcept("LunA"), -1, 1).getValue());
        Assert.assertEquals("LunAJ", new Token("LunAJ", TokenType.ADJECTIVE_PLURAL, ConceptRegistry.getInstance().getConcept("LunAJ"), -1, 1).getValue());
        Assert.assertEquals("LunE", new Token("LunE", TokenType.ADVERB_SINGULAR, ConceptRegistry.getInstance().getConcept("LunE")).getValue());
        Assert.assertEquals("LunEJ", new Token("LunEJ", TokenType.ADVERB_PLURAL, null).getValue());
        Assert.assertEquals("/de/'Stefan'IcxO$Mi", new Token("/de/'Stefan'IcxO$Mi", TokenType.PERSONAL_PRONOUN_SINGULAR, null).getValue());
        Assert.assertEquals("/de/'Baurs'|'Baur'OJ$Ni", new Token("/de/'Baurs'|'Baur'OJ$Ni", TokenType.PERSONAL_PRONOUN_PLURAL, null).getValue());
        Assert.assertEquals("/de/'Müllers'|'Müller'OJ$Vi", new Token("/de/'Müllers'|'Müller'OJ$Vi", TokenType.PERSONAL_PRONOUN_PLURAL, null).getValue());
    }
    
    @Test
    public void testGetType() {
        Assert.assertEquals(TokenType.TERMINATOR, new Token(".", TokenType.TERMINATOR, ConceptRegistry.getInstance().getConcept("."), 20, 5).getType());
        Assert.assertEquals(TokenType.SUBSTANTIVE_SINGULAR, new Token("LunO", TokenType.SUBSTANTIVE_SINGULAR, ConceptRegistry.getInstance().getConcept("LunO"), -1, 1).getType());
        Assert.assertEquals(TokenType.SUBSTANTIVE_PLURAL, new Token("LunOJ", TokenType.SUBSTANTIVE_PLURAL, ConceptRegistry.getInstance().getConcept("LunOJ"), -1, 1).getType());
        Assert.assertEquals(TokenType.ADJECTIVE_SINGULAR, new Token("LunA", TokenType.ADJECTIVE_SINGULAR, ConceptRegistry.getInstance().getConcept("LunA"), -1, 1).getType());
        Assert.assertEquals(TokenType.ADJECTIVE_PLURAL, new Token("LunAJ", TokenType.ADJECTIVE_PLURAL, ConceptRegistry.getInstance().getConcept("LunAJ"), -1, 1).getType());
        Assert.assertEquals(TokenType.ADVERB_SINGULAR, new Token("LunE", TokenType.ADVERB_SINGULAR, ConceptRegistry.getInstance().getConcept("LunE")).getType());
        Assert.assertEquals(TokenType.ADVERB_PLURAL, new Token("LunEJ", TokenType.ADVERB_PLURAL, null).getType());
        Assert.assertEquals(TokenType.PERSONAL_PRONOUN_SINGULAR, new Token("/de/'Stefan'IcxO$Mi", TokenType.PERSONAL_PRONOUN_SINGULAR, null).getType());
        Assert.assertEquals(TokenType.PERSONAL_PRONOUN_PLURAL, new Token("/de/'Baurs'|'Baur'OJ$Ni", TokenType.PERSONAL_PRONOUN_PLURAL, null).getType());
        Assert.assertEquals(TokenType.PERSONAL_PRONOUN_PLURAL, new Token("/de/'Müllers'|'Müller'OJ$Vi", TokenType.PERSONAL_PRONOUN_PLURAL, null).getType());
    }
    
    @Test
    public void testGetConcept() {
        Assert.assertEquals(".", new Token(".", TokenType.TERMINATOR, ConceptRegistry.getInstance().getConcept("."), 20, 5).getConcept().getFullPhrase());
        Assert.assertEquals("LunO", new Token("LunO", TokenType.SUBSTANTIVE_SINGULAR, ConceptRegistry.getInstance().getConcept("LunO"), -1, 1).getConcept().getFullPhrase());
        Assert.assertEquals("LunOJ", new Token("LunOJ", TokenType.SUBSTANTIVE_PLURAL, ConceptRegistry.getInstance().getConcept("LunOJ"), -1, 1).getConcept().getFullPhrase());
        Assert.assertEquals("LunA", new Token("LunA", TokenType.ADJECTIVE_SINGULAR, ConceptRegistry.getInstance().getConcept("LunA"), -1, 1).getConcept().getFullPhrase());
        Assert.assertEquals("LunAJ", new Token("LunAJ", TokenType.ADJECTIVE_PLURAL, ConceptRegistry.getInstance().getConcept("LunAJ"), -1, 1).getConcept().getFullPhrase());
        Assert.assertEquals("LunE", new Token("LunE", TokenType.ADVERB_SINGULAR, ConceptRegistry.getInstance().getConcept("LunE")).getConcept().getFullPhrase());
        Assert.assertNull(new Token("LunEJ", TokenType.ADVERB_PLURAL, null).getConcept());
        Assert.assertNull(new Token("/de/'Stefan'IcxO$Mi", TokenType.PERSONAL_PRONOUN_SINGULAR, null).getConcept());
        Assert.assertNull(new Token("/de/'Baurs'|'Baur'OJ$Ni", TokenType.PERSONAL_PRONOUN_PLURAL, null).getConcept());
        Assert.assertNull(new Token("/de/'Müllers'|'Müller'OJ$Vi", TokenType.PERSONAL_PRONOUN_PLURAL, null).getConcept());
    }
    
    @Test
    public void testHasPosition() {
        Assert.assertTrue(new Token(".", TokenType.TERMINATOR, ConceptRegistry.getInstance().getConcept("."), 20, 5).hasPosition());
        Assert.assertFalse(new Token("LunO", TokenType.SUBSTANTIVE_SINGULAR, ConceptRegistry.getInstance().getConcept("LunO"), -1, 1).hasPosition());
        Assert.assertFalse(new Token("LunOJ", TokenType.SUBSTANTIVE_PLURAL, ConceptRegistry.getInstance().getConcept("LunOJ"), -1, 1).hasPosition());
        Assert.assertFalse(new Token("LunA", TokenType.ADJECTIVE_SINGULAR, ConceptRegistry.getInstance().getConcept("LunA"), -1, 1).hasPosition());
        Assert.assertFalse(new Token("LunAJ", TokenType.ADJECTIVE_PLURAL, ConceptRegistry.getInstance().getConcept("LunAJ"), -1, 1).hasPosition());
        Assert.assertFalse(new Token("LunE", TokenType.ADVERB_SINGULAR, ConceptRegistry.getInstance().getConcept("LunE")).hasPosition());
        Assert.assertFalse(new Token("LunEJ", TokenType.ADVERB_PLURAL, null).hasPosition());
        Assert.assertFalse(new Token("/de/'Stefan'IcxO$Mi", TokenType.PERSONAL_PRONOUN_SINGULAR, null).hasPosition());
        Assert.assertFalse(new Token("/de/'Baurs'|'Baur'OJ$Ni", TokenType.PERSONAL_PRONOUN_PLURAL, null).hasPosition());
        Assert.assertFalse(new Token("/de/'Müllers'|'Müller'OJ$Vi", TokenType.PERSONAL_PRONOUN_PLURAL, null).hasPosition());
    }
    
    @Test
    public void testGetPositionX() {
        Assert.assertEquals(20, new Token(".", TokenType.TERMINATOR, ConceptRegistry.getInstance().getConcept("."), 20, 5).getPositionX());
        Assert.assertEquals(-1, new Token("LunO", TokenType.SUBSTANTIVE_SINGULAR, ConceptRegistry.getInstance().getConcept("LunO"), -1, 1).getPositionX());
        Assert.assertEquals(-1, new Token("LunOJ", TokenType.SUBSTANTIVE_PLURAL, ConceptRegistry.getInstance().getConcept("LunOJ"), -1, 1).getPositionX());
        Assert.assertEquals(-1, new Token("LunA", TokenType.ADJECTIVE_SINGULAR, ConceptRegistry.getInstance().getConcept("LunA"), -1, 1).getPositionX());
        Assert.assertEquals(-1, new Token("LunAJ", TokenType.ADJECTIVE_PLURAL, ConceptRegistry.getInstance().getConcept("LunAJ"), -1, 1).getPositionX());
        Assert.assertEquals(0, new Token("LunE", TokenType.ADVERB_SINGULAR, ConceptRegistry.getInstance().getConcept("LunE")).getPositionX());
        Assert.assertEquals(0, new Token("LunEJ", TokenType.ADVERB_PLURAL, null).getPositionX());
        Assert.assertEquals(0, new Token("/de/'Stefan'IcxO$Mi", TokenType.PERSONAL_PRONOUN_SINGULAR, null).getPositionX());
        Assert.assertEquals(0, new Token("/de/'Baurs'|'Baur'OJ$Ni", TokenType.PERSONAL_PRONOUN_PLURAL, null).getPositionX());
        Assert.assertEquals(0, new Token("/de/'Müllers'|'Müller'OJ$Vi", TokenType.PERSONAL_PRONOUN_PLURAL, null).getPositionX());
    }
    
    @Test
    public void testGetPositionY() {
        Assert.assertEquals(5, new Token(".", TokenType.TERMINATOR, ConceptRegistry.getInstance().getConcept("."), 20, 5).getPositionY());
        Assert.assertEquals(1, new Token("LunO", TokenType.SUBSTANTIVE_SINGULAR, ConceptRegistry.getInstance().getConcept("LunO"), -1, 1).getPositionY());
        Assert.assertEquals(1, new Token("LunOJ", TokenType.SUBSTANTIVE_PLURAL, ConceptRegistry.getInstance().getConcept("LunOJ"), -1, 1).getPositionY());
        Assert.assertEquals(1, new Token("LunA", TokenType.ADJECTIVE_SINGULAR, ConceptRegistry.getInstance().getConcept("LunA"), -1, 1).getPositionY());
        Assert.assertEquals(1, new Token("LunAJ", TokenType.ADJECTIVE_PLURAL, ConceptRegistry.getInstance().getConcept("LunAJ"), -1, 1).getPositionY());
        Assert.assertEquals(1, new Token("LunE", TokenType.ADVERB_SINGULAR, ConceptRegistry.getInstance().getConcept("LunE")).getPositionY());
        Assert.assertEquals(1, new Token("LunEJ", TokenType.ADVERB_PLURAL, null).getPositionY());
        Assert.assertEquals(1, new Token("/de/'Stefan'IcxO$Mi", TokenType.PERSONAL_PRONOUN_SINGULAR, null).getPositionY());
        Assert.assertEquals(1, new Token("/de/'Baurs'|'Baur'OJ$Ni", TokenType.PERSONAL_PRONOUN_PLURAL, null).getPositionY());
        Assert.assertEquals(1, new Token("/de/'Müllers'|'Müller'OJ$Vi", TokenType.PERSONAL_PRONOUN_PLURAL, null).getPositionY());
    }
}

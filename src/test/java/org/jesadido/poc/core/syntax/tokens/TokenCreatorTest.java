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

public class TokenCreatorTest {
    
    @Test
    public void testCreate() {
        final TokenCreator tokenCreator = new TokenCreator();
        Assert.assertNotNull(tokenCreator.create("."));
        Assert.assertEquals(TokenType.TERMINATOR, tokenCreator.create(".").getType());
        Assert.assertNotNull(tokenCreator.create("LunO"));
        Assert.assertEquals(TokenType.SUBSTANTIVE_SINGULAR, tokenCreator.create("LunO", 40, 30).getType());
        Assert.assertNotNull(tokenCreator.create(TokenType.TERMINATOR));
        Assert.assertEquals(TokenType.TERMINATOR, tokenCreator.create(TokenType.TERMINATOR).getType());
        Assert.assertEquals(".", tokenCreator.create(TokenType.TERMINATOR).getValue());
    }
    
    @Test
    public void testGetSupportedTokenTypes() {
        final TokenCreator tokenCreator = new TokenCreator();
        Assert.assertTrue(TokenType.UNKNOWN.isOneOf(tokenCreator.getSupportedTokenTypes()));
        Assert.assertTrue(TokenType.TERMINATOR.isOneOf(tokenCreator.getSupportedTokenTypes()));
        Assert.assertTrue(TokenType.SUBSTANTIVE_SINGULAR.isOneOf(tokenCreator.getSupportedTokenTypes()));
        Assert.assertTrue(TokenType.OPEN.isOneOf(tokenCreator.getSupportedTokenTypes()));
        Assert.assertTrue(TokenType.CLOSE.isOneOf(tokenCreator.getSupportedTokenTypes()));
        Assert.assertFalse(TokenType.SUBSTANTIVE.isOneOf(tokenCreator.getSupportedTokenTypes()));
        Assert.assertTrue(tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("X")).isOneOf(tokenCreator.getSupportedTokenTypes()));
        Assert.assertTrue(tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept(".")).isOneOf(tokenCreator.getSupportedTokenTypes()));
        Assert.assertTrue(tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("Titl.")).isOneOf(tokenCreator.getSupportedTokenTypes()));
        Assert.assertTrue(tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("SunO")).isOneOf(tokenCreator.getSupportedTokenTypes()));
        Assert.assertTrue(tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("SunOJ")).isOneOf(tokenCreator.getSupportedTokenTypes()));
        Assert.assertTrue(tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("SunA")).isOneOf(tokenCreator.getSupportedTokenTypes()));
        Assert.assertTrue(tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("SunAJ")).isOneOf(tokenCreator.getSupportedTokenTypes()));
        Assert.assertTrue(tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("SunE")).isOneOf(tokenCreator.getSupportedTokenTypes()));
        Assert.assertTrue(tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("SunEJ")).isOneOf(tokenCreator.getSupportedTokenTypes()));
        Assert.assertTrue(tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("/de/'Berta'InO")).isOneOf(tokenCreator.getSupportedTokenTypes()));
        Assert.assertTrue(tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("'1965-08-11'DatO")).isOneOf(tokenCreator.getSupportedTokenTypes()));
        Assert.assertTrue(tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("/de/'Baurs'|'Baur'OJ")).isOneOf(tokenCreator.getSupportedTokenTypes()));
        Assert.assertTrue(tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("/de/'Stefan'IcxO$Mi")).isOneOf(tokenCreator.getSupportedTokenTypes()));
        Assert.assertTrue(tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("/de/'Baurs'|'Baur'OJ$Ni")).isOneOf(tokenCreator.getSupportedTokenTypes()));
        Assert.assertTrue(tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("Kaj")).isOneOf(tokenCreator.getSupportedTokenTypes()));
        Assert.assertTrue(tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("Aux")).isOneOf(tokenCreator.getSupportedTokenTypes()));
        Assert.assertTrue(tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept(",")).isOneOf(tokenCreator.getSupportedTokenTypes()));
        Assert.assertTrue(tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("La")).isOneOf(tokenCreator.getSupportedTokenTypes()));
        Assert.assertTrue(tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("Da$La")).isOneOf(tokenCreator.getSupportedTokenTypes()));
        Assert.assertTrue(tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("Mi$La")).isOneOf(tokenCreator.getSupportedTokenTypes()));
        Assert.assertTrue(tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("HomArO$Ni$La")).isOneOf(tokenCreator.getSupportedTokenTypes()));
    }
    
    @Test
    public void testSelectTokenType() {
        final TokenCreator tokenCreator = new TokenCreator();
        Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("X")));
        Assert.assertEquals(TokenType.TERMINATOR, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept(".")));
        Assert.assertEquals(TokenType.TERMINATOR, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("Titl.")));
        Assert.assertEquals(TokenType.SUBSTANTIVE_SINGULAR, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("SunO")));
        Assert.assertEquals(TokenType.SEPARATOR_KAJ, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("Kaj")));
        Assert.assertEquals(TokenType.SEPARATOR_AUX, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("Aux")));
        Assert.assertEquals(TokenType.SEPARATOR, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept(",")));
    }
}

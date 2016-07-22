/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tokens;

import org.jesadido.poc.core.concepts.*;
import org.junit.Assert;
import org.junit.Test;

public class TokenTypeTest {
    
    @Test
    public void testGet() {
        Assert.assertEquals(TokenType.UNKNOWN, TokenType.get(ConceptRegistry.getInstance().getConcept("X")));
        Assert.assertEquals(TokenType.TERMINATOR, TokenType.get(ConceptRegistry.getInstance().getConcept(".")));
        Assert.assertEquals(TokenType.TERMINATOR, TokenType.get(ConceptRegistry.getInstance().getConcept("Titl.")));
        Assert.assertEquals(TokenType.SUBSTANTIVE_SINGULAR, TokenType.get(ConceptRegistry.getInstance().getConcept("SunO")));
        Assert.assertEquals(TokenType.SUBSTANTIVE_PLURAL, TokenType.get(ConceptRegistry.getInstance().getConcept("SunOJ")));
        Assert.assertEquals(TokenType.ADJECTIVE_SINGULAR, TokenType.get(ConceptRegistry.getInstance().getConcept("SunA")));
        Assert.assertEquals(TokenType.ADJECTIVE_PLURAL, TokenType.get(ConceptRegistry.getInstance().getConcept("SunAJ")));
        Assert.assertEquals(TokenType.ADVERB_SINGULAR, TokenType.get(ConceptRegistry.getInstance().getConcept("SunE")));
        Assert.assertEquals(TokenType.ADVERB_PLURAL, TokenType.get(ConceptRegistry.getInstance().getConcept("SunEJ")));
        Assert.assertEquals(TokenType.PARAMETERED_SUBSTANTIVE_SINGULAR, TokenType.get(ConceptRegistry.getInstance().getConcept("/de/'Berta'InO")));
        Assert.assertEquals(TokenType.PARAMETERED_SUBSTANTIVE_SINGULAR, TokenType.get(ConceptRegistry.getInstance().getConcept("'1965-08-11'DatO")));
        Assert.assertEquals(TokenType.PARAMETERED_SUBSTANTIVE_PLURAL, TokenType.get(ConceptRegistry.getInstance().getConcept("/de/'Baurs'|'Baur'OJ")));
        Assert.assertEquals(TokenType.PERSONAL_PRONOUN_SINGULAR, TokenType.get(ConceptRegistry.getInstance().getConcept("/de/'Stefan'IcxO$Mi")));
        Assert.assertEquals(TokenType.PERSONAL_PRONOUN_PLURAL, TokenType.get(ConceptRegistry.getInstance().getConcept("/de/'Baurs'|'Baur'OJ$Ni")));
        Assert.assertEquals(TokenType.SEPARATOR, TokenType.get(ConceptRegistry.getInstance().getConcept("Kaj")));
        Assert.assertEquals(TokenType.SEPARATOR, TokenType.get(ConceptRegistry.getInstance().getConcept("Aux")));
        Assert.assertEquals(TokenType.SEPARATOR, TokenType.get(ConceptRegistry.getInstance().getConcept(",")));
    }
    
    @Test
    public void testIsOneOf() {
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
}

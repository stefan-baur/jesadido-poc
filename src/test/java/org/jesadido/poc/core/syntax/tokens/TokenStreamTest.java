/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tokens;

import java.io.IOException;
import java.util.EnumMap;
import java.util.List;
import java.util.logging.Logger;
import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.concepts.ConceptRegistry;
import org.jesadido.poc.core.concepts.ConceptTermination;
import static org.jesadido.poc.core.syntax.tokens.TokenType.ADJECTIVE_SINGULAR;
import static org.jesadido.poc.core.syntax.tokens.TokenType.ARTICLE;
import static org.jesadido.poc.core.syntax.tokens.TokenType.PARAMETERED_SUBSTANTIVE_SINGULAR;
import static org.jesadido.poc.core.syntax.tokens.TokenType.SUBSTANTIVE_SINGULAR;
import static org.jesadido.poc.core.syntax.tokens.TokenType.TERMINATOR;
import org.junit.Assert;
import org.junit.Test;

public class TokenStreamTest {
    
    private static final Logger LOGGER = Logger.getLogger(TokenStreamTest.class.getName());
    
    private static final TokenCreator TC = new TokenCreatorForTokenStreamTest();
    
    @Test
    public void testHas() {
        Assert.assertFalse(new TokenStream("", TC).has());
        Assert.assertFalse(new TokenStream(" \t \r \n ", TC).has());
        Assert.assertTrue(new TokenStream(".", TC).has());
        Assert.assertTrue(new TokenStream(" Titl. ", TC).has());
        Assert.assertFalse(new TokenStream(" . ", TC).has(2));
        Assert.assertTrue(new TokenStream("\r\n \nSunO \t .  ", TC).has(2));
        Assert.assertFalse(new TokenStream("\r\n \tSunO \t .  ", TC).has(3));
    }
    
    @Test
    public void testHasSequence() {
        Assert.assertTrue(new TokenStream("", TC).hasSequence());
        Assert.assertFalse(new TokenStream("", TC).hasSequence(TokenType.PERSONAL_PRONOUN_PLURAL));
        Assert.assertTrue(new TokenStream(" \t \r \n ", TC).hasSequence());
        Assert.assertFalse(new TokenStream(" \t \r \n ", TC).hasSequence(TokenType.TERMINATOR));
        Assert.assertTrue(new TokenStream(".", TC).hasSequence(TokenType.TERMINATOR));
        Assert.assertTrue(new TokenStream(" Titl. ", TC).hasSequence(TokenType.TERMINATOR));
        Assert.assertFalse(new TokenStream(" . ", TC).hasSequence(TokenType.ARTICLE));
        Assert.assertTrue(new TokenStream(" . ", TC).hasSequence(TokenType.TERMINATOR));
        Assert.assertFalse(new TokenStream(" . ", TC).hasSequence(TokenType.TERMINATOR, TokenType.ARTICLE));
        Assert.assertFalse(new TokenStream(" . ", TC).hasSequence(TokenType.ARTICLE, TokenType.TERMINATOR));
        Assert.assertTrue(new TokenStream("\r\n \nSunO \t .  ", TC).hasSequence(TokenType.SUBSTANTIVE_SINGULAR, TokenType.TERMINATOR));
        Assert.assertFalse(new TokenStream("\r\n \tSunO \t .  ", TC).hasSequence(TokenType.SUBSTANTIVE_SINGULAR, TokenType.TERMINATOR, TokenType.UNKNOWN));
    }
    
    @Test
    public void testHasOneOf() {
        Assert.assertFalse(new TokenStream("", TC).hasOneOf());
        Assert.assertFalse(new TokenStream(" \t \r \n ", TC).hasOneOf());
        Assert.assertFalse(new TokenStream(" \t \r /de/'Stefan'IcxO \n . ", TC).hasOneOf(TokenType.TERMINATOR));
        Assert.assertTrue(new TokenStream("/de/'Stefan'IcxO .", TC).hasOneOf(TokenType.PARAMETERED_SUBSTANTIVE_SINGULAR));
        Assert.assertTrue(new TokenStream("/de/'Alex'IcxO .", TC).hasOneOf(TokenType.PARAMETERED_SUBSTANTIVE_SINGULAR, TokenType.UNKNOWN));
        Assert.assertTrue(new TokenStream("/es/'Maria'IcxO .", TC).hasOneOf(TokenType.UNKNOWN, TokenType.PARAMETERED_SUBSTANTIVE_SINGULAR));
    }
    
    @Test
    public void testPeek() {
        {
            TokenStream tokenStream = new TokenStream("", TC);
            Assert.assertNull(tokenStream.peek());
            Assert.assertTrue(tokenStream.peek(1).isEmpty());
            Assert.assertTrue(tokenStream.peek(2).isEmpty());
            Assert.assertFalse(tokenStream.has());
        }
        {
            TokenStream tokenStream = new TokenStream("StelOJ", TC);
            Assert.assertEquals("StelOJ", tokenStream.peek().getValue());
            Assert.assertEquals(1, tokenStream.peek(1).size());
            Assert.assertEquals("StelOJ", tokenStream.peek(1).get(0).getValue());
            Assert.assertEquals(1, tokenStream.peek(2).size());
            Assert.assertEquals("StelOJ", tokenStream.peek(2).get(0).getValue());
            Assert.assertTrue(tokenStream.has(1));
            Assert.assertFalse(tokenStream.has(2));
            Assert.assertEquals("StelOJ", tokenStream.next(1).get(0).getValue());
            Assert.assertTrue(tokenStream.peek(1).isEmpty());
            Assert.assertFalse(tokenStream.has(1));
        }
        {
            TokenStream tokenStream = new TokenStream("\tSunO .\r\n\tLunO .\r\n", TC);
            Assert.assertEquals("SunO", tokenStream.peek().getValue());
            Assert.assertEquals(1, tokenStream.peek(1).size());
            Assert.assertEquals("SunO", tokenStream.peek(1).get(0).getValue());
            Assert.assertEquals(2, tokenStream.peek(2).size());
            Assert.assertEquals("SunO", tokenStream.peek(2).get(0).getValue());
            Assert.assertEquals(".", tokenStream.peek(2).get(1).getValue());
            Assert.assertEquals(4, tokenStream.peek(4).size());
            Assert.assertEquals("SunO", tokenStream.peek(4).get(0).getValue());
            Assert.assertEquals(".", tokenStream.peek(4).get(1).getValue());
            Assert.assertEquals("LunO", tokenStream.peek(4).get(2).getValue());
            Assert.assertEquals(".", tokenStream.peek(4).get(3).getValue());
            Assert.assertEquals(4, tokenStream.peek(5).size());
            Assert.assertEquals("SunO", tokenStream.peek(5).get(0).getValue());
            Assert.assertEquals(".", tokenStream.peek(5).get(1).getValue());
            Assert.assertEquals("LunO", tokenStream.peek(5).get(2).getValue());
            Assert.assertEquals(".", tokenStream.peek(5).get(3).getValue());
            Assert.assertTrue(tokenStream.has(4));
            Assert.assertFalse(tokenStream.has(5));
        }
    }
    
    
    @Test
    public void testNext() {
        {
            TokenStream tokenStream = new TokenStream("\tSunO .\r\n\tLunO .\r\n", TC);
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
            TokenStream tokenStream = new TokenStream("SunO . LunO SunA .", TC);
            if (tokenStream.hasOneOf(TokenType.SUBSTANTIVE_SINGULAR)) {
                List<Token> nextTokens = tokenStream.next(1);
                Assert.assertEquals(1, nextTokens.size());
                Assert.assertEquals("SunO", nextTokens.get(0).getValue());
            }
            if (tokenStream.hasSequence(TokenType.TERMINATOR, TokenType.SUBSTANTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR)) {
                List<Token> nextTokens = tokenStream.next(3);
                Assert.assertEquals(3, nextTokens.size());
                Assert.assertEquals(".", nextTokens.get(0).getValue());
                Assert.assertEquals("LunO", nextTokens.get(1).getValue());
                Assert.assertEquals("SunA", nextTokens.get(2).getValue());
            }
            Assert.assertTrue(tokenStream.next(5).isEmpty());
            Assert.assertFalse(tokenStream.has(5));
            List<Token> nextTokens = tokenStream.next(5);
            Assert.assertEquals(1, nextTokens.size());
            Assert.assertEquals(".", nextTokens.get(0).getValue());
        }
    }
    
    @Test
    public void testClose() throws IOException {
        TokenStream tokenStream = new TokenStream("'OPENED'O 'UNREACHABLE-CLOSED'O", TC);
        Assert.assertTrue(tokenStream.has(1));
        tokenStream.close();
        LOGGER.info("The following IOException is provocated for the purpose of testing.");
        Assert.assertFalse(tokenStream.has(2));
    }
    
    private static final class TokenCreatorForTokenStreamTest implements TokenCreator {
        
        private static final TokenType[] SUPPORTED = new TokenType[] {
            TokenType.UNKNOWN,
            TokenType.TERMINATOR,
            TokenType.ARTICLE,
            TokenType.PARAMETERED_SUBSTANTIVE_SINGULAR,
            TokenType.SUBSTANTIVE_SINGULAR,
            TokenType.ADJECTIVE_SINGULAR
        };
        
        private static final EnumMap<ConceptTermination, Selector> SELECTIONS = new EnumMap<>(ConceptTermination.class);
    
        static {
            SELECTIONS.put(ConceptTermination.PERIOD, (Selector) (Concept c) -> TERMINATOR);
            SELECTIONS.put(ConceptTermination.LA, (Selector) (Concept c) -> ARTICLE);
            SELECTIONS.put(ConceptTermination.O, (Selector) (Concept c) -> c.getProperties().hasParameter() ? PARAMETERED_SUBSTANTIVE_SINGULAR : SUBSTANTIVE_SINGULAR);
            SELECTIONS.put(ConceptTermination.A, (Selector) (Concept c) -> ADJECTIVE_SINGULAR);
        }
        
        @Override
        public final Token create(final String conceptPhrase) {
            final Concept concept = ConceptRegistry.getInstance().getConcept(conceptPhrase);
            return new Token(conceptPhrase, this.selectTokenType(concept), concept);
        }
        
        @Override
        public final TokenType[] getSupportedTokenTypes() {
            return SUPPORTED;
        }
        
        @Override
        public final TokenType selectTokenType(final Concept concept) {
            final ConceptTermination termination = concept.getProperties().getTermination();
            if (SELECTIONS.containsKey(termination)) {
                return SELECTIONS.get(termination).select(concept);
            }
            return TokenType.UNKNOWN;
        }
    }
}

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tokens;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.concepts.ConceptRegistry;
import org.jesadido.poc.core.concepts.ConceptTermination;
import org.junit.Assert;
import org.junit.Test;

public class TokenCreatorTest {
    
    @Test
    public void testCreate() {
        {
            final TokenCreator tokenCreator = new TokenCreatorA();
            Assert.assertNotNull(tokenCreator.create("."));
            Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.create(".", 28, 1).getType());
            Assert.assertNotNull(tokenCreator.create("LunO"));
            Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.create("LunO", 7, 1).getType());
            Assert.assertNotNull(tokenCreator.create("LunOJ"));
            Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.create("LunOJ").getType());
            Assert.assertNotNull(tokenCreator.create("LunA"));
            Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.create("LunA").getType());
            Assert.assertNotNull(tokenCreator.create("LunAJ"));
            Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.create("LunAJ").getType());
            Assert.assertNotNull(tokenCreator.create("LunE"));
            Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.create("LunE").getType());
            Assert.assertNotNull(tokenCreator.create("LunEJ"));
            Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.create("LunEJ").getType());
            Assert.assertNotNull(tokenCreator.create("/de/'Stefan'IcxO$Mi"));
            Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.create("/de/'Stefan'IcxO$Mi").getType());
            Assert.assertNotNull(tokenCreator.create("/de/'Baurs'|'Baur'OJ$Ni"));
            Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.create("/de/'Baurs'|'Baur'OJ$Ni").getType());
            Assert.assertNotNull(tokenCreator.create("/de/'Müllers'|'Müller'OJ$Vi"));
            Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.create("/de/'Müllers'|'Müller'OJ$Vi").getType());
        }
        {
            final TokenCreator tokenCreator = new TokenCreatorB();
            Assert.assertNotNull(tokenCreator.create("."));
            Assert.assertEquals(TokenType.TERMINATOR, tokenCreator.create(".").getType());
            Assert.assertNotNull(tokenCreator.create("LunO"));
            Assert.assertEquals(TokenType.SUBSTANTIVE_SINGULAR, tokenCreator.create("LunO", 40, 30).getType());
            Assert.assertNotNull(tokenCreator.create("LunOJ"));
            Assert.assertEquals(TokenType.SUBSTANTIVE_PLURAL, tokenCreator.create("LunOJ").getType());
            Assert.assertNotNull(tokenCreator.create("LunA"));
            Assert.assertEquals(TokenType.ADJECTIVE_SINGULAR, tokenCreator.create("LunA").getType());
            Assert.assertNotNull(tokenCreator.create("LunAJ"));
            Assert.assertEquals(TokenType.ADJECTIVE_PLURAL, tokenCreator.create("LunAJ", 30, 11).getType());
            Assert.assertNotNull(tokenCreator.create("LunE"));
            Assert.assertEquals(TokenType.ADVERB_SINGULAR, tokenCreator.create("LunE").getType());
            Assert.assertNotNull(tokenCreator.create("LunEJ"));
            Assert.assertEquals(TokenType.ADVERB_PLURAL, tokenCreator.create("LunEJ").getType());
            Assert.assertNotNull(tokenCreator.create("/de/'Stefan'IcxO$Mi"));
            Assert.assertEquals(TokenType.PERSONAL_PRONOUN_SINGULAR, tokenCreator.create("/de/'Stefan'IcxO$Mi").getType());
            Assert.assertNotNull(tokenCreator.create("/de/'Baurs'|'Baur'OJ$Ni"));
            Assert.assertEquals(TokenType.PERSONAL_PRONOUN_PLURAL, tokenCreator.create("/de/'Baurs'|'Baur'OJ$Ni").getType());
            Assert.assertNotNull(tokenCreator.create("/de/'Müllers'|'Müller'OJ$Vi"));
            Assert.assertEquals(TokenType.PERSONAL_PRONOUN_PLURAL, tokenCreator.create("/de/'Müllers'|'Müller'OJ$Vi").getType());
        }
    }
    
    @Test
    public void testGetSupportedTokenTypes() {
        {
            final TokenCreator tokenCreator = new TokenCreatorA();
            Assert.assertTrue(TokenType.UNKNOWN.isOneOf(tokenCreator.getSupportedTokenTypes()));
            Assert.assertFalse(TokenType.TERMINATOR.isOneOf(tokenCreator.getSupportedTokenTypes()));
            Assert.assertFalse(TokenType.SUBSTANTIVE.isOneOf(tokenCreator.getSupportedTokenTypes()));
            Assert.assertFalse(TokenType.ADJECTIVE_PLURAL.isOneOf(tokenCreator.getSupportedTokenTypes()));
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
        {
            final TokenCreator tokenCreator = new TokenCreatorB();
            Assert.assertTrue(TokenType.UNKNOWN.isOneOf(tokenCreator.getSupportedTokenTypes()));
            Assert.assertTrue(TokenType.TERMINATOR.isOneOf(tokenCreator.getSupportedTokenTypes()));
            Assert.assertTrue(TokenType.SUBSTANTIVE_SINGULAR.isOneOf(tokenCreator.getSupportedTokenTypes()));
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
    }
    
    @Test
    public void testSelectTokenType() {
        {
            final TokenCreator tokenCreator = new TokenCreatorA();
            Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("X")));
            Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept(".")));
            Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("Titl.")));
            Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("SunO")));
            Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("SunOJ")));
            Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("SunA")));
            Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("SunAJ")));
            Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("SunE")));
            Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("SunEJ")));
            Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("/de/'Berta'InO")));
            Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("'1965-08-11'DatO")));
            Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("/de/'Baurs'|'Baur'OJ")));
            Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("/de/'Stefan'IcxO$Mi")));
            Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("/de/'Baurs'|'Baur'OJ$Ni")));
            Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("Kaj")));
            Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("Aux")));
            Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept(",")));
            Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("La")));
            Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("Da$La")));
            Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("Mi$La")));
            Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("HomArO$Ni$La")));
        }
        {
            final TokenCreator tokenCreator = new TokenCreatorB();
            Assert.assertEquals(TokenType.UNKNOWN, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("X")));
            Assert.assertEquals(TokenType.TERMINATOR, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept(".")));
            Assert.assertEquals(TokenType.TERMINATOR, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("Titl.")));
            Assert.assertEquals(TokenType.SUBSTANTIVE_SINGULAR, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("SunO")));
            Assert.assertEquals(TokenType.SUBSTANTIVE_PLURAL, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("SunOJ")));
            Assert.assertEquals(TokenType.ADJECTIVE_SINGULAR, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("SunA")));
            Assert.assertEquals(TokenType.ADJECTIVE_PLURAL, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("SunAJ")));
            Assert.assertEquals(TokenType.ADVERB_SINGULAR, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("SunE")));
            Assert.assertEquals(TokenType.ADVERB_PLURAL, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("SunEJ")));
            Assert.assertEquals(TokenType.PARAMETERED_SUBSTANTIVE_SINGULAR, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("/de/'Berta'InO")));
            Assert.assertEquals(TokenType.PARAMETERED_SUBSTANTIVE_SINGULAR, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("'1965-08-11'DatO")));
            Assert.assertEquals(TokenType.PARAMETERED_SUBSTANTIVE_PLURAL, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("/de/'Baurs'|'Baur'OJ")));
            Assert.assertEquals(TokenType.PERSONAL_PRONOUN_SINGULAR, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("/de/'Stefan'IcxO$Mi")));
            Assert.assertEquals(TokenType.PERSONAL_PRONOUN_PLURAL, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("/de/'Baurs'|'Baur'OJ$Ni")));
            Assert.assertEquals(TokenType.SEPARATOR, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("Kaj")));
            Assert.assertEquals(TokenType.SEPARATOR, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("Aux")));
            Assert.assertEquals(TokenType.SEPARATOR, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept(",")));
            Assert.assertEquals(TokenType.ARTICLE, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("La")));
            Assert.assertEquals(TokenType.ARTICLE, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("Da$La")));
            Assert.assertEquals(TokenType.ARTICLE, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("Mi$La")));
            Assert.assertEquals(TokenType.ARTICLE, tokenCreator.selectTokenType(ConceptRegistry.getInstance().getConcept("HomArO$Ni$La")));
        }
    }
    
    private static final class TokenCreatorA extends TokenCreator {
        
        @Override
        public final List<TokenType> getSupportedTokenTypes() {
            return Arrays.asList(TokenType.UNKNOWN);
        }
        
        
        @Override
        public final Token create(final String conceptPhrase) {
            final Concept concept = ConceptRegistry.getInstance().getConcept(conceptPhrase);
            return new Token(conceptPhrase, this.selectTokenType(concept), concept);
        }
        
        @Override
        public final TokenType selectTokenType(final Concept concept) {
            return TokenType.UNKNOWN;
        }
    }
    
    private static final class TokenCreatorB extends TokenCreator {
        
        private static final List<TokenType> SUPPORTED = Arrays.asList(TokenType.UNKNOWN,
                TokenType.INVALID_CONCEPT,
                TokenType.ADJECTIVE_PLURAL,
                TokenType.ADJECTIVE_SINGULAR,
                TokenType.ADVERB_PLURAL,
                TokenType.ADVERB_SINGULAR,
                TokenType.ARTICLE,
                TokenType.SEPARATOR,
                TokenType.PARAMETERED_SUBSTANTIVE_PLURAL,
                TokenType.PARAMETERED_SUBSTANTIVE_SINGULAR,
                TokenType.PERSONAL_PRONOUN_PLURAL,
                TokenType.PERSONAL_PRONOUN_SINGULAR,
                TokenType.SUBSTANTIVE_PLURAL,
                TokenType.SUBSTANTIVE_SINGULAR,
                TokenType.TERMINATOR
        );
        
        private static final Map<ConceptTermination, Selector> SELECTIONS = new EnumMap<>(ConceptTermination.class);
    
        static {
            SELECTIONS.put(ConceptTermination.PERIOD, (Selector) (Concept c) -> TokenType.TERMINATOR);
            SELECTIONS.put(ConceptTermination.LA, (Selector) (Concept c) -> TokenType.ARTICLE);
            SELECTIONS.put(ConceptTermination.O, (Selector) (Concept c) -> c.getProperties().hasParameter() ? TokenType.PARAMETERED_SUBSTANTIVE_SINGULAR : TokenType.SUBSTANTIVE_SINGULAR);
            SELECTIONS.put(ConceptTermination.O_J, (Selector) (Concept c) -> c.getProperties().hasParameter() ? TokenType.PARAMETERED_SUBSTANTIVE_PLURAL : TokenType.SUBSTANTIVE_PLURAL);
            SELECTIONS.put(ConceptTermination.A, (Selector) (Concept c) -> TokenType.ADJECTIVE_SINGULAR);
            SELECTIONS.put(ConceptTermination.A_J, (Selector) (Concept c) -> TokenType.ADJECTIVE_PLURAL);
            SELECTIONS.put(ConceptTermination.E, (Selector) (Concept c) -> TokenType.ADVERB_SINGULAR);
            SELECTIONS.put(ConceptTermination.E_J, (Selector) (Concept c) -> TokenType.ADVERB_PLURAL);
            SELECTIONS.put(ConceptTermination.MI, (Selector) (Concept c) -> TokenType.PERSONAL_PRONOUN_SINGULAR);
            SELECTIONS.put(ConceptTermination.NI, (Selector) (Concept c) -> TokenType.PERSONAL_PRONOUN_PLURAL);
            SELECTIONS.put(ConceptTermination.VI, (Selector) (Concept c) -> TokenType.PERSONAL_PRONOUN_PLURAL);
            SELECTIONS.put(ConceptTermination.KAJ, (Selector) (Concept c) -> TokenType.SEPARATOR);
            SELECTIONS.put(ConceptTermination.AUX, (Selector) (Concept c) -> TokenType.SEPARATOR);
            SELECTIONS.put(ConceptTermination.COMMA, (Selector) (Concept c) -> TokenType.SEPARATOR);
        }
        
        @Override
        public final Token create(final String conceptPhrase) {
            final String value = conceptPhrase == null ? "" : conceptPhrase;
            final Concept concept = ConceptRegistry.getInstance().getConcept(value);
            if (!value.equals(concept.getFullPhrase())) {
                return new Token(value, TokenType.INVALID_CONCEPT, concept);
            }
            return new Token(value, this.selectTokenType(concept), concept);
        }
        
        @Override
        public final List<TokenType> getSupportedTokenTypes() {
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

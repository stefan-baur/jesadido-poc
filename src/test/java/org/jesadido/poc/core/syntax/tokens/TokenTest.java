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
import static org.jesadido.poc.core.syntax.tokens.TokenType.ADJECTIVE;
import static org.jesadido.poc.core.syntax.tokens.TokenType.ADVERB;
import static org.jesadido.poc.core.syntax.tokens.TokenType.PERSONAL_PRONOUN;
import static org.jesadido.poc.core.syntax.tokens.TokenType.SUBSTANTIVE;
import static org.jesadido.poc.core.syntax.tokens.TokenType.TERMINATOR;
import org.junit.Assert;
import org.junit.Test;

public class TokenTest {
    
    private static final TokenCreator TC = new TokenCreatorForTokenTest();
    
    @Test
    public void testGetValue() {
        Assert.assertEquals(".", TC.create(".").getValue());
        Assert.assertEquals("LunO", TC.create("LunO").getValue());
        Assert.assertEquals("LunOJ", TC.create("LunOJ").getValue());
        Assert.assertEquals("LunA", TC.create("LunA").getValue());
        Assert.assertEquals("LunAJ", TC.create("LunAJ").getValue());
        Assert.assertEquals("LunE", TC.create("LunE").getValue());
        Assert.assertEquals("LunEJ", TC.create("LunEJ").getValue());
        Assert.assertEquals("/de/'Stefan'IcxO$Mi", TC.create("/de/'Stefan'IcxO$Mi").getValue());
        Assert.assertEquals("/de/'Baurs'|'Baur'OJ$Ni", TC.create("/de/'Baurs'|'Baur'OJ$Ni").getValue());
        Assert.assertEquals("/de/'Müllers'|'Müller'OJ$Vi", TC.create("/de/'Müllers'|'Müller'OJ$Vi").getValue());
    }
    
    @Test
    public void testGetType() {
        Assert.assertEquals(TokenType.TERMINATOR, TC.create(".").getType());
        Assert.assertEquals(TokenType.SUBSTANTIVE, TC.create("LunO").getType());
        Assert.assertEquals(TokenType.SUBSTANTIVE, TC.create("LunOJ").getType());
        Assert.assertEquals(TokenType.ADJECTIVE, TC.create("LunA").getType());
        Assert.assertEquals(TokenType.ADJECTIVE, TC.create("LunAJ").getType());
        Assert.assertEquals(TokenType.ADVERB, TC.create("LunE").getType());
        Assert.assertEquals(TokenType.ADVERB, TC.create("LunEJ").getType());
        Assert.assertEquals(TokenType.PERSONAL_PRONOUN, TC.create("/de/'Stefan'IcxO$Mi").getType());
        Assert.assertEquals(TokenType.PERSONAL_PRONOUN, TC.create("/de/'Baurs'|'Baur'OJ$Ni").getType());
        Assert.assertEquals(TokenType.PERSONAL_PRONOUN, TC.create("/de/'Müllers'|'Müller'OJ$Vi").getType());
    }
    
    @Test
    public void testGetConcept() {
        Assert.assertEquals(".", TC.create(".").getConcept().getFullPhrase());
        Assert.assertEquals("LunO", TC.create("LunO").getConcept().getFullPhrase());
        Assert.assertEquals("LunOJ", TC.create("LunOJ").getConcept().getFullPhrase());
        Assert.assertEquals("LunA", TC.create("LunA").getConcept().getFullPhrase());
        Assert.assertEquals("LunAJ", TC.create("LunAJ").getConcept().getFullPhrase());
        Assert.assertEquals("LunE", TC.create("LunE").getConcept().getFullPhrase());
        Assert.assertEquals("LunEJ", TC.create("LunEJ").getConcept().getFullPhrase());
        Assert.assertEquals("/de/'Stefan'IcxO$Mi", TC.create("/de/'Stefan'IcxO$Mi").getConcept().getFullPhrase());
        Assert.assertEquals("/de/'Baurs'|'Baur'OJ$Ni", TC.create("/de/'Baurs'|'Baur'OJ$Ni").getConcept().getFullPhrase());
        Assert.assertEquals("/de/'Müllers'|'Müller'OJ$Vi", TC.create("/de/'Müllers'|'Müller'OJ$Vi").getConcept().getFullPhrase());
    }
    
    @Test
    public void testToString() {
        Assert.assertEquals("TERMINATOR[\".\"]", TC.create(".").toString());
        Assert.assertEquals("SUBSTANTIVE[\"LunO\"]", TC.create("LunO").toString());
        Assert.assertEquals("SUBSTANTIVE[\"LunOJ\"]", TC.create("LunOJ").toString());
        Assert.assertEquals("ADJECTIVE[\"LunA\"]", TC.create("LunA").toString());
        Assert.assertEquals("ADJECTIVE[\"LunAJ\"]", TC.create("LunAJ").toString());
        Assert.assertEquals("ADVERB[\"LunE\"]", TC.create("LunE").toString());
        Assert.assertEquals("ADVERB[\"LunEJ\"]", TC.create("LunEJ").toString());
        Assert.assertEquals("PERSONAL_PRONOUN[\"/de/'Stefan'IcxO$Mi\"]", TC.create("/de/'Stefan'IcxO$Mi").toString());
        Assert.assertEquals("PERSONAL_PRONOUN[\"/de/'Baurs'|'Baur'OJ$Ni\"]", TC.create("/de/'Baurs'|'Baur'OJ$Ni").toString());
        Assert.assertEquals("PERSONAL_PRONOUN[\"/de/'Müllers'|'Müller'OJ$Vi\"]", TC.create("/de/'Müllers'|'Müller'OJ$Vi").toString());
    }
    
    private static final class TokenCreatorForTokenTest extends TokenCreator {
        
        private static final List<TokenType> SUPPORTED = Arrays.asList(
                TokenType.UNKNOWN,
                TokenType.TERMINATOR,
                TokenType.SUBSTANTIVE,
                TokenType.ADJECTIVE,
                TokenType.ADVERB,
                TokenType.PERSONAL_PRONOUN
        );
        
        private static final Map<ConceptTermination, Selector> SELECTIONS = new EnumMap<>(ConceptTermination.class);
    
        static {
            SELECTIONS.put(ConceptTermination.PERIOD, (Selector) (Concept c) -> TERMINATOR);
            SELECTIONS.put(ConceptTermination.O, (Selector) (Concept c) -> SUBSTANTIVE);
            SELECTIONS.put(ConceptTermination.O_J, (Selector) (Concept c) -> SUBSTANTIVE);
            SELECTIONS.put(ConceptTermination.A, (Selector) (Concept c) -> ADJECTIVE);
            SELECTIONS.put(ConceptTermination.A_J, (Selector) (Concept c) -> ADJECTIVE);
            SELECTIONS.put(ConceptTermination.E, (Selector) (Concept c) -> ADVERB);
            SELECTIONS.put(ConceptTermination.E_J, (Selector) (Concept c) -> ADVERB);
            SELECTIONS.put(ConceptTermination.MI, (Selector) (Concept c) -> PERSONAL_PRONOUN);
            SELECTIONS.put(ConceptTermination.NI, (Selector) (Concept c) -> PERSONAL_PRONOUN);
            SELECTIONS.put(ConceptTermination.VI, (Selector) (Concept c) -> PERSONAL_PRONOUN);
        }
        
        @Override
        public final Token create(final String conceptPhrase) {
            final Concept concept = ConceptRegistry.getInstance().getConcept(conceptPhrase);
            return new Token(conceptPhrase, this.selectTokenType(concept), concept);
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

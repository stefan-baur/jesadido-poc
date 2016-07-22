/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tokens;

import java.util.EnumMap;
import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.concepts.ConceptTermination;

public enum TokenType {
    
    UNKNOWN,
    INVALID_CONCEPT,
    ARTICLE,
    SUBSTANTIVE_SINGULAR,
    SUBSTANTIVE_PLURAL,
    PARAMETERED_SUBSTANTIVE_SINGULAR,
    PARAMETERED_SUBSTANTIVE_PLURAL,
    ADJECTIVE_SINGULAR,
    ADJECTIVE_PLURAL,
    ADVERB_SINGULAR,
    ADVERB_PLURAL,
    PERSONAL_PRONOUN_SINGULAR,
    PERSONAL_PRONOUN_PLURAL,
    TERMINATOR;
    
    @FunctionalInterface
    private interface Selector {
        TokenType select(Concept concept);
    }
    
    private static final EnumMap<ConceptTermination, Selector> SELECTIONS = new EnumMap<>(ConceptTermination.class);
    
    static {
        SELECTIONS.put(ConceptTermination.TERMINATOR, (Selector) (Concept c) -> TERMINATOR);
        SELECTIONS.put(ConceptTermination.LA, (Selector) (Concept c) -> ARTICLE);
        SELECTIONS.put(ConceptTermination.O, (Selector) (Concept c) -> c.getProperties().hasParameter() ? PARAMETERED_SUBSTANTIVE_SINGULAR : SUBSTANTIVE_SINGULAR);
        SELECTIONS.put(ConceptTermination.O_J, (Selector) (Concept c) -> c.getProperties().hasParameter() ? PARAMETERED_SUBSTANTIVE_PLURAL : SUBSTANTIVE_PLURAL);
        SELECTIONS.put(ConceptTermination.A, (Selector) (Concept c) -> ADJECTIVE_SINGULAR);
        SELECTIONS.put(ConceptTermination.A_J, (Selector) (Concept c) -> ADJECTIVE_PLURAL);
        SELECTIONS.put(ConceptTermination.E, (Selector) (Concept c) -> ADVERB_SINGULAR);
        SELECTIONS.put(ConceptTermination.E_J, (Selector) (Concept c) -> ADVERB_PLURAL);
        SELECTIONS.put(ConceptTermination.MI, (Selector) (Concept c) -> PERSONAL_PRONOUN_SINGULAR);
        SELECTIONS.put(ConceptTermination.BI, (Selector) (Concept c) -> PERSONAL_PRONOUN_SINGULAR);
        SELECTIONS.put(ConceptTermination.GXI, (Selector) (Concept c) -> PERSONAL_PRONOUN_SINGULAR);
        SELECTIONS.put(ConceptTermination.NI, (Selector) (Concept c) -> PERSONAL_PRONOUN_PLURAL);
        SELECTIONS.put(ConceptTermination.VI, (Selector) (Concept c) -> PERSONAL_PRONOUN_PLURAL);
        SELECTIONS.put(ConceptTermination.ILI, (Selector) (Concept c) -> PERSONAL_PRONOUN_PLURAL);
    }
    
    public static final TokenType get(Concept concept) {
        ConceptTermination termination = concept.getProperties().getTermination();
        if (SELECTIONS.containsKey(termination)) {
            return SELECTIONS.get(termination).select(concept);
        }
        return UNKNOWN;
    }
}

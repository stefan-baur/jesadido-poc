/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.concepts;

/**
 * This <code>ConceptTermination</code> enum class provides a list syntactical
 * concept informations representated by the ending of a concept/lexeme.
 */
public enum ConceptTermination {
    
    /**
     * The appropriated concept has no listed termination.
     */
    NONE(null),
    
    /**
     * The appropriated concept is a standard termination symbol, for example a
     * sentence/clause termination.
     */
    PERIOD("."),
    
    /**
     * The appropriated concept is a substantive (singular).
     */
    O("O"),
    
    /**
     * The appropriated concept is an adjective (singular).
     */
    A("A"),
    
    /**
     * The appropriated concept is an adverb (singular).
     */
    E("E"),
    
    /**
     * The appropriated concept is a substantive (plural).
     */
    O_J("OJ"),
    
    /**
     * The appropriated concept is an adjective (plural).
     */
    A_J("AJ"),
    
    /**
     * The appropriated concept is an adverb (plural).
     */
    E_J("EJ"),
    
    /**
     * The appropriated concept is an article.
     */
    LA("La"),
    
    /**
     * The appropriated concept is the personal pronoun <b>I</b>
     * (1. person, singular).
     */
    MI("Mi"),
    
    /**
     * The appropriated concept is the personal pronoun <b>you</b>
     * (2. person, singular).
     */
    BI("Bi"),
    
    /**
     * The appropriated concept is the personal pronoun <b>it</b>
     * (3. person, singular).
     */
    GXI("Gxi"),
    
    /**
     * The appropriated concept is the personal pronoun <b>we</b>
     * (1. person, plural).
     */
    NI("Ni"),
    
    /**
     * The appropriated concept is the personal pronoun <b>you</b>
     * (2. person, plural).
     */
    VI("Vi"),
    
    /**
     * The appropriated concept is the personal pronoun <b>they</b>
     * (3. person, plural).
     */
    ILI("Ili"),
    
    /**
     * The appropriated concept is a verb indicator for infinitive.
     */
    I("I"),
    
    /**
     * The appropriated concept is a verb indicator for imperative.
     */
    U("U"),
    
    /**
     * The appropriated concept is a verb indicator for conjunctive.
     */
    US("Us"),
    
    /**
     * The appropriated concept is a verb indicator for present tense.
     */
    AS("As"),
    
    /**
     * The appropriated concept is a verb indicator for past tense.
     */
    IS("Is"),
    
    /**
     * The appropriated concept is a verb indicator for future.
     */
    OS("Os"),
    
    /**
     * The appropriated concept stands for <b>and</b> (conjunction, subjunction
     * or rhetorical enumeration).
     */
    KAJ("Kaj"),
    
    /**
     * The appropriated concept stands for <b>or</b> (conjunction, etc.).
     */
    AUX("Aux"),
    
    /**
     * The appropriated concept is a comma, a separator symbol.
     */
    COMMA(","),
    
    /**
     * The appropriated concept is a subject preposition termination phrase.
     */
    SU("Su"),
    
    /**
     * The appropriated concept is a predicate preposition termination phrase.
     */
    DOM("Dom"),
    
    /**
     * The appropriated concept is a genitive object preposition termination
     * phrase.
     */
    DE("De"),
    
    /**
     * The appropriated concept is a dative object preposition termination
     * phrase.
     */
    AL("Al"),
    
    /**
     * The appropriated concept is an accusative object preposition termination
     * phrase.
     */
    FIN("Fin"),
    
    /**
     * The appropriated concept is a left square bracket, a typical opening sign
     * for ordered sequences.
     */
    L0("["),
    
    /**
     * The appropriated concept is a right square bracket, a typical closing
     * sign for ordered sequences.
     */
    R0("]"),
    
    /**
     * The appropriated concept is a left curly bracket, a left brace, a typical
     * opening sign for unordered sets.
     */
    L1("{"),
    
    /**
     * The appropriated concept is a right curly bracket, a right brace, a
     * typical closing sign for unordered sets.
     */
    R1("}"),
    
    /**
     * The appropriated concept is a left parenthesis, a typical opening sign
     * for any arguments.
     */
    L2("("),
    
    /**
     * The appropriated concept is a right parenthesis, a typical closing sign
     * for any arguments.
     */
    R2(")"),
    
    /**
     * The appropriated concept is a left angle bracket, a lower-than sign.
     */
    L3("<"),
    
    /**
     * The appropriated concept is a right angle bracket, a greater-than sign.
     */
    R3(">");
    
    private final String terminationPhrase;
    
    private ConceptTermination(final String terminationPhrase) {
        this.terminationPhrase = terminationPhrase;
    }
    
    /**
     * Returns the termination indicator as lexematical ending.
     * @return The termination indicator.
     */
    public final String getTerminationPhrase() {
        return this.terminationPhrase;
    }
    
    /**
     * Indicates whether the instance is contained inside the given concept
     * terminations. It's a kind of syntactical sugar for this framework source.
     * @param conceptTerminations The given concept terminations.
     * @return <code>true</code> if the termination is contained.
     */
    public final boolean isOneOf(final ConceptTermination ... conceptTerminations) {
        for (final ConceptTermination conceptTermination : conceptTerminations) {
            if (this == conceptTermination) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Returns the termination of the given concept phrase.
     * @param conceptPhrase The given concept phrase.
     * @return The termination of the given concept phrase.
     */
    public static final ConceptTermination get(final String conceptPhrase) {
        if (conceptPhrase != null) {
            for (final ConceptTermination conceptTermination : ConceptTermination.values()) {
                String termination = conceptTermination.getTerminationPhrase();
                if (termination != null && conceptPhrase.endsWith(termination)) {
                    return conceptTermination;
                }
            }
        }
        return ConceptTermination.NONE;
    }
}

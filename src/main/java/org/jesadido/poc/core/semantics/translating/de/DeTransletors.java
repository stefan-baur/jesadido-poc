/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.de;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.semantics.translating.TranslationResult;
import org.jesadido.poc.core.semantics.translating.TransletParameters;
import org.jesadido.poc.core.semantics.translating.Transletor;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public final class DeTransletors {
    
    private static final Transletor NOMINAL_TRANSLETOR = new Transletor()
            .add(Arrays.asList(TokenType.SUBSTANTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> nomQO(r, p.getCaseAttribute(), p.getConcept(0)))
            .add(Arrays.asList(TokenType.SUBSTANTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> nomQOXA(r, p.getCaseAttribute(), p.getConcept(0), p.getConcepts().subList(1, 2)))
            .add(Arrays.asList(TokenType.SUBSTANTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> nomQOXA(r, p.getCaseAttribute(), p.getConcept(0), p.getConcepts().subList(1, 3)))
            .add(Arrays.asList(TokenType.SUBSTANTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> nomQOXA(r, p.getCaseAttribute(), p.getConcept(0), p.getConcepts().subList(1, 4)))
            .add(Arrays.asList(TokenType.ARTICLE, TokenType.SUBSTANTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> nomQLaQO(r, p.getCaseAttribute(), p.getConcept(0), p.getConcept(1)))
            .add(Arrays.asList(TokenType.ARTICLE, TokenType.SUBSTANTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> nomQLaQOXA(r, p.getCaseAttribute(), p.getConcept(0), p.getConcept(1), p.getConcepts().subList(2, 3)))
            .add(Arrays.asList(TokenType.ARTICLE, TokenType.SUBSTANTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> nomQLaQOXA(r, p.getCaseAttribute(), p.getConcept(0), p.getConcept(1), p.getConcepts().subList(2, 4)))
            .add(Arrays.asList(TokenType.ARTICLE, TokenType.SUBSTANTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> nomQLaQOXA(r, p.getCaseAttribute(), p.getConcept(0), p.getConcept(1), p.getConcepts().subList(2, 5)))
            ;
    
    private DeTransletors() {
        // A private utility class constructor
    }
    
    public static Transletor getNominalTransletor() {
        return NOMINAL_TRANSLETOR;
    }
    
    private static void nomQO(final TranslationResult result, final Object caseAttribute, final Concept substantiveConcept) {
        nomQOXA(result, caseAttribute, substantiveConcept, new LinkedList<>());
    }
    
    private static void nomQOXA(final TranslationResult result, final Object caseAttribute, final Concept substantiveConcept, final List<Concept> adjectiveConcepts) {
        result.setTranslation(DeUtils.getIndefinite(result.getTranslator(), caseAttribute, substantiveConcept, adjectiveConcepts));
    }
    
    private static void nomQLaQO(final TranslationResult result, final Object caseAttribute, final Concept articleConcept, final Concept substantiveConcept) {
        nomQLaQOXA(result, caseAttribute, articleConcept, substantiveConcept, new LinkedList<>());
    }
    
    private static void nomQLaQOXA(final TranslationResult result, final Object caseAttribute, final Concept articleConcept, final Concept substantiveConcept, final List<Concept> adjectiveConcepts) {
        result.setTranslation(DeUtils.getDefinite(result.getTranslator(), caseAttribute, articleConcept, substantiveConcept, adjectiveConcepts));
    }
}

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.en;

import java.util.Arrays;
import java.util.LinkedList;
import org.jesadido.poc.core.semantics.translating.TranslationResult;
import org.jesadido.poc.core.semantics.translating.TransletParameters;
import org.jesadido.poc.core.semantics.translating.Transletor;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public final class EnTransletors {
    
    private static final Transletor NOMINAL_TRANSLETOR = new Transletor()
            .add(Arrays.asList(TokenType.SUBSTANTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> r.setTranslation(EnUtils.getIndefinite(r.getTranslator(), p.getConcept(0), new LinkedList<>())))
            .add(Arrays.asList(TokenType.SUBSTANTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> r.setTranslation(EnUtils.getIndefinite(r.getTranslator(), p.getConcept(0), p.getConcepts().subList(1, 2))))
            .add(Arrays.asList(TokenType.SUBSTANTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> r.setTranslation(EnUtils.getIndefinite(r.getTranslator(), p.getConcept(0), p.getConcepts().subList(1, 3))))
            .add(Arrays.asList(TokenType.SUBSTANTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> r.setTranslation(EnUtils.getIndefinite(r.getTranslator(), p.getConcept(0), p.getConcepts().subList(1, 4))))
            .add(Arrays.asList(TokenType.ARTICLE, TokenType.SUBSTANTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> r.setTranslation(EnUtils.getDefinite(r.getTranslator(), p.getConcept(0), p.getConcept(1), new LinkedList<>())))
            .add(Arrays.asList(TokenType.ARTICLE, TokenType.SUBSTANTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> r.setTranslation(EnUtils.getDefinite(r.getTranslator(), p.getConcept(0), p.getConcept(1), p.getConcepts().subList(2, 3))))
            .add(Arrays.asList(TokenType.ARTICLE, TokenType.SUBSTANTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> r.setTranslation(EnUtils.getDefinite(r.getTranslator(), p.getConcept(0), p.getConcept(1), p.getConcepts().subList(2, 4))))
            .add(Arrays.asList(TokenType.ARTICLE, TokenType.SUBSTANTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> r.setTranslation(EnUtils.getDefinite(r.getTranslator(), p.getConcept(0), p.getConcept(1), p.getConcepts().subList(2, 5))))
            ;
    
    private EnTransletors() {
        // A private utility class constructor
    }
    
    public static Transletor getNominalTransletor() {
        return NOMINAL_TRANSLETOR;
    }
}

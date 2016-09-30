/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.eo;

import java.util.Arrays;
import org.jesadido.poc.core.semantics.translating.TranslationResult;
import org.jesadido.poc.core.semantics.translating.TransletParameters;
import org.jesadido.poc.core.semantics.translating.Transletor;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public final class EoTransletors {
    
    private static final Transletor NOMINAL_TRANSLETOR = new Transletor()
            .add(Arrays.asList(TokenType.SUBSTANTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> r.setTranslation(EoUtils.getIndefinite(r.getTranslator(), Eo.DEFAULT, p.getConcept(0))))
            .add(Arrays.asList(TokenType.SUBSTANTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> r.setTranslation(EoUtils.getIndefinite(r.getTranslator(), Eo.DEFAULT, p.getConcept(0), p.getConcept(1))))
            .add(Arrays.asList(TokenType.SUBSTANTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> r.setTranslation(EoUtils.getIndefinite(r.getTranslator(), Eo.DEFAULT, p.getConcept(0), p.getConcept(1), p.getConcept(2))))
            .add(Arrays.asList(TokenType.SUBSTANTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> r.setTranslation(EoUtils.getIndefinite(r.getTranslator(), Eo.DEFAULT, p.getConcept(0), p.getConcept(1), p.getConcept(2), p.getConcept(3))))
            .add(Arrays.asList(TokenType.ARTICLE, TokenType.SUBSTANTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> r.setTranslation(EoUtils.getDefinite(r.getTranslator(), Eo.DEFAULT, p.getConcept(0), p.getConcept(1))))
            .add(Arrays.asList(TokenType.ARTICLE, TokenType.SUBSTANTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> r.setTranslation(EoUtils.getDefinite(r.getTranslator(), Eo.DEFAULT, p.getConcept(0), p.getConcept(1), p.getConcept(2))))
            .add(Arrays.asList(TokenType.ARTICLE, TokenType.SUBSTANTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> r.setTranslation(EoUtils.getDefinite(r.getTranslator(), Eo.DEFAULT, p.getConcept(0), p.getConcept(1), p.getConcept(2), p.getConcept(3))))
            .add(Arrays.asList(TokenType.ARTICLE, TokenType.SUBSTANTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> r.setTranslation(EoUtils.getDefinite(r.getTranslator(), Eo.DEFAULT, p.getConcept(0), p.getConcept(1), p.getConcept(2), p.getConcept(3), p.getConcept(4))))
            ;
    
    private static final Transletor ACCUSATIVE_TRANSLETOR = new Transletor()
            .add(Arrays.asList(TokenType.SUBSTANTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> r.setTranslation(EoUtils.getIndefinite(r.getTranslator(), Eo.ACCUSATIVE, p.getConcept(0))))
            .add(Arrays.asList(TokenType.SUBSTANTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> r.setTranslation(EoUtils.getIndefinite(r.getTranslator(), Eo.ACCUSATIVE, p.getConcept(0), p.getConcept(1))))
            .add(Arrays.asList(TokenType.SUBSTANTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> r.setTranslation(EoUtils.getIndefinite(r.getTranslator(), Eo.ACCUSATIVE, p.getConcept(0), p.getConcept(1), p.getConcept(2))))
            .add(Arrays.asList(TokenType.SUBSTANTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> r.setTranslation(EoUtils.getIndefinite(r.getTranslator(), Eo.ACCUSATIVE, p.getConcept(0), p.getConcept(1), p.getConcept(2), p.getConcept(3))))
            .add(Arrays.asList(TokenType.ARTICLE, TokenType.SUBSTANTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> r.setTranslation(EoUtils.getDefinite(r.getTranslator(), Eo.ACCUSATIVE, p.getConcept(0), p.getConcept(1))))
            .add(Arrays.asList(TokenType.ARTICLE, TokenType.SUBSTANTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> r.setTranslation(EoUtils.getDefinite(r.getTranslator(), Eo.ACCUSATIVE, p.getConcept(0), p.getConcept(1), p.getConcept(2))))
            .add(Arrays.asList(TokenType.ARTICLE, TokenType.SUBSTANTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> r.setTranslation(EoUtils.getDefinite(r.getTranslator(), Eo.ACCUSATIVE, p.getConcept(0), p.getConcept(1), p.getConcept(2), p.getConcept(3))))
            .add(Arrays.asList(TokenType.ARTICLE, TokenType.SUBSTANTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR, TokenType.ADJECTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> r.setTranslation(EoUtils.getDefinite(r.getTranslator(), Eo.ACCUSATIVE, p.getConcept(0), p.getConcept(1), p.getConcept(2), p.getConcept(3), p.getConcept(4))))
            ;
    
    private EoTransletors() {
        // A private utility class constructor
    }
    
    public static Transletor getNominalTransletor(final Eo caseAttribute) {
        if (caseAttribute == Eo.ACCUSATIVE) {
            return ACCUSATIVE_TRANSLETOR;
        }
        return NOMINAL_TRANSLETOR;
    }
}

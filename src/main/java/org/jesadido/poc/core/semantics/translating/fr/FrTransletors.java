/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.fr;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import org.jesadido.poc.core.semantics.translating.TranslationResult;
import org.jesadido.poc.core.semantics.translating.TransletParameters;
import org.jesadido.poc.core.semantics.translating.Transletor;
import org.jesadido.poc.core.syntax.tokens.TokenType;
import org.jesadido.poc.core.syntax.tree.Terminal;

public final class FrTransletors {
    
    private static final Transletor NOMINATIVE_TRANSLETOR = new Transletor()
            .add(Arrays.asList(TokenType.SUBSTANTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> nomQO(r, p.getTerminal(0)))
            .add(Arrays.asList(TokenType.ARTICLE, TokenType.SUBSTANTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> nomQLaQO(r, p.getTerminal(0), p.getTerminal(1)))
            ;
    
    private static final Transletor DATIVE_TRANSLETOR = new Transletor()
            .add(Arrays.asList(TokenType.SUBSTANTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> datQO(r, p.getTerminal(0)))
            .add(Arrays.asList(TokenType.ARTICLE, TokenType.SUBSTANTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> datQLaQO(r, p.getTerminal(0), p.getTerminal(1)))
            ;
    
    private static final Transletor ACCUSATIVE_TRANSLETOR = new Transletor()
            .add(Arrays.asList(TokenType.SUBSTANTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> accQO(r, p.getTerminal(0)))
            .add(Arrays.asList(TokenType.ARTICLE, TokenType.SUBSTANTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> accQLaQO(r, p.getTerminal(0), p.getTerminal(1)))
            ;
    
    private static final Map<Fr, Transletor> NOMINAL_TRANSLETORS = new EnumMap(Fr.class);
    
    static {
        NOMINAL_TRANSLETORS.put(Fr.NOMINATIVE, NOMINATIVE_TRANSLETOR);
        NOMINAL_TRANSLETORS.put(Fr.DATIVE, DATIVE_TRANSLETOR);
        NOMINAL_TRANSLETORS.put(Fr.ACCUSATIVE, ACCUSATIVE_TRANSLETOR);
    }
    
    private FrTransletors() {
        // A private utility class constructor
    }
    
    public static Transletor getNominalTransletor(final Fr caseAttribute) {
        if (NOMINAL_TRANSLETORS.containsKey(caseAttribute)) {
            return NOMINAL_TRANSLETORS.get(caseAttribute);
        }
        return new Transletor();
    }
    
    private static void nomQO(final TranslationResult result, final Terminal substantive) {
        result.setTranslation(FrUtils.getIndefinite(result.getTranslator(), Fr.NOMINATIVE, substantive.getConcept()));
    }
    
    private static void nomQLaQO(final TranslationResult result, final Terminal article, final Terminal substantive) {
        result.setTranslation(FrUtils.getDefinite(result.getTranslator(), Fr.NOMINATIVE, article.getConcept(), substantive.getConcept()));
    }
    
    private static void datQO(final TranslationResult result, final Terminal substantive) {
        result.setTranslation(FrUtils.getIndefinite(result.getTranslator(), Fr.DATIVE, substantive.getConcept()));
    }
    
    private static void datQLaQO(final TranslationResult result, final Terminal article, final Terminal substantive) {
        result.setTranslation(FrUtils.getDefinite(result.getTranslator(), Fr.DATIVE, article.getConcept(), substantive.getConcept()));
    }
    
    private static void accQO(final TranslationResult result, final Terminal substantive) {
        result.setTranslation(FrUtils.getIndefinite(result.getTranslator(), Fr.ACCUSATIVE, substantive.getConcept()));
    }
    
    private static void accQLaQO(final TranslationResult result, final Terminal article, final Terminal substantive) {
        result.setTranslation(FrUtils.getDefinite(result.getTranslator(), Fr.ACCUSATIVE, article.getConcept(), substantive.getConcept()));
    }
}

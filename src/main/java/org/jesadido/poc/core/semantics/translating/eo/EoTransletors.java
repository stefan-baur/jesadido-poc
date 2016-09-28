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
import org.jesadido.poc.core.syntax.tree.Terminal;

public final class EoTransletors {
    
    private static final Transletor NOMINAL_TRANSLETOR = new Transletor()
            .add(Arrays.asList(TokenType.SUBSTANTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> nomQO(r, p.getTerminal(0)))
            .add(Arrays.asList(TokenType.ARTICLE, TokenType.SUBSTANTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> nomQLaQO(r, p.getTerminal(0), p.getTerminal(1)))
            ;
    
    private static final Transletor ACCUSATIVE_TRANSLETOR = new Transletor()
            .add(Arrays.asList(TokenType.SUBSTANTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> accQO(r, p.getTerminal(0)))
            .add(Arrays.asList(TokenType.ARTICLE, TokenType.SUBSTANTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> accQLaQO(r, p.getTerminal(0), p.getTerminal(1)))
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
    
    private static void nomQO(final TranslationResult result, final Terminal substantive) {
        result.setTranslation(EoUtils.getIndefinite(result.getTranslator(), Eo.DEFAULT, substantive.getConcept()));
    }
    
    private static void nomQLaQO(final TranslationResult result, final Terminal article, final Terminal substantive) {
        result.setTranslation(EoUtils.getDefinite(result.getTranslator(), Eo.DEFAULT, article.getConcept(), substantive.getConcept()));
    }
    
    private static void accQO(final TranslationResult result, final Terminal substantive) {
        result.setTranslation(EoUtils.getIndefinite(result.getTranslator(), Eo.ACCUSATIVE, substantive.getConcept()));
    }
    
    private static void accQLaQO(final TranslationResult result, final Terminal article, final Terminal substantive) {
        result.setTranslation(EoUtils.getDefinite(result.getTranslator(), Eo.ACCUSATIVE, article.getConcept(), substantive.getConcept()));
    }
}

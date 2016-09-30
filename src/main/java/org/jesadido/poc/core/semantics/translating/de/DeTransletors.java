/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.de;

import java.util.Arrays;
import org.jesadido.poc.core.semantics.translating.TranslationResult;
import org.jesadido.poc.core.semantics.translating.TransletParameters;
import org.jesadido.poc.core.semantics.translating.Transletor;
import org.jesadido.poc.core.syntax.tokens.TokenType;
import org.jesadido.poc.core.syntax.tree.Terminal;

public final class DeTransletors {
    
    private static final Transletor NOMINAL_TRANSLETOR = new Transletor()
            .add(Arrays.asList(TokenType.SUBSTANTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> nomQO(r, p.getCaseAttribute(), p.getTerminal(0)))
            .add(Arrays.asList(TokenType.ARTICLE, TokenType.SUBSTANTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> nomQLaQO(r, p.getCaseAttribute(), p.getTerminal(0), p.getTerminal(1)))
            ;
    
    private DeTransletors() {
        // A private utility class constructor
    }
    
    public static Transletor getNominalTransletor() {
        return NOMINAL_TRANSLETOR;
    }
    
    private static void nomQO(final TranslationResult result, final Object caseAttribute, final Terminal substantive) {
        result.setTranslation(DeUtils.getIndefinite(result.getTranslator(), caseAttribute, substantive.getConcept()));
    }
    
    private static void nomQLaQO(final TranslationResult result, final Object caseAttribute, final Terminal article, final Terminal substantive) {
        result.setTranslation(DeUtils.getDefinite(result.getTranslator(), caseAttribute, article.getConcept(), substantive.getConcept()));
    }
}

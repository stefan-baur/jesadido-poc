/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.en;

import java.util.Arrays;
import org.jesadido.poc.core.semantics.translating.TranslationResult;
import org.jesadido.poc.core.semantics.translating.TransletParameters;
import org.jesadido.poc.core.semantics.translating.Transletor;
import org.jesadido.poc.core.syntax.tokens.TokenType;
import org.jesadido.poc.core.syntax.tree.Terminal;

public final class EnTransletors {
    
    private static final Transletor NOMINAL_TRANSLETOR = new Transletor()
            .add(Arrays.asList(TokenType.SUBSTANTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> nomQO(r, p.getTerminal(0)))
            .add(Arrays.asList(TokenType.ARTICLE, TokenType.SUBSTANTIVE_SINGULAR), (TranslationResult r, TransletParameters p) -> nomQLaQO(r, p.getTerminal(0), p.getTerminal(1)))
            ;
    
    private EnTransletors() {
        // A private utility class constructor
    }
    
    public static Transletor getNominalTransletor() {
        return NOMINAL_TRANSLETOR;
    }
    
    private static void nomQO(final TranslationResult result, final Terminal substantive) {
        result.setTranslation(EnUtils.getIndefinite(result.getTranslator(), substantive.getConcept()));
    }
    
    private static void nomQLaQO(final TranslationResult result, final Terminal article, final Terminal substantive) {
        result.setTranslation(EnUtils.getDefinite(result.getTranslator(), article.getConcept(), substantive.getConcept()));
    }
}

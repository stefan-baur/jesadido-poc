/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.de;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import org.jesadido.poc.core.semantics.translating.TranslationResult;
import org.jesadido.poc.core.semantics.translating.TranslationTarget;
import org.jesadido.poc.core.semantics.translating.TransletParameters;
import org.jesadido.poc.core.semantics.translating.Transletor;
import org.jesadido.poc.core.syntax.tokens.TokenType;
import org.jesadido.poc.core.syntax.tree.Terminal;

public final class DeTransletors {
    
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
    
    private static final Map<De, Transletor> NOMINAL_TRANSLETORS = new EnumMap(De.class);
    
    static {
        NOMINAL_TRANSLETORS.put(De.NOMINATIVE, NOMINATIVE_TRANSLETOR);
        NOMINAL_TRANSLETORS.put(De.DATIVE, DATIVE_TRANSLETOR);
        NOMINAL_TRANSLETORS.put(De.ACCUSATIVE, ACCUSATIVE_TRANSLETOR);
    }
    
    private DeTransletors() {
        // A private utility class constructor
    }
    
    public static Transletor getNominalTransletor(final De caseAttribute) {
        if (NOMINAL_TRANSLETORS.containsKey(caseAttribute)) {
            return NOMINAL_TRANSLETORS.get(caseAttribute);
        }
        return new Transletor();
    }
    
    private static void nomQO(final TranslationResult result, final Terminal substantive) {
        final De caseAttribute = De.NOMINATIVE;
        final TranslationTarget substantiveTarget = result.getTranslator().getFirstDefaultTarget(substantive.getConcept(), caseAttribute);
        result.setTranslation(DeUtils.getIndefiniteArticle(substantiveTarget, caseAttribute), substantiveTarget.getMainPhrase());
    }
    
    private static void nomQLaQO(final TranslationResult result, final Terminal article, final Terminal substantive) {
        final De caseAttribute = De.NOMINATIVE;
        final TranslationTarget substantiveTarget = result.getTranslator().getFirstDefaultTarget(substantive.getConcept(), caseAttribute);
        result.setTranslation(DeUtils.getDefiniteArticle(result.getTranslator(), caseAttribute, article.getConcept(), substantiveTarget), substantiveTarget.getMainPhrase());
    }
    
    private static void datQO(final TranslationResult result, final Terminal substantive) {
        final De caseAttribute = De.DATIVE;
        final TranslationTarget substantiveTarget = result.getTranslator().getFirstDefaultTarget(substantive.getConcept(), caseAttribute);
        result.setTranslation(DeUtils.getIndefiniteArticle(substantiveTarget, caseAttribute), substantiveTarget.getMainPhrase());
    }
    
    private static void datQLaQO(final TranslationResult result, final Terminal article, final Terminal substantive) {
        final De caseAttribute = De.DATIVE;
        final TranslationTarget substantiveTarget = result.getTranslator().getFirstDefaultTarget(substantive.getConcept(), caseAttribute);
        result.setTranslation(DeUtils.getDefiniteArticle(result.getTranslator(), caseAttribute, article.getConcept(), substantiveTarget), substantiveTarget.getMainPhrase());
    }
    
    private static void accQO(final TranslationResult result, final Terminal substantive) {
        final De caseAttribute = De.ACCUSATIVE;
        final TranslationTarget substantiveTarget = result.getTranslator().getFirstDefaultTarget(substantive.getConcept(), caseAttribute);
        result.setTranslation(DeUtils.getIndefiniteArticle(substantiveTarget, caseAttribute), substantiveTarget.getMainPhrase());
    }
    
    private static void accQLaQO(final TranslationResult result, final Terminal article, final Terminal substantive) {
        final De caseAttribute = De.ACCUSATIVE;
        final TranslationTarget substantiveTarget = result.getTranslator().getFirstDefaultTarget(substantive.getConcept(), caseAttribute);
        result.setTranslation(DeUtils.getDefiniteArticle(result.getTranslator(), caseAttribute, article.getConcept(), substantiveTarget), substantiveTarget.getMainPhrase());
    }
}

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.concepts;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import org.jesadido.poc.core.CoreUtils;
import org.jesadido.poc.core.Language;

public final class ConceptUtils {
    
    private static final Logger LOGGER = Logger.getLogger(ConceptUtils.class.getName());
    
    private ConceptUtils() {
        // A private utility class constructor.
    }
        
    /**
     * Concats the given morphemes to a typical concept phrase with upper-cased
     * morphemes.
     * @param morphemes The given morphemes.
     * @return The concept phrase.
     */
    public static final String toConceptPhrase(final List<String> morphemes) {
        return String.join("", CoreUtils.up(morphemes));
    }
    
    public static final List<String> parseToPlainTextList(final String parameterListMorpheme) {
        final List<String> result = new LinkedList<>();
        final String escaper1 = CoreUtils.escaper("1", parameterListMorpheme);
        final String escaper2 = CoreUtils.escaper("2", parameterListMorpheme);
        final String escaper3 = CoreUtils.escaper("3", parameterListMorpheme);
        final String escaper4 = CoreUtils.escaper("4", parameterListMorpheme);
        final String escapedMorpheme = parameterListMorpheme.replace("\\'", escaper1).replace("\\|", escaper2).replace("\\$", escaper3).replace("\\\\", escaper4);
        for (final String listItemPhrase : escapedMorpheme.split("\\|")) {
            final String[] snippets = listItemPhrase.split("'");
            final StringBuilder listPhraseBuilder = new StringBuilder();
            for (int i = 1; i < snippets.length; i++) {
                if (i > 1) {
                    listPhraseBuilder.append(' ');
                }
                listPhraseBuilder.append(snippets[i]);
            }
            result.add(listPhraseBuilder.toString().replace(escaper1, "'").replace(escaper2, "|").replace(escaper3, "$"));
        }
        return result;
    }
    
    public static final String toLanguageMorpheme(final Language language) {
        return String.format("/%s/", language.getCode());
    }
    
    public static final Language parseToLanguage(final String languageMorpheme) {
        for (final Language result : Language.values()) {
            if (String.format("/%s/", result.getCode()).equals(languageMorpheme)) {
                return result;
            }
        }
        LOGGER.warning(String.format("The language morpheme \"%s\" annotates no supported language.", languageMorpheme));
        return Language.JI;
    }
}

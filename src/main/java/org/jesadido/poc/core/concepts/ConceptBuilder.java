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

public final class ConceptBuilder {
    
    private static final Logger LOGGER = Logger.getLogger(ConceptBuilder.class.getName());
    
    private final List<String> morphemes;
    private final List<String> baseMorphemes;
    private final List<String> referenceMorphemes;
    private final String basePhrase;
    private final Concept referenceConcept;
    
    public ConceptBuilder(final List<String> morphemes) {
        
        this.morphemes = CoreUtils.up(morphemes);
        
        this.baseMorphemes = new LinkedList<>();
        this.referenceMorphemes = new LinkedList<>();
        boolean base = true;
        for (int i = this.morphemes.size() - 1; i >= 0; i--) {
            final String morpheme = this.morphemes.get(i);
            if (base) {
                if ("$".equals(morpheme)) {
                    base = false;
                } else {
                    this.baseMorphemes.add(0, CoreUtils.up(morpheme));
                }
            } else {
                this.referenceMorphemes.add(0, CoreUtils.up(morpheme));
            }
        }
        
        final StringBuilder basePhraseBuilder = new StringBuilder();
        this.baseMorphemes.stream().forEach(basePhraseBuilder::append);
        this.basePhrase = basePhraseBuilder.toString();
        
        this.referenceConcept = this.referenceMorphemes.isEmpty() ? null : ConceptRegistry.getInstance().getConcept(this.referenceMorphemes);
    }
    
    public final Concept buildReferenceConcept() {
        return this.referenceConcept;
    }
    
    public final List<String> buildBaseMorphemes() {
        return this.baseMorphemes;
    }
    
    public final String buildBasePhrase() {
        return this.basePhrase;
    }
    
    public final String buildFullPhrase() {
        final StringBuilder result = new StringBuilder();
        if (this.referenceConcept != null) {
            result.append(this.referenceConcept.getFullPhrase()).append("$");
        }
        result.append(this.buildBasePhrase());
        return result.toString();
    }
    
    public final ConceptProperties buildProperties() {
        final ConceptProperties result = new ConceptProperties();
        this.baseMorphemes.stream().filter(morpheme -> morpheme.startsWith("/")).forEach(morpheme -> result.setParameterLanguage(this.parseLanguage(morpheme)));
        this.baseMorphemes.stream().filter(morpheme -> morpheme.startsWith("'")).forEach(morpheme -> result.setParameterPlainList(this.parseParameterList(morpheme)));
        if (result.hasParameter()) {
            result.setParameterType(ConceptParameterType.get(this.basePhrase));
        }
        result.setTermination(ConceptTermination.get(this.basePhrase));
        if (result.getTermination() == ConceptTermination.UNKNOWN) {
            LOGGER.warning(String.format("The phrase \"%s\" has no supported concept termination.", this.basePhrase));
        }
        result.setPlural(result.getTermination().isOneOf(
                ConceptTermination.O_J,
                ConceptTermination.A_J,
                ConceptTermination.E_J,
                ConceptTermination.NI,
                ConceptTermination.VI,
                ConceptTermination.ILI));
        return result;
    }
    
    private List<String> parseParameterList(final String parameterListMorpheme) {
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
    
    private Language parseLanguage(final String languageMorpheme) {
        for (final Language result : Language.values()) {
            if (String.format("/%s/", result.getCode()).equals(languageMorpheme)) {
                return result;
            }
        }
        LOGGER.warning(String.format("The language morpheme \"%s\" annotates no supported language.", languageMorpheme));
        return Language.JI;
    }
}

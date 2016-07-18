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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        
        this.morphemes = new LinkedList<>();
        morphemes.stream().forEach(morpheme -> this.morphemes.add(CoreUtils.up(morpheme)));
        
        this.baseMorphemes = new LinkedList<>();
        this.referenceMorphemes = new LinkedList<>();
        boolean base = true;
        for (int i = this.morphemes.size() - 1; i >= 0; i--) {
            String morpheme = this.morphemes.get(i);
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
        
        this.referenceConcept = this.referenceMorphemes.isEmpty() ? null : new Concept(new ConceptBuilder(this.referenceMorphemes));
    }
    
    public Concept buildReferenceConcept() {
        return this.referenceConcept;
    }
    
    public List<String> buildBaseMorphemes() {
        return this.baseMorphemes;
    }
    
    public String buildBasePhrase() {
        return this.basePhrase;
    }
    
    public String buildFullPhrase() {
        final StringBuilder result = new StringBuilder();
        if (this.referenceConcept != null) {
            result.append(this.referenceConcept.getFullPhrase()).append("$");
        }
        result.append(this.buildBasePhrase());
        return result.toString();
    }
    
    public ConceptProperties buildProperties() {
        ConceptProperties result = new ConceptProperties();
        this.baseMorphemes.stream().filter(morpheme -> morpheme.startsWith("/")).forEach(morpheme -> result.setParameterLanguage(this.buildLanguage(morpheme)));
        this.baseMorphemes.stream().filter(morpheme -> morpheme.startsWith("'")).forEach(morpheme -> result.setParameterPlainList(this.buildParameterPlainList(morpheme)));
        if (result.hasParameter()) {
            result.setParameterType(this.buildConceptParameterType(this.basePhrase));
        }
        result.setTermination(this.buildConceptTermination(this.basePhrase));
        if (this.basePhrase.endsWith("J")) {
            result.setPlural(true);
        } else if (result.getTermination().isOneOf(ConceptTermination.NI, ConceptTermination.VI, ConceptTermination.ILI)) {
            result.setPlural(true);
        }
        return result;
    }
    
    private List<String> buildParameterPlainList(String morpheme) {
        final String escaper1 = CoreUtils.escaper("!§$%1", morpheme);
        final String escaper2 = CoreUtils.escaper("!§$%2", morpheme);
        final String escaper3 = CoreUtils.escaper("!§$%3", morpheme);
        final String[] snippets = morpheme.replace("\\'", escaper1).replace("\\|", escaper2).replace("\\\\", escaper3).split("'");
        StringBuilder listPhraseBuilder = new StringBuilder();
        for (int i = 1; i < snippets.length; i++) {
            if (i > 1) {
                listPhraseBuilder.append(' ');
            }
            listPhraseBuilder.append(snippets[i]);
        }
        String listPhrase = listPhraseBuilder.toString().replace(escaper1, "'").replace(escaper3, "\\");
        List<String> result = new LinkedList<>();
        for (String listItemPhrase : listPhrase.split("\\|")) {
            result.add(listItemPhrase.replace(escaper3, "|"));
        }
        return result;
    }
    
    private Language buildLanguage(String morpheme) {
        Matcher languageMatcher = Pattern.compile("^/(\\w\\w)/").matcher(morpheme);
        if (languageMatcher.find()) {
            String languageString = languageMatcher.group(1);
            for (Language result : Language.values()) {
                if (result.getCode().equals(languageString)) {
                    return result;
                }
            }
        }
        LOGGER.warning(String.format("The language morpheme \"%s\" annotates no supported language.", morpheme));
        return Language.JI;
    }
    
    private ConceptParameterType buildConceptParameterType(String phrase) {
        for (ConceptParameterType conceptParameterType : ConceptParameterType.values()) {
            for (String ending : conceptParameterType.getConceptEndings()) {
                if (phrase.endsWith(ending)) {
                    return conceptParameterType;
                }
            }
        }
        return ConceptParameterType.NONE;
    }
    
    private ConceptTermination buildConceptTermination(String phrase) {
        for (ConceptTermination conceptTermination : ConceptTermination.values()) {
            String termination = conceptTermination.getTerminationPhrase();
            if (termination != null && phrase.endsWith(termination)) {
                return conceptTermination;
            }
        }
        LOGGER.warning(String.format("The phrase \"%s\" has no supported concept termination.", phrase));
        return ConceptTermination.UNKNOWN;
    }
}

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
import java.util.regex.Pattern;
import org.jesadido.poc.core.CoreUtils;
import org.jesadido.poc.core.Language;

public final class ConceptBuilder {
    
    private final List<String> morphemes;
    private final List<String> baseMorphemes;
    private final List<String> referenceMorphemes;
    private final String basePhrase;
    private final Concept reference;
    
    public ConceptBuilder(final List<String> morphemes) {
        
        this.morphemes = new LinkedList<>();
        morphemes.stream().forEach(morpheme -> this.morphemes.add(CoreUtils.up(morpheme)));
        
        this.baseMorphemes = new LinkedList<>();
        this.referenceMorphemes = new LinkedList<>();
        boolean base = true;
        for (int i = this.morphemes.size() - 1; i >= 0; i--) {
            String morpheme = this.morphemes.get(i);
            if (base) {
                if (ConceptSymbols.MORPHEME_REFERENCE_INDICATOR.equals(morpheme)) {
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
        
        this.reference = this.referenceMorphemes.isEmpty() ? null : new Concept(new ConceptBuilder(this.referenceMorphemes));
    }
    
    public Concept buildReference() {
        return this.reference;
    }
    
    public List<String> buildBaseMorphemes() {
        return this.baseMorphemes;
    }
    
    public String buildBasePhrase() {
        return this.basePhrase;
    }
    
    public String buildFullPhrase() {
        final StringBuilder result = new StringBuilder();
        if (this.reference != null) {
            result.append(this.reference.getFullPhrase()).append(ConceptSymbols.MORPHEME_REFERENCE_INDICATOR);
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
        if (this.basePhrase.endsWith(ConceptSymbols.MORPHEME_PLURAL)) {
            result.setPlural(true);
        }
        return result;
    }
    
    private List<String> buildParameterPlainList(String morpheme) {
        final String escape1 = "!§$%1";
        final String escape2 = "!§$%2";
        final String escape3 = "!§$%3";
        final String[] snippets = morpheme.replace("\\'", escape1).replace("\\|", escape2).replace("\\\\", escape3).split("'");
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < snippets.length - 1; i++) {
            if (i > 1) {
                result.append(' ');
            }
            result.append(snippets[i]);
        }
        String n = result.toString().replace(escape1, "'").replace(escape3, "\\");
        
        String[] sdf = n.split("\\|");
        List<String> r = new LinkedList<>();
        for (String sd : sdf) {
            r.add(sd.replace(escape3, "|"));
        }
        return r;
    }
    
    private Language buildLanguage(String morpheme) {
        String languageString = Pattern.compile("^/([a-z]+)/").matcher(morpheme).group(1);
        for (Language result : Language.values()) {
            if (result.getCode().equals(languageString)) {
                return result;
            }
        }
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
        return ConceptTermination.NONE;
    }
}

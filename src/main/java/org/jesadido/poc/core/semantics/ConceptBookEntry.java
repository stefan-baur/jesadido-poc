/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics;

import org.jesadido.poc.core.semantics.translating.TranslationTarget;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.scripting.Src;

public class ConceptBookEntry {
    
    private final String conceptPhrase;
    private final List<Part> requiredParts = new LinkedList<>();
    private final List<Part> excludedParts = new LinkedList<>();
    private final Map<Language, List<TranslationTarget>> defaultTargets = new EnumMap<>(Language.class);
    
    public ConceptBookEntry(final String conceptPhrase) {
        this.conceptPhrase = conceptPhrase;
    }
    
    public String getConceptPhrase() {
        return this.conceptPhrase;
    }
    
    public ConceptBookEntry addRequiredParts(final Part ... parts) {
        for (final Part part : parts) {
            this.requiredParts.remove(part);
            this.requiredParts.add(part);
        }
        return this;
    }
    
    public List<Part> getRequiredParts() {
        return this.requiredParts;
    }
    
    public List<Class> getRequiredPartClasses() {
        final List<Class> result = new LinkedList<>();
        this.requiredParts.stream().forEach(part -> result.add(part.getPartClass()));
        return result;
    }
    
    public ConceptBookEntry addExcludedParts(final Part ... parts) {
        for (final Part part : parts) {
            this.excludedParts.remove(part);
            this.excludedParts.add(part);
        }
        return this;
    }
    
    public List<Part> getExcludedParts() {
        return this.excludedParts;
    }
    
    public List<Class> getExcludedPartClasses() {
        final List<Class> result = new LinkedList<>();
        this.excludedParts.stream().forEach(part -> result.add(part.getPartClass()));
        return result;
    }
    
    public ConceptBookEntry addDefaultTargets(final TranslationTarget ... targets) {
        for (final TranslationTarget target : targets) {
            if (!this.defaultTargets.containsKey(target.getLanguage())) {
                this.defaultTargets.put(target.getLanguage(), new LinkedList<>());
            }
            this.defaultTargets.get(target.getLanguage()).add(target);
        }
        return this;
    }
    
    public List<TranslationTarget> getDefaultTargets(final Language language) {
        if (!this.defaultTargets.containsKey(language)) {
            this.defaultTargets.put(language, new LinkedList<>());
        }
        return this.defaultTargets.get(language);
    }
    
    public List<TranslationTarget> getDefaultTargets(final Language language, final Object ... attributes) {
        final List<TranslationTarget> result = new LinkedList<>();
        final List<Object> attributeList = new LinkedList<>();
        for (Object attribute : attributes) {
            if (attribute != null) {
                attributeList.add(attribute);
            }
        }
        this.getDefaultTargets(language).stream().filter(target -> target.getAttributes().containsAll(attributeList)).forEach(result::add);
        return result;
    }
    
    public Src toPlot() {
        final Src result = new Src(Integer.MAX_VALUE, " ", "   ", "\r\n")
                .line("Concept-Phrase: \"%s\"", this.conceptPhrase)
                .line("Required Parts: %s", this.requiredParts.toString())
                .line("Excluded Parts: %s", this.excludedParts.toString())
                .line("Default Targets:")
                .inc()
                ;
        for (final Language language : new Language[] { Language.DE, Language.EN, Language.EO, Language.ES, Language.FR }) {
            result.line("%s: %s", language, this.getDefaultTargets(language).toString());
        }
        result
                .dec()
                ;
        return result;
    }
    
    @Override
    public String toString() {
        return this.toPlot().toString();
    }
}

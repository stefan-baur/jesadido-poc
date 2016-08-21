/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics;

import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.jesadido.poc.core.Language;

public class ConceptBookEntry {
    
    private final String conceptPhrase;
    private final Map<Language, List<TranslationTarget>> defaultTargets = new EnumMap<>(Language.class);
    
    public ConceptBookEntry(final String conceptPhrase) {
        this.conceptPhrase = conceptPhrase;
    }
    
    public String getConceptPhrase() {
        return this.conceptPhrase;
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
}

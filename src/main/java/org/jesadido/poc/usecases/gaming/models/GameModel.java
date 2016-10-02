/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.models;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.semantics.ConceptBook;

public class GameModel {
    
    private static final Language FALLBACK_LANGUAGE = Language.EO;
    
    private final String key;
    private final ConceptBook conceptBook;
    
    private final List<Language> supportedLanguages = new LinkedList<>();
    private final List<Language> selectedLanguages = new LinkedList<>();
    private String title = "TestO ..";
    
    public GameModel(final String key, final ConceptBook conceptBook) {
        this.key = key;
        this.conceptBook = conceptBook;
        this.supportedLanguages.add(FALLBACK_LANGUAGE);
        this.selectedLanguages.add(FALLBACK_LANGUAGE);
    }
    
    public String getKey() {
        return this.key;
    }
    
    public ConceptBook getConceptBook() {
        return this.conceptBook;
    }
    
    public List<Language> getSupportedLanguages() {
        return this.supportedLanguages;
    }
    
    public GameModel initSupportedLanguages(final Language ... languages) {
        this.supportedLanguages.clear();
        this.supportedLanguages.addAll(Arrays.asList(languages));
        if (this.supportedLanguages.isEmpty()) {
            this.supportedLanguages.add(FALLBACK_LANGUAGE);
        }
        return this;
    }
    
    public List<Language> getSelectedLanguages() {
        return this.selectedLanguages;
    }
    
    public GameModel initSelectedLanguages(final Language ... languages) {
        this.selectedLanguages.clear();
        for (final Language language : languages) {
            if ((this.supportedLanguages.contains(language)) && (!this.selectedLanguages.contains(language))) {
                this.selectedLanguages.add(language);
            }
        }
        if (this.selectedLanguages.isEmpty()) {
            this.selectedLanguages.add(this.supportedLanguages.get(0));
        }
        return this;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public GameModel initTitle(final String title) {
        this.title = title;
        return this;
    }
}

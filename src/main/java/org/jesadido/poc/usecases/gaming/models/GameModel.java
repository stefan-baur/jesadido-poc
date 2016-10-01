/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.models;

import java.util.Arrays;
import java.util.List;
import org.jesadido.poc.core.Language;

public class GameModel {
    
    private static final Language FALLBACK_LANGUAGE = Language.EO;
    
    private final String key;
    
    private List<Language> supportedLanguages = Arrays.asList(FALLBACK_LANGUAGE);
    private List<Language> defaultLanguages = Arrays.asList(FALLBACK_LANGUAGE);
    private String title = "TestO ..";
    
    public GameModel(final String key) {
        this.key = key;
    }
    
    public String getKey() {
        return this.key;
    }
    
    public List<Language> getSupportedLanguages() {
        return this.supportedLanguages;
    }
    
    public GameModel initSupportedLanguages(final Language ... languages) {
        this.supportedLanguages.clear();
        this.supportedLanguages = Arrays.asList(languages);
        if (this.supportedLanguages.isEmpty()) {
            this.supportedLanguages.add(FALLBACK_LANGUAGE);
        }
        return this;
    }
    
    public List<Language> getDefaultLanguages() {
        return this.defaultLanguages;
    }
    
    public GameModel initDefaultLanguages(final Language ... languages) {
        this.defaultLanguages.clear();
        for (final Language language : languages) {
            if ((this.supportedLanguages.contains(language)) && (!this.defaultLanguages.contains(language))) {
                this.defaultLanguages.add(language);
            }
        }
        if (this.defaultLanguages.isEmpty()) {
            this.defaultLanguages.add(this.supportedLanguages.get(0));
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

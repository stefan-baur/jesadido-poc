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
    
    private final String key;
    
    private List<Language> supportedLanguages = Arrays.asList(Language.EO);
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
        this.supportedLanguages = Arrays.asList(languages);
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

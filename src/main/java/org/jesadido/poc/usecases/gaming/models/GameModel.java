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
import org.jesadido.poc.usecases.gaming.graphics.Rgbo;
import org.jesadido.poc.usecases.gaming.graphics.RgboPalette;

public class GameModel {
    
    private static final Language FALLBACK_LANGUAGE = Language.EO;
    
    private final String key;
    private ConceptBook gameConceptBook = new ConceptBook("empty-book");
    private final List<Language> supportedLanguages = new LinkedList<>();
    private final List<Language> selectedLanguages = new LinkedList<>();
    private RgboPalette rgboPalette = new RgboPalette("empty-rgbos");
    private Phrase title = Phrase.DEFAULT;
    
    public GameModel(final String key) {
        this.key = key;
        this.supportedLanguages.add(FALLBACK_LANGUAGE);
        this.selectedLanguages.add(FALLBACK_LANGUAGE);
    }
    
    public String getKey() {
        return this.key;
    }
    
    public ConceptBook getGameConceptBook() {
        return this.gameConceptBook;
    }
    
    public GameModel initGameConceptBook(final ConceptBook gameConceptBook) {
        this.gameConceptBook = gameConceptBook;
        return this;
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
    
    public RgboPalette getRgboPalette() {
        return this.rgboPalette;
    }
    
    public GameModel initRgboPalette(final RgboPalette rgboPalette) {
        this.rgboPalette = rgboPalette;
        return this;
    }
    
    public Rgbo getRgbo(final String rgboKey) {
        return this.rgboPalette.get(rgboKey);
    }
    
    public Phrase getTitle() {
        return this.title;
    }
    
    public GameModel initTitle(final String titleSource) {
        this.title = Phrase.create(titleSource);
        return this;
    }
}

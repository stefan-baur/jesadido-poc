/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.generators.text;

import org.jesadido.poc.JesadidoPoc;
import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.scripting.Src;
import org.jesadido.poc.core.semantics.translating.TranslatorFactory;
import org.jesadido.poc.usecases.gaming.models.GameModel;

public class TextGameGenerator {
    
    private final GameModel gameModel;
    
    public TextGameGenerator(final GameModel gameModel) {
        this.gameModel = gameModel;
    }
    
    public GameModel getGameModel() {
        return this.gameModel;
    }
    
    public Src generate() {
        return new Src(Integer.MAX_VALUE, " ", "   ", "\r\n")
                .add(this.generateProperty("GameModel"))
                .inc()
                .add(this.generateStringProperty("Key", this.gameModel.getKey()))
                .add(this.generateStringProperty("Game-Concept-Book", this.gameModel.getGameConceptBook().getKey()))
                .add(this.generateProperty("Supported Languages", this.gameModel.getSupportedLanguages().toString()))
                .add(this.generateProperty("Selected Languages", this.gameModel.getSelectedLanguages().toString()))
                .add(this.generateStringProperty("Rgbos-Key", this.gameModel.getRgboPalette().getKey()))
                .add(this.generateSourceProperty("Title", this.gameModel.getTitle().getSource()))
                .dec()
                ;
    }
    
    private Src generateProperty(final String name, final String value) {
        return new Src()
                .line("%s: %s", name, value)
                ;
    }
    
    private Src generateProperty(final String name) {
        return new Src()
                .add(this.generateProperty(name, ""))
                ;
    }
    
    private Src generateStringProperty(final String name, final String value) {
        return this.generateProperty(name, String.format("\"%s\"", value.replace("\"", "\\\"")));
    }
    
    private Src generateTranslation(final Language language, final String source) {
        final String translation = TranslatorFactory.createTranslator(language, this.gameModel.getGameConceptBook()).translate(source).getTranslation();
        return new Src().line("[%s] %s", language, translation);
    }
    
    private Src generateSourceProperty(final String name, final String source) {
        final Src result = new Src()
                .add(this.generateProperty(name, String.format("(ji) %s", source)))
                .inc()
                ;
        this.gameModel.getSupportedLanguages().stream().forEach(supportedLanguage -> result.add(this.generateTranslation(supportedLanguage, source)));
        result
                .dec()
                ;
        return result;
    }
    
    public static void main(final String[] arguments) {
        JesadidoPoc.run(arguments);
    }
}

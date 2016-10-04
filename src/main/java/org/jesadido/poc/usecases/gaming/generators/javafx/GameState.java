/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.generators.javafx;

import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.Language;
import org.jesadido.poc.usecases.gaming.models.GameModel;

public class GameState {
    
    private final GameModel gameModel;
    
    private final List<Language> selectableLanguages = new LinkedList<>();
    private Language mainLanguage = Language.EO;
    private final List<Language> semiLanguages = new LinkedList<>();
    
    public GameState(final GameModel gameModel) {
        this.gameModel = gameModel;
        this.selectableLanguages.addAll(this.gameModel.getSupportedLanguages());
        this.mainLanguage = this.gameModel.getSelectedLanguages().get(0);
        this.semiLanguages.addAll(this.gameModel.getSelectedLanguages().subList(1, this.gameModel.getSelectedLanguages().size()));
    }
    
    public GameModel getGameModel() {
        return this.gameModel;
    }
    
    public List<Language> getSelectableLanguages() {
        return this.selectableLanguages;
    }
    
    public Language getMainLanguage() {
        return this.mainLanguage;
    }
    
    public List<Language> getSemiLanguages() {
        return this.semiLanguages;
    }
}

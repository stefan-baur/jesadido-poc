/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.models;

public class GameModel {
    
    private final String key;
    private String title = null;
    
    public GameModel(final String key) {
        this.key = key;
    }
    
    public String getKey() {
        return this.key;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public GameModel initTitle(final String title) {
        this.title = title;
        return this;
    }
}

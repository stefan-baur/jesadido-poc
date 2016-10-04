/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.models;

import java.util.LinkedList;
import java.util.List;

public class Phrase {
    
    public static final Phrase DEFAULT = new Phrase("TestO ..");
    
    private static final List<Phrase> PHRASES = new LinkedList<>();
    
    private static int phraseCounter = 0;
    private final int id;
    private final String source;
    
    private Phrase(final String source) {
        this.id = phraseCounter++;
        this.source = source;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getSource() {
        return this.source;
    }
    
    public static final List<Phrase> getPhrases() {
        return PHRASES;
    }
    
    public static Phrase create(final String source) {
        final Phrase result = new Phrase(source);
        PHRASES.add(result);
        return result;
    }
}

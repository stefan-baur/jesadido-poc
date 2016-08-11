/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics;

import java.util.LinkedHashMap;
import java.util.Map;

public class ConceptBook {
    
    private final Map<String, ConceptBookEntry> book = new LinkedHashMap<>();
    
    public boolean add(final ConceptBookEntry entry) {
        final String conceptPhrase = entry.getConceptPhrase();
        if (this.book.containsKey(conceptPhrase)) {
            return this.book.get(conceptPhrase).expand(entry);
        }
        this.book.put(conceptPhrase, entry);
        return true;
    }
}

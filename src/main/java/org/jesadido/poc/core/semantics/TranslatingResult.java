/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics;

import java.util.LinkedList;
import java.util.List;

public class TranslatingResult {
    
    private final List<String> translations = new LinkedList<>();
    
    public List<String> getTranslations() {
        return this.translations;
    }
}

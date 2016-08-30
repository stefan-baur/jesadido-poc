/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating;

import java.util.Arrays;
import java.util.List;
import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.StringUtils;

public class TranslationTarget<A> {
    
    private final Language language;
    private final String masterPhrase;
    private final List<A> attributes;
    
    public TranslationTarget(final Language language, final String phrase, final A ... attributes) {
        this.language = language;
        this.masterPhrase = phrase;
        this.attributes = Arrays.asList(attributes);
    }
    
    public Language getLanguage() {
        return this.language;
    }
    
    public String getPhrase() {
        return this.masterPhrase;
    }
    
    public List<A> getAttributes() {
        return this.attributes;
    }
    
    @Override
    public String toString() {
        return String.format("%s (%s)", this.masterPhrase, StringUtils.join(", ", this.attributes));
    }
}

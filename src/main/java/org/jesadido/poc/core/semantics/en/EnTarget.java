/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.en;

import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.semantics.TranslationTarget;

public class EnTarget extends TranslationTarget<En> {
    
    public EnTarget(final String phrase, final En ... attributes) {
        super(Language.EN, phrase, attributes);
    }
}

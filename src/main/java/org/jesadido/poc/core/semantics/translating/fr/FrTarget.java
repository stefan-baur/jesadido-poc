/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.fr;

import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.semantics.translating.TranslationTarget;

public class FrTarget extends TranslationTarget<Fr> {
    
    public FrTarget(final String phrase, final Fr ... attributes) {
        super(Language.FR, phrase, attributes);
    }
}

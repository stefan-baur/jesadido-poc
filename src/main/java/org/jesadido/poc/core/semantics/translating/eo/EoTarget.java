/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.eo;

import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.semantics.translating.TranslationTarget;

public class EoTarget extends TranslationTarget<Eo> {
    
    public EoTarget(final String phrase, final Eo ... attributes) {
        super(Language.EO, phrase, attributes);
    }
}

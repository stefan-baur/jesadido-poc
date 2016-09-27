/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating;

import java.util.List;
import org.jesadido.poc.core.syntax.tree.Terminal;

@FunctionalInterface
public interface Translet {
    
    void translate(final TranslationResult result, final List<Terminal> terminals);
}

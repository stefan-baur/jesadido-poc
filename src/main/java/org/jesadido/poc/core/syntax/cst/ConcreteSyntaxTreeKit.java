/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.cst;

import java.util.List;

public interface ConcreteSyntaxTreeKit<T, N> {
    
    N createSentence(List<T> openers, List<N> parts, List<T> closers);
    N createSentenceItem(List<T> openers, List<N> parts, List<T> closers);
    N createSentenceItemConjunction(T separator);
}

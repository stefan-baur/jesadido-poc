/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.nodes;

import org.jesadido.poc.core.syntax.nodes.composites.SentenceMeatNode;
import org.jesadido.poc.core.syntax.nodes.composites.SentenceNode;
import org.jesadido.poc.core.syntax.nodes.leaves.SentenceMeatConjunctionNode;

public interface Visitor<R, A> {
    
    R visit(SentenceNode node, A argument);
    R visit(SentenceMeatNode node, A argument);
    R visit(SentenceMeatConjunctionNode node, A argument);
}

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.nodes;

import org.jesadido.poc.core.syntax.nodes.composites.PrepositionalPartDom;
import org.jesadido.poc.core.syntax.nodes.composites.PrepositionalPartFin;
import org.jesadido.poc.core.syntax.nodes.composites.SentenceMeat;
import org.jesadido.poc.core.syntax.nodes.composites.Sentence;
import org.jesadido.poc.core.syntax.nodes.composites.PrepositionalPartSu;
import org.jesadido.poc.core.syntax.nodes.leaves.SentenceMeatConjunction;
import org.jesadido.poc.core.syntax.nodes.leaves.Trouble;

public interface Visitor<R, A> {
    
    R visit(Sentence node, A argument);
    R visit(SentenceMeat node, A argument);
    R visit(SentenceMeatConjunction node, A argument);
    R visit(PrepositionalPartSu node, A argument);
    R visit(PrepositionalPartDom node, A argument);
    R visit(PrepositionalPartFin node, A argument);
    
    R visit(Trouble node, A argument);
}

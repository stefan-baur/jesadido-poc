/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.nodes;

import org.jesadido.poc.core.syntax.nodes.sentence.Sentence;
import org.jesadido.poc.core.syntax.nodes.sentence.SentenceMeat;
import org.jesadido.poc.core.syntax.nodes.sentence.SentenceMeatPartDom;
import org.jesadido.poc.core.syntax.nodes.sentence.SentenceMeatPartFin;
import org.jesadido.poc.core.syntax.nodes.sentence.SentenceMeatPartSu;
import org.jesadido.poc.core.syntax.nodes.sentence.SentenceMeatConjunction;
import org.jesadido.poc.core.syntax.nodes.common.TroubleNode;

public interface Visitor<R, A> {
    
    R visit(Sentence node, A argument);
    R visit(SentenceMeat node, A argument);
    R visit(SentenceMeatConjunction node, A argument);
    R visit(SentenceMeatPartSu node, A argument);
    R visit(SentenceMeatPartDom node, A argument);
    R visit(SentenceMeatPartFin node, A argument);
    
    R visit(TroubleNode node, A argument);
}

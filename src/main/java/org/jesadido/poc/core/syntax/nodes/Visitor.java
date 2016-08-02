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
import org.jesadido.poc.core.syntax.nodes.sentence.PartDom;
import org.jesadido.poc.core.syntax.nodes.sentence.PartFin;
import org.jesadido.poc.core.syntax.nodes.sentence.PartSu;
import org.jesadido.poc.core.syntax.nodes.sentence.SentenceMeatConjunction;
import org.jesadido.poc.core.syntax.nodes.common.TroubleNode;
import org.jesadido.poc.core.syntax.nodes.sentence.VerbSelection;

public interface Visitor<R, A> {
    
    R visit(Sentence node, A argument);
    R visit(SentenceMeat node, A argument);
    R visit(SentenceMeatConjunction node, A argument);
    
    R visit(PartSu node, A argument);
    R visit(PartDom node, A argument);
    R visit(PartFin node, A argument);
    
    R visit(VerbSelection node, A argument);
    
    R visit(TroubleNode node, A argument);
}

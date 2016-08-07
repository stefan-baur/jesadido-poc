/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tree;

import org.jesadido.poc.core.syntax.tree.sentence.NominalPhrase;
import org.jesadido.poc.core.syntax.tree.sentence.NominalSelection;
import org.jesadido.poc.core.syntax.tree.sentence.Sentence;
import org.jesadido.poc.core.syntax.tree.sentence.SentenceMeat;
import org.jesadido.poc.core.syntax.tree.sentence.PartDom;
import org.jesadido.poc.core.syntax.tree.sentence.PartFin;
import org.jesadido.poc.core.syntax.tree.sentence.PartSu;
import org.jesadido.poc.core.syntax.tree.sentence.SentenceMeatConjunction;
import org.jesadido.poc.core.syntax.tree.sentence.VerbalSelection;

public interface Visitor<R, A> {
    
    R visit(Sentence node, A argument);
    R visit(SentenceMeat node, A argument);
    R visit(SentenceMeatConjunction node, A argument);
    
    R visit(PartSu node, A argument);
    R visit(PartDom node, A argument);
    R visit(PartFin node, A argument);
    
    R visit(NominalSelection node, A argument);
    R visit(NominalPhrase node, A argument);
    
    R visit(VerbalSelection node, A argument);
    
    R visit(TroubleNode node, A argument);
}

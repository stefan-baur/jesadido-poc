/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax;

import java.util.List;
import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.syntax.nodes.Node;

public interface SyntaxTreeFactory {
    
    Node createSentence(List<Node> meats, Concept terminator);
    Node createSentenceMeat(Node conjunction, Concept opener, List<Node> parts, Concept closer);
    Node createSentenceMeatConjunction(Concept conjunction);
    
    Node createSentenceMeatPartSu(Concept preposition, Concept opener, Node nominalSelection, Concept closer);
    Node createSentenceMeatPartDom(Concept preposition, Concept opener, Node verbSelection, Concept closer);
    Node createSentenceMeatPartFin(Concept preposition, Concept opener, Node nominalSelection, Concept closer);
    
    Node createTrouble(String message);
}

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax;

import java.util.List;
import org.jesadido.poc.core.syntax.nodes.Node;
import org.jesadido.poc.core.syntax.tokens.Token;

public interface SyntaxTreeFactory {
    
    Node createSentence(List<Node> meats, Token terminator);
    Node createSentenceMeat(Node conjunction, Token opener, List<Node> parts, Token closer);
    Node createSentenceMeatConjunction(Token conjunction);
    
    Node createPartSu(Token preposition, Token opener, Node nominalSelection, Token closer);
    Node createPartDom(Token preposition, Token opener, Node verbalSelection, Token closer);
    Node createPartFin(Token preposition, Token opener, Node nominalSelection, Token closer);
    
    Node createNominalSelection(Token substantive);
    Node createVerbalSelection(Token verb);
    
    Node createTrouble(String message);
}

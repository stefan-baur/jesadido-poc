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
    
    Node createSentence(final List<Node> meats, final Concept terminator);
    Node createSentenceMeat(final Concept opener, final List<Node> parts, final Concept closer);
    Node createSentenceMeatConjunction(final Concept separator);
    Node createPrepositionalPartSu(final Concept preposition, final Concept opener, final Node nominalSelection, final Concept closer);
    Node createPrepositionalPartDom(final Concept preposition, final Concept opener, final Node verbSelection, final Concept closer);
    Node createPrepositionalPartFin(final Concept preposition, final Concept opener, final Node nominalSelection, final Concept closer);
    Node createTrouble(final String message);
}

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax;

import org.jesadido.poc.core.syntax.nodes.Node;
import java.util.List;
import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.syntax.nodes.composites.PredicatePartNode;
import org.jesadido.poc.core.syntax.nodes.composites.SentenceMeatNode;
import org.jesadido.poc.core.syntax.nodes.composites.SentenceNode;
import org.jesadido.poc.core.syntax.nodes.composites.SubjectPartNode;
import org.jesadido.poc.core.syntax.nodes.leaves.SentenceMeatConjunctionNode;

public class SyntaxTreeFactory {
    
    public Node createSentence(final List<Node> meats, final Concept terminator) {
        return new SentenceNode()
                .addChildren(meats)
                .addCloser(terminator, ".");
    }
    
    public Node createSentenceMeat(final Concept open, final List<Node> parts, final Concept close) {
        return new SentenceMeatNode()
                .addOpener(open, "{")
                .addChildren(parts)
                .addCloser(close, "}");
    }
    
    public Node createSentenceMeatConjunction(final Concept separator) {
        return new SentenceMeatConjunctionNode()
                .addTerminal(separator, "Kaj");
    }
    
    public Node createSubjectPart(final Concept preposition, final Concept open, final Node nominalSelection, final Concept close) {
        return new SubjectPartNode()
                .addOpener(preposition, "Su")
                .addOpener(open, "(")
                .addChild(nominalSelection)
                .addCloser(close, ")");
    }
    
    public Node createPredicatePart(final Concept preposition, final Concept open, final Node verbSelection, final Concept close) {
        return new PredicatePartNode()
                .addOpener(preposition, "Dom")
                .addOpener(open, "(")
                .addChild(verbSelection)
                .addCloser(close, ")");
    }
}

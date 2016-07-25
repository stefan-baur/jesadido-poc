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
import org.jesadido.poc.core.syntax.nodes.composites.SentenceMeatNode;
import org.jesadido.poc.core.syntax.nodes.composites.SentenceNode;
import org.jesadido.poc.core.syntax.nodes.leaves.SentenceMeatConjunctionNode;

public class SyntaxTreeKit {
    
    public Node createSentence(final List<Node> meets, final Concept terminator) {
        return new SentenceNode()
                .addChildren(meets)
                .addCloser(terminator, ".");
    }
    
    public Node createSentenceMeat(final Concept open, final List<Node> parts, final Concept close) {
        return new SentenceMeatNode()
                .addOpener(open, "{")
                .addChildren(parts)
                .addCloser(close, "}");
    }
    
    public Node createSentenceMeatConjunction(Concept separator) {
        return new SentenceMeatConjunctionNode()
                .addTerminal(separator, "Kaj");
    }
}

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
import org.jesadido.poc.core.syntax.nodes.composites.PrepositionalPartDom;
import org.jesadido.poc.core.syntax.nodes.composites.SentenceMeat;
import org.jesadido.poc.core.syntax.nodes.composites.Sentence;
import org.jesadido.poc.core.syntax.nodes.composites.PrepositionalPartSu;
import org.jesadido.poc.core.syntax.nodes.leaves.SentenceMeatConjunction;

public class SyntaxTreeFactory {
    
    public Node createSentence(final List<Node> meats, final Concept terminator) {
        return new Sentence()
                .addChildren(meats)
                .addCloser(terminator, ".");
    }
    
    public Node createSentenceMeat(final Concept open, final List<Node> parts, final Concept close) {
        return new SentenceMeat()
                .addOpener(open, "{")
                .addChildren(parts)
                .addCloser(close, "}");
    }
    
    public Node createSentenceMeatConjunction(final Concept separator) {
        return new SentenceMeatConjunction()
                .addTerminal(separator, "Kaj");
    }
    
    public Node createPrepositionalPartSu(final Concept preposition, final Concept open, final Node nominalSelection, final Concept close) {
        return new PrepositionalPartSu()
                .addOpener(preposition, "Su")
                .addOpener(open, "(")
                .addChild(nominalSelection)
                .addCloser(close, ")");
    }
    
    public Node createPrepositionalPartDom(final Concept preposition, final Concept open, final Node verbSelection, final Concept close) {
        return new PrepositionalPartDom()
                .addOpener(preposition, "Dom")
                .addOpener(open, "(")
                .addChild(verbSelection)
                .addCloser(close, ")");
    }
    
    public Node createPrepositionalPartFin(final Concept preposition, final Concept open, final Node nominalSelection, final Concept close) {
        return new PrepositionalPartSu()
                .addOpener(preposition, "Fin")
                .addOpener(open, "(")
                .addChild(nominalSelection)
                .addCloser(close, ")");
    }
}

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
import org.jesadido.poc.core.syntax.nodes.composites.PrepositionalPartDom;
import org.jesadido.poc.core.syntax.nodes.composites.PrepositionalPartFin;
import org.jesadido.poc.core.syntax.nodes.composites.SentenceMeat;
import org.jesadido.poc.core.syntax.nodes.composites.Sentence;
import org.jesadido.poc.core.syntax.nodes.composites.PrepositionalPartSu;
import org.jesadido.poc.core.syntax.nodes.leaves.SentenceMeatConjunction;

public class SyntaxTreeFactory {
    
    public Node createSentence(final List<Node> meats, final Terminal terminator) {
        return new Sentence(terminator)
                .addChildren(meats);
    }
    
    public Node createSentenceMeat(final Terminal opener, final List<Node> parts, final Terminal closer) {
        return new SentenceMeat(opener, closer)
                .addChildren(parts);
    }
    
    public Node createSentenceMeatConjunction(final Terminal separator) {
        return new SentenceMeatConjunction(separator);
    }
    
    public Node createPrepositionalPartSu(final Terminal preposition, final Terminal opener, final Node nominalSelection, final Terminal closer) {
        return new PrepositionalPartSu(preposition, opener, closer)
                .addChild(nominalSelection);
    }
    
    public Node createPrepositionalPartDom(final Terminal preposition, final Terminal opener, final Node verbSelection, final Terminal closer) {
        return new PrepositionalPartDom(preposition, opener, closer)
                .addChild(verbSelection);
    }
    
    public Node createPrepositionalPartFin(final Terminal preposition, final Terminal opener, final Node nominalSelection, final Terminal closer) {
        return new PrepositionalPartFin(preposition, opener, closer)
                .addChild(nominalSelection);
    }
}

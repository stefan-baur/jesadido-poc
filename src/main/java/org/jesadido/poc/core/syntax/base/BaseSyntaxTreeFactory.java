/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.base;

import org.jesadido.poc.core.syntax.*;
import org.jesadido.poc.core.syntax.nodes.Node;
import java.util.List;
import java.util.logging.Logger;
import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.syntax.nodes.composites.PrepositionalPartDom;
import org.jesadido.poc.core.syntax.nodes.composites.PrepositionalPartFin;
import org.jesadido.poc.core.syntax.nodes.composites.SentenceMeat;
import org.jesadido.poc.core.syntax.nodes.composites.Sentence;
import org.jesadido.poc.core.syntax.nodes.composites.PrepositionalPartSu;
import org.jesadido.poc.core.syntax.nodes.leaves.SentenceMeatConjunction;
import org.jesadido.poc.core.syntax.nodes.leaves.Trouble;

public class BaseSyntaxTreeFactory implements SyntaxTreeFactory {
    
    private static final Logger LOGGER = Logger.getLogger(BaseSyntaxTreeFactory.class.getName());
    
    @Override
    public Node createSentence(final List<Node> meats, final Concept terminator) {
        return new Sentence(new Terminal(terminator, "."))
                .addChildren(meats);
    }
    
    @Override
    public Node createSentenceMeat(final Concept opener, final List<Node> parts, final Concept closer) {
        return new SentenceMeat(new Terminal(opener, "{"), new Terminal(closer, "}"))
                .addChildren(parts);
    }
    
    @Override
    public Node createSentenceMeatConjunction(final Concept separator) {
        return new SentenceMeatConjunction(new Terminal(separator, "Kaj"));
    }
    
    @Override
    public Node createPrepositionalPartSu(final Concept preposition, final Concept opener, final Node nominalSelection, final Concept closer) {
        return new PrepositionalPartSu(new Terminal(preposition, "Su"), new Terminal(opener, "("), new Terminal(closer, ")"))
                .addChild(nominalSelection);
    }
    
    @Override
    public Node createPrepositionalPartDom(final Concept preposition, final Concept opener, final Node verbSelection, final Concept closer) {
        return new PrepositionalPartDom(new Terminal(preposition, "Dom"), new Terminal(opener, "("), new Terminal(closer, ")"))
                .addChild(verbSelection);
    }
    
    @Override
    public Node createPrepositionalPartFin(final Concept preposition, final Concept opener, final Node nominalSelection, final Concept closer) {
        return new PrepositionalPartFin(new Terminal(preposition, "Fin"), new Terminal(opener, "("), new Terminal(closer, ")"))
                .addChild(nominalSelection);
    }
    
    @Override
    public Node createTrouble(final String message) {
        LOGGER.info(String.format("Creating a trouble-node with the message '%s'.", message));
        return new Trouble(message);
    }
}

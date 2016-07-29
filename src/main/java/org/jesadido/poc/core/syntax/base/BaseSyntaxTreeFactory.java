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
import org.jesadido.poc.core.syntax.nodes.sentence.SentenceMeatPartDom;
import org.jesadido.poc.core.syntax.nodes.sentence.SentenceMeatPartFin;
import org.jesadido.poc.core.syntax.nodes.sentence.SentenceMeat;
import org.jesadido.poc.core.syntax.nodes.sentence.Sentence;
import org.jesadido.poc.core.syntax.nodes.sentence.SentenceMeatPartSu;
import org.jesadido.poc.core.syntax.nodes.sentence.SentenceMeatPrefix;
import org.jesadido.poc.core.syntax.nodes.common.Trouble;

public class BaseSyntaxTreeFactory implements SyntaxTreeFactory {
    
    private static final Logger LOGGER = Logger.getLogger(BaseSyntaxTreeFactory.class.getName());
    
    @Override
    public Node createSentence(final List<Node> meats, final Concept terminator) {
        return new Sentence(new Terminal(terminator, "."))
                .addChildren(meats);
    }
    
    @Override
    public Node createSentenceMeat(final Node prefix, final Concept opener, final List<Node> parts, final Concept closer) {
        return new SentenceMeat(prefix, new Terminal(opener, "{"), new Terminal(closer, "}"))
                .addChildren(parts);
    }
    
    @Override
    public Node createSentenceMeatPrefix(final Concept prefix) {
        return new SentenceMeatPrefix(new Terminal(prefix, "Kaj"));
    }
    
    @Override
    public Node createSentenceMeatPartSu(final Concept preposition, final Concept opener, final Node nominalSelection, final Concept closer) {
        return new SentenceMeatPartSu(new Terminal(preposition, "Su"), new Terminal(opener, "("), new Terminal(closer, ")"))
                .addChild(nominalSelection);
    }
    
    @Override
    public Node createSentenceMeatPartDom(final Concept preposition, final Concept opener, final Node verbSelection, final Concept closer) {
        return new SentenceMeatPartDom(new Terminal(preposition, "Dom"), new Terminal(opener, "("), new Terminal(closer, ")"))
                .addChild(verbSelection);
    }
    
    @Override
    public Node createSentenceMeatPartFin(final Concept preposition, final Concept opener, final Node nominalSelection, final Concept closer) {
        return new SentenceMeatPartFin(new Terminal(preposition, "Fin"), new Terminal(opener, "("), new Terminal(closer, ")"))
                .addChild(nominalSelection);
    }
    
    @Override
    public Node createTrouble(final String message) {
        LOGGER.info(String.format("Creating a trouble-node with the message: %s", message));
        return new Trouble(message);
    }
}

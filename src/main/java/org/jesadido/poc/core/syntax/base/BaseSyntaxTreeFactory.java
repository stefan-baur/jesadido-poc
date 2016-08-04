/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.base;

import java.util.List;
import java.util.logging.Logger;
import org.jesadido.poc.core.syntax.SyntaxTreeFactory;
import org.jesadido.poc.core.syntax.Terminal;
import org.jesadido.poc.core.syntax.nodes.Node;
import org.jesadido.poc.core.syntax.nodes.common.TroubleNode;
import org.jesadido.poc.core.syntax.nodes.sentence.NominalSelection;
import org.jesadido.poc.core.syntax.nodes.sentence.Sentence;
import org.jesadido.poc.core.syntax.nodes.sentence.SentenceMeat;
import org.jesadido.poc.core.syntax.nodes.sentence.PartDom;
import org.jesadido.poc.core.syntax.nodes.sentence.PartFin;
import org.jesadido.poc.core.syntax.nodes.sentence.PartSu;
import org.jesadido.poc.core.syntax.nodes.sentence.SentenceMeatConjunction;
import org.jesadido.poc.core.syntax.nodes.sentence.VerbalSelection;
import org.jesadido.poc.core.syntax.tokens.Token;

public class BaseSyntaxTreeFactory implements SyntaxTreeFactory {
    
    private static final Logger LOGGER = Logger.getLogger(BaseSyntaxTreeFactory.class.getName());
    
    @Override
    public Node createSentence(final List<Node> meats, final Token terminator) {
        return new Sentence(new Terminal(terminator, "."))
                .addChildren(meats);
    }
    
    @Override
    public Node createSentenceMeat(final Node conjunction, final Token opener, final List<Node> parts, final Token closer) {
        return new SentenceMeat(conjunction, new Terminal(opener, "{"), new Terminal(closer, "}"))
                .addChildren(parts);
    }
    
    @Override
    public Node createSentenceMeatConjunction(final Token conjunction) {
        return new SentenceMeatConjunction(new Terminal(conjunction, "Kaj"));
    }
    
    @Override
    public Node createPartSu(final Token preposition, final Token opener, final Node nominalSelection, final Token closer) {
        return new PartSu(new Terminal(preposition, "Su"), new Terminal(opener, "("), new Terminal(closer, ")"))
                .addChild(nominalSelection);
    }
    
    @Override
    public Node createPartDom(final Token preposition, final Token opener, final Node verbalSelection, final Token closer) {
        return new PartDom(new Terminal(preposition, "Dom"), new Terminal(opener, "("), new Terminal(closer, ")"))
                .addChild(verbalSelection);
    }
    
    @Override
    public Node createPartFin(final Token preposition, final Token opener, final Node nominalSelection, final Token closer) {
        return new PartFin(new Terminal(preposition, "Fin"), new Terminal(opener, "("), new Terminal(closer, ")"))
                .addChild(nominalSelection);
    }
    
    @Override
    public Node createNominalSelection(final Token substantive) {
        return new NominalSelection(substantive.getConcept());
    }
    
    @Override
    public Node createVerbalSelection(final Token verb) {
        return new VerbalSelection(verb.getConcept());
    }
    
    @Override
    public Node createTrouble(final String message) {
        LOGGER.info(String.format("Creating a trouble-node with the message: %s", message));
        return new TroubleNode(message);
    }
}

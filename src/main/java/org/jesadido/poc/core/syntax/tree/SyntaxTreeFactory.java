/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tree;

import java.util.List;
import java.util.logging.Logger;
import org.jesadido.poc.core.syntax.tree.Node;
import org.jesadido.poc.core.syntax.tree.TroubleNode;
import org.jesadido.poc.core.syntax.tree.sentence.NominalSelection;
import org.jesadido.poc.core.syntax.tree.sentence.PartDom;
import org.jesadido.poc.core.syntax.tree.sentence.PartFin;
import org.jesadido.poc.core.syntax.tree.sentence.PartSu;
import org.jesadido.poc.core.syntax.tree.sentence.Sentence;
import org.jesadido.poc.core.syntax.tree.sentence.SentenceMeat;
import org.jesadido.poc.core.syntax.tree.sentence.SentenceMeatConjunction;
import org.jesadido.poc.core.syntax.tree.sentence.VerbalSelection;
import org.jesadido.poc.core.syntax.tokens.Token;

public class SyntaxTreeFactory {
    
    private static final Logger LOGGER = Logger.getLogger(SyntaxTreeFactory.class.getName());
    
    public Node createSentence(final List<Node> meats, final Token terminator) {
        return new Sentence(new Terminal(terminator, "."))
                .addChildren(meats);
    }
    
    public Node createSentenceMeat(final Node conjunction, final Token opener, final List<Node> parts, final Token closer) {
        return new SentenceMeat(conjunction, new Terminal(opener, "{"), new Terminal(closer, "}"))
                .addChildren(parts);
    }
    
    public Node createSentenceMeatConjunction(final Token conjunction) {
        return new SentenceMeatConjunction(new Terminal(conjunction, "Kaj"));
    }
    
    public Node createPartSu(final Token preposition, final Token opener, final Node nominalSelection, final Token closer) {
        return new PartSu(new Terminal(preposition, "Su"), new Terminal(opener, "("), new Terminal(closer, ")"))
                .addChild(nominalSelection);
    }
    
    public Node createPartDom(final Token preposition, final Token opener, final Node verbalSelection, final Token closer) {
        return new PartDom(new Terminal(preposition, "Dom"), new Terminal(opener, "("), new Terminal(closer, ")"))
                .addChild(verbalSelection);
    }
    
    public Node createPartFin(final Token preposition, final Token opener, final Node nominalSelection, final Token closer) {
        return new PartFin(new Terminal(preposition, "Fin"), new Terminal(opener, "("), new Terminal(closer, ")"))
                .addChild(nominalSelection);
    }
    
    public Node createNominalSelection(final Token substantive) {
        return new NominalSelection(substantive.getConcept());
    }
    
    public Node createVerbalSelection(final Token verb) {
        return new VerbalSelection(verb.getConcept());
    }
    
    public Node createTrouble(final String message) {
        LOGGER.info(String.format("Creating a trouble-node with the message: %s", message));
        return new TroubleNode(message);
    }
}

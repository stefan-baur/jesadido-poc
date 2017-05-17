/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tree;

import java.util.List;
import org.jesadido.poc.core.syntax.tree.sentence.NominalSelection;
import org.jesadido.poc.core.syntax.tree.sentence.PartDom;
import org.jesadido.poc.core.syntax.tree.sentence.PartFin;
import org.jesadido.poc.core.syntax.tree.sentence.PartSu;
import org.jesadido.poc.core.syntax.tree.sentence.Sentence;
import org.jesadido.poc.core.syntax.tree.sentence.SentenceMeat;
import org.jesadido.poc.core.syntax.tree.sentence.SentenceMeatConjunction;
import org.jesadido.poc.core.syntax.tree.sentence.VerbalSelection;
import org.jesadido.poc.core.syntax.tokens.Token;
import org.jesadido.poc.core.syntax.tree.sentence.AdjectiveSelection;
import org.jesadido.poc.core.syntax.tree.sentence.ArticleSelection;
import org.jesadido.poc.core.syntax.tree.sentence.PartAl;
import org.jesadido.poc.core.syntax.tree.sentence.SentenceSequence;
import org.jesadido.poc.core.syntax.tree.sentence.SubstantiveSelection;
import org.jesadido.poc.core.syntax.tree.sentence.VerbSelection;

public class SyntaxTreeFactory {
    
    public JesadidoNode createSentenceSequence(final List<JesadidoNode> sentences) {
        return new SentenceSequence()
                .addSentences(sentences);
    }
    
    public JesadidoNode createSentence(final List<JesadidoNode> meats, final Token terminator) {
        return new Sentence(new Terminal(terminator))
                .addMeats(meats);
    }
    
    public JesadidoNode createSentenceMeat(final JesadidoNode conjunction, final Token opener, final List<JesadidoNode> parts, final Token closer) {
        return new SentenceMeat(new Terminal(opener), new Terminal(closer))
                .setConjunction(conjunction)
                .addParts(parts);
    }
    
    public JesadidoNode createSentenceMeatConjunction(final Token conjunction) {
        return new SentenceMeatConjunction(new Terminal(conjunction));
    }
    
    public JesadidoNode createPartSu(final Token preposition, final Token opener, final JesadidoNode nominalSelection, final Token closer) {
        return new PartSu(new Terminal(preposition), new Terminal(opener), new Terminal(closer))
                .setNominalSelection(nominalSelection);
    }
    
    public JesadidoNode createPartDom(final Token preposition, final Token opener, final JesadidoNode verbalSelection, final Token closer) {
        return new PartDom(new Terminal(preposition), new Terminal(opener), new Terminal(closer))
                .setVerbalSelection(verbalSelection);
    }
    
    public JesadidoNode createPartAl(final Token preposition, final Token opener, final JesadidoNode nominalSelection, final Token closer) {
        return new PartAl(new Terminal(preposition), new Terminal(opener), new Terminal(closer))
                .setNominalSelection(nominalSelection);
    }
    
    public JesadidoNode createPartFin(final Token preposition, final Token opener, final JesadidoNode nominalSelection, final Token closer) {
        return new PartFin(new Terminal(preposition), new Terminal(opener), new Terminal(closer))
                .setNominalSelection(nominalSelection);
    }
    
    public JesadidoNode createNominalSelection(final JesadidoNode childSelection) {
        return new NominalSelection()
                .setChildSelection(childSelection);
    }
    
    public JesadidoNode createArticleSelection(final Token article, final JesadidoNode substantiveSelection) {
        return new ArticleSelection(new Terminal(article))
                .setSubstantiveSelection(substantiveSelection);
    }
    
    public JesadidoNode createSubstantiveSelection(final Token substantive, final List<JesadidoNode> adjectiveSelections) {
        return new SubstantiveSelection(new Terminal(substantive))
                .addAdjectiveSelections(adjectiveSelections);
    }
    
    public JesadidoNode createAdjectiveSelection(final Token adjective) {
        return new AdjectiveSelection(new Terminal(adjective));
    }
    
    public JesadidoNode createVerbalSelection(final JesadidoNode verbSelection) {
        return new VerbalSelection()
                .setVerbSelection(verbSelection);
    }
    
    public JesadidoNode createVerbSelection(final Token verb) {
        return new VerbSelection(new Terminal(verb));
    }
    
    public JesadidoNode createTrouble(final String message) {
        return new TroubleNode(message);
    }
}

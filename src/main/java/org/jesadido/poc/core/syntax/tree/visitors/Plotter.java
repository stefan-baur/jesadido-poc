/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tree.visitors;

import java.util.logging.Logger;
import org.jesadido.poc.core.scripting.Src;
import org.jesadido.poc.core.syntax.Grammar;
import org.jesadido.poc.core.syntax.GrammarFactory;
import org.jesadido.poc.core.syntax.Nonterminal;
import org.jesadido.poc.core.syntax.tree.JesadidoNode;
import org.jesadido.poc.core.syntax.tree.NominalPartNode;
import org.jesadido.poc.core.syntax.tree.Terminal;
import org.jesadido.poc.core.syntax.tree.Visitor;
import org.jesadido.poc.core.syntax.tree.TroubleNode;
import org.jesadido.poc.core.syntax.tree.sentence.AdjectiveSelection;
import org.jesadido.poc.core.syntax.tree.sentence.ArticleSelection;
import org.jesadido.poc.core.syntax.tree.sentence.SubstantiveSelection;
import org.jesadido.poc.core.syntax.tree.sentence.NominalSelection;
import org.jesadido.poc.core.syntax.tree.sentence.PartAl;
import org.jesadido.poc.core.syntax.tree.sentence.Sentence;
import org.jesadido.poc.core.syntax.tree.sentence.SentenceMeat;
import org.jesadido.poc.core.syntax.tree.sentence.PartDom;
import org.jesadido.poc.core.syntax.tree.sentence.PartFin;
import org.jesadido.poc.core.syntax.tree.sentence.PartSu;
import org.jesadido.poc.core.syntax.tree.sentence.SentenceMeatConjunction;
import org.jesadido.poc.core.syntax.tree.sentence.SentenceSequence;
import org.jesadido.poc.core.syntax.tree.sentence.VerbSelection;
import org.jesadido.poc.core.syntax.tree.sentence.VerbalSelection;

public class Plotter implements Visitor<Void, Src> {
    
    public static final Src plot(final JesadidoNode node) {
        Src result = new Src();
        node.accept(new Plotter(), result);
        return result;
    }
    
    private static String linePhrase(final JesadidoNode node) {
        return String.format("• %s", node.getClass().getSimpleName());
    }
    
    private static String linePhrase(final Terminal terminal) {
        return String.format("o %s", terminal.toString());
    }
    
    private static String errorPhrase(final String message) {
        return String.format("••• %s", message);
    }
    
    private Void visitNominalPartNode(final NominalPartNode node, final Src result) {
        result.line("%s", linePhrase(node));
        result.inc();
        result.line("%s", linePhrase(node.getPreposition()));
        result.line("%s", linePhrase(node.getOpener()));
        if (node.hasNominalSelection()) {
            node.getNominalSelection().accept(this, result);
        }
        result.line("%s", linePhrase(node.getCloser()));
        result.dec();
        return null;
    }
    
    @Override
    public Void visit(final SentenceSequence node, final Src result) {
        result.line("%s", linePhrase(node));
        result.inc();
        node.getSentences().stream().forEach(sentence -> sentence.accept(this, result));
        result.dec();
        return null;
    }
    
    @Override
    public Void visit(final Sentence node, final Src result) {
        result.line("%s", linePhrase(node));
        result.inc();
        node.getMeats().stream().forEach(meat -> meat.accept(this, result));
        result.line("%s", linePhrase(node.getTerminator()));
        result.dec();
        return null;
    }
    
    @Override
    public Void visit(final SentenceMeat node, final Src result) {
        result.line("%s", linePhrase(node));
        result.inc();
        if (node.hasConjunction()) {
            node.getConjunction().accept(this, result);
        }
        result.line("%s", linePhrase(node.getOpener()));
        node.getParts().stream().forEach(part -> part.accept(this, result));
        result.line("%s", linePhrase(node.getCloser()));
        result.dec();
        return null;
    }
    
    @Override
    public Void visit(final SentenceMeatConjunction node, final Src result) {
        result.line("%s", linePhrase(node));
        result.inc();
        result.line("%s", linePhrase(node.getConjunction()));
        result.dec();
        return null;
    }
    
    @Override
    public Void visit(final PartSu node, final Src result) {
        return this.visitNominalPartNode(node, result);
    }
    
    @Override
    public Void visit(final PartDom node, final Src result) {
        result.line("%s", linePhrase(node));
        result.inc();
        result.line("%s", linePhrase(node.getPreposition()));
        result.line("%s", linePhrase(node.getOpener()));
        if (node.hasVerbalSelection()) {
            node.getVerbalSelection().accept(this, result);
        }
        result.line("%s", linePhrase(node.getCloser()));
        result.dec();
        return null;
    }
    
    @Override
    public Void visit(final PartAl node, final Src result) {
        return this.visitNominalPartNode(node, result);
    }
    
    @Override
    public Void visit(final PartFin node, final Src result) {
        return this.visitNominalPartNode(node, result);
    }
    
    @Override
    public Void visit(final NominalSelection node, final Src result) {
        result.line("%s", linePhrase(node));
        result.inc();
        if (node.hasChildSelection()) {
            node.getChildSelection().accept(this, result);
        }
        result.dec();
        return null;
    }
    
    @Override
    public Void visit(final ArticleSelection node, final Src result) {
        result.line("%s", linePhrase(node));
        result.inc();
        result.line("%s", linePhrase(node.getArticle()));
        if (node.hasSubstantiveSelection()) {
            node.getSubstantiveSelection().accept(this, result);
        }
        result.dec();
        return null;
    }
    
    @Override
    public Void visit(final SubstantiveSelection node, final Src result) {
        result.line("%s", linePhrase(node));
        result.inc();
        result.line("%s", linePhrase(node.getSubstantive()));
        node.getAdjectiveSelections().stream().forEach(adjectiveSelection -> adjectiveSelection.accept(this, result));
        result.dec();
        return null;
    }
    
    @Override
    public Void visit(final AdjectiveSelection node, final Src result) {
        result.line("%s", linePhrase(node));
        result.inc();
        result.line("%s", linePhrase(node.getAdjective()));
        result.dec();
        return null;
    }
    
    @Override
    public Void visit(final VerbalSelection node, final Src result) {
        result.line("%s", linePhrase(node));
        result.inc();
        if (node.hasVerbSelection()) {
            node.getVerbSelection().accept(this, result);
        }
        result.dec();
        return null;
    }
    
    @Override
    public Void visit(final VerbSelection node, final Src result) {
        result.line("%s", linePhrase(node));
        result.inc();
        result.line("%s", linePhrase(node.getVerb()));
        result.dec();
        return null;
    }
    
    @Override
    public Void visit(final TroubleNode node, final Src result) {
        result.line("%s", linePhrase(node));
        result.inc();
        result.line("%s", errorPhrase(node.getMessage()));
        result.dec();
        return null;
    }
    
    public static void main(final String[] arguments) {
        final Grammar grammar = GrammarFactory.createJesadidoGrammar();
        for (final String sentencePhrase : new String[] {
            "HeroIcxO TrovAs Fin SkribIlO .",
            "HeroIcxO DonAs Fin SkribIlO Al HeroInO .",
            "HeroIcxO TrovAs Fin SkribIlO . HeroIcxO DonAs Fin SkribIlO Al HeroInO .",
            "HeroIcxO TrovAs Fin SkribIlO Kaj HeroIcxO DonAs TestO$Al HeroInO Fin SkribIlO .",
            "{\n\tHeroIcxO TrovAs Fin SkribIlO\n} Kaj {\n\tHeroIcxO DonAs Al HeroInO Fin SkribIlO\n} .",
            "{\n\tSu ( HeroIcxO )\n\tDom ( TrovAntAs )\n\tFin ( SkribIlO )\n} Kaj {\n\tSu ( HeroIcxO )\n\tDom ( DonAs )\n\tAl ( HeroInO )\n\tFin ( SkribIlO )\n} ."
        }) {
            final JesadidoNode sentence = grammar.parse(sentencePhrase, Nonterminal.SENTENCE_SEQUENCE);
            Logger.getAnonymousLogger().info("\n\n".concat(sentencePhrase).concat("\n\n").concat(Plotter.plot(sentence).toString()));
        }
    }
}

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tree.visitors;

import java.util.logging.Logger;
import org.jesadido.poc.core.concepts.ConceptUtils;
import org.jesadido.poc.core.scripting.Src;
import org.jesadido.poc.core.syntax.Grammar;
import org.jesadido.poc.core.syntax.GrammarFactory;
import org.jesadido.poc.core.syntax.Nonterminal;
import org.jesadido.poc.core.syntax.tree.Node;
import org.jesadido.poc.core.syntax.tree.TroubleNode;
import org.jesadido.poc.core.syntax.tree.Visitor;
import org.jesadido.poc.core.syntax.tree.sentence.NominalSelection;
import org.jesadido.poc.core.syntax.tree.sentence.PartAl;
import org.jesadido.poc.core.syntax.tree.sentence.PartDom;
import org.jesadido.poc.core.syntax.tree.sentence.PartFin;
import org.jesadido.poc.core.syntax.tree.sentence.PartSu;
import org.jesadido.poc.core.syntax.tree.sentence.Sentence;
import org.jesadido.poc.core.syntax.tree.sentence.SentenceMeat;
import org.jesadido.poc.core.syntax.tree.sentence.SentenceMeatConjunction;
import org.jesadido.poc.core.syntax.tree.sentence.SubstantiveSelection;
import org.jesadido.poc.core.syntax.tree.sentence.VerbSelection;
import org.jesadido.poc.core.syntax.tree.sentence.VerbalSelection;

public class PrettyPrinter implements Visitor<Void, Src> {
    
    public static final Src print(final Node node) {
        Src result = new Src();
        node.accept(new PrettyPrinter(), result);
        return result;
    }
    
    @Override
    public Void visit(final Sentence node, final Src result) {
        node.getMeats().stream().forEach(meat -> meat.accept(this, result));
        result.line("%s", node.getTerminator().getConcept());
        return null;
    }

    @Override
    public Void visit(final SentenceMeat node, final Src result) {
        if (node.hasConjunction()) {
            node.getConjunction().accept(this, result);
        }
        result.begin("%s", node.getOpener().getConcept());
        node.getParts().stream().forEach(part -> part.accept(this, result));
        result.end("%s", node.getCloser().getConcept());
        return null;
    }

    @Override
    public Void visit(final SentenceMeatConjunction node, final Src result) {
        result.line("%s", node.getConjunction().getConcept());
        return null;
    }

    @Override
    public Void visit(final PartSu node, final Src result) {
        result.begin("%s", ConceptUtils.join(node.getPreposition().getConcept(), node.getOpener().getConcept()));
        if (node.hasNominalSelection()) {
            node.getNominalSelection().accept(this, result);
        }
        result.end("%s", node.getCloser().getConcept());
        return null;
    }

    @Override
    public Void visit(final PartDom node, final Src result) {
        result.begin("%s", ConceptUtils.join(node.getPreposition().getConcept(), node.getOpener().getConcept()));
        if (node.hasVerbalSelection()) {
            node.getVerbalSelection().accept(this, result);
        }
        result.end("%s", node.getCloser().getConcept());
        return null;
    }

    @Override
    public Void visit(final PartAl node, final Src result) {
        result.begin("%s", ConceptUtils.join(node.getPreposition().getConcept(), node.getOpener().getConcept()));
        if (node.hasNominalSelection()) {
            node.getNominalSelection().accept(this, result);
        }
        result.end("%s", node.getCloser().getConcept());
        return null;
    }

    @Override
    public Void visit(final PartFin node, final Src result) {
        result.begin("%s", ConceptUtils.join(node.getPreposition().getConcept(), node.getOpener().getConcept()));
        if (node.hasNominalSelection()) {
            node.getNominalSelection().accept(this, result);
        }
        result.end("%s", node.getCloser().getConcept());
        return null;
    }

    @Override
    public Void visit(final NominalSelection node, final Src result) {
        if (node.hasSubstantiveSelection()) {
            node.getSubstantiveSelection().accept(this, result);
        }
        return null;
    }

    @Override
    public Void visit(final SubstantiveSelection node, final Src result) {
        result.line("%s", node.getSubstantive().getConcept());
        return null;
    }

    @Override
    public Void visit(final VerbalSelection node, final Src result) {
        if (node.hasVerbSelection()) {
            node.getVerbSelection().accept(this, result);
        }
        return null;
    }

    @Override
    public Void visit(final VerbSelection node, final Src result) {
        result.line("%s", node.getVerb().getConcept());
        return null;
    }

    @Override
    public Void visit(final TroubleNode node, final Src result) {
        return null;
    }
    
    public static void main(final String[] arguments) {
        final Grammar grammar = GrammarFactory.createJesadidoGrammar();
        for (final String sentencePhrase : new String[] {
            "HeroIcxO TrovAs Fin SkribIlO .",
            "TrovAs HeroIcxO Fin SkribIlO .",
            "HeroIcxO DonAs Fin SkribIlO Al HeroInO .",
            "Fin SkribIlO DonAs HeroIcxO Al HeroInO .",
            "HeroIcxO TrovAs Fin SkribIlO Kaj HeroIcxO DonAs TestO$Al HeroInO Fin SkribIlO .",
            "{\n\tHeroIcxO TrovAs Fin SkribIlO\n} Kaj {\n\tHeroIcxO DonAs Al HeroInO Fin SkribIlO\n} .",
            "{\n\tTestO$Su ( HeroIcxO )\n\tDom ( TrovAntAs )\n\tFin ( SkribIlO )\n} Kaj {\n\tSu ( HeroIcxO )\n\tDom ( DonAs )\n\tAl ( HeroInO )\n\tFin ( SkribIlO )\n} .",
            "HeroIcxO DonAs Al HeroInO Fin FlorO Se HeroIcxO TrovAs Fin FlorO .",
            "Se HeroIcxO TrovAs Fin FlorO { HeroIcxO DonAs Al HeroInO Fin FlorO } .",
            "Se { HeroIcxO TrovAs Fin FlorO } { HeroIcxO DonAs Al HeroInO Fin FlorO } ."
        }) {
            final Node sentenceOriginal = grammar.parse(sentencePhrase, Nonterminal.SENTENCE);
            final Src prettyPrintOriginal = PrettyPrinter.print(sentenceOriginal);
            final Node sentencePrettyPrintOriginal = grammar.parse(prettyPrintOriginal.toString(), Nonterminal.SENTENCE);
            final Src prettyPrintPrettyPrintOriginal = PrettyPrinter.print(sentencePrettyPrintOriginal);
            final Src compressed0 = new Src(0).add(prettyPrintPrettyPrintOriginal);
            final Src compressed1 = new Src(1).add(prettyPrintPrettyPrintOriginal);
            Logger.getAnonymousLogger().info(
                    "Original-Phrase:\n\n".concat(sentencePhrase).concat("\n\n")
                    .concat("Pretty-Print:\n\n").concat(prettyPrintOriginal.toString()).concat("\n\n")
                    .concat("Pretty-Print of Pretty-Print:\n\n").concat(prettyPrintPrettyPrintOriginal.toString()).concat("\n\n")
                    .concat("Compression-Level=0:\n\n").concat(compressed0.toString()).concat("\n\n")
                    .concat("Compression-Level=1:\n\n").concat(compressed1.toString())
            );
        }
    }
}

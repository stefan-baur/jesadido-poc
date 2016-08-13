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

public class PrettyPrinter implements Visitor<Src, Boolean> {
    
    public static final Src print(final Node node, final boolean sugared) {
        return node.accept(new PrettyPrinter(), sugared);
    }
    
    @Override
    public Src visit(final Sentence node, final Boolean sugared) {
        Src result = new Src();
        node.getMeats().stream().forEach(meat -> result.add(meat.accept(this, sugared)));
        result.line("%s", node.getTerminator().getConcept());
        return result;
    }

    @Override
    public Src visit(final SentenceMeat node, final Boolean sugared) {
        Src result = new Src();
        if (node.hasConjunction()) {
            result.add(node.getConjunction().accept(this, sugared));
        }
        result.begin("%s", node.getOpener().getConcept());
        node.getParts().stream().forEach(part -> result.add(part.accept(this, sugared)));
        result.end("%s", node.getCloser().getConcept());
        return result;
    }

    @Override
    public Src visit(final SentenceMeatConjunction node, final Boolean sugared) {
        Src result = new Src();
        result.line("%s", node.getConjunction().getConcept());
        return result;
    }

    @Override
    public Src visit(final PartSu node, final Boolean sugared) {
        Src result = new Src();
        if (sugared && node.getPreposition().isDefault()) {
            result.begin("%s", node.getOpener().getConcept());
        } else {
            result.begin("%s", ConceptUtils.join(node.getPreposition().getConcept(), node.getOpener().getConcept()));
        }
        if (node.hasNominalSelection()) {
            result.add(node.getNominalSelection().accept(this, sugared));
        }
        result.end("%s", node.getCloser().getConcept());
        return result;
    }

    @Override
    public Src visit(final PartDom node, final Boolean sugared) {
        Src result = new Src();
        result.begin("%s", ConceptUtils.join(node.getPreposition().getConcept(), node.getOpener().getConcept()));
        if (node.hasVerbalSelection()) {
            result.add(node.getVerbalSelection().accept(this, sugared));
        }
        result.end("%s", node.getCloser().getConcept());
        return result;
    }

    @Override
    public Src visit(final PartAl node, final Boolean sugared) {
        Src result = new Src();
        result.begin("%s", ConceptUtils.join(node.getPreposition().getConcept(), node.getOpener().getConcept()));
        if (node.hasNominalSelection()) {
            result.add(node.getNominalSelection().accept(this, sugared));
        }
        result.end("%s", node.getCloser().getConcept());
        return result;
    }

    @Override
    public Src visit(final PartFin node, final Boolean sugared) {
        Src result = new Src();
        result.begin("%s", ConceptUtils.join(node.getPreposition().getConcept(), node.getOpener().getConcept()));
        if (node.hasNominalSelection()) {
            result.add(node.getNominalSelection().accept(this, sugared));
        }
        result.end("%s", node.getCloser().getConcept());
        return result;
    }

    @Override
    public Src visit(final NominalSelection node, final Boolean sugared) {
        Src result = new Src();
        if (node.hasSubstantiveSelection()) {
            result.add(node.getSubstantiveSelection().accept(this, sugared));
        }
        return result;
    }

    @Override
    public Src visit(final SubstantiveSelection node, final Boolean sugared) {
        Src result = new Src();
        result.line("%s", node.getSubstantive().getConcept());
        return result;
    }

    @Override
    public Src visit(final VerbalSelection node, final Boolean sugared) {
        Src result = new Src();
        if (node.hasVerbSelection()) {
            result.add(node.getVerbSelection().accept(this, sugared));
        }
        return result;
    }

    @Override
    public Src visit(final VerbSelection node, final Boolean sugared) {
        Src result = new Src();
        result.line("%s", node.getVerb().getConcept());
        return result;
    }

    @Override
    public Src visit(final TroubleNode node, final Boolean sugared) {
        return new Src();
    }
    
    public static void main(final String[] arguments) {
        final Grammar grammar = new GrammarFactory().createJesadidoGrammar();
        for (final String sentencePhrase : new String[] {
            "HeroIcxO TrovAs Fin SkribIlO .",
            "HeroIcxO DonAs Fin SkribIlO Al HeroInO .",
            "HeroIcxO TrovAs Fin SkribIlO Kaj HeroIcxO DonAs TestO$Al HeroInO Fin SkribIlO .",
            "{\n\tHeroIcxO TrovAs Fin SkribIlO\n} Kaj {\n\tHeroIcxO DonAs Al HeroInO Fin SkribIlO\n} .",
            "{\n\tSu ( HeroIcxO )\n\tDom ( TrovAntAs )\n\tFin ( SkribIlO )\n} Kaj {\n\tSu ( HeroIcxO )\n\tDom ( DonAs )\n\tAl ( HeroInO )\n\tFin ( SkribIlO )\n} ."
        }) {
            for (final Boolean sugared : new Boolean[] { false, true }) {
                final Node sentenceOriginal = grammar.parse(sentencePhrase, Nonterminal.SENTENCE);
                final Src prettyPrintOriginal = PrettyPrinter.print(sentenceOriginal, sugared);
                final Node sentencePrettyPrintOriginal = grammar.parse(prettyPrintOriginal.toString(), Nonterminal.SENTENCE);
                final Src prettyPrintPrettyPrintOriginal = PrettyPrinter.print(sentencePrettyPrintOriginal, sugared);
                final Src compressed0 = new Src(0).add(prettyPrintPrettyPrintOriginal);
                final Src compressed1 = new Src(1).add(prettyPrintPrettyPrintOriginal);
                Logger.getAnonymousLogger().info(
                        "Sugared=".concat(sugared.toString()).concat(":\n\n")
                        .concat("Original-Phrase:\n\n").concat(sentencePhrase).concat("\n\n")
                        .concat("Pretty-Print:\n\n").concat(prettyPrintOriginal.toString()).concat("\n\n")
                        .concat("Pretty-Print of Pretty-Print:\n\n").concat(prettyPrintPrettyPrintOriginal.toString()).concat("\n\n")
                        .concat("Compression-Level=0:\n\n").concat(compressed0.toString()).concat("\n\n")
                        .concat("Compression-Level=1:\n\n").concat(compressed1.toString())
                );
            }
        }
    }
}
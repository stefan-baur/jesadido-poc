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
import org.jesadido.poc.core.syntax.tree.Node;
import org.jesadido.poc.core.syntax.tree.Terminal;
import org.jesadido.poc.core.syntax.tree.Visitor;
import org.jesadido.poc.core.syntax.tree.TroubleNode;
import org.jesadido.poc.core.syntax.tree.sentence.SubstantiveSelection;
import org.jesadido.poc.core.syntax.tree.sentence.NominalSelection;
import org.jesadido.poc.core.syntax.tree.sentence.PartAl;
import org.jesadido.poc.core.syntax.tree.sentence.Sentence;
import org.jesadido.poc.core.syntax.tree.sentence.SentenceMeat;
import org.jesadido.poc.core.syntax.tree.sentence.PartDom;
import org.jesadido.poc.core.syntax.tree.sentence.PartFin;
import org.jesadido.poc.core.syntax.tree.sentence.PartSu;
import org.jesadido.poc.core.syntax.tree.sentence.SentenceMeatConjunction;
import org.jesadido.poc.core.syntax.tree.sentence.VerbSelection;
import org.jesadido.poc.core.syntax.tree.sentence.VerbalSelection;

public class Plotter implements Visitor<Src, Void> {
    
    public static final Src plot(final Node node) {
        return node.accept(new Plotter(), null);
    }
    
    private Src openSrc(final Node node) {
        return new Src().line("• %s", node.getClass().getSimpleName()).inc();
    }
    
    private Src closeSrc(final Src src) {
        return src.dec();
    }
    
    private void out(final Src src, final Terminal terminal) {
        if (terminal.hasToken()) {
            src.line("\"%s\" : %s", terminal.getConcept().getFullPhrase(), terminal.getToken());
        } else if (terminal.hasConcept()) {
            src.line("\"%s\"", terminal.getConcept().getFullPhrase());
        } else {
            src.line("•••");
        }
    }
    
    @Override
    public Src visit(final Sentence node, final Void unused) {
        Src result = this.openSrc(node);
        node.getMeats().stream().forEach(meat -> result.add(meat.accept(this, unused)));
        this.out(result, node.getTerminator());
        return this.closeSrc(result);
    }
    
    @Override
    public Src visit(final SentenceMeat node, final Void unused) {
        Src result = this.openSrc(node);
        if (node.hasConjunction()) {
            result.add(node.getConjunction().accept(this, unused));
        }
        this.out(result, node.getOpener());
        node.getParts().stream().forEach(part -> result.add(part.accept(this, unused)));
        this.out(result, node.getCloser());
        return this.closeSrc(result);
    }
    
    @Override
    public Src visit(final SentenceMeatConjunction node, final Void unused) {
        Src result = this.openSrc(node);
        this.out(result, node.getConjunction());
        return this.closeSrc(result);
    }
    
    @Override
    public Src visit(final PartSu node, final Void unused) {
        Src result = this.openSrc(node);
        this.out(result, node.getPreposition());
        this.out(result, node.getOpener());
        if (node.hasNominalSelection()) {
            result.add(node.getNominalSelection().accept(this, unused));
        }
        this.out(result, node.getCloser());
        return this.closeSrc(result);
    }
    
    @Override
    public Src visit(final PartDom node, final Void unused) {
        Src result = this.openSrc(node);
        this.out(result, node.getPreposition());
        this.out(result, node.getOpener());
        if (node.hasVerbalSelection()) {
            result.add(node.getVerbalSelection().accept(this, unused));
        }
        this.out(result, node.getCloser());
        return this.closeSrc(result);
    }
    
    @Override
    public Src visit(final PartAl node, final Void unused) {
        Src result = this.openSrc(node);
        this.out(result, node.getPreposition());
        this.out(result, node.getOpener());
        if (node.hasNominalSelection()) {
            result.add(node.getNominalSelection().accept(this, unused));
        }
        this.out(result, node.getCloser());
        return this.closeSrc(result);
    }
    
    @Override
    public Src visit(final PartFin node, final Void unused) {
        Src result = this.openSrc(node);
        this.out(result, node.getPreposition());
        this.out(result, node.getOpener());
        if (node.hasNominalSelection()) {
            result.add(node.getNominalSelection().accept(this, unused));
        }
        this.out(result, node.getCloser());
        return this.closeSrc(result);
    }
    
    @Override
    public Src visit(final NominalSelection node, final Void unused) {
        Src result = this.openSrc(node);
        if (node.hasSubstantiveSelection()) {
            result.add(node.getSubstantiveSelection().accept(this, unused));
        }
        return this.closeSrc(result);
    }
    
    @Override
    public Src visit(final SubstantiveSelection node, final Void unused) {
        Src result = this.openSrc(node);
        this.out(result, node.getSubstantive());
        return this.closeSrc(result);
    }
    
    @Override
    public Src visit(final VerbalSelection node, final Void unused) {
        Src result = this.openSrc(node);
        if (node.hasVerbSelection()) {
            result.add(node.getVerbSelection().accept(this, unused));
        }
        return this.closeSrc(result);
    }
    
    @Override
    public Src visit(final VerbSelection node, final Void unused) {
        Src result = this.openSrc(node);
        this.out(result, node.getVerb());
        return this.closeSrc(result);
    }
    
    @Override
    public Src visit(final TroubleNode node, final Void unused) {
        Src result = this.openSrc(node);
        result.line("••• %s", node.getMessage());
        return this.closeSrc(result);
    }
    
    public static void main(final String[] arguments) {
        final Grammar grammar = new GrammarFactory().createDefaultGrammar("Jesadido");
        for (final Node sentence : new Node[] {
            grammar.parse("HeroIcxO TrovAs Fin SkribIlO .", Nonterminal.SENTENCE),
            grammar.parse("HeroIcxO DonAs Fin SkribIlO Al HeroInO .", Nonterminal.SENTENCE),
            grammar.parse("HeroIcxO TrovAs Fin SkribIlO Kaj HeroIcxO DonAs TestO$Al HeroInO Fin SkribIlO .", Nonterminal.SENTENCE)
        }) {
            Logger.getAnonymousLogger().info(Plotter.plot(sentence).toString());
        }
    }
}

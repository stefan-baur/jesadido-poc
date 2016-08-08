/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tree.visitors;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.syntax.tree.Node;
import org.jesadido.poc.core.syntax.tree.Visitor;
import org.jesadido.poc.core.syntax.tree.TroubleNode;
import org.jesadido.poc.core.syntax.tree.sentence.NominalPhrase;
import org.jesadido.poc.core.syntax.tree.sentence.NominalSelection;
import org.jesadido.poc.core.syntax.tree.sentence.PartAl;
import org.jesadido.poc.core.syntax.tree.sentence.Sentence;
import org.jesadido.poc.core.syntax.tree.sentence.SentenceMeat;
import org.jesadido.poc.core.syntax.tree.sentence.PartDom;
import org.jesadido.poc.core.syntax.tree.sentence.PartFin;
import org.jesadido.poc.core.syntax.tree.sentence.PartSu;
import org.jesadido.poc.core.syntax.tree.sentence.SentenceMeatConjunction;
import org.jesadido.poc.core.syntax.tree.sentence.VerbalSelection;

public class ConceptCollector implements Visitor<List<Concept>, Void> {
    
    public static final List<Concept> collect(final Node node) {
        return node.accept(new ConceptCollector(), null);
    }
    
    public static final void collect(final Node node, final Collection<Concept> output) {
        output.addAll(node.accept(new ConceptCollector(), null));
    }
    
    @Override
    public List<Concept> visit(final Sentence node, final Void unused) {
        List<Concept> result = new LinkedList<>();
        node.getMeats().stream().forEach(meat -> result.addAll(meat.accept(this, null)));
        result.add(node.getTerminator().getConcept());
        return result;
    }
    
    @Override
    public List<Concept> visit(final SentenceMeat node, final Void unused) {
        List<Concept> result = new LinkedList<>();
        if (node.hasConjunction()) {
            result.addAll(node.getConjunction().accept(this, null));
        }
        result.add(node.getOpener().getConcept());
        node.getParts().stream().forEach(part -> result.addAll(part.accept(this, null)));
        result.add(node.getCloser().getConcept());
        return result;
    }
    
    @Override
    public List<Concept> visit(final SentenceMeatConjunction node, final Void unused) {
        List<Concept> result = new LinkedList<>();
        result.add(node.getConjunction().getConcept());
        return result;
    }
    
    @Override
    public List<Concept> visit(final PartSu node, final Void unused) {
        List<Concept> result = new LinkedList<>();
        result.add(node.getPreposition().getConcept());
        result.add(node.getOpener().getConcept());
        if (node.hasNominalSelection()) {
            result.addAll(node.getNominalSelection().accept(this, null));
        }
        result.add(node.getCloser().getConcept());
        return result;
    }
    
    @Override
    public List<Concept> visit(final PartDom node, final Void unused) {
        List<Concept> result = new LinkedList<>();
        result.add(node.getPreposition().getConcept());
        result.add(node.getOpener().getConcept());
        if (node.hasVerbalSelection()) {
            result.addAll(node.getVerbalSelection().accept(this, null));
        }
        result.add(node.getCloser().getConcept());
        return result;
    }
    
    @Override
    public List<Concept> visit(final PartAl node, final Void unused) {
        List<Concept> result = new LinkedList<>();
        result.add(node.getPreposition().getConcept());
        result.add(node.getOpener().getConcept());
        if (node.hasNominalSelection()) {
            result.addAll(node.getNominalSelection().accept(this, null));
        }
        result.add(node.getCloser().getConcept());
        return result;
    }
    
    @Override
    public List<Concept> visit(final PartFin node, final Void unused) {
        List<Concept> result = new LinkedList<>();
        result.add(node.getPreposition().getConcept());
        result.add(node.getOpener().getConcept());
        if (node.hasNominalSelection()) {
            result.addAll(node.getNominalSelection().accept(this, null));
        }
        result.add(node.getCloser().getConcept());
        return result;
    }
    
    @Override
    public List<Concept> visit(final NominalSelection node, final Void unused) {
        List<Concept> result = new LinkedList<>();
        if (node.hasNominalPhrase()) {
            result.addAll(node.getNominalPhrase().accept(this, null));
        }
        return result;
    }
    
    @Override
    public List<Concept> visit(final NominalPhrase node, final Void unused) {
        List<Concept> result = new LinkedList<>();
        result.add(node.getSubstantive());
        return result;
    }
    
    @Override
    public List<Concept> visit(final VerbalSelection node, final Void unused) {
        List<Concept> result = new LinkedList<>();
        result.add(node.getVerb());
        return result;
    }
    
    @Override
    public List<Concept> visit(final TroubleNode node, final Void unused) {
        return new LinkedList<>();
    }
}

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.nodes.visitors;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.syntax.nodes.Node;
import org.jesadido.poc.core.syntax.nodes.Visitor;
import org.jesadido.poc.core.syntax.nodes.composites.PrepositionalPartDom;
import org.jesadido.poc.core.syntax.nodes.composites.PrepositionalPartFin;
import org.jesadido.poc.core.syntax.nodes.composites.PrepositionalPartSu;
import org.jesadido.poc.core.syntax.nodes.composites.Sentence;
import org.jesadido.poc.core.syntax.nodes.composites.SentenceMeat;
import org.jesadido.poc.core.syntax.nodes.leaves.SentenceMeatConjunction;

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
        node.getChildren().stream().forEach(child -> result.addAll(child.accept(this, null)));
        result.add(node.getTerminator().getConcept());
        return result;
    }
    
    @Override
    public List<Concept> visit(final SentenceMeat node, final Void unused) {
        List<Concept> result = new LinkedList<>();
        result.add(node.getOpener().getConcept());
        node.getChildren().stream().forEach(child -> result.addAll(child.accept(this, null)));
        result.add(node.getCloser().getConcept());
        return result;
    }
    
    @Override
    public List<Concept> visit(final SentenceMeatConjunction node, final Void unused) {
        List<Concept> result = new LinkedList<>();
        result.add(node.getSeparator().getConcept());
        return result;
    }
    
    @Override
    public List<Concept> visit(final PrepositionalPartSu node, final Void unused) {
        List<Concept> result = new LinkedList<>();
        result.add(node.getPreposition().getConcept());
        result.add(node.getOpener().getConcept());
        node.getChildren().stream().forEach(child -> result.addAll(child.accept(this, null)));
        result.add(node.getCloser().getConcept());
        return result;
    }
    
    @Override
    public List<Concept> visit(final PrepositionalPartDom node, final Void unused) {
        List<Concept> result = new LinkedList<>();
        result.add(node.getPreposition().getConcept());
        result.add(node.getOpener().getConcept());
        node.getChildren().stream().forEach(child -> result.addAll(child.accept(this, null)));
        result.add(node.getCloser().getConcept());
        return result;
    }
    
    @Override
    public List<Concept> visit(final PrepositionalPartFin node, final Void unused) {
        List<Concept> result = new LinkedList<>();
        result.add(node.getPreposition().getConcept());
        result.add(node.getOpener().getConcept());
        node.getChildren().stream().forEach(child -> result.addAll(child.accept(this, null)));
        result.add(node.getCloser().getConcept());
        return result;
    }
}

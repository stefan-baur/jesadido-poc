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
import org.jesadido.poc.core.syntax.nodes.common.TroubleNode;
import org.jesadido.poc.core.syntax.nodes.sentence.Sentence;
import org.jesadido.poc.core.syntax.nodes.sentence.SentenceMeat;
import org.jesadido.poc.core.syntax.nodes.sentence.SentenceMeatPartDom;
import org.jesadido.poc.core.syntax.nodes.sentence.SentenceMeatPartFin;
import org.jesadido.poc.core.syntax.nodes.sentence.SentenceMeatPartSu;
import org.jesadido.poc.core.syntax.nodes.sentence.SentenceMeatPrefix;

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
        if (node.hasPrefix()) {
            result.addAll(node.getPrefix().accept(this, null));
        }
        result.add(node.getOpener().getConcept());
        node.getChildren().stream().forEach(child -> result.addAll(child.accept(this, null)));
        result.add(node.getCloser().getConcept());
        return result;
    }
    
    @Override
    public List<Concept> visit(final SentenceMeatPrefix node, final Void unused) {
        List<Concept> result = new LinkedList<>();
        result.add(node.getSeparator().getConcept());
        return result;
    }
    
    @Override
    public List<Concept> visit(final SentenceMeatPartSu node, final Void unused) {
        List<Concept> result = new LinkedList<>();
        result.add(node.getPreposition().getConcept());
        result.add(node.getOpener().getConcept());
        node.getChildren().stream().forEach(child -> result.addAll(child.accept(this, null)));
        result.add(node.getCloser().getConcept());
        return result;
    }
    
    @Override
    public List<Concept> visit(final SentenceMeatPartDom node, final Void unused) {
        List<Concept> result = new LinkedList<>();
        result.add(node.getPreposition().getConcept());
        result.add(node.getOpener().getConcept());
        node.getChildren().stream().forEach(child -> result.addAll(child.accept(this, null)));
        result.add(node.getCloser().getConcept());
        return result;
    }
    
    @Override
    public List<Concept> visit(final SentenceMeatPartFin node, final Void unused) {
        List<Concept> result = new LinkedList<>();
        result.add(node.getPreposition().getConcept());
        result.add(node.getOpener().getConcept());
        node.getChildren().stream().forEach(child -> result.addAll(child.accept(this, null)));
        result.add(node.getCloser().getConcept());
        return result;
    }
    
    @Override
    public List<Concept> visit(final TroubleNode node, final Void unused) {
        return new LinkedList<>();
    }
}

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tree.visitors;

import java.util.LinkedList;
import java.util.List;
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
import org.jesadido.poc.core.syntax.tree.sentence.SentenceSequence;
import org.jesadido.poc.core.syntax.tree.sentence.VerbSelection;
import org.jesadido.poc.core.syntax.tree.sentence.VerbalSelection;

public class TerminalCollector implements Visitor<Void, List<Terminal>> {
    
    public static final List<Terminal> collect(final Node node) {
        List<Terminal> result = new LinkedList<>();
        node.accept(new TerminalCollector(), result);
        return result;
    }
    
    @Override
    public Void visit(final SentenceSequence node, final List<Terminal> result) {
        node.getSentences().stream().forEach(sentence -> sentence.accept(this, result));
        return null;
    }
    
    @Override
    public Void visit(final Sentence node, final List<Terminal> result) {
        node.getMeats().stream().forEach(meat -> meat.accept(this, result));
        result.add(node.getTerminator());
        return null;
    }
    
    @Override
    public Void visit(final SentenceMeat node, final List<Terminal> result) {
        if (node.hasConjunction()) {
            node.getConjunction().accept(this, result);
        }
        result.add(node.getOpener());
        node.getParts().stream().forEach(part -> part.accept(this, result));
        result.add(node.getCloser());
        return null;
    }
    
    @Override
    public Void visit(final SentenceMeatConjunction node, final List<Terminal> result) {
        result.add(node.getConjunction());
        return null;
    }
    
    @Override
    public Void visit(final PartSu node, final List<Terminal> result) {
        result.add(node.getPreposition());
        result.add(node.getOpener());
        if (node.hasNominalSelection()) {
            node.getNominalSelection().accept(this, result);
        }
        result.add(node.getCloser());
        return null;
    }
    
    @Override
    public Void visit(final PartDom node, final List<Terminal> result) {
        result.add(node.getPreposition());
        result.add(node.getOpener());
        if (node.hasVerbalSelection()) {
            node.getVerbalSelection().accept(this, result);
        }
        result.add(node.getCloser());
        return null;
    }
    
    @Override
    public Void visit(final PartAl node, final List<Terminal> result) {
        result.add(node.getPreposition());
        result.add(node.getOpener());
        if (node.hasNominalSelection()) {
            node.getNominalSelection().accept(this, result);
        }
        result.add(node.getCloser());
        return null;
    }
    
    @Override
    public Void visit(final PartFin node, final List<Terminal> result) {
        result.add(node.getPreposition());
        result.add(node.getOpener());
        if (node.hasNominalSelection()) {
            node.getNominalSelection().accept(this, result);
        }
        result.add(node.getCloser());
        return null;
    }
    
    @Override
    public Void visit(final NominalSelection node, final List<Terminal> result) {
        if (node.hasSubstantiveSelection()) {
            node.getSubstantiveSelection().accept(this, result);
        }
        return null;
    }
    
    @Override
    public Void visit(final SubstantiveSelection node, final List<Terminal> result) {
        result.add(node.getSubstantive());
        return null;
    }
    
    @Override
    public Void visit(final VerbalSelection node, final List<Terminal> result) {
        if (node.hasVerbSelection()) {
            node.getVerbSelection().accept(this, result);
        }
        return null;
    }
    
    @Override
    public Void visit(final VerbSelection node, final List<Terminal> result) {
        result.add(node.getVerb());
        return null;
    }
    
    @Override
    public Void visit(final TroubleNode node, final List<Terminal> result) {
        return null;
    }
}

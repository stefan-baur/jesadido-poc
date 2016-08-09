/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.visitors;

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
import org.jesadido.poc.core.syntax.tree.sentence.VerbSelection;
import org.jesadido.poc.core.syntax.tree.sentence.VerbalSelection;

public class TerminalCollector implements Visitor<List<Terminal>, Void> {
    
    public static final List<Terminal> collect(final Node node) {
        return node.accept(new TerminalCollector(), null);
    }
    
    @Override
    public List<Terminal> visit(final Sentence node, final Void unused) {
        List<Terminal> result = new LinkedList<>();
        node.getMeats().stream().forEach(meat -> result.addAll(meat.accept(this, unused)));
        result.add(node.getTerminator());
        return result;
    }
    
    @Override
    public List<Terminal> visit(final SentenceMeat node, final Void unused) {
        List<Terminal> result = new LinkedList<>();
        if (node.hasConjunction()) {
            result.addAll(node.getConjunction().accept(this, unused));
        }
        result.add(node.getOpener());
        node.getParts().stream().forEach(part -> result.addAll(part.accept(this, unused)));
        result.add(node.getCloser());
        return result;
    }
    
    @Override
    public List<Terminal> visit(final SentenceMeatConjunction node, final Void unused) {
        List<Terminal> result = new LinkedList<>();
        result.add(node.getConjunction());
        return result;
    }
    
    @Override
    public List<Terminal> visit(final PartSu node, final Void unused) {
        List<Terminal> result = new LinkedList<>();
        result.add(node.getPreposition());
        result.add(node.getOpener());
        if (node.hasNominalSelection()) {
            result.addAll(node.getNominalSelection().accept(this, unused));
        }
        result.add(node.getCloser());
        return result;
    }
    
    @Override
    public List<Terminal> visit(final PartDom node, final Void unused) {
        List<Terminal> result = new LinkedList<>();
        result.add(node.getPreposition());
        result.add(node.getOpener());
        if (node.hasVerbalSelection()) {
            result.addAll(node.getVerbalSelection().accept(this, unused));
        }
        result.add(node.getCloser());
        return result;
    }
    
    @Override
    public List<Terminal> visit(final PartAl node, final Void unused) {
        List<Terminal> result = new LinkedList<>();
        result.add(node.getPreposition());
        result.add(node.getOpener());
        if (node.hasNominalSelection()) {
            result.addAll(node.getNominalSelection().accept(this, unused));
        }
        result.add(node.getCloser());
        return result;
    }
    
    @Override
    public List<Terminal> visit(final PartFin node, final Void unused) {
        List<Terminal> result = new LinkedList<>();
        result.add(node.getPreposition());
        result.add(node.getOpener());
        if (node.hasNominalSelection()) {
            result.addAll(node.getNominalSelection().accept(this, unused));
        }
        result.add(node.getCloser());
        return result;
    }
    
    @Override
    public List<Terminal> visit(final NominalSelection node, final Void unused) {
        List<Terminal> result = new LinkedList<>();
        if (node.hasSubstantiveSelection()) {
            result.addAll(node.getSubstantiveSelection().accept(this, unused));
        }
        return result;
    }
    
    @Override
    public List<Terminal> visit(final SubstantiveSelection node, final Void unused) {
        List<Terminal> result = new LinkedList<>();
        result.add(node.getSubstantive());
        return result;
    }
    
    @Override
    public List<Terminal> visit(final VerbalSelection node, final Void unused) {
        List<Terminal> result = new LinkedList<>();
        if (node.hasVerbSelection()) {
            result.addAll(node.getVerbSelection().accept(this, unused));
        }
        return result;
    }
    
    @Override
    public List<Terminal> visit(final VerbSelection node, final Void unused) {
        List<Terminal> result = new LinkedList<>();
        result.add(node.getVerb());
        return result;
    }
    
    @Override
    public List<Terminal> visit(final TroubleNode node, final Void unused) {
        return new LinkedList<>();
    }
}

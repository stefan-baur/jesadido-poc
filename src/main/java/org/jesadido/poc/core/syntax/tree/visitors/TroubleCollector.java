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

public class TroubleCollector implements Visitor<Void, List<TroubleNode>> {

    public static List<TroubleNode> collect(Node node) {
        List<TroubleNode> result = new LinkedList<>();
        node.accept(new TroubleCollector(), result);
        return result;
    }
    
    @Override
    public Void visit(Sentence node, List<TroubleNode> result) {
        node.getMeats().stream().forEach(meat -> meat.accept(this, result));
        return null;
    }

    @Override
    public Void visit(SentenceMeat node, List<TroubleNode> result) {
        if (node.hasConjunction()) {
            node.getConjunction().accept(this, result);
        }
        node.getParts().stream().forEach(part -> part.accept(this, result));
        return null;
    }

    @Override
    public Void visit(SentenceMeatConjunction node, List<TroubleNode> result) {
        return null;
    }

    @Override
    public Void visit(PartSu node, List<TroubleNode> result) {
        if (node.hasNominalSelection()) {
            node.getNominalSelection().accept(this, result);
        }
        return null;
    }

    @Override
    public Void visit(PartDom node, List<TroubleNode> result) {
        if (node.hasVerbalSelection()) {
            node.getVerbalSelection().accept(this, result);
        }
        return null;
    }

    @Override
    public Void visit(PartAl node, List<TroubleNode> result) {
        if (node.hasNominalSelection()) {
            node.getNominalSelection().accept(this, result);
        }
        return null;
    }

    @Override
    public Void visit(PartFin node, List<TroubleNode> result) {
        if (node.hasNominalSelection()) {
            node.getNominalSelection().accept(this, result);
        }
        return null;
    }

    @Override
    public Void visit(NominalSelection node, List<TroubleNode> result) {
        if (node.hasSubstantiveSelection()) {
            node.getSubstantiveSelection().accept(this, result);
        }
        return null;
    }

    @Override
    public Void visit(SubstantiveSelection node, List<TroubleNode> result) {
        return null;
    }

    @Override
    public Void visit(VerbalSelection node, List<TroubleNode> result) {
        if (node.hasVerbSelection()) {
            node.getVerbSelection().accept(this, result);
        }
        return null;
    }

    @Override
    public Void visit(VerbSelection node, List<TroubleNode> result) {
        return null;
    }

    @Override
    public Void visit(TroubleNode node, List<TroubleNode> result) {
        if (result != null) {
            result.add(node);
        }
        return null;
    }
}

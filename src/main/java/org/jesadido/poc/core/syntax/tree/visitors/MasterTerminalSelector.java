/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tree.visitors;

import org.jesadido.poc.core.syntax.tree.Node;
import org.jesadido.poc.core.syntax.tree.Terminal;
import org.jesadido.poc.core.syntax.tree.TroubleNode;
import org.jesadido.poc.core.syntax.tree.Visitor;
import org.jesadido.poc.core.syntax.tree.sentence.ArticleSelection;
import org.jesadido.poc.core.syntax.tree.sentence.NominalSelection;
import org.jesadido.poc.core.syntax.tree.sentence.PartAl;
import org.jesadido.poc.core.syntax.tree.sentence.PartDom;
import org.jesadido.poc.core.syntax.tree.sentence.PartFin;
import org.jesadido.poc.core.syntax.tree.sentence.PartSu;
import org.jesadido.poc.core.syntax.tree.sentence.Sentence;
import org.jesadido.poc.core.syntax.tree.sentence.SentenceMeat;
import org.jesadido.poc.core.syntax.tree.sentence.SentenceMeatConjunction;
import org.jesadido.poc.core.syntax.tree.sentence.SentenceSequence;
import org.jesadido.poc.core.syntax.tree.sentence.SubstantiveSelection;
import org.jesadido.poc.core.syntax.tree.sentence.VerbSelection;
import org.jesadido.poc.core.syntax.tree.sentence.VerbalSelection;

public class MasterTerminalSelector implements Visitor<Terminal, Void> {

    public static final Terminal select(final Node node) {
        return node.accept(new MasterTerminalSelector(), null);
    }
    
    @Override
    public Terminal visit(final SentenceSequence node, final Void unused) {
        return null;
    }

    @Override
    public Terminal visit(final Sentence node, final Void unused) {
        return null;
    }

    @Override
    public Terminal visit(final SentenceMeat node, final Void unused) {
        return null;
    }

    @Override
    public Terminal visit(final SentenceMeatConjunction node, final Void unused) {
        return null;
    }

    @Override
    public Terminal visit(final PartSu node, final Void unused) {
        return node.hasNominalSelection() ? node.getNominalSelection().accept(this, unused) : null;
    }

    @Override
    public Terminal visit(final PartDom node, final Void unused) {
        return node.hasVerbalSelection() ? node.getVerbalSelection().accept(this, unused) : null;
    }

    @Override
    public Terminal visit(final PartAl node, final Void unused) {
        return node.hasNominalSelection() ? node.getNominalSelection().accept(this, unused) : null;
    }

    @Override
    public Terminal visit(final PartFin node, final Void unused) {
        return node.hasNominalSelection() ? node.getNominalSelection().accept(this, unused) : null;
    }

    @Override
    public Terminal visit(final NominalSelection node, final Void unused) {
        return node.hasChildSelection() ? node.getChildSelection().accept(this, unused) : null;
    }

    @Override
    public Terminal visit(final SubstantiveSelection node, final Void unused) {
        return node.getSubstantive();
    }
    
    @Override
    public Terminal visit(final ArticleSelection node, final Void unused) {
        return node.hasSubstantiveSelection() ? node.getSubstantiveSelection().accept(this, unused) : null;
    }

    @Override
    public Terminal visit(final VerbalSelection node, final Void unused) {
        return node.hasVerbSelection() ? node.getVerbSelection().accept(this, unused) : null;
    }

    @Override
    public Terminal visit(final VerbSelection node, final Void unused) {
        return node.getVerb();
    }

    @Override
    public Terminal visit(final TroubleNode node, final Void unused) {
        return null;
    }
}

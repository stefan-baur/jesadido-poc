/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tree.visitors;

import org.jesadido.poc.core.scripting.Src;
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

    @Override
    public Src visit(Sentence node, Boolean sugared) {
        return new Src();
    }

    @Override
    public Src visit(SentenceMeat node, Boolean sugared) {
        return new Src();
    }

    @Override
    public Src visit(SentenceMeatConjunction node, Boolean sugared) {
        return new Src();
    }

    @Override
    public Src visit(PartSu node, Boolean sugared) {
        return new Src();
    }

    @Override
    public Src visit(PartDom node, Boolean sugared) {
        return new Src();
    }

    @Override
    public Src visit(PartAl node, Boolean sugared) {
        return new Src();
    }

    @Override
    public Src visit(PartFin node, Boolean sugared) {
        return new Src();
    }

    @Override
    public Src visit(NominalSelection node, Boolean sugared) {
        return new Src();
    }

    @Override
    public Src visit(SubstantiveSelection node, Boolean sugared) {
        return new Src();
    }

    @Override
    public Src visit(VerbalSelection node, Boolean sugared) {
        return new Src();
    }

    @Override
    public Src visit(VerbSelection node, Boolean sugared) {
        return new Src();
    }

    @Override
    public Src visit(TroubleNode node, Boolean sugared) {
        return new Src();
    }
}

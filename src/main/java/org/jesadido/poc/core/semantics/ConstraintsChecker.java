/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics;

import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.syntax.tree.JesadidoNode;
import org.jesadido.poc.core.syntax.tree.JesadidoNodeUtils;
import org.jesadido.poc.core.syntax.tree.TroubleNode;
import org.jesadido.poc.core.syntax.tree.Visitor;
import org.jesadido.poc.core.syntax.tree.sentence.AdjectiveSelection;
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

public class ConstraintsChecker implements Visitor<List<String>, ConceptBook>{
    
    private static final int ADJECTIVES_MAX_COUNT = 3;
    
    public static List<String> check(final JesadidoNode node, final ConceptBook conceptBook) {
        return node.accept(new ConstraintsChecker(), conceptBook);
    }
    
    @Override
    public List<String> visit(final SentenceSequence node, final ConceptBook conceptBook) {
        final List<String> result = new LinkedList<>();
        node.getSentences().stream().forEach(sentence -> result.addAll(sentence.accept(this, conceptBook)));
        return result;
    }

    @Override
    public List<String> visit(final Sentence node, final ConceptBook conceptBook) {
        final List<String> result = new LinkedList<>();
        node.getMeats().stream().forEach(meat -> result.addAll(meat.accept(this, conceptBook)));
        return result;
    }

    @Override
    public List<String> visit(final SentenceMeat node, final ConceptBook conceptBook) {
        final List<String> result = new LinkedList<>();
        if (node.hasConjunction()) {
            result.addAll(node.getConjunction().accept(this, conceptBook));
        }
        final JesadidoNode dom = JesadidoNodeUtils.findFirst(node.getParts(), PartDom.class);
        if (dom != null) {
            ConceptBookEntry conceptBookEntry = conceptBook.get(dom.selectMasterConcept());
            if (!JesadidoNodeUtils.containsAll(node.getParts(), conceptBookEntry.getRequiredPartClasses())) {
                result.add("Required parts are missing.");
            }
            if (!JesadidoNodeUtils.containsNo(node.getParts(), conceptBookEntry.getExcludedPartClasses())) {
                result.add("Excluded parts are used.");
            }
        }
        node.getParts().stream().forEach(part -> result.addAll(part.accept(this, conceptBook)));
        return result;
    }

    @Override
    public List<String> visit(final SentenceMeatConjunction node, final ConceptBook conceptBook) {
        return new LinkedList<>();
    }

    @Override
    public List<String> visit(final PartSu node, final ConceptBook conceptBook) {
        final List<String> result = new LinkedList<>();
        if (node.hasNominalSelection()) {
            result.addAll(node.getNominalSelection().accept(this, conceptBook));
        }
        return result;
    }

    @Override
    public List<String> visit(final PartDom node, final ConceptBook conceptBook) {
        final List<String> result = new LinkedList<>();
        if (node.hasVerbalSelection()) {
            result.addAll(node.getVerbalSelection().accept(this, conceptBook));
        }
        return result;
    }

    @Override
    public List<String> visit(final PartAl node, final ConceptBook conceptBook) {
        final List<String> result = new LinkedList<>();
        if (node.hasNominalSelection()) {
            result.addAll(node.getNominalSelection().accept(this, conceptBook));
        }
        return result;
    }

    @Override
    public List<String> visit(final PartFin node, final ConceptBook conceptBook) {
        final List<String> result = new LinkedList<>();
        if (node.hasNominalSelection()) {
            result.addAll(node.getNominalSelection().accept(this, conceptBook));
        }
        return result;
    }

    @Override
    public List<String> visit(final NominalSelection node, final ConceptBook conceptBook) {
        final List<String> result = new LinkedList<>();
        if (node.hasChildSelection()) {
            result.addAll(node.getChildSelection().accept(this, conceptBook));
        }
        return result;
    }

    @Override
    public List<String> visit(final ArticleSelection node, final ConceptBook conceptBook) {
        final List<String> result = new LinkedList<>();
        if (node.hasSubstantiveSelection()) {
            result.addAll(node.getSubstantiveSelection().accept(this, conceptBook));
        }
        return result;
    }

    @Override
    public List<String> visit(final SubstantiveSelection node, final ConceptBook conceptBook) {
        final List<String> result = new LinkedList<>();
        if (node.getAdjectiveSelections().size() > ADJECTIVES_MAX_COUNT) {
            result.add("Too many adjectives.");
        }
        node.getAdjectiveSelections().stream().forEach(adjectiveSelection -> result.addAll(adjectiveSelection.accept(this, conceptBook)));
        return result;
    }
    
    @Override
    public List<String> visit(final AdjectiveSelection node, final ConceptBook conceptBook) {
        return new LinkedList<>();
    }

    @Override
    public List<String> visit(final VerbalSelection node, final ConceptBook conceptBook) {
        final List<String> result = new LinkedList<>();
        if (node.hasVerbSelection()) {
            result.addAll(node.getVerbSelection().accept(this, conceptBook));
        }
        return result;
    }

    @Override
    public List<String> visit(final VerbSelection node, final ConceptBook conceptBook) {
        return new LinkedList<>();
    }

    @Override
    public List<String> visit(final TroubleNode node, final ConceptBook conceptBook) {
        return new LinkedList<>();
    }
}

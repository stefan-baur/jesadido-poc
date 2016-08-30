/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.de;

import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.StringUtils;
import org.jesadido.poc.core.semantics.ConceptBookEntry;
import org.jesadido.poc.core.semantics.translating.TranslationResult;
import org.jesadido.poc.core.semantics.translating.TranslationTarget;
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
import org.jesadido.poc.core.syntax.tree.sentence.SentenceSequence;
import org.jesadido.poc.core.syntax.tree.sentence.SubstantiveSelection;
import org.jesadido.poc.core.syntax.tree.sentence.VerbSelection;
import org.jesadido.poc.core.syntax.tree.sentence.VerbalSelection;

public class DeVisitor implements Visitor<TranslationResult, DeVisitorArgument> {
    
    private final DeTranslator deTranslator;
    
    public DeVisitor(final DeTranslator deTranslator) {
        this.deTranslator = deTranslator;
    }
    
    @Override
    public TranslationResult visit(final SentenceSequence node, final DeVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        List<String> translatedSentences = new LinkedList<>();
        node.getSentences().stream().forEach(sentence -> translatedSentences.add(sentence.accept(this, argument).getTranslation()));
        return result.setTranslation(String.join(" ", translatedSentences));
    }

    @Override
    public TranslationResult visit(final Sentence node, final DeVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        List<String> translatedMeats = new LinkedList<>();
        for (int i = 0; i < node.getMeats().size(); i++) {
            argument.setSentenceMeatIndex(i);
            translatedMeats.add(node.getMeats().get(i).accept(this, argument).getTranslation());
        }
        return result.setTranslation(StringUtils.up(String.format("%s.", String.join("", translatedMeats))));
    }

    @Override
    public TranslationResult visit(final SentenceMeat node, final DeVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        List<String> translatedParts = new LinkedList<>();
        if (node.hasConjunction()) {
            translatedParts.add(node.getConjunction().accept(this, argument).getTranslation());
        }
        DeUtils.rearrangeParts(node.getParts()).stream().forEach(part -> translatedParts.add(part.accept(this, argument).getTranslation()));
        return result.setTranslation(String.join(" ", translatedParts));
    }
    
    @Override
    public TranslationResult visit(final SentenceMeatConjunction node, final DeVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        final ConceptBookEntry conceptBookEntry = this.deTranslator.getConceptBook().get(node.getConjunction().getConcept());
        List<TranslationTarget> defaultTargets = conceptBookEntry.getDefaultTargets(Language.DE);
        if (defaultTargets.isEmpty()) {
            result.setTranslation(conceptBookEntry.getConceptPhrase());
        } else {
            result.setTranslation(String.format("%s%s", argument.getSentenceMeatIndex() > 0 ? ", " : "", defaultTargets.get(0).getMainPhrase()));
        }
        return result;
    }

    @Override
    public TranslationResult visit(final PartSu node, final DeVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        argument.setCaseAttribute(De.NOMINATIVE);
        return result.setTranslation(node.getNominalSelection().accept(this, argument).getTranslation());
    }

    @Override
    public TranslationResult visit(final PartDom node, final DeVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        return result.setTranslation(node.getVerbalSelection().accept(this, argument).getTranslation());
    }

    @Override
    public TranslationResult visit(final PartAl node, final DeVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        argument.setCaseAttribute(De.DATIVE);
        return result.setTranslation(node.getNominalSelection().accept(this, argument).getTranslation());
    }

    @Override
    public TranslationResult visit(final PartFin node, final DeVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        argument.setCaseAttribute(De.ACCUSATIVE);
        return result.setTranslation(node.getNominalSelection().accept(this, argument).getTranslation());
    }

    @Override
    public TranslationResult visit(final NominalSelection node, final DeVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        if (node.hasSubstantiveSelection()) {
            result.setTranslation(node.getSubstantiveSelection().accept(this, argument).getTranslation());
        }
        return result;
    }

    @Override
    public TranslationResult visit(final SubstantiveSelection node, final DeVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        final ConceptBookEntry conceptBookEntry = this.deTranslator.getConceptBook().get(node.getSubstantive().getConcept());
        List<TranslationTarget> defaultTargets = conceptBookEntry.getDefaultTargets(Language.DE, argument.getCaseAttribute());
        if (defaultTargets.isEmpty()) {
            result.setTranslation(conceptBookEntry.getConceptPhrase());
        } else {
            final TranslationTarget substantiveTarget = defaultTargets.get(0);
            result.setTranslation(String.format("%s %s", DeUtils.getIndefiniteArticle(substantiveTarget, argument.getCaseAttribute()), substantiveTarget.getMainPhrase()));
        }
        return result;
    }

    @Override
    public TranslationResult visit(final VerbalSelection node, final DeVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        if (node.hasVerbSelection()) {
            result.setTranslation(node.getVerbSelection().accept(this, argument).getTranslation());
        }
        return result;
    }

    @Override
    public TranslationResult visit(final VerbSelection node, final DeVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        final ConceptBookEntry conceptBookEntry = this.deTranslator.getConceptBook().get(node.getVerb().getConcept());
        List<TranslationTarget> defaultTargets = conceptBookEntry.getDefaultTargets(Language.DE, De.GXI);
        if (defaultTargets.isEmpty()) {
            result.setTranslation(conceptBookEntry.getConceptPhrase());
        } else {
            result.setTranslation(defaultTargets.get(0).getMainPhrase());
        }
        return result;
    }

    @Override
    public TranslationResult visit(final TroubleNode node, final DeVisitorArgument argument) {
        return new TranslationResult(node);
    }
}

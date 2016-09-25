/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.en;

import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.StringUtils;
import org.jesadido.poc.core.semantics.ConceptBookEntry;
import org.jesadido.poc.core.semantics.translating.TranslationResult;
import org.jesadido.poc.core.semantics.translating.TranslationTarget;
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

public class EnVisitor implements Visitor<TranslationResult, EnVisitorArgument> {
    
    private final EnTranslator enTranslator;
    
    public EnVisitor(final EnTranslator enTranslator) {
        this.enTranslator = enTranslator;
    }
    
    @Override
    public TranslationResult visit(final SentenceSequence node, final EnVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        final List<String> translatedSentences = new LinkedList<>();
        node.getSentences().stream().forEach(sentence -> translatedSentences.add(sentence.accept(this, argument).getTranslation()));
        return result.setTranslation(translatedSentences);
    }

    @Override
    public TranslationResult visit(final Sentence node, final EnVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        final List<String> translatedMeats = new LinkedList<>();
        for (int i = 0; i < node.getMeats().size(); i++) {
            argument.setSentenceMeatIndex(i);
            translatedMeats.add(node.getMeats().get(i).accept(this, argument).getTranslation());
        }
        return result.setTranslation(StringUtils.up(String.format("%s.", String.join("", translatedMeats))));
    }

    @Override
    public TranslationResult visit(final SentenceMeat node, final EnVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        final List<String> translatedParts = new LinkedList<>();
        if (node.hasConjunction()) {
            translatedParts.add(node.getConjunction().accept(this, argument).getTranslation());
        }
        EnUtils.rearrangeParts(node.getParts()).stream().forEach(part -> translatedParts.add(part.accept(this, argument).getTranslation()));
        return result.setTranslation(translatedParts);
    }
    
    @Override
    public TranslationResult visit(final SentenceMeatConjunction node, final EnVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        final ConceptBookEntry conceptBookEntry = this.enTranslator.getConceptBook().get(node.getConjunction().getConcept());
        final List<TranslationTarget> defaultTargets = conceptBookEntry.getDefaultTargets(Language.EN);
        if (defaultTargets.isEmpty()) {
            result.setTranslation(conceptBookEntry.getConceptPhrase());
        } else {
            result.setTranslation(String.format("%s%s", argument.getSentenceMeatIndex() > 0 ? ", " : "", defaultTargets.get(0).getMainPhrase()));
        }
        return result;
    }

    @Override
    public TranslationResult visit(final PartSu node, final EnVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        argument.setCaseAttribute(En.NOMINATIVE);
        return result.setTranslation(node.getNominalSelection().accept(this, argument).getTranslation());
    }

    @Override
    public TranslationResult visit(final PartDom node, final EnVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        return result.setTranslation(node.getVerbalSelection().accept(this, argument).getTranslation());
    }

    @Override
    public TranslationResult visit(final PartAl node, final EnVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        argument.setCaseAttribute(En.DATIVE);
        return result.setTranslation(node.getNominalSelection().accept(this, argument).getTranslation());
    }

    @Override
    public TranslationResult visit(final PartFin node, final EnVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        argument.setCaseAttribute(En.ACCUSATIVE);
        return result.setTranslation(node.getNominalSelection().accept(this, argument).getTranslation());
    }

    @Override
    public TranslationResult visit(final NominalSelection node, final EnVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        argument.setArticle(null);
        if (node.hasChildSelection()) {
            result.setTranslation(node.getChildSelection().accept(this, argument).getTranslation());
        }
        return result;
    }

    @Override
    public TranslationResult visit(final ArticleSelection node, final EnVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        argument.setArticle(node.getArticle());
        if (node.hasSubstantiveSelection()) {
            result.setTranslation(node.getSubstantiveSelection().accept(this, argument).getTranslation());
        }
        return result;
    }

    @Override
    public TranslationResult visit(final SubstantiveSelection node, final EnVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        final ConceptBookEntry conceptBookEntry = this.enTranslator.getConceptBook().get(node.getSubstantive().getConcept());
        final List<TranslationTarget> defaultTargets = conceptBookEntry.getDefaultTargets(Language.EN);
        if (defaultTargets.isEmpty()) {
            result.setTranslation(conceptBookEntry.getConceptPhrase());
        } else if (argument.getArticle() != null) {
            final TranslationTarget substantiveTarget = defaultTargets.get(0);
            result.setTranslation("the", substantiveTarget.getMainPhrase());
        } else {
            final TranslationTarget substantiveTarget = defaultTargets.get(0);
            result.setTranslation(EnUtils.getIndefiniteArticle(substantiveTarget), substantiveTarget.getMainPhrase());
        }
        return result;
    }

    @Override
    public TranslationResult visit(final VerbalSelection node, final EnVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        if (node.hasVerbSelection()) {
            result.setTranslation(node.getVerbSelection().accept(this, argument).getTranslation());
        }
        return result;
    }

    @Override
    public TranslationResult visit(final VerbSelection node, final EnVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        final ConceptBookEntry conceptBookEntry = this.enTranslator.getConceptBook().get(node.getVerb().getConcept());
        final List<TranslationTarget> defaultTargets = conceptBookEntry.getDefaultTargets(Language.EN, En.GXI);
        if (defaultTargets.isEmpty()) {
            result.setTranslation(conceptBookEntry.getConceptPhrase());
        } else {
            result.setTranslation(defaultTargets.get(0).getMainPhrase());
        }
        return result;
    }

    @Override
    public TranslationResult visit(final TroubleNode node, final EnVisitorArgument argument) {
        return new TranslationResult(node);
    }
}

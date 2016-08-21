/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.es;

import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.StringUtils;
import org.jesadido.poc.core.semantics.ConceptBookEntry;
import org.jesadido.poc.core.semantics.TranslationResult;
import org.jesadido.poc.core.semantics.TranslationTarget;
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

public class EsVisitor implements Visitor<TranslationResult, EsVisitorArgument> {
    
    private final EsTranslator esTranslator;
    
    public EsVisitor(final EsTranslator esTranslator) {
        this.esTranslator = esTranslator;
    }
    
    @Override
    public TranslationResult visit(final SentenceSequence node, final EsVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        List<String> translatedSentences = new LinkedList<>();
        node.getSentences().stream().forEach(sentence -> translatedSentences.add(sentence.accept(this, argument).getTranslation()));
        return result.setTranslation(String.join(" ", translatedSentences));
    }

    @Override
    public TranslationResult visit(final Sentence node, final EsVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        List<String> translatedMeats = new LinkedList<>();
        node.getMeats().stream().forEach(meat -> translatedMeats.add(meat.accept(this, argument).getTranslation()));
        return result.setTranslation(StringUtils.up(String.format("%s.", String.join("", translatedMeats))));
    }

    @Override
    public TranslationResult visit(final SentenceMeat node, final EsVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        List<String> translatedParts = new LinkedList<>();
        if (node.hasConjunction()) {
            translatedParts.add(node.getConjunction().accept(this, argument).getTranslation());
        }
        node.getParts().stream().forEach(part -> translatedParts.add(part.accept(this, argument).getTranslation()));
        return result.setTranslation(String.join(" ", translatedParts));
    }
    
    @Override
    public TranslationResult visit(final SentenceMeatConjunction node, final EsVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        final ConceptBookEntry conceptBookEntry = this.esTranslator.getConceptBook().get(node.getConjunction().getConcept());
        List<TranslationTarget> defaultTargets = conceptBookEntry.getDefaultTargets(Language.ES);
        if (defaultTargets.isEmpty()) {
            result.setTranslation(conceptBookEntry.getConceptPhrase());
        } else {
            result.setTranslation(String.format(", %s", defaultTargets.get(0).getPhrase()));
        }
        return result;
    }

    @Override
    public TranslationResult visit(final PartSu node, final EsVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        argument.setCaseAttribute(Es.NOMINATIVE);
        return result.setTranslation(node.getNominalSelection().accept(this, argument).getTranslation());
    }

    @Override
    public TranslationResult visit(final PartDom node, final EsVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        return result.setTranslation(node.getVerbalSelection().accept(this, argument).getTranslation());
    }

    @Override
    public TranslationResult visit(final PartAl node, final EsVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        argument.setCaseAttribute(Es.DATIVE);
        return result.setTranslation(node.getNominalSelection().accept(this, argument).getTranslation());
    }

    @Override
    public TranslationResult visit(final PartFin node, final EsVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        argument.setCaseAttribute(Es.ACCUSATIVE);
        return result.setTranslation(node.getNominalSelection().accept(this, argument).getTranslation());
    }

    @Override
    public TranslationResult visit(final NominalSelection node, final EsVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        if (node.hasSubstantiveSelection()) {
            result.setTranslation(node.getSubstantiveSelection().accept(this, argument).getTranslation());
        }
        return result;
    }

    @Override
    public TranslationResult visit(final SubstantiveSelection node, final EsVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        final ConceptBookEntry conceptBookEntry = this.esTranslator.getConceptBook().get(node.getSubstantive().getConcept());
        List<TranslationTarget> defaultTargets = conceptBookEntry.getDefaultTargets(Language.ES);
        if (defaultTargets.isEmpty()) {
            result.setTranslation(conceptBookEntry.getConceptPhrase());
        } else {
            final TranslationTarget substantiveTarget = defaultTargets.get(0);
            result.setTranslation(String.format("%s%s %s", argument.getCaseAttribute() == Es.DATIVE ? "al " : "", EsUtils.getUndeterminedArticle(substantiveTarget), substantiveTarget.getPhrase()));
        }
        return result;
    }

    @Override
    public TranslationResult visit(final VerbalSelection node, final EsVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        if (node.hasVerbSelection()) {
            result.setTranslation(node.getVerbSelection().accept(this, argument).getTranslation());
        }
        return result;
    }

    @Override
    public TranslationResult visit(final VerbSelection node, final EsVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        final ConceptBookEntry conceptBookEntry = this.esTranslator.getConceptBook().get(node.getVerb().getConcept());
        List<TranslationTarget> defaultTargets = conceptBookEntry.getDefaultTargets(Language.ES, Es.GXI);
        if (defaultTargets.isEmpty()) {
            result.setTranslation(conceptBookEntry.getConceptPhrase());
        } else {
            result.setTranslation(defaultTargets.get(0).getPhrase());
        }
        return result;
    }

    @Override
    public TranslationResult visit(final TroubleNode node, final EsVisitorArgument argument) {
        return new TranslationResult(node);
    }
}

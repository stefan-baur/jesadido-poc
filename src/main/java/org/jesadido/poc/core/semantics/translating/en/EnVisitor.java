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
import org.jesadido.poc.core.StringUtils;
import org.jesadido.poc.core.concepts.ConceptUtils;
import org.jesadido.poc.core.semantics.translating.TranslationResult;
import org.jesadido.poc.core.semantics.translating.TranslationTarget;
import org.jesadido.poc.core.semantics.translating.TransletParameters;
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

public class EnVisitor implements Visitor<TranslationResult, EnVisitorArgument> {
    
    private final EnTranslator enTranslator;
    
    public EnVisitor(final EnTranslator enTranslator) {
        this.enTranslator = enTranslator;
    }
    
    @Override
    public TranslationResult visit(final SentenceSequence node, final EnVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.enTranslator, node);
        final List<String> translatedSentences = new LinkedList<>();
        node.getSentences().stream().forEach(sentence -> translatedSentences.add(sentence.accept(this, argument).getTranslation()));
        return result.setTranslation(translatedSentences);
    }

    @Override
    public TranslationResult visit(final Sentence node, final EnVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.enTranslator, node);
        final List<String> translatedMeats = new LinkedList<>();
        for (int i = 0; i < node.getMeats().size(); i++) {
            argument.setSentenceMeatIndex(i);
            translatedMeats.add(node.getMeats().get(i).accept(this, argument).getTranslation());
        }
        return result.setTranslation(StringUtils.up(String.format("%s%s", String.join("", translatedMeats), ConceptUtils.isEllipsis(node.getTerminator().getConcept()) ? "" : ".")));
    }

    @Override
    public TranslationResult visit(final SentenceMeat node, final EnVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.enTranslator, node);
        final List<String> translatedParts = new LinkedList<>();
        if (node.hasConjunction()) {
            translatedParts.add(node.getConjunction().accept(this, argument).getTranslation());
        }
        EnUtils.rearrangeParts(node.getParts()).stream().forEach(part -> translatedParts.add(part.accept(this, argument).getTranslation()));
        return result.setTranslation(translatedParts);
    }
    
    @Override
    public TranslationResult visit(final SentenceMeatConjunction node, final EnVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.enTranslator, node);
        final TranslationTarget conjunctionTarget = this.enTranslator.getFirstDefaultTarget(node.getConjunction().getConcept());
        if (",".equals(conjunctionTarget.getMainPhrase())) {
            result.setTranslation(conjunctionTarget.getMainPhrase());
        } else {
            result.setTranslation(String.format("%s%s", argument.getSentenceMeatIndex() > 0 ? ", " : "", conjunctionTarget.getMainPhrase()));
        }
        return result;
    }

    @Override
    public TranslationResult visit(final PartSu node, final EnVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.enTranslator, node);
        argument.setCaseAttribute(En.NOMINATIVE);
        return result.setTranslation(node.getNominalSelection().accept(this, argument).getTranslation());
    }

    @Override
    public TranslationResult visit(final PartDom node, final EnVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.enTranslator, node);
        return result.setTranslation(node.getVerbalSelection().accept(this, argument).getTranslation());
    }

    @Override
    public TranslationResult visit(final PartAl node, final EnVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.enTranslator, node);
        argument.setCaseAttribute(En.DATIVE);
        return result.setTranslation(node.getNominalSelection().accept(this, argument).getTranslation());
    }

    @Override
    public TranslationResult visit(final PartFin node, final EnVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.enTranslator, node);
        argument.setCaseAttribute(En.ACCUSATIVE);
        return result.setTranslation(node.getNominalSelection().accept(this, argument).getTranslation());
    }

    @Override
    public TranslationResult visit(final NominalSelection node, final EnVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.enTranslator, node);
        EnTransletors.getNominalTransletor().translate(result, new TransletParameters(argument.getCaseAttribute(), node.collectTerminals()));
        return result;
    }

    @Override
    public TranslationResult visit(final ArticleSelection node, final EnVisitorArgument argument) {
        return new TranslationResult(this.enTranslator, node);
    }

    @Override
    public TranslationResult visit(final SubstantiveSelection node, final EnVisitorArgument argument) {
        return new TranslationResult(this.enTranslator, node);
    }

    @Override
    public TranslationResult visit(final AdjectiveSelection node, final EnVisitorArgument argument) {
        return new TranslationResult(this.enTranslator, node);
    }

    @Override
    public TranslationResult visit(final VerbalSelection node, final EnVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.enTranslator, node);
        if (node.hasVerbSelection()) {
            result.setTranslation(node.getVerbSelection().accept(this, argument).getTranslation());
        }
        return result;
    }

    @Override
    public TranslationResult visit(final VerbSelection node, final EnVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.enTranslator, node);
        final TranslationTarget verbTarget = this.enTranslator.getFirstDefaultTarget(node.getVerb().getConcept(), En.GXI);
        result.setTranslation(verbTarget.getMainPhrase());
        return result;
    }

    @Override
    public TranslationResult visit(final TroubleNode node, final EnVisitorArgument argument) {
        return new TranslationResult(this.enTranslator, node);
    }
}

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.eo;

import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.StringUtils;
import org.jesadido.poc.core.concepts.ConceptUtils;
import org.jesadido.poc.core.semantics.translating.TranslationResult;
import org.jesadido.poc.core.semantics.translating.TranslationTarget;
import org.jesadido.poc.core.semantics.translating.TransletParameters;
import org.jesadido.poc.core.syntax.tree.JesadidoNode;
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

public class EoVisitor implements Visitor<TranslationResult, EoVisitorArgument> {
    
    private final EoTranslator eoTranslator;
    
    public EoVisitor(final EoTranslator eoTranslator) {
        this.eoTranslator = eoTranslator;
    }
    
    @Override
    public TranslationResult visit(final SentenceSequence node, final EoVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.eoTranslator, node);
        final List<String> translatedSentences = new LinkedList<>();
        final List<JesadidoNode> sentences = node.getSentences();
        for (int i = 0; i < sentences.size(); i++) {
            argument.setNextSentence(i < sentences.size() - 1);
            translatedSentences.add(sentences.get(i).accept(this, argument).getTranslation());
        }
        return result.setTranslation(translatedSentences);
    }

    @Override
    public TranslationResult visit(final Sentence node, final EoVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.eoTranslator, node);
        argument.setIsEllipsis(ConceptUtils.isEllipsis(node.getTerminator().getConcept()));
        argument.setSentenceMeatCount(node.getMeats().size());
        final List<String> translatedMeats = new LinkedList<>();
        for (int i = 0; i < node.getMeats().size(); i++) {
            argument.setSentenceMeatIndex(i);
            translatedMeats.add(node.getMeats().get(i).accept(this, argument).getTranslation());
        }
        final String sentenceTerminator = argument.getIsEllipsis() ? (argument.getNextSentence() ? ";" : "") : ".";
        return result.setTranslation(StringUtils.up(String.format("%s%s", String.join("", translatedMeats), sentenceTerminator)));
    }

    @Override
    public TranslationResult visit(final SentenceMeat node, final EoVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.eoTranslator, node);
        argument.setPartCount(node.getParts().size());
        final List<String> translatedParts = new LinkedList<>();
        if (node.hasConjunction()) {
            translatedParts.add(node.getConjunction().accept(this, argument).getTranslation());
        }
        EoUtils.rearrangeParts(node.getParts()).stream().forEach(part -> translatedParts.add(part.accept(this, argument).getTranslation()));
        return result.setTranslation(translatedParts);
    }
    
    @Override
    public TranslationResult visit(final SentenceMeatConjunction node, final EoVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.eoTranslator, node);
        final TranslationTarget conjunctionTarget = this.eoTranslator.getFirstDefaultTarget(node.getConjunction().getConcept());
        if (",".equals(conjunctionTarget.getMainPhrase())) {
            result.setTranslation(conjunctionTarget.getMainPhrase());
        } else {
            result.setTranslation(String.format("%s%s", argument.getSentenceMeatIndex() > 0 ? ", " : "", conjunctionTarget.getMainPhrase()));
        }
        return result;
    }

    @Override
    public TranslationResult visit(final PartSu node, final EoVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.eoTranslator, node);
        if (!argument.getIsEllipsis() && argument.getSentenceMeatCount() == 1 && argument.getPartCount() == 1) {
            return result.setTranslation(String.format("%s eksistas", node.getNominalSelection().accept(this, argument).getTranslation()));
        } else {
            return result.setTranslation(node.getNominalSelection().accept(this, argument).getTranslation());
        }
    }

    @Override
    public TranslationResult visit(final PartDom node, final EoVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.eoTranslator, node);
        return result.setTranslation(node.getVerbalSelection().accept(this, argument).getTranslation());
    }

    @Override
    public TranslationResult visit(final PartAl node, final EoVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.eoTranslator, node);
        return result.setTranslation("al", node.getNominalSelection().accept(this, argument).getTranslation());
    }

    @Override
    public TranslationResult visit(final PartFin node, final EoVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.eoTranslator, node);
        argument.setCaseAttribute(Eo.ACCUSATIVE);
        result.setTranslation(node.getNominalSelection().accept(this, argument).getTranslation());
        argument.setCaseAttribute(null);
        return result;
    }

    @Override
    public TranslationResult visit(final NominalSelection node, final EoVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.eoTranslator, node);
        EoTransletors.getNominalTransletor().translate(result, new TransletParameters(argument.getCaseAttribute(), node.collectTerminals()));
        return result;
    }

    @Override
    public TranslationResult visit(final ArticleSelection node, final EoVisitorArgument argument) {
        return new TranslationResult(this.eoTranslator, node);
    }

    @Override
    public TranslationResult visit(final SubstantiveSelection node, final EoVisitorArgument argument) {
        return new TranslationResult(this.eoTranslator, node);
    }

    @Override
    public TranslationResult visit(final AdjectiveSelection node, final EoVisitorArgument argument) {
        return new TranslationResult(this.eoTranslator, node);
    }

    @Override
    public TranslationResult visit(final VerbalSelection node, final EoVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.eoTranslator, node);
        if (node.hasVerbSelection()) {
            result.setTranslation(node.getVerbSelection().accept(this, argument).getTranslation());
        }
        return result;
    }

    @Override
    public TranslationResult visit(final VerbSelection node, final EoVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.eoTranslator, node);
        final TranslationTarget verbTarget = this.eoTranslator.getFirstDefaultTarget(node.getVerb().getConcept());
        result.setTranslation(verbTarget.getMainPhrase());
        return result;
    }

    @Override
    public TranslationResult visit(final TroubleNode node, final EoVisitorArgument argument) {
        return new TranslationResult(this.eoTranslator, node);
    }
}

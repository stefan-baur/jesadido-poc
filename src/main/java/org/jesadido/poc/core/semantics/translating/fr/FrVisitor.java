/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.fr;

import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.StringUtils;
import org.jesadido.poc.core.concepts.ConceptUtils;
import org.jesadido.poc.core.semantics.translating.TranslationResult;
import org.jesadido.poc.core.semantics.translating.TranslationTarget;
import org.jesadido.poc.core.semantics.translating.TransletParameters;
import org.jesadido.poc.core.syntax.tokens.TokenType;
import org.jesadido.poc.core.syntax.tree.Node;
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

public class FrVisitor implements Visitor<TranslationResult, FrVisitorArgument> {
    
    private final FrTranslator frTranslator;
    
    public FrVisitor(final FrTranslator frTranslator) {
        this.frTranslator = frTranslator;
    }
    
    @Override
    public TranslationResult visit(final SentenceSequence node, final FrVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.frTranslator, node);
        final List<String> translatedSentences = new LinkedList<>();
        final List<Node> sentences = node.getSentences();
        for (int i = 0; i < sentences.size(); i++) {
            argument.setNextSentence(i < sentences.size() - 1);
            translatedSentences.add(sentences.get(i).accept(this, argument).getTranslation());
        }
        return result.setTranslation(translatedSentences);
    }

    @Override
    public TranslationResult visit(final Sentence node, final FrVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.frTranslator, node);
        final List<String> translatedMeats = new LinkedList<>();
        for (int i = 0; i < node.getMeats().size(); i++) {
            argument.setSentenceMeatIndex(i);
            translatedMeats.add(node.getMeats().get(i).accept(this, argument).getTranslation());
        }
        String sentenceTerminator = ".";
        if (ConceptUtils.isEllipsis(node.getTerminator().getConcept())) {
            sentenceTerminator = argument.getNextSentence() ? ";" : "";
        }
        return result.setTranslation(StringUtils.up(String.format("%s%s", String.join("", translatedMeats), sentenceTerminator)));
    }

    @Override
    public TranslationResult visit(final SentenceMeat node, final FrVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.frTranslator, node);
        final List<String> translatedParts = new LinkedList<>();
        if (node.hasConjunction()) {
            translatedParts.add(node.getConjunction().accept(this, argument).getTranslation());
        }
        FrUtils.rearrangeParts(node.getParts()).stream().forEach(part -> translatedParts.add(part.accept(this, argument).getTranslation()));
        return result.setTranslation(translatedParts);
    }
    
    @Override
    public TranslationResult visit(final SentenceMeatConjunction node, final FrVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.frTranslator, node);
        final TranslationTarget conjunctionTarget = this.frTranslator.getFirstDefaultTarget(node.getConjunction().getConcept());
        if (",".equals(conjunctionTarget.getMainPhrase())) {
            result.setTranslation(conjunctionTarget.getMainPhrase());
        } else if (node.getConjunction().getToken().getType() == TokenType.SEPARATOR_SE) {
            result.setTranslation(String.format("%s%s", argument.getSentenceMeatIndex() > 0 ? ", " : "", conjunctionTarget.getMainPhrase()));
        } else {
            result.setTranslation(String.format("%s%s", argument.getSentenceMeatIndex() > 0 ? " " : "", conjunctionTarget.getMainPhrase()));
        }
        return result;
    }

    @Override
    public TranslationResult visit(final PartSu node, final FrVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.frTranslator, node);
        argument.setCaseAttribute(Fr.NOMINATIVE);
        return result.setTranslation(node.getNominalSelection().accept(this, argument).getTranslation());
    }

    @Override
    public TranslationResult visit(final PartDom node, final FrVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.frTranslator, node);
        return result.setTranslation(node.getVerbalSelection().accept(this, argument).getTranslation());
    }

    @Override
    public TranslationResult visit(final PartAl node, final FrVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.frTranslator, node);
        argument.setCaseAttribute(Fr.DATIVE);
        return result.setTranslation(node.getNominalSelection().accept(this, argument).getTranslation());
    }

    @Override
    public TranslationResult visit(final PartFin node, final FrVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.frTranslator, node);
        argument.setCaseAttribute(Fr.ACCUSATIVE);
        return result.setTranslation(node.getNominalSelection().accept(this, argument).getTranslation());
    }

    @Override
    public TranslationResult visit(final NominalSelection node, final FrVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.frTranslator, node);
        FrTransletors.getNominalTransletor().translate(result, new TransletParameters(argument.getCaseAttribute(), node.collectTerminals()));
        return result;
    }

    @Override
    public TranslationResult visit(final ArticleSelection node, final FrVisitorArgument argument) {
        return new TranslationResult(this.frTranslator, node);
    }

    @Override
    public TranslationResult visit(final SubstantiveSelection node, final FrVisitorArgument argument) {
        return new TranslationResult(this.frTranslator, node);
    }

    @Override
    public TranslationResult visit(final AdjectiveSelection node, final FrVisitorArgument argument) {
        return new TranslationResult(this.frTranslator, node);
    }

    @Override
    public TranslationResult visit(final VerbalSelection node, final FrVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.frTranslator, node);
        if (node.hasVerbSelection()) {
            result.setTranslation(node.getVerbSelection().accept(this, argument).getTranslation());
        }
        return result;
    }

    @Override
    public TranslationResult visit(final VerbSelection node, final FrVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.frTranslator, node);
        final TranslationTarget verbTarget = this.frTranslator.getFirstDefaultTarget(node.getVerb().getConcept(), Fr.GXI);
        result.setTranslation(verbTarget.getMainPhrase());
        return result;
    }

    @Override
    public TranslationResult visit(final TroubleNode node, final FrVisitorArgument argument) {
        return new TranslationResult(this.frTranslator, node);
    }
}

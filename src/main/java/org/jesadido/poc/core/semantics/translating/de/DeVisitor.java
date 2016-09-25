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
import org.jesadido.poc.core.StringUtils;
import org.jesadido.poc.core.semantics.translating.TranslationResult;
import org.jesadido.poc.core.semantics.translating.TranslationTarget;
import org.jesadido.poc.core.syntax.tokens.TokenType;
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
        return result.setTranslation(translatedSentences);
    }

    @Override
    public TranslationResult visit(final Sentence node, final DeVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        argument.setConditionalMeatB(false);
        argument.setConditionalMeatA(false);
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
        argument.setConditionalMeatB(argument.getConditionalMeatA());
        argument.setConditionalMeatA(false);
        if (node.hasConjunction()) {
            translatedParts.add(node.getConjunction().accept(this, argument).getTranslation());
        }
        if (argument.getConditionalMeatA()) {
            DeUtils.rearrangeConditionalMeatAParts(node.getParts()).stream().forEach(part -> translatedParts.add(part.accept(this, argument).getTranslation()));
        } else if (argument.getConditionalMeatB()) {
            DeUtils.rearrangeConditionalMeatBParts(node.getParts()).stream().forEach(part -> translatedParts.add(part.accept(this, argument).getTranslation()));
        } else {
            DeUtils.rearrangeParts(node.getParts()).stream().forEach(part -> translatedParts.add(part.accept(this, argument).getTranslation()));
        }
        return result.setTranslation(translatedParts);
    }
    
    @Override
    public TranslationResult visit(final SentenceMeatConjunction node, final DeVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        argument.setConditionalMeatA(node.getConjunction().getToken().getType() == TokenType.SEPARATOR_SE);
        final TranslationTarget conjunctionTarget = this.deTranslator.getFirstDefaultTarget(node.getConjunction().getConcept());
        if (",".equals(conjunctionTarget.getMainPhrase())) {
            result.setTranslation(conjunctionTarget.getMainPhrase());
        } else {
            result.setTranslation(String.format("%s%s", argument.getSentenceMeatIndex() > 0 ? ", " : "", conjunctionTarget.getMainPhrase()));
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
        argument.setArticle(null);
        if (node.hasChildSelection()) {
            result.setTranslation(node.getChildSelection().accept(this, argument).getTranslation());
        }
        return result;
    }

    @Override
    public TranslationResult visit(final ArticleSelection node, final DeVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        argument.setArticle(node.getArticle());
        if (node.hasSubstantiveSelection()) {
            result.setTranslation(node.getSubstantiveSelection().accept(this, argument).getTranslation());
        }
        return result;
    }

    @Override
    public TranslationResult visit(final SubstantiveSelection node, final DeVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(node);
        final TranslationTarget substantiveTarget = this.deTranslator.getFirstDefaultTarget(node.getSubstantive().getConcept(), argument.getCaseAttribute());
        if (argument.getArticle() != null) {
            result.setTranslation(DeUtils.getDefiniteArticle(substantiveTarget, argument.getCaseAttribute()), substantiveTarget.getMainPhrase());
        } else {
            result.setTranslation(DeUtils.getIndefiniteArticle(substantiveTarget, argument.getCaseAttribute()), substantiveTarget.getMainPhrase());
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
        final TranslationTarget verbTarget = this.deTranslator.getFirstDefaultTarget(node.getVerb().getConcept(), De.GXI);
        result.setTranslation(verbTarget.getMainPhrase());
        return result;
    }

    @Override
    public TranslationResult visit(final TroubleNode node, final DeVisitorArgument argument) {
        return new TranslationResult(node);
    }
}

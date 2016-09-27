/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.es;

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

public class EsVisitor implements Visitor<TranslationResult, EsVisitorArgument> {
    
    private final EsTranslator esTranslator;
    
    public EsVisitor(final EsTranslator esTranslator) {
        this.esTranslator = esTranslator;
    }
    
    @Override
    public TranslationResult visit(final SentenceSequence node, final EsVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.esTranslator, node);
        final List<String> translatedSentences = new LinkedList<>();
        node.getSentences().stream().forEach(sentence -> translatedSentences.add(sentence.accept(this, argument).getTranslation()));
        return result.setTranslation(translatedSentences);
    }

    @Override
    public TranslationResult visit(final Sentence node, final EsVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.esTranslator, node);
        final List<String> translatedMeats = new LinkedList<>();
        for (int i = 0; i < node.getMeats().size(); i++) {
            argument.setSentenceMeatIndex(i);
            translatedMeats.add(node.getMeats().get(i).accept(this, argument).getTranslation());
        }
        return result.setTranslation(StringUtils.up(String.format("%s.", String.join("", translatedMeats))));
    }

    @Override
    public TranslationResult visit(final SentenceMeat node, final EsVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.esTranslator, node);
        final List<String> translatedParts = new LinkedList<>();
        if (node.hasConjunction()) {
            translatedParts.add(node.getConjunction().accept(this, argument).getTranslation());
        }
        EsUtils.rearrangeParts(node.getParts()).stream().forEach(part -> translatedParts.add(part.accept(this, argument).getTranslation()));
        return result.setTranslation(translatedParts);
    }
    
    @Override
    public TranslationResult visit(final SentenceMeatConjunction node, final EsVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.esTranslator, node);
        final TranslationTarget conjunctionTarget = this.esTranslator.getFirstDefaultTarget(node.getConjunction().getConcept());
        if (",".equals(conjunctionTarget.getMainPhrase())) {
            result.setTranslation(conjunctionTarget.getMainPhrase());
        } else if (node.getConjunction().getToken().getType() == TokenType.SEPARATOR_SE) {
            result.setTranslation(String.format("%s%s", argument.getSentenceMeatIndex() > 0 ? " " : "", conjunctionTarget.getMainPhrase()));
        } else {
            result.setTranslation(String.format("%s%s", argument.getSentenceMeatIndex() > 0 ? ", " : "", conjunctionTarget.getMainPhrase()));
        }
        return result;
    }

    @Override
    public TranslationResult visit(final PartSu node, final EsVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.esTranslator, node);
        argument.setCaseAttribute(Es.NOMINATIVE);
        return result.setTranslation(node.getNominalSelection().accept(this, argument).getTranslation());
    }

    @Override
    public TranslationResult visit(final PartDom node, final EsVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.esTranslator, node);
        return result.setTranslation(node.getVerbalSelection().accept(this, argument).getTranslation());
    }

    @Override
    public TranslationResult visit(final PartAl node, final EsVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.esTranslator, node);
        argument.setCaseAttribute(Es.DATIVE);
        return result.setTranslation(node.getNominalSelection().accept(this, argument).getTranslation());
    }

    @Override
    public TranslationResult visit(final PartFin node, final EsVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.esTranslator, node);
        argument.setCaseAttribute(Es.ACCUSATIVE);
        return result.setTranslation(node.getNominalSelection().accept(this, argument).getTranslation());
    }

    @Override
    public TranslationResult visit(final NominalSelection node, final EsVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.esTranslator, node);
        argument.setArticle(null);
        if (node.hasChildSelection()) {
            result.setTranslation(node.getChildSelection().accept(this, argument).getTranslation());
        }
        return result;
    }
    
    @Override
    public TranslationResult visit(final ArticleSelection node, final EsVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.esTranslator, node);
        argument.setArticle(node.getArticle());
        if (node.hasSubstantiveSelection()) {
            result.setTranslation(node.getSubstantiveSelection().accept(this, argument).getTranslation());
        }
        return result;
    }

    @Override
    public TranslationResult visit(final SubstantiveSelection node, final EsVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.esTranslator, node);
        final TranslationTarget substantiveTarget = this.esTranslator.getFirstDefaultTarget(node.getSubstantive().getConcept());
        if (argument.getArticle() != null) {
            result.setTranslation(EsUtils.getDefiniteArticle(substantiveTarget, argument.getCaseAttribute()), substantiveTarget.getMainPhrase());
        } else {
            result.setTranslation(String.format("%s%s %s", argument.getCaseAttribute() == Es.DATIVE ? "a " : "", EsUtils.getIndefiniteArticle(substantiveTarget), substantiveTarget.getMainPhrase()));
        }
        return result;
    }

    @Override
    public TranslationResult visit(final VerbalSelection node, final EsVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.esTranslator, node);
        if (node.hasVerbSelection()) {
            result.setTranslation(node.getVerbSelection().accept(this, argument).getTranslation());
        }
        return result;
    }

    @Override
    public TranslationResult visit(final VerbSelection node, final EsVisitorArgument argument) {
        final TranslationResult result = new TranslationResult(this.esTranslator, node);
        final TranslationTarget verbTarget = this.esTranslator.getFirstDefaultTarget(node.getVerb().getConcept(), Es.GXI);
        result.setTranslation(verbTarget.getMainPhrase());
        return result;
    }

    @Override
    public TranslationResult visit(final TroubleNode node, final EsVisitorArgument argument) {
        return new TranslationResult(this.esTranslator, node);
    }
}

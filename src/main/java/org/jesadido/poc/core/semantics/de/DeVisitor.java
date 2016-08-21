/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.de;

import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.StringUtils;
import org.jesadido.poc.core.semantics.ConceptBookEntry;
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

public class DeVisitor implements Visitor<String, DeVisitorArgument> {
    
    private final DeTranslator deTranslator;
    
    public DeVisitor(final DeTranslator deTranslator) {
        this.deTranslator = deTranslator;
    }
    
    @Override
    public String visit(final SentenceSequence node, final DeVisitorArgument argument) {
        List<String> translatedSentences = new LinkedList<>();
        node.getSentences().stream().forEach(sentence -> translatedSentences.add(sentence.accept(this, argument)));
        return String.join(" ", translatedSentences);
    }

    @Override
    public String visit(final Sentence node, final DeVisitorArgument argument) {
        List<String> translatedMeats = new LinkedList<>();
        node.getMeats().stream().forEach(meat -> translatedMeats.add(meat.accept(this, argument)));
        return StringUtils.up(String.format("%s.", String.join("", translatedMeats)));
    }

    @Override
    public String visit(final SentenceMeat node, final DeVisitorArgument argument) {
        List<String> translatedParts = new LinkedList<>();
        if (node.hasConjunction()) {
            translatedParts.add(node.getConjunction().accept(this, argument));
        }
        node.getParts().stream().forEach(part -> translatedParts.add(part.accept(this, argument)));
        return String.join(" ", translatedParts);
    }

    @Override
    public String visit(final SentenceMeatConjunction node, final DeVisitorArgument argument) {
        final ConceptBookEntry cbe = this.deTranslator.getConceptBook().get(node.getConjunction().getConcept());
        List<TranslationTarget> defaultTargets = cbe.getDefaultTargets(Language.DE);
        if (defaultTargets.isEmpty()) {
            return cbe.getConceptPhrase();
        } else {
            return String.format(", %s", defaultTargets.get(0).getPhrase());
        }
    }

    @Override
    public String visit(final PartSu node, final DeVisitorArgument argument) {
        argument.setCaseAttribute(De.NOMINATIVE);
        return node.getNominalSelection().accept(this, argument);
    }

    @Override
    public String visit(final PartDom node, final DeVisitorArgument argument) {
        return node.getVerbalSelection().accept(this, argument);
    }

    @Override
    public String visit(final PartAl node, final DeVisitorArgument argument) {
        argument.setCaseAttribute(De.DATIVE);
        return node.getNominalSelection().accept(this, argument);
    }

    @Override
    public String visit(final PartFin node, final DeVisitorArgument argument) {
        argument.setCaseAttribute(De.ACCUSATIVE);
        return node.getNominalSelection().accept(this, argument);
    }

    @Override
    public String visit(final NominalSelection node, final DeVisitorArgument argument) {
        return node.getSubstantiveSelection().accept(this, argument);
    }

    @Override
    public String visit(final SubstantiveSelection node, final DeVisitorArgument argument) {
        final ConceptBookEntry cbe = this.deTranslator.getConceptBook().get(node.getSubstantive().getConcept());
        List<TranslationTarget> defaultTargets = cbe.getDefaultTargets(Language.DE, argument.getCaseAttribute());
        if (defaultTargets.isEmpty()) {
            return cbe.getConceptPhrase();
        } else {
            final TranslationTarget substantiveTarget = defaultTargets.get(0);
            return String.format("%s %s", DeUtils.getUndeterminedArticle(substantiveTarget, argument.getCaseAttribute()), substantiveTarget.getPhrase());
        }
    }

    @Override
    public String visit(final VerbalSelection node, final DeVisitorArgument argument) {
        return node.getVerbSelection().accept(this, argument);
    }

    @Override
    public String visit(final VerbSelection node, final DeVisitorArgument argument) {
        final ConceptBookEntry cbe = this.deTranslator.getConceptBook().get(node.getVerb().getConcept());
        List<TranslationTarget> defaultTargets = cbe.getDefaultTargets(Language.DE, De.GXI);
        if (defaultTargets.isEmpty()) {
            return cbe.getConceptPhrase();
        } else {
            return defaultTargets.get(0).getPhrase();
        }
    }

    @Override
    public String visit(final TroubleNode node, final DeVisitorArgument argument) {
        return "";
    }
}

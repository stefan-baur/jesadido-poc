/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating;

import java.util.List;
import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.semantics.ConceptBook;
import org.jesadido.poc.core.semantics.ConstraintsChecker;
import org.jesadido.poc.core.syntax.tree.Node;

public abstract class Translator {
    
    private final Language language;
    private final ConceptBook conceptBook;
    
    public Translator(final Language language, final ConceptBook conceptBook) {
        this.language = language;
        this.conceptBook = conceptBook;
    }
    
    public Language getLanguage() {
        return this.language;
    }
    
    public ConceptBook getConceptBook() {
        return this.conceptBook;
    }
    
    public TranslationResult translate(final String code) {
        final Node node = this.getConceptBook().getGrammar().parse(code);
        final TranslationResult result = new TranslationResult(node);
        result.addParsingTroubles(node.collectTroubles());
        if (!result.hasParsingTroubles()) {
            result.addConstraintsTroubles(ConstraintsChecker.check(node, this.getConceptBook()));
            if (!result.hasConstraintsTroubles()) {
                return this.translate(node);
            }
        }
        return result;
    }
    
    public abstract TranslationResult translate(final Node validatedNode);
    
    public List<TranslationTarget> getDefaultTargets(final Concept concept, final Object ... attributes) {
        return this.getConceptBook().get(concept).getDefaultTargets(this.getLanguage(), attributes);
    }
    
    public TranslationTarget getFirstDefaultTarget(final Concept concept, final Object ... attributes) {
        List<TranslationTarget> defaultTargets = this.getDefaultTargets(concept, attributes);
        if (defaultTargets.isEmpty()) {
            return new TranslationTarget(Language.JI, concept.getFullPhrase());
        } else {
            return defaultTargets.get(0);
        }
    }
}

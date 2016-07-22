/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.concepts;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import org.jesadido.poc.core.CoreUtils;

/**
 * This <code>ConceptBuilder</code> class is used to build the concept
 * parameters on the basis of given morphemes. It's a class for the
 * precalculation to get more efficient usage of concept instances.
 */
public final class ConceptBuilder {
    
    private static final Logger LOGGER = Logger.getLogger(ConceptBuilder.class.getName());
    
    private final List<String> morphemes;
    private final List<String> baseMorphemes;
    private final List<String> referenceMorphemes;
    private final String basePhrase;
    private final Concept referenceConcept;
    
    /**
     * This class constructor uses a morpheme list to define needful concept
     * properties.
     * @param morphemes The morpheme list.
     */
    public ConceptBuilder(final List<String> morphemes) {
        this.morphemes = CoreUtils.up(morphemes);
        this.baseMorphemes = new LinkedList<>();
        this.referenceMorphemes = new LinkedList<>();
        boolean base = true;
        for (int i = this.morphemes.size() - 1; i >= 0; i--) {
            final String morpheme = this.morphemes.get(i);
            if (base) {
                if ("$".equals(morpheme)) {
                    base = false;
                } else {
                    this.baseMorphemes.add(0, CoreUtils.up(morpheme));
                }
            } else {
                this.referenceMorphemes.add(0, CoreUtils.up(morpheme));
            }
        }
        final StringBuilder basePhraseBuilder = new StringBuilder();
        this.baseMorphemes.stream().forEach(basePhraseBuilder::append);
        this.basePhrase = basePhraseBuilder.toString();
        this.referenceConcept = this.referenceMorphemes.isEmpty() ? null : ConceptRegistry.getInstance().getConcept(this.referenceMorphemes);
    }
    
    /**
     * Returns the prefixed reference concept suffixed by the last occurrence of
     * the morpheme <b>$</b>.
     * @return The reference concept.
     */
    public final Concept buildReferenceConcept() {
        return this.referenceConcept;
    }
    
    /**
     * Returns the base morphemes without any reference morphemes.
     * @return The base morphemes.
     */
    public final List<String> buildBaseMorphemes() {
        return this.baseMorphemes;
    }
    
    /**
     * Returns the concatenation of the base morphemes as lexeme.
     * @return The base lexeme.
     */
    public final String buildBasePhrase() {
        return this.basePhrase;
    }
    
    /**
     * Returns the concatenation of all given morphemes.
     * @return The full lexeme.
     */
    public final String buildFullPhrase() {
        final StringBuilder result = new StringBuilder();
        if (this.referenceConcept != null) {
            result.append(this.referenceConcept.getFullPhrase()).append("$");
        }
        result.append(this.buildBasePhrase());
        return result.toString();
    }
    
    /**
     * Return the calculated properties according all given morphemes.
     * @return The concept properties.
     */
    public final ConceptProperties buildProperties() {
        final ConceptProperties result = new ConceptProperties();
        this.baseMorphemes.stream().filter(morpheme -> ConceptUtils.isLanguageMorpheme(morpheme)).forEach(morpheme -> result.setParameterLanguage(ConceptUtils.parseToLanguage(morpheme)));
        this.baseMorphemes.stream().filter(morpheme -> ConceptUtils.isParameterMorpheme(morpheme)).forEach(morpheme -> result.setParameterPlainTextList(ConceptUtils.parseToPlainTextList(morpheme)));
        if (result.hasParameter()) {
            result.setParameterType(ConceptParameterType.get(this.basePhrase));
        }
        result.setTermination(ConceptTermination.get(this.basePhrase));
        if (result.getTermination() == ConceptTermination.USER_DEFINED) {
            LOGGER.warning(String.format("The phrase \"%s\" has no supported concept termination.", this.basePhrase));
        }
        result.setPlural(result.getTermination().isOneOf(
                ConceptTermination.O_J,
                ConceptTermination.A_J,
                ConceptTermination.E_J,
                ConceptTermination.NI,
                ConceptTermination.VI,
                ConceptTermination.ILI));
        return result;
    }
}

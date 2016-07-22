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
import org.jesadido.poc.core.Language;

/**
 * This <code>ConceptProperties</code> class is a kind of bean containing all
 * required concept properties for further processings, such as the translation
 * process or the parsing process.
 */
public final class ConceptProperties {
    
    private ConceptTermination termination = ConceptTermination.USER_DEFINED;
    private boolean plural = false;
    private List<String> parameterPlainTextList = new LinkedList<>();
    private Language parameterLanguage = Language.JI;
    private ConceptParameterType parameterType = ConceptParameterType.NONE;
    
    /**
     * Returns the concept termination, the syntactical information of the
     * concept, which is required for the parsing process.
     * @return The concept termination.
     */
    public final ConceptTermination getTermination() {
        return this.termination;
    }
    
    /**
     * Sets the concept termination.
     * @param value The concept termination.
     */
    public final void setTermination(final ConceptTermination value) {
        this.termination = value;
    }
    
    /**
     * Indicates whether the concept is plural by itself.
     * @return <code>true</code> if the concept is plural.
     */
    public final boolean isPlural() {
        return this.plural;
    }
    
    /**
     * Sets the plural information.
     * @param value The plural information.
     */
    public final void setPlural(final boolean value) {
        this.plural = value;
    }
    
    /**
     * Indicates whether the concept contains a parameter.
     * @return <code>true</code> if the concept contains a parameter.
     */
    public final boolean hasParameter() {
        return !this.parameterPlainTextList.isEmpty();
    }
    
    /**
     * Returns the parameter as a list of plain text phrases.
     * @return The parameter as a list of plain text phrases (never null).
     */
    public final List<String> getParameterPlainTextList() {
        return this.parameterPlainTextList;
    }
    
    /**
     * Sets the parameter as a list of plain text phrases.
     * @param list The parameter as a list of plain text phrases.
     */
    public final void setParameterPlainTextList(final List<String> list) {
        if (list == null) {
            this.parameterPlainTextList = new LinkedList<>();
        } else {
            this.parameterPlainTextList = list;
        }
    }
    
    /**
     * Returns the language of the parameter.
     * @return The language of the parameter.
     */
    public Language getParameterLanguage() {
        return this.parameterLanguage;
    }
    
    /**
     * Sets the language of the parameter.
     * @param value Teh language of the parameter.
     */
    public final void setParameterLanguage(final Language value) {
        this.parameterLanguage = value;
    }
    
    /**
     * Returns the type of the parameter.
     * @return The type of the parameter.
     */
    public final ConceptParameterType getParameterType() {
        return this.parameterType;
    }
    
    /**
     * Sets the type of the parameter.
     * @param value The type of the parameter.
     */
    public final void setParameterType(final ConceptParameterType value) {
        this.parameterType = value;
    }
}

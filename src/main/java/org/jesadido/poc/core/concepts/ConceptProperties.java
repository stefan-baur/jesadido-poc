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

public final class ConceptProperties {
    
    private ConceptTermination termination = ConceptTermination.UNKNOWN;
    private boolean plural = false;
    private List<String> parameterPlainList = new LinkedList<>();
    private Language parameterLanguage = Language.JI;
    private ConceptParameterType parameterType = ConceptParameterType.NONE;
    
    public final ConceptTermination getTermination() {
        return this.termination;
    }
    
    public final void setTermination(final ConceptTermination value) {
        this.termination = value;
    }
    
    public final boolean isPlural() {
        return this.plural;
    }
    
    public final void setPlural(final boolean value) {
        this.plural = value;
    }
    
    public final boolean hasParameter() {
        return !this.parameterPlainList.isEmpty();
    }
    
    public final List<String> getParameterPlainList() {
        return this.parameterPlainList;
    }
    
    public final void setParameterPlainList(final List<String> list) {
        this.parameterPlainList = list;
    }
    
    public Language getParameterLanguage() {
        return this.parameterLanguage;
    }
    
    public final void setParameterLanguage(final Language value) {
        this.parameterLanguage = value;
    }
    
    public final ConceptParameterType getParameterType() {
        return this.parameterType;
    }
    
    public final void setParameterType(final ConceptParameterType value) {
        this.parameterType = value;
    }
}

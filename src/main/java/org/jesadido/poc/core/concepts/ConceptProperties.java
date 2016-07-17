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
    
    private ConceptTermination termination;
    private boolean plural;
    private List<String> parameterPlainList;
    private Language parameterLanguage;
    private ConceptParameterType parameterType;
    
    public ConceptProperties() {
        this.termination = ConceptTermination.UNKNOWN;
        this.plural = false;
        this.parameterPlainList = new LinkedList<>();
        this.parameterLanguage = Language.JI;
        this.parameterType = ConceptParameterType.NONE;
    }
    
    public ConceptTermination getTermination() {
        return this.termination;
    }
    
    public void setTermination(ConceptTermination value) {
        this.termination = value;
    }
    
    public boolean isPlural() {
        return this.plural;
    }
    
    public void setPlural(boolean value) {
        this.plural = value;
    }
    
    public boolean hasParameter() {
        return !this.parameterPlainList.isEmpty();
    }
    
    public List<String> getParameterPlainList() {
        return this.parameterPlainList;
    }
    
    public void setParameterPlainList(List<String> list) {
        this.parameterPlainList = list;
    }
    
    public Language getParameterLanguage() {
        return this.parameterLanguage;
    }
    
    public void setParameterLanguage(Language value) {
        this.parameterLanguage = value;
    }
    
    public ConceptParameterType getParameterType() {
        return this.parameterType;
    }
    
    public void setParameterType(ConceptParameterType value) {
        this.parameterType = value;
    }
}

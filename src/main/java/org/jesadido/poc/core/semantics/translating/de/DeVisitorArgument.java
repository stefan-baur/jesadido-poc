/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.de;

public class DeVisitorArgument {
    
    private De caseAttribute;
    private int sentenceMeatIndex = -1;
    private boolean conditionalMeatA = false;
    private boolean conditionalMeatB = false;
    
    public De getCaseAttribute() {
        return this.caseAttribute;
    }
    
    public void setCaseAttribute(final De caseAttribute) {
        this.caseAttribute = caseAttribute;
    }
    
    public int getSentenceMeatIndex() {
        return this.sentenceMeatIndex;
    }
    
    public void setSentenceMeatIndex(final int value) {
        this.sentenceMeatIndex = value;
    }
    
    public boolean getConditionalMeatA() {
        return this.conditionalMeatA;
    }
    
    public void setConditionalMeatA(final boolean value) {
        this.conditionalMeatA = value;
    }
    
    public boolean getConditionalMeatB() {
        return this.conditionalMeatB;
    }
    
    public void setConditionalMeatB(final boolean value) {
        this.conditionalMeatB = value;
    }
}

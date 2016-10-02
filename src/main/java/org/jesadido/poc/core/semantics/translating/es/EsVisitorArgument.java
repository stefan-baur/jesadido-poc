/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.es;

public class EsVisitorArgument {
    
    private boolean nextSentence = false;
    private Es caseAttribute = null;
    private int sentenceMeatIndex = -1;
    
    public boolean getNextSentence() {
        return this.nextSentence;
    }
    
    public void setNextSentence(final boolean value) {
        this.nextSentence = value;
    }
    
    public Es getCaseAttribute() {
        return this.caseAttribute;
    }
    
    public void setCaseAttribute(Es caseAttribute) {
        this.caseAttribute = caseAttribute;
    }
    
    public int getSentenceMeatIndex() {
        return this.sentenceMeatIndex;
    }
    
    public void setSentenceMeatIndex(int value) {
        this.sentenceMeatIndex = value;
    }
}

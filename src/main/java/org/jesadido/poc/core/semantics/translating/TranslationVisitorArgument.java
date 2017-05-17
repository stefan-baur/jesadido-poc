/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating;

public class TranslationVisitorArgument {
    
    private boolean nextSentence = false;
    
    private boolean isEllipsis = false;
    private int sentenceMeatCount = 0;
    private int sentenceMeatIndex = -1;
    private boolean conditionalMeatA = false;
    private boolean conditionalMeatB = false;
    private int partCount = 0;
    
    public boolean getNextSentence() {
        return this.nextSentence;
    }
    
    public void setNextSentence(final boolean value) {
        this.nextSentence = value;
    }
    
    public boolean getIsEllipsis() {
        return this.isEllipsis;
    }
    
    public void setIsEllipsis(final boolean value) {
        this.isEllipsis = value;
    }
    
    public int getSentenceMeatCount() {
        return this.sentenceMeatCount;
    }
    
    public void setSentenceMeatCount(final int value) {
        this.sentenceMeatCount = value;
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
    
    public int getPartCount() {
        return this.partCount;
    }
    
    public void setPartCount(final int value) {
        this.partCount = value;
    }
}

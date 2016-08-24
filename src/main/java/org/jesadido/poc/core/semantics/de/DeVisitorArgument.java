/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.de;

public class DeVisitorArgument {
    
    private De caseAttribute;
    private int sentenceMeatIndex = -1;
    
    public De getCaseAttribute() {
        return this.caseAttribute;
    }
    
    public void setCaseAttribute(De caseAttribute) {
        this.caseAttribute = caseAttribute;
    }
    
    public int getSentenceMeatIndex() {
        return this.sentenceMeatIndex;
    }
    
    public void setSentenceMeatIndex(int value) {
        this.sentenceMeatIndex = value;
    }
}

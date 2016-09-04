/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.eo;

import org.jesadido.poc.core.syntax.tree.Terminal;

public class EoVisitorArgument {
    
    private Eo caseAttribute = null;
    private int sentenceMeatIndex = -1;
    private Terminal article = null;
    
    public Eo getCaseAttribute() {
        return this.caseAttribute;
    }
    
    public void setCaseAttribute(Eo caseAttribute) {
        this.caseAttribute = caseAttribute;
    }
    
    public int getSentenceMeatIndex() {
        return this.sentenceMeatIndex;
    }
    
    public void setSentenceMeatIndex(int value) {
        this.sentenceMeatIndex = value;
    }
    
    public Terminal getArticle() {
        return this.article;
    }
    
    public void setArticle(final Terminal article) {
        this.article = article;
    }
}

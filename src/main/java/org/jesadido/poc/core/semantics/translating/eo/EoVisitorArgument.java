/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.eo;

import org.jesadido.poc.core.semantics.translating.TranslationVisitorArgument;

public class EoVisitorArgument extends TranslationVisitorArgument {
    
    private Eo caseAttribute = null;
    
    public Eo getCaseAttribute() {
        return this.caseAttribute;
    }
    
    public void setCaseAttribute(Eo caseAttribute) {
        this.caseAttribute = caseAttribute;
    }
}

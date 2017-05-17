/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.en;

import org.jesadido.poc.core.semantics.translating.TranslationVisitorArgument;

public class EnVisitorArgument extends TranslationVisitorArgument {
    
    private En caseAttribute = null;
    
    public En getCaseAttribute() {
        return this.caseAttribute;
    }
    
    public void setCaseAttribute(En caseAttribute) {
        this.caseAttribute = caseAttribute;
    }
}

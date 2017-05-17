/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.es;

import org.jesadido.poc.core.semantics.translating.TranslationVisitorArgument;

public class EsVisitorArgument extends TranslationVisitorArgument {
    
    private Es caseAttribute = null;
    
    public Es getCaseAttribute() {
        return this.caseAttribute;
    }
    
    public void setCaseAttribute(Es caseAttribute) {
        this.caseAttribute = caseAttribute;
    }
}

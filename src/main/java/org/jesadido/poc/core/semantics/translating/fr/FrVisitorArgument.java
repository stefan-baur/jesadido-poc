/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.fr;

import org.jesadido.poc.core.semantics.translating.TranslationVisitorArgument;

public class FrVisitorArgument extends TranslationVisitorArgument {
    
    private Fr caseAttribute = null;
    
    public Fr getCaseAttribute() {
        return this.caseAttribute;
    }
    
    public void setCaseAttribute(Fr caseAttribute) {
        this.caseAttribute = caseAttribute;
    }
}

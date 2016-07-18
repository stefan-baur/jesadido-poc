/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.concepts;

public enum ConceptTermination {
    UNKNOWN(null),
    TERMINATOR("."),
    LABEL_TERMINATOR("!"),
    O("O"),
    A("A"),
    E("E"),
    O_J("OJ"),
    A_J("AJ"),
    E_J("EJ"),
    LA("La"),
    MI("Mi"),
    BI("Bi"),
    GXI("Gxi"),
    NI("Ni"),
    VI("Vi"),
    ILI("Ili"),
    KAJ("Kaj"),
    AUX("Aux");
    
    private final String terminationPhrase;
    
    private ConceptTermination(String terminationPhrase) {
        this.terminationPhrase = terminationPhrase;
    }
    
    public String getTerminationPhrase() {
        return this.terminationPhrase;
    }
    
    public boolean isOneOf(ConceptTermination ... conceptTerminations) {
        for (ConceptTermination conceptTermination : conceptTerminations) {
            if (this == conceptTermination) {
                return true;
            }
        }
        return false;
    }
    
    public static ConceptTermination get(String conceptPhrase) {
        if (conceptPhrase != null) {
            for (ConceptTermination conceptTermination : ConceptTermination.values()) {
                String termination = conceptTermination.getTerminationPhrase();
                if (termination != null && conceptPhrase.endsWith(termination)) {
                    return conceptTermination;
                }
            }
        }
        return ConceptTermination.UNKNOWN;
    }
}

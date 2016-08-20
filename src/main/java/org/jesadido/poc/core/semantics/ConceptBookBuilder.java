/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics;

import java.util.logging.Logger;

public class ConceptBookBuilder {
    
    private final ConceptBook conceptBook = new ConceptBook();
    
    public ConceptBook toBook() {
        return this.conceptBook;
    }
    
    /**
     * ~ ConceptBook myConceptBook = new ConceptBookBuilder()
     *     .concept("HeroIcxO")
     *     ...
     *     .de().???("Held")
     *     .en???("Hero")
     *     ...
     *     .concept???("TrovAs")
     *     .de("finde", "findest", "findet", ...)
     *     .toBook()
     *     ;
     * 
     * @param arguments Unused.
     */
    public static void main(final String[] arguments) {
        Logger.getAnonymousLogger().info("Building the 'ConceptBook' via method-chaining.");
    }
}

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc;

import org.jesadido.poc.client.JesadidoPocClient;

/**
 * This <code>JesadidoPoc</code> class implements the main application for
 * exploring all the features of the language project
 * <b>Jesadido - Proof of Concept</b>.
 */
public class JesadidoPoc {
    
    /**
     * The abbreviation name of this language project.
     */
    public static final String ABBREVIATION = "jesadido-poc";
    
    /**
     * The full name of this language project.
     */
    public static final String NAME = "Jesadido - Proof of Concept";
    
    /**
     * The OSI-conform open source license of this language project.
     */
    public static final String LICENSE = "LGPL-3.0";
    
    private JesadidoPoc() {
        // A private main class constructor.
    }

    /**
     * Launches a standalone project client application.
     * @param arguments Used for running the client application.
     */
    public static void main(final String[] arguments) {
        new JesadidoPocClient().launchClient(arguments);
    }
}

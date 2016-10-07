/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.references;

import org.jesadido.poc.JesadidoPoc;
import org.jesadido.poc.usecases.gaming.graphics.RgboColor;
import org.jesadido.poc.usecases.gaming.graphics.Rgbos;

public final class ReferenceRgbos {
    
    public static final String BACKGROUND = "background";
    
    public static final Rgbos DEFAULT_COLORS = new Rgbos("my-tiny-game", new RgboColor(0, 0, 0))
            .add(BACKGROUND, 44, 44, 44, 1)
            ;
    
    private ReferenceRgbos() {
        // A private class constructor
    }
    
    public static void main(final String[] arguments) {
        JesadidoPoc.run(arguments);
    }
}

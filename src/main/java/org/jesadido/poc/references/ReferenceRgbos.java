/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.references;

import org.jesadido.poc.JesadidoPoc;
import org.jesadido.poc.usecases.gaming.graphics.RgboKeys;
import org.jesadido.poc.usecases.gaming.graphics.RgboPalette;

public final class ReferenceRgbos {
    
    public static final RgboPalette DEFAULT_COLORS = new RgboPalette("default-colors")
            .add(RgboKeys.BACKGROUND, 44, 44, 44)
            ;
    
    public static final RgboPalette MAGIC_COLORS = new RgboPalette("magic-colors").addAll(DEFAULT_COLORS)
            .add(RgboKeys.BACKGROUND, 0, 66, 11)
            ;
    
    private ReferenceRgbos() {
        // A private class constructor
    }
    
    public static void main(final String[] arguments) {
        JesadidoPoc.run(arguments);
    }
}

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

public final class ReferenceRgboPalettes {
    
    public static final RgboPalette DEFAULT_COLORS = new RgboPalette("default-colors")
            .add(RgboKeys.BACKGROUND_FILL, 44, 44, 44)
            .add(RgboKeys.MAIN_LANGUAGE_CONTROL_FILL, 55, 55, 55, 0.6)
            .add(RgboKeys.MAIN_LANGUAGE_FILL, 240, 230, 140)
            .add(RgboKeys.MAIN_TEXT_FILL, 240, 230, 140)
            .add(RgboKeys.SEMI_LANGUAGE_CONTROL_FILL, 55, 55, 55, 0.5)
            .add(RgboKeys.SEMI_LANGUAGE_FILL, 200, 200, 200)
            .add(RgboKeys.SEMI_TEXT_FILL, 220, 220, 220)
            .add(RgboKeys.REST_LANGUAGE_CONTROL_FILL, 55, 55, 55, 0.3)
            .add(RgboKeys.REST_LANGUAGE_FILL, 66, 66, 66)
            .add(RgboKeys.REST_TEXT_FILL, 66, 66, 66)
            ;
    
    public static final RgboPalette MAGIC_COLORS = new RgboPalette("magic-colors").addAll(DEFAULT_COLORS)
            .add(RgboKeys.BACKGROUND_FILL, 0, 22, 55)
            .add(RgboKeys.MAIN_LANGUAGE_CONTROL_FILL, 88, 88, 88, 0.25)
            .add(RgboKeys.SEMI_LANGUAGE_CONTROL_FILL, 88, 88, 88, 0.2)
            .add(RgboKeys.SEMI_TEXT_FILL, 240, 240, 240)
            .add(RgboKeys.REST_LANGUAGE_CONTROL_FILL, 88, 88, 88, 0.15)
            .add(RgboKeys.REST_LANGUAGE_FILL, 70, 77, 88, 0.8)
            ;
    
    private ReferenceRgboPalettes() {
        // A private class constructor
    }
    
    public static void main(final String[] arguments) {
        JesadidoPoc.run(arguments);
    }
}

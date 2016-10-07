/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.generators.javafx;

import javafx.scene.paint.Color;
import org.jesadido.poc.usecases.gaming.graphics.Rgbo;

public final class JavaFxUtils {
    
    private JavaFxUtils() {
        // A private utility class constructor
    }
    
    public static Color toColor(final Rgbo rgbo) {
        return Color.color(Math.min(1.0, rgbo.getRed() / 255.0), Math.min(1.0, rgbo.getGreen() / 255.0), Math.min(1.0, rgbo.getBlue() / 255.0), rgbo.getOpacity());
    }
}

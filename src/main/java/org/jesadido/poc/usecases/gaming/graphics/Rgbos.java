/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.graphics;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Rgbos {
    
    private final String key;
    private final RgboColor defaultColor;
    private final Map<String, RgboColor> colors = new HashMap<>();
    
    public Rgbos(final String key, final RgboColor defaultColor) {
        this.key = key;
        this.defaultColor = defaultColor;
    }
    
    public String getKey() {
        return this.key;
    }
    
    public Rgbos addAll(final Rgbos other) {
        if (other != null) {
            other.colors.keySet().stream().forEach(colorKey -> this.add(colorKey, other.colors.get(colorKey)));
        }
        return this;
    }
    
    public Rgbos add(final String colorKey, final RgboColor color) {
        if (!colors.containsKey(colorKey)) {
            this.colors.put(colorKey, color);
        } else {
            Logger.getAnonymousLogger().warning(String.format("The rgbo-color \"%s\" is already added.", colorKey));
        }
        return this;
    }
    
    public Rgbos add(final String colorKey, final int red, final int green, final int blue, final double opacity) {
        return this.add(colorKey, new RgboColor(red, green, blue, opacity));
    }
    
    public RgboColor get(final String colorKey) {
        if (this.colors.containsKey(colorKey)) {
            return this.colors.get(colorKey);
        } else {
            return this.defaultColor;
        }
    }
}

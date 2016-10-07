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

public class RgboPalette {
    
    private final String key;
    private final Rgbo defaultRgbo;
    private final Map<String, Rgbo> rgboMap = new HashMap<>();
    
    public RgboPalette(final String key, final Rgbo defaultRgbo) {
        this.key = key;
        this.defaultRgbo = defaultRgbo;
    }
    
    public RgboPalette(final String key) {
        this(key, Rgbo.BLACK);
    }
    
    public String getKey() {
        return this.key;
    }
    
    public RgboPalette addAll(final RgboPalette other) {
        if (other != null) {
            other.rgboMap.keySet().stream().forEach(rgboKey -> this.add(rgboKey, other.rgboMap.get(rgboKey)));
        }
        return this;
    }
    
    public RgboPalette add(final String rgboKey, final Rgbo rgbo) {
        this.rgboMap.put(rgboKey, rgbo);
        return this;
    }
    
    public RgboPalette add(final String rgboKey, final int red, final int green, final int blue, final double opacity) {
        return this.add(rgboKey, new Rgbo(red, green, blue, opacity));
    }
    
    public RgboPalette add(final String rgboKey, final int red, final int green, final int blue) {
        return this.add(rgboKey, new Rgbo(red, green, blue));
    }
    
    public Rgbo get(final String rgboKey) {
        if (this.rgboMap.containsKey(rgboKey)) {
            return this.rgboMap.get(rgboKey);
        } else {
            return this.defaultRgbo;
        }
    }
}

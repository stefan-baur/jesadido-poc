/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.graphics;

import java.util.logging.Logger;

public final class RGBO {
    
    public static final RGBO TRANSPARENT = new RGBO(0, 0, 0, 0.0);
    
    private final int red;
    private final int green;
    private final int blue;
    private final double opacity;
    
    public RGBO(final int red, final int green, final int blue, final double opacity) {
        this.red = Integer.max(0, Integer.min(255, red));
        this.green = Integer.max(0, Integer.min(255, green));
        this.blue = Integer.max(0, Integer.min(255, blue));
        this.opacity = Double.max(0.0, Double.min(1.0, opacity));
    }
    
    public RGBO(final int red, final int green, final int blue) {
        this(red, green, blue, 1.0);
    }
    
    public int getRed() {
        return this.red;
    }
    
    public int getGreen() {
        return this.green;
    }
    
    public int getBlue() {
        return this.blue;
    }
    
    public double getOpacity() {
        return this.opacity;
    }
    
    public double getTransparency() {
        return Double.compare(this.opacity, 0.0) == 0 ? 1.0 : Double.max(0.0, 1.0 - this.opacity);
    }
    
    @Override
    public String toString() {
        return String.format("RGBOT(red: %d; green: %d; blue: %d; opacity: %.3f; transparency: %.3f)", this.getRed(), this.getGreen(), this.getBlue(), this.getOpacity(), this.getTransparency());
    }
    
    public static void main(final String[] arguments) {
        Logger.getAnonymousLogger().info(new RGBO(0, 0, 0, 0.0).toString());
        Logger.getAnonymousLogger().info(new RGBO(255, 255, 255, 1.0).toString());
        Logger.getAnonymousLogger().info(new RGBO(0, 127, 0, 0.6).toString());
        Logger.getAnonymousLogger().info(new RGBO(256, -330, 3000, 700).toString());
    }
}

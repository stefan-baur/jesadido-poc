/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.models;

import org.jesadido.poc.usecases.gaming.graphics.RgboKeys;
import org.jesadido.poc.usecases.gaming.graphics.rags.RagPath;
import org.jesadido.poc.usecases.gaming.graphics.rags.RagRotate;
import org.jesadido.poc.usecases.gaming.graphics.rags.RagScale;
import org.jesadido.poc.usecases.gaming.graphics.rags.RagTranslate;

public final class ThingFactory {
    
    private ThingFactory() {
        // A private utility class constructor
    }
    
    public static Thing createSunO() {
        return new Thing("SunO", new RagRotate(30)
                .add(new RagPath(RgboKeys.NONE, "M -250,-250 250,-250 250,250 -250,250 Z"))
                .add(new RagPath(RgboKeys.YELLOW, "M -4.0406102,-166.29268 C -210.78166,-155.98002 -229.27343,163.1367 3.030454,169.078 235.33433,175.0193 202.70044,-176.60534 -4.0406102,-166.29268 z"))
                .add(new RagPath(RgboKeys.YELLOW, "m -4.5625,-251.15625 4.05076273,-0.97895 -4.01951273,67.6664 -2.0304576,-1.01015 -3.0515551,-65.67735 z"))
                .add(new RagPath(RgboKeys.YELLOW, "m 98.025381,-240.75428 -31.806631,67.19178 0.90625,0.40625 36.35232,-59.58439 z"))
                .add(new RagPath(RgboKeys.YELLOW, "m 241.40625,-8.1875 -62.63594,5.5465288 -2.96796,2.01015257 69.20193,-1.00079997 z"))
                .add(new RagPath(RgboKeys.YELLOW, "m 1.5210975,182.18834 c 1.1595206,19.94755 2.3192338,44.81683 4.5456864,64.66537 l -8.5964492,-3.03041 2.03045765,-65.6758 z"))
                .add(new RagPath(RgboKeys.YELLOW, "M 134.71875,141.4688 134,142.1562 l 50.5,51.5 11.83043,-4.728 z"))
                .add(new RagPath(RgboKeys.YELLOW, "m -132.65625,131.3125 -57.59375,50.5313 1.6664,7.8211 L -132,132.0938 z"))
                .add(new RagPath(RgboKeys.YELLOW, "m -248.46875,-0.125 -1.04135,8.0711 67.6664,-5.0399 -5.01956,-2.0102 z"))
                .add(new RagPath(RgboKeys.YELLOW, "m -197.65625,-192.90625 -5.73826,5.76951 69.70701,56.57424 0.6875,-0.75 z"))
                .add(new RagPath(RgboKeys.YELLOW, "m -103.59375,-241.25 -6.96717,1.4164 38.37342,66.67735 0.90625,-0.4375 z"))
                .add(new RagPath(RgboKeys.YELLOW, "m -242.25,-96.0625 -7.44607,2.95781 84.85232,28.29219 0.375,-0.9375 z"))
                .add(new RagPath(RgboKeys.YELLOW, "m -163.84375,80.75 -73.75,34.3438 1.4164,7.9773 72.73985,-41.4149 z"))
                .add(new RagPath(RgboKeys.YELLOW, "m -68.125,172.9062 -31.3125,64.6563 -5.15467,-3.6031 34.342962,-61.6258 z"))
                .add(new RagPath(RgboKeys.YELLOW, "m 75.21875,172.9375 3.10311,3.3742 18.17814,55.5633 -7.14372,8.7476 z"))
                .add(new RagPath(RgboKeys.YELLOW, "m 169.875,74.6562 -0.34375,0.9376 64.65625,25.25 2.36406,-6.9985 z"))
                .add(new RagPath(RgboKeys.YELLOW, "M 189.53125,-189.875 136,-132.28125 l -1.27031,3.71796 64.64293,-59.10898 z"))
                .add(new RagPath(RgboKeys.YELLOW, "m 235.1875,-104.125 -63.65625,25.25 -2.65546,2.957805 71.73747,-23.229695 z"))
        );
    }
    
    public static Thing createHeroIcxO() {
        return new Thing("HeroIcxO", new RagScale(0.25).add(new RagPath(RgboKeys.BLUE, "m -227.14286,103.79075 120,12.85715 114.2857171,-7.14286 145.7142829,1.42857 37.14286,1.42857 62.85714,-5.71428 -1.42857,94.28571 -5.71428,85.71429 0,214.28571 12.85714,222.85714 -2.85714,155.71429 -7.14286,174.28576 -215.714287,1.4285 -252.857143,1.4286 -2.85714,-118.57143 -1.42857,-100 12.85714,-125.71429 -12.85714,-185.71428 5.71428,-265.71429 -2.85714,-87.14286 z")));
    }
    
    public static Thing createHeroInO() {
        return new Thing("HeroInO", new RagScale(0.25).add(new RagPath(RgboKeys.RED, "m -227.14286,103.79075 120,12.85715 114.2857171,-7.14286 145.7142829,1.42857 37.14286,1.42857 62.85714,-5.71428 -1.42857,94.28571 -5.71428,85.71429 0,214.28571 12.85714,222.85714 -2.85714,155.71429 -7.14286,174.28576 -215.714287,1.4285 -252.857143,1.4286 -2.85714,-118.57143 -1.42857,-100 12.85714,-125.71429 -12.85714,-185.71428 5.71428,-265.71429 -2.85714,-87.14286 z")));
    }
}

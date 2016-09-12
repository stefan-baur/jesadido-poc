/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.graphics;

import org.jesadido.poc.usecases.gaming.graphics.Thing;
import org.jesadido.poc.usecases.gaming.graphics.RGBO;
import org.jesadido.poc.usecases.gaming.graphics.rags.RagPath;
import org.jesadido.poc.usecases.gaming.graphics.rags.RagProperties;
import org.jesadido.poc.usecases.gaming.graphics.rags.RagScale;

public final class ThingFactory {
    
    private ThingFactory() {
        // A private utility class constructor
    }
    
    public static Thing createHeroIcxO() {
        return new Thing("HeroIcxO", new RagScale(0.25).add(new RagPath(new RagProperties(new RGBO(0, 0, 127)), "m -227.14286,103.79075 120,12.85715 114.2857171,-7.14286 145.7142829,1.42857 37.14286,1.42857 62.85714,-5.71428 -1.42857,94.28571 -5.71428,85.71429 0,214.28571 12.85714,222.85714 -2.85714,155.71429 -7.14286,174.28576 -215.714287,1.4285 -252.857143,1.4286 -2.85714,-118.57143 -1.42857,-100 12.85714,-125.71429 -12.85714,-185.71428 5.71428,-265.71429 -2.85714,-87.14286 z")));
    }
    
    public static Thing createHeroInO() {
        return new Thing("HeroInO", new RagScale(0.25).add(new RagPath(new RagProperties(new RGBO(127, 0, 0)), "m -227.14286,103.79075 120,12.85715 114.2857171,-7.14286 145.7142829,1.42857 37.14286,1.42857 62.85714,-5.71428 -1.42857,94.28571 -5.71428,85.71429 0,214.28571 12.85714,222.85714 -2.85714,155.71429 -7.14286,174.28576 -215.714287,1.4285 -252.857143,1.4286 -2.85714,-118.57143 -1.42857,-100 12.85714,-125.71429 -12.85714,-185.71428 5.71428,-265.71429 -2.85714,-87.14286 z")));
    }
}

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.concepts;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class ConceptUtilsTest {
    
    @Test
    public void testToConceptPhrase() {
        Assert.assertEquals("IcxO", ConceptUtils.toConceptPhrase(Arrays.asList("icx", "o")));
        Assert.assertEquals("/de/'von'Hefner'O", ConceptUtils.toConceptPhrase(Arrays.asList("/de/", "'von'Hefner'", "o")));
    }
}

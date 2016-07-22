/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tokens;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.jesadido.poc.core.CoreUtils;

public final class TokenStream {
    
    private final BufferedReader source;
    
    public TokenStream(final InputStream source) {
        this.source = new BufferedReader(new InputStreamReader(source, CoreUtils.UTF_8));
    }
    
    public TokenStream(final String source) {
        this(new ByteArrayInputStream(source.getBytes(CoreUtils.UTF_8)));
    }
    
    public final boolean has() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public final Token next() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public final Token peek() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

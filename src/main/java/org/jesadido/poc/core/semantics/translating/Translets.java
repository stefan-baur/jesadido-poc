/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.jesadido.poc.core.StringUtils;
import org.jesadido.poc.core.syntax.tokens.TokenType;
import org.jesadido.poc.core.syntax.tree.Terminal;

public class Translets {
    
    private final Map<String, Translet> transletMap = new HashMap<>();
    
    private static String createTokenTypesKey(final List<TokenType> tokenTypes) {
        return StringUtils.join(".", tokenTypes);
    }
    
    private static String createTerminalsKey(final List<Terminal> terminals) {
        final List<TokenType> tokenTypes = new LinkedList<>();
        terminals.stream().forEach(terminal -> tokenTypes.add(terminal.getToken().getType()));
        return createTokenTypesKey(tokenTypes);
    }
    
    public Translets add(final List<TokenType> tokenTypes, final Translet translet) {
        final String key = createTokenTypesKey(tokenTypes);
        if (!this.transletMap.containsKey(key)) {
            this.transletMap.put(createTokenTypesKey(tokenTypes), translet);
        } else {
            Logger.getAnonymousLogger().warning(String.format("There is already added a translet with the same signation '%s'. The current translet will be ignored.", key));
        }
        return this;
    }
    
    public void translate(final TranslationResult result, final List<Terminal> terminals) {
        final String key = createTerminalsKey(terminals);
        if (this.transletMap.containsKey(key)) {
            this.transletMap.get(key).translate(result, terminals);
        }
    }
}

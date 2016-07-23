/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.cfg;

import java.util.List;
import java.util.Map;

public interface ContextFreeGrammar<N, T, P> {
    
    String getName();
    List<N> getNonterminalSymbols();
    List<T> getTerminalSymbols();
    Map<String, P> getProductionRules();
    N getStartSymbol();
}

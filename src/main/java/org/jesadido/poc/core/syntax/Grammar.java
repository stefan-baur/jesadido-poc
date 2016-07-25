/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax;

import java.util.List;

public interface Grammar<N, T, P extends ProductionRule<N, T>> {
    
    String getName();
    List<N> getNonterminalSymbols();
    List<T> getTerminalSymbols();
    List<P> getProductionRules();
    N getStartSymbol();
}

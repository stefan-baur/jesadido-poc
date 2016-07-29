/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.productions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.StringUtils;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public abstract class ProductionOneOf extends ProductionLeaf {
    
    private final List<TokenType> firsts;
    
    public ProductionOneOf(final String nonterminalSymbol, final List<TokenType> firsts) {
        super(nonterminalSymbol, firsts, new LinkedList<>());
        this.firsts = firsts;
    }
    
    @Override
    public List<String> getRules() {
        return Arrays.asList(String.format("%s ::= %s", this.getNonterminalSymbol(), StringUtils.join(" | ", this.firsts)));
    }
    
    @Override
    public List<TokenType> getFirsts() {
        return this.firsts;
    }
}

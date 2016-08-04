/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.base.productions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.syntax.base.Base;
import org.jesadido.poc.core.syntax.nodes.Node;
import org.jesadido.poc.core.syntax.productions.ProductionLeaf;
import org.jesadido.poc.core.syntax.tokens.Token;
import org.jesadido.poc.core.syntax.tokens.TokenStream;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public class NominalSelectionProduction extends ProductionLeaf {
    
    private List<TokenType> firsts = null;
    
    public NominalSelectionProduction() {
        super(Base.NT_NOMINAL_SELECTION,
                Arrays.asList(TokenType.SUBSTANTIVE_SINGULAR),
                new LinkedList<>()
        );
    }
    
    @Override
    public List<String> getRules() {
        return Arrays.asList(String.format("%s ::= %s", this.getNonterminalSymbol(),
                TokenType.SUBSTANTIVE_SINGULAR
        ));
    }
    
    @Override
    public List<TokenType> getFirsts() {
        if (this.firsts == null) {
            this.firsts = new LinkedList<>();
            this.firsts.add(TokenType.SUBSTANTIVE_SINGULAR);
        }
        return this.firsts;
    }
    
    @Override
    public Node parse(final TokenStream tokenStream) {
        if (tokenStream.hasOneOf(TokenType.SUBSTANTIVE_SINGULAR)) {
            final Token substantive = tokenStream.next();
            return this.getGrammar().getSyntaxTreeFactory().createNominalSelection(substantive);
        }
        return this.parsingTrouble(tokenStream);
    }
}

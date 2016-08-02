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

public class VerbSelectionProduction extends ProductionLeaf {
    
    private List<TokenType> firsts = null;
    
    public VerbSelectionProduction() {
        super(Base.NT_VERB_SELECTION,
                Arrays.asList(TokenType.AS, TokenType.IS, TokenType.OS),
                new LinkedList<>()
        );
    }
    
    @Override
    public List<String> getRules() {
        return Arrays.asList(String.format("%s ::= %s | %s | %s", this.getNonterminalSymbol(),
                TokenType.AS,
                TokenType.IS,
                TokenType.OS
        ));
    }
    
    @Override
    public List<TokenType> getFirsts() {
        if (this.firsts == null) {
            this.firsts = new LinkedList<>();
            this.firsts.add(TokenType.AS);
            this.firsts.add(TokenType.IS);
            this.firsts.add(TokenType.OS);
        }
        return this.firsts;
    }
    
    @Override
    public Node parse(final TokenStream tokenStream) {
        if (tokenStream.hasOneOf(TokenType.AS, TokenType.IS, TokenType.OS)) {
            final Token verb = tokenStream.next();
            return this.getGrammar().getSyntaxTreeFactory().createVerbSelection(verb.getConcept());
        }
        return this.parsingTrouble(tokenStream);
    }
}

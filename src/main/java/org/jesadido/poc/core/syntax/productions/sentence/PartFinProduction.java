/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.productions.sentence;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.syntax.Nonterminal;
import org.jesadido.poc.core.syntax.tree.Node;
import org.jesadido.poc.core.syntax.productions.ProductionLeaf;
import org.jesadido.poc.core.syntax.tokens.Token;
import org.jesadido.poc.core.syntax.tokens.TokenStream;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public class PartFinProduction extends ProductionLeaf {
    
    private List<TokenType> firsts = null;
    
    public PartFinProduction() {
        super(Nonterminal.PART_FIN,
                Arrays.asList(TokenType.PART_FIN, TokenType.OPEN, TokenType.CLOSE),
                new LinkedList<>()
        );
    }
    
    @Override
    public List<String> getRules() {
        return Arrays.asList(String.format("%s ::= %s %s %s", this.getNonterminalSymbol(),
                TokenType.PART_FIN,
                TokenType.OPEN,
                TokenType.CLOSE
        ));
    }
    
    @Override
    public List<TokenType> getFirsts() {
        if (this.firsts == null) {
            this.firsts = new LinkedList<>();
            this.firsts.add(TokenType.PART_FIN);
        }
        return this.firsts;
    }
    
    @Override
    public Node parse(final TokenStream tokenStream) {
        if (tokenStream.hasOneOf(TokenType.PART_FIN)) {
            final Token preposition = tokenStream.next();
            if (tokenStream.hasOneOf(TokenType.OPEN)) {
                final Token opener = tokenStream.next();
                if (tokenStream.hasOneOf(TokenType.CLOSE)) {
                    final Token closer = tokenStream.next();
                    return this.getGrammar().getSyntaxTreeFactory().createPartFin(preposition, opener, null, closer);
                }
                return this.parsingTrouble(tokenStream, TokenType.CLOSE);
            }
            return this.parsingTrouble(tokenStream, TokenType.OPEN);
        }
        return this.parsingTrouble(tokenStream, TokenType.PART_FIN);
    }
}

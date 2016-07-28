/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.base.productions.leaves;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.StringUtils;
import org.jesadido.poc.core.syntax.ProductionLeaf;
import org.jesadido.poc.core.syntax.base.Base;
import org.jesadido.poc.core.syntax.nodes.Node;
import org.jesadido.poc.core.syntax.tokens.Token;
import org.jesadido.poc.core.syntax.tokens.TokenStream;
import org.jesadido.poc.core.syntax.tokens.TokenType;

public class SentenceMeatInfixConjunctionProduction extends ProductionLeaf {
    
    private static final List<TokenType> FIRST_SET = Arrays.asList(TokenType.KAJ, TokenType.AUX, TokenType.SEPARATOR);
    private static final List<String> NO_NONTERMINALS = new LinkedList<>();
    
    public SentenceMeatInfixConjunctionProduction() {
        super(Base.NT_SENTENCE_MEAT_INFIX_CONJUNCTION, FIRST_SET, NO_NONTERMINALS);
    }
    
    @Override
    public List<String> getBnfs() {
        return Arrays.asList(String.format("%s ::= %s", this.getNonterminalSymbol(), StringUtils.join(" | ", FIRST_SET)));
    }
    
    @Override
    public List<TokenType> getFirstSet() {
        return FIRST_SET;
    }
    
    @Override
    public Node parse(final TokenStream tokenStream) {
        if (tokenStream.hasOneOf(FIRST_SET)) {
            final Token separator = tokenStream.next();
            return this.getGrammar().getSyntaxTreeFactory().createSentenceMeatConjunction(separator.getConcept());
        }
        return this.parsingTrouble(tokenStream);
    }
}

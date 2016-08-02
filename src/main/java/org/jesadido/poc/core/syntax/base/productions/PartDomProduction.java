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

public class PartDomProduction extends ProductionLeaf {
    
    private List<TokenType> firsts = null;
    
    public PartDomProduction() {
        super(Base.NT_PART_DOM,
                Arrays.asList(TokenType.DOM, TokenType.OPEN, TokenType.CLOSE),
                Arrays.asList(Base.NT_VERB_SELECTION)
        );
    }
    
    @Override
    public List<String> getRules() {
        return Arrays.asList(String.format("%s ::= (%s ((%s %s %s) | %s)) | %s", this.getNonterminalSymbol(),
                TokenType.DOM,
                TokenType.OPEN,
                Base.NT_VERB_SELECTION,
                TokenType.CLOSE,
                Base.NT_VERB_SELECTION,
                Base.NT_VERB_SELECTION
        ));
    }
    
    @Override
    public List<TokenType> getFirsts() {
        if (this.firsts == null) {
            this.firsts = new LinkedList<>();
            this.firsts.add(TokenType.DOM);
            this.firsts.addAll(this.getFirsts(Base.NT_VERB_SELECTION));
        }
        return this.firsts;
    }
    
    @Override
    public Node parse(final TokenStream tokenStream) {
        if (tokenStream.hasOneOf(TokenType.DOM)) {
            final Token preposition = tokenStream.next();
            if (tokenStream.hasOneOf(TokenType.OPEN)) {
                final Token opener = tokenStream.next();
                final Node verbSelection = this.parseVerbSelection(tokenStream);
                if (tokenStream.hasOneOf(TokenType.CLOSE)) {
                    final Token closer = tokenStream.next();
                    return this.getGrammar().getSyntaxTreeFactory().createPartDom(preposition.getConcept(), opener.getConcept(), verbSelection, closer.getConcept());
                }
                return this.parsingTrouble(tokenStream, TokenType.CLOSE);
            } else {
                final Node verbSelection = this.parseVerbSelection(tokenStream);
                return this.getGrammar().getSyntaxTreeFactory().createPartDom(preposition.getConcept(), null, verbSelection, null);
            }
        } else {
            final Node verbSelection = this.parseVerbSelection(tokenStream);
            return this.getGrammar().getSyntaxTreeFactory().createPartDom(null, null, verbSelection, null);
        }
    }
    
    private Node parseVerbSelection(final TokenStream tokenStream) {
        if (this.hasFirstOf(tokenStream, Base.NT_VERB_SELECTION)) {
            return this.parse(tokenStream, Base.NT_VERB_SELECTION);
        }
        return this.parsingTrouble(tokenStream);
    }
}

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.nodes.visitors;

import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.syntax.nodes.NodeComposite;
import org.jesadido.poc.core.syntax.nodes.NodeLeaf;
import org.jesadido.poc.core.syntax.nodes.Visitor;
import org.jesadido.poc.core.syntax.nodes.composites.PrepositionalPartDom;
import org.jesadido.poc.core.syntax.nodes.composites.PrepositionalPartFin;
import org.jesadido.poc.core.syntax.nodes.composites.SentenceMeat;
import org.jesadido.poc.core.syntax.nodes.composites.Sentence;
import org.jesadido.poc.core.syntax.nodes.composites.PrepositionalPartSu;
import org.jesadido.poc.core.syntax.nodes.leaves.SentenceMeatConjunction;

public class Stringifier implements Visitor<String, String> {
    
    public static final String DEFAULT_DELIMITER = " ";
    
    private static String stringify(final String delimiter, final List<Concept> concepts) {
        final List<String> result = new LinkedList<>();
        concepts.stream().filter(concept -> concept != null).forEach(concept -> result.add(concept.getFullPhrase()));
        return String.join(delimiter == null ? DEFAULT_DELIMITER : delimiter, result);
    }
    
    private String stringify(final String delimiter, final NodeLeaf leaf) {
        return stringify(delimiter, leaf.getTerminals());
    }
    
    private String stringify(final String delimiter, final NodeComposite composite) {
        final List<String> result = new LinkedList<>();
        final String openersResult = stringify(delimiter, composite.getOpeners());
        if (openersResult.length() > 0) {
            result.add(openersResult);
        }
        composite.getChildren().stream().forEach(child -> {
            final String childResult = child.accept(this, delimiter);
            if (childResult.length() > 0) {
                result.add(childResult);
            }
        });
        final String closersResult = stringify(delimiter, composite.getClosers());
        if (closersResult.length() > 0) {
            result.add(closersResult);
        }
        return String.join(delimiter == null ? DEFAULT_DELIMITER : delimiter, result);
    }
    
    @Override
    public String visit(final Sentence node, final String delimiter) {
        return this.stringify(delimiter, node);
    }
    
    @Override
    public String visit(final SentenceMeat node, final String delimiter) {
        return this.stringify(delimiter, node);
    }
    
    @Override
    public String visit(final SentenceMeatConjunction node, final String delimiter) {
        return this.stringify(delimiter, node);
    }
    
    @Override
    public String visit(final PrepositionalPartSu node, final String delimiter) {
        return this.stringify(delimiter, node);
    }
    
    @Override
    public String visit(final PrepositionalPartDom node, final String delimiter) {
        return this.stringify(delimiter, node);
    }
    
    @Override
    public String visit(final PrepositionalPartFin node, final String delimiter) {
        return this.stringify(delimiter, node);
    }
}

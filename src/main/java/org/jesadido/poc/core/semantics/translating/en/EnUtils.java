/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.en;

import java.util.List;
import org.jesadido.poc.core.concepts.Concept;
import org.jesadido.poc.core.concepts.ConceptTermination;
import org.jesadido.poc.core.semantics.translating.TranslationTarget;
import org.jesadido.poc.core.semantics.translating.Translator;
import org.jesadido.poc.core.syntax.tree.Node;
import org.jesadido.poc.core.syntax.tree.NodeUtils;
import org.jesadido.poc.core.syntax.tree.sentence.PartAl;
import org.jesadido.poc.core.syntax.tree.sentence.PartDom;
import org.jesadido.poc.core.syntax.tree.sentence.PartFin;
import org.jesadido.poc.core.syntax.tree.sentence.PartSu;

public final class EnUtils {
    
    private EnUtils() {
        // A private utility class constructor
    }
    
    public static List<Node> rearrangeParts(final List<Node> parts) {
        return NodeUtils.rearrange(parts, PartSu.class, PartDom.class, PartAl.class, PartFin.class);
    }
    
    public static String getIndefinite(final Translator translator, final Concept substantiveConcept) {
        final TranslationTarget substantiveTarget = translator.getFirstDefaultTarget(substantiveConcept);
        return String.join(" ", getIndefiniteArticle(substantiveTarget), substantiveTarget.getMainPhrase());
    }
    
    public static String getDefinite(final Translator translator, final Concept articleConcept, final Concept substantiveConcept) {
        final TranslationTarget substantiveTarget = translator.getFirstDefaultTarget(substantiveConcept);
        return String.join(" ", getDefiniteArticle(translator, articleConcept), substantiveTarget.getMainPhrase());
    }
    
    private static String getIndefiniteArticle(final TranslationTarget followerTarget) {
        final String follower = followerTarget.getMainPhrase();
        if ("aeio".contains(Character.toString(follower.charAt(0)))) {
            return "an";
        } else {
            return "a";
        }
    }
    
    private static String getDefiniteArticle(final Translator translator, final Concept articleConcept) {
        if (articleConcept.hasReferenceConcept()) {
            final Concept referenceConcept = articleConcept.getReferenceConcept();
            if (referenceConcept.getProperties().getTermination().isOneOf(ConceptTermination.MI)) {
                return "my";
            } else if (referenceConcept.getProperties().getTermination().isOneOf(ConceptTermination.BI)) {
                return "your";
            } else if (referenceConcept.getProperties().getTermination().isOneOf(ConceptTermination.GXI)) {
                return getGxiArticle(translator, referenceConcept);
            }
        }
        return "the";
    }
    
    private static String getGxiArticle(final Translator translator, final Concept gxiConcept) {
        if (gxiConcept.hasReferenceConcept()) {
            final Concept gxiReferenceConcept = gxiConcept.getReferenceConcept();
            final TranslationTarget gxiReferenceTarget = translator.getFirstDefaultTarget(gxiReferenceConcept);
            if (gxiReferenceTarget.has(En.FEMININE)) {
                return "her";
            } else if (gxiReferenceTarget.has(En.MASCULINE)) {
                return "his";
            }
        }
        return "its";
    }
}

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics.translating.fr;

import java.util.List;
import org.jesadido.poc.core.semantics.translating.TranslationTarget;
import org.jesadido.poc.core.syntax.tree.Node;
import org.jesadido.poc.core.syntax.tree.NodeUtils;
import org.jesadido.poc.core.syntax.tree.sentence.PartAl;
import org.jesadido.poc.core.syntax.tree.sentence.PartDom;
import org.jesadido.poc.core.syntax.tree.sentence.PartFin;
import org.jesadido.poc.core.syntax.tree.sentence.PartSu;

public final class FrUtils {
    
    private FrUtils() {
        // A private utility class constructor
    }
    
    public static List<Node> rearrangeParts(final List<Node> parts) {
        return NodeUtils.rearrange(parts, PartSu.class, PartDom.class, PartAl.class, PartFin.class);
    }
    
    public static String getIndefiniteArticle(final TranslationTarget substantiveTarget) {
        if (substantiveTarget.getAttributes().contains(Fr.FEMININE)) {
            return "une";
        } else {
            return "un";
        }
    }
    
    public static String getDefiniteArticleSubstantive(final TranslationTarget substantiveTarget) {
        final String follower = substantiveTarget.getMainPhrase();
        if (substantiveTarget.getAttributes().contains(Fr.FEMININE)) {
            return isVocalical(follower) ? String.format("l'%s", follower) : String.format("la %s", follower);
        } else {
            return isVocalical(follower) ? String.format("l'%s", follower) : String.format("le %s", follower);
        }
    }
    
    private static boolean isVocalical(String follower) {
        if (follower != null && follower.length() > 0) {
            final String firstCharOfFollower = Character.toString(follower.charAt(0));
            return ("aeioué".contains(firstCharOfFollower)) || ("ha|he|hi|ho|hu".contains(firstCharOfFollower));
        }
        return false;
    }
}

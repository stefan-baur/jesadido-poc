/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tree;

import java.util.LinkedList;
import java.util.List;

public final class NodeUtils {
    
    private NodeUtils() {
        // A private utility class constructor.
    }
    
    public static List<Node> rearrange(final List<Node> nodes, final Class ... classSequence) {
        final List<Node> nodeList = new LinkedList<>(nodes);
        final List<Node> result = new LinkedList<>();
        for (final Class clazz : classSequence) {
            Node foundNode = null;
            for (final Node node : nodeList) {
                if (node.objectOf(clazz)) {
                    foundNode = node;
                    break;
                }
            }
            if (foundNode != null) {
                result.add(foundNode);
                nodeList.remove(foundNode);
            }
        }
        return result;
    }
}

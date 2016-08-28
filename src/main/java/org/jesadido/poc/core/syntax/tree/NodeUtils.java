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
    
    public static Node getFirstNode(final List<Node> nodes, final Class clazz) {
        for (final Node node : nodes) {
            if (node.objectOf(clazz)) {
                return node;
            }
        }
        return null;
    }
    
    public static List<Node> rearrange(final List<Node> nodes, final Class ... classSequence) {
        final List<Node> result = new LinkedList<>();
        final List<Node> nodeList = new LinkedList<>(nodes);
        for (final Class clazz : classSequence) {
            if (clazz == null) {
                continue;
            }
            final Node firstNode = getFirstNode(nodeList, clazz);
            if (firstNode != null) {
                result.add(firstNode);
                nodeList.remove(firstNode);
            }
        }
        return result;
    }
}

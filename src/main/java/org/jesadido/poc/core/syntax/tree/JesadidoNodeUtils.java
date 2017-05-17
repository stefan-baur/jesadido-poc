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

public final class JesadidoNodeUtils {
    
    private JesadidoNodeUtils() {
        // A private utility class constructor.
    }
    
    public static List<JesadidoNode> find(final List<JesadidoNode> nodes, final Class filter) {
        final List<JesadidoNode> result = new LinkedList<>();
        nodes.stream().filter(node -> node.objectOf(filter)).forEach(result::add);
        return result;
    }
    
    public static JesadidoNode findFirst(final List<JesadidoNode> nodes, final Class filter) {
        for (final JesadidoNode node : nodes) {
            if (node.objectOf(filter)) {
                return node;
            }
        }
        return null;
    }
    
    public static List<JesadidoNode> rearrange(final List<JesadidoNode> nodes, final Class ... filterSequence) {
        final List<JesadidoNode> result = new LinkedList<>();
        final List<JesadidoNode> nodeList = new LinkedList<>(nodes);
        for (final Class filter : filterSequence) {
            if (filter == null) {
                continue;
            }
            final JesadidoNode firstOccurrence = findFirst(nodeList, filter);
            if (firstOccurrence != null) {
                result.add(firstOccurrence);
                nodeList.remove(firstOccurrence);
            }
        }
        return result;
    }
    
    public static boolean containsAll(final List<JesadidoNode> nodes, final List<Class> filterSequence) {
        return filterSequence.stream().noneMatch(filter -> findFirst(nodes, filter) == null);
    }
    
    public static boolean containsNo(final List<JesadidoNode> nodes, final List<Class> filterSequence) {
        return filterSequence.stream().noneMatch(filter -> findFirst(nodes, filter) != null);
    }
}

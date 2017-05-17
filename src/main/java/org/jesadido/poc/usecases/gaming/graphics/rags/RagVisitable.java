/*
 * jesadido-poc
 * Copyright (C) 2017 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.graphics.rags;

@FunctionalInterface
public interface RagVisitable {
    
    public <R, A> R accept(RagVisitor<R, A> visitor, A argument);
}

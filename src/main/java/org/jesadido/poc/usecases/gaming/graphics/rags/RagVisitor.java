/*
 * jesadido-poc
 * Copyright (C) 2017 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.graphics.rags;

public interface RagVisitor<R, A> {
    
    public R visit(RagGroup rag, A argument);
    public R visit(RagPath rag, A argument);
    public R visit(RagScale rag, A argument);
    public R visit(RagTranslate rag, A argument);
}

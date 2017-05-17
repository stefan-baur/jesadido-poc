/*
 * jesadido-poc
 * Copyright (C) 2017 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.generators.javafx;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.SVGPath;
import org.jesadido.poc.usecases.gaming.graphics.rags.RagGroup;
import org.jesadido.poc.usecases.gaming.graphics.rags.RagPath;
import org.jesadido.poc.usecases.gaming.graphics.rags.RagScale;
import org.jesadido.poc.usecases.gaming.graphics.rags.RagTranslate;
import org.jesadido.poc.usecases.gaming.graphics.rags.RagVisitor;
import org.jesadido.poc.usecases.gaming.models.GameModel;

public class JavaFxRagVisitor implements RagVisitor<Node, Void> {
    
    private final GameModel gameModel;
    
    public JavaFxRagVisitor(final GameModel gameModel) {
        this.gameModel = gameModel;
    }

    @Override
    public Node visit(RagGroup rag, Void argument) {
        final Group result = new Group();
        rag.getRags().stream().forEach(child -> result.getChildren().add(child.accept(this, argument)));
        return result;
    }

    @Override
    public Node visit(RagPath rag, Void argument) {
        final SVGPath result = new SVGPath();
        result.setContent(rag.getPath());
        result.setFill(JavaFxGameUtils.toColor(this.gameModel.getRgbo(rag.getFillKey())));
        result.setStroke(JavaFxGameUtils.toColor(this.gameModel.getRgbo(rag.getStrokeKey())));
        result.setStrokeWidth(rag.getStrokeWidth());
        return result;
    }

    @Override
    public Node visit(RagScale rag, Void argument) {
        final Group result = new Group();
        rag.getRags().stream().forEach(child -> result.getChildren().add(child.accept(this, argument)));
        result.setScaleX(rag.getScaleX());
        result.setScaleY(rag.getScaleY());
        return result;
    }

    @Override
    public Node visit(RagTranslate rag, Void argument) {
        final Group result = new Group();
        rag.getRags().stream().forEach(child -> result.getChildren().add(child.accept(this, argument)));
        result.setTranslateX(rag.getTranslateX());
        result.setTranslateY(rag.getTranslateY());
        return result;
    }
}

/*
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.client;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.jesadido.poc.JesadidoPoc;

/**
 * This <code>JesadidoPocClient</code> class implements the JavaFX client
 * application for exploring all the features of the language project
 * <b>Jesadido - Proof of Concept</b>.
 */
public class JesadidoPocClient extends Application {

    /**
     * Launches this JavaFX client application.
     *
     * @param arguments Unused.
     */
    public void launchClient(String[] arguments) {

        launch(arguments);
    }

    /**
     * The main entry point starts this JavaFX client application.
     * @param primaryStage Defines the scene and more.
     * @throws Exception Any exception of the application.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setTitle(JesadidoPoc.NAME);
        primaryStage.setScene(new Scene(new StackPane(), 800, 600));
        primaryStage.show();
    }
}

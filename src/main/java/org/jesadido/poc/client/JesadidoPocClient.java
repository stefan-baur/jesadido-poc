/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.client;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.jesadido.poc.JesadidoPoc;
import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.semantics.ConceptBook;
import org.jesadido.poc.core.semantics.ConceptBookEntry;
import org.jesadido.poc.core.syntax.Grammar;
import org.jesadido.poc.core.syntax.GrammarFactory;
import org.jesadido.poc.core.testing.References;

/**
 * This <code>JesadidoPocClient</code> class implements the JavaFX client
 * application for exploring all the features of this language project.
 */
public class JesadidoPocClient extends Application {

    /**
     * Launches this JavaFX client application.
     *
     * @param arguments Used for the JavaFX client application.
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
        primaryStage.setScene(this.createMasterScene());
        primaryStage.show();
    }
    
    public static void main(final String[] arguments) {
        JesadidoPoc.main(arguments);
    }
    
    private Scene createMasterScene() {
        
        final Grammar jesadidoGrammar = GrammarFactory.createJesadidoGrammar();
        final ConceptBook gameBook = References.GAME_BOOK;
        
        final BorderPane masterPane = new BorderPane();
        masterPane.setPadding(new Insets(8, 8, 8, 8));
        
        final MenuItem menuItemGrammarJesadido = new MenuItem(jesadidoGrammar.getName());
        menuItemGrammarJesadido.setOnAction((ActionEvent e) -> {
            masterPane.setTop(this.createHeaderControl(String.format("Grammar: %s", jesadidoGrammar.getName())));
            masterPane.setCenter(this.createGrammarControl(jesadidoGrammar));
        });
        final Menu menuGrammars = new Menu("Grammars");
        menuGrammars.getItems().addAll(menuItemGrammarJesadido);
        
        final MenuItem menuItemGameBook = new MenuItem(gameBook.getName());
        menuItemGameBook.setOnAction((ActionEvent e) -> {
            masterPane.setTop(this.createHeaderControl(String.format("Concept-Book: %s (Grammar: %s)", gameBook.getName(), gameBook.getGrammar().getName())));
            masterPane.setCenter(this.createConceptBookControl(gameBook));
        });
        final Menu menuConceptBooks = new Menu("Concept-Books");
        menuConceptBooks.getItems().addAll(menuItemGameBook);
        
        final MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menuGrammars, menuConceptBooks);
        
        final VBox masterBox = new VBox();
        masterBox.getChildren().addAll(menuBar, masterPane);
        final StackPane rootPane = new StackPane(masterBox);
        return new Scene(rootPane, 800, 600);
    }
    
    private Node createHeaderControl(final String text) {
        final Label result = new Label(text);
        result.setFont(Font.font(null, FontWeight.BOLD, FontPosture.REGULAR, 24));
        result.setPadding(new Insets(2, 2, 8, 12));
        return result;
    }
    
    private Node createGrammarControl(final Grammar grammar) {
        final TextArea result = new TextArea(grammar.toString());
        result.setFont(Font.font("Courier New", FontWeight.NORMAL, FontPosture.REGULAR, 14));
        result.setEditable(false);
        result.setPrefHeight(2400);
        result.setPadding(new Insets(6, 6, 6, 8));
        return result;
    }
    
    private Node createConceptBookControl(final ConceptBook conceptBook) {
        final ObservableList<String> conceptPhrases = FXCollections.observableArrayList();
        conceptBook.getEntries().stream().forEach(conceptBookEntry -> conceptPhrases.add(conceptBookEntry.getConceptPhrase()));
        final ListView<String> listView = new ListView<>(conceptPhrases);
        
        final VBox entryKeysControl = new VBox(10, listView);
        
        final Label concept = new Label("Concept: -");
        final Label requiredParts = new Label("Required Parts: -");
        final Label excludedParts = new Label("Excluded Parts: -");
        final Label defaultTargets = new Label("Default Targets: -");
        final VBox entryControl = new VBox(10, concept, requiredParts, excludedParts, defaultTargets);
        
        listView.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            concept.setText("Concept: " + newValue);
            final ConceptBookEntry conceptBookEntry = conceptBook.get(newValue);
            requiredParts.setText("Required Parts: " + conceptBookEntry.getRequiredParts().toString());
            excludedParts.setText("Excluded Parts: " + conceptBookEntry.getExcludedParts().toString());
            defaultTargets.setText(String.format("Default Targets:%n   %s: %s%n   %s: %s%n   %s: %s%n   %s: %s%n   %s: %s%n",
                    Language.DE, conceptBookEntry.getDefaultTargets(Language.DE),
                    Language.EN, conceptBookEntry.getDefaultTargets(Language.EN),
                    Language.EO, conceptBookEntry.getDefaultTargets(Language.EO),
                    Language.ES, conceptBookEntry.getDefaultTargets(Language.ES),
                    Language.FR, conceptBookEntry.getDefaultTargets(Language.FR)
            ));
        });
        
        return new HBox(10, entryKeysControl, entryControl);
    }
}

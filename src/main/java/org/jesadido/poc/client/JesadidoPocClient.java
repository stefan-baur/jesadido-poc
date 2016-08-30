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
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
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
        
        
        final MenuBar menuBar = new MenuBar();
        
        final VBox masterBox = new VBox();
        final BorderPane masterPane = new BorderPane();
        masterBox.getChildren().addAll(menuBar, masterPane);
        
        final MenuItem menu0Item1 = new MenuItem(jesadidoGrammar.getName());
        menu0Item1.setOnAction((ActionEvent e) -> {
            masterPane.setTop(new Text(String.format("Grammar: %s", jesadidoGrammar.getName())));
            masterPane.setCenter(this.createGrammarNode(jesadidoGrammar));
        });
        final Menu menu0 = new Menu("Grammars");
        menu0.getItems().addAll(menu0Item1);
        
        final MenuItem menu1Item1 = new MenuItem(gameBook.getName());
        menu1Item1.setOnAction((ActionEvent e) -> {
            masterPane.setTop(new Text(String.format("Concept-Book: %s (Grammar: %s)", gameBook.getName(), gameBook.getGrammar().getName())));
            masterPane.setCenter(this.createConceptBookNode(gameBook));
        });
        final Menu menu1 = new Menu("Concept-Books");
        menu1.getItems().addAll(menu1Item1);
        
        menuBar.getMenus().addAll(menu0, menu1);
        
        return new Scene(masterBox, 800, 600);
    }
    
    private Node createGrammarNode(final Grammar grammar) {
        final Label result = new Label(grammar.toString());
        result.setWrapText(true);
        return result;
    }
    
    private Node createConceptBookNode(final ConceptBook conceptBook) {
        final ObservableList<String> conceptPhrases = FXCollections.observableArrayList();
        conceptBook.getEntries().stream().forEach(conceptBookEntry -> conceptPhrases.add(conceptBookEntry.getConceptPhrase()));
        final ListView<String> listView = new ListView<>(conceptPhrases);
        
        final VBox entryKeysControl = new VBox(10, listView);
        
        final Text concept = new Text("Concept: -");
        final Text requiredParts = new Text("Required Parts: -");
        final Text excludedParts = new Text("Excluded Parts: -");
        final Text defaultTargets = new Text("Default Targets: -");
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

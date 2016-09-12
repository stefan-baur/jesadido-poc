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
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
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
import org.jesadido.poc.core.semantics.translating.TranslatorFactory;
import org.jesadido.poc.core.syntax.Grammar;
import org.jesadido.poc.core.syntax.GrammarFactory;
import org.jesadido.poc.core.testing.References;
import org.jesadido.poc.usecases.gaming.Layer;
import org.jesadido.poc.usecases.gaming.Thing;
import org.jesadido.poc.usecases.gaming.ThingFactory;

/**
 * This <code>JesadidoPocClient</code> class implements the JavaFX client
 * application for exploring all the features of this language project.
 */
public class JesadidoPocClient extends Application {

    private static final Font SOURCE_FONT_11 = Font.font("Courier New", FontWeight.NORMAL, FontPosture.REGULAR, 11);
    
    /**
     * Launches this JavaFX client application.
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
    
    private Scene createMasterScene() {
        
        final Grammar jesadidoGrammar = GrammarFactory.createJesadidoGrammar();
        final ConceptBook gameBook = References.GAME_BOOK;
        
        final BorderPane masterPane = new BorderPane();
        masterPane.setPadding(new Insets(8, 8, 8, 8));
        masterPane.setCenter(this.createGaming());
        
        final MenuItem menuItemGrammarJesadido = new MenuItem(jesadidoGrammar.getName());
        menuItemGrammarJesadido.setOnAction((ActionEvent e) -> {
            masterPane.setTop(this.createPageHeader(String.format("Grammar: %s", jesadidoGrammar.getName())));
            masterPane.setCenter(this.createGrammarOverview(jesadidoGrammar));
        });
        final Menu menuGrammars = new Menu("Grammars");
        menuGrammars.getItems().addAll(menuItemGrammarJesadido);
        
        final MenuItem menuItemGameBook = new MenuItem(gameBook.getName());
        menuItemGameBook.setOnAction((ActionEvent e) -> {
            masterPane.setTop(this.createPageHeader(String.format("Concept-Book: %s (Grammar: %s)", gameBook.getName(), gameBook.getGrammar().getName())));
            masterPane.setCenter(this.createConceptBookOverview(gameBook));
        });
        final Menu menuConceptBooks = new Menu("Concept-Books");
        menuConceptBooks.getItems().addAll(menuItemGameBook);
        
        final MenuItem menuItemGaming = new MenuItem("Gaming");
        menuItemGaming.setOnAction((ActionEvent e) -> {
            masterPane.setTop(null);
            masterPane.setCenter(this.createGaming());
        });
        final Menu menuUseCases = new Menu("Use-Cases");
        menuUseCases.getItems().addAll(menuItemGaming);
        
        final MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menuGrammars, menuConceptBooks, menuUseCases);
        
        final VBox masterBox = new VBox();
        masterBox.getChildren().addAll(menuBar, masterPane);
        final StackPane rootPane = new StackPane(masterBox);
        return new Scene(rootPane, 800, 600);
    }
    
    private Node createGaming() {
        final Group result = new Group();
        
        final Thing heroIcxO = ThingFactory.createHeroIcxO();
        heroIcxO.setPosition(-400, 0);
        final Thing heroInO = ThingFactory.createHeroInO();
        
        final Layer layer = new Layer();
        layer.getThings().add(heroIcxO);
        layer.getThings().add(heroInO);
        
        result.getChildren().add(layer.createJavaFx());
        return result;
    }
    
    private Node createPageHeader(final String text) {
        final Label result = new Label(text);
        result.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 24));
        result.setPadding(new Insets(2, 2, 12, 12));
        return result;
    }
    
    private Node createGrammarOverview(final Grammar grammar) {
        final TextArea result = new TextArea(grammar.toString());
        result.setFont(Font.font("Courier New", FontWeight.NORMAL, FontPosture.REGULAR, 14));
        result.setEditable(false);
        result.setPrefHeight(2400);
        result.setPadding(new Insets(6, 6, 6, 8));
        return result;
    }
    
    private static ObservableList<String> toConceptPhrases(final ConceptBook conceptBook) {
        final ObservableList<String> result = FXCollections.observableArrayList();
        conceptBook.getEntries().stream().forEach(conceptBookEntry -> result.add(conceptBookEntry.getConceptPhrase()));
        return result;
    }
    
    private Node createConceptBookOverview(final ConceptBook conceptBook) {
        
        final BorderPane entriesEntryPane = new BorderPane();
        
        final ListView<String> entriesListView = new ListView<>(toConceptPhrases(conceptBook));
        entriesListView.setPrefHeight(2400);
        entriesListView.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) ->
            entriesEntryPane.setCenter(this.createConceptBookEntryInfos(conceptBook, newValue))
        );
        
        final HBox entriesContent = new HBox(10, new VBox(4, entriesListView), entriesEntryPane);
        entriesContent.setPadding(new Insets(8, 0, 0, 0));
        
        final Tab entriesTab = new Tab("Concept-Entries");
        entriesTab.setContent(entriesContent);
        entriesTab.setClosable(false);
        
        final BorderPane referencesReferenceResultPane = new BorderPane();
        
        final ListView<String> referencesListView = new ListView<>(FXCollections.observableList(conceptBook.getReferenceSources()));
        referencesListView.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) ->
            referencesReferenceResultPane.setCenter(this.createReferenceResult(conceptBook, newValue))
        );
        
        final VBox referencesContent = new VBox(10, referencesListView, referencesReferenceResultPane);
        referencesContent.setPadding(new Insets(8, 0, 0, 0));
        
        final Tab referencesTab = new Tab("Reference-Sources");
        referencesTab.setContent(referencesContent);
        referencesTab.setClosable(false);
        
        final TabPane result = new TabPane();
        result.setPrefHeight(2400);
        result.getTabs().addAll(entriesTab, referencesTab);
        return result;
    }
    
    private Node createConceptBookEntryInfos(final ConceptBook conceptBook, final String conceptPhrase) {
        final Label concept = new Label("Concept: -");
        final Label requiredParts = new Label("Required Parts: -");
        final Label excludedParts = new Label("Excluded Parts: -");
        final Label defaultTargets = new Label("Default Targets: -");
        final VBox entryControl = new VBox(10, concept, requiredParts, excludedParts, defaultTargets);
        
        concept.setText("Concept: " + conceptPhrase);
        final ConceptBookEntry conceptBookEntry = conceptBook.get(conceptPhrase);
        requiredParts.setText("Required Parts: " + conceptBookEntry.getRequiredParts().toString());
        excludedParts.setText("Excluded Parts: " + conceptBookEntry.getExcludedParts().toString());
        defaultTargets.setText(String.format("Default Targets:%n   %s: %s%n   %s: %s%n   %s: %s%n   %s: %s%n   %s: %s%n",
                Language.DE, conceptBookEntry.getDefaultTargets(Language.DE),
                Language.EN, conceptBookEntry.getDefaultTargets(Language.EN),
                Language.EO, conceptBookEntry.getDefaultTargets(Language.EO),
                Language.ES, conceptBookEntry.getDefaultTargets(Language.ES),
                Language.FR, conceptBookEntry.getDefaultTargets(Language.FR)
        ));
        return entryControl;
    }
    
    private static ObservableList<String> toTranslations(final ConceptBook conceptBook, String referenceSource) {
        final ObservableList<String> result = FXCollections.observableArrayList();
        for (final Language language : Language.values()) {
            result.add(String.format("%s: %s", language, TranslatorFactory.createTranslator(language, conceptBook).translate(referenceSource).getTranslation()));
        }
        return result;
    }
    
    private Node createReferenceResult(final ConceptBook conceptBook, final String referenceSource) {
        
        final ListView<String> translationsListView = new ListView<>(FXCollections.observableList(toTranslations(conceptBook, referenceSource)));
        
        final BorderPane translationsContent = new BorderPane(translationsListView);
        translationsContent.setPadding(new Insets(8, 0, 0, 0));
        
        final Tab translationsTab = new Tab("Translations");
        translationsTab.setContent(translationsContent);
        translationsTab.setClosable(false);
        
        final TextArea prettyPrintContent = new TextArea(conceptBook.getGrammar().parse(referenceSource).prettyPrint().toString());
        prettyPrintContent.setFont(SOURCE_FONT_11);
        prettyPrintContent.setEditable(false);
        prettyPrintContent.setPadding(new Insets(8, 0, 0, 0));
        
        final Tab prettyPrintTab = new Tab("Pretty-Print");
        prettyPrintTab.setContent(prettyPrintContent);
        prettyPrintTab.setClosable(false);
        
        final TextArea cstContent = new TextArea(conceptBook.getGrammar().parse(referenceSource).plot().toString());
        cstContent.setFont(SOURCE_FONT_11);
        cstContent.setEditable(false);
        cstContent.setPadding(new Insets(8, 0, 0, 0));
        
        final Tab cstTab = new Tab("Concrete Syntax-Tree");
        cstTab.setContent(cstContent);
        cstTab.setClosable(false);
        
        final TabPane result = new TabPane();
        result.getTabs().addAll(translationsTab, prettyPrintTab, cstTab);
        return result;
    }
    
    public static void main(final String[] arguments) {
        JesadidoPoc.main(arguments);
    }
}

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.jesadido.poc.JesadidoPoc;
import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.semantics.ConceptBook;
import org.jesadido.poc.core.semantics.translating.TranslatorFactory;
import org.jesadido.poc.core.syntax.Grammar;
import org.jesadido.poc.core.syntax.GrammarFactory;
import org.jesadido.poc.references.ReferenceConceptBooks;
import org.jesadido.poc.references.ReferenceGameModels;
import org.jesadido.poc.usecases.gaming.generators.web20.Web20GameGenerator;
import org.jesadido.poc.usecases.gaming.generators.javafx.JavaFxGenerator;
import org.jesadido.poc.usecases.gaming.generators.text.TextGameGenerator;
import org.jesadido.poc.usecases.gaming.models.GameModel;

/**
 * This <code>JesadidoPocClient</code> class implements the JavaFX client
 * application for exploring all the features of this language project.
 */
public class JesadidoPocClient extends Application {

    private static final String SOURCE_FONT_FAMILY = "Courier New";
    private static final Font SOURCE_FONT_11 = Font.font(SOURCE_FONT_FAMILY, FontWeight.NORMAL, FontPosture.REGULAR, 11);
    private static final Font SOURCE_FONT_14 = Font.font(SOURCE_FONT_FAMILY, FontWeight.NORMAL, FontPosture.REGULAR, 14);
    
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
        
        final BorderPane masterPane = new BorderPane();
        masterPane.setPadding(new Insets(8, 8, 8, 8));
        masterPane.setCenter(this.createGameModelOverview(ReferenceGameModels.getGameModels().get(0)));
        
        final MenuItem menuItemGrammarJesadido = new MenuItem(jesadidoGrammar.getKey());
        menuItemGrammarJesadido.setOnAction((ActionEvent e) -> {
            masterPane.setTop(this.createPageHeader(String.format("Grammar: \"%s\"", jesadidoGrammar.getKey())));
            masterPane.setCenter(this.createGrammarOverview(jesadidoGrammar));
        });
        final Menu menuGrammars = new Menu("Grammars");
        menuGrammars.getItems().addAll(menuItemGrammarJesadido);
        
        final Menu menuConceptBooks = new Menu("Concept-Books");
        ReferenceConceptBooks.getConceptBooks().stream().forEach(conceptBook -> this.addConceptBookMenuItem(masterPane, menuConceptBooks, conceptBook));
        
        final Menu menuItemGaming = new Menu("Gaming");
        ReferenceGameModels.getGameModels().stream().forEach(gameModel -> this.addGameModelMenuItem(masterPane, menuItemGaming, gameModel));
        
        final Menu menuUseCases = new Menu("Use-Cases");
        menuUseCases.getItems().addAll(menuItemGaming);
        
        final MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menuGrammars, menuConceptBooks, menuUseCases);
        
        final VBox masterBox = new VBox();
        masterBox.getChildren().addAll(menuBar, masterPane);
        final StackPane rootPane = new StackPane(masterBox);
        return new Scene(rootPane, 800, 600);
    }
    
    private void addConceptBookMenuItem(final BorderPane masterPane, final Menu menuConceptBooks, final ConceptBook conceptBook) {
        final MenuItem menuItemGameBook = new MenuItem(conceptBook.getKey());
        menuItemGameBook.setOnAction((ActionEvent e) -> {
            masterPane.setTop(this.createPageHeader(String.format("Concept-Book: \"%s\" (Grammar: \"%s\")", conceptBook.getKey(), conceptBook.getGrammar().getKey())));
            masterPane.setCenter(this.createConceptBookOverview(conceptBook));
        });
        menuConceptBooks.getItems().addAll(menuItemGameBook);
    }
    
    private void addGameModelMenuItem(final BorderPane masterPane, final Menu menuItemGaming, final GameModel gameModel) {
        final MenuItem menuItemMyTinyGame = new MenuItem(gameModel.getKey());
        menuItemMyTinyGame.setOnAction((ActionEvent e) -> {
            masterPane.setTop(this.createPageHeader(String.format("Game: \"%s\"", gameModel.getKey())));
            masterPane.setCenter(this.createGameModelOverview(gameModel));
        });
        menuItemGaming.getItems().addAll(menuItemMyTinyGame);
    }
    
    private Node createGameModelOverview(final GameModel gameModel) {
        
        final BorderPane playGameContent = new BorderPane(new JavaFxGenerator().generate(gameModel));
        playGameContent.setPadding(new Insets(8, 0, 0, 0));
        
        final Tab playGameTab = new Tab("Play the Game!");
        playGameTab.setContent(playGameContent);
        playGameTab.setClosable(false);
        
        final Button generateStaticWebsite = new Button("Generate a Web 2.0 Component!");
        generateStaticWebsite.setOnAction((ActionEvent e) -> {
            final Web20GameGenerator web20GameGenerator = new Web20GameGenerator(gameModel);
            if (web20GameGenerator.generate()) {
                getHostServices().showDocument(web20GameGenerator.getTestPageFile().getAbsolutePath());
            }
        });
        
        final VBox crossPlatformContent = new VBox();
        crossPlatformContent.getChildren().add(generateStaticWebsite);
        
        final Tab crossPlatformTab = new Tab("Code-Generation");
        crossPlatformTab.setContent(crossPlatformContent);
        crossPlatformTab.setClosable(false);
        crossPlatformTab.setDisable(true);
        
        final TextArea gameModelContent = new TextArea(new TextGameGenerator(gameModel).generate().toString());
        gameModelContent.setFont(SOURCE_FONT_11);
        gameModelContent.setEditable(false);
        gameModelContent.setPadding(new Insets(8, 0, 0, 0));
        
        final Tab gameModelTab = new Tab("Game-Model");
        gameModelTab.setContent(gameModelContent);
        gameModelTab.setClosable(false);
        
        final TabPane result = new TabPane();
        result.setPrefHeight(2400);
        result.getTabs().addAll(playGameTab, crossPlatformTab, gameModelTab);
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
        result.setFont(SOURCE_FONT_14);
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
        
        final BorderPane entriesContent = new BorderPane();
        entriesContent.setPadding(new Insets(8, 0, 0, 0));
        
        final ListView<String> entriesListView = new ListView<>(toConceptPhrases(conceptBook));
        entriesListView.setPrefHeight(2400);
        entriesListView.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) ->
            entriesContent.setCenter(this.createConceptBookEntryPlot(conceptBook, newValue))
        );
        entriesContent.setLeft(entriesListView);
        BorderPane.setMargin(entriesListView, new Insets(0, 8, 0, 0));
        
        final Tab entriesTab = new Tab("Concept-Entries");
        entriesTab.setContent(entriesContent);
        entriesTab.setClosable(false);
        
        final BorderPane referencesReferenceResultPane = new BorderPane();
        
        final ListView<String> referencesListView = new ListView<>(FXCollections.observableList(conceptBook.getReferenceSources()));
        referencesListView.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) ->
            referencesReferenceResultPane.setCenter(this.createReferenceResult(conceptBook, newValue))
        );
        
        final VBox referenceSourcesContent = new VBox(10, referencesListView, referencesReferenceResultPane);
        referenceSourcesContent.setPadding(new Insets(8, 0, 0, 0));
        
        final Tab referenceSourcesTab = new Tab("Reference-Sources");
        referenceSourcesTab.setContent(referenceSourcesContent);
        referenceSourcesTab.setClosable(false);
        
        final TextArea referenceTestsContent = new TextArea(ReferenceConceptBooks.generateTests(conceptBook).toString());
        referenceTestsContent.setFont(SOURCE_FONT_14);
        referenceTestsContent.setEditable(false);
        referenceTestsContent.setPrefHeight(2400);
        
        final Tab referenceTestsTab = new Tab("Reference-Tests");
        referenceTestsTab.setContent(referenceTestsContent);
        referenceTestsTab.setClosable(false);
        
        final TabPane result = new TabPane();
        result.setPrefHeight(2400);
        result.getTabs().addAll(entriesTab, referenceSourcesTab, referenceTestsTab);
        return result;
    }
    
    private Node createConceptBookEntryPlot(final ConceptBook conceptBook, final String conceptPhrase) {
        final TextArea result = new TextArea(conceptBook.get(conceptPhrase).toString());
        result.setFont(SOURCE_FONT_14);
        result.setEditable(false);
        result.setPadding(new Insets(6, 6, 6, 8));
        return result;
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

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.generators.web20;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jesadido.poc.JesadidoPoc;
import org.jesadido.poc.core.scripting.Src;
import org.jesadido.poc.usecases.gaming.models.GameModel;

public class Web20GameGenerator {
    
    private static final File RESOURCES_ROOT_DIR = new File(new File(Web20GameGenerator.class.getResource("Web20GameGenerator.class").getPath()).getParentFile(), "resources");
    private static final String JQUERY_FILE = "jquery-3.1.1.min.js";
    
    private final GameModel gameModel;
    
    public Web20GameGenerator(final GameModel gameModel) {
        this.gameModel = gameModel;
    }
    
    public boolean generate() {
        try {
            this.generateTestPage();
            this.generateResources();
        } catch (IOException ex) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "The web 2.0 component can not be stored to the directory: " + this.getWeb20Directory().getAbsolutePath(), ex);
            return false;
        }
        return true;
    }
    
    public File getBaseDirectory() {
        return new File(System.getProperty("user.home"), JesadidoPoc.ABBREVIATION);
    }
    
    public File getOutputDirectory() {
        return new File(this.getBaseDirectory(), "output");
    }
    
    public File getWeb20Directory() {
        return new File(this.getOutputDirectory(), "web20");
    }
    
    public File getKeyDirectory() {
        return new File(this.getWeb20Directory(), this.gameModel.getKey());
    }
    
    public File getJQueryFile() {
        return new File(this.getKeyDirectory(), JQUERY_FILE);
    }
    
    public File getTestPageFile() {
        return new File(this.getKeyDirectory(), "test.html");
    }
    
    private void generateTestPage() throws IOException {
        new Src()
                .line("<!DOCTYPE html>")
                .begin("<html>")
                .begin("<head>")
                .line("<meta charset=\"utf-8\" />")
                .line("<title>%s</title>", this.gameModel.translate(this.gameModel.getSelectedLanguages().get(0), this.gameModel.getTitle().getSource()))
                .line("<script type=\"text/javascript\" src=\"%s\"></script>", JQUERY_FILE)
                .begin("<script type=\"text/javascript\">")
                .begin("(function($) {")
                .begin("$(function() {")
                .begin("$(window).resize(function() {")
                .line("console.log(\"\" + $(window).width() + \"x\" + $(window).height());")
                .end("});")
                .end("});")
                .end("})(jQuery);")
                .end("</script>")
                .end("</head>")
                .begin("<body>")
                .line("<div>%s %s</div>", this.gameModel.getSelectedLanguages(), this.gameModel.getSupportedLanguages().toString().replace("[", "{").replace("]", "}"))
                .line("<code>%s</code>", this.gameModel.translate(this.gameModel.getSelectedLanguages().get(0), this.gameModel.getTitle().getSource()))
                .end("</body>")
                .end("</html>")
                .save(this.getTestPageFile());
    }
    
    private void generateResources() throws IOException {
        Web20GameUtils.fileCopy(new File(RESOURCES_ROOT_DIR, JQUERY_FILE), this.getJQueryFile());
    }
    
    public static void main(final String[] arguments) {
        JesadidoPoc.run(arguments);
    }
}

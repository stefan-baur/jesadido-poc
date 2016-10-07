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
    
    private final GameModel gameModel;
    
    public Web20GameGenerator(final GameModel gameModel) {
        this.gameModel = gameModel;
    }
    
    public boolean generate() {
        try {
            this.generateTestPage();
        } catch (IOException ex) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "The web 2.0 component can not be stored to the directory: " + this.getHtmlDirectory().getAbsolutePath(), ex);
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
    
    public File getHtmlDirectory() {
        return new File(this.getOutputDirectory(), "html");
    }
    
    public File getKeyDirectory() {
        return new File(this.getHtmlDirectory(), this.gameModel.getKey());
    }
    
    public File getTestPageFile() {
        return new File(this.getKeyDirectory(), "test.html");
    }
    
    private void generateTestPage() throws IOException {
        new Src()
                .line("<!DOCTYPE html>")
                .begin("<html>")
                .begin("<head>")
                .line("<title>%s</title>", this.gameModel.translate(this.gameModel.getSelectedLanguages().get(0), this.gameModel.getTitle().getSource()))
                .end("</head>")
                .begin("<body>")
                .line("<div>%s %s</div>", this.gameModel.getSelectedLanguages(), this.gameModel.getSupportedLanguages().toString().replace("[", "{").replace("]", "}"))
                .line("<code>%s</code>", this.gameModel.translate(this.gameModel.getSelectedLanguages().get(0), this.gameModel.getTitle().getSource()))
                .end("</body>")
                .end("</html>")
                .save(this.getTestPageFile());
    }
    
    public static void main(final String[] arguments) {
        JesadidoPoc.run(arguments);
    }
}

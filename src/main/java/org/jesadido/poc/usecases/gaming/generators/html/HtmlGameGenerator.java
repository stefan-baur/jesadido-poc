/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.generators.html;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jesadido.poc.JesadidoPoc;
import org.jesadido.poc.core.scripting.Src;
import org.jesadido.poc.usecases.gaming.models.GameModel;

public class HtmlGameGenerator {
    
    public boolean generate(final GameModel gameModel) {
        try {
            this.generateIndexPage(gameModel);
        } catch (IOException ex) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "The static-html website can not be stored to the directory: " + this.getHtmlDirectory().getAbsolutePath(), ex);
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
    
    public File getKeyDirectory(final GameModel gameModel) {
        return new File(this.getHtmlDirectory(), gameModel.getKey());
    }
    
    public File getIndexPageFile(final GameModel gameModel) {
        return new File(this.getKeyDirectory(gameModel), "index.html");
    }
    
    public void generateIndexPage(final GameModel gameModel) throws IOException {
        new Src()
                .line("<!DOCTYPE html>")
                .begin("<html>")
                .begin("<head>")
                .line("<title>%s</title>", gameModel.getTitle())
                .end("</head>")
                .begin("<body>")
                .line("<div>%s</div>", gameModel.getSupportedLanguages().toString())
                .line("<code>%s</code>", gameModel.getTitle())
                .end("</body>")
                .end("</html>")
                .save(this.getIndexPageFile(gameModel));
    }
    
    public static void main(final String[] arguments) {
        JesadidoPoc.run(arguments);
    }
}

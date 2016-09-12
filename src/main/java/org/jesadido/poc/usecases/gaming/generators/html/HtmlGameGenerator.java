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
            Logger.getAnonymousLogger().log(Level.SEVERE, "The static website can not be stored to the directory: " + this.getHtmlDirectory().getAbsolutePath(), ex);
            return false;
        }
        return true;
    }
    
    public File getBaseDirectory() {
        return new File(System.getProperty("user.home"), JesadidoPoc.ABBREVIATION);
    }
    
    public File getHtmlDirectory() {
        return new File(this.getBaseDirectory(), "html");
    }
    
    public File getIndexPageFile() {
        return new File(this.getHtmlDirectory(), "index.html");
    }
    
    public void generateIndexPage(final GameModel gameModel) throws IOException {
        new Src()
                .line("<!DOCTYPE html>")
                .begin("<html>")
                .begin("<head>")
                .line("<title>%s</title>", gameModel.getTitle())
                .end("</head>")
                .begin("<body>")
                .line("<code>%s</code>", gameModel.getTitle())
                .end("</body>")
                .end("</html>")
                .save(this.getIndexPageFile());
    }
}

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
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jesadido.poc.JesadidoPoc;
import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.scripting.Src;
import org.jesadido.poc.usecases.gaming.graphics.RgboKeys;
import org.jesadido.poc.usecases.gaming.models.GameModel;

public class Web20GameGenerator {
    
    private static final File RESOURCES_ROOT_DIR = new File(new File(Web20GameGenerator.class.getResource("Web20GameGenerator.class").getPath()).getParentFile(), "resources");
    private static final String JQUERY_FILE = "jquery-3.1.1.min.js";
    private static final String COMPONENT_FILE = "game.js";
    
    private final GameModel gameModel;
    
    public Web20GameGenerator(final GameModel gameModel) {
        this.gameModel = gameModel;
    }
    
    public boolean generate() {
        try {
            this.generateComponent();
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
    
    public File getComponentFile() {
        return new File(this.getKeyDirectory(), COMPONENT_FILE);
    }
    
    public File getTestPageFile() {
        return new File(this.getKeyDirectory(), "test.html");
    }
    
    private Language getMainLanguage() {
        return this.gameModel.getSelectedLanguages().get(0);
    }
    
    private List<Language> getSemiLanguages() {
        return this.gameModel.getSelectedLanguages().subList(1, this.gameModel.getSelectedLanguages().size());
    }
    
    private List<Language> getRestLanguages() {
        final List<Language> result = new LinkedList<>();
        this.gameModel.getSupportedLanguages().stream().filter(supportedLanguage -> !this.gameModel.getSelectedLanguages().contains(supportedLanguage)).forEach(result::add);
        return result;
    }
    
    private void generateComponent() throws IOException {
        new Src()
                .begin("(function($) {")
                .line()
                .begin("$.fn.extend({")
                .line()
                .begin("game: function() {")
                
                .begin("return this.each(function() {")
                
                .begin("var languages = {")
                .line("main: '%s',", this.getMainLanguage().getCode())
                .line("semi: %s,", Web20GameUtils.toJsLanguageArray(this.getSemiLanguages()))
                .line("rest: %s,", Web20GameUtils.toJsLanguageArray(this.getRestLanguages()))
                .begin("select: function(l) {")
                
                .begin("if (l === this.main) {")
                .line("this.rest.push(l);")
                .begin("if (!this.semi.length) {")
                .line("this.main = this.rest[0];")
                .line("this.rest.splice(0, 1);")
                .endBegin("} else {")
                .line("this.main = this.semi[0];")
                .line("this.semi.splice(0, 1);")
                .end("}")
                .endBegin("} else {")
                .line("var semiIndex = this.semi.indexOf(l);")
                .begin("if (semiIndex > -1) {")
                .line("this.semi.splice(semiIndex, 1);")
                .end("}")
                .line("this.semi.splice(0, 0, this.main);")
                .line("var restIndex = this.rest.indexOf(l);")
                .begin("if (restIndex > -1) {")
                .line("this.rest.splice(restIndex, 1);")
                .end("}")
                .line("this.main = l;")
                .end("}")
                .line("alert(l + ' (' + this.main + ', ' + this.semi + ', ' + this.rest + ')');")
                .end("}")
                .end("};")
                
                .begin("var $master = $('<span></span>').css({")
                .line("backgroundColor: '%s',", Web20GameUtils.toCssRgba(this.gameModel.getRgbo(RgboKeys.BACKGROUND_FILL)))
                .line("display: 'inline-block',")
                .line("width: $(this).width() + 'px',")
                .line("height: $(this).height() + 'px'")
                .end("}).appendTo($(this));")
                
                .line("var $languageSettings = $('<div class=\"language-settings\"></div>').appendTo($master);")
                .line("$('<a href=\"#\">' + languages.main + '</a>').data('language', languages.main).appendTo($languageSettings);")
                .begin("for (var i = 0; i < languages.semi.length; i++) {")
                .line("var l = languages.semi[i];")
                .line("$('<a href=\"#\">' + l + '</a>').data('language', l).appendTo($languageSettings);")
                .end("}")
                .begin("for (var i = 0; i < languages.rest.length; i++) {")
                .line("var l = languages.rest[i];")
                .line("$('<a href=\"#\">' + l + '</a>').data('language', l).appendTo($languageSettings);")
                .end("}")
                .begin("$languageSettings.children().on('click', function() {")
                .line("languages.select($(this).data('language'));")
                .end("});")
                
                .line("$('<div>%s</div>').appendTo($master);", this.gameModel.translate(this.gameModel.getSelectedLanguages().get(0), this.gameModel.getTitle().getSource()))
                
                .end("});")
                
                .end("}")
                .line()
                .end("});")
                .line()
                .end("})(jQuery);")
                .line()
                .save(this.getComponentFile())
                ;
    }
    
    private void generateTestPage() throws IOException {
        new Src()
                .line("<!DOCTYPE html>")
                .begin("<html>")
                .begin("<head>")
                .line("<meta charset=\"utf-8\" />")
                .line("<title>%s</title>", this.gameModel.translate(this.gameModel.getSelectedLanguages().get(0), this.gameModel.getTitle().getSource()))
                .line("<script type=\"text/javascript\" src=\"%s\"></script>", JQUERY_FILE)
                .line("<script type=\"text/javascript\" src=\"%s\"></script>", COMPONENT_FILE)
                .begin("<script type=\"text/javascript\">")
                .begin("(function($) {")
                .begin("$(function() {")
                .line("$('.game').game();")
                .begin("$(window).resize(function() {")
                .line("console.log(\"\" + $(window).width() + \"x\" + $(window).height());")
                .end("});")
                .end("});")
                .end("})(jQuery);")
                .end("</script>")
                .end("</head>")
                .begin("<body>")
                .line("<span class=\"game\" style=\"display: inline-block; width: 200px; height: 160px;\"></span>")
                .line("<span class=\"game\" style=\"display: inline-block; width: 400px; height: 360px;\"></span>")
                .line("<div class=\"game\" style=\"height: 560px;\"></div>")
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

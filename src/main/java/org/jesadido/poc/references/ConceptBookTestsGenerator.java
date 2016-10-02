/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.references;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.scripting.Src;
import org.jesadido.poc.core.semantics.ConceptBook;
import org.jesadido.poc.core.semantics.translating.TranslatorFactory;

public class ConceptBookTestsGenerator {
    
    private final ConceptBook conceptBook;
    private final String javaInstancePhrase;
    private final String javaIdentifierPhrase;
    
    public ConceptBookTestsGenerator(final ConceptBook conceptBook, final String javaInstancePhrase, final String javaIdentifierPhrase) {
        this.conceptBook = conceptBook;
        this.javaInstancePhrase = javaInstancePhrase;
        this.javaIdentifierPhrase = javaIdentifierPhrase;
    }
    
    public Src generate() {
        return this.generateTranslationTests();
    }
    
    private Src generateTranslationTests() {
        return generateTranslationTestMethods();
    }
    
    private Src generateTranslationTestMethods() {
        final Src result = new Src(Integer.MAX_VALUE, "", "    ", "\r\n").line().inc();
        for (int i = 0; i < this.conceptBook.getReferenceSources().size(); i++) {
            result.add(generateTranslationTestMethod(i, this.conceptBook.getReferenceSources().get(i)));
        }
        return result.dec().line();
    }
    
    private Src generateTranslationTestMethod(final int methodNumber, final String source) {
        final Src result = new Src()
                .line()
                .line("@Test")
                .begin("public void testMethod%03d%s%s() {", methodNumber, javaIdentifierPhrase, new SimpleDateFormat("yyyyMMddhhmmsszzz").format(new Date()))
                .line("final String source = \"%s\";", source)
                ;
        for (final Language language : Language.values()) {
            final String translation = TranslatorFactory.createTranslator(language, this.conceptBook).translate(source).getTranslation();
            result.line("Assert.assertEquals(\"%s\", TranslatorFactory.createTranslator(Language.%s, %s).translate(source).getTranslation());", translation, language.name(), this.javaInstancePhrase);
        }
        return result.end("}");
    }
}

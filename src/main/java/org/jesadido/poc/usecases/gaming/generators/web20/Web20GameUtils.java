/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.usecases.gaming.generators.web20;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.jesadido.poc.core.Language;
import org.jesadido.poc.usecases.gaming.graphics.Rgbo;

public final class Web20GameUtils {
    
    private Web20GameUtils() {
        // A private utility class constructor
    }
    
    public static void fileCopy(File source, File target) throws IOException {
        if (!target.getParentFile().exists()) {
            target.getParentFile().mkdirs();
        }
        Files.copy(new FileInputStream(source.getAbsolutePath().replace("%20", " ")), target.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
    
    public static String toCssRgba(final Rgbo rgbo) {
        return String.format(Locale.ENGLISH, "rgba(%s, %s, %s, %3.2f)", rgbo.getRed(), rgbo.getGreen(), rgbo.getBlue(), rgbo.getOpacity());
    }
    
    public static String toJsLanguageArray(final List<Language> languages) {
        final List<String> formattedLanguages = new LinkedList<>();
        languages.stream().forEach(language -> formattedLanguages.add(String.format("'%s'", language.getCode())));
        return String.format("[%s]", String.join(", ", formattedLanguages));
    }
}

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
}

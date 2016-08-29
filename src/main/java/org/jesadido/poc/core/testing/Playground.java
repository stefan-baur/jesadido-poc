/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.testing;

import java.util.logging.Logger;
import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.semantics.translating.Translator;
import org.jesadido.poc.core.semantics.translating.TranslatorFactory;

public final class Playground {
    
    private Playground() {
        // A private playground class constructor
    }
    
    public static void nextTranslations() {
        for (final Language language : Language.values()) {
            final Translator translator = TranslatorFactory.createTranslator(language, References.GAME_BOOK);
            final String translation = translator.translate("HeroIcxO HavAs Fin SkribIlO Al HeroInO .").getTranslation();
            Logger.getAnonymousLogger().info(translation);
        }
    }
    
    public static void main(final String[] arguments) {
        nextTranslations();
    }
}

/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.semantics;

import java.util.EnumMap;
import java.util.Map;
import org.jesadido.poc.core.Language;
import org.jesadido.poc.core.semantics.de.DeTranslator;
import org.jesadido.poc.core.semantics.en.EnTranslator;
import org.jesadido.poc.core.semantics.eo.EoTranslator;
import org.jesadido.poc.core.semantics.es.EsTranslator;
import org.jesadido.poc.core.semantics.fr.FrTranslator;
import org.jesadido.poc.core.semantics.ji.JiTranslator;

public final class TranslatorFactory {
    
    private static final Map<Language, Creator> TRANSLATORS = new EnumMap<>(Language.class);
    
    static {
        TRANSLATORS.put(Language.DE, (Creator) (ConceptBook conceptBook) -> new DeTranslator(conceptBook));
        TRANSLATORS.put(Language.EN, (Creator) (ConceptBook conceptBook) -> new EnTranslator(conceptBook));
        TRANSLATORS.put(Language.EO, (Creator) (ConceptBook conceptBook) -> new EoTranslator(conceptBook));
        TRANSLATORS.put(Language.ES, (Creator) (ConceptBook conceptBook) -> new EsTranslator(conceptBook));
        TRANSLATORS.put(Language.FR, (Creator) (ConceptBook conceptBook) -> new FrTranslator(conceptBook));
        TRANSLATORS.put(Language.JI, (Creator) (ConceptBook conceptBook) -> new JiTranslator(conceptBook));
    }
    
    private TranslatorFactory() {
        // A private factory class constructor
    }
    
    public static Translator createTranslator(final Language language, final ConceptBook conceptBook) {
        if (TRANSLATORS.containsKey(language)) {
            return TRANSLATORS.get(language).create(conceptBook);
        }
        return new JiTranslator(conceptBook);
    }
    
    @FunctionalInterface
    private interface Creator {
        
        Translator create(final ConceptBook conceptBook);
    }
}

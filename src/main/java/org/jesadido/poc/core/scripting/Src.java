/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.scripting;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.LinkedList;
import java.util.List;
import org.jesadido.poc.core.StringUtils;

public final class Src {
    
    public static final String DEFAULT_INDENT = "\t";
    public static final String DEFAULT_NEWLINE = "\r\n";
    
    private final int compressionLevel;
    private final String indent;
    private final String newline;
    
    private final List<Item> items = new LinkedList<>();
    
    public Src(final int compressionLevel, final String indent, final String newline) {
        this.compressionLevel = compressionLevel;
        this.indent = indent;
        this.newline = newline;
    }
    
    public Src(final int compressionLevel) {
        this(compressionLevel, DEFAULT_INDENT, DEFAULT_NEWLINE);
    }
    
    public Src() {
        this(Integer.MAX_VALUE);
    }
    
    public final int getCompressionLevel() {
        return this.compressionLevel;
    }
    
    public final String getIndent() {
        return this.indent;
    }
    
    public final String getNewline() {
        return this.newline;
    }
    
    public final Src begin(final String format, final Object ... arguments) {
        this.items.add(Item.INDENT);
        this.items.add(Item.OPEN);
        this.items.add(Item.createSnippet(format, arguments));
        this.items.add(Item.BREAK);
        this.items.add(Item.INC);
        return this;
    }
    
    public final Src end(final String format, final Object ... arguments) {
        this.items.add(Item.DEC);
        this.items.add(Item.INDENT);
        this.items.add(Item.createSnippet(format, arguments));
        this.items.add(Item.CLOSE);
        this.items.add(Item.BREAK);
        return this;
    }
    
    public final Src endBegin(final String format, final Object ... arguments) {
        this.items.add(Item.DEC);
        this.items.add(Item.INDENT);
        this.items.add(Item.createSnippet(format, arguments));
        this.items.add(Item.BREAK);
        this.items.add(Item.INC);
        return this;
    }
    
    public final Src line(final String format, final Object ... arguments) {
        this.items.add(Item.INDENT);
        this.items.add(Item.createSnippet(format, arguments));
        this.items.add(Item.BREAK);
        return this;
    }
    
    public final Src line() {
        this.items.add(Item.BREAK);
        return this;
    }
    
    public final Src beginLine(final String format, final Object ... arguments) {
        this.items.add(Item.INDENT);
        this.items.add(Item.createSnippet(format, arguments));
        return this;
    }
    
    public final Src endLine(final String format, final Object ... arguments) {
        this.items.add(Item.createSnippet(format, arguments));
        this.items.add(Item.BREAK);
        return this;
    }
    
    public final Src snippet(final String format, final Object ... arguments) {
        this.items.add(Item.createSnippet(format, arguments));
        return this;
    }
    
    public final Src inc() {
        this.items.add(Item.INC);
        return this;
    }
    
    public final Src dec() {
        this.items.add(Item.DEC);
        return this;
    }
    
    public final Src add(final Src other) {
        if (other != null) {
            this.items.addAll(other.items);
        }
        return this;
    }
    
    public final Src save(final File target) throws IOException {
        if (!target.getParentFile().exists()) {
            target.getParentFile().mkdirs();
        }
        try (final Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(target), StringUtils.UTF_8))) {
            writer.write(this.toString());
        }
        return this;
    }
    
    @Override
    public final String toString() {
        final StringBuilder result = new StringBuilder();
        int compression = 0;
        int indentValue = 0;
        for (final Item item : this.items) {
            if (item == Item.OPEN) {
                compression++;
            } else if (item == Item.CLOSE) {
                compression--;
            } else if (item == Item.INC) {
                indentValue++;
            } else if (item == Item.DEC) {
                indentValue--;
            } else if (item == Item.INDENT) {
                if (this.compressionLevel >= compression) {
                    result.append(StringUtils.repeat(indentValue, indent));
                }
            } else if (item == Item.BREAK) {
                if (this.compressionLevel >= compression) {
                    result.append(this.newline);
                }
            } else {
                result.append(item.getSnippet());
            }
        }
        return result.toString();
    }
    
    private static final class Item {
        
        static final Item OPEN = new Item(null);
        static final Item CLOSE = new Item(null);
        static final Item INC = new Item(null);
        static final Item DEC = new Item(null);
        static final Item BREAK = new Item(null);
        static final Item INDENT = new Item(null);
        
        private final String snippet;
        
        Item(final String snippet) {
            this.snippet = snippet;
        }
        
        final String getSnippet() {
            return this.snippet;
        }
        
        static final Item createSnippet(final String format, final Object ... arguments) {
            return new Item(String.format(format, arguments));
        }
    }
}

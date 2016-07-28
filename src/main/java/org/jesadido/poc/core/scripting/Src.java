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

/**
 * This <code>Src</code> class can be used for generating any UTF-8 source
 * codes for example Java-code, HTML-code, CSS-code, PHP-code, and more.
 */
public final class Src {
    
    /**
     * The default indentation phrase.
     */
    public static final String DEFAULT_INDENT = "\t";
    
    /**
     * The default phrase for a new line.
     */
    public static final String DEFAULT_NEWLINE = "\r\n";
    
    private final int compressionLevel;
    private final String indent;
    private final String newline;
    
    private final List<Item> items = new LinkedList<>();
    
    /**
     * Constructor.
     * @param compressionLevel The compression level
     * (<code>Integer.MAX_VALUE</code> for no compression; <code>0</code> for
     * full compression).
     * @param indent The indentation phrase.
     * @param newline The phrase for a new line.
     */
    public Src(final int compressionLevel, final String indent, final String newline) {
        this.compressionLevel = compressionLevel;
        this.indent = indent;
        this.newline = newline;
    }
    
    /**
     * Constructor.
     * @param compressionLevel The compression level
     * (<code>Integer.MAX_VALUE</code> for no compression; <code>0</code> for
     * full compression).
     */
    public Src(final int compressionLevel) {
        this(compressionLevel, DEFAULT_INDENT, DEFAULT_NEWLINE);
    }
    
    /**
     * Default Constructor.
     */
    public Src() {
        this(Integer.MAX_VALUE);
    }
    
    /**
     * Returns the compression level of this instance
     * (<code>Integer.MAX_VALUE</code> for no compression; <code>0</code> for
     * full compression).
     * @return The compression level.
     */
    public final int getCompressionLevel() {
        return this.compressionLevel;
    }
    
    /**
     * Returns the indentation phrase of this instance.
     * @return The indentation phrase.
     */
    public final String getIndent() {
        return this.indent;
    }
    
    /**
     * Returns the new-line phrase of this instance.
     * @return The new-line phrase.
     */
    public final String getNewline() {
        return this.newline;
    }
    
    /**
     * Opens a new code-block with the given format string and its arguments.
     * @param format The given format string.
     * @param arguments The given arguments.
     * @return This instance for method-chaining.
     */
    public final Src begin(final String format, final Object ... arguments) {
        this.items.add(Item.INDENT);
        this.items.add(Item.OPEN);
        this.items.add(Item.createSnippet(format, arguments));
        this.items.add(Item.BREAK);
        this.items.add(Item.INC);
        return this;
    }
    
    /**
     * Closes a code-block with the given format string and its arguments.
     * @param format The given format string.
     * @param arguments The given arguments.
     * @return This instance for method-chaining.
     */
    public final Src end(final String format, final Object ... arguments) {
        this.items.add(Item.DEC);
        this.items.add(Item.INDENT);
        this.items.add(Item.createSnippet(format, arguments));
        this.items.add(Item.CLOSE);
        this.items.add(Item.BREAK);
        return this;
    }
    
    /**
     * Closes a code-block and opens a new code-block with the given format
     * string and its arguments.
     * @param format The given format string.
     * @param arguments The given arguments.
     * @return This instance for method-chaining.
     */
    public final Src endBegin(final String format, final Object ... arguments) {
        this.items.add(Item.DEC);
        this.items.add(Item.INDENT);
        this.items.add(Item.createSnippet(format, arguments));
        this.items.add(Item.BREAK);
        this.items.add(Item.INC);
        return this;
    }
    
    /**
     * Writes a single code-line with the given format string and its arguments.
     * @param format The given format string.
     * @param arguments The given arguments.
     * @return This instance for method-chaining.
     */
    public final Src line(final String format, final Object ... arguments) {
        this.items.add(Item.INDENT);
        this.items.add(Item.createSnippet(format, arguments));
        this.items.add(Item.BREAK);
        return this;
    }
    
    /**
     * Writes an empty code-line with the given format string and its arguments.
     * @return This instance for method-chaining.
     */
    public final Src line() {
        this.items.add(Item.BREAK);
        return this;
    }
    
    /**
     * Opens a new code-line with the given format string and its arguments.
     * @param format The given format string.
     * @param arguments The given arguments.
     * @return This instance for method-chaining.
     */
    public final Src beginLine(final String format, final Object ... arguments) {
        this.items.add(Item.INDENT);
        this.items.add(Item.createSnippet(format, arguments));
        return this;
    }
    
    /**
     * Closes a code-line with the given format string and its arguments.
     * @param format The given format string.
     * @param arguments The given arguments.
     * @return This instance for method-chaining.
     */
    public final Src endLine(final String format, final Object ... arguments) {
        this.items.add(Item.createSnippet(format, arguments));
        this.items.add(Item.BREAK);
        return this;
    }
    
    /**
     * Writes a code-snippet with the given format string and its arguments.
     * @param format The given format string.
     * @param arguments The given arguments.
     * @return This instance for method-chaining.
     */
    public final Src snippet(final String format, final Object ... arguments) {
        this.items.add(Item.createSnippet(format, arguments));
        return this;
    }
    
    /**
     * Increments the repeatation of the indentation.
     * @return This instance for method-chaining.
     */
    public final Src inc() {
        this.items.add(Item.INC);
        return this;
    }
    
    /**
     * Decrements the repeatation of the indentation.
     * @return This instance for method-chaining.
     */
    public final Src dec() {
        this.items.add(Item.DEC);
        return this;
    }
    
    /**
     * Adds the items of another instance, only.
     * @param other The other instance (can be <code>null</code>).
     * @return This instance for method-chaining.
     */
    public final Src add(final Src other) {
        if (other != null) {
            this.items.addAll(other.items);
        }
        return this;
    }
    
    /**
     * Stores this UTF-8 source-code string to any file. The directories will be
     * created, if needed.
     * @param target The target file.
     * @return This instance for method-chaining.
     * @throws IOException An I/O-exception.
     */
    public final Src save(final File target) throws IOException {
        if (!target.getParentFile().exists()) {
            target.getParentFile().mkdirs();
        }
        try (final Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(target), StringUtils.UTF_8))) {
            writer.write(this.toString());
        }
        return this;
    }
    
    /**
     * Returns the UTF-8 source-code of this instance.
     * @return The source-code.
     */
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

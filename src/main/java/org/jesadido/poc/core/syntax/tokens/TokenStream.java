/*
 * jesadido-poc
 * Copyright (C) 2016 Stefan K. Baur
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0 (LGPL-3.0)
 * https://www.gnu.org/licenses/lgpl-3.0.txt
 */
package org.jesadido.poc.core.syntax.tokens;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jesadido.poc.core.CoreUtils;

public final class TokenStream implements Closeable {
    
    private static final Logger LOGGER = Logger.getLogger(TokenStream.class.getName());
    
    private final BufferedReader source;
    private final List<Token> peekQueue;
    
    public TokenStream(final InputStream source) {
        this.source = new BufferedReader(new InputStreamReader(source, CoreUtils.UTF_8));
        this.peekQueue = new LinkedList<>();
    }
    
    public TokenStream(final String source) {
        this(new ByteArrayInputStream(source.getBytes(CoreUtils.UTF_8)));
    }
    
    public final boolean has() {
        return this.has(1);
    }
    
    public final boolean has(final int count) {
        this.provideNextTokens(count);
        return this.peekQueue.size() >= count;
    }
    
    public final boolean hasSequence(final TokenType ... tokenTypes) {
        if (this.has(tokenTypes.length)) {
            for (int i = 0; i < tokenTypes.length; i++) {
                if (this.peekQueue.get(i).getType() != tokenTypes[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    public final boolean hasOneOf(final TokenType ... tokenTypes) {
        return this.has(1) && this.peekQueue.get(0).getType().isOneOf(tokenTypes);
    }
    
    public final Token peek() {
        this.provideNextTokens(1);
        return this.peekQueue.isEmpty() ? null : this.peekQueue.get(0);
    }
    
    public final List<Token> peek(final int count) {
        this.provideNextTokens(count);
        final List<Token> result = new LinkedList<>();
        final int minCount = Math.min(count, this.peekQueue.size());
        for (int i = 0; i < minCount; i++) {
            result.add(this.peekQueue.get(i));
        }
        return result;
    }
    
    public final Token next() {
        return this.peekQueue.isEmpty() ? null : this.peekQueue.remove(0);
    }
    
    public final List<Token> next(final int count) {
        final List<Token> result = new LinkedList<>();
        final int minCount = Math.min(count, this.peekQueue.size());
        for (int i = 0; i < minCount; i++) {
            result.add(this.next());
        }
        return result;
    }
    
    @Override
    public void close() throws IOException {
        this.source.close();
    }
    
    private void provideNextTokens(final int count) {
        final int maxCount = Math.max(count, this.peekQueue.size());
        try {
            while (this.peekQueue.size() < maxCount) {
                Token token = this.readToken();
                if (token == null) {
                    return;
                }
                this.peekQueue.add(token);
            }
        } catch (IOException exception) {
            LOGGER.log(Level.SEVERE, "Cannot provide the next tokens, because of an IO-exception.", exception);
        }
    }
    
    private Token readToken() throws IOException {
        final StringBuilder value = new StringBuilder();
        int c;
        boolean skipping = true;
        while ((c = this.source.read()) != -1) {
            final char character = (char) c;
            final boolean whitespace = Character.isWhitespace(character);
            if (!skipping && whitespace) {
                break;
            }
            if (!whitespace) {
                value.append(character);
                skipping = false;
            }
        }
        final String conceptPhrase = value.toString();
        if (conceptPhrase.length() > 0) {
            return Token.create(conceptPhrase);
        }
        return null;
    }
}

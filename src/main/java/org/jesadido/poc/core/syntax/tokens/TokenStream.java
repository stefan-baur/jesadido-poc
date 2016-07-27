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
import org.jesadido.poc.core.StringUtils;

/**
 * This <code>TokenStream</code> class implements the token iteration accoring
 * a <b>Jesadido</b> source code for the purpose of parsing.
 */
public final class TokenStream implements Closeable {
    
    private static final Logger LOGGER = Logger.getLogger(TokenStream.class.getName());
    
    private final BufferedReader source;
    private final TokenCreator tokenCreator;
    private final List<Token> peekQueue;
    
    /**
     * Class constructor.
     * @param source The <b>Jesadido</b> source code as an
     * <code>InputStream</code>.
     * @param tokenCreator The factory instance for creating token instances.
     * <code>InputStream</code>.
     */
    public TokenStream(final InputStream source, final TokenCreator tokenCreator) {
        this.source = new BufferedReader(new InputStreamReader(source, StringUtils.UTF_8));
        this.tokenCreator = tokenCreator;
        this.peekQueue = new LinkedList<>();
    }
    
    /**
     * Class constructor.
     * @param source The <b>Jesadido</b> source code as a <code>String</code>.
     * @param tokenCreator The factory instance for creating token instances.
     */
    public TokenStream(final String source, final TokenCreator tokenCreator) {
        this(new ByteArrayInputStream(source.getBytes(StringUtils.UTF_8)), tokenCreator);
    }
    
    /**
     * Indicates whether one next token can be fetched via the methods
     * <code>peek()</code> and <code>next()</code>.
     * @return <code>true</code> if there is at least one token returnable.
     */
    public final boolean has() {
        return this.has(1);
    }
    
    /**
     * Indicates whether a determined number of next tokens can be fetched via
     * the methods <code>peek(int)</code> and <code>next(int)</code>.
     * @param count The determined number of next tokens.
     * @return <code>true</code> if there are at least the determined number of
     * next tokens returnable.
     */
    public final boolean has(final int count) {
        this.provideNextTokens(count);
        return this.peekQueue.size() >= count;
    }
    
    /**
     * Indicates whether a token sequence with the given token types are
     * available via the methods <code>peek(int)</code> and
     * <code>next(int)</code>.
     * @param tokenTypes The given token types.
     * @return <code>true</code> if there is a token sequence according to the
     * given token types available.
     */
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
    
    /**
     * Indicates whether one next token typed by the given token types can be
     * fetched via the methods <code>peek()</code> and <code>next()</code>.
     * @param tokenTypes The given token types.
     * @return <code>true</code> if there is at least one token with at least
     * one of the given token types returnable.
     */
    public final boolean hasOneOf(final TokenType ... tokenTypes) {
        return this.has(1) && this.peekQueue.get(0).getType().isOneOf(tokenTypes);
    }
    
    /**
     * Indicates whether one next token typed by the given token types can be
     * fetched via the methods <code>peek()</code> and <code>next()</code>.
     * @param tokenTypes The given token types.
     * @return <code>true</code> if there is at least one token with at least
     * one of the given token types returnable.
     */
    public final boolean hasOneOf(final List<TokenType> tokenTypes) {
        return this.has(1) && this.peekQueue.get(0).getType().isOneOf(tokenTypes);
    }
    
    /**
     * Returns the next token instance without consuming it from the token
     * stream.
     * @return <code>null</code> if there is no next token available, or if an
     * <code>IOException</code> is happened.
     */
    public final Token peek() {
        this.provideNextTokens(1);
        return this.peekQueue.isEmpty() ? null : this.peekQueue.get(0);
    }
    
    /**
     * Returns a determined number of next token instances without consuming
     * these tokens from the token stream.
     * @param count The determined number of next tokens.
     * @return The available next tokens with <code>count</code> as maximum
     * value.
     */
    public final List<Token> peek(final int count) {
        this.provideNextTokens(count);
        final List<Token> result = new LinkedList<>();
        final int minCount = Math.min(count, this.peekQueue.size());
        for (int i = 0; i < minCount; i++) {
            result.add(this.peekQueue.get(i));
        }
        return result;
    }
    
    /**
     * Returns the next token instance with consuming it from the token stream.
     * @return <code>null</code> if there is no next token available, or if an
     * <code>IOException</code> is happened.
     */
    public final Token next() {
        return this.peekQueue.isEmpty() ? null : this.peekQueue.remove(0);
    }
    
    /**
     * Returns a determined number of next token instances with consuming these
     * tokens from the token stream.
     * @param count The determined number of next tokens.
     * @return The available next tokens with <code>count</code> as maximum
     * value.
     */
    public final List<Token> next(final int count) {
        final List<Token> result = new LinkedList<>();
        final int minCount = Math.min(count, this.peekQueue.size());
        for (int i = 0; i < minCount; i++) {
            result.add(this.next());
        }
        return result;
    }
    
    /**
     * Closes the capsulated reader.
     * @throws IOException If an I/O error occurs.
     */
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
            return this.tokenCreator.create(conceptPhrase);
        }
        return null;
    }
}

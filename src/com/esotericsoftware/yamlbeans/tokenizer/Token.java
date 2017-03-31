/*
 * Copyright (c) 2008 Nathan Sweet
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy,
 * modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software
 * is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR
 * IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.esotericsoftware.yamlbeans.tokenizer;

/** @author <a href="mailto:misc@n4te.com">Nathan Sweet</a> */
public class Token {
	public final static Token DOCUMENT_START = new Token(TokenType.DOCUMENT_START);
	public final static Token DOCUMENT_END = new Token(TokenType.DOCUMENT_END);
	public final static Token BLOCK_MAPPING_START = new Token(TokenType.BLOCK_MAPPING_START);
	public final static Token BLOCK_SEQUENCE_START = new Token(TokenType.BLOCK_SEQUENCE_START);
	public final static Token BLOCK_ENTRY = new Token(TokenType.BLOCK_ENTRY);
	public final static Token BLOCK_END = new Token(TokenType.BLOCK_END);
	public final static Token FLOW_ENTRY = new Token(TokenType.FLOW_ENTRY);
	public final static Token FLOW_MAPPING_END = new Token(TokenType.FLOW_MAPPING_END);
	public final static Token FLOW_MAPPING_START = new Token(TokenType.FLOW_MAPPING_START);
	public final static Token FLOW_SEQUENCE_END = new Token(TokenType.FLOW_SEQUENCE_END);
	public final static Token FLOW_SEQUENCE_START = new Token(TokenType.FLOW_SEQUENCE_START);
	public final static Token KEY = new Token(TokenType.KEY);
	public final static Token VALUE = new Token(TokenType.VALUE);
	public final static Token STREAM_END = new Token(TokenType.STREAM_END);
	public final static Token STREAM_START = new Token(TokenType.STREAM_START);

	public final TokenType type;

	public Token (TokenType type) {
		this.type = type;
	}

	public String toString () {
		return "<" + type + ">";
	}
}

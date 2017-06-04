package com.esotericsoftware.yamlbeans.tokenizer;


public class TokenizerException extends RuntimeException {
	
	static int lineNumber = 0;
	static int column = 0;
	
	
	public static int getLineNumber () {
		return lineNumber;
	}

	public static int getColumn () {
		return column;
	}

	
	public TokenizerException (String message, Throwable cause) {
		super("Line " + getLineNumber() + ", column " + getColumn() + ": " + message, cause);
	}

	public TokenizerException (String message) {
		this(message, null);
	}
}

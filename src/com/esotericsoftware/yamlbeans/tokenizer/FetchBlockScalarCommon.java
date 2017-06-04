package com.esotericsoftware.yamlbeans.tokenizer;

import java.io.Reader;

public abstract class FetchBlockScalarCommon extends Tokenizer {
	public FetchBlockScalarCommon(Reader reader) {
		super(reader);
		// TODO Auto-generated constructor stub
	}

	protected abstract Token fetchCommon();
	
	public Token fetchTok () {
		allowSimpleKey = true;
		Token tok = fetchCommon();
		tokens.add(tok);
		return tok;
	}
}

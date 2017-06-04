package com.esotericsoftware.yamlbeans.tokenizer;

import java.io.Reader;

public class FetchBlockLiteral extends FetchBlockScalarCommon {
	public FetchBlockLiteral(Reader reader) {
		super(reader);
		// TODO Auto-generated constructor stub
	}
	
	public Token fetchCommon()
	{
		Token tok = scanBlockScalar('>');
		return tok;
	}

}

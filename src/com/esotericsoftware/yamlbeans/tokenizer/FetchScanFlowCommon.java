package com.esotericsoftware.yamlbeans.tokenizer;

import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.esotericsoftware.yamlbeans.parser.Parser;
import com.esotericsoftware.yamlbeans.tokenizer.TokenizerCommon.SimpleKey;



public abstract class FetchScanFlowCommon extends Tokenizer {
	
	public FetchScanFlowCommon(Reader reader) {
		super(reader);
		// TODO Auto-generated constructor stub
	}


	protected abstract Token fetchCommon();
	
	public Token fetchTok () {
		savePossibleSimpleKey();
		allowSimpleKey = false;
		Token tok = fetchCommon();
		tokens.add(tok);
		return tok;
	}
}

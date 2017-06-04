package com.esotericsoftware.yamlbeans.tokenizer;

import java.io.Reader;

public class FetchScanFlowDouble extends FetchScanFlowCommon {
	public FetchScanFlowDouble(Reader reader) {
		super(reader);
		// TODO Auto-generated constructor stub
	}

	public Token fetchCommon()
	{
		Token tok = scanFlowScalar('"');
		return tok;
	}
}

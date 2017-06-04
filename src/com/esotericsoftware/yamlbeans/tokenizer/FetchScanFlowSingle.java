package com.esotericsoftware.yamlbeans.tokenizer;
import java.io.Reader;
import java.util.regex.Pattern;

public class FetchScanFlowSingle extends FetchScanFlowCommon {
	
	public FetchScanFlowSingle(Reader reader) {
		super(reader);
		// TODO Auto-generated constructor stub
	}

	public Token fetchCommon()
	{
		Token tok = scanFlowScalar('\'');
		return tok;
	}
}

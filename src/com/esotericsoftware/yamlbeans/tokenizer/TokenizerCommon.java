package com.esotericsoftware.yamlbeans.tokenizer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public abstract class TokenizerCommon {
	
	protected final static Map<Character, String> ESCAPE_REPLACEMENTS = new HashMap();
	protected final static Map<Character, Integer> ESCAPE_CODES = new HashMap();

	static {
		ESCAPE_REPLACEMENTS.put('0', "\0");
		ESCAPE_REPLACEMENTS.put('a', "\u0007");
		ESCAPE_REPLACEMENTS.put('b', "\u0008");
		ESCAPE_REPLACEMENTS.put('t', "\u0009");
		ESCAPE_REPLACEMENTS.put('\t', "\u0009");
		ESCAPE_REPLACEMENTS.put('n', "\n");
		ESCAPE_REPLACEMENTS.put('v', "\u000B");
		ESCAPE_REPLACEMENTS.put('f', "\u000C");
		ESCAPE_REPLACEMENTS.put('r', "\r");
		ESCAPE_REPLACEMENTS.put('e', "\u001B");
		ESCAPE_REPLACEMENTS.put(' ', "\u0020");
		ESCAPE_REPLACEMENTS.put('"', "\"");
		ESCAPE_REPLACEMENTS.put('\\', "\\");
		ESCAPE_REPLACEMENTS.put('N', "\u0085");
		ESCAPE_REPLACEMENTS.put('_', "\u00A0");
		ESCAPE_REPLACEMENTS.put('L', "\u2028");
		ESCAPE_REPLACEMENTS.put('P', "\u2029");

		ESCAPE_CODES.put('x', 2);
		ESCAPE_CODES.put('u', 4);
		ESCAPE_CODES.put('U', 8);
	}
	
	protected boolean allowSimpleKey = true;
	protected int flowLevel = 0;
	protected int tokensTaken = 0;

	//protected int lineNumber = 0;
	//protected int column = 0;
	
	protected int pointer = 0;

	protected boolean eof;
	protected int indent = -1;

	protected boolean docStart = false;
	
	protected final static String LINEBR = "\n\u0085\u2028\u2029";
	protected final static String ALPHA = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-_";
	protected final static String NULL_BL_T_LINEBR = "\0 \t\r\n\u0085";
	protected final static String NULL_OR_OTHER = NULL_BL_T_LINEBR;
	protected final static String NULL_BL_LINEBR = "\0 \r\n\u0085";
	protected final static String FULL_LINEBR = "\r\n\u0085";
	protected final static String RN = "\r\n";
	protected final static String NULL_OR_LINEBR = "\0\r\n\u0085";
	protected final static String BLANK_OR_LINEBR = " \r\n\u0085";
	protected final static String S4 = "\0 \t\r\n\u0028[]{}";
	protected final static String STRANGE_CHAR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][-';/?:@&=+$,.!~*()%";
	protected final static Pattern NON_PRINTABLE = Pattern.compile("[^\u0009\n\r\u0020-\u007E\u0085\u00A0-\u00FF]");
	protected final static Pattern R_FLOWZERO = Pattern.compile("[\0 \t\r\n\u0085]|(:[\0 \t\r\n\u0028])");
	protected final static Pattern R_FLOWNONZERO = Pattern.compile("[\0 \t\r\n\u0085\\[\\]{},:?]");
	protected final static Pattern END_OR_START = Pattern.compile("^(---|\\.\\.\\.)[\0 \t\r\n\u0085]$");
	protected final static Pattern ENDING = Pattern.compile("^---[\0 \t\r\n\u0085]$");
	protected final static Pattern START = Pattern.compile("^\\.\\.\\.[\0 \t\r\n\u0085]$");
	protected final static String BLANK_T = " \t";
	protected final static String NON_ALPHA_OR_NUM = "\0 \t\r\n\u0085?:,]}%@`";
	protected final static String DOUBLE_ESC = "\"\\";
	protected final static Pattern NOT_HEXA = Pattern.compile("[^0-9A-Fa-f]");
	protected final static Pattern NON_ALPHA = Pattern.compile("[^-0-9A-Za-z_]");
	protected final static String SPACES_AND_STUFF = "'\"\\\0 \t\r\n\u0085";
	protected final static Pattern BEG = Pattern
		.compile("^([^\0 \t\r\n\u0085\\-?:,\\[\\]{}#&*!|>'\"%@]|([\\-?:][^\0 \t\r\n\u0085]))");
	
	
	
	
	static class SimpleKey {
		public final int tokenNumber;
		public final int column;

		public SimpleKey (int tokenNumber, int column) {
			this.tokenNumber = tokenNumber;
			this.column = column;
		}
	}
	

	protected String ch (char ch) {
		return "'" + ch + "' (" + (int)ch + ")";
	}
	


}

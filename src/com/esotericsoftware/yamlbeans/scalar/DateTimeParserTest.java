package com.esotericsoftware.yamlbeans.scalar;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.esotericsoftware.yamlbeans.scalar.DateTimeParser.Parser;
import com.esotericsoftware.yamlbeans.scalar.DateTimeParser.SimpleParser;

import sun.util.resources.CalendarData;

public class DateTimeParserTest {
	private static final String DATEFORMAT_YAML = "yyyy-MM-dd HH:mm:ss";
	private static final int FORMAT_NONE = -1;
	private SimpleDateFormat outputFormat;
	DateTimeParser dateTimeParser = new DateTimeParser();
	private ArrayList<Parser> parsers = new ArrayList<Parser>();
	
	@Test
	public void testDateTimeParser() throws ParseException {
		String s = "1993-07-01 11:22:33";
		
		assertEquals(true, parsers.add(new SimpleParser(s)));
		
		assertEquals(true, parsers.add(new SimpleParser(DateFormat.FULL, DateFormat.FULL)));
		assertEquals(true, parsers.add(new SimpleParser(DateFormat.LONG, DateFormat.LONG)));
		assertEquals(true, parsers.add(new SimpleParser(DateFormat.MEDIUM, DateFormat.MEDIUM)));
		assertEquals(true, parsers.add(new SimpleParser(DateFormat.SHORT, DateFormat.SHORT)));
		
		assertEquals(true, parsers.add(new SimpleParser(DateFormat.FULL, FORMAT_NONE)));
		assertEquals(true, parsers.add(new SimpleParser(DateFormat.LONG, FORMAT_NONE)));
		assertEquals(true, parsers.add(new SimpleParser(DateFormat.MEDIUM, FORMAT_NONE)));
		assertEquals(true, parsers.add(new SimpleParser(DateFormat.SHORT, FORMAT_NONE)));
		
		assertEquals(true, parsers.add(new SimpleParser(FORMAT_NONE, DateFormat.FULL)));
		assertEquals(true, parsers.add(new SimpleParser(FORMAT_NONE, DateFormat.LONG)));
		assertEquals(true, parsers.add(new SimpleParser(FORMAT_NONE, DateFormat.MEDIUM)));
		assertEquals(true, parsers.add(new SimpleParser(FORMAT_NONE, DateFormat.SHORT)));
	}
	
	@Test
	public void testParseStringParsePosition() {
		String text1 = "7:03:47 AM PDT";
		ParsePosition pos1 = new ParsePosition(0);
		Date date1 = dateTimeParser.parse(text1, pos1);
		assertEquals(null, date1);
		
		String text2 = "7:03:47 AM";
		ParsePosition pos2 = new ParsePosition(0);
		Date date2 = dateTimeParser.parse(text2, pos2);
		assertEquals(null, date2);
		
		String text3 = "7:03 AM";
		ParsePosition pos3 = new ParsePosition(0);
		Date date3 = dateTimeParser.parse(text3, pos3);
		assertEquals(null, date3);
		
		String text4 = "1993";
		ParsePosition pos4 = new ParsePosition(0);
		Date date4 = dateTimeParser.parse(text4, pos4);
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(date4);
		assertEquals(1993, Long.parseLong(text4));
	}

	@Test
	public final void testFormatDateStringBufferFieldPosition() throws ParseException {
		SimpleDateFormat outputFormat = new SimpleDateFormat();
		String s = "1993-07-01 11:22:33";
		Date date = dateTimeParser.parse(s);
		FieldPosition pos = new FieldPosition(0);
		StringBuffer buf = new StringBuffer(0);	
//		assertEquals(buf.length(), outputFormat.format(date, buf, pos));
	}
}

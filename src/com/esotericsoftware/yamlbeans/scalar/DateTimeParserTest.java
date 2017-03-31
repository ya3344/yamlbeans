package com.esotericsoftware.yamlbeans.scalar;

import static org.junit.Assert.*;

import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.esotericsoftware.yamlbeans.scalar.DateTimeParser.Parser;

import junit.framework.Assert;

public class DateTimeParserTest {

	private static final String DATEFORMAT_YAML = "yyyy-MM-dd HH:mm:ss";
	private static final int FORMAT_NONE = -1;

	DateTimeParser dateTimeParser = new DateTimeParser();
	@Test
	public void testDateTimeParser() throws ParseException {
        Date date = dateTimeParser.parse("2017-03-31 22:06:13");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        assertEquals(2017, calendar.get(Calendar.YEAR));
        assertEquals(2, calendar.get(Calendar.MONTH));
        assertEquals(31, calendar.get(Calendar.DAY_OF_MONTH));
        assertEquals(22, calendar.get(Calendar.HOUR_OF_DAY));
        assertEquals(06, calendar.get(Calendar.MINUTE));
        assertEquals(13, calendar.get(Calendar.SECOND));
	}

	@Test
	public void testParseStringParsePosition() throws ParseException {
		String text = "7:03 AM";
		ParsePosition pos = new ParsePosition(0);
		Date date = dateTimeParser.parse(text, pos);		
	}

	@Test
	public void testFormatDateStringBufferFieldPosition() throws ParseException {
		SimpleDateFormat outputFormat = new SimpleDateFormat();
		Date date = dateTimeParser.parse("2017-03-31 22:06:13");
		FieldPosition pos = new FieldPosition(0);
		StringBuffer buf = new StringBuffer();
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
		outputFormat.format(date, buf, pos);
	}

}

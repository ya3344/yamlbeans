package com.esotericsoftware.yamlbeans.scalar;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.esotericsoftware.yamlbeans.YamlException;

public class DateSerializerTest {
	private DateTimeParser dateParser = new DateTimeParser();
	
	@Test
	public void testRead() throws ParseException, YamlException {
		String value = "1993-07-01 11:22:33";
		Date date = dateParser.parse(value);
		DateSerializer dateSerializer1 = new DateSerializer();
		assertEquals(dateSerializer1.read(value), date);
		
		String value2 = "1993-07-01 11:22";
		Date date2 = dateParser.parse(value2);
		DateSerializer dateSerializer2 = new DateSerializer();
		assertEquals(dateSerializer2.read(value2), date2);
		
		String value3 = "1993-07-01 11";
		Date date3 = dateParser.parse(value3);
		DateSerializer dateSerializer3 = new DateSerializer();
		assertEquals(dateSerializer3.read(value3), date3);
		
		String value4 = "1993-07-01";
		Date date4 = dateParser.parse(value4);
		DateSerializer dateSerializer4 = new DateSerializer();
		assertEquals(dateSerializer4.read(value4), date4);

		String value5 = "1993";
		Date date5 = dateParser.parse(value5);
		DateSerializer dateSerializer5 = new DateSerializer();
		assertEquals(dateSerializer5.read(value5), date5);

		String incorrect = "12:34:56";
		DateSerializer dateSerializer6 = new DateSerializer();
		assertEquals("invalid date: " + incorrect, dateSerializer6.read(incorrect));
		
	}

	@Test
	public void testWrite() throws ParseException, YamlException {
		DateSerializer dateSerializer = new DateSerializer();
		String text = "1993-07-01 11:22:33";
		Date date = dateParser.parse(text);
		assertEquals(dateSerializer.write(date), dateParser.format(date));
		
		DateSerializer dateSerializer2 = new DateSerializer();
		String text2 = "1993-07-01 11:22";
		Date date2 = dateParser.parse(text2);
		assertEquals(dateSerializer2.write(date2), dateParser.format(date2));
		
		DateSerializer dateSerializer3 = new DateSerializer();
		String text3 = "1993-07-01 11";
		Date date3 = dateParser.parse(text3);
		assertEquals(dateSerializer3.write(date3), dateParser.format(date3));
		
		DateSerializer dateSerializer4 = new DateSerializer();
		String text4 = "1993-07-01";
		Date date4 = dateParser.parse(text4);
		assertEquals(dateSerializer4.write(date4), dateParser.format(date4));
		
		DateSerializer dateSerializer5 = new DateSerializer();
		String text5 = "1993";
		Date date5 = dateParser.parse(text5);
		assertEquals(dateSerializer5.write(date5), dateParser.format(date5));
		
		DateSerializer dateSerializer6 = new DateSerializer();
		String text6 = "11:22:33";
		Date date6 = dateParser.parse(text6);

	}

}
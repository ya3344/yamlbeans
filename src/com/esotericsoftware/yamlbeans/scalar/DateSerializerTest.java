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
		String value = "1993-07-01";
		Date date = dateParser.parse(value);
		DateSerializer dateSerializer1 = new DateSerializer();
		assertEquals(dateSerializer1.read(value), date);
		
		String incorrect = "12:34";
		DateSerializer dateSerializer2 = new DateSerializer();
		assertEquals(dateSerializer2.read(incorrect),dateParser.parse(incorrect));
	}

	@Test
	public void testWrite() throws ParseException, YamlException {
		DateSerializer dateSerializer = new DateSerializer();
		String text = "1993-07-01";
		Date date = dateParser.parse(text);
		assertEquals(dateSerializer.write(date), dateParser.format(date));

	}

}
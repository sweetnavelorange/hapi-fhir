package ca.uhn.fhir.model.primitive;


import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Before;
import org.junit.Test;

import ca.uhn.fhir.model.api.TemporalPrecisionEnum;

public class BaseDateTimeDtTest {
	private SimpleDateFormat myDateInstantParser;

	@Before
	public void before() {
		myDateInstantParser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	}

	/**
	 * See HAPI #101 - https://github.com/jamesagnew/hapi-fhir/issues/101
	 */
	@Test
	public void testPrecisionRespectedForSetValueWithPrecision() throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.setTime(myDateInstantParser.parse("2012-01-02 22:31:02.333"));
		cal.setTimeZone(TimeZone.getTimeZone("EST"));
		
		Date time = cal.getTime();
		
		DateDt date = new DateDt();
		date.setValue(time, TemporalPrecisionEnum.DAY);
		assertEquals("2012-01-02", date.getValueAsString());
	}
	
	/**
	 * See HAPI #101 - https://github.com/jamesagnew/hapi-fhir/issues/101
	 */
	@Test
	public void testPrecisionRespectedForSetValue() throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.setTime(myDateInstantParser.parse("2012-01-02 22:31:02.333"));
		cal.setTimeZone(TimeZone.getTimeZone("EST"));
		
		Date time = cal.getTime();
		
		DateDt date = new DateDt();
		date.setValue(time);
		assertEquals("2012-01-02", date.getValueAsString());
	}
	

}

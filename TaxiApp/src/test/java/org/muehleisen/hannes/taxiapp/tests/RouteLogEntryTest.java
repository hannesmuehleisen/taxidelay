package org.muehleisen.hannes.taxiapp.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.muehleisen.hannes.taxiapp.RouteLogEntry;

public class RouteLogEntryTest {

	@Test
	public void parseTest() {

		String line = "DFD2202EE08F7A8DC9A57B02ACB81FE2,51EE87E3205C985EF8431D850C786310,CMT,1,N,2013-01-07 23:25:03,2013-01-07 23:34:24,1,560,2.10,-73.97625,40.748528,-74.002586,40.747868";

		RouteLogEntry rle = new RouteLogEntry(line);
		assertEquals(rle.getPickupWeekday(), 2);
		assertEquals(rle.getPickupHourOfDay(), 23);
		assertEquals(rle.getTripTimeInSecs(), 560);
		assertEquals(rle.getTripDistanceMeters(), 3379.62, 10);
		assertEquals(rle.getPickupLatitude(), 40.748528, 0.1);
		assertEquals(rle.getPickupLongitude(), -73.97625, 0.1);
		assertEquals(rle.getDropoffLatitude(), 40.747868, 0.1);
		assertEquals(rle.getDropoffLongitude(), -74.002586, 0.1);

		assertEquals(RouteLogEntry.md5("5377994"),
				"095A4C5DF7C5B5F627317EF75F7C9EBA");
		assertEquals(RouteLogEntry.md5("5384691"),
				"00711D0CC3FB5BC905BB62D9B62296D6");
		assertEquals(RouteLogEntry.md5("99495"),
				"5B34A2589D1D2106FC0C47564A4833F0");
		
		RouteLogEntry.initLrt();
		assertEquals(rle.getLicense(), "499752");
	}
}

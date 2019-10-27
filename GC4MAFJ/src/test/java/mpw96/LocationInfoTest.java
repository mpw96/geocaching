package mpw96;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class LocationInfoTest {

	public static final byte[] us_flag_bytes =
	    {-16, -97, -121, -70, -16, -97, -121, -72};


	public static LocationInfo s_li = null;

    @BeforeClass
	public static void getLocationInfoObject() {
		try {
			s_li = new LocationInfo("134.201.250.155", "de");
			//s_li = new LocationInfo("2003:ec:cfff:f7:3a10:d5ff:fedd:cc5c", "de");
		}
		catch(Exception e) {
			// tests will fail
		}
	}
	
    @Test
	public void shouldGetCity() {
		assertTrue(s_li.getCity().length()>0);
	}

    @Test
	public void shouldGetCountry() {
		assertEquals("Vereinigte Staaten", s_li.getCountry());
	}

	@Test
	public void shouldGetRegion() {
		assertEquals("Kalifornien", s_li.getRegion());
	}

	@Test
	public void shouldGetFlag() {
		byte[] flag_bytes = s_li.getFlag().getBytes();
		assertArrayEquals(us_flag_bytes, flag_bytes);
	}
}

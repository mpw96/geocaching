package mpw96;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class SecureCoordinateResponderTest {

	@Test
	public void shouldLoadClearText() {
    	try {
			SecureCoordinateResponder scr = new SecureCoordinateResponder();
			String clearText = scr.loadClearText();
			assertTrue(0<clearText.length());
		} catch (Exception e) {
			fail();
    	}
    }

}

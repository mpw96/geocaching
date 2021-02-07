package mpw96;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.junit.Test;

public class PublicKeyCreatorTest {

    @Test
	public void shouldCreateKeyFromValidFile() {
    	try {
    		PGPPublicKey key = new PublicKeyCreator().createKeyFrom(this.getClass().getResourceAsStream("/pubkey.asc"));
    		assertTrue(4317252130728739008L==key.getKeyID());
    	} catch (Exception e) {
    		fail(e.getMessage());
    	}
    }

    @Test
	public void shouldCreateKeyFromValidFileWithComments() {
        try {
            PGPPublicKey key = new PublicKeyCreator().createKeyFrom(this.getClass().getResourceAsStream("/pubkey-with-comment.asc"));
            assertTrue(4317252130728739008L==key.getKeyID());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
	public void shouldCreateKeyFromUnkelbabysInput() {
        try {
			PGPPublicKey key = new PublicKeyCreator().createKeyFrom(this.getClass().getResourceAsStream("/pubkey-unkelbaby.asc"));
			System.out.println(key.getKeyID());
            assertTrue(-4731421810003270649L==key.getKeyID());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

	@Test(expected=NullPointerException.class)
	public void shouldThrowNullPointerException() throws NullPointerException {
    	try {
    		new PublicKeyCreator().createKeyFrom(this.getClass().getResourceAsStream("/noexist.asc"));
    	} catch (IOException e) {
    		fail(e.getMessage());
    	} catch (PGPException e) {
    		fail(e.getMessage());
    	}
    }

    @Test(expected=AssertionError.class)
	public void shouldThrowIllegalArgumentException() throws AssertionError {
		try {
			new PublicKeyCreator().createKeyFrom(this.getClass()
					.getResourceAsStream("/illegal.asc"));
		} catch (IOException e) {
			fail(e.getMessage());
    	} catch (PGPException e) {
    		fail(e.getMessage());
    	}
	}
}

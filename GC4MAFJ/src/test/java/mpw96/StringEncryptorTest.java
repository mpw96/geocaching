package mpw96;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringEncryptorTest {

	@BeforeClass
    public static void setBouncyCastle() {
		Security.addProvider(new BouncyCastleProvider());
	}	

	@AfterClass
    public static void deleteBouncyCastle() {
		Security.removeProvider(BouncyCastleProvider.PROVIDER_NAME);
	}	

	@Test
	public void shouldCreateEncryptedMessage() {
    	try {
    		PGPPublicKey key = new PublicKeyCreator().createKeyFrom(this.getClass().getResourceAsStream("/pubkey.asc"));
    		String ciphertext = new StringEncryptor().encryptString(key, "Hallo Welt");
    		assertTrue(ciphertext.startsWith("-----BEGIN PGP MESSAGE-----"));
    	} catch (Exception e) {
    		fail(e.getMessage());
    	}
    }

	@Test
	public void shouldCreateEncryptedMessageForUnkelbavy() {
    	try {
    		PGPPublicKey key = new PublicKeyCreator().createKeyFrom(this.getClass().getResourceAsStream("/pubkey-unkelbaby.asc"));
    		String ciphertext = new StringEncryptor().encryptString(key, "Hallo Welt");
    		assertTrue(ciphertext.startsWith("-----BEGIN PGP MESSAGE-----"));
    	} catch (Exception e) {
    		fail(e.getMessage());
    	}
    }

}

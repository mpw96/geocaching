package mpw96;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.openpgp.operator.jcajce.JcaKeyFingerprintCalculator;

public class PublicKeyCreator {

	public PGPPublicKey createKeyFrom(InputStream in) throws IOException, PGPException {
		
		InputStream pgpData = PGPUtil.getDecoderStream(in);
		
		PGPPublicKeyRingCollection pgpPub = new PGPPublicKeyRingCollection(
				PGPUtil.getDecoderStream(pgpData), new JcaKeyFingerprintCalculator());

		Iterator<PGPPublicKeyRing> keyRingIter = pgpPub.getKeyRings();
		while (keyRingIter.hasNext())
		{
			PGPPublicKeyRing keyRing = (PGPPublicKeyRing)keyRingIter.next();

			Iterator<PGPPublicKey> keyIter = keyRing.getPublicKeys();
			while (keyIter.hasNext())
			{
				PGPPublicKey key = keyIter.next();

				if (key.isEncryptionKey())
				{
					return key;
				}
			}
		}
		throw new IllegalArgumentException("Can't find encryption key in key ring.");
	}
}

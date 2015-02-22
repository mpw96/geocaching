package mpw96;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Date;

import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPCompressedDataGenerator;
import org.bouncycastle.openpgp.PGPEncryptedData;
import org.bouncycastle.openpgp.PGPEncryptedDataGenerator;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPLiteralData;
import org.bouncycastle.openpgp.PGPLiteralDataGenerator;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.operator.jcajce.JcePGPDataEncryptorBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcePublicKeyKeyEncryptionMethodGenerator;

public class StringEncryptor {

	public String encryptString(PGPPublicKey key, String clearText)
			throws IOException, PGPException {

		byte[] clearData = clearText.getBytes(StandardCharsets.UTF_8);

		ByteArrayOutputStream encOut = new ByteArrayOutputStream();
		OutputStream out = new ArmoredOutputStream(encOut);
		ByteArrayOutputStream bOut = new ByteArrayOutputStream();

		PGPCompressedDataGenerator comData = new PGPCompressedDataGenerator(
				PGPCompressedDataGenerator.ZIP);
		OutputStream cos = comData.open(bOut);
		PGPLiteralDataGenerator lData = new PGPLiteralDataGenerator();

		OutputStream pOut = lData.open(cos, PGPLiteralData.BINARY,
				PGPLiteralData.CONSOLE, clearData.length, new Date());
		pOut.write(clearData);

		lData.close();
		comData.close();

		PGPEncryptedDataGenerator encGen = new PGPEncryptedDataGenerator(
				new JcePGPDataEncryptorBuilder(PGPEncryptedData.CAST5)
						.setWithIntegrityPacket(true)
						.setSecureRandom(new SecureRandom()).setProvider(BouncyCastleProvider.PROVIDER_NAME));

		encGen.addMethod(new JcePublicKeyKeyEncryptionMethodGenerator(key)
				.setProvider(BouncyCastleProvider.PROVIDER_NAME));

		byte[] bytes = bOut.toByteArray();
		OutputStream cOut = encGen.open(out, bytes.length);
		cOut.write(bytes);
		cOut.close();
		out.close();

		return new String(encOut.toByteArray());
	}
}

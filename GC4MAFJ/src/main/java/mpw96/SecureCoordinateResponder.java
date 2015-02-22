package mpw96;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.Security;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPPublicKey;


public class SecureCoordinateResponder extends HttpServlet {
	
	private static final long serialVersionUID = 2L;

	@Override
	public void destroy() {
		if(null!=Security.getProvider(BouncyCastleProvider.PROVIDER_NAME)) {
			try {
				Security.removeProvider(BouncyCastleProvider.PROVIDER_NAME);
			}
			catch( Exception e) {
			}
		}
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			Security.addProvider(new BouncyCastleProvider());
		}
		catch(Exception e) {
			throw new ServletException("error adding security provider " + BouncyCastleProvider.PROVIDER_NAME, e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cipherText=getCipherText(request.getParameter("public_key"));
		
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>GC4MAFJ</title>");
		
		
		writer.println("<style type=\"text/css\">");
		writer.println("* {");
		writer.println("        font-family: monospace;");
		writer.println("}");
		writer.println("</style>");
		writer.println("</head>");
		writer.println("<body bgcolor=\""+(null==cipherText?"red":"green")+"\">");
		writer.println("<p>");
		writer.println("GC4MAFJ");
		writer.println("</p>");
		if(null==cipherText) {
			writer.println("<p style=\"font-size: 300%;\">");
			writer.println("No, this did not work.");
			writer.println("</p>");
		}
		else {
			writer.println("<p>");
			writer.println("Here's my encrypted message for you...");
			writer.println("</p>");
			writer.println("<p>");
			writer.println("<textarea cols=\"80\" rows=\"20\" readonly>");
			writer.println(cipherText);
			writer.println("</textarea>");
			writer.println("</p>");
		}
		writer.println("<img src=\""+request.getContextPath()+"/images/geocaching-logo.png\" alt=\"Geocaching\" height=\"43\" width=\"301\" />");
		writer.println("</body>");
		writer.close();			
	}
	
	private String getCipherText(String publicKeyString) {
		String ciphertext = null;
		if(null!=publicKeyString) {
			try {
				Security.addProvider(new BouncyCastleProvider());
				PublicKeyCreator pkc = new PublicKeyCreator();
				PGPPublicKey publicKey = pkc.createKeyFrom(new ByteArrayInputStream(publicKeyString.getBytes(StandardCharsets.UTF_8)));
				ciphertext = new StringEncryptor().encryptString(publicKey, "N 52 25.908 E 013 18.625");
			}
			catch( Exception e) {
			}
		}
		return ciphertext;
	}
}

package mpw96;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPPublicKey;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class SecureCoordinateResponder extends HttpServlet {

	private static final long serialVersionUID = 2L;
	private static final String clearText = "N 52 25.899 E 013 18.576";

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
		
		String errorMessage = null;
		Exception errorException = null;
		String cipherText = null;
		try {
			String public_key = request.getParameter("public_key");
			cipherText=getCipherText(public_key);
		}
		catch( Exception e ) {
			errorMessage = e.getMessage();
			errorException = e;
		}
		
		response.setContentType("text/html");
		ServletOutputStream writer = response.getOutputStream();

		writer.println("<!DOCTYPE html>");
        writer.println("<html>");
		writer.println("<head>");
		writer.println("<meta charset=\"UTF-8\">");
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
			writer.println("<p><font size=\"7\">");
			writer.println("No, this did not work.");
			writer.println("</font></p>");
			if( null != errorMessage ) {
			    writer.println("<p><font size=\"7\">");
			    writer.println(errorMessage);
				writer.println("</font></p>");
			}
			if( null != errorException ) {
				writer.println("<!--");
				errorException.printStackTrace(new PrintStream(writer));
				writer.println("-->");

			}
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
        if( null != cipherText ) {
			String clientIP = request.getHeader("X-FORWARDED-FOR");
			if( null == clientIP ) {
			  clientIP = request.getRemoteAddr();
			}
			else {
				clientIP = clientIP.contains(",") ? clientIP.split(",")[0] : clientIP;
			}
			try {
				LocationInfo loci = new LocationInfo(clientIP);
				String flag = loci.getFlag();
				String region = loci.getRegion();
				String city = loci.getCity();
				String isp = loci.getISP();
				writer.println("<br><br><br><br><br>");
				writer.println("<table border=1>");
				writer.println("<tr>");
				writer.println("<th colspan=\"2\">This is not relevant for the cache, but just so you know what I know about you...</th>");
				writer.println("</tr>");
				writer.println("<tr>");
				writer.println(String.format("<td colspan=\"2\" align=\"center\"><a href=\"%s\">%s</a></td>", loci.getLocationProviderURL(), loci.getLocationProviderString()));
				writer.println("</tr>");
				if( null != flag ) {
					writer.println("<tr>");
					writer.print("<td>Your country:</td><td><font size=\"7\">");
					writer.write(flag.getBytes());
					writer.println("</font></td>");
					writer.println("</tr>");
				}
				if( null != region ) {
					writer.println("<tr>");
					writer.println(String.format("<td>Your region:</td><td>%s</td>", region));
					writer.println("</tr>");
				}
				if( null != city ) {
					writer.println("<tr>");
					writer.println(String.format("<td>Your city:</td><td>%s</td>", city));
					writer.println("</tr>");
				}
				if( null != isp ) {
					writer.println("<tr>");
					writer.println(String.format("<td>Your Internet Service Provider:</td><td>%s</td>", isp));
					writer.println("</tr>");
				}
				writer.println("<tr>");
				writer.println(String.format("<td>Your IP address:</td><td>%s</td>", clientIP));
				writer.println("</tr>");
				writer.println("</table>");
			}
			catch( Exception e) {
				//writer.println("<!--");
				e.printStackTrace(new PrintStream(writer));
				//writer.println("-->");
			}
		}
		writer.println("<p>\"Bonus\": <b>dig</b> for a tracking number stored as DNS record of type TXT at no-intercept.de!</p>");
		writer.println("</body>");
		writer.flush();
	}

	private String getCipherText(String publicKeyString) {
		String ciphertext = null;
		if(null!=publicKeyString) {
			try {
				Security.addProvider(new BouncyCastleProvider());
				PublicKeyCreator pkc = new PublicKeyCreator();
				PGPPublicKey publicKey = pkc.createKeyFrom(new ByteArrayInputStream(publicKeyString.getBytes(StandardCharsets.UTF_8)));
				ciphertext = new StringEncryptor().encryptString(publicKey, clearText);
			}
			catch( Exception e) {
			}
		}
		return ciphertext;
	}
}

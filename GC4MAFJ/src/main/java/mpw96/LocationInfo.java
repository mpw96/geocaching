package mpw96;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class LocationInfo {
	
	private URL m_url = null;
	private String m_country = null;
	private String m_isp = null;
    private String m_region = null;
	private String m_city = null;
	private String m_flag = null;

	public LocationInfo(String ip_address) throws Exception {
		m_url = new URL(String.format("%s/%s", getLocationProviderURL(), ip_address));

		obtainData();
	}

    public String getLocationProviderString() {
		return "IP Geolocation API";
	}
	
	public String getLocationProviderURL() {
		return "http://ip-api.com/json";
	}

    public String getCity() {
	    return m_city;
	}

	public String getRegion() {
		return m_region;
	}

	public String getCountry() {
	    return m_country;
    }

	public String getISP() {
	    return m_isp;
    }

	public String getFlag() {
		return m_flag;
	}

	private void obtainData() throws Exception {
		HttpURLConnection con = (HttpURLConnection) m_url.openConnection();
		con.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine = in.readLine();
		in.close();
		JSONParser parser = new JSONParser();
		JSONObject geo = (JSONObject) parser.parse(inputLine);

		m_country = (String) geo.get("country");
		m_city = (String) geo.get("city");
		m_region = (String) geo.get("regionName");
		m_isp = (String) geo.get("isp");

		String country = (String) geo.get("countryCode");
    	int flagOffset = 0x1F1E6;
        int asciiOffset = 0x41;
        int firstChar = Character.codePointAt(country, 0) - asciiOffset + flagOffset;
        int secondChar = Character.codePointAt(country, 1) - asciiOffset + flagOffset;
        m_flag = new String(Character.toChars(firstChar)) + new String(Character.toChars(secondChar));
	}
}

package mpw96;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class LocationInfo {
	
	private static final long serialVersionUID = 2L;
	private URL m_url = null;
	private String m_language = null;
	private String m_country = null;
    private String m_region = null;
	private String m_city = null;
	private String m_flag = null;

	public LocationInfo(String ip_address, String language) throws Exception {
		m_language = language;
		m_url = new URL(String.format("http://api.ipstack.com/%s?access_key=4ca98354a62b9867622d80eeedececfc&language=%s", ip_address, m_language));

		obtainData();
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

	public String getFlag() {
		return m_flag;
	}

	private void obtainData() throws Exception {
		HttpURLConnection con = (HttpURLConnection) m_url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json");

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine = in.readLine();
		in.close();
		JSONParser parser = new JSONParser();
		JSONObject basic = (JSONObject) parser.parse(inputLine);

		m_country = (String) basic.get("country_name");
		m_city = (String) basic.get("city");
		m_region = (String) basic.get("region_name");

		JSONObject location = (JSONObject) basic.get("location");
		m_flag = (String) location.get("country_flag_emoji");
	}
}

package dad.javafx.GeoFx.client;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import dad.javafx.client.messages.IPAPIMessage;
import dad.javafx.client.messages.PropiaIPMessage;

public class GeoFXService {

	public GeoFXService() {
		Unirest.setObjectMapper(new UnirestObjectMapper());
	}

	IPAPIMessage message = null;

	public IPAPIMessage getMessage() {
		return message;
	}

	public void setMessage(String ip) {
		try {
			message = Unirest.get("http://api.ipapi.com/" + ip + "?access_key=f5da6a49ff9e5256e7ff69817750b4d3")
					.asObject(IPAPIMessage.class).getBody();
		} catch (UnirestException e) {
			e.printStackTrace();
		}

	}

	public String getPropiaIP() {

		PropiaIPMessage message;
		try {
			message = Unirest.get("https://geo.ipify.org/api/v1?apiKey=at_uxYZybE2c9IAhoKOTD2T7Gx8FTk1Q&")
					.asObject(PropiaIPMessage.class).getBody();

			return message.getIp();

		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;

	}

	public Double getLatitude() {

		return message.getLatitude();

	}

	public Double getLongitude() {

		return message.getLongitude();

	}

	public String getIPLocation() {

		return message.getCountryName() + "(" + message.getCountryCode() + ")";

	}

	public String getCountryCode() {

		return message.getCountryCode();

	}

	public String getCity() {

		return message.getCity();

	}

	public String getZipCode() {

		return message.getZip();
	}

	public String getLanguage() {

		return message.getLocation().getLanguages().get(0).getName() + "("
				+ message.getLocation().getLanguages().get(0).getCode().toUpperCase() + ")";

	}

	public String getTimeZone() {

		return message.getTimeZone().getCode();

	}

	public String getCallingCode() {

		return "+" + message.getLocation().getCallingCode();

	}

	public String getCurrency() {

		return message.getCurrency().getName() + "(" + message.getCurrency().getSymbol() + ")";

	}

	public String getIpAdress() {

		return message.getIp();
	}

	public String getISP() {

		return message.getConnection().getIsp();
	}

	public String getType() {

		return message.getType();
	}

	public Number getASN() {

		return message.getConnection().getAsn();
	}

	public String getHostname() {

		return message.getHostname();
	}

	public String getThreatlevel() {

		return message.getSecurity().getThreatLevel();

	}

	public Boolean getProxy() {

		return message.getSecurity().getIsProxy();

	}

	public Boolean getTor() {

		return message.getSecurity().getIsTor();

	}

	public Boolean getCrawler() {

		return message.getSecurity().getIsCrawler();

	}
	public Object getThreatTypes() {
		return message.getSecurity().getThreatTypes();
	}
	

}

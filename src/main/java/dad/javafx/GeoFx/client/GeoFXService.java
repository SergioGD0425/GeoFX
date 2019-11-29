package dad.javafx.GeoFx.client;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import dad.javafx.client.messages.IPAPIMessage;
import dad.javafx.client.messages.PropiaIPMessage;

public class GeoFXService {

	public GeoFXService() {
		Unirest.setObjectMapper(new UnirestObjectMapper());
	}

	public IPAPIMessage getMessage(String ip) {
		try {
			//http://api.ipapi.com/" + ip + "?access_key=f5da6a49ff9e5256e7ff69817750b4d3
			return Unirest.get("http://api.ipapi.com/ "+ ip +" ?access_key=f5da6a49ff9e5256e7ff69817750b4d3")
					.asObject(IPAPIMessage.class).getBody();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;
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

}

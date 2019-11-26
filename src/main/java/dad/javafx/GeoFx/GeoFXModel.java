package dad.javafx.GeoFx;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class GeoFXModel {
	
	private StringProperty ip = new SimpleStringProperty();
	
	//first tab model
	
	private StringProperty latitude = new SimpleStringProperty();
	private StringProperty longitude = new SimpleStringProperty();
	private StringProperty location = new SimpleStringProperty();
	private ObjectProperty<Image> flag = new SimpleObjectProperty<Image>();
	private StringProperty city = new SimpleStringProperty();
	private StringProperty zipcode = new SimpleStringProperty();
	private StringProperty language = new SimpleStringProperty();
	private StringProperty timezone = new SimpleStringProperty();
	private StringProperty callingcode = new SimpleStringProperty();
	private StringProperty currency = new SimpleStringProperty();
	
	//Second tab model
	
	private StringProperty ipadress = new SimpleStringProperty();
	private StringProperty ISP = new SimpleStringProperty();
	private StringProperty type = new SimpleStringProperty();
	private StringProperty ASN = new SimpleStringProperty();
	private StringProperty hostname = new SimpleStringProperty();
	
	//third tab
	
	private StringProperty safe = new SimpleStringProperty();
	private BooleanProperty tor = new SimpleBooleanProperty();
	private BooleanProperty proxy = new SimpleBooleanProperty();
	private BooleanProperty crawler = new SimpleBooleanProperty();
	private StringProperty threatlevel = new SimpleStringProperty();
	private StringProperty threattypes = new SimpleStringProperty();
	
	

	public final StringProperty ipProperty() {
		return this.ip;
	}
	

	public final String getIp() {
		return this.ipProperty().get();
	}
	

	public final void setIp(final String ip) {
		this.ipProperty().set(ip);
	}


	public final StringProperty latitudeProperty() {
		return this.latitude;
	}
	


	public final String getLatitude() {
		return this.latitudeProperty().get();
	}
	


	public final void setLatitude(final String latitude) {
		this.latitudeProperty().set(latitude);
	}
	


	public final StringProperty longitudeProperty() {
		return this.longitude;
	}
	


	public final String getLongitude() {
		return this.longitudeProperty().get();
	}
	


	public final void setLongitude(final String longitude) {
		this.longitudeProperty().set(longitude);
	}
	


	public final StringProperty locationProperty() {
		return this.location;
	}
	


	public final String getLocation() {
		return this.locationProperty().get();
	}
	


	public final void setLocation(final String location) {
		this.locationProperty().set(location);
	}
	


	public final StringProperty cityProperty() {
		return this.city;
	}
	


	public final String getCity() {
		return this.cityProperty().get();
	}
	


	public final void setCity(final String city) {
		this.cityProperty().set(city);
	}
	


	public final StringProperty zipcodeProperty() {
		return this.zipcode;
	}
	


	public final String getZipcode() {
		return this.zipcodeProperty().get();
	}
	


	public final void setZipcode(final String zipcode) {
		this.zipcodeProperty().set(zipcode);
	}
	


	public final StringProperty languageProperty() {
		return this.language;
	}
	


	public final String getLanguage() {
		return this.languageProperty().get();
	}
	


	public final void setLanguage(final String language) {
		this.languageProperty().set(language);
	}
	


	public final StringProperty timezoneProperty() {
		return this.timezone;
	}
	


	public final String getTimezone() {
		return this.timezoneProperty().get();
	}
	


	public final void setTimezone(final String timezone) {
		this.timezoneProperty().set(timezone);
	}
	


	public final StringProperty callingcodeProperty() {
		return this.callingcode;
	}
	


	public final String getCallingcode() {
		return this.callingcodeProperty().get();
	}
	


	public final void setCallingcode(final String callingcode) {
		this.callingcodeProperty().set(callingcode);
	}
	


	public final StringProperty currencyProperty() {
		return this.currency;
	}
	


	public final String getCurrency() {
		return this.currencyProperty().get();
	}
	


	public final void setCurrency(final String currency) {
		this.currencyProperty().set(currency);
	}


	public final ObjectProperty<Image> flagProperty() {
		return this.flag;
	}
	


	public final Image getFlag() {
		return this.flagProperty().get();
	}
	


	public final void setFlag(final Image flag) {
		this.flagProperty().set(flag);
	}


	public final StringProperty ipadressProperty() {
		return this.ipadress;
	}
	


	public final String getIpadress() {
		return this.ipadressProperty().get();
	}
	


	public final void setIpadress(final String ipadress) {
		this.ipadressProperty().set(ipadress);
	}
	


	public final StringProperty ISPProperty() {
		return this.ISP;
	}
	


	public final String getISP() {
		return this.ISPProperty().get();
	}
	


	public final void setISP(final String ISP) {
		this.ISPProperty().set(ISP);
	}
	


	public final StringProperty typeProperty() {
		return this.type;
	}
	


	public final String getType() {
		return this.typeProperty().get();
	}
	


	public final void setType(final String type) {
		this.typeProperty().set(type);
	}
	


	public final StringProperty ASNProperty() {
		return this.ASN;
	}
	


	public final String getASN() {
		return this.ASNProperty().get();
	}
	


	public final void setASN(final String ASN) {
		this.ASNProperty().set(ASN);
	}
	


	public final StringProperty hostnameProperty() {
		return this.hostname;
	}
	


	public final String getHostname() {
		return this.hostnameProperty().get();
	}
	


	public final void setHostname(final String hostname) {
		this.hostnameProperty().set(hostname);
	}


	public final BooleanProperty torProperty() {
		return this.tor;
	}
	


	public final boolean isTor() {
		return this.torProperty().get();
	}
	


	public final void setTor(final boolean tor) {
		this.torProperty().set(tor);
	}
	


	public final BooleanProperty crawlerProperty() {
		return this.crawler;
	}
	


	public final boolean isCrawler() {
		return this.crawlerProperty().get();
	}
	


	public final void setCrawler(final boolean crawler) {
		this.crawlerProperty().set(crawler);
	}
	


	public final StringProperty threatlevelProperty() {
		return this.threatlevel;
	}
	


	public final String getThreatlevel() {
		return this.threatlevelProperty().get();
	}
	


	public final void setThreatlevel(final String threatlevel) {
		this.threatlevelProperty().set(threatlevel);
	}
	


	public final StringProperty threattypesProperty() {
		return this.threattypes;
	}
	


	public final String getThreattypes() {
		return this.threattypesProperty().get();
	}
	


	public final void setThreattypes(final String threattypes) {
		this.threattypesProperty().set(threattypes);
	}


	public final StringProperty safeProperty() {
		return this.safe;
	}
	


	public final String getSafe() {
		return this.safeProperty().get();
	}
	


	public final void setSafe(final String safe) {
		this.safeProperty().set(safe);
	}
	


	public final BooleanProperty proxyProperty() {
		return this.proxy;
	}
	


	public final boolean isProxy() {
		return this.proxyProperty().get();
	}
	


	public final void setProxy(final boolean proxy) {
		this.proxyProperty().set(proxy);
	}
	
	
	
	
	
	

}

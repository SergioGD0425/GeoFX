package dad.javafx.GeoFx;

import java.io.IOException;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.javafx.binding.SelectBinding.AsBoolean;

import dad.javafx.GeoFx.client.GeoFXService;
import dad.javafx.client.messages.IPAPIMessage;
import dad.javafx.client.messages.Security;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

public class GeoFXController implements Initializable {

	@FXML
	private BorderPane root;

	@FXML
	private TabPane tabpane;

	@FXML
	private Tab firsttab;

	@FXML
	private VBox latitudeBox;

	@FXML
	private Label latitudeLabel;

	@FXML
	private VBox longitudeBox;

	@FXML
	private Label longitudeLabel;

	@FXML
	private HBox locationBox;

	@FXML
	private Label locationLabel;

	@FXML
	private ImageView locationImage;

	@FXML
	private VBox cityBox;

	@FXML
	private Label cityLabel;

	@FXML
	private VBox zipBox;

	@FXML
	private Label zipLabel;

	@FXML
	private VBox languageBox;

	@FXML
	private Label languageLabel;

	@FXML
	private VBox timeBox;

	@FXML
	private Label timeLabel;

	@FXML
	private VBox callingBox;

	@FXML
	private Label callingLabel;

	@FXML
	private VBox currencyBox;

	@FXML
	private Label currencyLabel;

	@FXML
	private Tab secondtab;

	@FXML
	private VBox ipaddressBox;

	@FXML
	private Label ipaddressLabel;

	@FXML
	private HBox ispBox;

	@FXML
	private Label ispLabel;

	@FXML
	private VBox typeBox;

	@FXML
	private Label typeLabel;

	@FXML
	private VBox asnBox;

	@FXML
	private Label asnLabel;

	@FXML
	private VBox hostnameBox;

	@FXML
	private Label hostnameLabel;

	@FXML
	private Tab thirdtab;

	@FXML
	private Label safeLabel;

	@FXML
	private CheckBox proxyCheckbox;

	@FXML
	private CheckBox torCheckbox;

	@FXML
	private CheckBox crawlerCheckbox;

	@FXML
	private Label threatLabel;

	@FXML
	private Label threattypeLabel;

	@FXML
	private HBox ipBox;

	@FXML
	private TextField ipTextField;

	@FXML
	private Button ipButton;

	// model

	private GeoFXService service = new GeoFXService();
	private GeoFXModel model = new GeoFXModel();
	Task<Void> tarea;
	IPAPIMessage message;

	public GeoFXController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GeoFXView.fxml"));
		loader.setController(this);
		loader.load();
	}

	public BorderPane getView() {
		return root;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// binds

		ipTextField.textProperty().bindBidirectional(model.ipProperty());

		// BINDS DEL PRIMER TAB

		latitudeLabel.textProperty().bind(model.latitudeProperty());
		longitudeLabel.textProperty().bind(model.longitudeProperty());
		locationLabel.textProperty().bind(model.locationProperty());
		locationImage.imageProperty().bind(model.flagProperty());
		cityLabel.textProperty().bind(model.cityProperty());
		zipLabel.textProperty().bind(model.zipcodeProperty());
		languageLabel.textProperty().bind(model.languageProperty());
		timeLabel.textProperty().bind(model.timezoneProperty());
		callingLabel.textProperty().bind(model.callingcodeProperty());
		currencyLabel.textProperty().bind(model.currencyProperty());

		// BINDS DEL SEGUNDO TAB

		ipaddressLabel.textProperty().bind(model.ipadressProperty());
		ispLabel.textProperty().bind(model.ISPProperty());
		typeLabel.textProperty().bind(model.typeProperty());
		asnLabel.textProperty().bind(model.ASNProperty());
		hostnameLabel.textProperty().bind(model.hostnameProperty());

		// BINDS DEL TERCER TAB

		safeLabel.textProperty().bind(model.safeProperty());
		proxyCheckbox.selectedProperty().bind(model.proxyProperty());
		torCheckbox.selectedProperty().bind(model.torProperty());
		crawlerCheckbox.selectedProperty().bind(model.crawlerProperty());
		threatLabel.textProperty().bind(model.threatlevelProperty());
		threattypeLabel.textProperty().bind(model.threattypesProperty());

		root.sceneProperty().addListener((o, ov, nv) -> {
			model.setIp(service.getPropiaIP());
		});
	}

	@FXML
	void onCheckIPAction(ActionEvent event) {
	
		tarea = new Task<Void>() {

			@Override
			protected Void call() throws Exception {
				message = service.getMessage(model.getIp());
				return null;	
				}		
			};
			tarea.setOnSucceeded(e->{
				
				// First Tab
				model.setLatitude(message.getLatitude() + "");
				model.setLongitude(message.getLongitude() + "");
				model.setLocation(message.getCountryName() + "(" + message.getCountryCode() + ")");
				model.setFlag(new Image(getClass().getResourceAsStream("/Flags/" + message.getCountryCode() + ".png")));
				model.setCity(message.getCity());
				model.setZipcode(message.getZip());
				model.setLanguage(message.getLocation().getLanguages().get(0).getName() + "(" + message.getLocation().getLanguages().get(0).getCode().toUpperCase()+")");
				model.setTimezone(message.getTimeZone() != null ? message.getTimeZone().getCode() : "You need a major subscription");
				model.setCallingcode("+"+message.getLocation().getCallingCode());
				model.setCurrency(message.getCurrency() != null ? message.getCurrency().getName() + "(" + message.getCurrency().getSymbol() + ")" : "You need a major subscription");

				// Second tab

				model.setIpadress(message.getIp());
				
				model.setISP(message.getConnection() != null ? message.getConnection().getIsp() : "You need a major subscription");

				model.setType(message.getType());
				
				model.setASN(message.getConnection() != null ? message.getConnection().getAsn().toString() : "You need a major subscription");

				model.setHostname(message.getHostname());

				// third tab

				if (message.getSecurity() == null) {
					model.setSafe("You need a major subscription");
				} else {
					if (message.getSecurity().getThreatLevel().equals("low")) {
						model.setSafe("This IP is safe. No threats have been detected.");
					} else {
						model.setSafe("This IP is not safe. Threats have been detected.");
					}
				}
				
				model.setThreatlevel(message.getSecurity() != null ? message.getSecurity().getThreatLevel()  : "You need a major subscription");
				
				
				model.setProxy(message.getSecurity() != null ? message.getSecurity().getIsProxy() : false);
				
				model.setTor(message.getSecurity() != null ? message.getSecurity().getIsTor() : false);
				
				model.setCrawler(message.getSecurity() != null ? message.getSecurity().getIsCrawler() : false);
					
				if (message.getSecurity() == null) {
					model.setThreattypes("You need a major subscription");
				} else {
					if (message.getSecurity().getThreatTypes()!=null) {
						model.setThreattypes("No threats have been detected for this IP address");
					} else {
						model.setThreattypes("Threats have been detected for this IP address");
					}
				}
				
			});
			
			tarea.setOnFailed(e->{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("GeoFX");
				alert.setHeaderText("No se pudo hacer la conexión");
				alert.setContentText(e.getSource().getException().getMessage());
				alert.showAndWait();
			});
			new Thread(tarea).start();


	}

}

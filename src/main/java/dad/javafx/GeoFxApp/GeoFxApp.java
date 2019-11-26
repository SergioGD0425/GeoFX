package dad.javafx.GeoFxApp;

import dad.javafx.GeoFx.GeoFXController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GeoFxApp extends Application {

	GeoFXController root;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		root = new GeoFXController();
		
		Scene scene = new Scene(root.getView());
		primaryStage.setTitle("GeoFx");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}

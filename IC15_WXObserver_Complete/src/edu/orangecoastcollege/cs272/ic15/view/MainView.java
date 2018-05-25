package edu.orangecoastcollege.cs272.ic15.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.ic15.controller.WeatherController;
import edu.orangecoastcollege.cs272.ic15.model.WeatherObservation;
import edu.orangecoastcollege.cs272.ic15.model.WeatherStation;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class MainView extends Application implements Initializable {

	private WeatherController controller = new WeatherController();

	@FXML
	private ComboBox<WeatherStation> weatherStationsCB;
	@FXML
	private TextArea weatherReportTA;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		weatherStationsCB.setItems(controller.getCAWeatherStations());
		weatherReportTA.setText("Please select station above for current weather observation.");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Current California Weather Observations");

		Scene scene = new Scene(FXMLLoader.load(getClass().getResource("WeatherObserverScene.fxml")));
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	@FXML
	public void getCurrentWeather() {
		WeatherStation selectedStation = weatherStationsCB.getSelectionModel().getSelectedItem();
		if (selectedStation != null) {
			WeatherObservation currentObservation = controller.getCurrentWeather(selectedStation.getXMLURL());
			weatherReportTA.setText(currentObservation.toString());

		}
	}

	public static void main(String[] args) {
		launch(args);

	}

}

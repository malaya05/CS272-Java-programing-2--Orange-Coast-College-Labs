package edu.orangecoastcollege.cs272.finalexam.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.finalexam.controller.Controller;
import edu.orangecoastcollege.cs272.finalexam.model.Earthquake;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;

public class ListEarthquakesScene implements Initializable {

	private static Controller controller = Controller.getInstance();

	@FXML
	private ComboBox<String> areasCB;

	@FXML
	private Slider magnitudeSlider;

	@FXML
	private ListView<Earthquake> earthquakesLV;

	@FXML
	private Label countLabel;

	@FXML
	private Button removeEarthquakeButton;

	@FXML
	private Button addNewEarthquakeButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//	TODO: Set the items of the earthquakes list view, using the controller
		//	Set the items of the areas combo box using the controller
		//	Disable the remove earthquake button
		//	Set the text of the count label to the number of earthquakes displayed
	}

	@FXML
	public Object addNewEarthquake() {
		ViewNavigator.loadScene("Add New Earthquake", ViewNavigator.ADD_EARTHQUAKE_SCENE);
		return this;
	}

	@FXML
	public Object removeEarthquake() {

		//	TODO: Get the selected earthquake from the earthquakesListView
		//	Use the controller to call the removeEarthquake(Earthquake eq) method you created earlier.  
		//	Select -1 on the list view to clear any selections
		//	Disable the delete button (since nothing is selected)
		//	Update the test of the countLabel with the new number of earthquakes

		return this;
	}
	
	@FXML
	public Object filter()
	{
		//	TODO: Use the value of the areasComboBox and the magnitudeSlider to filter the list of what is
		//	displayed in the list view
		// 	Also, update the countLabel to reflect the count of the filtered list.
		return this;
	}

}

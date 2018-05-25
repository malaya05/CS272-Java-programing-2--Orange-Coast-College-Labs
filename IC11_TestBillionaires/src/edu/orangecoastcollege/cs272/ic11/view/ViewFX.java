package edu.orangecoastcollege.cs272.ic11.view;

import edu.orangecoastcollege.cs272.ic11.controller.Controller;
import edu.orangecoastcollege.cs272.ic11.model.Billionaire;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Slider;

import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ViewFX extends Application
{
	int selectedId = -1;

	ComboBox<String> citizenshipsCB;
	ComboBox<String> sectorsCB;
	Slider minWorthSlider = new Slider(0.0, 80.0, 0.0);
	Slider maxWorthSlider = new Slider(0.0, 80.0, 80.0);
	ListView<Billionaire> billionairesLV = new ListView<>();
	Button deleteButton = new Button("Delete");

	ObservableList<Billionaire> billionairesList;
	Controller controller = Controller.getInstance();

	@Override
	public void start(Stage primaryStage) throws Exception {

		billionairesList = controller.getAllBillionares();
		// Associate the employeesLV with the observable list
		billionairesLV.setItems(billionairesList);
		billionairesLV.setPrefWidth(800);

		// new code for the delte button
		billionairesLV.setOnMouseClicked(e -> selectBillionaire());
		deleteButton.setDisable(true);
		deleteButton.setOnAction(e -> deleteBillionaire());

		citizenshipsCB = new ComboBox<>(controller.getDistinctCitizenships());
		citizenshipsCB.setOnAction(e -> filter());

		sectorsCB = new ComboBox<>(controller.getDistinctSectors());
		sectorsCB.setOnAction(e -> filter());

		minWorthSlider.setShowTickMarks(true);
		minWorthSlider.setShowTickLabels(true);
		minWorthSlider.setMajorTickUnit(5.0f);
		minWorthSlider.setBlockIncrement(1.0f);
		minWorthSlider.setOnMouseDragged(e -> filter());
		minWorthSlider.setOnMouseClicked(e -> filter());

		maxWorthSlider.setShowTickMarks(true);
		maxWorthSlider.setShowTickLabels(true);
		maxWorthSlider.setMajorTickUnit(5.0f);
		maxWorthSlider.setBlockIncrement(1.0f);
		maxWorthSlider.setOnMouseDragged(e -> filter());
		maxWorthSlider.setOnMouseClicked(e -> filter());

		GridPane pane = new GridPane();
		pane.setVgap(10);
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.add(new Label("Filters:"), 0, 0);
		pane.add(new Label("Citizenship:"), 0, 1);
		pane.add(citizenshipsCB, 1, 1);

		pane.add(new Label("Sector:"), 0, 2);
		pane.add(sectorsCB, 1, 2);

		pane.add(new Label("Min Worth ($B):"), 0, 3);
		pane.add(minWorthSlider, 1, 3);

		pane.add(new Label("Max Worth ($B):"), 0, 4);
		pane.add(maxWorthSlider, 1, 4);

		pane.add(billionairesLV, 0, 5, 2, 1);
		pane.add(deleteButton, 0, 6);

		Scene scene = new Scene(pane, 800, 400);
		primaryStage.setTitle("The World's Billionaires");
		primaryStage.setScene(scene);
		primaryStage.show();
	}



    private void filter() {
		String citizenship = citizenshipsCB.getSelectionModel().getSelectedItem();
		String sector = sectorsCB.getSelectionModel().getSelectedItem();
		double minWorth = minWorthSlider.getValue();
		double maxWorth = maxWorthSlider.getValue();

		billionairesList = controller.filter(b -> (citizenship == null || b.getCitizenship().equalsIgnoreCase(citizenship))
				&& (sector == null || b.getSector().equalsIgnoreCase(sector)) && b.getWorth() >= minWorth && b.getWorth() <= maxWorth);
		billionairesLV.setItems(billionairesList);
	}

    private void deleteBillionaire()
    {
        // This will allow multiple slections
        billionairesLV.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // return the index of the selected item
        int billionarIndex = billionairesLV.getSelectionModel().getSelectedIndex();

        // return the selected object
       Billionaire b = billionairesLV.getSelectionModel().getSelectedItem();

       billionairesLV.getItems().remove(b);

       deleteButton.setDisable(true);

       // this line will not allow removing more than one!
       // filter();
    }

    // TODO  ???
	private void selectBillionaire()
	{

	    if(deleteButton.isDisable())
	        deleteButton.setDisable(false);
	}

	// TODO is this correct?
	public void stop() throws Exception
	{
	    controller.close();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}

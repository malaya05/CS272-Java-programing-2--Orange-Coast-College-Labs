package edu.orangecoastcollege.cs272.ic12.view;

import edu.orangecoastcollege.cs272.ic12.controller.Controller;
import edu.orangecoastcollege.cs272.ic12.model.Car;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * This <code>ViewFX</code> creates a Java FX file where all of the Car database
 * information can be viewed and filtered based on make, fuel type and minimum
 * miles per gallon (MPG) for both city and highway driving.
 *
 * @author
 * @version 1.0
 */
public class ViewFX extends Application
{

    // Nodes needed for the main scene
    Scene mainScene;
    ComboBox<String> makesCB;
    ComboBox<String> fuelTypesCB;
    Slider cityMPGSlider = new Slider(0.0, 60.0, 0.0);
    Slider hwyMPGSlider = new Slider(0.0, 60.0, 0.0);
    ListView<Car> carsLV = new ListView<>();
    Button addCarButton = new Button("Add New Car...");
    Button deleteButton = new Button("Delete");
    Button resetButton = new Button("Reset");
    Label recordCountLabel = new Label("0 records displayed");

    // Shared member variables between both scenes
    Stage mainStage;
    Car selectedCar;
    ObservableList<Car> carsList;
    ObservableList<String> makesList;
    ObservableList<String> fuelTypesList;
    Controller controller = Controller.getInstance();

    // Nodes needed for the add car scenes
    Label errorLabel = new Label("*All fields must be complete");
    ComboBox<String> newMakesCB;
    ComboBox<String> newFuelTypesCB;
    TextField descriptionTF = new TextField();
    TextField horsepowerTF = new TextField();
    TextField cityMPGTF = new TextField();
    TextField hwyMPGTF = new TextField();
    CheckBox hybridCheckBox = new CheckBox();
    Button saveButton = new Button("Save");
    Button cancelButton = new Button("Cancel");

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        mainStage = primaryStage;
        carsList = controller.getAllCars();
        makesList = controller.getDistinctMakes();
        fuelTypesList = controller.getDistinctFuelTypes();

        mainScene = createMainScene();
        mainStage.setTitle("Car Fuel Efficiency");
        mainStage.setScene(mainScene);
        mainStage.show();
    }

    private Scene createMainScene()
    {
        carsLV.setItems(carsList);
        carsLV.setPrefWidth(1000);
        carsLV.setOnMouseClicked(e -> selectCar());

        makesCB = new ComboBox<>(makesList);
        makesCB.setOnAction(e -> filter());

        fuelTypesCB = new ComboBox<>(fuelTypesList);
        fuelTypesCB.setOnAction(e -> filter());

        cityMPGSlider.setShowTickMarks(true);
        cityMPGSlider.setShowTickLabels(true);
        cityMPGSlider.setMajorTickUnit(5.0f);
        cityMPGSlider.setBlockIncrement(1.0f);
        cityMPGSlider.setOnMouseDragged(e -> filter());
        cityMPGSlider.setOnMouseClicked(e -> filter());

        hwyMPGSlider.setShowTickMarks(true);
        hwyMPGSlider.setShowTickLabels(true);
        hwyMPGSlider.setMajorTickUnit(5.0f);
        hwyMPGSlider.setBlockIncrement(1.0f);
        hwyMPGSlider.setOnMouseDragged(e -> filter());
        hwyMPGSlider.setOnMouseClicked(e -> filter());

        addCarButton.setOnAction(e -> createAddCarScene());

        GridPane pane = new GridPane();
        pane.setVgap(10);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.add(new Label("Filters:"), 0, 0);
        pane.add(new Label("Make:"), 0, 1);
        pane.add(makesCB, 1, 1);

        pane.add(new Label("Fuel Type:"), 0, 2);
        pane.add(fuelTypesCB, 1, 2);

        pane.add(new Label("City MPG:"), 0, 3);
        pane.add(cityMPGSlider, 1, 3);

        pane.add(new Label("Highway MPG:"), 0, 4);
        pane.add(hwyMPGSlider, 1, 4);

        pane.add(addCarButton, 0, 5);

        pane.add(carsLV, 0, 6, 2, 1);

        recordCountLabel.setText(carsList.size() + " record(s) displayed");
        pane.add(recordCountLabel, 0, 7);

        pane.add(deleteButton, 0, 8);
        deleteButton.setDisable(true);
        deleteButton.setOnMouseClicked(e -> deleteCar());

        pane.add(resetButton, 1, 8);
        resetButton.setOnAction(e -> reset());

        return new Scene(pane, 1000, 600);
    }

    private void filter()
    {
        String make = makesCB.getSelectionModel().getSelectedItem();
        String fuelType = fuelTypesCB.getSelectionModel().getSelectedItem();
        int cityMPG = (int) cityMPGSlider.getValue();
        int hwyMPG = (int) hwyMPGSlider.getValue();
        carsList = controller.filter(c -> (make == null || c.getMake().equalsIgnoreCase(make))
                && (fuelType == null || c.getFuelType().equalsIgnoreCase(fuelType)) && c.getCityMPG() >= cityMPG
                && c.getHighwayMPG() >= hwyMPG);
        carsLV.setItems(carsList);
        recordCountLabel.setText(carsList.size() + " record(s) displayed");
    }

    private void selectCar()
    {
        selectedCar = carsLV.getSelectionModel().getSelectedItem();
        deleteButton.setDisable(false);
    }

    private void addCar()
    {
        // TODO: Implement this method
    }

    private void deleteCar()
    {
        controller.deleteCar(selectedCar);
        deleteButton.setDisable(true);
        carsLV.getSelectionModel().select(-1);
        filter();
        recordCountLabel.setText(carsList.size() + " record(s) displayed");
    }

    private void reset()
    {
        makesCB.getSelectionModel().select(-1);
        fuelTypesCB.getSelectionModel().select(-1);
        carsLV.getSelectionModel().select(-1);
        cityMPGSlider.setValue(0.0);
        hwyMPGSlider.setValue(0.0);
        deleteButton.setDisable(true);
        carsList = controller.getAllCars();
        carsLV.setItems(carsList);
    }

    private void createAddCarScene()
    { // Lets make copies of the original combo boxe
        newMakesCB = new ComboBox<>(makesList); // these list are the distinct
                                                // makes
        newFuelTypesCB = new ComboBox<>(fuelTypesList); // and distinct fuel
                                                        // types

        saveButton.setOnAction(e -> saveNewCar());
        cancelButton.setOnAction(e -> cancelAddCarScene());
        // Lets configure the error label to be red and hidden
        errorLabel.setTextFill(Color.RED);
        errorLabel.setVisible(false);

        GridPane pane = new GridPane();
        pane.setVgap(10);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.add(errorLabel, 1, 0);
        pane.add(new Label("Make"), 0, 1);
        pane.add(new Label("Description"), 0, 2);
        pane.add(new Label("Horsepower"), 0, 3);
        pane.add(new Label("Fuel Type"), 0, 4);
        pane.add(new Label("City MPG"), 0, 5);
        pane.add(new Label("Highway MPG"), 0, 6);
        pane.add(new Label("Hybrid"), 0, 7);

        HBox hbox = new HBox(saveButton, cancelButton);
        hbox.setSpacing(20);
        pane.add(newMakesCB, 1, 1);
        pane.add(descriptionTF, 1, 2);
        pane.add(horsepowerTF, 1, 3);
        pane.add(newFuelTypesCB, 1, 4);
        pane.add(cityMPGTF, 1, 5);
        pane.add(hwyMPGTF, 1, 6);
        pane.add(hybridCheckBox, 1, 7);
        pane.add(hbox, 1, 8);

        Scene createCarScene = new Scene(pane);
        mainStage.setTitle("Add New Car...");
        mainStage.setScene(createCarScene);
        mainStage.show();
    }

    private void cancelAddCarScene()
    {
        // clear everything otherwise it remmebers it
        errorLabel.setVisible(false);
        // "clear" comboBox
        newMakesCB.getSelectionModel().select(-1);
        newFuelTypesCB.getSelectionModel().select(-1);
        descriptionTF.clear();
        horsepowerTF.clear();
        cityMPGTF.clear();
        hwyMPGTF.clear();
        hybridCheckBox.setSelected(false);
        mainStage.setScene(mainScene);
        mainStage.setTitle("Car Fuel Efficiency");
        mainStage.show();

    }

    private void saveNewCar()
    {
        // Check to see if anything is empty
        if (newMakesCB.getSelectionModel().isEmpty() || descriptionTF.getText().isEmpty()
                || horsepowerTF.getText().isEmpty() || cityMPGTF.getText().isEmpty() || hwyMPGTF.getText().isEmpty())
        {
            errorLabel.setVisible(true);
            return;
        }
        // All fields have been filled out
        // we need to parse them and send them to the controller
        String make = newMakesCB.getSelectionModel().getSelectedItem();
        String description = descriptionTF.getText();
        int horsepower = Integer.parseInt(horsepowerTF.getText());
        String fuelType = cityMPGTF.getText();
        int cityMPG = Integer.parseInt(cityMPGTF.getText());
        int hwyMPG = Integer.parseInt(hwyMPGTF.getText());
        boolean hybrid = hybridCheckBox.isSelected();
        controller.addCar(make, description, horsepower, fuelType, cityMPG, hwyMPG, hybrid);

        cancelAddCarScene();
        filter();
    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }

}
package edu.orangecoastcollege.cs272.ic08;

import java.text.NumberFormat;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TipCalculatorFX extends Application {

	// TODO: Create slider for tipPercent
	private Slider mTipPercentSlider = new Slider(0,30,10); // param min, max, start

	private Label mTipPercentLabel = new Label("15%");
	private TextField mBillAmountTF = new TextField();
	private TextField mTipAmountTF = new TextField();
	private TextField mTotalAmountTF = new TextField();

	private Button mCalculateButton = new Button("Calculate");
	private Button mClearButton = new Button("Clear");

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create UI
	    // configure the slider
	    mTipPercentSlider.setShowTickLabels(true);
	    mTipPercentSlider.setShowTickMarks(true);
	    // change the increments of our ticks
	    mTipPercentSlider.setBlockIncrement(5);
	    mTipPercentSlider.setMajorTickUnit(5);
	    // moves slider dir to indivuals ticks
	    mTipPercentSlider.setSnapToTicks(true);

		GridPane gridPane = new GridPane();
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		gridPane.add(new Label("Bill Amount:"), 0, 0);
		gridPane.add(mBillAmountTF, 1, 0);
		gridPane.add(mTipPercentSlider, 1, 1);

		gridPane.add(mTipPercentLabel, 0, 1);
		gridPane.add(new Label("Tip Amount:"), 0, 2);
		gridPane.add(mTipAmountTF, 1, 2);
		gridPane.add(new Label("Total Amount:"), 0, 3);
		gridPane.add(mTotalAmountTF, 1, 3);

		// TODO: Instantiate a new HBox, with spacing of 10 between nodes
		  HBox hbox = new HBox(mClearButton, mCalculateButton);
		  hbox.setSpacing(10);
		// TODO: Set the alignment to CENTER_RIGHT and add both buttons
		  hbox.setAlignment(Pos.CENTER_RIGHT);

		// TODO: Add the HBox to the grid pane at row 5, column 1
		  gridPane.add(hbox, 1, 5);

		// Set properties for UI
		gridPane.setAlignment(Pos.CENTER);
		mBillAmountTF.setAlignment(Pos.BOTTOM_RIGHT);
		mTipAmountTF.setAlignment(Pos.BOTTOM_RIGHT);
		mTotalAmountTF.setAlignment(Pos.BOTTOM_RIGHT);

		// TODO: make the tipAmountTF not editable and not focusable
		mTipAmountTF.setEditable(false);
	    mTipAmountTF.setFocusTraversable(false);

		// TODO: make the totalAmountTF not editable and not focusable
	   this.mTotalAmountTF.setEditable(false);
	   this.mTotalAmountTF.setFocusTraversable(false);

		// TODO: Handle events (calculate button, clear button and slider value changed)
	   mClearButton.setOnAction(e -> clear());
	   mCalculateButton.setOnAction(e -> calculate());

	   mTipPercentSlider.valueProperty().addListener((obs, oldVal , newVal) -> changeTipPercentage(newVal));


		// Create a scene and place it in the stage
		Scene scene = new Scene(gridPane, 400, 250);
		primaryStage.setTitle("Tip Calculator"); // Set title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}


    private void changeTipPercentage(Number newVal)
    {
        // TODO Auto-generated method stub
        this.mTipPercentLabel.setText(newVal.intValue() + "%");
        calculate();
    }


    private void calculate()
    {
        double percent = mTipPercentSlider.getValue();
        double bill = 0;
        if(!mBillAmountTF.getText().isEmpty())
             bill = Double.valueOf(mBillAmountTF.getText());
        double total = (percent * bill)/100 + bill;
        // Display amout
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        mTipAmountTF.setText(currency.format(percent));
        mTotalAmountTF.setText(currency.format(total));
    }

    private void clear()
    {
        // TODO Auto-generated method stub
	   mBillAmountTF.clear();
	   mTipAmountTF .clear();
	   mTotalAmountTF.clear();

	   //reset slider to defult
	   this.mTipPercentSlider.setValue(15);
	   // return fouce back to the bill amout
	   this.mBillAmountTF.requestFocus();

    }

    public static void main(String[] args) {
		Application.launch(args);
	}

}

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

public class CarPaymentFX extends Application
{
	private Slider mYearsSlider = new Slider(2,5,3); // param min, max, start
	private Label mYearsSliderLabel = new Label("Years: " +  mYearsSlider.getValue());
	
	private TextField mCarPriceF = new TextField();
	private TextField mDownF = new TextField();
	private TextField mRateF = new TextField();
    private TextField mMonthlyPaymentF = new TextField();
    
	private Button mCalculateButton = new Button("Calculate");
	private Button mClearButton = new Button("Clear");

	@Override
	public void start(Stage primaryStage) 
	{
		// Create UI
	    // configure the slider
		mYearsSlider.setShowTickLabels(true);
		mYearsSlider.setShowTickMarks(true);
	    // change the increments of our ticks
		mYearsSlider.setBlockIncrement(1);
		mYearsSlider.setMajorTickUnit(1);
	    // moves slider dir to indivuals ticks
		mYearsSlider.setSnapToTicks(true);

		GridPane gridPane = new GridPane();
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		gridPane.add(new Label("Car Price $"), 0, 0);
		gridPane.add(mCarPriceF, 1, 0);
		gridPane.add(mYearsSlider, 1, 1);

		gridPane.add(mYearsSliderLabel, 0, 1);
		gridPane.add(new Label("Down Payment $:"), 0, 2);
		gridPane.add(mDownF, 1, 2);
		gridPane.add(new Label("Interest Rate %"), 0, 3);
		gridPane.add(mRateF, 1, 3);
		gridPane.add(new Label("Monthly Payment $"), 0, 4);
		gridPane.add(mMonthlyPaymentF, 1, 4);

		// TODO: Instantiate a new HBox, with spacing of 10 between nodes
		  HBox hbox = new HBox(mClearButton, mCalculateButton);
		  hbox.setSpacing(10);
		// TODO: Set the alignment to CENTER_RIGHT and add both buttons
		  hbox.setAlignment(Pos.CENTER_RIGHT);

		// TODO: Add the HBox to the grid pane at row 5, column 1
		  gridPane.add(hbox, 1, 5);

		// Set properties for UI
		gridPane.setAlignment(Pos.CENTER);
		mCarPriceF.setAlignment(Pos.BOTTOM_RIGHT);
		mDownF.setAlignment(Pos.BOTTOM_RIGHT);
		mRateF.setAlignment(Pos.BOTTOM_RIGHT);

		// TODO: make the tipAmountTF not editable and not focusable
		mDownF.setFocusTraversable(false);
		mMonthlyPaymentF.setEditable(false);
	   this.mRateF.setFocusTraversable(false);

		// TODO: Handle events (calculate button, clear button and slider value changed)
	   mClearButton.setOnAction(e -> clear());
	   mCalculateButton.setOnAction(e -> calculate());
	   mYearsSlider.valueProperty().addListener((obs, oldVal , newVal) -> changeYear(newVal));


		// Create a scene and place it in the stage
		Scene scene = new Scene(gridPane, 400, 250);
		primaryStage.setTitle("Car Payment"); // Set title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
	
	private void calculate() 
	{
		// A = p (r(1+r)^n /(1+r)^n   -1
		double fraction = 0, total = 0;
		//if(!mRateF.getText().isEmpty() && ! mCarPriceF.getText().isEmpty())
		{
			double rate =  Double.valueOf(mRateF.getText()) / 100;
			double exp = Math.pow((1 + rate), Double.valueOf(mYearsSlider.getValue()));
		   fraction = rate * exp /(exp);
		
		 total = Double.valueOf(mCarPriceF.getText()) * fraction -1;
		}
		   NumberFormat currency = NumberFormat.getCurrencyInstance();
	       mMonthlyPaymentF.setText(currency.format(total));
	}


	private void changeYear(Number newVal) 
	{
		 NumberFormat currency = NumberFormat.getInstance();
		 this.mYearsSliderLabel.setText("Years: " + currency.format(newVal.doubleValue()));
		 calculate();
	}


	private void clear() 
	{
	 mCarPriceF.clear();
	 mDownF.clear(); 
	 mRateF.clear(); 
	 mMonthlyPaymentF.clear();
	 
	 this.mYearsSlider.setValue(3);
	 mCarPriceF.requestFocus();
	}


	public static void main(String[] args) 
	{
		Application.launch(args);
	}

}

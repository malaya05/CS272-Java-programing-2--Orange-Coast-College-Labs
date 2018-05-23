package application;

import java.text.NumberFormat;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TargetHeartRateFX extends Application
{

	private TextField mAge = new TextField();
	private TextField mMaxHR = new TextField();
	private TextField mTargetHR = new TextField();

	private Button mCalculateButton = new Button("Calculate");
	private Button mClearButton = new Button("Clear");
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		GridPane gridPane = new GridPane();
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		gridPane.add(new Label("Your Age: "), 0, 0);
		gridPane.add(mAge, 1, 0);
		gridPane.add(mMaxHR, 1, 1);
		gridPane.add(new Label("Maximum Heart Rate: "), 0, 1);
		gridPane.add(mTargetHR, 1, 2);
		gridPane.add(new Label("Target Hart Rate: "), 0, 2);
		
		  HBox hbox = new HBox(mClearButton, mCalculateButton);
		  hbox.setSpacing(10);
		  hbox.setAlignment(Pos.CENTER_RIGHT);
		  
		gridPane.add(hbox, 1, 5);
	    gridPane.setAlignment(Pos.CENTER);
		
	    mMaxHR.setEditable(false);
	    mTargetHR.setEditable(false);
	    mClearButton.setOnAction(e -> clear());
		mCalculateButton.setOnAction(e -> calculate());
		   
	    Scene scene = new Scene(gridPane, 400, 250);
		primaryStage.setTitle("Target Heart Rate"); // Set title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

	}
	private void calculate()
	{
		int maxHR = 220;
	if(!mAge.getText().isEmpty())
	{
		maxHR -=  Integer.valueOf(mAge.getText());
	}
	int lowRange = (int) (maxHR * 0.5);
	int highRange =(int) (maxHR * 0.85);
	
     this.mMaxHR.setText(String.valueOf(maxHR));
     this.mTargetHR.setText(String.valueOf(lowRange)+ " <-> " + String.valueOf(highRange) );
		
	}
	private void clear() 
	{
		mAge.clear();
	    mMaxHR.clear();
	    mTargetHR.clear();
		mAge.requestFocus();
	}
	
	public static void main(String args[])
	{
		Application.launch(args);
	}

}

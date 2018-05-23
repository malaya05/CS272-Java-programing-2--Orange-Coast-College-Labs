import java.text.NumberFormat;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoanCalculatorFX extends Application
{
 // Member variables should be the nodes we intreact with
private TextField mIntrestRateTF = new TextField();
private TextField mNumOfYearsTF = new TextField();
private TextField mloanAmtTF = new TextField();
private TextField mMonthlyPaymentTF = new TextField();
private TextField mTotalPaymentTF = new TextField();


private Button mClearButton = new Button("Clear");
private Button mCalculateButton = new Button("Calculate");

private GridPane mGridPane = new GridPane();
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // Fill the GridPane with all the nodes
        mGridPane.add(new Label("Annual Interest Rate: "), 0, 0);
        mGridPane.add(mIntrestRateTF, 1, 0);
        mGridPane.add(new Label("Number of Years: "), 0, 1);
        mGridPane.add(mNumOfYearsTF, 1, 1);
        mGridPane.add(new Label("Loan Amout: "),0 , 2);
        mGridPane.add(mloanAmtTF, 1, 2);
        mGridPane.add(new Label("Monthly Payment: "), 0, 3);
        mGridPane.add(mMonthlyPaymentTF, 1, 3);
        mGridPane.add(new Label("Total Payment: "), 0, 4);
        mGridPane.add(mTotalPaymentTF,1,4);


        // adding the buttons
        mGridPane.add(mClearButton,0,5);
        mGridPane.add(mCalculateButton,1,5);

        // Define Events handler for each button
        mClearButton.setOnAction(e -> clear());
        mCalculateButton.setOnAction(e -> calculate());

        // Align the GridPane to center
        mGridPane.setAlignment(Pos.CENTER);
        mGridPane.setHgap(5);
        mGridPane.setVgap(5);

        mIntrestRateTF.setAlignment(Pos.CENTER_RIGHT);
        mMonthlyPaymentTF.setEditable(false);
        mTotalPaymentTF.setEditable(false);

        // After making the pan, add it to the scene
        Scene scene = new Scene(mGridPane,400, 250);
        // Add the Scene to stage
        primaryStage.setTitle("Loan Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    private Object calculate()
    {
        double r = Double.parseDouble(mIntrestRateTF.getText()) / 100 / 12;
        double period = Double.parseDouble(mNumOfYearsTF.getText()) * 12;
        double loanAmount = Double.parseDouble(this.mloanAmtTF.getText());

        double top = r * loanAmount;
        double dom = 1- (Math.pow((1+r) , -period));
        double frac = top / dom;
        double monthlypayment = frac;
        double totalPayment = monthlypayment * period;
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        this.mMonthlyPaymentTF.setText(currency.format(monthlypayment));
         this.mTotalPaymentTF.setText(currency.format(totalPayment));

        return null;
    }

    private void clear()
    {
        //clear all text fields
        mIntrestRateTF.clear();
        this.mNumOfYearsTF.clear();
        this.mloanAmtTF.clear();
        this.mMonthlyPaymentTF.clear();
        this.mTotalPaymentTF.clear();

        // Reset the fouces back to intreast rate
        mIntrestRateTF.requestFocus();
    }

    public static void main(String[] args)
    {
        // tp launch javafx app
      Application.launch(args);
    }
}

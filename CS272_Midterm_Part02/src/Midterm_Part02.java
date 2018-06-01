
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Midterm_Part02 extends Application
{

GridPane gPane = new GridPane();

TextField amount = new TextField();
TextField years = new TextField();
TextField rate = new TextField();
TextField futuer = new TextField();

Button mClear = new Button("Clear");
Button mCalculate = new Button("Calculate");

@Override
public void start(Stage primaryStage) throws Exception
{
    gPane.add(new Label("Investment Amount: "), 0,0);
    gPane.add(amount,1,0);

    gPane.add(new Label("Number Of Years: "), 0,1);
    gPane.add(years, 1, 1);

    gPane.add(new Label("Annual Interest Rate: "), 0,2);
    gPane.add(rate, 1, 2);

    gPane.add(new Label("Future value "), 0,3);
    gPane.add(futuer, 1, 3);

    HBox hbox = new HBox(mClear, mCalculate);
    hbox.setAlignment(Pos.CENTER_RIGHT);
    hbox.setSpacing(8);

    gPane.add(hbox,1 ,4 );

    gPane.setAlignment(Pos.CENTER);
    gPane.setVgap(5);
    gPane.setHgap(5);

    futuer.setEditable(false);

    mClear.setOnAction(e -> clear());
    mCalculate.setOnAction(e -> calc());

    Scene s = new Scene(gPane, 400 ,250);
    primaryStage.setTitle("Future Value of Investment");
    primaryStage.setScene(s);
    primaryStage.show();
}

private Object calc()
{

    double theRate = (Double.parseDouble(rate.getText())/100 + 1);
    System.out.println(theRate);
    int numYears = Integer.parseInt(years.getText()) ;
    double power = Math.pow(theRate, numYears);
   double f = power * Double.parseDouble(amount.getText());
   futuer.setText(String.valueOf(f));
    return null;
}

private Object clear()
{
    // TODO Auto-generated method stub
    amount.clear();
    years.clear();
    rate.clear();
    futuer.clear();
    amount.requestFocus();
    return null;
}

public static void main(String [] args)
{
    Application.launch(args);
}

}

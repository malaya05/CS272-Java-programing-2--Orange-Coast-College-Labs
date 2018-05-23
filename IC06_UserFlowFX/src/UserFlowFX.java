import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

// to tell Java it is an fx program extends app
public class UserFlowFX extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // Define a GridPane to store all nodes
        GridPane pane = new GridPane();
        // Define a padding (border from  the sides)
        pane.setPadding(new Insets(10,10,10,10));
        // if all the padding is the same do
        // pane.setPadding(new Insets(10));
        pane.setHgap(5);
        pane.setVgap(5);

        // putting nodes into the pane
        pane.add(new Label("First Name: "), 0, 0);
        pane.add(new TextField(), 1, 0);

        pane.add(new Label("MI: "), 0, 1);
        pane.add(new TextField(), 1, 1);

        pane.add(new Label("Last Name: "), 0, 2);
        pane.add(new TextField(), 1, 2);

        pane.add(new Button("Add Name"), 1, 3);

        // add the pane to a scene
        Scene scene = new Scene(pane);

        // set up the stage
        primaryStage.setTitle("User Info");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String [] args)
    {
       // tell javaFx to launch this app
        Application.launch(args);
    }

}

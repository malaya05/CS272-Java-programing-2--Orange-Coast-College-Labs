import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ControlCircle extends Application
{
private BorderPane border = new BorderPane();
private Button mShrink = new Button("Shrink");
private Button mEnlarge = new Button("Enlarge");
private Circle cir = new Circle(220,100,50,Color.SNOW);

public HBox addHbox()
{
    HBox hbox = new HBox(mEnlarge,mShrink);
    hbox.setPadding(new Insets(15, 12, 15, 12));
    hbox.setSpacing(10);
    return hbox;
}
    @Override
    public void start(Stage arg0) throws Exception
    {
        cir.setStrokeWidth(1);
        cir.setStroke(Color.BLACK);
        border.setCenter(cir);
        border.setBottom(addHbox());

        mShrink.setOnAction(e -> shrink());
        mEnlarge.setOnAction(e -> bigger());

        //Scene scene = new Scene(border,400, 250);
        // Add the Scene to stage
        arg0.setTitle("Control Circle");
        arg0.setScene(new Scene(border,400, 250));
        arg0.show();
    }

    private void bigger()
    { cir.setRadius(cir.getRadius()+2);}
    
    private void shrink()
    { cir.setRadius(cir.getRadius()-2);}
    
    public static void main(String[] args)
    {
      Application.launch(args);
    }
}

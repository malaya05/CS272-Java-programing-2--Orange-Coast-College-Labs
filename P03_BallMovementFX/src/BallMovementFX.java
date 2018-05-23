import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class BallMovementFX extends Application
{
//private BorderPane border = new BorderPane();
private Button mUp = new Button("UP");
private Button mDown = new Button("Down");
private Button mLeft = new Button("Left");
private Button mRight = new Button("Right");

private Circle cir = new Circle(220,100,50,Color.SNOW);

 Pane border = new Pane(cir,addHbox());

public HBox addHbox()
{
    HBox hbox = new HBox(mLeft, mRight, mUp,mDown);
    hbox.setPadding(new Insets(15, 12, 15, 12));
    hbox.setSpacing(10);
    hbox.setAlignment(Pos.BOTTOM_CENTER);
    return hbox;
}


   
@Override
    public void start(Stage arg0) throws Exception
    {
        cir.setStrokeWidth(1);
        cir.setStroke(Color.BLACK);
        
        
        
        mUp.setOnAction(e -> moveUp());
        mDown.setOnAction(e -> moveDown());
        mLeft.setOnAction(e -> moveLeft());
        mRight.setOnAction(e -> moveRight());


        //Scene scene = new Scene(border,400, 250);
        // Add the Scene to stage
        arg0.setTitle("Control Circle");
        arg0.setScene(new Scene(border,400, 250));
        arg0.show();
    }

   
    
    private void moveRight() 
    {
    	cir.setCenterX(cir.getCenterX() + 50);
    
	}
    
	private void moveLeft() 
	{
		cir.setCenterX(cir.getCenterX() - 50);
	}
	
	private void moveDown() 
	{
		cir.setCenterY(cir.getCenterY() + 50);
	}
	
	private void moveUp() 
	{
		cir.setCenterY(cir.getCenterY() - 50);
	}
	
	
	public static void main(String[] args)
    {
      Application.launch(args);
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EmployeeDBFX extends Application
{
    private ListView<String> mEmployeeLV = new ListView<>();
    private ObservableList<String> mEmployeeList;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        mEmployeeList = FXCollections.observableArrayList();

        //connect the listview with obseravable list
        mEmployeeLV.setItems(mEmployeeList);
        createDBTable();
       // addEmployeeToDB();
        GridPane pane = new GridPane();
        pane.add(new Label("Names:"), 0, 0);
        pane.add(mEmployeeLV,0,1);

        // Configure the size of the list view
        mEmployeeLV.setPrefWidth(500);
        mEmployeeLV.setPrefHeight(400);


        Scene scene = new Scene(pane);
        primaryStage.setTitle("Java 2 People");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void createDBTable()
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
        }
        catch (ClassNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // Establish a connection to database
        // try with resources
          try(Connection connection = DriverManager.getConnection("Jdbc:sqlite:employee.db");
               Statement stmt = connection.createStatement();)
          {
              //create statment
              StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS employee(");
              sb.append("_id INTEGER PRIMARY KEY, ");
              sb.append("first_name TEXT, ");
              sb.append("last_name TEXT, ");
              sb.append("rank TEXT, ");
              sb.append("salary REAL)");

             // System.out.println(sb);
              //EXCuter the update
              StringBuilder fix = new StringBuilder("DROP TABLE IF EXISTS employee");
              stmt.executeUpdate(fix.toString());

              // if the table exist populates observablelist with all records
              sb = new StringBuilder("SELECT * FROM employee");
              // ResultSet are the records returnd (if any)
              ResultSet rs = stmt.executeQuery(sb.toString());
              while(rs.next())
              {
                  // you can supply name of the colume or the index
                  String name = rs.getString("first_name");
                  mEmployeeList.add(name);
               }
     }
          catch(SQLException e)
          {
              System.err.println(e.getMessage());
          }
        }

    
    private void addEmployeeToDB()
	{
	    try
	    {
	        Class.forName("org.sqlite.JDBC");
	    }
	    catch (ClassNotFoundException e)
	    {

	        e.printStackTrace();
	    }

	      try(Connection connection = DriverManager.getConnection("Jdbc:sqlite:employee.db");
	           Statement stmt = connection.createStatement();)
	      {
	    	  Scanner cin = new Scanner(new File("Employees.txt"));
	    	  while(cin.hasNextLine())
	    	  {
	    		  String line[] = cin.nextLine().split(" ");
	    		  String fName = line[0];
	    		  String lName = line[1];
	    		  String rank =  line[2];
	    		  String salary =line[3];
	          //create statment
	          StringBuilder sb = new StringBuilder("INSERT INTO employee(first_name , last_name, rank, salary) VALUES('");
	          sb.append(fName+"', '").
	          append(lName+"', '").
	          append(rank+"', '").
	          append(salary+"')");

	      
	          //EXCuter the update
	          stmt.executeUpdate(sb.toString());
	    	  }
	      }
	      catch(SQLException e)
	      {
	          System.err.println(e.getMessage());
	      } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public static void main(String args [])
    {
        Application.launch(args);
    }

}

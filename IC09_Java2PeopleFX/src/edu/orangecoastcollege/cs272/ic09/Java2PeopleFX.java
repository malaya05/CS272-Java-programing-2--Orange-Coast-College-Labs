package edu.orangecoastcollege.cs272.ic09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Java2PeopleFX extends Application {

    private ListView<String> mPeopleLV = new ListView<>();
    private ObservableList<String> mPeopleList;
	private TextField mNameTF = new TextField();
	private Button mAddPersonButton = new Button("Add Person");

	@Override
	public void start(Stage primaryStage) throws Exception {

	    //observable list automatically updates the list view connected to it
	    mPeopleList = FXCollections.observableArrayList();

	    //connect the listview with obseravable list
	    mPeopleLV.setItems(mPeopleList);
	    createDBTable();

		GridPane pane = new GridPane();
		pane.add(new Label("Names:"), 0, 0);
		pane.add(mPeopleLV,0,1);

		// Configure the size of the list view
		mPeopleLV.setPrefWidth(500);

		HBox hBox = new HBox();
		hBox.getChildren().add(mNameTF);
		hBox.getChildren().add(mAddPersonButton);
		hBox.setSpacing(25.0);
		pane.add(hBox, 0, 2);

		// create an event for the button
		mAddPersonButton.setOnAction(e -> handleAddPerson());

		Scene scene = new Scene(pane);
		primaryStage.setTitle("Java 2 People");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void handleAddPerson()
    {
        // TODO Auto-generated method stub
	    String name = mNameTF.getText();
	    addPersonToDB(name);
	    //add person to ob list
	    mPeopleList.add(name);
	    // clear out textField
	    mNameTF.clear();
	    mNameTF.requestFocus();


    }

    public static void main(String[] args) {
		Application.launch(args);
	}

	private void createDBTable()
	{
	  // Load the Classes for SQLite from JAR file
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
	  try(Connection connection = DriverManager.getConnection("Jdbc:sqlite:people.db");
	       Statement stmt = connection.createStatement();)
	  {
	      //create statment
	      StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS people(");
	      sb.append("_id INTEGER PRIMARY KEY, ");
	      sb.append("name TEXT)");

	     // System.out.println(sb);
	      //EXCuter the update
	      stmt.executeUpdate(sb.toString());

	      // if the table exist populates observablelist with all records
	      sb = new StringBuilder("SELECT * FROM people");
	      // ResultSet are the records returnd (if any)
	      ResultSet rs = stmt.executeQuery(sb.toString());
	      while(rs.next())
	      {
	          // you can supply name of the colume of the index
	          String name = rs.getString("name");
	          mPeopleList.add(name);
	       }
 }
	  catch(SQLException e)
	  {
	      System.err.println(e.getMessage());
	  }
	}

	private void addPersonToDB(String name)
	{
	    try
	    {
	        Class.forName("org.sqlite.JDBC");
	    }
	    catch (ClassNotFoundException e)
	    {

	        e.printStackTrace();
	    }

	      try(Connection connection = DriverManager.getConnection("Jdbc:sqlite:people.db");
	           Statement stmt = connection.createStatement();)
	      {
	          //create statment
	          StringBuilder sb = new StringBuilder("INSERT INTO people(name) VALUES('");
	          sb.append(name).append("')");

	          //EXCuter the update
	          stmt.executeUpdate(sb.toString());
	      }
	      catch(SQLException e)
	      {
	          System.err.println(e.getMessage());
	      }
	}

}

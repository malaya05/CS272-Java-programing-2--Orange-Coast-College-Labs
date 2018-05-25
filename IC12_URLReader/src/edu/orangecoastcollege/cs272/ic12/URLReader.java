package edu.orangecoastcollege.cs272.ic12;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class URLReader extends Application {

	// Nodes on the main scene
	TextField urlTF = new TextField("http://");
	TextArea outputTA = new TextArea("Enter URL in the text field above, then press the enter key.\n\n" +
	"The contents of the resource will be displayed here if found.\n" +
			"Otherwise, an error code and message will display.");

	@Override
	public void start(Stage primaryStage) throws Exception {

		GridPane pane = new GridPane();
		pane.setVgap(10.0);
		pane.setHgap(10.0);
		pane.setPadding(new Insets(10, 10, 10, 10));

		urlTF.setOnAction(e -> readURL());
		pane.add(new Label("Enter URL and press ENTER : "), 0, 0);
		pane.add(urlTF,  1, 0);

		outputTA.setPrefHeight(550);
		outputTA.setPrefWidth(800);
		pane.add(outputTA, 0, 1, 2, 1);

		primaryStage.setScene(new Scene(pane));
		primaryStage.setTitle("URL Reader");
		primaryStage.show();
	}

	private void readURL() {

		//TODO: Implement this method
	   // 1) get The URL from the text field
	    try
        {
            URL url = new URL(urlTF.getText());
            // open HTTP conenctions
            HttpURLConnection conection = (HttpURLConnection) url.openConnection();

            int code = conection.getResponseCode();
            String message = conection.getResponseMessage();

            if(code != HttpURLConnection.HTTP_OK)
            {
                outputTA.setText(String.valueOf(code) + ": " + message);
                return;
            }
            // otherwise, loop tjrough the server response
           // We need input stream to read a server response
            InputStream in = conection.getInputStream();

            // set up a Scanner on the input stream
            Scanner inScanner = new Scanner(in);
            StringBuilder sb = new StringBuilder();

            while(inScanner.hasNextLine())
            {
                sb.append(inScanner.nextLine()).append("\n");
            }
            outputTA.setText(sb.toString());

            //close all open resources
            inScanner.close();
            
            conection.disconnect();
        }
        catch (IOException e)
        {
            // in the text area, let's print URL  is malformed
            outputTA.setText("Bad URL");
        }
	}

	public static void main(String[] args)
	{
		Application.launch(args);
	}

}

package edu.orangecoastcollege.cs272.finalexam.view;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainView extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {		
		ViewNavigator.setStage(primaryStage);
		ViewNavigator.loadScene("Earth Quaking 1.0 ", ViewNavigator.LIST_EARTHQUAKES_SCENE);
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}

package edu.orangecoastcollege.cs272.ic13.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.ic13.controller.Controller;
import edu.orangecoastcollege.cs272.ic13.model.VideoGame;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

// TODO: Implement the Initializable interface
public class VideoGamesListScene implements Initializable{

	private static Controller controller = Controller.getInstance();

	@FXML
	private ListView<VideoGame> allVideoGamesLV;
	@FXML
	private ComboBox<String> publishersCB;
	@FXML
	private ComboBox<String> platformsCB;

	// TODO: Override the initialize method (let Eclipse generate the method for you)
	// In this method:
	// 1) Set the items of the allVideoGamesLV to all video games from the controller
	// 2) Set the items of the platformsCB to the distinct platforms from the controller
	// 3) Set the items of the publishersCB to the distinct publishers from the controller

	@FXML
	public boolean addGameToInventory()
	{
		//TODO: Complete this method
	    // 1) Get the selected video game from the allVideoGamesLV (use getSelectedItem())
	      VideoGame selectedGame = allVideoGamesLV.getSelectionModel().getSelectedItem();
	    // 2) Use the controller to add the selected game to the inventory
	      return controller.addGameToUsersInventory(selectedGame);
		// 3) Return the result (as a boolean)
	}

	@FXML
	public void viewInventory()
	{
		//TODO: Complete this method
		// 1) Use the ViewNavigator to load the VIEW_INVENTORY_SCENE with the title �User�s Video Games�
	    ViewNavigator.loadScene("User's video Games", ViewNavigator.VIEW_INVENTORY_SCENE);
	}

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        //1) set the items of the allLV to cideo games from the controller
        allVideoGamesLV.setItems(controller.getAllVideoGames());
        // 2)
        platformsCB.setItems(controller.getDistinctPlatforms());
        publishersCB.setItems(controller.getDistinctPublishers());

    }

}

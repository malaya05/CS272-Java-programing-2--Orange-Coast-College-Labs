package edu.orangecoastcollege.cs272.ic13.view;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.text.View;

import edu.orangecoastcollege.cs272.ic13.controller.Controller;
import edu.orangecoastcollege.cs272.ic13.model.VideoGame;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

// TODO: Implement the Initializable interface
public class ViewInventoryScene implements Initializable  {

	private static Controller controller = Controller.getInstance();

	@FXML
	private ListView<VideoGame> userVideoGamesLV;
	@FXML
	private Label userLabel;

	// TODO: Override the initialize method (let Eclipse generate the method for you)
	// In this method:
	// 1) Set the text of the userLabel to the name of the current user from the controller
	// 2) Set the items of the userVideoGamesList to the games for the current user from the controller


	@FXML
	public void backToAllGames()
	{

		// 1) Navigate back to the VideoGamesListScene
	    ViewNavigator.loadScene("Video Game List", ViewNavigator.VIDEO_GAME_LIST_SCENE);
	}

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        // TODO Auto-generated method stub
        //1 set text of the userLable to the name of the current user from controler
        userLabel.setText(controller.getCurrentUser().getName());
        //2 set the items of the
        userVideoGamesLV.setItems(controller.getGamesForCurrentUser());

    }
}

package jc.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import jc.Model.Account;

public class MoreInformationScene {
<<<<<<< HEAD

	@FXML
	Button back;
	@FXML
	Label title;
	@FXML
	Button quit;
	@FXML
	Button changeCity;
	@FXML
	TextArea moreInformationText;
	@FXML
	Label createSignIn;

	public void initialize() throws FileNotFoundException {
		title.setText(ReviewScene.cw.getName()); // SET CAR WASH LOCATION NAME
		File file = new File("./src/DataMock/MoreInformation.txt");
		Scanner inputFile = new Scanner(file);
		String carWashName = "";
		String tempCarWashName = "";
		// DISPLAY CONTACT AND OPERATIONAL HOUR OF CAR WASH LOCATION
		while (inputFile.hasNext()) {
			carWashName += inputFile.nextLine() + "\n";
			tempCarWashName = carWashName;
		}
		moreInformationText.setText(tempCarWashName);
		inputFile.close();
=======
	
	@FXML Button back;
	@FXML Label title;
	@FXML Button quit;
	@FXML Button changeCity;
	@FXML TextArea moreInformationText;
	@FXML Label createSignIn;
	
	public void initialize() throws FileNotFoundException
	{
		setSignInText();
		
		 title.setText(ReviewScene.cw.getName()); //SET CAR WASH LOCATION NAME
		 File file = new File("./src/DataMock/MoreInformation.txt");
		 Scanner inputFile = new Scanner(file);
		 String carWashName= "";
		 String tempCarWashName = "";
		 //DISPLAY CONTACT AND OPERATIONAL HOUR OF CAR WASH LOCATION
		 while(inputFile.hasNext()) 
		 {
			 carWashName += inputFile.nextLine()+"\n";
			 tempCarWashName = carWashName;
		 }
		 moreInformationText.setText(tempCarWashName);
		 inputFile.close();
>>>>>>> cf5d1c60d21d6438e7b6adde77263db436077e74
	}

	// RETURN TO CHOOSE CAR WASH LOCATION
	@FXML
	public Object back() throws IOException {
		ReviewScene.cw = null;
		Main.swapScene("CityScene.fxml");
		return null;
	}

	// TERMINATE THE PROGRAM
	@FXML
	public Object quit() {
		System.exit(0);
		return null;
	}

	// RETURN TO THE BEGINNING TO SELECT CITY
	@FXML
	public Object changeCity() throws IOException {
		Main.swapScene("StartScene.fxml");
		return null;
	}

	// DIRECT TO THE CREATE ACCOUNT/ SIGN IN SCENE
	@FXML
	public Object createSignIn() throws IOException {
		Main.swapToLoginScene();
		SignInScene.saveScene = "MoreInformation.fxml";
		setSignInText();
		return null;
	}
<<<<<<< HEAD

	// @FXML public Object writeReview() throws IOException
	// {
	// Main.swapScene("WriteScene.fxml");
	// return null;
	// }
=======
	
	private void setSignInText()
	{
		if (Account.signedIn)
			createSignIn.setText("Log out");
		else
			createSignIn.setText("Create Account / Sign In");
	}
	
//	@FXML public Object writeReview() throws IOException
//	{
//		Main.swapScene("WriteScene.fxml");
//		return null;
//	}
>>>>>>> cf5d1c60d21d6438e7b6adde77263db436077e74
}

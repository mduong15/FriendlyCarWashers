package jc.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import jc.Model.Review;

public class MoreInformationScene {
	
	@FXML Button back;
	@FXML Label title;
	@FXML Button quit;
	@FXML Button changeCity;
	//@FXML Button writeReview;
	@FXML TextArea moreInformationText;
	
	public void initialize() throws FileNotFoundException
	{
		 title.setText(ReviewScene.cw.getName());
		 File file = new File("./src/DataMock/MoreInformation.txt");
		 Scanner inputFile = new Scanner(file);
		 String carWashName;
		 String tempCarWashName = "";
		 while(inputFile.hasNext()) 
		 {
			 carWashName = inputFile.nextLine();
			 
				 
		//	 if(carWashName.equals(ReviewScene.cw.getName()))
		//		 break;
			 tempCarWashName = carWashName;
		 }
		 moreInformationText.setText(tempCarWashName);
		 inputFile.close();
	}
	
	@FXML public Object back() throws IOException
	{
		ReviewScene.cw=null;
		Main.swapScene("CityScene.fxml");
		return null;
	}
	@FXML public Object quit()
	{
		System.exit(0);
		return null;
	}
	@FXML public Object changeCity() throws IOException
	{
		Main.swapScene("StartScene.fxml");
		//dummy comment
		return null;
	}
	
//	@FXML public Object writeReview() throws IOException
//	{
//		Main.swapScene("WriteScene.fxml");
//		return null;
//	}
}

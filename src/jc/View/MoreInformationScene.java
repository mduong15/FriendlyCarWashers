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
	@FXML TextArea moreInformationText;
	
	public void initialize() throws FileNotFoundException
	{
		 title.setText(ReviewScene.cw.getName());
		 Scanner scan = new Scanner(new File(".src/DataMock/MoreInformation.txt"));
		 String carWashName;
		 while(true) {
			 carWashName=scan.next(";");
			 if(carWashName.equals(ReviewScene.cw.getName()))
				 break;
		 }
		 moreInformationText.setText(scan.next(";"));
		 scan.close();
	}
	
	@FXML public Object back() throws IOException{
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
}

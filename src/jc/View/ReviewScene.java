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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import jc.Model.CarWash;
import jc.Model.Review;

public class ReviewScene {
	static CarWash cw;
	
	@FXML Button review;
	@FXML Button back;
	@FXML ListView<Review> reviewView;
	@FXML Label title;
	@FXML Button quit2;
	
	private ObservableList<Review> rev;
	
	public void initialize() throws FileNotFoundException{
		 title.setText("Seeing reviews for: "+cw.getName());
		 rev=FXCollections.observableArrayList(cw.getReviews());
		 File[] files=new File("./src/DataMock").listFiles();
		 LOOP:for(File f:files){
			 if(f.getName().equals(cw.getName())){
				 Scanner fs=new Scanner(f);
				 review.setText("Edit Review");
				 String data[]=fs.nextLine().split(";");
				 rev.add(new Review(data[0],Integer.parseInt(data[1])));
				 fs.close();
				 break LOOP;
			 }
		 }
		 reviewView.setItems(rev);
	}
	
	@FXML public Object review() throws IOException{
		Main.swapScene("WriteScene.fxml");
		return null;
	}
	@FXML public Object back() throws IOException{
		cw=null;
		Main.swapScene("CityScene.fxml");
		return null;
	}
	@FXML public Object quit2()
	{
		System.exit(0);
		return null;
	}
	
}

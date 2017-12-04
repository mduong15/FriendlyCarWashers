package jc.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import jc.Model.Account;
import jc.Model.CarWash;
import jc.Model.Review;

public class ReviewScene {
	static CarWash cw;
	static Map<String, Review> userReviews;
	
	@FXML Button review;
	@FXML Button back;
	@FXML ListView<Review> reviewView;
	@FXML Label title;
	@FXML Button quit2;
	@FXML Button changeCity;
	@FXML Label createSignIn;
	
	private ObservableList<Review> rev;
	
	public void initialize() throws FileNotFoundException{
		setSignInText();
		
		 title.setText("Seeing reviews for: "+cw.getName());
		 rev=FXCollections.observableArrayList(cw.getReviews());
		 
		 userReviews = cw.getUserReviews();
		 if (userReviews != null)
			 userReviews.forEach((k, v)->rev.add((Review)v));
		 
		 if (Account.signedIn)
		 {
			 if (userReviews.containsKey(Account.signedInUser))
				 review.setText("Edit Review");
		 }
		 
//		 File[] files=new File("./src/DataMock").listFiles();
//		 LOOP:for(File f:files){
//			 if(f.getName().equals(cw.getName())){
//				 Scanner fs=new Scanner(f);
//				 review.setText("Edit Review");
//				 String data[]=fs.nextLine().split(";");
//				 rev.add(new Review(data[0],Integer.parseInt(data[1]), data[2].equals("Edited")));
//				 fs.close();
//				 break LOOP;
//			 }
//		 }
		 reviewView.setItems(rev);
	}
	
	@FXML public Object review() throws IOException{
		if (Account.signedIn)
			Main.swapScene("WriteScene.fxml");
		else
		{
			/*** DISPLAY POP UP TO SIGN IN***/
			SignInScene.displaySigninWarning();
		}
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
	@FXML public Object changeCity() throws IOException
	{
		Main.swapScene("StartScene.fxml");
		//dummy comment
		return null;
	}
	@FXML public Object createSignIn() throws IOException
	{
		Main.swapToLoginScene();
		SignInScene.saveScene = "ReviewScene.fxml";
		setSignInText();
		return null;
	}
	
	private void setSignInText()
	{
		if (Account.signedIn)
			createSignIn.setText("Log out");
		else
			createSignIn.setText("Create Account / Sign In");
	}
}
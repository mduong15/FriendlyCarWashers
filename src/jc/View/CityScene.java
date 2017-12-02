package jc.View;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import jc.Model.Account;
import jc.Model.CarWash;
import jc.Model.City;
import jc.Model.Review;

public class CityScene {
	static String city;
	
	@FXML Label title;
	@FXML Label indicator;
	@FXML ListView<CarWash> washes;
	@FXML Button priceSort;
	@FXML Button rateSort;
	@FXML Button select;
	@FXML Button back;
	@FXML Button quit;
	@FXML Button information;
	@FXML Label createSignIn;
	@FXML Button seeCoupon;
	private ObservableList<CarWash> washList;
	
	public void initialize() throws FileNotFoundException{
		setSignInText();
		
		washList=FXCollections.observableArrayList();
		title.setText("You have chosen: "+city);
		
		City currCity = null;
		int i = 0, end = Main.carWashes.cities.size();
		while (i < end && currCity == null)
		{
			if (Main.carWashes.cities.get(i).name == city)
				currCity = Main.carWashes.cities.get(i);
			i++;
		}
		
		if (currCity == null)
			System.out.println("Whoops something went wrong with making the city.");
		
		for (CarWash wash : currCity.carWashes)
		{
			washList.add(wash);
		}
		
		washes.setItems(washList);
	}
	
	@FXML public Object priceSort(){
		Collections.sort(washList,new Comparator<CarWash>(){
			public int compare(CarWash c1,CarWash c2){
				if(c1.getPrice()>c2.getPrice())return 1;
				else if(c1.getPrice()<c2.getPrice())return -1;
				return 0;
			}
		});
		indicator.setText("The list has been sorted by: Price ▲");
		indicator.setVisible(true);
		return null;
	}
	@FXML public Object rateSort(){
		Collections.sort(washList,new Comparator<CarWash>(){
			public int compare(CarWash c1,CarWash c2){
				if(c1.getAverageRating()>c2.getAverageRating())return -1;
				else if(c1.getAverageRating()<c2.getAverageRating())return 1;
				return 0;
			}
		});
		indicator.setText("The list has been sorted by: Rating ▼");
		indicator.setVisible(true);
		return null;
	}
	@FXML public Object select() throws IOException{
		ReviewScene.cw=washes.getSelectionModel().getSelectedItem();
		if(ReviewScene.cw==null)return null;
		Main.swapScene("ReviewScene.fxml");
		return null;
	}
	@FXML public Object back() throws IOException{
		city=null;
		Main.swapScene("StartScene.fxml");
		return null;
	}
	@FXML public Object quit()
	{
		System.exit(0);
		return null;
	}
	@FXML public Object information() throws IOException
	{
		ReviewScene.cw=washes.getSelectionModel().getSelectedItem();
		if(ReviewScene.cw==null)return null;
		Main.swapScene("MoreInformation.fxml");
		return null;
	}
	@FXML public Object createSignIn() throws IOException
	{
		Main.swapToLoginScene();
		SignInScene.saveScene = "CityScene.fxml";
		setSignInText();
		return null;
	}
	@FXML public Object seeCoupon() throws IOException
	{
		Main.swapScene("CouponScene.fxml");
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

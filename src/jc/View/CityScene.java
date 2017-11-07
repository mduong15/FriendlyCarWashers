package jc.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import jc.Model.CarWash;
import jc.Model.Review;

public class CityScene {
	static String city;
	
	@FXML Label title;
	@FXML Label tableLabel;
	@FXML ListView<CarWash> washes;
	@FXML Button priceSort;
	@FXML Button rateSort;
	@FXML Button select;
	@FXML Button back;
	@FXML Button quit;
	private ObservableList<CarWash> washList;
	
	public void initialize() throws FileNotFoundException{
		washList=FXCollections.observableArrayList();
		title.setText("You have chosen: "+city);
		
		Scanner fs=new Scanner(new File("./src/Data/"+city));
		while(fs.hasNextLine()){
			String[] data=fs.nextLine().split(";");
			CarWash toAdd=new CarWash(data[0],  Double.parseDouble(data[1]),  -1.0,  data[2], null);
			data=fs.nextLine().split(";");
			ArrayList<Review> reviews=new ArrayList<>();
			int count=0;double sum=0.;
			while(!data[0].equals("#")){
				int rating=Integer.parseInt(data[1]);
				reviews.add(new Review(data[0],rating, false));
				count++;sum+=rating;
				data=fs.nextLine().split(";");
			}
			toAdd.setAverageRating(sum/count);
			toAdd.setReviews(reviews);
			washList.add(toAdd);
		}
		fs.close();
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
		tableLabel.setText("Name / Price ▲ / Rating / Address");
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
		tableLabel.setText("Name / Price / Rating ▼ / Address");
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
	
}

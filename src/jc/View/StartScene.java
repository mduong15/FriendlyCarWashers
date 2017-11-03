package jc.View;

import java.io.IOException;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class StartScene {
	@FXML Button select;
	@FXML ListView<String> cities;
	
	public void initialize(){
		ObservableList<String> cityList=FXCollections.observableArrayList();
		for(String c:Main.CITIES)cityList.add(c);
		Collections.sort(cityList);
		cities.setItems(cityList);
	}
	
	@FXML Object select() throws IOException{
		CityScene.city=cities.getSelectionModel().getSelectedItem();
		if(CityScene.city==null||CityScene.city.equals(""))return null;
		Main.swapScene("CityScene.fxml");
		return null;
	}
}

package jc.View;

import java.io.IOException;
import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import jc.Model.City;

public class CouponScene {
	public class StartScene {
		
		@FXML ListView<String> coupon;
		@FXML Label createSignIn;
		@FXML Button quit;
		@FXML Button back;
		@FXML Button changeCity;
		@FXML Label title;
		
		public void initialize()
		{
			title.setText("Coupon for "+CityScene.city);
		}
				
		@FXML public Object createSignIn() throws IOException
		{
			Main.swapToLoginScene();
			return null;
		}
		
		@FXML public Object quit()
		{
			System.exit(0);
			return null;
		}
		
		@FXML public Object changeCity() throws IOException
		{
			CityScene.city = null;
			Main.swapScene("StartScene.fxml");
			return null;
		}
		
		@FXML public Object back() throws IOException
		{
			//CityScene.city = null;
			Main.swapScene("CityScene.fxml");
			return null;
		}
	}
}

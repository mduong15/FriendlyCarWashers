package jc.View;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class CouponScene {
	@FXML
	ListView<String> coupon;
	@FXML
	Label createSignIn;
	@FXML
	Button quit;
	@FXML
	Button back;
	@FXML
	Button changeCity;
	@FXML
	Label title;

	// DISPLAY CITY NAME WHEN CHOSEN
	public void initialize() {
		title.setText("Coupon for " + CityScene.city);
	}

	// DIRECT TO THE CREATE ACCOUNT/SIGN IN SCENE
	@FXML
	public Object createSignIn() throws IOException {
		Main.swapToLoginScene();
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
		CityScene.city = null;
		Main.swapScene("StartScene.fxml");
		return null;
	}

	// RETURN TO CHOOSE CAR WASH LOCATION
	@FXML
	public Object back() throws IOException {
		// CityScene.city = null;
		Main.swapScene("CityScene.fxml");
		return null;
	}
}

package jc.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import jc.Model.Account;
import jc.Model.City;

public class SignInScene {
	@FXML
	Button signIn;
	@FXML
	Button createAccount;
	@FXML
	Button cancel;
	@FXML
	TextField signInUsername;
	@FXML
	TextField signInPass;
	@FXML
	TextField createFirst;
	@FXML
	TextField createLast;
	@FXML
	ComboBox<String> cities;
	@FXML
	TextField createUsername;
	@FXML
	TextField createPass;
	@FXML
	Label createWarning;
	@FXML
	Label signInWarning;
	@FXML
	Label userTakenWarn;

	public void initialize() throws FileNotFoundException {
		ObservableList<String> cityList=FXCollections.observableArrayList();
		for(City c: Main.carWashes.cities)cityList.add(c.name);
		Collections.sort(cityList);
		cities.setItems(cityList);
	}

	@FXML
	public Object signIn() throws IOException {
		String checkUser = signInUsername.getText();
		String checkPass = signInPass.getText();
		if (checkUser == null || checkUser.equals("") ||
				checkPass == null || checkPass.equals(""))
		{
			signInWarning.setVisible(true);
			return null;
		}
		
		int i = 0, len = Main.carWashes.accounts.size();
		while (i < len && !Account.signedIn)
		{
			Account a = Main.carWashes.accounts.get(i);
			if (checkUser.equals(a.getUsername()) && 
					checkPass.equals(a.getPassword()))
				Account.signedIn = true;

			i++;
		}
		if (!Account.signedIn)
		{
			signInWarning.setVisible(true);
			return null;
		}
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Logged in!");
		alert.setHeaderText("Welcome back " + checkUser + "!");
		alert.setContentText("Now you have access to account-only features, such as writing reviews " +
				"and saving all of your favorite car washes!");
		alert.show();
		
		/** TODO: Make it go back to the previous scene instead **/
		Main.swapScene("StartScene.fxml");
		return null;
	}
	
	@FXML
	public Object createAccount() throws IOException {
		createWarning.setVisible(false);
		userTakenWarn.setVisible(false);

		String fName = createFirst.getText();
		String lName = createLast.getText();
		String city = cities.getValue();
		String user = createUsername.getText();
		String pass = createPass.getText();
		if (fName == null || fName.equals("") ||
				lName == null || lName.equals("") ||
				city == null || city.equals("") ||
				user == null || user.equals("") ||
				pass == null || pass.equals(""))
		{
			createWarning.setVisible(true);
			return null;
		}
		
		for (Account a : Main.carWashes.accounts)
		{
			if (a.getUsername().equals(fName))
			{
				userTakenWarn.setVisible(true);
				return null;
			}
		}
		
		Account newAcc = new Account(fName, lName, city, user, pass);
		Main.carWashes.accounts.add(newAcc);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Account created!");
		alert.setHeaderText("Account created!");
		alert.setContentText("Now you have access to account-only features, such as writing reviews " +
				"and saving all of your favorite car washes!");
		alert.show();
		
		
		/** TODO: Make it go back to the previous scene instead **/
		Main.swapScene("StartScene.fxml");
		return null;
	}

	@FXML
	public Object cancel() throws IOException {
		/** TODO: Probalby save the last scene and return to it or something **/
		Main.swapScene("StartScene.fxml");
		return null;
	}
}

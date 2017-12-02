package jc.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
	TextField createUsername;
	@FXML
	TextField createPass;

	public void initialize() throws FileNotFoundException {
		/** TODO: fill in list of cities **/
	}

	@FXML
	public Object signIn() throws IOException {
		/** TODO: Check accounts and possibly log in or throw error **/
		return null;
	}
	
	@FXML
	public Object createAccount() throws IOException {
		/** TODO: creates an account and adds it to everything **/
		return null;
	}

	@FXML
	public Object cancel() throws IOException {
		/** TODO: Probalby save the last scene and return to it or something **/
		return null;
	}
}

package jc.View;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	static final ArrayList<String> CITIES;
	static{
		CITIES=new ArrayList<>();
		File[] data=new File("./src/Data").listFiles();
		for(File f:data)CITIES.add(f.getName());
	}
	private static Stage stage;
	private static Class _class;
	public static void main(String[]args){Application.launch();}
	@Override public void start(Stage arg0) throws Exception {
		stage=arg0;
		_class=getClass();
		swapScene("StartScene.fxml");
	}
	public static void swapScene(String fxmlSrc) throws IOException{
		stage.setTitle("Friendly Car Wash");
		stage.setScene(new Scene(FXMLLoader.load(_class.getResource(fxmlSrc))));
		stage.show();
	}
}

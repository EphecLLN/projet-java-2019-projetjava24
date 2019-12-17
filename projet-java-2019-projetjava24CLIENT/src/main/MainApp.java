package main;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application{

	public void start(Stage primaryStage) throws Exception {
		 Parent root = FXMLLoader.load(MainApp.class.getResource("/ressources/fxml/GUI.fxml"));
		 Scene scene = new Scene(root);
		 //scene.getStylesheets().add(getClass().getResource("/ressources/css/Main.css"));
		 primaryStage.setScene(scene);
		 primaryStage.setResizable(false);
		 primaryStage.show();
	}
	
	public static void main(String [] args) throws ClassNotFoundException, IOException {
		launch(args);	
	}
	
	public void init() throws ClassNotFoundException, IOException, InterruptedException {
	}
}

package src;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Joueur;

public class MainStrategoApp extends Application {
	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		Joueur j = new Joueur("PPPanda1014", Color.DARKGOLDENROD);
    	
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Stratego");
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainStrategoApp.class.getResource("Stratego_fxml.fxml"));
            VBox rootLayout = (VBox) loader.load();
            StrategoGUIController vueCtrl = loader.getController();
            vueCtrl.setModel(j);
            
            // Show the scene containing the root layout.
            //GridPane terrain = new GridPane();
            
            //terrain.add(new Label("test"), 0, 0);
            
            //rootLayout.getChildren().add(terrain);
            
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public static void main(String[] args) {
		launch(args);
	}
}

package application;

import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
/* 05/12/2021 - Ofek Yariv */
public class Main extends Application {
	@Override
	public void start(Stage stage) throws Exception,FileNotFoundException {
        Parent root = FXMLLoader.load(getClass().getResource("Q2FXML.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Maman 13 A - Ofek Yariv");
		stage.setScene(scene);
		stage.show(); 
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

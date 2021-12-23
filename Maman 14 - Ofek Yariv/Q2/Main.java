
package application;
/* 23/12/2021 - Ofek Yariv */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Q2FXML.fxml"));
        Scene scene = new Scene(root);
		stage.setTitle("Maman 14 B - Ofek Yariv");
		stage.setScene(scene);
		stage.show(); 
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/* 31/10/2021 - Ofek Yariv */

public class Main extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("PressMe.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Maman 11 A - Ofek Yariv");
		stage.setScene(scene);
		stage.show(); 
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}

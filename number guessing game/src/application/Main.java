package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root=FXMLLoader.load(getClass().getResource("/Main.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image("number_guessing_game_transparent.png"));
			primaryStage.setTitle("Number Guessing Game");
			primaryStage.show();
			primaryStage.setOnCloseRequest(event -> {
				event.consume();
				giveup(primaryStage);
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void giveup(Stage stage) {
		Alert alert=new Alert(AlertType.CONFIRMATION);
		alert.setTitle("GIVE UP!!!");
		alert.setHeaderText("You're about to give up");
		alert.setContentText("Are you sure you want to give up?");
		if(alert.showAndWait().get()==ButtonType.OK) {
			stage.close();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

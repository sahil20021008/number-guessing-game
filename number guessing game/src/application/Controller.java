package application;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Controller implements Initializable {
	int number;
	int guess_no;
	int best_guess;
	
	@FXML
	private AnchorPane anchorpane;
	@FXML
	private Button giveup;
	@FXML
	private Button playagain;
	@FXML
	private Button guess;
	@FXML
	private Label bestscore;
	@FXML
	private Label noguess;
	@FXML
	private TextField numberinput;
	@FXML
	private Label higherlower;
	
	Stage stage;
	@FXML
	private void playagain(ActionEvent e) {
		Random rand=new Random();
		number=rand.nextInt(100)+1;
		guess_no=0;
		noguess.setText(String.valueOf(guess_no));
		higherlower.setText(null);
		guess.setDisable(false);
	}
	@FXML
	private void giveup(ActionEvent e) {
		Alert alert=new Alert(AlertType.CONFIRMATION);
		alert.setTitle("GIVE UP!!!");
		alert.setHeaderText("You're about to give up");
		alert.setContentText("Are you sure you want to give up?");
		if(alert.showAndWait().get()==ButtonType.OK) {
			stage=(Stage)anchorpane.getScene().getWindow();
			stage.close();
		}
	}
	@FXML
	private void guess(ActionEvent e) {
		String s=numberinput.getText();
		int n=Integer.parseInt(s);
		guess_no++;
		noguess.setText(String.valueOf(guess_no));
		if(n<number) {
			higherlower.setText("The Number is higher than "+n);
		}else if (n>number) {
			higherlower.setText("The Number is lower than "+n);
		}else {
			higherlower.setText("Correct! The number is "+n);
			guess.setDisable(true);
			if(best_guess>guess_no) {
				bestscore.setText(String.valueOf(guess_no));
				best_guess=guess_no;
			}
			return;
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Random rand=new Random();
		number=rand.nextInt(100)+1;
		guess_no=0;
		best_guess=Integer.MAX_VALUE;
		bestscore.setMinWidth(20);
		noguess.setMinWidth(20);
		higherlower.setMinWidth(235);
		bestscore.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), new Insets(0))));
		noguess.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), new Insets(0))));
		bestscore.setStyle("-fx-border-color: black;");
		noguess.setStyle("-fx-border-color: black;");
	}
}

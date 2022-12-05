package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginScreen implements Initializable{
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("I've been reborn!");
    }

    public void onLoginAction(ActionEvent actionEvent) {
        Alert dialogue = new Alert(Alert.AlertType.CONFIRMATION,"Sorry, nothing to login to yet...try again later.");
        dialogue.show();
    }
}

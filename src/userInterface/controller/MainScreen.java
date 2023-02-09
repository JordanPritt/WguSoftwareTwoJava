package userInterface.controller;

import data.models.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MainScreen implements Initializable {
//    private final User currentUser;

    @FXML
    Label greetingLabel;

//    public MainScreen(User user) {
//        this.currentUser = user;
//    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        greetingLabel.setText(resourceBundle.getString("greetingText "));
    }
}

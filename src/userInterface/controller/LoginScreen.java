package userInterface.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginScreen implements Initializable {
    @FXML
    Label regionLanguage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // set display for localization
        Locale locale = Locale.getDefault();
        String lang = locale.getDisplayLanguage();
        String country = locale.getDisplayCountry();
        regionLanguage.setText("Country: " + resourceBundle.getString("country")
                + " | Language: " + resourceBundle.getString("language"));
    }

    public void onLoginAction(ActionEvent actionEvent) {
        Alert dialogue = new Alert(Alert.AlertType.CONFIRMATION, "Sorry, nothing to login to yet...try again later.");
        dialogue.show();
    }
}

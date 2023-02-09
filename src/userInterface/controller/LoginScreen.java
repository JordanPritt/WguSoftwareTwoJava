package userInterface.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.UserService;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginScreen implements Initializable {
    private final UserService userService = new UserService();
    private ResourceBundle resourceBundle;

    @FXML
    Label regionLanguage;
    @FXML
    TextField usernameTxtBox;
    @FXML
    TextField passwordTxtBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
        // set display for localization
        regionLanguage.setText("Country: " + resourceBundle.getString("country")
                + " | Language: " + resourceBundle.getString("language"));
    }

    public void onLoginAction(ActionEvent actionEvent) throws IOException {
        boolean isSignedIn = userService.validateUserCredentials(usernameTxtBox.getText(), passwordTxtBox.getText());
        if (isSignedIn) {
            // open next screen
            Parent mainScreen = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/userInterface/view/MainScreen.fxml")));
            Scene scene = new Scene(mainScreen, 800, 600);
            Stage appStage = (Stage) regionLanguage.getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        } else if (usernameTxtBox.getText().trim().equals("") || passwordTxtBox.getText().trim().equals("")) {
            String message = resourceBundle.getString("loginEmptyError");
            Alert dialogue = new Alert(Alert.AlertType.WARNING, message);
            dialogue.show();
        } else {
            String message = resourceBundle.getString("loginError");
            Alert dialogue = new Alert(Alert.AlertType.WARNING, message);
            dialogue.show();
        }
    }
}

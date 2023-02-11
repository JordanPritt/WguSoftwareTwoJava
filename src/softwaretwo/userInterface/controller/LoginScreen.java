package softwaretwo.userInterface.controller;

import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import softwaretwo.services.UserService;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Login screens controller
 */
public class LoginScreen implements Initializable {
    private final UserService userService = new UserService();
    private ResourceBundle resourceBundle;

    @FXML
    Button loginBtn;
    @FXML
    Label regionLanguage;
    @FXML
    TextField usernameTxtBox;
    @FXML
    PasswordField passwordTxtBox;

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
            ResourceBundle bundle = ResourceBundle.getBundle("softwaretwo/resources/translations", Locale.getDefault());
            FXMLLoader loader = new FXMLLoader();
            loader.setResources(bundle);
            loader.setLocation(getClass().getResource("/softwaretwo/userInterface/view/MainScreen.fxml"));
            Stage appStage = (Stage) regionLanguage.getScene().getWindow();
            Parent root = loader.load();
            appStage.setTitle(resourceBundle.getString("main"));
            appStage.setScene(new Scene(root,800, 600));
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

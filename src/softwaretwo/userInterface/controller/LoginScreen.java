package softwaretwo.userInterface.controller;

import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import softwaretwo.data.models.User;
import softwaretwo.services.UserService;
import softwaretwo.utilities.LoginLogModel;
import softwaretwo.utilities.LoginLogger;

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
    private int attemptCounter = 1;

    @FXML
    Button loginBtn;
    @FXML
    Label regionLanguage;
    @FXML
    TextField usernameTxtBox;
    @FXML
    PasswordField passwordTxtBox;

    /**
     * Default empty constructor.
     */
    public LoginScreen() {
    }

    /**
     * Default JavaFX Controller initializer.
     *
     * @param url            path to view.
     * @param resourceBundle provided resource bundle.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
        // set display for localization
        regionLanguage.setText("Country: " + resourceBundle.getString("country")
                + " | Language: " + resourceBundle.getString("language"));
    }

    /**
     * Performs login actions.
     *
     * @param actionEvent the event used for login.
     * @throws IOException any exception that could occur.
     */
    public void onLoginAction(ActionEvent actionEvent) throws IOException {
        User signedInUser = userService.validateUserCredentials(usernameTxtBox.getText(), passwordTxtBox.getText());

        if (signedInUser != null) {
            // track login activity
            trackLoginAttempt(true, attemptCounter, "Credentials were valid.");

            // open next screen
            ResourceBundle bundle = ResourceBundle.getBundle("softwaretwo/resources/translations", Locale.getDefault());
            FXMLLoader loader = new FXMLLoader();
            loader.setResources(bundle);
            loader.setLocation(getClass().getResource("/softwaretwo/userInterface/view/MainScreen.fxml"));
            Stage appStage = (Stage) regionLanguage.getScene().getWindow();
            Parent root = loader.load();
            MainScreen controller = loader.getController();
            controller.setUser(signedInUser);
            appStage.setTitle(resourceBundle.getString("main"));
            appStage.setScene(new Scene(root, 800, 600));
            appStage.setResizable(false);
            appStage.show();
        } else if (usernameTxtBox.getText().trim().equals("") || passwordTxtBox.getText().trim().equals("")) {
            // track login activity
            trackLoginAttempt(false, attemptCounter, "One or both credentials were empty.");
            attemptCounter++;

            String message = resourceBundle.getString("loginEmptyError");
            Alert dialogue = new Alert(Alert.AlertType.WARNING, message);
            dialogue.show();
        } else {
            // track login activity
            trackLoginAttempt(false, attemptCounter, "Invalid login credentials.");
            attemptCounter++;

            String message = resourceBundle.getString("loginError");
            Alert dialogue = new Alert(Alert.AlertType.WARNING, message);
            dialogue.show();
        }
    }

    private void trackLoginAttempt(boolean isSuccess, int attempt, String message) {
        LoginLogModel model = new LoginLogModel(usernameTxtBox.getText(), attempt, LoginLogger.getTimeStamp(), isSuccess, message);
        LoginLogger.LogUserActivity(model);
    }
}

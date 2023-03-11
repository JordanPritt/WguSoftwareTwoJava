package softwaretwo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import softwaretwo.data.models.Appointment;
import softwaretwo.data.models.Customer;
import softwaretwo.data.repositories.*;
import softwaretwo.services.AppointmentService;
import softwaretwo.services.CustomerService;
import softwaretwo.services.ICrudService;
import softwaretwo.services.UserService;
import softwaretwo.userInterface.controller.LoginScreen;
import softwaretwo.userInterface.controller.MainScreen;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * A GUI application for managing scheduling.
 */
public class SchedulerApplication extends Application {
    /**
     * JavaFX start point.
     *
     * @param primaryStage primary stage.
     * @throws Exception an exception.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Locale current = Locale.getDefault();
        ResourceBundle bundle = ResourceBundle.getBundle("softwaretwo/resources/translations", current);

        FXMLLoader loader = new FXMLLoader();
        loader.setResources(bundle);
        loader.setLocation(getClass().getResource("/softwaretwo/userInterface/view/LoginScreen.fxml"));

        // open first/default window of application
        Parent root = loader.load();
        primaryStage.setTitle(bundle.getString("main"));
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    /**
     * The main entry to the application.
     *
     * @param args string arguments list.
     */
    public static void main(String[] args) {
        // launch JavaFX
        launch();
    }
}

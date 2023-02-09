package softwaretwo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import softwaretwo.tests.TestRunner;

import java.util.Locale;
import java.util.ResourceBundle;

public class SchedulerApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Locale current = Locale.getDefault();
        // test locations for translation checking
        Locale french = new Locale.Builder().setLanguage("fr").setRegion("FR").build();
        Locale uk = new Locale.Builder().setLanguage("en").setRegion("GB").build();
        ResourceBundle bundle = ResourceBundle.getBundle("softwaretwo/resources/translations", uk);

        FXMLLoader loader = new FXMLLoader();
        loader.setResources(bundle);
        loader.setLocation(getClass().getResource("/softwaretwo/userInterface/view/LoginScreen.fxml"));

        // open first/default window of application
        Parent root = loader.load();
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root,800, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        // run softwaretwo.tests
        TestRunner.RunTests();
        // launch JavaFX
        launch();
    }
}

import data.access.ClientScheduleContext;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // open first/default window of application
        Parent root = FXMLLoader.load(getClass().getResource("/userInterface/view/LoginScreen.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root,800, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
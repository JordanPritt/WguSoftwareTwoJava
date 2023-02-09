package softwaretwo.userInterface.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainScreen implements Initializable {
    @FXML
    Label greetingLabel;
    @FXML
    Tab customersTab;
    @FXML
    Tab schedulingTab;
    @FXML
    Tab reportsTab;
    @FXML
    TableView upcomingAppointmentsTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        greetingLabel.setText(resourceBundle.getString("greetingText"));
    }
}

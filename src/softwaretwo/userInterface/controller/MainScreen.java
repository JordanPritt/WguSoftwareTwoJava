package softwaretwo.userInterface.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import softwaretwo.data.models.Appointment;
import softwaretwo.services.AppointmentService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainScreen implements Initializable {
    private final AppointmentService appointmentService = new AppointmentService();
    private ResourceBundle resourceBundle;
    private List<Appointment> appointments = appointmentService.getAllAppointments();
    ;

    @FXML
    Label greetingLabel;

    @FXML
    Tab customersTab;
    @FXML
    Tab schedulingTab;
    @FXML
    Tab reportsTab;

    @FXML
    Button addCustomerBtn;
    @FXML
    Button editCustomerBtn;
    @FXML
    Button deleteCustomerBtn;
    @FXML
    Button addAppointmentBtn;
    @FXML
    Button editAppointmentBtn;
    @FXML
    Button deleteAppointmentBtn;

    @FXML
    TableView upcomingAppointmentsTable;
    @FXML
    TableView customerTable;
    @FXML
    TableView appointmentTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
        // setup upcoming appointment table
        greetingLabel.setText(resourceBundle.getString("greetingText"));
        // setup tables
        populateCustomerTable();
        populateAppointmentTable();
        populateUpcomingAppointmentTable();
    }

    private void populateCustomerTable() {
    }

    private void rePopulateTableData() {
        appointments = appointmentService.getAllAppointments();
    }

    private void populateUpcomingAppointmentTable() {
        TableColumn<Appointment, String> titleColumn =
                new TableColumn<>(resourceBundle.getString("appointmentTableHeaderTitle"));
        titleColumn.setPrefWidth(100);
        titleColumn.setCellValueFactory(
                p -> new SimpleStringProperty(p.getValue().getTitle())
        );

        TableColumn<Appointment, String> locationColumn =
                new TableColumn<>(resourceBundle.getString("appointmentTableHeaderLocation"));
        locationColumn.setPrefWidth(100);
        locationColumn.setCellValueFactory(/**/
                p -> new SimpleStringProperty(p.getValue().getLocation())
        );

        TableColumn<Appointment, String> startColumn =
                new TableColumn<>(resourceBundle.getString("appointmentTableHeaderStart"));
        startColumn.setPrefWidth(125);
        startColumn.setCellValueFactory(
                p -> new SimpleStringProperty(p.getValue().getStart().toString())
        );

        TableColumn<Appointment, String> endColumn =
                new TableColumn<>(resourceBundle.getString("appointmentTableHeaderEnd"));
        endColumn.setPrefWidth(125);
        endColumn.setCellValueFactory(
                p -> new SimpleStringProperty(p.getValue().getEnd().toString())
        );

        upcomingAppointmentsTable.getColumns().addAll(titleColumn, locationColumn, startColumn, endColumn);
        upcomingAppointmentsTable.getItems().addAll(appointments);
    }

    private void populateAppointmentTable() {
        TableColumn<Appointment, String> titleColumn =
                new TableColumn<>(resourceBundle.getString("appointmentTableHeaderTitle"));
        //titleColumn.setPrefWidth(100);
        titleColumn.setCellValueFactory(
                p -> new SimpleStringProperty(p.getValue().getTitle())
        );

        TableColumn<Appointment, String> descriptionColumn =
                new TableColumn<>(resourceBundle.getString("appointmentTableHeaderDescription"));
        //descriptionColumn.setPrefWidth(150);
        descriptionColumn.setCellValueFactory(
                p -> new SimpleStringProperty(p.getValue().getDescription())
        );

        TableColumn<Appointment, String> locationColumn =
                new TableColumn<>(resourceBundle.getString("appointmentTableHeaderLocation"));
        //locationColumn.setPrefWidth(100);
        locationColumn.setCellValueFactory(
                p -> new SimpleStringProperty(p.getValue().getLocation())
        );

        TableColumn<Appointment, String> typeColumn =
                new TableColumn<>(resourceBundle.getString("appointmentTableHeaderType"));
        //typeColumn.setPrefWidth(100);
        typeColumn.setCellValueFactory(
                p -> new SimpleStringProperty(p.getValue().getType())
        );

        TableColumn<Appointment, String> startColumn =
                new TableColumn<>(resourceBundle.getString("appointmentTableHeaderStart"));
        startColumn.setPrefWidth(100);
        startColumn.setCellValueFactory(
                p -> new SimpleStringProperty(p.getValue().getStart().toString())
        );

        TableColumn<Appointment, String> endColumn =
                new TableColumn<>(resourceBundle.getString("appointmentTableHeaderEnd"));
        endColumn.setPrefWidth(100);
        endColumn.setCellValueFactory(
                p -> new SimpleStringProperty(p.getValue().getEnd().toString())
        );

        appointmentTable.getColumns().addAll(titleColumn, descriptionColumn, locationColumn, typeColumn, startColumn, endColumn);
        appointmentTable.getItems().addAll(appointments);
    }
}

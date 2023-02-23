package softwaretwo.userInterface.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import softwaretwo.data.models.Appointment;
import softwaretwo.data.models.Customer;
import softwaretwo.services.AppointmentService;
import softwaretwo.services.CustomerService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Main screen controller.
 */
public class MainScreen implements Initializable {
    // instantiate services
    private final AppointmentService appointmentService = new AppointmentService();
    private final CustomerService customerService = new CustomerService();

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

    /**
     * Default JavaFX Controller initializer.
     *
     * @param url            path to view.
     * @param resourceBundle provided resource bundle.
     */
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

        // setup appointments table
        appointmentTable.getColumns().addAll(titleColumn, descriptionColumn, locationColumn, typeColumn, startColumn, endColumn);
        appointmentTable.getItems().addAll(appointments);
    }

    private void populateCustomerTable() {
        TableColumn<Customer, String> idColumn =
                new TableColumn<>(resourceBundle.getString("appointmentTableHeaderTitle"));
        idColumn.setCellValueFactory(
                p -> new SimpleStringProperty(Integer.toString(p.getValue().getCustomerId()))
        );

        TableColumn<Customer, String> nameColumn =
                new TableColumn<>(resourceBundle.getString("appointmentTableHeaderTitle"));
        nameColumn.setCellValueFactory(
                p -> new SimpleStringProperty(p.getValue().getCustomerName())
        );

        TableColumn<Customer, String> addressColumn =
                new TableColumn<>(resourceBundle.getString("appointmentTableHeaderTitle"));
        nameColumn.setCellValueFactory(
                p -> new SimpleStringProperty(p.getValue().getAddress())
        );

        TableColumn<Customer, String> postalCodeColumn =
                new TableColumn<>(resourceBundle.getString("appointmentTableHeaderTitle"));
        nameColumn.setCellValueFactory(
                p -> new SimpleStringProperty(p.getValue().getPostalCode())
        );

        TableColumn<Customer, String> phoneColumn =
                new TableColumn<>(resourceBundle.getString("appointmentTableHeaderTitle"));
        nameColumn.setCellValueFactory(
                p -> new SimpleStringProperty(p.getValue().getPhone())
        );

        TableColumn<Customer, String> createDateColumn =
                new TableColumn<>(resourceBundle.getString("appointmentTableHeaderTitle"));
        nameColumn.setCellValueFactory(
                p -> new SimpleStringProperty(p.getValue().getCreatedDate().toString())
        );

        TableColumn<Customer, String> createByColumn =
                new TableColumn<>(resourceBundle.getString("appointmentTableHeaderTitle"));
        nameColumn.setCellValueFactory(
                p -> new SimpleStringProperty(p.getValue().getCreatedBy())
        );

        TableColumn<Customer, String> lastUpdateColumn =
                new TableColumn<>(resourceBundle.getString("appointmentTableHeaderTitle"));
        nameColumn.setCellValueFactory(
                p -> new SimpleStringProperty(p.getValue().getLastUpdate().toString())
        );

        TableColumn<Customer, String> lastUpdatedByColumn =
                new TableColumn<>(resourceBundle.getString("appointmentTableHeaderTitle"));
        nameColumn.setCellValueFactory(
                p -> new SimpleStringProperty(p.getValue().getLastUpdatedBy())
        );

        TableColumn<Customer, String> divisionIdColumn =
                new TableColumn<>(resourceBundle.getString("appointmentTableHeaderTitle"));
        nameColumn.setCellValueFactory(
                p -> new SimpleStringProperty(Integer.toString(p.getValue().getDivisionId()))
        );

        // setup customer table
        List<Customer> customers = customerService.getCustomers();
        customerTable.getColumns().addAll(idColumn, nameColumn, addressColumn, postalCodeColumn, phoneColumn, createDateColumn, createByColumn, lastUpdateColumn, lastUpdatedByColumn, divisionIdColumn);
        customerTable.getItems().addAll(customers);
    }
}

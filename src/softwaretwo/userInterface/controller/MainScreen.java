package softwaretwo.userInterface.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import softwaretwo.data.models.Appointment;
import softwaretwo.data.models.Customer;
import softwaretwo.data.models.User;
import softwaretwo.services.AppointmentService;
import softwaretwo.services.CustomerService;

import java.io.IOException;
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
    private User user;

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
                new TableColumn<>(resourceBundle.getString("customerTableIdColumn"));
        idColumn.setCellValueFactory(
                p -> new SimpleStringProperty(Integer.toString(p.getValue().getCustomerId()))
        );

        TableColumn<Customer, String> customerNameColumn =
                new TableColumn<>(resourceBundle.getString("customerTableNameColumn"));
        customerNameColumn.setCellValueFactory(
                p -> new SimpleStringProperty(p.getValue().getCustomerName())
        );

        TableColumn<Customer, String> addressColumn =
                new TableColumn<>(resourceBundle.getString("customerTableAddressColumn"));
        addressColumn.setCellValueFactory(
                p -> new SimpleStringProperty(p.getValue().getAddress())
        );

        TableColumn<Customer, String> postalCodeColumn =
                new TableColumn<>(resourceBundle.getString("customerTablePostalCodeColumn"));
        postalCodeColumn.setCellValueFactory(
                p -> new SimpleStringProperty(p.getValue().getPostalCode())
        );

        TableColumn<Customer, String> phoneColumn =
                new TableColumn<>(resourceBundle.getString("customerTablePhoneColumn"));
        phoneColumn.setCellValueFactory(
                p -> new SimpleStringProperty(p.getValue().getPhone())
        );

        TableColumn<Customer, String> createDateColumn =
                new TableColumn<>(resourceBundle.getString("customerTableCreatedDateColumn"));
        createDateColumn.setCellValueFactory(
                p -> new SimpleStringProperty(p.getValue().getCreatedDate().toString())
        );

        TableColumn<Customer, String> createByColumn =
                new TableColumn<>(resourceBundle.getString("customerTableCreatedByColumn"));
        createByColumn.setCellValueFactory(
                p -> new SimpleStringProperty(p.getValue().getCreatedBy())
        );

        TableColumn<Customer, String> lastUpdateColumn =
                new TableColumn<>(resourceBundle.getString("customerTableLastUpdateColumn"));
        lastUpdateColumn.setCellValueFactory(
                p -> {
                    String date = p.getValue().getLastUpdate() != null ?
                            p.getValue().getLastUpdate().toString() : "N/A";
                    return new SimpleStringProperty(date);
                }
        );

        TableColumn<Customer, String> lastUpdatedByColumn =
                new TableColumn<>(resourceBundle.getString("customerTableLastUpdatedByColumn"));
        lastUpdatedByColumn.setCellValueFactory(
                p -> new SimpleStringProperty(p.getValue().getLastUpdatedBy())
        );

        TableColumn<Customer, String> divisionIdColumn =
                new TableColumn<>(resourceBundle.getString("customerTableDivisionIdColumn"));
        divisionIdColumn.setCellValueFactory(
                p -> new SimpleStringProperty(Integer.toString(p.getValue().getDivisionId()))
        );

        // setup customer table
        List<Customer> customers = customerService.getCustomers();
        customerTable.getColumns().addAll(idColumn, customerNameColumn, addressColumn, postalCodeColumn, phoneColumn, createDateColumn, createByColumn, lastUpdateColumn, lastUpdatedByColumn, divisionIdColumn);
        customerTable.getItems().addAll(customers);
    }

    /**
     * Handler for Add button.
     */
    public void handleAddCustomer() {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setResources(resourceBundle);
            loader.setLocation(getClass().getResource("/softwaretwo/userInterface/view/AddOrEditCustomerScreen.fxml"));
            Parent scene = loader.load();
            AddOrEditCustomerScreen controller = loader.getController();
            controller.setUser(user);
            stage.setTitle("Add Customer");
            stage.setScene(new Scene(scene));
            stage.setResizable(false);
            stage.setOnCloseRequest(event -> {
                // we want to reload the table in case a customer was added.
                rePopulateTableData();
            });
            stage.show();
        } catch (IOException ex) {
            System.out.println("Couldn't load customer add scene because: " + ex.getMessage());
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        if (user != null) {
            final String welcomeMessage = resourceBundle
                    .getString("greetingText")
                    .replace("user", user.getUserName());
            greetingLabel.setText(welcomeMessage);
        }
    }
}

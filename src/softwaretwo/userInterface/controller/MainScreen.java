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
    private final CustomerService customerService = new CustomerService();
    private final AppointmentService appointmentService = new AppointmentService();
    private List<Appointment> appointments;

    private ResourceBundle resourceBundle;
    private User user;

    //region FXML variables

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

    //endregion

    /**
     * Default JavaFX Controller initializer.
     *
     * @param url            path to view.
     * @param resourceBundle provided resource bundle.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.appointments = appointmentService.getAll();
        } catch (Exception ex) {
            System.out.println("Could not load appointments: " + ex.getMessage());
        }

        this.resourceBundle = resourceBundle;
        // setup upcoming appointment table
        greetingLabel.setText(resourceBundle.getString("greetingText"));
        // setup tables
        populateCustomerTable();
        populateAppointmentTable();
        populateUpcomingAppointmentTable();
    }

    //region table refresh methods
    private void refreshCustomerTableData() {
        customerTable.getItems().clear();
        customerTable.getColumns().clear();
        populateCustomerTable();
    }

    private void refreshAppointmentTableData() {
        appointmentTable.getItems().clear();
        appointmentTable.getColumns().clear();
        populateCustomerTable();
    }

    private void refreshUpcomingAppointmentTableData() {
        upcomingAppointmentsTable.getItems().clear();
        upcomingAppointmentsTable.getColumns().clear();
        populateCustomerTable();
    }

    //endregion

    //region Populate Tables

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
                p -> new SimpleStringProperty(p.getValue().getLastUpdate().toString())
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
        List<Customer> customers = customerService.getAll();
        customerTable
                .getColumns()
                .addAll(
                        idColumn,
                        customerNameColumn,
                        addressColumn,
                        postalCodeColumn,
                        phoneColumn,
                        createDateColumn,
                        createByColumn,
                        lastUpdateColumn,
                        lastUpdatedByColumn,
                        divisionIdColumn);
        customerTable.getItems().addAll(customers);
    }

    //endregion

    //region Appointment button handlers

    /**
     * Handler for Add Appointment button.
     */
    public void handleAddAppointment() {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setResources(resourceBundle);
            loader.setLocation(getClass().getResource("/softwaretwo/userInterface/view/AddOrEditAppointmentScreen.fxml"));
            loader.setControllerFactory(controller -> new AddOrEditAppointmentScreen(user));
            Parent scene = loader.load();
            AddOrEditAppointmentScreen controller = loader.getController();
            stage.setTitle(resourceBundle.getString("appointmentAddLabel"));
            stage.setScene(new Scene(scene));
            stage.setResizable(false);
            stage.setOnHiding(event -> refreshCustomerTableData());
            stage.show();
        } catch (IOException ex) {
            System.out.println(resourceBundle.getString("appointmentAddError") + " reason: " + ex.getMessage());
        }
    }

    /**
     * Handler for Update Appointment button.
     */
    public void handleEditAppointment() {
    }

    /**
     * Handler for Delete Appointment button.
     */
    public void handleDeleteAppointment() {
    }

    //endregion

    //region Customer button handlers

    /**
     * Handler for Add Customer button.
     */
    public void handleAddCustomer() {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setResources(resourceBundle);
            loader.setLocation(getClass().getResource("/softwaretwo/userInterface/view/AddOrEditCustomerScreen.fxml"));
            loader.setControllerFactory(controller -> new AddOrEditCustomerScreen(user));
            Parent scene = loader.load();
            AddOrEditCustomerScreen controller = loader.getController();
            controller.setUser(user);
            stage.setTitle("Add Customer");
            stage.setScene(new Scene(scene));
            stage.setResizable(false);
            stage.setOnHiding(event -> refreshCustomerTableData());
            stage.show();
        } catch (IOException ex) {
            System.out.println("Couldn't load customer add scene because: " + ex.getMessage());
        }
    }

    /**
     * Handles the customer update button.
     */
    public void handleUpdateCustomer() {
        String message = "";
        try {
            Customer customer = (Customer) customerTable.getSelectionModel().getSelectedItem();
            if (customer == null) {
                message = resourceBundle.getString("selectCustomerMessage");
                return;
            }
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setResources(resourceBundle);
            loader.setLocation(getClass().getResource("/softwaretwo/userInterface/view/AddOrEditCustomerScreen.fxml"));
            loader.setControllerFactory(controlerClass -> new AddOrEditCustomerScreen(user, customer, true));
            Parent scene = loader.load();
            stage.setTitle("Edit Customer");
            stage.setScene(new Scene(scene));
            stage.setResizable(false);
            stage.setOnHiding(event -> refreshCustomerTableData());
            stage.show();
        } catch (Exception ex) {
            message = resourceBundle.getString("updateCustomerFailText") + " Reason: " + ex.getMessage();
            System.out.println(message);
        } finally {
            if (message.equals(resourceBundle.getString("selectCustomerMessage"))) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText(message);
                alert.show();
            }
        }
    }

    /**
     * Handles the customer delete button.
     */
    public void handleDeleteCustomer() {
        String message = "";
        try {
            Customer customer = (Customer) customerTable.getSelectionModel().getSelectedItem();
            if (customer == null) {
                message = resourceBundle.getString("selectCustomerMessage");
                return;
            }

            // confirm delete
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Delete: " + customer.getCustomerName() + " ?",
                    ButtonType.YES,
                    ButtonType.CANCEL);
            alert.setContentText(resourceBundle.getString("deleteCustomerText"));
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                customerService.delete(customer);
                message = resourceBundle.getString("deleteCustomerSuccessText");
                refreshCustomerTableData();
            }
        } catch (Exception ex) {
            message = resourceBundle.getString("deleteCustomerFailText") + " Reason: " + ex.getMessage();
            System.out.println(message);
        } finally {
            if (message.equals(resourceBundle.getString("selectCustomerMessage"))) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText(message);
                alert.show();
            }
        }
    }

    //endregion

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

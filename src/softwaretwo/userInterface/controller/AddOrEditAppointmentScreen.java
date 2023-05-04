package softwaretwo.userInterface.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;
import softwaretwo.data.models.Appointment;
import softwaretwo.data.models.Contact;
import softwaretwo.data.models.Customer;
import softwaretwo.data.models.User;
import softwaretwo.services.AppointmentService;
import softwaretwo.services.ContactService;
import softwaretwo.services.CustomerService;

import java.net.URL;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class AddOrEditAppointmentScreen implements Initializable {
    private final AppointmentService appointmentService = new AppointmentService();
    //private final ContactService contactService = new ContactService();
    private ResourceBundle resourceBundle;
    private final User user;
    private boolean isEdit = false;
    private Appointment oldAppointment;

    //region FXML variables

    @FXML
    Label screenLabel;

    @FXML
    TextField titleTxt;

    @FXML
    TextField locationTxt;

    @FXML
    TextField typeTxt;

    @FXML
    TextField startDateTxt;

    @FXML
    TextField endDateTxt;

    @FXML
    TextField customerIdTxt;

    @FXML
    TextField contactIdTxt;

    @FXML
    TextArea descriptionTxtArea;

    @FXML
    ComboBox<Contact> contactComboBox = new ComboBox<>();

    @FXML
    ComboBox<Customer> customerComboBox = new ComboBox<>();

    //endregion

    public AddOrEditAppointmentScreen(User user) {
        this.user = user;
    }

    public AddOrEditAppointmentScreen(User user, Appointment appointment) {
        this.user = user;
        this.oldAppointment = appointment;
        this.isEdit = true;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
        if (isEdit)
            screenLabel.setText(resourceBundle.getString("appointmentEditLabel"));
        else
            screenLabel.setText(resourceBundle.getString("appointmentAddLabel"));

        // populate contacts dropdown.
        Callback<ListView<Contact>, ListCell<Contact>> contactFactory = lv -> new ListCell<>() {
            @Override
            protected void updateItem(Contact item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getContactName());
            }
        };

        contactComboBox.setCellFactory(contactFactory);
        contactComboBox.setButtonCell(contactFactory.call(null));
        contactComboBox.setItems(FXCollections.observableList(ContactService.get()));

        // populate customer dropdown.
        Callback<ListView<Customer>, ListCell<Customer>> customerFactory = lv -> new ListCell<>() {
            @Override
            protected void updateItem(Customer item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getCustomerName());
            }
        };

        customerComboBox.setCellFactory(customerFactory);
        customerComboBox.setButtonCell(customerFactory.call(null));
        customerComboBox.setItems(FXCollections.observableList(new CustomerService().getAll()));
    }

    //region Button Handlers

    public void handleSave() {
        String saveAppointmentMessage = resourceBundle.getString("saveAppointmentEmptyMessage");
        try {
            boolean selectionsAreValid = validateAppointmentSelections();
            if (selectionsAreValid) {
                Appointment newAppointment = getAppointmentSelections();
                appointmentService.create(newAppointment);
                this.screenLabel.getScene().getWindow().hide();
                saveAppointmentMessage = resourceBundle.getString("saveAppointmentSuccessMessage");
            }
        } catch (Exception ex) {
            System.out.println("Could not save appointment: " + ex.getMessage());
            saveAppointmentMessage = resourceBundle.getString("saveAppointmentFailMessage");
        } finally {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(saveAppointmentMessage);
            alert.show();
        }
    }

    public void handleReset() {

    }

    public void handleCancel() {
        screenLabel.getScene().getWindow().hide();
    }

    //endregion

    private Appointment getAppointmentSelections() {
        ZonedDateTime nowUtc = ZonedDateTime.now().with(ZoneOffset.UTC);
        return new Appointment(
                0,
                titleTxt.getText(),
                descriptionTxtArea.getText(),
                locationTxt.getText(),
                typeTxt.getText(),
                convertDateString(startDateTxt.getText()),
                convertDateString(endDateTxt.getText()),
                nowUtc,
                this.user.getUserName(),
                nowUtc,
                this.user.getUserName(),
                customerComboBox.getValue().getCustomerId(),
                this.user.getUserId(),
                contactComboBox.getValue().getContactId()
        );
    }

    private boolean validateAppointmentSelections() {
        boolean isValid = !titleTxt.getText().equals("");

        if (locationTxt.getText().equals(""))
            isValid = false;
        if (typeTxt.getText().equals(""))
            isValid = false;
        if (descriptionTxtArea.getText().equals(""))
            isValid = false;
        if (startDateTxt.getText().equals(""))
            isValid = false;
        if (endDateTxt.getText().equals(""))
            isValid = false;

        // validate date times for start/end
        LocalDateTime startDate =
                LocalDateTime.parse(startDateTxt.getText(), DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss a"));
        LocalDateTime endDate =
                LocalDateTime.parse(endDateTxt.getText(), DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss a"));

        if (startDate == null || endDate == null)
            isValid = false;

        if (customerComboBox.getValue() == null || contactComboBox.getValue() == null)
            isValid = false;

        return isValid;
    }

    private ZonedDateTime convertDateString(String dateString) {
        try {
            DateTimeFormatter dateTimeFormatter =
                    DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss a").withZone(ZoneOffset.UTC);
            return ZonedDateTime.parse(dateString, dateTimeFormatter);
        } catch (Exception ex) {
            System.out.println("Could not convert to ZoneDateTime because:" + ex.getMessage());
            return null;
        }
    }
}

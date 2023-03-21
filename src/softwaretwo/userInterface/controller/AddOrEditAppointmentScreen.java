package softwaretwo.userInterface.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import softwaretwo.data.models.Appointment;
import softwaretwo.data.models.User;
import softwaretwo.services.AppointmentService;

import java.net.URL;
import java.time.Clock;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class AddOrEditAppointmentScreen implements Initializable {
    private final AppointmentService appointmentService = new AppointmentService();
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
        Appointment newAppointment = new Appointment();
        newAppointment.setContactId(Integer.parseInt(contactIdTxt.getText()));
        newAppointment.setCreateDate(ZonedDateTime.now(Clock.systemUTC()));
        return newAppointment;
    }

    private boolean validateAppointmentSelections() {
        boolean isValid = !titleTxt.getText().equals("");

        if (locationTxt.getText().equals(""))
            isValid = false;
        if (typeTxt.getText().equals(""))
            isValid = false;
        if (customerIdTxt.getText().equals(""))
            isValid = false;
        if (contactIdTxt.getText().equals(""))
            isValid = false;
        if (descriptionTxtArea.getText().equals(""))
            isValid = false;
        if (startDateTxt.getText().equals(""))
            isValid = false;
        if (endDateTxt.getText().equals(""))
            isValid = false;

        // validate date times for start/end
        ZonedDateTime startDate = convertDateString(startDateTxt.getText());
        ZonedDateTime endDate = convertDateString(endDateTxt.getText());

        if (startDate == null)
            isValid = false;
        if (endDate == null)
            isValid = false;

        return isValid;
    }

    private ZonedDateTime convertDateString(String dateString) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneOffset.UTC);
            return ZonedDateTime.parse(dateString, dateTimeFormatter);
        } catch (Exception ex) {
            System.out.println("Could not convert to ZoneDateTime because:" + ex.getMessage());
            return null;
        }
    }
}

package softwaretwo.userInterface.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import softwaretwo.data.models.Appointment;
import softwaretwo.data.models.User;
import softwaretwo.services.AppointmentService;

import java.net.URL;
import java.util.ResourceBundle;

public class AddOrEditAppointmentScreen implements Initializable {
    private final AppointmentService appointmentService = new AppointmentService();
    private ResourceBundle resourceBundle;
    private final User user;
    private boolean isEdit = false;
    private Appointment oldAppointment;
    private Appointment newAppointment;

    //region FXML variables

    @FXML
    Label screenLabel;

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

    public void handleSave() {
        screenLabel.getScene().getWindow().hide();
    }

    public void handleReset() {

    }

    public void handleCancel() {
        screenLabel.getScene().getWindow().hide();
    }

}

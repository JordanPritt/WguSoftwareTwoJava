package softwaretwo.userInterface.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import softwaretwo.data.models.Customer;
import softwaretwo.data.models.User;

import java.net.URL;
import java.util.ResourceBundle;

public class AddOrEditCustomerScreen implements Initializable {
    private ResourceBundle resourceBundle;
    private Customer customer;
    private User user;

    @FXML
    TextField nameTxt;

    /**
     * Default Initializer method for controller.
     *
     * @param url            url to view.
     * @param resourceBundle provided resource bundle.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    /**
     * Handler for save button.
     */
    public void handleSave() {
        // close the stage
        nameTxt.getScene().getWindow().hide();
    }

    /**
     * Handler for cancel button.
     */
    public void handleCancel() {
        // close the stage
        nameTxt.getScene().getWindow().hide();
    }

    /**
     * Handler for save button.
     */
    public void handleReset() {
        // close the stage
        nameTxt.setText("");
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

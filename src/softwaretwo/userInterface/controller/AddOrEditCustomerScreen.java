package softwaretwo.userInterface.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import softwaretwo.data.models.Country;
import softwaretwo.data.models.Customer;
import softwaretwo.data.models.FirstLevelDomain;
import softwaretwo.data.models.User;
import softwaretwo.data.repositories.*;
import softwaretwo.services.CustomerService;

import java.io.InvalidObjectException;
import java.net.URL;
import java.time.Clock;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.ResourceBundle;

public class AddOrEditCustomerScreen implements Initializable {
    private final CustomerService customerService = new CustomerService();
    private final FirstLevelDomainRepository domainRepo = new FirstLevelDomainRepository();
    private final CountriesRepository countryRepo = new CountriesRepository();

    private boolean isEdit = false;
    private ResourceBundle resourceBundle;
    private Customer customer;
    private User user;
    private List<String> states;
    private List<String> canadianProvinces;
    private List<String> ukProvinces;
    private List<String> countries;
    private List<FirstLevelDomain> domains;

    @FXML
    TextField nameTxt;
    @FXML
    TextField phoneTxt;
    @FXML
    TextField postalCodeTxt;
    @FXML
    TextField customerIdTxt;
    @FXML
    TextField addressTxt;

    @FXML
    Label customerIdLabel;
    @FXML
    Label customerScreenLabel;

    @FXML
    ComboBox<String> countryComboBox;
    @FXML
    ComboBox<String> stateOrProvinceComboBox;

    /**
     * Default constructor for Add.
     *
     * @param user
     */
    public AddOrEditCustomerScreen(User user) {
        this.user = user;
        this.customer = null;
        this.isEdit = false;
    }

    /**
     * Default constructor for Edit.
     *
     * @param user     the signed-in user object.
     * @param customer the customer to edit.
     * @param isEdit   idicator to edit or create.
     */
    public AddOrEditCustomerScreen(User user, Customer customer, boolean isEdit) {
        this.user = user;
        this.customer = customer;
        this.isEdit = isEdit;
    }

    /**
     * Default Initializer method for controller.
     *
     * @param url            url to view.
     * @param resourceBundle provided resource bundle.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.domains = domainRepo.getAll();
        this.resourceBundle = resourceBundle;
        this.countries = countryRepo
                .getAllCountries()
                .stream()
                .map(Country::getCountry)
                .toList();
        this.states = domains
                .stream()
                .filter(i -> i.getCountryId() == 1)
                .map(FirstLevelDomain::getDivision)
                .toList();
        this.canadianProvinces = domains
                .stream()
                .filter(i -> i.getCountryId() == 3)
                .map(FirstLevelDomain::getDivision)
                .toList();
        this.ukProvinces = domains
                .stream()
                .filter(i -> i.getCountryId() == 2)
                .map(FirstLevelDomain::getDivision)
                .toList();
        // populate combo box data with default to US
        this.countryComboBox.setItems(FXCollections.observableList(this.countries));
        this.countryComboBox.getSelectionModel().select(0);
        // set and show/hide readonly customer fields
        this.customerIdTxt.setEditable(false);
        if (!isEdit) {
            this.stateOrProvinceComboBox.setItems(FXCollections.observableList(this.states));
            this.stateOrProvinceComboBox.getSelectionModel().selectFirst();
            this.customerIdTxt.setVisible(false);
            this.customerIdLabel.setVisible(false);
        } else {
            // apply customer data to UI components
            this.customerScreenLabel.setText(resourceBundle.getString("editCustomerLabel"));
            this.customerIdTxt.setText(Integer.toString(customer.getCustomerId()));
            this.nameTxt.setText(customer.getCustomerName());
            this.postalCodeTxt.setText(customer.getPostalCode());
            this.addressTxt.setText(customer.getAddress());
            this.phoneTxt.setText(customer.getPhone());
            String domain = domains
                    .stream()
                    .filter(d -> d.getDivisionId() == customer.getDivisionId())
                    .findFirst()
                    .get()
                    .getDivision();
            if (customer.getDivisionId() >= 101) {
                countryComboBox.getSelectionModel().select(1);
                stateOrProvinceComboBox.setItems(FXCollections.observableList(this.ukProvinces));
                stateOrProvinceComboBox.getSelectionModel().select(domain);
            } else if (customer.getDivisionId() >= 60) {
                countryComboBox.getSelectionModel().select(2);
                stateOrProvinceComboBox.setItems(FXCollections.observableList(this.canadianProvinces));
                stateOrProvinceComboBox.getSelectionModel().select(domain);
            } else {
                countryComboBox.getSelectionModel().select(0);
                stateOrProvinceComboBox.setItems(FXCollections.observableList(this.states));
                stateOrProvinceComboBox.getSelectionModel().select(domain);
            }
        }
    }

    public void handleCountryChange(ActionEvent event) {
        String country = this.countryComboBox.getValue();
        // change the state/province options
        if (country.equals("UK"))
            this.stateOrProvinceComboBox.setItems(FXCollections.observableList(this.ukProvinces));
        else if (country.equals("Canada"))
            this.stateOrProvinceComboBox.setItems(FXCollections.observableList(this.canadianProvinces));
        else
            this.stateOrProvinceComboBox.setItems(FXCollections.observableList(this.states));
        // default to first in list
        this.stateOrProvinceComboBox.getSelectionModel().select(0);
    }

    /**
     * Handler for save button.
     */
    public void handleSave() {
        // validate the selections
        String message = "";
        // used this site for regex below https://www.baeldung.com/java-regex-validate-phone-numbers
        String phoneRegexPatterns
                = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
        try {
            if (!validateCustomerSelections())
                throw new Exception(resourceBundle.getString("invalidCustomerMessage"));
            if (!phoneTxt.getText().matches(phoneRegexPatterns))
                throw new InvalidObjectException(resourceBundle.getString("validPhoneNumberMessage"));

            // get division id
            int divisionId = domainRepo.getByName(stateOrProvinceComboBox.getValue());

            Customer newCustomer = new Customer();
            newCustomer.setCustomerName(nameTxt.getText());
            newCustomer.setPhone(phoneTxt.getText());
            newCustomer.setPostalCode(postalCodeTxt.getText());
            newCustomer.setAddress(addressTxt.getText());
            newCustomer.setDivisionId(divisionId);
            newCustomer.setLastUpdatedBy(this.user.getUserName());

            if (isEdit) {
                newCustomer.setCustomerId(customer.getCustomerId());
                newCustomer.setCreatedDate(customer.getCreatedDate());
                newCustomer.setCreatedBy(customer.getCreatedBy());
                customerService.update(newCustomer);
                message = resourceBundle.getString("editedCustomerMessage");
            } else {
                newCustomer.setCreatedBy(user.getUserName());
                newCustomer.setCreatedDate(ZonedDateTime.now(Clock.systemUTC()));
                customerService.create(newCustomer);
                message = resourceBundle.getString("savedCustomerMessage");
            }

            // close the stage
            nameTxt.getScene().getWindow().hide();
        } catch (Exception ex) {
            message = ex.getMessage();
        } finally {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText(message);
            alert.show();
        }
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
        // clear out selections
        this.nameTxt.setText("");
        this.phoneTxt.setText("");
        this.addressTxt.setText("");
        this.postalCodeTxt.setText("");
        // restore combobox default
        this.countryComboBox.getSelectionModel().select(0);
        this.stateOrProvinceComboBox.getSelectionModel().select(0);
        // close the stage
        nameTxt.setText("");
    }

    private boolean validateCustomerSelections() {
        boolean isValid = !this.nameTxt.getText().equals("");
        if (this.addressTxt.getText().equals(""))
            isValid = false;
        if (this.phoneTxt.getText().equals(""))
            isValid = false;
        if (this.postalCodeTxt.getText().equals(""))
            isValid = false;

        return isValid;
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

    public boolean isEdit() {
        return isEdit;
    }

    public void setEdit(boolean edit) {
        isEdit = edit;
    }
}

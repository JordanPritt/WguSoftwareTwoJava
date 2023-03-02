package softwaretwo.userInterface.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;
import softwaretwo.data.models.Country;
import softwaretwo.data.models.Customer;
import softwaretwo.data.models.FirstLevelDomain;
import softwaretwo.data.models.User;
import softwaretwo.data.repositories.CountriesRepository;
import softwaretwo.data.repositories.FirstLevelDomainRepository;
import softwaretwo.data.repositories.ICountriesRepository;
import softwaretwo.data.repositories.IFirstLevelDomainRepository;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddOrEditCustomerScreen implements Initializable {
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
    TextField streetTxt;
    @FXML
    TextField townOrCityTxt;
    @FXML
    TextField postalCodeTxt;
    @FXML
    TextField customerIdTxt;

    @FXML
    Label customerIdLabel;

    @FXML
    ComboBox<String> countryComboBox;
    @FXML
    ComboBox<String> stateOrProvinceComboBox;

    /**
     * Default Initializer method for controller.
     *
     * @param url            url to view.
     * @param resourceBundle provided resource bundle.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        IFirstLevelDomainRepository domainRepo = new FirstLevelDomainRepository();
        ICountriesRepository countryRepo = new CountriesRepository();
        this.domains = domainRepo.getDomains();
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
        this.stateOrProvinceComboBox.setItems(FXCollections.observableList(this.states));
        this.stateOrProvinceComboBox.getSelectionModel().select(0);
        this.countryComboBox.setItems(FXCollections.observableList(this.countries));
        this.countryComboBox.getSelectionModel().select(0);
        // set and show/hide readonly customer fields
        this.customerIdTxt.setEditable(false);
        if (customer == null) {
            this.customerIdTxt.setVisible(false);
            this.customerIdLabel.setVisible(false);
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
        // clear out selections
        this.nameTxt.setText("");
        this.phoneTxt.setText("");
        this.streetTxt.setText("");
        this.townOrCityTxt.setText("");
        this.postalCodeTxt.setText("");
        // restore combobox default
        this.countryComboBox.getSelectionModel().select(0);
        this.stateOrProvinceComboBox.getSelectionModel().select(0);
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

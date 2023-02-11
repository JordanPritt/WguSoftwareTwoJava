package softwaretwo.data.models;

import java.util.Date;

/**
 * A Customer model.
 */
public class Customer {
    private String customerName;
    private String address;
    private String postalCode;
    private String phone;
    private Date createdDate;
    private String createdBy;
    private Date lastUpdate;
    private String lastUpdatedBy;
    private int divisionId;
    private int customerId;

    /**
     * Empty constructor.
     */
    public Customer() {
    }

    /**
     * Default constructor.
     *
     * @param customerName  customer's name.
     * @param address       customer's address.
     * @param postalCode    customer's postal code
     * @param phone         customer's phone.
     * @param createdDate   customer's created date.
     * @param createdBy     customer's created by.
     * @param lastUpdate    customer's last update.
     * @param lastUpdatedBy customer's last updated by.
     * @param divisionId    customer's division identifier.
     * @param customerId    customer's identifier.
     */
    public Customer(String customerName, String address, String postalCode, String phone, Date createdDate, String createdBy, Date lastUpdate, String lastUpdatedBy, int divisionId, int customerId) {
        this.customerName = customerName;
        this.address = address;
        this.postalCode = postalCode;
        this.phone = phone;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.divisionId = divisionId;
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}

package softwaretwo.data.models;

public class Contact {
    private int contactId;
    private String contactName;
    private String contactEmail;

    /**
     * Default Constructor.
     *
     * @param contactId    A contact's identifier.
     * @param contactName  A contact's name.
     * @param contactEmail A contact's email.
     */
    public Contact(int contactId, String contactName, String contactEmail) {
        this.contactId = contactId;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
    }

    /**
     * Gets the contact's identifier.
     *
     * @return an int.
     */
    public int getContactId() {
        return contactId;
    }

    /**
     * Sets a contact's id.
     *
     * @param contactId the id.
     */
    public void setContactId(int contactId) {
        contactId = contactId;
    }

    /**
     * Gets a contact's name.
     *
     * @return A contact's name.
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * Sets a contact's name.
     *
     * @param contactName A contact's name.
     */
    public void setContactName(String contactName) {
        contactName = contactName;
    }

    /**
     * Gets a contact's email.
     *
     * @return A contact's email.
     */
    public String getContactEmail() {
        return contactEmail;
    }

    /**
     * Sets a contact's email.
     *
     * @param contactEmail a contact's email.
     */
    public void setContactEmail(String contactEmail) {
        contactEmail = contactEmail;
    }
}

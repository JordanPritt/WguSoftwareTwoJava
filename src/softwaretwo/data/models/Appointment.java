package softwaretwo.data.models;

import java.util.Date;

/**
 * An Appointment model.
 */
public class Appointment {
    private int id;
    private int customerId;
    private int userId;
    private int contactId;
    private String title;
    private String description;
    private String location;
    private String type;
    private Date start;
    private Date end;
    private Date createDate;
    private String createdBy;
    private Date lastUpdate;
    private String lastUpdatedBy;

    /**
     * Empty constructor.
     */
    public Appointment() {
    }

    /**
     * @param id            an appointment's id.
     * @param title         an appointment's title.
     * @param description   an appointment's description.
     * @param location      an appointment's location.
     * @param type          an appointment's type.
     * @param start         an appointment's start.
     * @param end           an appointment's end.
     * @param createDate    an appointment's created date.
     * @param createdBy     an appointment's created by
     * @param lastUpdate    an appointment's last update date.
     * @param lastUpdatedBy an appointment's last updated by.
     */
    public Appointment(int id, String title, String description, String location, String type, Date start, Date end, Date createDate, String createdBy, Date lastUpdate, String lastUpdatedBy) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.type = type;
        this.start = start;
        this.end = end;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return
     */
    public Date getStart() {
        return start;
    }

    /**
     * @param start
     */
    public void setStart(Date start) {
        this.start = start;
    }

    /**
     * @return
     */
    public Date getEnd() {
        return end;
    }

    /**
     * @param end
     */
    public void setEnd(Date end) {
        this.end = end;
    }

    /**
     * @return
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return
     */
    public Date getLastUpdate() {
        return lastUpdate;
    }

    /**
     * @param lastUpdate
     */
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /**
     * @return
     */
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    /**
     * @param lastUpdatedBy
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * @return
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * @return
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return
     */
    public int getContactId() {
        return contactId;
    }

    /**
     * @param contactId
     */
    public void setContactId(int contactId) {
        this.contactId = contactId;
    }
}

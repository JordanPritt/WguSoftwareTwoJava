package softwaretwo.data.models;

import java.util.Date;

/**
 * An Appointment model.
 */
public class Appointment {
    private int id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
}

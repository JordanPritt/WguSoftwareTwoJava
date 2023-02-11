package softwaretwo.data.models;

import java.util.Date;

/**
 * A User model.
 */
public class User {
    private int userId;
    private String userName;
    private String password;
    private Date createDate;
    private String createBy;
    private Date lastUpdate;
    private String lastUpdatedBy;

    /**
     * Empty constructor.
     */
    public User() {
    }

    /**
     * Default constructor.
     *
     * @param userId        a user's identifier.
     * @param userName      a user's username.
     * @param password      a user's password.
     * @param createDate    a user's created date.
     * @param createBy      a user's created by.
     * @param lastUpdate    a user's last update date.
     * @param lastUpdatedBy a user's who last updated by.
     */
    public User(int userId, String userName, String password, Date createDate, String createBy, Date lastUpdate, String lastUpdatedBy) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.createBy = createBy;
        this.createDate = createDate;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
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

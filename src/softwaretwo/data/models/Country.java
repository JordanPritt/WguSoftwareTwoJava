package softwaretwo.data.models;

import java.time.ZonedDateTime;

/**
 * A model class for the countries table.
 */
public class Country {
    private int countryId;
    private String country;
    private ZonedDateTime createDate;
    private String createdBy;
    private ZonedDateTime lastUpdate;
    private String lastUpdatedBy;

    /**
     * Default constructor
     *
     * @param countryId     a country id.
     * @param country       a country name.
     * @param createDate    created date.
     * @param createdBy     created by username.
     * @param lastUpdate    last updated date.
     * @param lastUpdatedBy last updated by date.
     */
    public Country(int countryId,
                   String country,
                   ZonedDateTime createDate,
                   String createdBy,
                   ZonedDateTime lastUpdate,
                   String lastUpdatedBy) {
        this.countryId = countryId;
        this.country = country;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * getter
     *
     * @return gets a country id.
     */
    public int getCountryId() {
        return countryId;
    }

    /**
     * setter
     *
     * @param countryId sets a country id.
     */
    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    /**
     * getter
     *
     * @return gets a country name string.
     */
    public String getCountry() {
        return country;
    }

    /**
     * setter
     *
     * @param country sets a country name string.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * getter
     *
     * @return gets a created date.
     */
    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    /**
     * setter
     *
     * @param createDate sets a created by date.
     */
    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    /**
     * getter
     *
     * @return gets a created by username string.
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * setter
     *
     * @param createdBy sets a created by username string.
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * getter
     *
     * @return gets a last updated date.
     */
    public ZonedDateTime getLastUpdate() {
        return lastUpdate;
    }

    /**
     * setter
     *
     * @param lastUpdate sets a last updated date.
     */
    public void setLastUpdate(ZonedDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /**
     * getter
     *
     * @return gets a last updated by username string.
     */
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    /**
     * setter
     *
     * @param lastUpdatedBy sets a last updated by username string.
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }
}

package softwaretwo.data.models;

/**
 * Model class for First Level Domain table.
 */
public class FirstLevelDomain {
    private int divisionId;
    private String division;
    private int countryId;

    /**
     * Default constructor
     *
     * @param divisionId a division id.
     * @param division   a division name.
     * @param countryId  a country id.
     */
    public FirstLevelDomain(int divisionId, String division, int countryId) {
        this.divisionId = divisionId;
        this.division = division;
        this.countryId = countryId;
    }

    /**
     * getter.
     *
     * @return int
     */
    public int getDivisionId() {
        return divisionId;
    }

    /**
     * setter
     *
     * @param divisionId division id to set.
     */
    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    /**
     * getter
     *
     * @return a division name string.
     */
    public String getDivision() {
        return division;
    }

    /**
     * setter
     *
     * @param division sets a division.
     */
    public void setDivision(String division) {
        this.division = division;
    }

    /**
     * getter
     *
     * @return a conutry id.
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
}

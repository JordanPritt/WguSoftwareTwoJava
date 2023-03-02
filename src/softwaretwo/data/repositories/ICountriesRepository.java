package softwaretwo.data.repositories;

import softwaretwo.data.models.Country;

import java.util.List;

/**
 * Public interface for a country repository.
 */
public interface ICountriesRepository {
    /**
     * Retrieves a list of counties.
     *
     * @return a list of country models.
     */
    List<Country> getAllCountries();
}

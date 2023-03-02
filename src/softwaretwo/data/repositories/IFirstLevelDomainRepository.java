package softwaretwo.data.repositories;

import softwaretwo.data.models.FirstLevelDomain;

import java.util.List;

/**
 * public interface for a First Level Domain repository.
 */
public interface IFirstLevelDomainRepository {
    /**
     * Retrieves all the domains.
     *
     * @return list of domains.
     */
    List<FirstLevelDomain> getDomains();
}

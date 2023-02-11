package softwaretwo.data.repositories;

import softwaretwo.data.models.User;

/**
 * An interface for a repository for User database interactions.
 */
public interface IUserRepository {
    /**
     * Retrieves a user by their sign-in credentials.
     *
     * @param userName a user's username.
     * @param password a user's password.
     * @return a user object.
     */
    User getSignInUser(String userName, String password);

    /**
     * Retrieves a user from the database.
     *
     * @param userId a user's id.
     * @return a user object.
     */
    User getUser(int userId);

    /**
     * Inserts a new user into the database.
     *
     * @param user a user to insert.
     * @return a boolean indicating pass or fail.
     */
    boolean insertUser(User user);

    /**
     * Updates an existing user in the database.
     *
     * @param user the updated user.
     * @return a boolean indicating pass or fail.
     */
    boolean updateUser(User user);

    /**
     * Deletes a user from the database.
     *
     * @param userId a user's id.
     * @return a boolean indicating pass or fail.
     */
    boolean deleteUser(int userId);
}

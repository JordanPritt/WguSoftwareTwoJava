package softwaretwo.services;

import softwaretwo.data.models.User;
import softwaretwo.data.repositories.UserRepo;

/**
 * A service for managing users.
 */
public class UserService {
    private final UserRepo userRepo = new UserRepo();

    /**
     * Validate a user's credentials for logging in.
     *
     * @param userName a user's username.
     * @param password a user's password.
     * @return a User object if sign-in i successful.
     */
    public User validateUserCredentials(String userName, String password) {
        return userRepo.getSignInUser(userName, password);
    }
}

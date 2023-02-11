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
     * @return a boolean indicating pass or fail.
     */
    public boolean validateUserCredentials(String userName, String password) {
        User signedInUser = userRepo.getSignInUser(userName, password);
        return signedInUser.getUserId() != 0; // 0 means the user doesn't exist
    }
}

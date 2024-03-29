package softwaretwo.services;

import softwaretwo.data.models.User;
import softwaretwo.data.repositories.UserRepository;

/**
 * A service for managing users.
 */
public class UserService {
    private final UserRepository userRepository = new UserRepository();

    private User currentUser;

    /**
     * Validate a user's credentials for logging in.
     *
     * @param userName a user's username.
     * @param password a user's password.
     * @return a User object if sign-in is successful.
     */
    public User validateUserCredentials(String userName, String password) {
        return userRepository.getSignInUser(userName, password);
    }

    /**
     * Current User Getter.
     *
     * @return current User object.
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Current User Setter.
     *
     * @param currentUser the user to set.
     */
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}

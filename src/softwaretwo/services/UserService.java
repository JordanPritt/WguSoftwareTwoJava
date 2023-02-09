package softwaretwo.services;

import softwaretwo.data.models.User;
import softwaretwo.data.repositories.UserRepo;

public class UserService {
    private final UserRepo userRepo = new UserRepo();
    public boolean validateUserCredentials(String userName, String password) {
        User signedInUser = userRepo.getSignInUser(userName, password);
        return signedInUser.getUserId() != 0; // 0 means the user doesn't exist
    }
}

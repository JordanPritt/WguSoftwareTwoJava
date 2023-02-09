package services;

import data.models.User;
import data.repositories.UserRepo;

public class UserService {
    private final UserRepo userRepo = new UserRepo();
    public boolean validateUserCredentials(String userName, String password) {
        User signedInUser = userRepo.getSignInUser(userName, password);
        return signedInUser.getUserId() != 0; // 0 means the user doesn't exist
    }
}

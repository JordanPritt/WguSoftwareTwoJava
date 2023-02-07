package tests;

import data.models.User;
import data.repositories.IUserRepository;
import data.repositories.UserRepo;

public class RepoTests {
    public static boolean getSignInUserTest() {
        IUserRepository userRepo = new UserRepo();
        User user = userRepo.getSignInUser("test", "test");
        if (user.getUserId() == 1)
            return true;
        return false;
    }
}

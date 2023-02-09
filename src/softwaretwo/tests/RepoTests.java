package softwaretwo.tests;

import softwaretwo.data.models.User;
import softwaretwo.data.repositories.IUserRepository;
import softwaretwo.data.repositories.UserRepo;

public class RepoTests {
    public static boolean getSignInUserTest() {
        IUserRepository userRepo = new UserRepo();
        User user = userRepo.getSignInUser("test", "test");
        if (user.getUserId() == 1)
            return true;
        return false;
    }
}

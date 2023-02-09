package softwaretwo.data.repositories;

import softwaretwo.data.models.User;

public interface IUserRepository {
    User getSignInUser(String userName, String password);
}

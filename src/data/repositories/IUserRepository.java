package data.repositories;

import data.models.User;

public interface IUserRepository {
    User getSignInUser(String userName, String password);
}

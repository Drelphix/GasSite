package by.instasite.database.user;

import java.util.List;

public interface UserService {
    User getUserByUsername(String user);

    void saveUser(User user);

    void updateUser(String user, String password, String email, String country);

    void deleteUser(String username);

    List<User> findAll();
}
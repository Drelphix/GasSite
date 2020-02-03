package by.instasite.database.user;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.transaction.Transactional;
import java.util.List;

@EnableTransactionManagement
public interface UserService {
    @Transactional
    User getUserByUsername(String user);

    @Transactional
    User getUserByEmail(String email);

    @Transactional
    User getUserById(int id);

    @Transactional
    void saveUser(User user);

    @Transactional
    void updateUser(String user, String password, String email, String country);

    @Transactional
    void deleteUser(String username);

    @Transactional
    List<User> findAll();
}
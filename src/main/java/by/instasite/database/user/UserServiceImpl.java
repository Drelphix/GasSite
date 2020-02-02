package by.instasite.database.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setUserRepository(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User getUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public User getUserById(int id) {
        return repository.getOne(id);
    }

    @Override
    public void updateUser(String username, String password, String email, String country) {
        User updated = repository.findByUsername(username);
        updated.setPassword(passwordEncoder.encode(password));
        updated.setEmail(email);
        updated.setCountry(country);
        repository.save(updated);
    }

    @Override
    public void deleteUser(String username) {
        User delete = repository.findByUsername(username);
        repository.delete(delete);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
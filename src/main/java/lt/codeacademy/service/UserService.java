package lt.codeacademy.service;

import lt.codeacademy.model.User;

public interface UserService {
    User save(User user);

    Iterable<User> getAllUsers();

    User getUserById(long id);

    User getUserByName(String name);

    User updateUser(User user, long id);

}

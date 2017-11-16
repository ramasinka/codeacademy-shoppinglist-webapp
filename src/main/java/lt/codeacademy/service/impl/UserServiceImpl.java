package lt.codeacademy.service.impl;


import lt.codeacademy.dao.UserRepository;
import lt.codeacademy.dto.UserDto;
import lt.codeacademy.dto_service.UserDtoService;
import lt.codeacademy.model.User;
import lt.codeacademy.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private PasswordEncoder passwordEncoder;

    public boolean userExistsByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        if (user == null) {
            throw new RuntimeException("User with email:" + email + " does not exists");
        }
        return true;
    }

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public User save(User user) {
        if (user.getPassword() == null) {
            user.setPassword("angularTest");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(long id) {
        return userRepository.findOne(id);
    }

    public User getUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    public User updateUser(User user, long id) {
        return userRepository.updateUser(id, user.getEmail(), user.getName());
    }
}

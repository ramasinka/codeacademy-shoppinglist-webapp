package lt.codeacademy.service;


import lt.codeacademy.dao.UserRepository;
import lt.codeacademy.model.User;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

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
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}

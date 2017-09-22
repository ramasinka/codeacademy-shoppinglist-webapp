package lt.codeacademy.service;


import lt.codeacademy.dao.UserRepository;
import lt.codeacademy.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    UserRepository userRepository;

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
}

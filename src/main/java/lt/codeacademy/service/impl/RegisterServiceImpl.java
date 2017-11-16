package lt.codeacademy.service.impl;

import lt.codeacademy.dao.UserRepository;
import lt.codeacademy.model.Role;
import lt.codeacademy.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterServiceImpl {

    @Resource
    private UserRepository userRepository;

    @Resource
    private RoleServiceImpl roleService;

    public User registerUser(User user) {
        if (userRepository.findUserByName(user.getName()) != null) {
            throw new RuntimeException("User exists with name: " + user.getName() + ". Please try again!");
        } else {
            List<Role> roleList = new ArrayList<>();
            Role userRole = roleService.getRoleByName("USER");
            roleList.add(userRole);
            user.setRoles(roleList);
            return userRepository.save(user);
        }
    }
}

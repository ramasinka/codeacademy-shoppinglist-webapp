package lt.codeacademy.controllers;

import lt.codeacademy.dao.UserRepository;
import lt.codeacademy.dto.UserDto;
import lt.codeacademy.dto_service.UserDtoService;
import lt.codeacademy.model.User;
import lt.codeacademy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserService userService;

    @Resource
    private UserDtoService userDtoService;

    @RequestMapping(value = "/users", method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public List<User> getAlLUsers() {
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(user -> userList.add(user));
        return userList;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST,
            produces = "application/json")
    @ResponseBody
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(value = "/user/{userName}", method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public UserDto getUser(@PathVariable String userName) {
        User user = userRepository.findUserByName(userName);
        return userDtoService.convertToUserDto(user);
    }


}

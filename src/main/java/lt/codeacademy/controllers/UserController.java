package lt.codeacademy.controllers;

import lt.codeacademy.dao.UserRepository;
import lt.codeacademy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

    @RequestMapping(value = "/users", method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public List<User> getAlLUsers() {
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(user -> userList.add(user));
        return userList;
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public User getUserById(@PathVariable long userId) {
        return userRepository.findOne(userId);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST,
            produces = "application/json")
    @ResponseBody
    public User createUser(@RequestParam String name,
                           @RequestParam String email,
                           @RequestParam String password) {
        return userRepository.save(new User(name, password, email));
    }

    @RequestMapping(value = "/user/{userName}/{userPassword}", method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public User getUser(@PathVariable String userName,
                        @PathVariable String userPassword) {
        return userRepository.findUserByNameAndPassword(userName, userPassword);
    }

    @RequestMapping(value = "/login/{name}/{password}", method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public User checkUser(@PathVariable String name,
                          @PathVariable String password) {
        return userRepository.findUserByNameAndPassword(name, password);
    }
}

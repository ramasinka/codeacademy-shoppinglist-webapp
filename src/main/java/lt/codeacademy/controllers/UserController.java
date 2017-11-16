package lt.codeacademy.controllers;

import lt.codeacademy.dto.UserDto;
import lt.codeacademy.dto_service.UserDtoService;
import lt.codeacademy.model.User;
import lt.codeacademy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private UserDtoService userDtoService;

    @RequestMapping(value = "/users", method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public List<UserDto> getAlLUsers() {
        Iterable<User> users = userService.getAllUsers();
        return userDtoService.convertToUserDtoList(users);
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST,
            produces = "application/json")
    @ResponseBody
    public void createUser(@RequestBody User user) {
        userService.save(user);
    }


    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public UserDto getUserById(@PathVariable long id) {
        User user = userService.getUserById(id);
        return userDtoService.convertToUserDto(user);
    }

    @RequestMapping(value = "/userByName/{name}", method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public UserDto getUserByName(@PathVariable String name) {
        User user = userService.getUserByName(name);
        return userDtoService.convertToUserDto(user);
    }

    @RequestMapping(value = "/user/update/{id}", method = RequestMethod.POST,
            produces = "application/json")
    @ResponseBody
    public UserDto updateUser(@RequestBody User user,
                              @PathVariable long id) {

        User updatedUser = userService.updateUser(user, id);
        return userDtoService.convertToUserDto(updatedUser);
    }
}

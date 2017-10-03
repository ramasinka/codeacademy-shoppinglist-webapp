package lt.codeacademy.controllers;

import lt.codeacademy.dao.UserRepository;
import lt.codeacademy.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class LoginController {

    @Resource
    private UserRepository userRepository;

    @RequestMapping(value = "/login/{name}/{password}", method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public User checkUser(@PathVariable String name,
                          @PathVariable String password) {
        return userRepository.findUserByNameAndPassword(name, password);
    }
}

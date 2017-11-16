package lt.codeacademy.controllers;

import lt.codeacademy.model.User;
import lt.codeacademy.service.impl.RegisterServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class RegisterController {

    public static final String APPLICATION_JSON = "application/json";

    @Resource
    private RegisterServiceImpl registerServiceImpl;

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST,
            produces = APPLICATION_JSON, consumes = APPLICATION_JSON)
    @ResponseStatus(value = HttpStatus.OK)
    public void registerUser(@RequestBody User user) {
        registerServiceImpl.registerUser(user);
    }
}

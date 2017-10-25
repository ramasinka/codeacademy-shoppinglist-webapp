package lt.codeacademy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class TokenController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public void getAuthorizationCode(HttpServletRequest request, HttpServletResponse response){
        System.out.println("test login");

    }
}

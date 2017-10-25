package lt.codeacademy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WebController {

    @GetMapping("/")
    public String indexPage(HttpServletRequest request) {
        if (request.getSession().getAttribute("userid") != null) {
            return "main";
        }
        return "index";
    }

//    @GetMapping("/login")
//    public String loginPage() {
//        return "login";
//    }

    @GetMapping("/main")
    public String mainPage() {
        return "main";
    }

    @GetMapping("/lists")
    public String shoppingListPage() {
        return "shoppinglist";
    }

    @GetMapping("/shareHistory")
    public String shareHistoryPage() {
        return "sharehistory";
    }

    @GetMapping("/registration")
    public String registerPage() {
        return "register";
    }
}

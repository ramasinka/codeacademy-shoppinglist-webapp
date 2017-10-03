package lt.codeacademy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/test")
    public String test() {
        return "login";
    }


    @GetMapping("/login")
    public String loginPage() {
        return "index";
    }

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
}

package lt.codeacademy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String indexPage() {
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

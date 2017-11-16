package lt.codeacademy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class WebController {

    @GetMapping("/sigIn")
    public String indexPage(HttpServletRequest request) {
        if (request.getSession().getAttribute("userid") != null) {
            return "main";
        }
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

    @GetMapping("/registration")
    public String registerPage() {
        return "register";
    }
}

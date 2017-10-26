package lt.codeacademy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class TokenController {

    @GetMapping(value = "/tokenas")
    public void getAuthorizationCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String code = request.getParameter("code");
        System.out.println(code);
        response.addHeader("code", code);
        response.setHeader("code", code);
        response.sendRedirect("/tokenas/generate?code=" + code);
//        response.sendRedirect("http://localhost:8082/auth/oauth/token?client_id=ClientId&client_secret=secret&grant_type=authorization_code&code=" + code + "&redirect_uri=http://localhost:8084/main");
    }
}

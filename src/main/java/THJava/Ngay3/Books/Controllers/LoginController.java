package THJava.Ngay3.Books.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage() {
    	System.out.println("login");
        return "auth/login";
    }
}

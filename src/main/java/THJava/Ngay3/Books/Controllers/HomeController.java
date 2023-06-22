package THJava.Ngay3.Books.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import THJava.Ngay3.Books.Models.User;
import THJava.Ngay3.Books.Repositories.UserRepository;



@Controller
public class HomeController {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/")
	public String Home() {
		return "home/index";
	}
	
	
}

package github.gustavoaraujopires.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeViewController {

    @GetMapping("/home")
    public String home(Authentication authentication, Model model){
        model.addAttribute("home",authentication.getName());
        return "home";
    }
}

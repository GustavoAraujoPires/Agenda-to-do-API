package github.gustavoaraujopires.demo.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Configuration
public class HomeViewController {

    @GetMapping("{home}")
    public String home(Authentication authentication, Model model){
        model.addAttribute("home",authentication.getName());
        return "home";
    }
}

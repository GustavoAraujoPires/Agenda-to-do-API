package github.gustavoaraujopires.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebViewController {

    @GetMapping("{login}")
    public String paginaLogin(){
        return "login";
    }

}

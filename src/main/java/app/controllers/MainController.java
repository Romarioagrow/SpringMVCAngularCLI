package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainMethod() {
        System.out.println("INDEX GET");
        return "index.html";
    }

}

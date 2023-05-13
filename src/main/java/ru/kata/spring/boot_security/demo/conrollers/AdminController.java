package ru.kata.spring.boot_security.demo.conrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin")
    public String goToAdmin() {
        return "admin";

    }
}

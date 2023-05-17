package ru.kata.spring.boot_security.demo.conrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.RegistrationService;


import javax.validation.Valid;


@Controller
public class AuthController {

    private final RegistrationService registrationService;


    @Autowired
    public AuthController(RegistrationService registrationService) {
        this.registrationService = registrationService;

    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }


    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") User user) {
        return "registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("user") User user) {

        registrationService.register(user);

        return "redirect:/login";
    }
}

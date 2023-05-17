package ru.kata.spring.boot_security.demo.conrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.services.RolesService;
import ru.kata.spring.boot_security.demo.services.UserService;

import javax.validation.Valid;

@Controller
public class AdminController {
    private final RolesService rolesService;
    private final UserService userService;
    private final RoleRepository roleRepository;


    @Autowired
    public AdminController(RolesService rolesService, UserService userService, RoleRepository roleRepository) {
        this.rolesService = rolesService;
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/admin/user")
    public String index(Model model) {
        model.addAttribute("users", userService.index());
        model.addAttribute("allRoles", rolesService.getRoles());

        return "admin";
    }

    @DeleteMapping("/admin/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:user";
    }

    @PatchMapping("/admin/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:user";
    }


    @PostMapping("/admin/user")
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin/user";
    }

}
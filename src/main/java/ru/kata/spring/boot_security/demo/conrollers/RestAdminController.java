package ru.kata.spring.boot_security.demo.conrollers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.security.UsersDetails;
import org.springframework.http.ResponseEntity;
import ru.kata.spring.boot_security.demo.services.RolesService;
import ru.kata.spring.boot_security.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//url любой команды содержит "api"
@RestController
@RequestMapping("/api")
public class RestAdminController {
    private final RolesService rolesService;
    private final UserService userService;
    private final RoleRepository roleRepository;
    @Autowired
    public RestAdminController(RolesService rolesService, UserService userService, RoleRepository roleRepository) {
        this.rolesService = rolesService;
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @GetMapping ("/admin")
    public List<User> getAll() {
        List<User> allUsers = userService.index();
        return ResponseEntity.ok(allUsers).getBody();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getOne(@PathVariable("id") Long id) {
        User user = userService.show(Math.toIntExact(id));
        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "/users")
    public ResponseEntity<User> create(@RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping ("/users")
    public User update(@RequestBody User user) {
        userService.update(user);
        return ResponseEntity.ok(user).getBody();
    }

/*
    @PatchMapping(value = "/users/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody User user, @PathVariable("id") Long id, Model model) {
        userService.updateUserById(id, user, model);
    }
*/

    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "User with id = " + id + " was deleted";
    }
    @GetMapping("/roles")
    public List<Role> allRoles() {
        List<Role> roleList = rolesService.getRolesList();
        System.out.println(roleList);
        return roleList;
    }

}

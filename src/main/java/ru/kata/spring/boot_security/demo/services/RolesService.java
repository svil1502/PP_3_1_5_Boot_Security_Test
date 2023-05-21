package ru.kata.spring.boot_security.demo.services;


import ru.kata.spring.boot_security.demo.models.Role;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RolesService {
    Set<Role> getRoles();

    List<Role> getRolesList();

}

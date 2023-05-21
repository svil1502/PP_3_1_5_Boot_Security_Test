package ru.kata.spring.boot_security.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;


@Component
public class RolesServiceImp implements RolesService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Autowired
    public RolesServiceImp(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Set<Role> getRoles() {
        List<Role> list = roleRepository.findAll();
        return new HashSet<>(list);
    }
    @Override
    public List<Role> getRolesList() {
        List<Role> list = roleRepository.findAll();
        return list;
    }

}

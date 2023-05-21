package ru.kata.spring.boot_security.demo.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import ru.kata.spring.boot_security.demo.models.Role;

public class RoleGrantedAuthority implements GrantedAuthority {


    private final Role role;

    public RoleGrantedAuthority(Role role) {
        this.role = role;
    }

    @JsonIgnore
    @Override
    public String getAuthority() {
        return role.getName();
    }
}

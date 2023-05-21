package ru.kata.spring.boot_security.demo.security;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.security.RoleGrantedAuthority;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


public class UsersDetails implements UserDetails {
    private final User user;

    public UsersDetails(User user) {
        this.user = user;
    }
    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<Role> set = user.getRoles();
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : set) {
            grantedAuthorities.add(new RoleGrantedAuthority(role));
        }
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @JsonIgnore
    @Override
    public String getUsername() {
        return this.user.getEmail();
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

    public User getUser() {
        return this.user;
    }

    public String rolesToString() {
        Set<Role> roles = user.getRoles();
        String role = "";
        for (Role r : roles)
            role = role + " " + r.getName();
        return role;
    }


}
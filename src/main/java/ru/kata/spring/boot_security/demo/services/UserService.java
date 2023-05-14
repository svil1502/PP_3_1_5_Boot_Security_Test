package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {

    List<User> index();
    User show(int id);
    User showOne();
    void delete(int id);
    void update(User user);

    void save(User user);
}

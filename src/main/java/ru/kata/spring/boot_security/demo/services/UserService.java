package ru.kata.spring.boot_security.demo.services;

import org.springframework.ui.Model;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> index();

    User show(int id);

    User showOne();

    void delete(int id);

    void update(User user);

    void save(User user);

    Optional<User> findUserByEmail(String email);
}

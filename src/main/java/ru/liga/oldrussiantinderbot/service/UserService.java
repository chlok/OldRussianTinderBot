package ru.liga.oldrussiantinderbot.service;

import ru.liga.oldrussiantinderbot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUser(Long id);

    void saveUser(User user);

    void deleteUser(Long id);
}

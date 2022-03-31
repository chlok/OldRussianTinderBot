package ru.liga.oldrussiantinderbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.liga.oldrussiantinderbot.model.User;
import ru.liga.oldrussiantinderbot.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRESTController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllEmployees() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @PostMapping("/users")
    public User addNewUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }
    @PutMapping("/users")
    public User updateUser(@RequestBody User user){
        userService.saveUser(user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id) {
        User user = userService.getUser(id);
        userService.deleteUser(user.getId());
        return "User with ID = " + id + " was deleted";
    }

}
